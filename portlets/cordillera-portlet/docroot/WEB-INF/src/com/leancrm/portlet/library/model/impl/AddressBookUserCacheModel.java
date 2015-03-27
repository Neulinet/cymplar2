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

import com.leancrm.portlet.library.model.AddressBookUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressBookUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookUser
 * @generated
 */
public class AddressBookUserCacheModel implements CacheModel<AddressBookUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{addressBookId=");
		sb.append(addressBookId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressBookUser toEntityModel() {
		AddressBookUserImpl addressBookUserImpl = new AddressBookUserImpl();

		addressBookUserImpl.setAddressBookId(addressBookId);
		addressBookUserImpl.setUserId(userId);

		addressBookUserImpl.resetOriginalValues();

		return addressBookUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressBookId = objectInput.readLong();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressBookId);
		objectOutput.writeLong(userId);
	}

	public long addressBookId;
	public long userId;
}