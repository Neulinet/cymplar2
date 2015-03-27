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
public class ColleagueAddressBookContactPK implements Comparable<ColleagueAddressBookContactPK>,
	Serializable {
	public long contactid;
	public long methodId;

	public ColleagueAddressBookContactPK() {
	}

	public ColleagueAddressBookContactPK(long contactid, long methodId) {
		this.contactid = contactid;
		this.methodId = methodId;
	}

	public long getContactid() {
		return contactid;
	}

	public void setContactid(long contactid) {
		this.contactid = contactid;
	}

	public long getMethodId() {
		return methodId;
	}

	public void setMethodId(long methodId) {
		this.methodId = methodId;
	}

	@Override
	public int compareTo(ColleagueAddressBookContactPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (contactid < pk.contactid) {
			value = -1;
		}
		else if (contactid > pk.contactid) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (methodId < pk.methodId) {
			value = -1;
		}
		else if (methodId > pk.methodId) {
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

		if (!(obj instanceof ColleagueAddressBookContactPK)) {
			return false;
		}

		ColleagueAddressBookContactPK pk = (ColleagueAddressBookContactPK)obj;

		if ((contactid == pk.contactid) && (methodId == pk.methodId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(contactid) + String.valueOf(methodId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("contactid");
		sb.append(StringPool.EQUAL);
		sb.append(contactid);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("methodId");
		sb.append(StringPool.EQUAL);
		sb.append(methodId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}