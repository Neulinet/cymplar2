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

import com.leancrm.portlet.library.model.ContactDataPhone;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactDataPhone in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhone
 * @generated
 */
public class ContactDataPhoneCacheModel implements CacheModel<ContactDataPhone>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactDataId=");
		sb.append(contactDataId);
		sb.append(", extension=");
		sb.append(extension);
		sb.append(", number=");
		sb.append(number);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDataPhone toEntityModel() {
		ContactDataPhoneImpl contactDataPhoneImpl = new ContactDataPhoneImpl();

		contactDataPhoneImpl.setContactDataId(contactDataId);

		if (extension == null) {
			contactDataPhoneImpl.setExtension(StringPool.BLANK);
		}
		else {
			contactDataPhoneImpl.setExtension(extension);
		}

		if (number == null) {
			contactDataPhoneImpl.setNumber(StringPool.BLANK);
		}
		else {
			contactDataPhoneImpl.setNumber(number);
		}

		contactDataPhoneImpl.resetOriginalValues();

		return contactDataPhoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactDataId = objectInput.readLong();
		extension = objectInput.readUTF();
		number = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactDataId);

		if (extension == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extension);
		}

		if (number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(number);
		}
	}

	public long contactDataId;
	public String extension;
	public String number;
}