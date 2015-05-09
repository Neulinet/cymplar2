package com.leancrm.portlet.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class OrganizationUtils {
	private static Logger logger = Logger.getLogger(OrganizationUtils.class);
	
	/** Get organization for user. Currently we expect that user is related to only one organization
	 * 
	 * @param userId
	 * @return
	 */
	public static Organization getOrganizationByUser(long userId) {
		try {
			List<Organization> organizationList = OrganizationLocalServiceUtil.getUserOrganizations(userId);
			if (organizationList != null && !organizationList.isEmpty()) {
				return organizationList.get(0);
			}
		} catch (SystemException e) {
			logger.error("Canot get user organization for user " + userId, e);
		}
		
		return null;
	}
	
	/* Get Organization Admins - users with ORGANIZATION_ADMIN and ORGANIZATION_OWNER roles
	 * 
	 */
	public static Collection<User> getOrganizationAdmin(long organizationId) throws PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		Role orgOwner = RoleLocalServiceUtil.getRole(organization.getCompanyId(), RoleConstants.ORGANIZATION_OWNER);
		Role orgAdmin = RoleLocalServiceUtil.getRole(organization.getCompanyId(), RoleConstants.ORGANIZATION_ADMINISTRATOR);
		
		Set<User> adminUsers = new HashSet<User>();

		// add all org owners
		for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(organization.getGroupId(), orgOwner.getRoleId())) {
			adminUsers.add(ugr.getUser());
		}
		
		// and add all org admins
		for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(organization.getGroupId(), orgAdmin.getRoleId())) {
			adminUsers.add(ugr.getUser());
		}
		
		return adminUsers;
	}
	
	public static List<User> getConsultants(long organizationId) {
		List<User> consultantsList = new ArrayList<User>();
		List<User> userOrganizationList;
		try {
			userOrganizationList = UserLocalServiceUtil.getOrganizationUsers(organizationId);
			
			for (User userOrganization : userOrganizationList) {
				consultantsList.add(userOrganization);
			}
			Collections.sort(consultantsList, new Comparator<User>() {
				public int compare(User u1, User u2) {
					String fullName1 = u1.getLastName() + u1.getFirstName();
					String fullName2 = u2.getLastName() + u2.getFirstName();
					
					return fullName1.compareTo(fullName2);
				}
			});
		
		} catch (SystemException e) {
			// logger.warm
		}
		
		return consultantsList;
	}
	
	public static List<Enterprise> getEnterprises(long organizationId) {
		Map<Long, Enterprise> enterpriseMap = new HashMap<Long, Enterprise>();
		try {
			List<User> consultantList = getConsultants(organizationId);
			for (User consultant : consultantList) {
				AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUserList(consultant.getUserId()).get(0);
				List<Enterprise> consEnterpriseList = AddressBookUtils.getEnterprisesFromAddressBook(addressBookUser.getAddressBookId());
				for (Enterprise enterprise : consEnterpriseList) {
					enterpriseMap.put(enterprise.getEnterpriseId(), enterprise);
				}
			}
		} catch (Exception e) {
			// logger.warm
		}
		
		return new ArrayList<Enterprise>(enterpriseMap.values());
	}
}
