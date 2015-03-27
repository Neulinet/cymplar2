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

import com.leancrm.portlet.library.model.ColleagueAddressBookContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ColleagueAddressBookContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ColleagueAddressBookContact
 * @generated
 */
public class ColleagueAddressBookContactCacheModel implements CacheModel<ColleagueAddressBookContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{contactid=");
		sb.append(contactid);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", contactdataid=");
		sb.append(contactdataid);
		sb.append(", methodId=");
		sb.append(methodId);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", enterpriseName=");
		sb.append(enterpriseName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ColleagueAddressBookContact toEntityModel() {
		ColleagueAddressBookContactImpl colleagueAddressBookContactImpl = new ColleagueAddressBookContactImpl();

		colleagueAddressBookContactImpl.setContactid(contactid);

		if (emailAddress == null) {
			colleagueAddressBookContactImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			colleagueAddressBookContactImpl.setEmailAddress(emailAddress);
		}

		colleagueAddressBookContactImpl.setContactdataid(contactdataid);
		colleagueAddressBookContactImpl.setMethodId(methodId);

		if (contactName == null) {
			colleagueAddressBookContactImpl.setContactName(StringPool.BLANK);
		}
		else {
			colleagueAddressBookContactImpl.setContactName(contactName);
		}

		if (enterpriseName == null) {
			colleagueAddressBookContactImpl.setEnterpriseName(StringPool.BLANK);
		}
		else {
			colleagueAddressBookContactImpl.setEnterpriseName(enterpriseName);
		}

		colleagueAddressBookContactImpl.resetOriginalValues();

		return colleagueAddressBookContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactid = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		contactdataid = objectInput.readLong();
		methodId = objectInput.readLong();
		contactName = objectInput.readUTF();
		enterpriseName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactid);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(contactdataid);
		objectOutput.writeLong(methodId);

		if (contactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		if (enterpriseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(enterpriseName);
		}
	}

	public long contactid;
	public String emailAddress;
	public long contactdataid;
	public long methodId;
	public String contactName;
	public String enterpriseName;
}