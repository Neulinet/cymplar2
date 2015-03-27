package com.leancrm.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.utils.ConstantDefinitions;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Colleague
 */
public class Colleague extends MVCPortlet {
 
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void updateRole(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
			boolean hasAdminPermission = permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), Role.class.getName(), PortalUtil.getUser(actionRequest).getCompanyId(), ActionKeys.ASSIGN_MEMBERS);
			
			if (hasAdminPermission) {
				long userId = ParamUtil.getLong(actionRequest, "userId");
				boolean companyAdministrator = ParamUtil.getBoolean(actionRequest, "companyAdministrator");
				boolean companyConsultant = ParamUtil.getBoolean(actionRequest, "companyConsultant");
				
				if (companyAdministrator && !RoleLocalServiceUtil.hasUserRole(userId, 11855)) {
					RoleLocalServiceUtil.addUserRoles(userId, new long[] { 11855 });
				} else if (!companyAdministrator && RoleLocalServiceUtil.hasUserRole(userId, 11855)) {
					UserLocalServiceUtil.deleteRoleUser(11855, userId);
				}
				
				if (companyConsultant && !RoleLocalServiceUtil.hasUserRole(userId, 12023)) {
					RoleLocalServiceUtil.addUserRoles(userId, new long[] { 12023 });
				} else if (!companyConsultant && RoleLocalServiceUtil.hasUserRole(userId, 12023)) {
					UserLocalServiceUtil.deleteRoleUser(12023, userId);
				}
				
				SessionMessages.add(actionRequest, "Role updated successfully");
			} else {
				// TODO
				SessionErrors.add(actionRequest, "error permission");
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/colleague/view.jsp");
	}
	
	public void showAssignRole(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			long userId = ParamUtil.getLong(actionRequest, "userId");
			String userEmail = ParamUtil.getString(actionRequest, "userEmail");
			
			actionRequest.setAttribute("userId", userId);
			actionRequest.setAttribute("userEmail", userEmail);
			
			SessionMessages.add(actionRequest, "");
			
			actionResponse.setRenderParameter("jspPage", "/html/colleague/assignRoles.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeColleague(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		try {
			List<Organization> organizationList = OrganizationLocalServiceUtil.getUserOrganizations(userId);
			for (Organization organization: organizationList) {
				UserUtil.removeOrganization(userId, organization.getOrganizationId());
			}
			
			// this is temporal until found a better solution for thoses static user groups
			if (ValidationsUtil.isUserGroup(ConstantDefinitions.REGULAR_USER_GROUP_ID)) {
				UserGroup regularUserGroup = UserGroupLocalServiceUtil.getUserGroup(ConstantDefinitions.REGULAR_USER_GROUP_ID);
				UserLocalServiceUtil.deleteUserGroupUser(regularUserGroup.getUserGroupId(), userId);
			} else {
				logger.error("Error when try to add a user (" + userId+ ") in the regular uset group.");
			}
			
			if (ValidationsUtil.isUserGroup(ConstantDefinitions.REGISTER_ONLY_GROUP_ID)) {
				UserGroup registerOnlyGroup = UserGroupLocalServiceUtil.getUserGroup(ConstantDefinitions.REGISTER_ONLY_GROUP_ID);
				UserLocalServiceUtil.addUserGroupUsers(registerOnlyGroup.getUserGroupId(), new long[] { userId });
			} else {
				logger.error("Error when try to add a user (" + userId + ") in the regular uset group.");
			}
			
			UserLocalServiceUtil.deleteRoleUser(11855, userId);
			UserLocalServiceUtil.addRoleUsers(12845, new long[] { userId });
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SessionMessages.add(actionRequest, "Role updated successfully");
		actionResponse.setRenderParameter("jspPage", "/html/colleague/view.jsp");
	}
}
