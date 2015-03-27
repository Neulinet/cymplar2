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

import com.leancrm.portlet.library.model.ContactDataMethod;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactDataMethod in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethod
 * @generated
 */
public class ContactDataMethodCacheModel implements CacheModel<ContactDataMethod>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{contactDataMethodId=");
		sb.append(contactDataMethodId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", contactDataType=");
		sb.append(contactDataType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDataMethod toEntityModel() {
		ContactDataMethodImpl contactDataMethodImpl = new ContactDataMethodImpl();

		contactDataMethodImpl.setContactDataMethodId(contactDataMethodId);
		contactDataMethodImpl.setGroupId(groupId);
		contactDataMethodImpl.setCompanyId(companyId);

		if (name == null) {
			contactDataMethodImpl.setName(StringPool.BLANK);
		}
		else {
			contactDataMethodImpl.setName(name);
		}

		if (title == null) {
			contactDataMethodImpl.setTitle(StringPool.BLANK);
		}
		else {
			contactDataMethodImpl.setTitle(title);
		}

		contactDataMethodImpl.setContactDataType(contactDataType);

		contactDataMethodImpl.resetOriginalValues();

		return contactDataMethodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactDataMethodId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		contactDataType = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactDataMethodId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeInt(contactDataType);
	}

	public long contactDataMethodId;
	public long groupId;
	public long companyId;
	public String name;
	public String title;
	public int contactDataType;
}