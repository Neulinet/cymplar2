package com.leancrm.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.entity.ConsultantEntity;
import com.leancrm.portlet.entity.Contact;
import com.leancrm.portlet.entity.ContactEntity;
import com.leancrm.portlet.library.NoSuchContactDataException;
import com.leancrm.portlet.library.NoSuchContactDataRefException;
import com.leancrm.portlet.library.NoSuchContactDataTextException;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.MyAddressBookContact;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.types.ContractStatus;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.leancrm.portlet.utils.CRMJsonFormat;
import com.leancrm.portlet.utils.CRMSuccessKey;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContactDisplay
 */
public class ContactDisplay extends MVCPortlet {

	private Logger logger = Logger.getLogger(ContactDisplay.class);
	
	public void removeContact(ActionRequest actionRequest, ActionResponse actionResponse) {
		String contactIdString = ParamUtil.getString(actionRequest, "contactId");
		try {
			Long contactId = ValidationsUtil.existContact(contactIdString);
			
			if (contactId != null) {
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId()).get(0);
				
				ContactLocalServiceUtil.removeContact(contactId, addressBookUser.getAddressBookId());
			}
		} catch (NoSuchContactDataException e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		} catch (NoSuchContactDataRefException e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		} catch (NoSuchContactDataTextException e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		} catch (SystemException e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		} catch (PortalException e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		} catch (Exception e) {
			logger.error(e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/viewError.jsp");
		}
		
		SessionMessages.add(actionRequest, CRMSuccessKey.CONTACT_REMOVED);
		
		actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/view.jsp");
	}

	public void loadContactDetail(ActionRequest actionRequest, ActionResponse actionResponse) {
		String contactIdParam = ParamUtil.getString(actionRequest, "contactId");
		StringBuilder json = new StringBuilder();
		try {
			Long contactId = ValidationsUtil.existContact(contactIdParam);
			
			if (contactId != null) {
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				ContactEntity contactEntity = new ContactEntity(contactId, themeDisplay.getUserId());
				json.append(CRMJsonFormat.getContactDetailAsJson(contactEntity));
			} else {
				json = new StringBuilder();
				json.append(CRMJsonFormat.generateJsonError(new String[] {"Tried to edit contact but contact doesnt exist. Contact Id: " + contactIdParam}));
				logger.warn("Tried to edit contact but contact doesnt exist. Contact Id: " + contactIdParam);
			}
			
		} catch (Exception e) {
			json = new StringBuilder();
			json.append(CRMJsonFormat.generateJsonError(new String[] {"Unexpected error when try to edit contact. Contact Id: " + contactIdParam, e.getMessage()}));
			logger.error("Unexpected error when try to edit contact. Contact Id: " + contactIdParam, e);
		}
		
		CRMJsonFormat.jsonResponse(actionResponse, json.toString());
	}
	
	public void getContacts(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			int cur1 = ParamUtil.getInteger(actionRequest, "cur1");
			int delta1 = ParamUtil.getInteger(actionRequest, "delta1");
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			
			int start = cur1 <= 1? 0 : cur1 * delta1;
			int end = start + delta1 - 1;
			System.out.println("Cur1: " + cur1);
			System.out.println("Delta1: " + delta1);
			System.out.println("Start: " + start);
			System.out.println("End: " + end);
			ConsultantEntity consultant = new ConsultantEntity(themeDisplay.getUser());
			List<Contact> contactList = new ArrayList<Contact>();
			if (consultant.getOrganization() != null) {
				List<MyAddressBookContact> resultList = MyAddressBookContactLocalServiceUtil.getAll(consultant.getOrganization().getOrganizationId(), consultant.getConsultantId(), start, end * 2);
				
				Map<Long, Contact> temporaryResult = new HashMap<Long, Contact>();
				if (resultList != null) {
					for (MyAddressBookContact result : resultList) {
						Contact c = temporaryResult.get(result.getContactId());
						if (c == null) {
							c = new Contact();
							c.setContactId(result.getContactId());
							temporaryResult.put(result.getContactId(), c);
						}
						Long methodId = result.getMethodId();
						if (methodId != null && methodId == 204) {
							c.setFullName( result.getContactName());
						} else if (methodId == 205) {
							c.setEnterpriseName( result.getEnterpriseName());
							
							Long contractId = result.getContactId();
							if (contractId != null && contractId > 0) {
								c.setContractDescription( result.getDescription() );
								c.setContractProgress( String.valueOf(result.getProgress()) );
								ContractStatus cs = ContractStatus.getContractStatus( Integer.parseInt(String.valueOf(result.getStatus())) );
								c.setContractStatus(cs.getLabel());
							}
						}
					}
				}
				contactList.addAll(temporaryResult.values());
			}
			
			actionRequest.setAttribute("contactList", contactList);
			
			actionResponse.setRenderParameter("jspPage", "/html/contactdisplay/contactList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
	 
		if ("getContactInfo".equals(resourceID)) {
			long contactId = ParamUtil.getLong(resourceRequest, "contactId");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				ContactEntity contactEntity = new ContactEntity(themeDisplay.getCompanyId(), contactId, themeDisplay.getUserId());
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("enterpriseId", contactEntity.getEnterpriseEntity().getEnterpriseId());
				json.put("enterpriseName", contactEntity.getEnterpriseEntity().getName());
				json.put("enterpriseDescription", contactEntity.getEnterpriseEntity().getDescription());
				json.put("enterpriseEmail", contactEntity.getEnterpriseEntity().getEmail());
				json.put("enterpriseAbn", contactEntity.getEnterpriseEntity().getAbn());
				json.put("enterpriseIndustry", contactEntity.getEnterpriseEntity().getIndustry());
				json.put("enterpriseStreet1", contactEntity.getEnterpriseEntity().getStreet1());
				json.put("enterpriseStreet2", contactEntity.getEnterpriseEntity().getStreet2());
				json.put("enterpriseSuburb", contactEntity.getEnterpriseEntity().getSuburb());
				json.put("enterpriseCountry", contactEntity.getEnterpriseEntity().getCountryId());
				json.put("enterprisePostalCode", contactEntity.getEnterpriseEntity().getPostalCode());
				json.put("enterpriseCity", contactEntity.getEnterpriseEntity().getCity());
				
				json.put("contactId", contactId);
				json.put("fullName", contactEntity.getName());
				json.put("position", contactEntity.getPosition());
				json.put("phone", contactEntity.getPhone());
				json.put("mobile", contactEntity.getCellPhone());
				json.put("skype", contactEntity.getSkype());
				json.put("email", contactEntity.getEmail());
				json.put("personalEmail", contactEntity.getPersonalEmail());
				
				writeJSON(resourceRequest, resourceResponse, json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if ("contactPagination".equals(resourceID)) {
			try {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				JSONArray results = JSONFactoryUtil.createJSONArray();
				json.put("response", results);
				
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				ConsultantEntity consultant = new ConsultantEntity(themeDisplay.getUser());
				
				Integer pageNumber = ParamUtil.getInteger(resourceRequest, "pageNumber");
				Integer pageSize = ParamUtil.getInteger(resourceRequest, "pageSize");
				
				List<Contact> contactList = new ArrayList<Contact>();
				if (consultant.getOrganization() != null) {
					int start = (pageNumber - 1) * pageSize;
					int end = pageNumber * pageSize;
					
					List<MyAddressBookContact> resultList = MyAddressBookContactLocalServiceUtil.getAll(consultant.getOrganization().getOrganizationId(), consultant.getConsultantId(), start, end * 2);
					
					Map<Long, Contact> temporaryResult = new HashMap<Long, Contact>();
					if (resultList != null) {
						for (MyAddressBookContact result : resultList) {
							Contact c = temporaryResult.get(result.getContactId());
							if (c == null) {
								c = new Contact();
								c.setContactId(result.getContactId());
								temporaryResult.put(result.getContactId(), c);
							}
							Long methodId = result.getMethodId();
							if (methodId != null && methodId == 204) {
								c.setFullName( result.getContactName());
							} else if (methodId == 205) {
								c.setEnterpriseName( result.getEnterpriseName());
								
								Long contractId = result.getContactId();
								if (contractId != null && contractId > 0) {
									c.setContractDescription( result.getDescription() );
									c.setContractProgress( String.valueOf(result.getProgress()) );
									ContractStatus cs = ContractStatus.getContractStatus( Integer.parseInt(String.valueOf(result.getStatus())) );
									c.setContractStatus( cs.getLabel() );
								}
							}
						}
					}
					contactList.addAll(temporaryResult.values());
				}
				
				for (Contact c : contactList) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					
					object.put("contactId", c.getContactId());
					object.put("enterpriseName", c.getEnterpriseName());
					object.put("fullName", c.getFullName());
					object.put("contractId", c.getContractId());
					object.put("contractDescription", c.getContractDescription());
					object.put("contractProgress", c.getContractProgress());
					object.put("contractStatus", c.getContractStatus());
					
					results.put(object);
				}
				
				writeJSON(resourceRequest, resourceResponse, json);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}
