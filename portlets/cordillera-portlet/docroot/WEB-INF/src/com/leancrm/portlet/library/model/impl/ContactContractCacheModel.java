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

import com.leancrm.portlet.library.model.ContactContract;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactContract in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactContract
 * @generated
 */
public class ContactContractCacheModel implements CacheModel<ContactContract>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactContract toEntityModel() {
		ContactContractImpl contactContractImpl = new ContactContractImpl();

		contactContractImpl.setContactId(contactId);
		contactContractImpl.setContractId(contractId);
		contactContractImpl.setActive(active);

		contactContractImpl.resetOriginalValues();

		return contactContractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();
		contractId = objectInput.readLong();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactId);
		objectOutput.writeLong(contractId);
		objectOutput.writeBoolean(active);
	}

	public long contactId;
	public long contractId;
	public boolean active;
}