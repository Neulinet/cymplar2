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

import com.leancrm.portlet.library.model.UserContract;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserContract in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserContract
 * @generated
 */
public class UserContractCacheModel implements CacheModel<UserContract>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", accessLevel=");
		sb.append(accessLevel);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserContract toEntityModel() {
		UserContractImpl userContractImpl = new UserContractImpl();

		userContractImpl.setUserId(userId);
		userContractImpl.setContractId(contractId);
		userContractImpl.setActive(active);
		userContractImpl.setAccessLevel(accessLevel);

		if (createDate == Long.MIN_VALUE) {
			userContractImpl.setCreateDate(null);
		}
		else {
			userContractImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userContractImpl.setModifiedDate(null);
		}
		else {
			userContractImpl.setModifiedDate(new Date(modifiedDate));
		}

		userContractImpl.resetOriginalValues();

		return userContractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		contractId = objectInput.readLong();
		active = objectInput.readBoolean();
		accessLevel = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(contractId);
		objectOutput.writeBoolean(active);
		objectOutput.writeInt(accessLevel);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long userId;
	public long contractId;
	public boolean active;
	public int accessLevel;
	public long createDate;
	public long modifiedDate;
}