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
public class ColleagueAddressBookContactFinderUtil {
	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> findAll(
		long organizationId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findAll(organizationId, userId, start, end);
	}

	public static int countAll(long organizationId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countAll(organizationId, userId);
	}

	public static ColleagueAddressBookContactFinder getFinder() {
		if (_finder == null) {
			_finder = (ColleagueAddressBookContactFinder)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ColleagueAddressBookContactFinder.class.getName());

			ReferenceRegistry.registerReference(ColleagueAddressBookContactFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ColleagueAddressBookContactFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ColleagueAddressBookContactFinderUtil.class,
			"_finder");
	}

	private static ColleagueAddressBookContactFinder _finder;
}