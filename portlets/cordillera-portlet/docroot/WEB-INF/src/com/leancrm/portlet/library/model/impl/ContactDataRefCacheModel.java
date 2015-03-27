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

package com.leancrm.portlet.library.model.impl;

import com.leancrm.portlet.library.model.ContactDataRef;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactDataRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRef
 * @generated
 */
public class ContactDataRefCacheModel implements CacheModel<ContactDataRef>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contactDataId=");
		sb.append(contactDataId);
		sb.append(", refValue=");
		sb.append(refValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDataRef toEntityModel() {
		ContactDataRefImpl contactDataRefImpl = new ContactDataRefImpl();

		contactDataRefImpl.setContactDataId(contactDataId);
		contactDataRefImpl.setRefValue(refValue);

		contactDataRefImpl.resetOriginalValues();

		return contactDataRefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactDataId = objectInput.readLong();
		refValue = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactDataId);
		objectOutput.writeLong(refValue);
	}

	public long contactDataId;
	public long refValue;
}