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

package com.leancrm.portlet.library.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactFinderUtil {
	public static java.util.List<com.leancrm.portlet.library.model.Contact> findByEventNameEventDescriptionLocationName(
		java.lang.String eventName, java.lang.String eventDescription,
		java.lang.String locationName, int begin, int end) {
		return getFinder()
				   .findByEventNameEventDescriptionLocationName(eventName,
			eventDescription, locationName, begin, end);
	}

	public static ContactFinder getFinder() {
		if (_finder == null) {
			_finder = (ContactFinder)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ContactFinder.class.getName());

			ReferenceRegistry.registerReference(ContactFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContactFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContactFinderUtil.class, "_finder");
	}

	private static ContactFinder _finder;
}