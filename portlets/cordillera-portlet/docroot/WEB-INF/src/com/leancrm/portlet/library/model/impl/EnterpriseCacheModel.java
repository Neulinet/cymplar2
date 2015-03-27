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

import com.leancrm.portlet.library.model.Enterprise;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Enterprise in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Enterprise
 * @generated
 */
public class EnterpriseCacheModel implements CacheModel<Enterprise>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{enterpriseId=");
		sb.append(enterpriseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", isPrivate=");
		sb.append(isPrivate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", taxid=");
		sb.append(taxid);
		sb.append(", description=");
		sb.append(description);
		sb.append(", industry=");
		sb.append(industry);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Enterprise toEntityModel() {
		EnterpriseImpl enterpriseImpl = new EnterpriseImpl();

		enterpriseImpl.setEnterpriseId(enterpriseId);
		enterpriseImpl.setGroupId(groupId);
		enterpriseImpl.setIsPrivate(isPrivate);
		enterpriseImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			enterpriseImpl.setCreateDate(null);
		}
		else {
			enterpriseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enterpriseImpl.setModifiedDate(null);
		}
		else {
			enterpriseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			enterpriseImpl.setName(StringPool.BLANK);
		}
		else {
			enterpriseImpl.setName(name);
		}

		if (taxid == null) {
			enterpriseImpl.setTaxid(StringPool.BLANK);
		}
		else {
			enterpriseImpl.setTaxid(taxid);
		}

		if (description == null) {
			enterpriseImpl.setDescription(StringPool.BLANK);
		}
		else {
			enterpriseImpl.setDescription(description);
		}

		enterpriseImpl.setIndustry(industry);

		if (email == null) {
			enterpriseImpl.setEmail(StringPool.BLANK);
		}
		else {
			enterpriseImpl.setEmail(email);
		}

		enterpriseImpl.resetOriginalValues();

		return enterpriseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		enterpriseId = objectInput.readLong();
		groupId = objectInput.readLong();
		isPrivate = objectInput.readInt();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		taxid = objectInput.readUTF();
		description = objectInput.readUTF();
		industry = objectInput.readLong();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(enterpriseId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(isPrivate);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (taxid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxid);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(industry);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public long enterpriseId;
	public long groupId;
	public int isPrivate;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String taxid;
	public String description;
	public long industry;
	public String email;
}