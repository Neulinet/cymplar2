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

package com.leancrm.portlet.library.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressBookContactDataPK implements Comparable<AddressBookContactDataPK>,
	Serializable {
	public long addressBookId;
	public long contactDataId;

	public AddressBookContactDataPK() {
	}

	public AddressBookContactDataPK(long addressBookId, long contactDataId) {
		this.addressBookId = addressBookId;
		this.contactDataId = contactDataId;
	}

	public long getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		this.addressBookId = addressBookId;
	}

	public long getContactDataId() {
		return contactDataId;
	}

	public void setContactDataId(long contactDataId) {
		this.contactDataId = contactDataId;
	}

	@Override
	public int compareTo(AddressBookContactDataPK pk) {
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

		if (contactDataId < pk.contactDataId) {
			value = -1;
		}
		else if (contactDataId > pk.contactDataId) {
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
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookContactDataPK)) {
			return false;
		}

		AddressBookContactDataPK pk = (AddressBookContactDataPK)obj;

		if ((addressBookId == pk.addressBookId) &&
				(contactDataId == pk.contactDataId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(addressBookId) + String.valueOf(contactDataId)).hashCode();
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
		sb.append("contactDataId");
		sb.append(StringPool.EQUAL);
		sb.append(contactDataId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}