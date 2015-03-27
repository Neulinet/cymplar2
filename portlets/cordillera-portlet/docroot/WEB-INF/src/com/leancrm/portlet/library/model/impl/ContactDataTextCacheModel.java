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

import com.leancrm.portlet.library.model.ContactDataText;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactDataText in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataText
 * @generated
 */
public class ContactDataTextCacheModel implements CacheModel<ContactDataText>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contactDataId=");
		sb.append(contactDataId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDataText toEntityModel() {
		ContactDataTextImpl contactDataTextImpl = new ContactDataTextImpl();

		contactDataTextImpl.setContactDataId(contactDataId);

		if (value == null) {
			contactDataTextImpl.setValue(StringPool.BLANK);
		}
		else {
			contactDataTextImpl.setValue(value);
		}

		contactDataTextImpl.resetOriginalValues();

		return contactDataTextImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactDataId = objectInput.readLong();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactDataId);

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long contactDataId;
	public String value;
}