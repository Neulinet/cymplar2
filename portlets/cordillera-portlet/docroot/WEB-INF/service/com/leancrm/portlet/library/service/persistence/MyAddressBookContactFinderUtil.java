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

package com.leancrm.portlet.library.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class MyAddressBookContactFinderUtil {
	public static java.util.List<com.leancrm.portlet.library.model.MyAddressBookContact> findAll(
		long organizationId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findAll(organizationId, userId, start, end);
	}

	public static int countAll(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countAll(userId);
	}

	public static MyAddressBookContactFinder getFinder() {
		if (_finder == null) {
			_finder = (MyAddressBookContactFinder)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					MyAddressBookContactFinder.class.getName());

			ReferenceRegistry.registerReference(MyAddressBookContactFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(MyAddressBookContactFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(MyAddressBookContactFinderUtil.class,
			"_finder");
	}

	private static MyAddressBookContactFinder _finder;
}