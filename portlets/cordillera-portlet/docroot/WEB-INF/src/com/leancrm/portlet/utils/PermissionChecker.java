package com.leancrm.portlet.utils;

import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;


public class PermissionChecker {
	
	/** Check - is user is administrator of Organization
	 * 
	 * @param consultant
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean isOrganizationAdmin(User consultant) throws PortalException, SystemException {
		Organization org = OrganizationUtils.getOrganizationByUser(consultant.getUserId());
		
		return UserGroupRoleLocalServiceUtil.hasUserGroupRole(consultant.getUserId(), org.getGroupId(), RoleConstants.ORGANIZATION_OWNER) || UserGroupRoleLocalServiceUtil.hasUserGroupRole(consultant.getUserId(), org.getGroupId(), RoleConstants.ORGANIZATION_ADMINISTRATOR); 
	}
	
	/** Checks, does specified user may leave new actions on the contract or not
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
