package com.leancrm.portlet.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;

public class PermissionChecker {

	public static boolean isOrganizationAdmin(User consultant) throws PortalException, SystemException {
		return RoleServiceUtil.hasUserRole(consultant.getUserId(), consultant.getCompanyId(), "Company Administrator", true);
	}
}
