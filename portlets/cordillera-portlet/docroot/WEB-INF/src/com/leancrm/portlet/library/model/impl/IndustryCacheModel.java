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

import com.leancrm.portlet.library.model.Industry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Industry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Industry
 * @generated
 */
public class IndustryCacheModel implements CacheModel<Industry>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{industryId=");
		sb.append(industryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Industry toEntityModel() {
		IndustryImpl industryImpl = new IndustryImpl();

		industryImpl.setIndustryId(industryId);
		industryImpl.setGroupId(groupId);

		if (name == null) {
			industryImpl.setName(StringPool.BLANK);
		}
		else {
			industryImpl.setName(name);
		}

		industryImpl.resetOriginalValues();

		return industryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		industryId = objectInput.readLong();
		groupId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(industryId);
		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long industryId;
	public long groupId;
	public String name;
}