/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.leancrm.portlet.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.base.AddressBookUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the address book user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.AddressBookUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.AddressBookUserLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil
 */
public class AddressBookUserLocalServiceImpl
	extends AddressBookUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil} to access the address book user local service.
	 */
	public List<AddressBookUser> getAddressBookUserList(long userId) throws SystemException {
		return addressBookUserPersistence.findByUser(userId);
	}
	
	public List<Long> getUsersHaveContact(long contactId) throws PortalException, SystemException {
		List<Long> userList = new ArrayList<Long>();
		List<AddressBookContact> addressBookContactList = AddressBookContactLocalServiceUtil.getByContact(contactId);
		if (addressBookContactList != null) {
			for (AddressBookContact abContact : addressBookContactList) {
				AddressBookUser abUser = getAddressBookUser(abContact.getAddressBookId());
				if (abUser != null) {
					userList.add(abUser.getUserId());
				}
			}
		}
		
		return userList;
	}
	
}