package com.leancrm.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.leancrm.portlet.utils.ConstantDefinitions;
import com.leancrm.portlet.utils.CustomFieldUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OrganizationRequest
 */
public class OrganizationRequest extends MVCPortlet {
	

	public void acceptUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		User pendingUser;
		try {
			pendingUser = UserLocalServiceUtil.getUser(userId);
			long organizationId = CustomFieldUtils.getCustomValue(pendingUser.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, userId);
			
			if (organizationId != 0) {
				UserLocalServiceUtil.addOrganizationUsers(organizationId, new long[] { pendingUser.getUserId() });
				CustomFieldUtils.setCustomValue(pendingUser.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, userId, 0);
				
				UserGroup regularUserGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGULAR_USER_GROUP_NAME);
				UserLocalServiceUtil.addUserGroupUsers(regularUserGroup.getUserGroupId(), new long[] { pendingUser.getUserId() });
				UserGroup registerOnlyGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGISTER_ONLY_GROUP_NAME);
				UserLocalServiceUtil.deleteUserGroupUser(registerOnlyGroup.getUserGroupId(), pendingUser.getUserId());
				
				Role companyConsultantRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), ConstantDefinitions.ROLE_COMPANY_CONSULTANT);
				RoleLocalServiceUtil.addUserRoles(userId, new long[] { companyConsultantRole.getRoleId() });
				
			}
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getMessage());
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/organizationrequest/view.jsp");
	}
	
	public void ignoreUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = ParamUtil.getLong(actionRequest, "userId");
		User pendingUser;
		try {
			pendingUser = UserLocalServiceUtil.getUser(userId);
			CustomFieldUtils.setCustomValue(pendingUser.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, userId, 0);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getMessage());
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/organizationrequest/view.jsp");
	}
}
