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

import com.leancrm.portlet.library.model.OrganizationIndustry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrganizationIndustry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationIndustry
 * @generated
 */
public class OrganizationIndustryCacheModel implements CacheModel<OrganizationIndustry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{organizationId=");
		sb.append(organizationId);
		sb.append(", industryId=");
		sb.append(industryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationIndustry toEntityModel() {
		OrganizationIndustryImpl organizationIndustryImpl = new OrganizationIndustryImpl();

		organizationIndustryImpl.setOrganizationId(organizationId);
		organizationIndustryImpl.setIndustryId(industryId);

		organizationIndustryImpl.resetOriginalValues();

		return organizationIndustryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationId = objectInput.readLong();
		industryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(industryId);
	}

	public long organizationId;
	public long industryId;
}