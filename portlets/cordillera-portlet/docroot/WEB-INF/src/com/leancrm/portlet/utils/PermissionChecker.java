package com.leancrm.portlet.utils;

import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;

public class PermissionChecker {

	public static boolean isOrganizationAdmin(User consultant) throws PortalException, SystemException {
		return RoleServiceUtil.hasUserRole(consultant.getUserId(), consultant.getCompanyId(), "Company Administrator", true);
	}
	
	/** Checks, does soecified user may leave new actions on the contract or not
	 * 
	 * @param contractId
	 * @param consultant
	 * @return
	 */
	public static boolean canCommentContract(long contractId, User consultant) {
		UserContract userContract = UserContractLocalServiceUtil.getByUserContract(consultant.getUserId(), contractId);
		
		if (userContract != null && (userContract.getAccessLevel() == ContractConstants.ACCESS_CONTRIBUTE || userContract.getAccessLevel() == ContractConstants.ACCESS_OWNER)) {
			// only owners or users with contribute permission can leave new comments on contract
			return true;
		} else {
			return false;
		}
		
	}
}
