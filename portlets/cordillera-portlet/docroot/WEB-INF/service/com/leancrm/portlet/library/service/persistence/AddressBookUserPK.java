/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.leancrm.portlet.library.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressBookUserPK implements Comparable<AddressBookUserPK>,
	Serializable {
	public long addressBookId;
	public long userId;

	public AddressBookUserPK() {
	}

	public AddressBookUserPK(long addressBookId, long userId) {
		this.addressBookId = addressBookId;
		this.userId = userId;
	}

	public long getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		this.addressBookId = addressBookId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int compareTo(AddressBookUserPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (addressBookId < pk.addressBookId) {
			value = -1;
		}
		else if (addressBookId > pk.addressBookId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AddressBookUserPK pk = null;

		try {
			pk = (AddressBookUserPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((addressBookId == pk.addressBookId) && (userId == pk.userId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(addressBookId) + String.valueOf(userId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("addressBookId");
		sb.append(StringPool.EQUAL);
		sb.append(addressBookId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}