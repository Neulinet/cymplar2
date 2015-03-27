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

import com.leancrm.portlet.library.model.NextFollowUpEvent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NextFollowUpEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEvent
 * @generated
 */
public class NextFollowUpEventCacheModel implements CacheModel<NextFollowUpEvent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", eventDate=");
		sb.append(eventDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NextFollowUpEvent toEntityModel() {
		NextFollowUpEventImpl nextFollowUpEventImpl = new NextFollowUpEventImpl();

		nextFollowUpEventImpl.setEventId(eventId);

		if (eventDate == Long.MIN_VALUE) {
			nextFollowUpEventImpl.setEventDate(null);
		}
		else {
			nextFollowUpEventImpl.setEventDate(new Date(eventDate));
		}

		nextFollowUpEventImpl.setStatus(status);

		if (title == null) {
			nextFollowUpEventImpl.setTitle(StringPool.BLANK);
		}
		else {
			nextFollowUpEventImpl.setTitle(title);
		}

		if (description == null) {
			nextFollowUpEventImpl.setDescription(StringPool.BLANK);
		}
		else {
			nextFollowUpEventImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			nextFollowUpEventImpl.setCreateDate(null);
		}
		else {
			nextFollowUpEventImpl.setCreateDate(new Date(createDate));
		}

		nextFollowUpEventImpl.setOwnerId(ownerId);
		nextFollowUpEventImpl.setContractId(contractId);
		nextFollowUpEventImpl.setReportId(reportId);

		nextFollowUpEventImpl.resetOriginalValues();

		return nextFollowUpEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();
		eventDate = objectInput.readLong();
		status = objectInput.readInt();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		createDate = objectInput.readLong();
		ownerId = objectInput.readLong();
		contractId = objectInput.readLong();
		reportId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(eventDate);
		objectOutput.writeInt(status);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(ownerId);
		objectOutput.writeLong(contractId);
		objectOutput.writeLong(reportId);
	}

	public long eventId;
	public long eventDate;
	public int status;
	public String title;
	public String description;
	public long createDate;
	public long ownerId;
	public long contractId;
	public long reportId;
}