package com.leancrm.portlet;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.leancrm.portlet.invitationcolleagues.util.InvitationUtil;
import com.leancrm.portlet.utils.OrganizationCode;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationColleagues
 */
public class InvitationColleagues extends MVCPortlet {
 

	public void sendInvitations(ActionRequest actionRequest, ActionResponse actionResponse) {
		Set<String> invalidEmailAddresses = new HashSet<String>();
		Set<String> validEmailAddresses = new HashSet<String>();
		
		try {
			
			int emailMessageMaxRecipients =
				InvitationUtil.getEmailMessageMaxRecipients();
			
			for (int i = 0; i < emailMessageMaxRecipients; i++) {
				String emailAddress = ParamUtil.getString(
					actionRequest, "emailAddress" + i);
				
				if (Validator.isEmailAddress(emailAddress)) {
					validEmailAddresses.add(emailAddress);
				}
				else if (Validator.isNotNull(emailAddress)) {
					invalidEmailAddresses.add("emailAddress" + i);
				}
			}
			
			if (validEmailAddresses.isEmpty() && invalidEmailAddresses.isEmpty()) {
				invalidEmailAddresses.add("emailAddress0");
			}
			
			if (!invalidEmailAddresses.isEmpty()) {
				SessionErrors.add(
					actionRequest, "emailAddresses", invalidEmailAddresses);
	
				return;
			}
	
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
	
			User user = themeDisplay.getUser();
	
			String fromAddress = user.getEmailAddress();
			String fromName = user.getFullName();
	
			String organizationName = "";
			long organizationId = 0;
			List<Organization> organizationList;
			
			organizationList = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());

			if (organizationList != null && !organizationList.isEmpty()) {
				organizationName = organizationList.get(0).getName();
				organizationId = organizationList.get(0).getOrganizationId();
			}
			
			InternetAddress from = new InternetAddress(fromAddress, fromName);
	
			Layout layout = themeDisplay.getLayout();
	
			String portalURL = PortalUtil.getPortalURL(actionRequest);
	
			String layoutFullURL = PortalUtil.getLayoutFullURL(
				layout, themeDisplay);
			
			String portletId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			
			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					actionRequest, portletId);
	
			String subject = InvitationUtil.getEmailMessageSubject(preferences);
			String body = InvitationUtil.getEmailMessageBody(preferences);
			
			String code = OrganizationCode.encode(organizationId);
			
			if (code != null) {
			
				subject = StringUtil.replace(
					subject,
					new String[] {
						"[$FROM_ADDRESS$]", "[$FROM_NAME$]", "[$PAGE_URL$]",
						"[$PORTAL_URL$]", "[$COMPANY_NAME$]", "[$COMPANY_CODE$]"
					},
					new String[] {
						fromAddress, fromName, layoutFullURL, portalURL, organizationName, code
					});
		
				body = StringUtil.replace(
					body,
					new String[] {
						"[$FROM_ADDRESS$]", "[$FROM_NAME$]", "[$PAGE_URL$]",
						"[$PORTAL_URL$]", "[$COMPANY_NAME$]", "[$COMPANY_CODE$]"
					},
					new String[] {
						fromAddress, fromName, layoutFullURL, portalURL, organizationName, code
					});
		
				for (String emailAddress : validEmailAddresses) {
					InternetAddress to = new InternetAddress(emailAddress);
		
					MailMessage message = new MailMessage(
						from, to, subject, body, true);
		
					MailServiceUtil.sendEmail(message);
				}
		
		
				SessionMessages.add(actionRequest, "invitationSent");
			} else {
				SessionErrors.add(actionRequest, "invalid-organization-generate-code-key");
			}
			actionResponse.setRenderParameter("jspPage", "/html/invitationcolleagues/view.jsp");
		
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "");
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
