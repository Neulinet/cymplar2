package com.leancrm.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
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

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.leancrm.portlet.entity.ConsultantEntity;
import com.leancrm.portlet.entity.ContactEntity;
import com.leancrm.portlet.entity.OrganizationEntity;
import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.IndustryLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.leancrm.portlet.types.ContractStatus;
import com.leancrm.portlet.utils.AddressBookUtils;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.utils.ContactStatusEnum;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.utils.ReportManagerUtils;
import com.leancrm.portlet.validator.ContractValidator;
import com.leancrm.portlet.validator.ReportValidator;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.opencsv.CSVReader;

/**
 * Portlet implementation class ContactMigration
 */
public class ContactMigration extends MVCPortlet {
	private Logger logger = Logger.getLogger(this.getClass());
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public void selectOrganization(ActionRequest actionRequest, ActionResponse actionResponse) {
		String folder = getInitParameter("uploadFolder");
		String realPath = getPortletContext().getRealPath("/");
		
		logger.info("RealPath" + realPath + " UploadFolder :" + folder);
		try {
			logger.info("Siamo nel try");
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));
			
			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}
			
			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(uploadRequest.getFileAsStream("fileName")));
			
			String line;
			while ((line = reader.readLine()) != null) {
				logger.info(line);
			}
			
			SessionMessages.add(actionRequest, "success");
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (NullPointerException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			SessionMessages.add(actionRequest, "error");
			e1.printStackTrace();
		}
	}
	
	// COMPANY NAME (MANDATORY IF NOT PRIVATE) ;PRIVATE (MANDATORY);DESCRIPTION;COMPANY EMAIL;ABN;INDUSTRY ID;STREET 1 (MANDATORY); STREET 2;SUBURB;COUNTRY (MANDATORY);POSTAL CODE (MANDATORY);CITY (MANDATORY)
	public void inportCompanies(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
//		String folder = getInitParameter("uploadFolder");
//		String realPath = getPortletContext().getRealPath("/");
//		
//		logger.info("RealPath" + realPath + " UploadFolder :" + folder);
		
		int row = 0;
	    
		List<String> errorList;
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));
			
			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}
			
			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(uploadRequest.getFileAsStream("fileName")));
			  
			String line = reader.readLine(); // READ HEADER
			int columns = line.split(";" ,-1).length;
			while ((line = reader.readLine()) != null) {
				row++;
				errorList = new ArrayList<String>();
				
				String[] a = line.split(";", -1);
				
				if (a.length == columns) {
					String companyName = a[0].replaceAll("\"", "");
					boolean isPrivate = "1".equals((a[1]));
					String description = a[2].replaceAll("\"", "");
					String email = a[3];
					String taxId = a[4];
					String industry = a[5];
					String street1 = a[6];
					String street2 = a[7];
					String street3 = a[8];
					String countryId = "32";
					String zipCode = a[10];
					String city = a[11];
					
					if (ValidationsUtil.validateEnterpriseRequest(companyName, taxId, countryId, description, email, industry,
							street1, street2, street3, zipCode, city, isPrivate, errorList)) {
						EnterpriseLocalServiceUtil.addEnterprise(themeDisplay.getCompanyId(), themeDisplay.getUserId(), companyName, taxId, countryId, description, email, industry, street1, street2, street3, zipCode, city, isPrivate);
					} else {
						logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						logger.error("Could not validate row: [" + row + "] " + line);
						for (String error : errorList) {
							logger.error("ERROR: " + error);
						}
						logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					}   
				} else {
					logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					logger.error("Incorrect columns for the row: [" + row + "] " + line);
					logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				}
			}
		} catch (Exception e) {
			logger.error("Error when try to inport company: " + "companies and contacts", e);
		}
		
		logger.info("Rows processed: " + row);
	}
	
	// COMPANY NAME (MANDATORY IF NOT PRIVATE) ;PRIVATE (MANDATORY);DESCRIPTION;COMPANY EMAIL;ABN;INDUSTRY ID;STREET 1 (MANDATORY); STREET 2;SUBURB;COUNTRY (MANDATORY);POSTAL CODE (MANDATORY);CITY (MANDATORY)
	public void exportCompanies(ResourceRequest actionRequest, ResourceResponse actionResponse) {

		StringBuilder csvText = new StringBuilder();
		try {
			csvText.append("COMPANY ID");   
			csvText.append(",");
			csvText.append("COMPANY NAME");
			csvText.append(",");
			csvText.append("PRIVATE");
			csvText.append(",");
			csvText.append("DESCRIPTION");
			csvText.append(",");
			csvText.append("COMPANY EMAIL");
			csvText.append(",");
			csvText.append("ABN");
			csvText.append(",");
			csvText.append("INDUSTRY ID");
			csvText.append(",");
			csvText.append("STREET 1");
			csvText.append(",");
			csvText.append("STREET 2");
			csvText.append(",");
			csvText.append("SUBURB");
			csvText.append(",");
			csvText.append("COUNTRY");
			csvText.append(",");
			csvText.append("POSTAL CODE");
			csvText.append(",");
			csvText.append("CITY");
			csvText.append("\n");
			
			List<Enterprise> enterprises = EnterpriseLocalServiceUtil.getAll();
			for (Enterprise enterprise : enterprises) {
				csvText.append(enterprise.getEnterpriseId());
				csvText.append(",");
				csvText.append(enterprise.getName());  
				csvText.append(",");
				csvText.append(enterprise.getIsPrivate());
				csvText.append(",");
				csvText.append(enterprise.getDescription());
				csvText.append(",");
				csvText.append(enterprise.getEmail());
				csvText.append(",");
				csvText.append(enterprise.getTaxid());
				csvText.append(",");
				csvText.append(enterprise.getIndustry());
				csvText.append(",");
				
				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				List<Address> addressList = AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(), Enterprise.class.getName(), enterprise.getEnterpriseId());
				
				csvText.append(addressList.get(0).getStreet1());
				csvText.append(",");
				csvText.append(addressList.get(0).getStreet2());
				csvText.append(","); 
				csvText.append(addressList.get(0).getStreet3());
				csvText.append(",");
				csvText.append(addressList.get(0).getCountryId());
				csvText.append(",");
				csvText.append(addressList.get(0).getZip());
				csvText.append(",");
				csvText.append(addressList.get(0).getCity());
				csvText.append("\n");
			}
		} catch (Exception e) {
			logger.error("There was a problem when try to export companies", e);
			csvText.append("There was a problem when try to export companies. " + e.getMessage());
		}
		
		serveResource(actionRequest, actionResponse, csvText.toString(), "companies-report");
	}
	
	// ConsultantEmail(liferay);CompanyID(liferay);CONTACT FULL NAME (MANDATORY);POSITION;PHONE;MOBILE;SKYPE;EMAIL;PERSONAL EMAIL
	public void importContacts(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		int row = 1;
		
		List<String> errorList;
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));
			
			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}
			
			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(uploadRequest.getFileAsStream("fileName")));
			
			String line = reader.readLine(); // READ HEADER
			int columns = line.split(";" ,-1).length;
			while ((line = reader.readLine()) != null) {
				row++;
				errorList = new ArrayList<String>();
				
				String[] a = line.split(";", -1);
				
				if (a.length == columns || a.length == columns-1) {
					
					ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					
					String consultantEmail = a[0];
					String enterpriseId = a[1];// CompanyID(liferay)
					String fullName = a[2]; //CONTACT FULL NAME (MANDATORY)
					String position = a[3]; // POSITION
					String homePhone = a[4]; // PHONE
					String homePhoneExt = "";
					String cellPhone = a[5];  // MOBILE
					String cellPhoneExt = "";
					String skype = a[6]; // SKYPE 
					String workEmail = a[7].replace(" ", "").replace("'", ""); // EMAIL
					String personalEmail = "";
					if (a.length == columns) {
						personalEmail = a[8].replace(" ", "").replace("'", ""); // PERSONAL EMAIL
					}
					User consultant;
					try {
						consultant = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), consultantEmail);
					} catch (Exception e) {
						logger.error("[" + row + "] Error when try to get user with email: " + consultantEmail + " in row " + row + ". Row: " + line);
						continue;
					}
					
					Enterprise enterprise;
					try {
						enterprise = EnterpriseLocalServiceUtil.getEnterprise(Long.parseLong(enterpriseId));
					} catch (Exception e) {
						logger.error("[" + row + "] Error when try to get company with id: " + enterpriseId + ". Row: " + line);
						continue;
					}
					
					if (enterprise != null) {
						List<AddressBookUser> aBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(consultant.getUserId());
						if (aBookUserList != null && !aBookUserList.isEmpty()) {
							if (ValidationsUtil.validateAditionalInfo(consultant.getUserId(), -1, enterprise.getEnterpriseId(), 
								fullName, cellPhone, cellPhoneExt, workEmail, skype, position, homePhone, homePhoneExt, personalEmail, errorList)) {
								
								Contact contact = ContactLocalServiceUtil.addContact(consultant.getCompanyId());
								long contactId = contact.getContactId();
							 
								AddressBookContact addressBookContact = new AddressBookContactImpl();
								addressBookContact.setCompanyId(consultant.getCompanyId());
								addressBookContact.setContactId(contact.getContactId());
								addressBookContact.setAddressBookId(aBookUserList.get(0).getAddressBookId());
								AddressBookContactLocalServiceUtil.addAddressBookContact(addressBookContact);
								
								ContactDataMethod enterpriseContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
								ContactDataRefLocalServiceUtil.updateContactDataRef(contactId, enterpriseContactDataMethod, String.valueOf(enterprise.getEnterpriseId()), aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod nameContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
								ContactDataTextLocalServiceUtil.updateContactDataText(contactId, nameContactDataMethod, fullName, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
							
								ContactDataMethod cellPhoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.CELL_PHONE.getMethodName());
								ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, cellPhoneContactDataMethod, cellPhone, cellPhoneExt, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod phoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PHONE.getMethodName());
								ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, phoneContactDataMethod, homePhone, homePhoneExt, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod skypeContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.SKYPE.getMethodName());
								ContactDataTextLocalServiceUtil.updateContactDataText(contactId, skypeContactDataMethod, skype, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod emailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.EMAIL.getMethodName());
								ContactDataTextLocalServiceUtil.updateContactDataText(contactId, emailContactDataMethod, workEmail, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod personalEmailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName());
								ContactDataTextLocalServiceUtil.updateContactDataText(contactId, personalEmailContactDataMethod, personalEmail, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
								ContactDataMethod positionContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.POSITION.getMethodName());
								ContactDataTextLocalServiceUtil.updateContactDataText(contactId, positionContactDataMethod, position, aBookUserList.get(0).getAddressBookId(), consultant.getCompanyId());
								
							} else {
								String errorMessage = "";
								for (String error : errorList) {
									errorMessage += "|";
									errorMessage += error;
								}
								logger.error("[" + row + "] Errors (" + errorMessage + "). Row: " + line);
							}
						} else {
							logger.error("[" + row + "] Errors Cound not found address book for consultant in the row: " + line);
						}
					} else {
						logger.error("[" + row + "] Errors Cound not found enterprise for contact in the row: " + line);
					}
				} else {
					logger.error("[" + row + "] Errors Incorrect columns for the row: " + line);
				}
			}
		} catch (Exception e) {
			logger.error("[" + row + "] Errors when try to inport company: " + "companies and contacts", e);
		}
			
		logger.info("Rows processed: " + row);
		
	}

	/// CONSULTANT FULL NAME (MANDATORY)	COMPANY NAME (MANDATORY IF NOT PRIVATE) 	PRIVATE (MANDATORY)	DESCRIPTION	COMPANY EMAIL	ABN	INDUSTRY	STREET 1 (MANDATORY)	 STREET 2	SUBURB	COUNTRY (MANDATORY)	POSTAL CODE (MANDATORY)	CITY (MANDATORY)	CONTACT FULL NAME (MANDATORY)	POSITION	PHONE	MOBILE	SKYPE	EMAIL	PERSONAL EMAIL
	public void exportContacts(ResourceRequest actionRequest, ResourceResponse actionResponse) {
		Long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		StringBuilder csvText = new StringBuilder();
		
		try {
			OrganizationEntity organization = new OrganizationEntity(organizationId);
			List<ConsultantEntity> consultants = organization.getConsultants();
			
			csvText.append("ORGANIZATION ID");
			csvText.append(",");
			csvText.append("ORGANIZATION NAME");
			csvText.append(",");
			csvText.append("CONSULTANT ID");
			csvText.append(",");
			csvText.append("CONSULTANT FULL NAME");
			csvText.append(",");
			csvText.append("COMPANY ID");
			csvText.append(",");
			csvText.append("COMPANY ID");
			csvText.append(",");
			csvText.append("COMPANY NAME");
			csvText.append(",");
			csvText.append("PRIVATE");
			csvText.append(",");
			csvText.append("EMAIL");
			csvText.append(",");
			csvText.append("ABN");
			csvText.append(",");
			csvText.append("INDUSTRY");
			csvText.append(",");
			csvText.append("STREET 1");
			csvText.append(",");
			csvText.append("STREET 2");
			csvText.append(",");
			csvText.append("SUBURB");
			csvText.append(",");
			csvText.append("COUNTRY");
			csvText.append(",");
			csvText.append("POSTAL CODE");
			csvText.append(",");
			csvText.append("CITY");
			csvText.append(",");
			csvText.append("CONTACT ID");
			csvText.append(",");
			csvText.append("CONTACT FULL NAME");
			csvText.append(",");
			csvText.append("POSITION");
			csvText.append(",");
			csvText.append("PHONE");
			csvText.append(",");
			csvText.append("MOBILE");
			csvText.append(",");
			csvText.append("SKYPE");
			csvText.append(",");
			csvText.append("EMAIL");
			csvText.append(",");
			csvText.append("PERSONAL EMAIL");
			csvText.append("\n");
			
			for (ConsultantEntity consultant : consultants) {
				
				List<ContactEntity> contacts = consultant.getContacts();
				for (ContactEntity contact : contacts) {
					// @Organization
					csvText.append(organization.getOrganizationId()); // ORGANIZATION ID
					csvText.append(",");
					csvText.append(organization.getName()); // ORGANIZATION NAME
					csvText.append(",");
					
					// @Consultant
					csvText.append(consultant.getConsultantId()); // CONSULTANT ID
					csvText.append(",");
					csvText.append(consultant.getFullName()); // CONSULTANT FULL NAME (MANDATORY)
					csvText.append(",");
					
					// @Company
					Enterprise enterprise = contact.getEnterprise();
					csvText.append(enterprise.getEnterpriseId()); // COMPANY ID
					csvText.append(",");
					csvText.append(enterprise.getName()); // COMPANY NAME (MANDATORY IF NOT PRIVATE)
					csvText.append(",");
					csvText.append(enterprise.getIsPrivate()); // PRIVATE (MANDATORY)
					csvText.append(",");
					csvText.append(enterprise.getDescription()); // DESCRIPTION
					csvText.append(",");
					csvText.append(enterprise.getEmail()); // EMAIL
					csvText.append(",");
					csvText.append(enterprise.getTaxid()); // ABN
					csvText.append(",");
					if (enterprise.getIndustry()>0) {
						csvText.append(IndustryLocalServiceUtil.getIndustry(enterprise.getIndustry()).getName()); // INDUSTRY
					}
					csvText.append(",");
					
					ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					List<Address> addressList = AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(), Enterprise.class.getName(), enterprise.getEnterpriseId());
					
					if (addressList != null && !addressList.isEmpty()) {
						csvText.append(addressList.get(0).getStreet1()); // STREET 1 (MANDATORY)
						csvText.append(",");
						csvText.append(addressList.get(0).getStreet2()); // STREET 2
						csvText.append(",");
						csvText.append(addressList.get(0).getStreet3()); // SUBURB
						csvText.append(",");
						csvText.append(addressList.get(0).getCountry().getCountryId()); // COUNTRY (MANDATORY)
						csvText.append(",");
						csvText.append(addressList.get(0).getZip()); // POSTAL CODE (MANDATORY)
						csvText.append(",");
						csvText.append(addressList.get(0).getCity()); // CITY (MANDATORY)
						csvText.append(",");
					}
					
					// @Contact
					csvText.append(contact.getContactId()); // CONTACT ID
					csvText.append(",");
					csvText.append(contact.getName()); // CONTACT FULL NAME (MANDATORY)
					csvText.append(",");
					csvText.append(contact.getPosition()); // POSITION
					csvText.append(",");
					csvText.append(contact.getPhone()); // PHONE
					csvText.append(",");
					csvText.append(contact.getCellPhone()); // MOBILE
					csvText.append(",");
					csvText.append(contact.getSkype()); // SKYPE
					csvText.append(",");
					csvText.append(contact.getEmail()); // EMAIL
					csvText.append(",");
					csvText.append(contact.getPersonalEmail()); // PERSONAL EMAIL
					csvText.append("\n");
				}
				
			}
			
		} catch (Exception e) {
			logger.error("There was a problem when try to export report: " + "companies and contacts", e);
			csvText.append("There was a problem when try to export report: " + "companies and contacts. ERROR: " + e.getMessage());
		}
		
		serveResource(actionRequest, actionResponse, csvText.toString(), "contacts");
	}

	// COMPANY NAME (MANDATORY)	CONTACT FULL NAME (MANDATORY)	CONTRACT DESCRIPTION (MANDATORY)	CONTRACT AMOUNT (MANDATORY)	METHOD (MANDATORY)	STATUS (MANDATORY)	PROGRESS (MANDATORY)	REPORT DATA (MANDATORY)	COMMENTS (MANDATORY)
	public void importContracts(ActionRequest actionRequest, ActionResponse actionResponse) {
		
	}
	
	// COMPANY NAME (MANDATORY)	CONTACT FULL NAME (MANDATORY)	CONTRACT DESCRIPTION (MANDATORY)	CONTRACT AMOUNT (MANDATORY)	METHOD (MANDATORY)	STATUS (MANDATORY)	PROGRESS (MANDATORY)	REPORT DATA (MANDATORY)	COMMENTS (MANDATORY)
	public void exportContracts(ResourceRequest actionRequest, ResourceResponse actionResponse) {
		Long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		
		StringBuilder csvText = new StringBuilder();
		try {
			OrganizationEntity organization = new OrganizationEntity(organizationId);
			
			csvText.append("ORGANIZATION ID");
			csvText.append(",");
			csvText.append("ORGANIZATION NAME");
			csvText.append(",");
			csvText.append("CONSULTANT ID");
			csvText.append(",");
			csvText.append("CONSULTANT FULL NAME");
			csvText.append(",");
			csvText.append("COMPANY ID");
			csvText.append(",");
			csvText.append("COMPANY NAME");
			csvText.append(",");
			csvText.append("CONTACT ID");
			csvText.append(",");
			csvText.append("CONTACT FULL NAME");
			csvText.append(",");
			csvText.append("CONTRACT ID");
			csvText.append(",");
			csvText.append("CONTRACT DESCRIPTION");
			csvText.append(",");
			csvText.append("CONTRACT AMOUNT");
			csvText.append(",");
			csvText.append("METHOD");
			csvText.append(",");
			csvText.append("STATUS");
			csvText.append(",");
			csvText.append("PROGRESS");
			csvText.append(",");
			csvText.append("REPORT DATE");
			csvText.append(",");
			csvText.append("COMMENTS");
			csvText.append("\n");
			
			List<Contract> contracts = ContractLocalServiceUtil.getContractsByOrganization(organizationId); 
			for (Contract contract : contracts) {
				List<Report> reports = ReportLocalServiceUtil.getReportByContract(contract.getContractId());
				for (Report report : reports) {
					
					csvText.append(organization.getOrganizationId()); // ORGANIZATION ID
					csvText.append(",");
					csvText.append(organization.getName()); // ORGANIZATION NAME
					csvText.append(",");
					csvText.append(report.getUserId()); // CONSULTANT ID
					csvText.append(",");
					csvText.append(UserLocalServiceUtil.getUser(report.getUserId()).getFullName()); // CONSULTANT FULL NAME
					csvText.append(",");
					csvText.append(contract.getEnterpriseId()); // COMPANY ID
					csvText.append(",");
					csvText.append(EnterpriseLocalServiceUtil.getEnterprise(contract.getEnterpriseId()).getName()); // COMPANY NAME (MANDATORY)
					csvText.append(",");
					csvText.append(report.getContactId()); // CONTACT ID
					csvText.append(",");
					ContactEntity contact = new ContactEntity(report.getContactId(), report.getUserId());
					csvText.append(contact.getName()); // CONTACT FULL NAME (MANDATORY)
					csvText.append(",");
					csvText.append(report.getContractId()); // CONTRACT ID
					csvText.append(",");
					csvText.append(contract.getDescription()); // CONTRACT DESCRIPTION (MANDATORY)
					csvText.append(",");
					csvText.append(contract.getAmount()); // CONTRACT AMOUNT (MANDATORY)
					csvText.append(",");
					csvText.append(ContactDataMethodLocalServiceUtil.getContactDataMethod(report.getContactMethodId()).getName()); // METHOD (MANDATORY)
					csvText.append(",");
					csvText.append(ContractStatus.getContractStatus(report.getStatus())); // STATUS (MANDATORY)
					csvText.append(",");
					csvText.append(report.getProgress()); // PROGRESS (MANDATORY)
					csvText.append(",");
					csvText.append(dateFormat.format(report.getReportDate())); // REPORT DATE (MANDATORY)
					csvText.append(",");
					csvText.append("\"" + report.getComments() + "\""); // COMMENTS (MANDATORY)
					csvText.append("\n");
				}
			}
		} catch (Exception e) {
			logger.error("There was a problem when try to export report: " + "contracts and reports", e);
			csvText.append("There was a problem when try to export report: " + "contracts and reports. ERROR: " + e.getMessage());
		}
		
		serveResource(actionRequest, actionResponse, csvText.toString(), "contracts-reports");
	}
	
    private void serveResource(ResourceRequest request, ResourceResponse response, String csvText, String reportName) {
    	OutputStream out = null;
    	try {
	    	String fileName = dateFormat.format(new Date()).replace("-", "_").replace(" ", "_") + "_" + reportName.toLowerCase() + ".csv";
	    	byte[] bytes = csvText.getBytes();
	    	response.addProperty( "Content-Disposition", "attachment; filename=\"" + fileName + "\"" );
	    	response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	    	response.setContentType( "application/octet-stream" );
	    	response.setContentLength(bytes.length);
	    	out = response.getPortletOutputStream();
	    	out.write(bytes);
	    	out.flush();
		} catch (IOException e) {
			logger.error("There was a problem when try to export report: " + reportName, e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("Could not close outputstream when export report: " + reportName, e);
				}				
			}
		}
    }
    
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
			
		Integer reportType = ParamUtil.getInteger(resourceRequest, "reportType");
		
		switch (ReportType.getReportType(reportType)) {
		case CONTACT_REPORT:
			exportContacts(resourceRequest, resourceResponse);
			break;
		case CONTRACT_REPORT:
			exportContracts(resourceRequest, resourceResponse);
			break;
		case COMPANIES_REPORT:
			exportCompanies(resourceRequest, resourceResponse);
			break;
		default:
			break;
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	public enum ReportType {
		CONTACT_REPORT(1),
		CONTRACT_REPORT(2),
		COMPANIES_REPORT(2)
		;
		
		private int reportId;
		
		private ReportType(int reportId) {
			this.reportId = reportId;
		}
		
		public int getReportId() {
			return reportId;
		}
		
		public static ReportType getReportType(int reportId) {
			switch (reportId) {
			case 1: return CONTACT_REPORT;
			case 2: return CONTRACT_REPORT;
			case 3: return COMPANIES_REPORT;
			default:
				return CONTACT_REPORT;
			}
		}
	}
	
	private String getCleanedCsvValue(String value, String def) {
		String result = "";
		if (value != null) {
			result = value.trim();
		}
		
		if (result.isEmpty()) {
			result = def;
		}
		
		return result;
	}
	
	public void importReports(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		int row = 1;
		List<String> cutLines = new ArrayList<String>();
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));
			
			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}
			
			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(uploadRequest.getFileAsStream("fileName")));
			
			
			
			String header = reader.readLine(); // READ HEADER
			int columns = header.split(";" ,-1).length;
			columns = 9;
			String nextLine;
			String currentLine = reader.readLine(); // FIRST DATA LINE
			while ((nextLine = reader.readLine()) != null) {
				while (nextLine != null && !nextLine.substring(Math.min(4, nextLine.length()), Math.min(5, nextLine.length())).equals(";")) {
					currentLine += nextLine;
					nextLine = reader.readLine();
				}
				row++;
				
				String[] a = currentLine.split(";", -1);
				
				if (a.length >= columns) {
					
					Long contactId = Long.parseLong(getCleanedCsvValue(a[0], "0"));
					List<Long> userList = AddressBookUserLocalServiceUtil.getUsersHaveContact(contactId);
					if (!userList.isEmpty()) {
						long userId = userList.get(0);
						User user = UserLocalServiceUtil.getUser(userId);
						ContactEntity contactEntity = new ContactEntity(contactId, userId);
						String enterpriseIdParam = String.valueOf(contactEntity.getEnterprise().getEnterpriseId());
						Organization organization = OrganizationUtils.getOrganizationByUser(userId);
						long organizationId = organization.getOrganizationId();
						long companyId = user.getCompanyId();
						String contractDescriptionParam = getCleanedCsvValue(a[1], "-");
						String contractIdParam = null; // obtener o crear
						List<Contract> contractList = ContractLocalServiceUtil.getContractList(userId, contactId, organizationId, contactEntity.getEnterprise().getEnterpriseId());
						if (contractList != null && !contractList.isEmpty()) {
							if (contractList.size() > 1) {
								logger.info("Search contract with description: " + contractDescriptionParam);
								for (Contract c : contractList) {
									logger.info("in: " + c.getDescription());
									if (c.getDescription().equals(contractDescriptionParam)) {
										contractIdParam = String.valueOf(c.getContractId());
										break;
									}
								}
								logger.warn("row["+row+"] Multiple contracts for a Contact: " + contactId + ". Selected contract: " + contractIdParam);
							} else { // == 1
								if (contractList.get(0).getDescription().equals(contractDescriptionParam)) {
									contractIdParam = String.valueOf(contractList.get(0).getContractId());
								} else {
									logger.warn("row["+row+"] Contract already exist but description is not the same. Expected: " + contractDescriptionParam + " but it was: " + contractList.get(0).getDescription());
								}
							}
						}
						String contractAmountParam = getCleanedCsvValue(a[2], "0");
						String contactDataIdParam = getCleanedCsvValue(a[3], "0");
						String statusCode = getCleanedCsvValue(a[4], "COLD").toUpperCase();
						ContactStatusEnum status = ContactStatusEnum.valueOf(statusCode);
						statusCode = String.valueOf(status.getStatusCode());
						String progressParam = getCleanedCsvValue(a[5], "0");
						String reportDateParam = getCleanedCsvValue(a[6], "01/01/1900");
						String commentsParam = getCleanedCsvValue(a[7], "No Comments");
						if (commentsParam.length() >= 500) {
							commentsParam = commentsParam.substring(0, 499);
							cutLines.add(currentLine);
						}
						
						addReport(organizationId, companyId, userId, contractIdParam, contractDescriptionParam, contractAmountParam, String.valueOf(contactId), contactDataIdParam, progressParam, reportDateParam, commentsParam, statusCode, enterpriseIdParam);
						logger.info("row["+row+"] Processed. " + contactId);
					} else {
						logger.warn("row["+row+"] Contact isn't in address book. Contact id: " + contactId);
					}
				} else {
					logger.error("row["+row+"] Incorrect columns for the row: " + currentLine);
					logger.error("Expected " + columns + " but it was  " + a.length);
				}
				
				currentLine = nextLine;
			}
		} catch (Exception e) {
			logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			logger.error("Error when try to inport report. Row: " + row, e);
			logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		logger.info("Rows processed: " + row);
		logger.info("Total Errors:  " + totalErrors);
		logger.info("Cut Lines: " + cutLines.size());
		for (String l : cutLines) {
			logger.info("\t" + l);
		}
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	int totalErrors = 0;
	
	public boolean addReport(long organizationId, long companyId, long userId, String contractIdParam, String contractDescriptionParam, String contractAmountParam,
			String contactIdParam, String contactDataIdParam, String progressParam, String reportDateParam, String commentsParam, String statusCode, String enterpriseIdParam) throws ServletException, IOException {
		try {
			
				Long contractId = ValidationsUtil.existContract(contractIdParam);
				
				List<String> errorList = new ArrayList<String>();
				
				if (contractId == null) {
					ContractValidator.validateContract(contactIdParam, enterpriseIdParam, contractDescriptionParam, contractAmountParam, errorList);
					ReportValidator.validateReport(contactDataIdParam, progressParam, 0d, reportDateParam, null, commentsParam, statusCode, errorList);
				} else {
					Report lastReport = ReportManagerUtils.getLastReport(contractId);
					ReportValidator.validateReport(contactDataIdParam, progressParam, lastReport.getProgress(), reportDateParam, lastReport.getReportDate(), commentsParam, statusCode, errorList);
				}
				
				if (errorList.isEmpty()) {
					
					if (contractId == null) {
						Contract contract = ContractLocalServiceUtil.addContract(
								companyId, 
								Long.parseLong(contactIdParam), 
								Long.parseLong(enterpriseIdParam),
								organizationId, 
								contractDescriptionParam, 
								Double.parseDouble(contractAmountParam));
						
						contractId = contract.getContractId();
						UserContractLocalServiceUtil.addUserContract(userId, contractId, ContractConstants.ACCESS_OWNER);
						logger.info("Contract created.");
					} else {
						ContractLocalServiceUtil.updateAmount(contractId, Double.parseDouble(contractAmountParam));
						logger.info("Contract updated.");
					}
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

					AddressBook addressBookUser = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(userId));
					
					long contactId = Long.parseLong(contactIdParam);
					
					ContactDataText contactName = ContactLocalServiceUtil.getName(contactId, addressBookUser.getAddressBookId());
					
					Report report = ReportLocalServiceUtil.addReport(
							companyId, 
							contractId, 
							Long.parseLong(contactIdParam),
							commentsParam, 
							Long.parseLong(contactDataIdParam),
							Long.parseLong(enterpriseIdParam), 
							organizationId, 
							Double.parseDouble(progressParam), 
							formatter.parse(reportDateParam), 
							Integer.parseInt(statusCode), 
							userId,
							contactName.getContactDataId());
					
					// Contact Data Used as Read Only
					if (report.getContactDataId() > 0) {
						ContactDataLocalServiceUtil.setReadOnly(report.getContactDataId(), true);
					}

					// Contact Name as Read Only
					ContactDataLocalServiceUtil.setReadOnly(contactName.getContactDataId(), true);
					
					// Contact Enterprise
					ContactDataRef contactEnterprise = ContactLocalServiceUtil.getEnterprise(report.getContactId(), addressBookUser.getAddressBookId());
					ContactDataLocalServiceUtil.setReadOnly(contactEnterprise.getContactDataId(), true);
					
					logger.info("Report created.");
					
					return true;
				} else {
					for (String error : errorList) {
						logger.error(error);
						logger.info("Comments: " + commentsParam.length());
					}
					totalErrors++;
					return false;
				}
		} catch (Exception e) {
			logger.error("Unexpected error when try to add report", e);
			return false;
		}
	}
	
	/** New Implementation of importing reports
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void newImportReports(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int row = 1;
		totalErrors = 0;
		
		List<String> cutLines = new ArrayList<String>();
		
		try {
			final String[] EXPECTED_HEADERS = {"ID","ClientFinder","Organization","Private","IndustryType","Company Field Description","Source","ContactName","Position","Email","Phone","Mobile","Address","StreetName","Town","State","ContractValue","Method, leave blank","Status","LeadIntensity","Status Leave blank ","DateCreated","Comments","DateNextFollowUp","Time of next follow up (leave Blank)","Detail"};
			final long DEFAULT_COUNTRY_ID = CountryServiceUtil.getCountryByA3("AUS").getCountryId();
			final String DEFAULT_LEAD_NAME = "Imported Lead";
			final DateFormat reportDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			final DateFormat reportDateFormat2 = new SimpleDateFormat("dd/MM/yy");
			final DateFormat reportDateFormat3 = new SimpleDateFormat("dd/M/yy");
			final DateFormat createDateFormat1 = new  SimpleDateFormat("MM/dd/yyyy");
			
			ContactDataMethod cellPhoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.CELL_PHONE.getMethodName());
			ContactDataMethod emailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.EMAIL.getMethodName());
			
		    long orgId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
			
		    List<AddressBookUser> aBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
		    if (aBookUserList == null || aBookUserList.size() == 0) {
		    	logger.error("User has no address book to import");
				SessionErrors.add(actionRequest, "User has no address book to import");
				return;
		    }
		    AddressBookUser aBookUser = aBookUserList.get(0);
		    
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			logger.info("Uploading new reports with file size: " + uploadRequest.getSize("fileName"));
			
			if (uploadRequest.getSize("fileName") == 0) {
				SessionErrors.add(actionRequest, "error");
				return;
			}
			
			logger.info("Upload file name:" + uploadRequest.getFileName("fileName"));
			
			File file = uploadRequest.getFile("fileName");
			
			Reader r = new FileReader(file);
			CSVReader csvReader = new CSVReader(r, ',');
			
			// read header and compare it with expected headers
			String[] headers = csvReader.readNext();
			
			if (!ArrayUtils.isEquals(EXPECTED_HEADERS,headers)) {
				logger.error("Headers not match");
				logger.error("Expected " + ArrayUtils.toString(EXPECTED_HEADERS));
				logger.error("Loaded   " + ArrayUtils.toString(headers));
				
				SessionErrors.add(actionRequest, "Headers does not match required headers");
				return;
			}
			
			String [] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				row++;
				try {
				    String iD = StringUtils.trim(nextLine[0]);
				    String clientFinder = StringUtils.trim(nextLine[1]);
				    String organization = StringUtils.trim(nextLine[2]);
				    String privateFlag = StringUtils.trim(nextLine[3]);
				    String industryType = StringUtils.trim(nextLine[4]);
				    String companyFieldDescription  = StringUtils.trim(nextLine[5]);
				    String source = StringUtils.trim(nextLine[6]);
				    String contactName = StringUtils.trim(nextLine[7]);
				    String position = StringUtils.trim(nextLine[8]);
				    String email = StringUtils.trim(nextLine[9]);
				    String phone = StringUtils.trim(nextLine[10]);
				    String mobile = StringUtils.trim(nextLine[11]);
				    String address = StringUtils.trim(nextLine[12]);
				    String streetName = StringUtils.trim(nextLine[13]);
				    String town = StringUtils.trim(nextLine[14]);
				    String state = StringUtils.trim(nextLine[15]);
				    String contractValue = StringUtils.trim(nextLine[16]);
				    String method = StringUtils.trim(nextLine[17]);
				    String status = StringUtils.trim(nextLine[18]);
				    String leadIntensity = StringUtils.trim(nextLine[19]);
				    String statusLeaveBlank = StringUtils.trim(nextLine[20]);
				    String dateCreated = StringUtils.trim(nextLine[21]);
				    String comments = StringUtils.trim(nextLine[22]);
				    String dateNextFollowUp = StringUtils.trim(nextLine[23]);
				    String timeNextFollowUp = StringUtils.trim(nextLine[24]);
				    String detail = StringUtils.trim(nextLine[25]);
				    
				    logger.info("======================================");
				    logger.info("Importing report " + contactName + " from " + organization + " on " + dateCreated);
				    
				    // create enterprise (if required)
				    // try to find enterprise
				    Enterprise enterprise = null;
				    List<Enterprise> enterprises = EnterpriseLocalServiceUtil.findByName(organization);
				    if (enterprises.size() > 1) {
				    	logger.warn("Found several enterprises with name " + organization + " . First will be used");
				    }
				    if (enterprises.size() > 0) {
				    	enterprise = enterprises.get(0);
				    	logger.info("Found Enterprise " + organization + " + , Enterprise ID: " + enterprise.getEnterpriseId());
				    }
				    
				    if (enterprise == null) {
				    	logger.info("Enterprise " + organization + " not found -> create");
					    // create enterprise ( it is not exists)
				    	// TODO - industry - check codes mapping
				    	// TODO - test for private
				    	// TODO - zip
					    enterprise = EnterpriseLocalServiceUtil.addEnterprise(themeDisplay.getCompanyId(), themeDisplay.getUserId(), organization, (String)null /*taxId*/, String.valueOf(DEFAULT_COUNTRY_ID), companyFieldDescription, email, "0" /* industry */, streetName, address, (String)null /*street3*/, "000" /*zipCode*/, town, false);
				    	logger.info("Created Enterprise " + organization + " + , Enterprise ID: " + enterprise.getEnterpriseId());
				    }				    
				    
				    // create contact (if required)
				    // try to find contact by name
				    Contact contact = ContactLocalServiceUtil.findByName(themeDisplay.getUserId(), aBookUser.getAddressBookId(), enterprise.getEnterpriseId(), contactName);
				    
				    if (contact == null) {
				    	// contact not found - create new
				    	logger.info("Contact for " + contactName + " not found, create new");
				    	List<String> errorList = new ArrayList<String>();
				    	
				    	contact = createContact(themeDisplay.getCompanyId(), themeDisplay.getUserId(), enterprise.getEnterpriseId(), aBookUser.getAddressBookId(), errorList, row, contactName, mobile, null, email, null, position, null /*homePhone*/, null /*homePhoneExt*/, null /*personalEmail*/);
				    	logger.info("Created contact " + contactName + ", ID " + contact.getContactId()); 
				    } else {
				    	logger.info("Found contact " + contactName + ", ID " + contact.getContactId());
				    }
				    
				    double amount = 0.0;
				    try {
				    	amount = Double.valueOf(contractValue);
				    } catch (Exception ex) {}
				    
				    // create contract (if not exist yet)
				    Contract contract = ContractLocalServiceUtil.findByName(themeDisplay.getUserId(), contact.getContactId(), orgId, enterprise.getEnterpriseId(), DEFAULT_LEAD_NAME);
				    if (contract == null) {
				    	logger.info("Contract not found - create new");
				    	contract = ContractLocalServiceUtil.addContract(themeDisplay.getCompanyId(), contact.getContactId(), enterprise.getEnterpriseId(), orgId, DEFAULT_LEAD_NAME, amount);
				    	
				    	long contractId = contract.getContractId();
						UserContractLocalServiceUtil.addUserContract(themeDisplay.getUserId(), contractId, ContractConstants.ACCESS_OWNER);
				    } else {
				    	logger.info("Contract Exists");
				    }
				    
				    
				    // finally - add report!!!
				    
				    // get createDate
				    Date createDate = null;
				    // try to parse create date
				    try {
				    	createDate = createDateFormat1.parse(dateCreated); 
				    } catch (Exception ex) {} // ignore date parsing error
				    
				    if (createDate == null) {
				    	// use current date if not parsed
				    	createDate = new Date();
				    }
				    
				    // try to parse comments to extract date
				    String reportComment = comments;
				    Date reportDate = null;
				    
				    String[] commentParts = comments.split("-");
				    if (commentParts.length > 1) {
				    	// get first part and try to parse it
				    	try {
				    		reportDate = reportDateFormat1.parse(StringUtils.trim(commentParts[0]));
				    	} catch (Exception ex) {} // just ignore it here
				    	
				    	if (reportDate == null) {
				    		// try second format
					    	try {
					    		reportDate = reportDateFormat2.parse(StringUtils.trim(commentParts[0]));
					    	} catch (Exception ex) {} // just ignore it here
				    	}
				    	if (reportDate == null) {
				    		// try third format
					    	try {
					    		reportDate = reportDateFormat3.parse(StringUtils.trim(commentParts[0]));
					    	} catch (Exception ex) {} // just ignore it here
				    	}
				    	
				    	if (reportDate != null) {
				    		// merge rest parts back into comments
				    		reportComment = StringUtils.join(ArrayUtils.subarray(commentParts, 1, commentParts.length),"-");
				    	}
				    }
				    
				    if (reportDate == null) {
				    	reportDate = createDate;
				    }
				    
				    ContactDataText contactNameData = ContactLocalServiceUtil.getName(contact.getContactId(), aBookUser.getAddressBookId());
				    
				    long contactDataId = 0l;
				    if (StringUtils.isNotBlank(mobile)) {
				    	ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(aBookUser.getAddressBookId(), contact.getContactId(), cellPhoneContactDataMethod.getContactDataMethodId());
				    	if (contactData != null) {
				    		contactDataId = contactData.getContactDataId();
				    	}
				    } else {
				    	// use email
				    	ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(aBookUser.getAddressBookId(), contact.getContactId(), emailContactDataMethod.getContactDataMethodId());
				    	if (contactData != null) {
				    		contactDataId = contactData.getContactDataId();
				    	}
				    }
				    
				    // parse status
				    ContractStatus contractStatus = ContractStatus.getContractStatus(leadIntensity);
				    
				    
				    ReportLocalServiceUtil.addReport(themeDisplay.getCompanyId(), contract.getContractId(), contact.getContactId(), StringUtils.substring(reportComment, 0, 500), contactDataId, enterprise.getEnterpriseId(), orgId, 0.0, reportDate, contractStatus.getPow(), themeDisplay.getUserId(), contactNameData.getContactDataId(), createDate);
				} catch (Exception ex) {
					logger.error("Cannot process row " + row, ex);
					totalErrors++;
				}
			}
		} catch (Exception ex) {
			logger.error("Error during importing reports", ex);
			return;
		}
		
		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		logger.info("Rows processed: " + row);
		logger.info("Total Errors:  " + totalErrors);
		logger.info("Cut Lines: " + cutLines.size());
		for (String l : cutLines) {
			logger.info("\t" + l);
		}
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}
	
	
	private Contact createContact(long companyId, long userId, long enterpriseId,long addressBookId, List<String> errorList, int row, 
		String fullName, String cellPhone, String cellPhoneExt, String workEmail, String skype, String position, String homePhone, String homePhoneExt, String personalEmail) throws SystemException, PortalException {
	
		if (ValidationsUtil.validateAditionalInfo(userId, -1, enterpriseId, 
			fullName, cellPhone, cellPhoneExt, workEmail, skype, position, homePhone, homePhoneExt, personalEmail, errorList)) {
			
			Contact contact = ContactLocalServiceUtil.addContact(companyId);
			long contactId = contact.getContactId();
		 
			AddressBookContact addressBookContact = new AddressBookContactImpl();
			addressBookContact.setCompanyId(companyId);
			addressBookContact.setContactId(contact.getContactId());
			addressBookContact.setAddressBookId(addressBookId);
			AddressBookContactLocalServiceUtil.addAddressBookContact(addressBookContact);
			
			ContactDataMethod enterpriseContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
			ContactDataRefLocalServiceUtil.updateContactDataRef(contactId, enterpriseContactDataMethod, String.valueOf(enterpriseId), addressBookId, companyId);
			
			ContactDataMethod nameContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
			ContactDataTextLocalServiceUtil.updateContactDataText(contactId, nameContactDataMethod, fullName, addressBookId, companyId);
		
			ContactDataMethod cellPhoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.CELL_PHONE.getMethodName());
			ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, cellPhoneContactDataMethod, cellPhone, cellPhoneExt, addressBookId, companyId);
			
			ContactDataMethod phoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PHONE.getMethodName());
			ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactId, phoneContactDataMethod, homePhone, homePhoneExt, addressBookId, companyId);
			
			ContactDataMethod skypeContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.SKYPE.getMethodName());
			ContactDataTextLocalServiceUtil.updateContactDataText(contactId, skypeContactDataMethod, skype, addressBookId, companyId);
			
			ContactDataMethod emailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.EMAIL.getMethodName());
			ContactDataTextLocalServiceUtil.updateContactDataText(contactId, emailContactDataMethod, workEmail, addressBookId, companyId);
			
			ContactDataMethod personalEmailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName());
			ContactDataTextLocalServiceUtil.updateContactDataText(contactId, personalEmailContactDataMethod, personalEmail, addressBookId, companyId);
			
			ContactDataMethod positionContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.POSITION.getMethodName());
			ContactDataTextLocalServiceUtil.updateContactDataText(contactId, positionContactDataMethod, position, addressBookId, companyId);
			
			return contact;
		} else {
			String errorMessage = "";
			for (String error : errorList) {
				errorMessage += "|";
				errorMessage += error;
			}
			logger.error("[" + row + "] Errors (" + errorMessage + ").");
		}

		
		return null;
	}
}
