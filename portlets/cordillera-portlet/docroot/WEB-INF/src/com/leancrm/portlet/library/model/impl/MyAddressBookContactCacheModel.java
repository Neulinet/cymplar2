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

import com.leancrm.portlet.library.model.MyAddressBookContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MyAddressBookContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MyAddressBookContact
 * @generated
 */
public class MyAddressBookContactCacheModel implements CacheModel<MyAddressBookContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", methodId=");
		sb.append(methodId);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", enterpriseId=");
		sb.append(enterpriseId);
		sb.append(", enterpriseName=");
		sb.append(enterpriseName);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MyAddressBookContact toEntityModel() {
		MyAddressBookContactImpl myAddressBookContactImpl = new MyAddressBookContactImpl();

		myAddressBookContactImpl.setContactId(contactId);
		myAddressBookContactImpl.setMethodId(methodId);

		if (contactName == null) {
			myAddressBookContactImpl.setContactName(StringPool.BLANK);
		}
		else {
			myAddressBookContactImpl.setContactName(contactName);
		}

		myAddressBookContactImpl.setEnterpriseId(enterpriseId);

		if (enterpriseName == null) {
			myAddressBookContactImpl.setEnterpriseName(StringPool.BLANK);
		}
		else {
			myAddressBookContactImpl.setEnterpriseName(enterpriseName);
		}

		myAddressBookContactImpl.setContractId(contractId);
		myAddressBookContactImpl.setReportId(reportId);
		myAddressBookContactImpl.setStatus(status);
		myAddressBookContactImpl.setProgress(progress);

		if (description == null) {
			myAddressBookContactImpl.setDescription(StringPool.BLANK);
		}
		else {
			myAddressBookContactImpl.setDescription(description);
		}

		myAddressBookContactImpl.resetOriginalValues();

		return myAddressBookContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();
		methodId = objectInput.readLong();
		contactName = objectInput.readUTF();
		enterpriseId = objectInput.readLong();
		enterpriseName = objectInput.readUTF();
		contractId = objectInput.readLong();
		reportId = objectInput.readLong();
		status = objectInput.readInt();
		progress = objectInput.readDouble();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactId);
		objectOutput.writeLong(methodId);

		if (contactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		objectOutput.writeLong(enterpriseId);

		if (enterpriseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(enterpriseName);
		}

		objectOutput.writeLong(contractId);
		objectOutput.writeLong(reportId);
		objectOutput.writeInt(status);
		objectOutput.writeDouble(progress);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long contactId;
	public long methodId;
	public String contactName;
	public long enterpriseId;
	public String enterpriseName;
	public long contractId;
	public long reportId;
	public int status;
	public double progress;
	public String description;
}