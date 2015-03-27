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

import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.service.base.AddressBookOrganizationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the address book organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.AddressBookOrganizationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.AddressBookOrganizationLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil
 */
public class AddressBookOrganizationLocalServiceImpl
	extends AddressBookOrganizationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil} to access the address book organization local service.
	 */
	public List<AddressBookOrganization> getAddressBookOrganizationList(long organizationId) throws SystemException {
		List<AddressBookOrganization> addressBookOrganizationList = new ArrayList<AddressBookOrganization>();
		
		if (addressBookOrganizationPersistence.findByOrganization(organizationId) != null) {
			for (AddressBookOrganization addressBookOrganization : addressBookOrganizationPersistence.findByOrganization(organizationId)) {
				addressBookOrganizationList.add(addressBookOrganization);
			}
		}
		
		return addressBookOrganizationList;
	}
}