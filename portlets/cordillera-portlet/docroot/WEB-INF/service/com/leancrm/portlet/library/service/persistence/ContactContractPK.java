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
public class ContactContractPK implements Comparable<ContactContractPK>,
	Serializable {
	public long contactId;
	public long contractId;

	public ContactContractPK() {
	}

	public ContactContractPK(long contactId, long contractId) {
		this.contactId = contactId;
		this.contractId = contractId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getContractId() {
		return contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	@Override
	public int compareTo(ContactContractPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (contactId < pk.contactId) {
			value = -1;
		}
		else if (contactId > pk.contactId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (contractId < pk.contractId) {
			value = -1;
		}
		else if (contractId > pk.contractId) {
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

		if (!(obj instanceof ContactContractPK)) {
			return false;
		}

		ContactContractPK pk = (ContactContractPK)obj;

		if ((contactId == pk.contactId) && (contractId == pk.contractId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(contactId) + String.valueOf(contractId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("contactId");
		sb.append(StringPool.EQUAL);
		sb.append(contactId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("contractId");
		sb.append(StringPool.EQUAL);
		sb.append(contractId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}