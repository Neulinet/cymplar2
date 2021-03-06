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

import com.leancrm.portlet.library.model.AddressBookContactData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressBookContactData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactData
 * @generated
 */
public class AddressBookContactDataCacheModel implements CacheModel<AddressBookContactData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{addressBookId=");
		sb.append(addressBookId);
		sb.append(", contactDataId=");
		sb.append(contactDataId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressBookContactData toEntityModel() {
		AddressBookContactDataImpl addressBookContactDataImpl = new AddressBookContactDataImpl();

		addressBookContactDataImpl.setAddressBookId(addressBookId);
		addressBookContactDataImpl.setContactDataId(contactDataId);
		addressBookContactDataImpl.setActive(active);

		addressBookContactDataImpl.resetOriginalValues();

		return addressBookContactDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressBookId = objectInput.readLong();
		contactDataId = objectInput.readLong();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressBookId);
		objectOutput.writeLong(contactDataId);
		objectOutput.writeBoolean(active);
	}

	public long addressBookId;
	public long contactDataId;
	public boolean active;
}