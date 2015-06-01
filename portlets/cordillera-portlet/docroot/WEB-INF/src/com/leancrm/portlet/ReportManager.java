package com.leancrm.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.entity.ContactEntity;
import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.leancrm.portlet.types.FollowUpEventStatus;
import com.leancrm.portlet.utils.AddressBookUtils;
import com.leancrm.portlet.utils.CRMParamUtils;
import com.leancrm.portlet.utils.MailUtils;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.utils.ReportManagerUtils;
import com.leancrm.portlet.validator.ContractValidator;
import com.leancrm.portlet.validator.ReportValidator;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.cal.TZSRecurrence;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ReportManager
 */
public class ReportManager extends MVCPortlet {
	
	private static Logger logger = Logger.getLogger(ReportManager.class);

	public void getEnterprises(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray results = JSONFactoryUtil.createJSONArray();
		json.put("response", results);
		
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId()).get(0);
			
			List<Contact> contacts = ContactLocalServiceUtil.getConsultantContacts(themeDisplay.getUserId());
			List<Enterprise> enterprises = AddressBookUtils.getEnterprisesFromContacts(addressBookUser.getAddressBookId(), contacts);
			
			for (Enterprise enterprise : enterprises) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("enterpriseId", enterprise.getEnterpriseId());
				object.put("description", enterprise.getDescription());
				object.put("email", enterprise.getEmail());
				object.put("industryId", enterprise.getIndustry());
				object.put("isPrivate", CRMParamUtils.getCheckboxValue(enterprise.getIsPrivate()));
				object.put("enterpriseName", enterprise.getName());
				object.put("taxid", enterprise.getTaxid());
				
				results.put(object);
			}
	 
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get enterprises from report manager. " + e.getMessage());
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void getContactsAndContractsByEnterprise(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId()).get(0);
			
			long enterpriseId = ParamUtil.getLong(resourceRequest, "enterpriseId");
			logger.debug("Get contacts and contracts for enterprise id: " + enterpriseId);
			long organizationId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
			
			json.put("contacts", ReportManagerUtils.getContactAsJson(ContactLocalServiceUtil.getConsultantContacts(themeDisplay.getUserId()), enterpriseId, addressBookUser.getAddressBookId()));
			json.put("contracts", ReportManagerUtils.getContractListAsJson(ContractLocalServiceUtil.getContractList(organizationId, enterpriseId, themeDisplay.getUserId()))); // deberia buscar contratos entre la organization, empresa y consultor
			
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get contacts and contracts from report manager." + e.getMessage());
			logger.error("Unexpected error when try to get contacts and contracts from report manager.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}

	public void getContactDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId()).get(0);
			AddressBook currentAddressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookUser.getAddressBookId());
			long contactId = ParamUtil.getLong(resourceRequest, "contactId");
			
			List<ContactData> contactData = AddressBookContactDataLocalServiceUtil.getContactData(currentAddressBook, contactId);
			
			json.put("methods", ReportManagerUtils.getContactDataAsJson(contactData) );
			
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get contact detail from report manager." + e.getMessage());
			logger.error("Unexpected error when try to get contact detail from report manager.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
		
	}
	
	public void getContractDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			Long contractId = ValidationsUtil.existContract(ParamUtil.getString(resourceRequest, "contractId"));
			
			if (contractId != null) {
				json = ReportManagerUtils.getContractDetail(ContractLocalServiceUtil.getContract(contractId));
			} else {
				json.put("error", "Could not get contract with the id: " + contractId);
			}
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get contract detail from report manager. " + e.getMessage());
			logger.error("Unexpected error when try to get contract detail from report manager. ", e);
		}
 
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	 
	public void addEvent(long userId, int startDateDay, int startMonth, int startDateYear, int startDateHour, int startDateMinute, 
			int endDay, int endMonth, int endYear, int endHour, int endMinute, ServiceContext serviceContext,
			String title, String description) throws PortalException, SystemException {
		TZSRecurrence recurrence =new TZSRecurrence();
		recurrence.setFrequency(1);
  
		String location = "";
		int startDateMonth = startMonth - 1;
		int durationHour = 1;
		int durationMinute = 0;
		boolean allDay = false;
		boolean timeZoneSensitive = false;
		String type = "appointment";
		boolean repeating = false;
		int remindBy = 0;
		int firstReminder = 300000;
		int secondReminder = 300000;
		
		CalEventLocalServiceUtil.addEvent(
				userId, 
				title, 
				description, 
				location, 
				startDateMonth, 
				startDateDay, 
				startDateYear, 
				startDateHour, 
				startDateMinute, 
				durationHour, 
				durationMinute, 
				allDay, 
				timeZoneSensitive, 
				type, 
				repeating, 
				recurrence, 
				remindBy, 
				firstReminder, 
				secondReminder, 
				serviceContext);
	}

	public void addReportTest(ResourceRequest actionRequest, ResourceResponse actionResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
			
			if (organization != null) {
				String enterpriseIdParam = ParamUtil.getString(actionRequest, "enterpriseId");
				logger.info("EnterpriseId: " + enterpriseIdParam);
				String contactIdParam = ParamUtil.getString(actionRequest, "contact");
				logger.info("Contact: " + contactIdParam);
				String contractIdParam = ParamUtil.getString(actionRequest, "contract");
				logger.info("Contract: " + contractIdParam);
				String contractDescriptionParam = ParamUtil.getString(actionRequest, "contractDescription");
				logger.info("C. Description: " + contractDescriptionParam);
				String contractAmountParam = ParamUtil.getString(actionRequest, "contractAmount");
				logger.info("C. Ammount: " + contractAmountParam);
				
				String contactDataIdParam = ParamUtil.getString(actionRequest, "contactDataId");
				logger.info("Contact Data Id: " + contactDataIdParam);
				String statusCode = ParamUtil.getString(actionRequest, "statusCode");
				logger.info("Status Code: " + statusCode);
				String progressParam = ParamUtil.getString(actionRequest, "progress");
				logger.info("Progress: " + progressParam);
				String reportDateParam = ParamUtil.getString(actionRequest, "reportDate");
				logger.info("Report Date: " + reportDateParam);
				String commentsParam = ParamUtil.getString(actionRequest, "comments");
				logger.info("Comments: " + commentsParam);
				
				String nextDate = ParamUtil.getString(actionRequest, "nextFollowUpDate");
				logger.info("Next Follow Up Date: " + nextDate);
				String nextTime = ParamUtil.getString(actionRequest, "nextFollowUpTime");
				logger.info("Nest Follow Up Time: " + nextTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("result", "this is the result");
		
		try {
			writeJSON(actionRequest, actionResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error.", e);
		}
	}
	
	// private boolean isNotDuplicated(String enterpriseId, String contactId, String contractId, String status, String progress, String comment) {}
	
	public void addReport(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String result = "success";
		JSONArray resultDescription = JSONFactoryUtil.createJSONArray();
		List<String> errorList = new ArrayList<String>();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
			
			if (organization != null) {
				String enterpriseIdParam = ParamUtil.getString(resourceRequest, "enterpriseId");
				logger.info("EnterpriseId: " + enterpriseIdParam);
				String contactIdParam = ParamUtil.getString(resourceRequest, "contact");
				logger.info("Contact: " + contactIdParam);
				String contractIdParam = ParamUtil.getString(resourceRequest, "contract");
				logger.info("Contract: " + contractIdParam);
				String contractDescriptionParam = ParamUtil.getString(resourceRequest, "contractDescription");
				logger.info("C. Description: " + contractDescriptionParam);
				String contractAmountParam = ParamUtil.getString(resourceRequest, "contractAmount");
				logger.info("C. Ammount: " + contractAmountParam);
				
				String contactDataIdParam = ParamUtil.getString(resourceRequest, "contactDataId");
				logger.info("Contact Data Id: " + contactDataIdParam);
				String statusCode = ParamUtil.getString(resourceRequest, "statusCode");
				logger.info("Status Code: " + statusCode);
				String progressParam = ParamUtil.getString(resourceRequest, "progress");
				logger.info("Progress: " + progressParam);
				String reportDateParam = ParamUtil.getString(resourceRequest, "reportDate");
				logger.info("Report Date: " + reportDateParam);
				String commentsParam = ParamUtil.getString(resourceRequest, "comments");
				logger.info("Comments: " + commentsParam);
				
				String nextDate = ParamUtil.getString(resourceRequest, "nextFollowUpDate");
				logger.info("Next Follow Up Date: " + nextDate);
				String nextTime = ParamUtil.getString(resourceRequest, "nextFollowUpTime");
				logger.info("Nest Follow Up Time: " + nextTime);
				
				Long contractId = ValidationsUtil.existContract(contractIdParam);
				
				if (contractId == null) {
					ContractValidator.validateContract(contactIdParam, enterpriseIdParam, contractDescriptionParam, contractAmountParam, errorList);
					ReportValidator.validateReport(contactDataIdParam, progressParam, 0d, reportDateParam, null, commentsParam, statusCode, errorList);
				} else {
					Report lastReport = ReportManagerUtils.getLastReport(contractId);
					ReportValidator.validateReport(contactDataIdParam, progressParam, lastReport.getProgress(), reportDateParam, lastReport.getReportDate(), commentsParam, statusCode, errorList);
				} 
 
				if (errorList.isEmpty()) {
					Contract contract = null;
					
					if (contractId == null) {
						contract = ContractLocalServiceUtil.addContract(
								themeDisplay.getCompanyId(), 
								Long.parseLong(contactIdParam), 
								Long.parseLong(enterpriseIdParam),
								organization.getOrganizationId(), 
								contractDescriptionParam, 
								Double.parseDouble(contractAmountParam));
						
						contractId = contract.getContractId();
						UserContractLocalServiceUtil.addUserContract(themeDisplay.getUserId(), contractId, ContractConstants.ACCESS_OWNER);
						
					} else {
						ContractLocalServiceUtil.updateAmount(contractId, Double.parseDouble(contractAmountParam));
						contract = ContractLocalServiceUtil.getContract(contractId);
					}
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

					AddressBook addressBookUser = AddressBookUtils.getAddressBook(themeDisplay.getUser());
					
					long contactId = Long.parseLong(contactIdParam);
					
					ContactDataText contactName = ContactLocalServiceUtil.getName(contactId, addressBookUser.getAddressBookId());
					
					Report report = ReportLocalServiceUtil.addReport(
							themeDisplay.getCompanyId(), 
							contractId, 
							Long.parseLong(contactIdParam),
							commentsParam, 
							Long.parseLong(contactDataIdParam),
							Long.parseLong(enterpriseIdParam), 
							organization.getOrganizationId(), 
							Double.parseDouble(progressParam), 
							formatter.parse(reportDateParam), 
							Integer.parseInt(statusCode), 
							themeDisplay.getUserId(),
							contactName.getContactDataId());
					
					ContactEntity contactEntity = new ContactEntity(contactId, themeDisplay.getUserId());
					Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(report.getEnterpriseId());
					
//					SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//					SimpleDateFormat format2 = new SimpleDateFormat("HH:mm a");
//					SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMdd");
//					SimpleDateFormat format4 = new SimpleDateFormat("HHmmss");
//					Date d1 = format1.parse(nextDate);
//					Date d2 = format2.parse(nextTime);
//					String dd = format3.format(d1) + format4.format(d2);
//					System.out.println(dd);
//					addCalEventAdHoc(contactEntity.getName(), enterprise.getName(), dd, "1", "false", "");
					
					if (!ValidationsUtil.isEmpty(nextDate)) {
						String date;
						if (!ValidationsUtil.isEmpty(nextTime)) {
							date = nextDate + " " + nextTime;
						} else {
							date = nextDate + " 00:00 am";
						}
						
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:ss a");
						Date nextEventDateTime = dateFormat.parse(date);
						NextFollowUpEventLocalServiceUtil.addNextFollowUpEvent(contractId, report.getReportId(), "FollowUpEvent with " + contactEntity.getName(), enterprise.getName(), nextEventDateTime, themeDisplay.getUserId(), FollowUpEventStatus.PENDING.ordinal());
					}
					// Contact Data Used
					ContactDataLocalServiceUtil.setReadOnly(report.getContactDataId(), true);
					
					/*
					if (AddressBookLocalServiceUtil.hasContactData(addressBookOrganization.getAddressBookId(), report.getContactDataId())) {
						
					} else {
//-						AddressBookLocalServiceUtil.addContactData(addressBookOrganization.getAddressBookId(), report.getContactDataId(), addressBookOrganization.getCompanyId());
					}
					*/
			        
					// Contact Name
					ContactDataLocalServiceUtil.setReadOnly(contactName.getContactDataId(), true);
					
					// Contact Enterprise
					ContactDataRef contactEnterprise = ContactLocalServiceUtil.getEnterprise(report.getContactId(), addressBookUser.getAddressBookId());
					ContactDataLocalServiceUtil.setReadOnly(contactEnterprise.getContactDataId(), true);
					
//-					if (! AddressBookLocalServiceUtil.hasContact(addressBookOrganization.getAddressBookId(), report.getContactId())) {
//-						// Add Contact
//-						AddressBookLocalServiceUtil.addContact(addressBookOrganization.getAddressBookId(), report.getContactId(), addressBookOrganization.getCompanyId());
//-						AddressBookLocalServiceUtil.addContactData(addressBookOrganization.getAddressBookId(), contactName.getContactDataId(), addressBookOrganization.getCompanyId());
//-						AddressBookLocalServiceUtil.addContactData(addressBookOrganization.getAddressBookId(), contactEnterprise.getContactDataId(), addressBookOrganization.getCompanyId());
//-					}
					
					
					// if reporter is not owner of contract (lead) - owner should be notified
					User leadOwner = UserContractLocalServiceUtil.getContractOwner(contractId);
					if (leadOwner.getUserId() != themeDisplay.getUserId()) {
						
						MailUtils.leadChanged(leadOwner, themeDisplay.getUser(),  contract, report);
					}
					
				} else {
					result = "error";
					logger.warn("Validations fail");
				}
			} else {
				result = "error";
				logger.warn("Could not get organization for the user:" + themeDisplay.getUserId());
				errorList.add("Could not get organization for the user:" + themeDisplay.getUserId());
			}
		} catch (Exception e) {
			result = "error";
			logger.error("Unexpected error when try to add report", e);
			errorList.add("Unexpected error when try to add report, please check the logs");
		}
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		resultDescription = getJsonErrors(errorList);
		json.put(result, resultDescription);
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error.", e);
		}
	}
	
	private JSONArray getJsonErrors(List<String> errorList) {
		JSONArray results = JSONFactoryUtil.createJSONArray();
		if (errorList != null) {
			for (String error : errorList) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("message", error);
				results.put(object);
			}
		}
		return results;
	}
	
	public void reloadCalendar(ActionRequest actionRequest, ActionResponse actionResponse) throws ServletException, IOException {
		goToPage(actionRequest, actionResponse, "/html/reportmanager/reportCalendar.jsp");
	}
	
	public void showReportForm(ActionRequest actionRequest, ActionResponse actionResponse) throws ServletException, IOException {
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		goToPage(actionRequest, actionResponse, "/html/reportmanager/view.jsp");
	}
	
	private void goToPage(ActionRequest actionRequest, ActionResponse actionResponse, String page) throws ServletException, IOException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletResponse servletResponse = PortalUtil.getHttpServletResponse(actionResponse);
		
		servletRequest.getRequestDispatcher(page).forward(servletRequest, servletResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if ("autocompleteEnterpriseAddReport".equals(resourceID)) {
			getEnterprises(resourceRequest, resourceResponse);
		} else if ("getContactsAndContractsByEnterprise".equals(resourceID)) {
			getContactsAndContractsByEnterprise(resourceRequest, resourceResponse);
		} else if ("getContactDetail".equals(resourceID)) {
			getContactDetail(resourceRequest, resourceResponse);
		} else if ("getContractDetail".equals(resourceID)) {
			getContractDetail(resourceRequest, resourceResponse);
		} else if ("addReport".equals(resourceID)){
			addReport(resourceRequest, resourceResponse);
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}