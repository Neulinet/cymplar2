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
public class AddressBookOrganizationPK implements Comparable<AddressBookOrganizationPK>,
	Serializable {
	public long addressBookId;
	public long organizationId;

	public AddressBookOrganizationPK() {
	}

	public AddressBookOrganizationPK(long addressBookId, long organizationId) {
		this.addressBookId = addressBookId;
		this.organizationId = organizationId;
	}

	public long getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		this.addressBookId = addressBookId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public int compareTo(AddressBookOrganizationPK pk) {
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

		if (organizationId < pk.organizationId) {
			value = -1;
		}
		else if (organizationId > pk.organizationId) {
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

		AddressBookOrganizationPK pk = null;

		try {
			pk = (AddressBookOrganizationPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((addressBookId == pk.addressBookId) &&
				(organizationId == pk.organizationId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(addressBookId) + String.valueOf(organizationId)).hashCode();
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
		sb.append("organizationId");
		sb.append(StringPool.EQUAL);
		sb.append(organizationId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}