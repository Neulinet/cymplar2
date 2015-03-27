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

import com.leancrm.portlet.library.model.AddressBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AddressBook in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBook
 * @generated
 */
public class AddressBookCacheModel implements CacheModel<AddressBook>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{addressBookId=");
		sb.append(addressBookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", addressBookType=");
		sb.append(addressBookType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressBook toEntityModel() {
		AddressBookImpl addressBookImpl = new AddressBookImpl();

		addressBookImpl.setAddressBookId(addressBookId);
		addressBookImpl.setGroupId(groupId);
		addressBookImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			addressBookImpl.setCreateDate(null);
		}
		else {
			addressBookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressBookImpl.setModifiedDate(null);
		}
		else {
			addressBookImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressBookImpl.setAddressBookType(addressBookType);

		addressBookImpl.resetOriginalValues();

		return addressBookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressBookId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		addressBookType = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressBookId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(addressBookType);
	}

	public long addressBookId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long addressBookType;
}