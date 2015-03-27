package com.leancrm.portlet.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class OrganizationUtils {

	public static Organization getOrganizationByUser(long userId) {
		try {
			List<Organization> organizationList = OrganizationLocalServiceUtil.getUserOrganizations(userId);
			if (organizationList != null && !organizationList.isEmpty()) {
				return organizationList.get(0);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<User> getOrganizationAdmin(long organizationId) throws PortalException, SystemException {
		List<User> adminList = new ArrayList<User>();
		List<User> userList = UserLocalServiceUtil.getOrganizationUsers(organizationId);
		for (User user : userList) {
			long[] rolesId = user.getRoleIds();
			for (long roleId : rolesId) {
				if (roleId == 11855) {
					adminList.add(user);
					break;
				}
			}
		}
		
		return adminList;
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
