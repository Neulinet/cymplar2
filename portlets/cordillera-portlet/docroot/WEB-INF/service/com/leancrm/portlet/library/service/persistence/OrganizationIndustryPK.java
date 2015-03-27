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
public class OrganizationIndustryPK implements Comparable<OrganizationIndustryPK>,
	Serializable {
	public long organizationId;
	public long industryId;

	public OrganizationIndustryPK() {
	}

	public OrganizationIndustryPK(long organizationId, long industryId) {
		this.organizationId = organizationId;
		this.industryId = industryId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(long industryId) {
		this.industryId = industryId;
	}

	@Override
	public int compareTo(OrganizationIndustryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (industryId < pk.industryId) {
			value = -1;
		}
		else if (industryId > pk.industryId) {
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

		if (!(obj instanceof OrganizationIndustryPK)) {
			return false;
		}

		OrganizationIndustryPK pk = (OrganizationIndustryPK)obj;

		if ((organizationId == pk.organizationId) &&
				(industryId == pk.industryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(organizationId) + String.valueOf(industryId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("organizationId");
		sb.append(StringPool.EQUAL);
		sb.append(organizationId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("industryId");
		sb.append(StringPool.EQUAL);
		sb.append(industryId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}