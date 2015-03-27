/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import java.util.List;

import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.service.base.ColleagueAddressBookContactLocalServiceBaseImpl;
import com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the colleague address book contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ColleagueAddressBookContactLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil
 */
public class ColleagueAddressBookContactLocalServiceImpl
	extends ColleagueAddressBookContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil} to access the colleague address book contact local service.
	 */
	
	public List<ColleagueAddressBookContact> getAll(long organizationId, long userId, int start, int end) throws SystemException {
		return ColleagueAddressBookContactFinderUtil.findAll(organizationId, userId, start, end);
	}
	
	public int getTotal(long organizationId, long userId) throws SystemException {
		return ColleagueAddressBookContactFinderUtil.countAll(organizationId, userId);
	}
}