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

import com.leancrm.portlet.library.model.ContactData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactData
 * @generated
 */
public class ContactDataCacheModel implements CacheModel<ContactData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contactDataId=");
		sb.append(contactDataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", contactDataType=");
		sb.append(contactDataType);
		sb.append(", readOnly=");
		sb.append(readOnly);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", contactDataMethodId=");
		sb.append(contactDataMethodId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactData toEntityModel() {
		ContactDataImpl contactDataImpl = new ContactDataImpl();

		contactDataImpl.setContactDataId(contactDataId);
		contactDataImpl.setGroupId(groupId);
		contactDataImpl.setContactDataType(contactDataType);
		contactDataImpl.setReadOnly(readOnly);
		contactDataImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			contactDataImpl.setCreateDate(null);
		}
		else {
			contactDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactDataImpl.setModifiedDate(null);
		}
		else {
			contactDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		contactDataImpl.setContactDataMethodId(contactDataMethodId);
		contactDataImpl.setContactId(contactId);

		contactDataImpl.resetOriginalValues();

		return contactDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactDataId = objectInput.readLong();
		groupId = objectInput.readLong();
		contactDataType = objectInput.readInt();
		readOnly = objectInput.readBoolean();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		contactDataMethodId = objectInput.readLong();
		contactId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactDataId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(contactDataType);
		objectOutput.writeBoolean(readOnly);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(contactDataMethodId);
		objectOutput.writeLong(contactId);
	}

	public long contactDataId;
	public long groupId;
	public int contactDataType;
	public boolean readOnly;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long contactDataMethodId;
	public long contactId;
}