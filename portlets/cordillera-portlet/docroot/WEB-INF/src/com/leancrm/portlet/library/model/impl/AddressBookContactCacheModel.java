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

import com.leancrm.portlet.library.model.AddressBookContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressBookContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContact
 * @generated
 */
public class AddressBookContactCacheModel implements CacheModel<AddressBookContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{addressBookId=");
		sb.append(addressBookId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", assignedTo=");
		sb.append(assignedTo);
		sb.append(", currentProgress=");
		sb.append(currentProgress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressBookContact toEntityModel() {
		AddressBookContactImpl addressBookContactImpl = new AddressBookContactImpl();

		addressBookContactImpl.setAddressBookId(addressBookId);
		addressBookContactImpl.setContactId(contactId);
		addressBookContactImpl.setGroupId(groupId);
		addressBookContactImpl.setCompanyId(companyId);
		addressBookContactImpl.setAssignedTo(assignedTo);
		addressBookContactImpl.setCurrentProgress(currentProgress);

		addressBookContactImpl.resetOriginalValues();

		return addressBookContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressBookId = objectInput.readLong();
		contactId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		assignedTo = objectInput.readLong();
		currentProgress = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressBookId);
		objectOutput.writeLong(contactId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(assignedTo);
		objectOutput.writeDouble(currentProgress);
	}

	public long addressBookId;
	public long contactId;
	public long groupId;
	public long companyId;
	public long assignedTo;
	public double currentProgress;
}