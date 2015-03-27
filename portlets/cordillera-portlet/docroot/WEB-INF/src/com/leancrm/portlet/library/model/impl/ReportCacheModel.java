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

import com.leancrm.portlet.library.model.Report;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Report in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Report
 * @generated
 */
public class ReportCacheModel implements CacheModel<Report>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{reportId=");
		sb.append(reportId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", enterpriseId=");
		sb.append(enterpriseId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", contactDataId=");
		sb.append(contactDataId);
		sb.append(", contactMethodId=");
		sb.append(contactMethodId);
		sb.append(", reportDate=");
		sb.append(reportDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", status=");
		sb.append(status);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", cdNameId=");
		sb.append(cdNameId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Report toEntityModel() {
		ReportImpl reportImpl = new ReportImpl();

		reportImpl.setReportId(reportId);
		reportImpl.setGroupId(groupId);
		reportImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			reportImpl.setCreateDate(null);
		}
		else {
			reportImpl.setCreateDate(new Date(createDate));
		}

		reportImpl.setUserId(userId);
		reportImpl.setOrganizationId(organizationId);
		reportImpl.setEnterpriseId(enterpriseId);
		reportImpl.setContactId(contactId);
		reportImpl.setContactDataId(contactDataId);
		reportImpl.setContactMethodId(contactMethodId);

		if (reportDate == Long.MIN_VALUE) {
			reportImpl.setReportDate(null);
		}
		else {
			reportImpl.setReportDate(new Date(reportDate));
		}

		if (comments == null) {
			reportImpl.setComments(StringPool.BLANK);
		}
		else {
			reportImpl.setComments(comments);
		}

		reportImpl.setProgress(progress);
		reportImpl.setStatus(status);
		reportImpl.setContractId(contractId);
		reportImpl.setCdNameId(cdNameId);

		reportImpl.resetOriginalValues();

		return reportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		userId = objectInput.readLong();
		organizationId = objectInput.readLong();
		enterpriseId = objectInput.readLong();
		contactId = objectInput.readLong();
		contactDataId = objectInput.readLong();
		contactMethodId = objectInput.readLong();
		reportDate = objectInput.readLong();
		comments = objectInput.readUTF();
		progress = objectInput.readDouble();
		status = objectInput.readInt();
		contractId = objectInput.readLong();
		cdNameId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(enterpriseId);
		objectOutput.writeLong(contactId);
		objectOutput.writeLong(contactDataId);
		objectOutput.writeLong(contactMethodId);
		objectOutput.writeLong(reportDate);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeDouble(progress);
		objectOutput.writeInt(status);
		objectOutput.writeLong(contractId);
		objectOutput.writeLong(cdNameId);
	}

	public long reportId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long userId;
	public long organizationId;
	public long enterpriseId;
	public long contactId;
	public long contactDataId;
	public long contactMethodId;
	public long reportDate;
	public String comments;
	public double progress;
	public int status;
	public long contractId;
	public long cdNameId;
}