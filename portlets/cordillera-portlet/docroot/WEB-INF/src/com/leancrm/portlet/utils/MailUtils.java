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

import com.liferay.mail.service.MailService;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;

public class MailUtils {

	private static Logger logger = Logger.getLogger(MailUtils.class);
	
//	private static final String WEBMASTER_EMAIL_ADDRESS = "webmaster@ourdrugrep.com";
//	private static final String WEBMASTER_FROM = "OurDrugRep.com";
	
	private static final String USER_NAME = "${USER_NAME}";
	private static final String MEMBER_FULL_NAME = "${MEMBER_FULL_NAME}";
	private static final String ORGANIZATION_NAME = "${ORGANIZATION_NAME}";

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
			
			sendHtmlEmail(from, to, title, body);
			
			logger.info("Email with member request sent to adminstrator " + admin.getUserId());
		} catch (Exception e) {
			logger.error("Error when tried to send an email to request be member.", e);
		}
	}
	
}
