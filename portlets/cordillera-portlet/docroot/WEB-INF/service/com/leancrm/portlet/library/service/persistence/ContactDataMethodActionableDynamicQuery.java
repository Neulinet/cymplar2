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

import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactDataMethodActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ContactDataMethodActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ContactDataMethodLocalServiceUtil.getService());
		setClass(ContactDataMethod.class);

		setClassLoader(com.leancrm.portlet.library.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("contactDataMethodId");
	}
}