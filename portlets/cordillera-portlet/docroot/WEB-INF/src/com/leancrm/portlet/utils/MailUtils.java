package com.leancrm.portlet.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.liferay.mail.service.MailService;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class MailUtils {

	private static Logger logger = Logger.getLogger(MailUtils.class);
	
//	private static final String WEBMASTER_EMAIL_ADDRESS = "webmaster@ourdrugrep.com";
//	private static final String WEBMASTER_FROM = "OurDrugRep.com";
	
	private static final String USER_NAME = "${USER_NAME}";
	private static final String MEMBER_FULL_NAME = "${MEMBER_FULL_NAME}";
	private static final String ORGANIZATION_NAME = "${ORGANIZATION_NAME}";
	
	private static final String COMPANY_NAME = "${COMPANY_NAME}";
	private static final String CONTACT_NAME = "${CONTACT_NAME}";
	private static final String CONTRACT_NAME = "${CONTRACT_NAME}";
	private static final String CONTRACT_PROGRESS = "${CONTRACT_PROGRESS}";
	private static final String CONTRACT_STATUS = "${CONTRACT_STATUS}";
	private static final String LEAD_ACCESS_LEVEL = "${LEAD_ACCESS_LEVEL}";

	public static final boolean USE_EMAIL_TEST = false;
	public static final String TEST_EMAIL = "dgmonzon@gmail.com";
	public static final String TEST_NAME = "Gaston Monzon Test";
	
	private enum Posting {
		EMAIL,
		FILE;
	}
	
	private static Posting testPosting = Posting.EMAIL;
	
	private static InternetAddress getRecipient(String email, String name) throws UnsupportedEncodingException {
		if (USE_EMAIL_TEST) {
			return new InternetAddress(TEST_EMAIL, TEST_NAME);
		} else {
			return new InternetAddress(email, name);
		}
	}
	
	private static void sendHtmlEmail(InternetAddress from, InternetAddress to, String title, String body) {
		sendEmail(from, to, title, body, true);
	}
	
	private static void sendEmail(InternetAddress from, InternetAddress to, String title, String body, boolean htmlFormat) {
		if (testPosting.equals(Posting.EMAIL)) {
			MailMessage message = new MailMessage(from, to , title, body, htmlFormat);
			
			MailService mailService =	MailServiceUtil.getService();
			mailService.sendEmail(message);
		} else if (testPosting.equals(Posting.FILE)) {
			try {
				BufferedWriter buffer = null;
				String longDate = String.valueOf(Calendar.getInstance().getTimeInMillis());
				String normalTitle = title.replace(" ", "").toLowerCase();
				String toEmail = to.getAddress().substring(0, to.getAddress().indexOf("@"));
				buffer = new BufferedWriter(new FileWriter(new File("/Users/gaston/segmax/ourdrugrep/temp/"+longDate+"_"+normalTitle+"_"+toEmail+".htm")));
				buffer.write(body);
				buffer.flush();
				buffer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Read and return an email template.
	 * 
	 * @param templateName
	 * @return
	 * @throws IOException
	 */
	private static String getEmailTemplate(String templateName) throws IOException {
		InputStream emailTemplate = MailUtils.class.getResourceAsStream("/content/" + templateName + ".html");
		BufferedReader reader = new BufferedReader(new InputStreamReader(emailTemplate));
		
		StringBuilder template = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			template.append(line);
			line = reader.readLine();
		}
		
		return template.toString();
	}
	
	public static void sendRequestToBeMember(User admin, User member, Organization organization) {
		try {
			InternetAddress from = new InternetAddress("support@cymplar.com", "cymplar.com");
			InternetAddress to = getRecipient(admin.getEmailAddress(), admin.getFullName());
			
			String title = "Member Request";
			
			String body = getEmailTemplate("templateRequestToBeMemberEmail");
			
			body = body.replace(USER_NAME, admin.getFirstName());
			body = body.replace(MEMBER_FULL_NAME, member.getFullName());
			body = body.replace(ORGANIZATION_NAME, organization.getName());
			// get lead access level name
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with member request sent to adminstrator " + admin.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request be member.", e);
		}
	}

	
	public static void sendRequestToLead(User leadOwner, User member, Contract contract, int leadAccess) {
		try {
			InternetAddress from = new InternetAddress("support@cymplar.com", "cymplar.com");
			InternetAddress to = getRecipient(leadOwner.getEmailAddress(), leadOwner.getFullName());
			
			String title = "Request to Lead";
			
			String body = getEmailTemplate("templateRequestToLead");
			
			body = body.replace(USER_NAME, leadOwner.getFirstName());
			body = body.replace(MEMBER_FULL_NAME, member.getFullName());
			body = body.replace(CONTRACT_NAME, contract.getDescription());
			// get lead access level name
			String accessLevel = "";
			
			switch (leadAccess) {
				case ContractConstants.ACCESS_OWNER: {
					accessLevel = "Owner";
					break;
				}
				case ContractConstants.ACCESS_CONTRIBUTE: {
					accessLevel = "Contribute";
					break;
				}
				case ContractConstants.ACCESS_READ: {
					accessLevel = "Read";
					break;
				}
			}
			body = body.replace(LEAD_ACCESS_LEVEL, accessLevel);
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with request to lead was sent to " + leadOwner.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request to leaad.", e);
		}
	}
	
	public static void leadShared(User userReceiver, User whoShared, Contract lead, int leadAccess) {
		try {
			Report report = ReportLocalServiceUtil.getLastReport(lead.getContractId());
			Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(lead.getEnterpriseId());
			ContactStatusEnum status = ContactStatusEnum.getStatus(report.getStatus());
			
			AddressBook addressBook = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(report.getUserId()));
			ContactDataMethod contactDataName = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
			ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), lead.getContactId(), contactDataName.getContactDataMethodId());
			String contactName = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
			
			InternetAddress from = new InternetAddress("support@cymplar.com", "cymplar.com");
			InternetAddress to = getRecipient(userReceiver.getEmailAddress(), userReceiver.getFullName());
			
			String title = "New lead shared with you";
			
			String body = getEmailTemplate("templateLeadShared");
			
			body = body.replace(USER_NAME, userReceiver.getFirstName());
			body = body.replace(MEMBER_FULL_NAME, whoShared.getFullName());
			
			body = body.replace(COMPANY_NAME, enterprise.getName());
			body = body.replace(CONTACT_NAME, contactName);
			body = body.replace(CONTRACT_NAME, lead.getDescription());
			body = body.replace(CONTRACT_PROGRESS, report.getProgress() + "%");
			body = body.replace(CONTRACT_STATUS, status.name());
			
			// get lead access level name
			String accessLevel = "";
			
			switch (leadAccess) {
				case ContractConstants.ACCESS_OWNER: {
					accessLevel = "Owner";
					break;
				}
				case ContractConstants.ACCESS_CONTRIBUTE: {
					accessLevel = "Contribute";
					break;
				}
				case ContractConstants.ACCESS_READ: {
					accessLevel = "Read";
					break;
				}
			}
			body = body.replace(LEAD_ACCESS_LEVEL, accessLevel);
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with lead sharing information was sent to " + userReceiver.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request to leaad.", e);
		}
	}
	
	public static void ownershipMoved(User userReceiver, User whoDid, Contract lead) {
		try {
			InternetAddress from = new InternetAddress("support@cymplar.com", "cymplar.com");
			InternetAddress to = getRecipient(userReceiver.getEmailAddress(), userReceiver.getFullName());
			
			String title = "Lead moved";          
			
			String body = getEmailTemplate("templateLeadOwnershipMoved");
			
			body = body.replace(USER_NAME, userReceiver.getFirstName());
			body = body.replace(MEMBER_FULL_NAME, whoDid.getFullName());
			body = body.replace(CONTRACT_NAME, lead.getDescription());
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with lead ownership trasfer information was sent to " + userReceiver.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request to leaad.", e);
		}
	}
	
	public static void leadChanged(User userReceiver, User whoChanged, Contract lead, Report report) {
		try {
			ContactStatusEnum status = ContactStatusEnum.getStatus(report.getStatus());

			InternetAddress from = new InternetAddress("support@cymplar.com", "cymplar.com");
			InternetAddress to = getRecipient(userReceiver.getEmailAddress(), userReceiver.getFullName());
			
			String title = "Lead changed";          
			
			String body = getEmailTemplate("templateLeadChanged");
			
			body = body.replace(USER_NAME, userReceiver.getFirstName());
			body = body.replace(MEMBER_FULL_NAME, whoChanged.getFullName());

			body = body.replace(CONTRACT_NAME, lead.getDescription());
			body = body.replace(CONTRACT_PROGRESS, report.getProgress() + "%");
			body = body.replace(CONTRACT_STATUS, status.name());
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with lead ownership trasfer information was sent to " + userReceiver.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request to leaad.", e);
		}
	}
}
