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

import com.leancrm.portlet.library.model.Contract;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Contract in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contract
 * @generated
 */
public class ContractCacheModel implements CacheModel<Contract>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contractId=");
		sb.append(contractId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", enterpriseId=");
		sb.append(enterpriseId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", amount=");
		sb.append(amount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contract toEntityModel() {
		ContractImpl contractImpl = new ContractImpl();

		contractImpl.setContractId(contractId);
		contractImpl.setGroupId(groupId);
		contractImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			contractImpl.setCreateDate(null);
		}
		else {
			contractImpl.setCreateDate(new Date(createDate));
		}

		contractImpl.setOrganizationId(organizationId);
		contractImpl.setEnterpriseId(enterpriseId);
		contractImpl.setContactId(contactId);

		if (description == null) {
			contractImpl.setDescription(StringPool.BLANK);
		}
		else {
			contractImpl.setDescription(description);
		}

		contractImpl.setAmount(amount);

		contractImpl.resetOriginalValues();

		return contractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contractId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		organizationId = objectInput.readLong();
		enterpriseId = objectInput.readLong();
		contactId = objectInput.readLong();
		description = objectInput.readUTF();
		amount = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contractId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(enterpriseId);
		objectOutput.writeLong(contactId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(amount);
	}

	public long contractId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long organizationId;
	public long enterpriseId;
	public long contactId;
	public String description;
	public double amount;
}