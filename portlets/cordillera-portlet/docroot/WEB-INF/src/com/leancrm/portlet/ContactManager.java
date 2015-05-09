package com.leancrm.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.leancrm.portlet.utils.CRMJsonFormat;
import com.leancrm.portlet.utils.CRMParamUtils;
import com.leancrm.portlet.utils.CRMSuccessKey;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.utils.ContactInfo;
import com.leancrm.portlet.utils.ContactManagerUtils;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * All unexpected errors redirect to home page of the Contact Manage.
 * Portlet implementation class ContactManager
 */
public class ContactManager extends MVCPortlet {

	private Logger logger = Logger.getLogger(ContactManager.class);
	
	/**
	 * Dado el ID de un contacto obtiene todo su informacion de contacto para luego ser recargada en un formulario
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void showEditContact(ActionRequest actionRequest, ActionResponse actionResponse) {
		String contactIdParam = ParamUtil.getString(actionRequest, "contactId");
		
		try {
			Long contactId = ValidationsUtil.existContact(contactIdParam);
			
			if (contactId != null) {
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
				
				ContactInfo contactInfo = ContactManagerUtils.getContactInfo(contactId, addressBookUserList.get(0).getAddressBookId());
				
				actionRequest.setAttribute("contactId", contactInfo.getContactId());
				actionRequest.setAttribute("contactFullName", contactInfo.getFullName());
				actionRequest.setAttribute("enterpriseId", contactInfo.getEnterpriseId());
				actionRequest.setAttribute("enterpriseName", contactInfo.getEnterpriseName());
			} else {
				SessionErrors.add(actionRequest, CRMErrorKey.INVALID_CONTACT_PARAM);
				logger.warn("Tried to edit contact but contact doesnt exist. Contact Id: " + contactIdParam);
			}
			
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/contactFormFlow1.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to edit contact. Contact Id: " + contactIdParam, e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");			
		}
	}
	
	public void showEditEnterprise(ActionRequest actionRequest, ActionResponse actionResponse) {
		String enterpriseIdParam = ParamUtil.getString(actionRequest, "enterpriseId");
		String contactIdParam = ParamUtil.getString(actionRequest, "contactId");
		
		try {
			Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
			if (enterpriseId != null) {
				Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(enterpriseId);
				
				actionRequest.setAttribute("enterpriseId", enterprise.getEnterpriseId());
				actionRequest.setAttribute("isPrivate", CRMParamUtils.getCheckboxValue(enterprise.getIsPrivate()));
				actionRequest.setAttribute("enterpriseName", enterprise.getName());
				actionRequest.setAttribute("taxid", enterprise.getTaxid());
				actionRequest.setAttribute("description", enterprise.getDescription());
				actionRequest.setAttribute("email", enterprise.getEmail());
				actionRequest.setAttribute("insustryId", enterprise.getIndustry());
				
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				List<Address> addressList = AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(), Enterprise.class.getName(), enterpriseId);
				
				if (addressList != null && !addressList.isEmpty()) {
					actionRequest.setAttribute("countryId", addressList.get(0).getCountry().getCountryId());
					actionRequest.setAttribute("street1", addressList.get(0).getStreet1());
					actionRequest.setAttribute("street2", addressList.get(0).getStreet2());
					actionRequest.setAttribute("street3", addressList.get(0).getStreet3());
					actionRequest.setAttribute("zip", addressList.get(0).getZip());
					actionRequest.setAttribute("city", addressList.get(0).getCity());
				}
				
				actionRequest.setAttribute("contactId", contactIdParam);
				
				actionResponse.setRenderParameter("jspPage", "/html/contactmanager/enterpriseForm.jsp");
			} else {
				SessionErrors.add(actionRequest, CRMErrorKey.INVALID_ENTERPRISE_PARAM);
				logger.warn("Tried to edit enterprise but enterprise doesnt exist. Enterprise id: " + enterpriseIdParam);
				actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
			}
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to show edit enterprise. Enterprise Id:" + enterpriseIdParam + ", Contact Id:" + contactIdParam, e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to show edit enterprise. Enterprise Id:" + enterpriseIdParam + ", Contact Id:" + contactIdParam, e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		}
	}
	
	public void getEnterprises(ActionRequest actionRequest, ActionResponse actionResponse) {
		StringBuilder json = new StringBuilder();
		try {
		    
			json.append(CRMJsonFormat.getEnterpriseListAsJson(EnterpriseLocalServiceUtil.getAll()));
			
		} catch (Exception e) {
			json = new StringBuilder();
			json.append(CRMJsonFormat.generateJsonError(new String[] {"Unexpected error when try to get enterprises from report manager.", e.getMessage()}));
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
		
		CRMJsonFormat.jsonResponse(actionResponse, json.toString());
	}
	
	/**
	 * Dado el id de una Empresa retorna el TaxId, Country e informacion de si otro collega ya lo tiene en su address book.
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void showEnterpriseDetail(ActionRequest actionRequest, ActionResponse actionResponse) {
		String enterpriseIdParam = ParamUtil.getString(actionRequest, "enterpriseId");
		StringBuilder json = new StringBuilder();
		try {
			Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
			if (enterpriseId != null) {
				
				try {
					
					User user = PortalUtil.getUser(actionRequest);
					
					actionRequest.setAttribute("isInColleage", false);
					for (ContactInfo contactInfo : ContactManagerUtils.getColleaguesContacts(user.getUserId())) {
						if (Long.parseLong(contactInfo.getEnterpriseId()) == enterpriseId) {
							actionRequest.setAttribute("isInColleage", true);
							break;
						}
					}
				     
					Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(enterpriseId);
					
					json.append("{");
					json.append(CRMJsonFormat.getEnterpriseDetailAsJson(enterprise));
					json.append("}");
					
				} catch (Exception e) {
					json = new StringBuilder();
					json.append(CRMJsonFormat.generateJsonError(new String[] {"Unexpected error when try to get enterprises from report manager.", e.getMessage()}));
					logger.error("Unexpected error when try to get enterprises from report manager.", e);
				}
			} else {
				json = new StringBuilder();
				json.append(CRMJsonFormat.generateJsonError(new String[] {"Tried to get enterprise detail but enterprise doesnt exist. Enterprise id: " + enterpriseIdParam}));
				logger.warn("Tried to get enterprise detail but enterprise doesnt exist. Enterprise id: " + enterpriseIdParam);
			}
		} catch (Exception e) {
			json.append(CRMJsonFormat.generateJsonError(new String[] {"Unexpected error when try to get enterprise detail. Enterprise Id:" + enterpriseIdParam, e.getMessage()}));
			logger.error("Unexpected error when try to get enterprise detail. Enterprise Id:" + enterpriseIdParam, e);
		}
		
		CRMJsonFormat.jsonResponse(actionResponse, json.toString());
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public Enterprise updateEnterprise(ActionRequest actionRequest, ActionResponse actionResponse)  {
		String enterpriseIdParam = ParamUtil.getString(actionRequest, Parameters.ENTERPRISE_ID.getName());
		
		try {
			boolean isPrivate = ParamUtil.getBoolean(actionRequest, Parameters.IS_PRIVATE.getName());
			String name = ParamUtil.getString(actionRequest, Parameters.ENTERPRISE_NAME.getName());
			name = isPrivate && ValidationsUtil.isEmpty(name) ? "Private" : name;
			String taxId = isPrivate ? null : ParamUtil.getString(actionRequest, Parameters.TAX_ID.getName());
			String countryId = ParamUtil.getString(actionRequest, Parameters.COUNTRY_ID.getName());
			String description = ParamUtil.getString(actionRequest, Parameters.DESCRIPTION.getName());
			String email = ParamUtil.getString(actionRequest, Parameters.ENTERPRISE_EMAIL.getName());
			String industry = ParamUtil.getString(actionRequest, Parameters.INDUSTRY.getName());
			String street1 = ParamUtil.getString(actionRequest, Parameters.STREET1.getName());
			String street2 = ParamUtil.getString(actionRequest, Parameters.STREET2.getName());
			String street3 = ParamUtil.getString(actionRequest, Parameters.STREET3.getName());
			String zipCode = ParamUtil.getString(actionRequest, Parameters.ZIP.getName());
			String city = ParamUtil.getString(actionRequest, Parameters.CITY.getName());
			
			List<String> errorList = new ArrayList<String>();
			if (ValidationsUtil.validateEnterpriseRequest(name, taxId, countryId, description, email, industry, street1, street2, street3, zipCode, city, isPrivate, errorList)) {
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				Enterprise enterprise;
				Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
				if (enterpriseId != null) {
					enterprise = EnterpriseLocalServiceUtil.updateEnterprise(enterpriseId, themeDisplay.getCompanyId(), themeDisplay.getUserId(), name, taxId, countryId, description, email, industry, street1, street2, street3, zipCode, city, isPrivate);
				} else {
					enterprise = EnterpriseLocalServiceUtil.addEnterprise(themeDisplay.getCompanyId(), themeDisplay.getUserId(), name, taxId, countryId, description, email, industry, street1, street2, street3, zipCode, city, isPrivate);
				}
				
				SessionMessages.add(actionRequest, CRMSuccessKey.ENTERPRISE_SAVED_SUCCESS);
			    
				return enterprise;
			} else {
				addErrors(actionRequest, errorList);
				CRMParamUtils.copyRequestParameters(actionRequest, Parameters.ENTERPRISE_ID.getName(), Parameters.CONTACT_ID.getName(), Parameters.IS_PRIVATE.getName(),
						Parameters.ENTERPRISE_NAME.getName(), Parameters.TAX_ID.getName(), Parameters.COUNTRY_ID.getName(), Parameters.DESCRIPTION.getName(),
						Parameters.EMAIL.getName(), Parameters.INDUSTRY.getName(), Parameters.STREET1.getName(), Parameters.STREET2.getName(), Parameters.STREET3.getName(),
						Parameters.ZIP.getName(), Parameters.CITY.getName());
			}
			
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to save enterprise.", e);
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to save enterprise.", e);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to save enterprise.", e);
		}
		
		return null;
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void selectEnterprise(ActionRequest actionRequest, ActionResponse actionResponse)  {
		String contactIdParam = ParamUtil.getString(actionRequest, "contactId");
		String enterpriseIdParam = ParamUtil.getString(actionRequest, "enterpriseId");
		
		try {
			Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
			
			if (enterpriseId != null) {
				
				Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(enterpriseId);
				
				actionRequest.setAttribute("enterpriseId", enterprise.getEnterpriseId());
				actionRequest.setAttribute("enterpriseName", enterprise.getName());
				
				Long contactId = ValidationsUtil.existContact(contactIdParam);
				if (contactId != null) {
					ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					
					List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
					
					ContactInfo contactInfo = ContactManagerUtils.getContactInfo(contactId, addressBookUserList.get(0).getAddressBookId());
					
					actionRequest.setAttribute("contactId", contactInfo.getContactId());
					actionRequest.setAttribute("fullName", contactInfo.getFullName());
					actionRequest.setAttribute("cellPhone", contactInfo.getCellPhone());
					actionRequest.setAttribute("cellPhoneExt", contactInfo.getCellPhoneExt());
					actionRequest.setAttribute("skype", contactInfo.getSkype());
					actionRequest.setAttribute("email", contactInfo.getEmail());
					actionRequest.setAttribute("position", contactInfo.getPosition());
					actionRequest.setAttribute("phone", contactInfo.getPhone());
					actionRequest.setAttribute("phoneExt", contactInfo.getPhoneExt());
					actionRequest.setAttribute("personalEmail", contactInfo.getPersonalEmail());
				}
				
				actionResponse.setRenderParameter("jspPage", "/html/contactmanager/contactFormFlow2.jsp");
			} else {
				SessionErrors.add(actionRequest, CRMErrorKey.INVALID_ENTERPRISE_PARAM);
				logger.warn("Tried to show contact form after select an enterprise but the enterprise doesnt exist. Enterprise id: " + enterpriseIdParam);
				actionResponse.setRenderParameter("jspPage", "/html/contactmanager/contactFormFlow1.jsp");
			}
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to show contact form.", e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to show contact form.", e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		}
	}
	
	private enum Parameters {
		
		CONTACT_ID("contactId"),
		ENTERPRISE_ID("enterpriseId"),
		IS_PRIVATE("isPrivate"),
		ENTERPRISE_NAME("enterpriseName"),
		TAX_ID("taxid"),
		COUNTRY_ID("countryId"),
		DESCRIPTION("description"),
		ENTERPRISE_EMAIL("enterpriseEmail"),
		EMAIL("email"),
		INDUSTRY("industryId"),
		STREET1("street1"),
		STREET2("street2"),
		STREET3("street3"),
		ZIP("zip"),
		CITY("city"),
		CONTACT_FULL_NAME("fullName"),
		CELL_PHONE("cellPhone"),
		CELL_PHONE_EXT("cellPhoneExt"),
		PHONE("phone"),
		PHONE_EXT("phoneExt"),
		SKYPE("skype"),
		POSITION("position"),
		PERSONAL_EMAIL("personalEmail")
		;
		
		private String name;
		
		private Parameters(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateContactInfo(ActionRequest actionRequest, ActionResponse actionResponse)  {
		
		Enterprise enterprise = updateEnterprise(actionRequest, actionResponse);
		
		String contactIdParam = ParamUtil.getString(actionRequest, Parameters.CONTACT_ID.getName());
		String fullName = ParamUtil.getString(actionRequest, Parameters.CONTACT_FULL_NAME.getName());
		String cellPhone = ParamUtil.getString(actionRequest, Parameters.CELL_PHONE.getName());
		String cellPhoneExt = ParamUtil.getString(actionRequest, Parameters.CELL_PHONE_EXT.getName());
		String skype = ParamUtil.getString(actionRequest, Parameters.SKYPE.getName());
		String workEmail = ParamUtil.getString(actionRequest, Parameters.EMAIL.getName());
		String position = ParamUtil.getString(actionRequest, Parameters.POSITION.getName());
		String homePhone = ParamUtil.getString(actionRequest, Parameters.PHONE.getName());
		String homePhoneExt = ParamUtil.getString(actionRequest, Parameters.PHONE_EXT.getName());
		String personalEmail = ParamUtil.getString(actionRequest, Parameters.PERSONAL_EMAIL.getName());
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<AddressBookUser> aBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
			
			// AKA - I'm not sure why - but in y case address book was not create for my user.
			// So, I suggest to add it here
			if (aBookUserList == null || aBookUserList.isEmpty()) {
				AddressBookLocalServiceUtil.addAddressBookUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
			}
			aBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
			
			if (enterprise != null) {
				if (aBookUserList != null && !aBookUserList.isEmpty()) {
					Long contactId = ValidationsUtil.existContact(contactIdParam);
					
					List<String> errorList = new ArrayList<String>();
					if (ValidationsUtil.validateAditionalInfo(themeDisplay.getUserId(), contactId != null ? contactId : -1, enterprise.getEnterpriseId(), 
						fullName, cellPhone, cellPhoneExt, workEmail, skype, position, homePhone, homePhoneExt, personalEmail, errorList)) {
						
						if (contactId == null) { // Se crea el contacto luego de una validacion positiva
							Contact contact = ContactLocalServiceUtil.addContact(themeDisplay.getCompanyId());
							contactId = contact.getContactId();
							
							AddressBookContact addressBookContact = new AddressBookContactImpl();
							addressBookContact.setCompanyId(themeDisplay.getCompanyId());
							addressBookContact.setContactId(contact.getContactId());
							addressBookContact.setAddressBookId(aBookUserList.get(0).getAddressBookId());
							AddressBookContactLocalServiceUtil.addAddressBookContact(addressBookContact);
						}
						
						ContactDataMethod enterpriseContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
						ContactDataRefLocalServiceUtil.updateContactDataRef(contactId, enterpriseContactDataMethod, String.valueOf(enterprise.getEnterpriseId()), aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod nameContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
						ContactDataTextLocalServiceUtil.updateContactDataText(contactId, nameContactDataMethod, fullName, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
					
						ContactDataMethod cellPhoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.CELL_PHONE.getMethodName());
						ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, cellPhoneContactDataMethod, cellPhone, cellPhoneExt, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod phoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PHONE.getMethodName());
						ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, phoneContactDataMethod, homePhone, homePhoneExt, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod skypeContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.SKYPE.getMethodName());
						ContactDataTextLocalServiceUtil.updateContactDataText(contactId, skypeContactDataMethod, skype, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod emailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.EMAIL.getMethodName());
						ContactDataTextLocalServiceUtil.updateContactDataText(contactId, emailContactDataMethod, workEmail, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod personalEmailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName());
						ContactDataTextLocalServiceUtil.updateContactDataText(contactId, personalEmailContactDataMethod, personalEmail, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						ContactDataMethod positionContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.POSITION.getMethodName());
						ContactDataTextLocalServiceUtil.updateContactDataText(contactId, positionContactDataMethod, position, aBookUserList.get(0).getAddressBookId(), themeDisplay.getCompanyId());
						
						SessionMessages.add(actionRequest, CRMSuccessKey.CONTACT_SAVED_SUCCESS);
						
						actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
					} else {
						addErrors(actionRequest, errorList);
						CRMParamUtils.copyRequestParameters(actionRequest, Parameters.ENTERPRISE_ID.getName(), Parameters.CONTACT_ID.getName(), Parameters.CONTACT_FULL_NAME.getName(),
								Parameters.CELL_PHONE.getName(), Parameters.CELL_PHONE_EXT.getName(), Parameters.SKYPE.getName(), Parameters.EMAIL.getName(), Parameters.POSITION.getName(),
								Parameters.PHONE.getName(), Parameters.PHONE_EXT.getName(), Parameters.PERSONAL_EMAIL.getName(),  Parameters.ENTERPRISE_NAME.getName());
						actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
					}
				} else {
					SessionErrors.add(actionRequest, CRMErrorKey.NON_EXIXTENT_ADDRESS_BOOK);
					logger.warn("Tried to save contact info but the user doesnt have address book. User id: " + themeDisplay.getUserId());
					actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
				}
			} else {
				SessionErrors.add(actionRequest, CRMErrorKey.INVALID_ENTERPRISE_PARAM);
				logger.warn("Tried to save contact info but the enterprise does not exist");
				actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
			}
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to save contact info.", e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			logger.error("Unexpected error when try to save contact info.", e);
			actionResponse.setRenderParameter("jspPage", "/html/contactmanager/view.jsp");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
	 
		if ("autocomplete".equals(resourceID)) {
			String keywords = ParamUtil.getString(resourceRequest, "keywords");
	 
			JSONObject json = JSONFactoryUtil.createJSONObject();
			JSONArray results = JSONFactoryUtil.createJSONArray();
			json.put("response", results);
	 
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Enterprise.class);
				query.add(RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + keywords + StringPool.PERCENT));
				List<Enterprise> enterprises = EnterpriseLocalServiceUtil.dynamicQuery(query);

				for (Enterprise enterprise : enterprises) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("enterpriseId", enterprise.getEnterpriseId());
					object.put("description", enterprise.getDescription());
					object.put("email", enterprise.getEmail());
					object.put("industryId", enterprise.getIndustry());
					object.put("isPrivate", CRMParamUtils.getCheckboxValue(enterprise.getIsPrivate()));
					object.put("enterpriseName", enterprise.getName());
					object.put("taxid", enterprise.getTaxid());
					
					List<Address> addressList = AddressLocalServiceUtil.getAddresses(enterprise.getCompanyId(), Enterprise.class.getName(), enterprise.getEnterpriseId());
					if (addressList != null && !addressList.isEmpty()) {
						object.put("countryId", addressList.get(0).getCountry().getCountryId());
						object.put("street1", addressList.get(0).getStreet1());
						object.put("street2", addressList.get(0).getStreet2());
						object.put("street3", addressList.get(0).getStreet3());
						object.put("zip", addressList.get(0).getZip());
						object.put("city", addressList.get(0).getCity());
					}
					
					results.put(object);
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
	 
			writeJSON(resourceRequest, resourceResponse, json);
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	private void addErrors(ActionRequest actionRequest, List<String> errorList) {
		if (errorList != null) {
			for (String error : errorList) {
				SessionErrors.add(actionRequest, error);
			}
		}
	}
}