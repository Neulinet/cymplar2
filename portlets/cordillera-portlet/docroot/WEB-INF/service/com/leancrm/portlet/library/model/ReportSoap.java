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

package com.leancrm.portlet.library.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReportSoap implements Serializable {
	public static ReportSoap toSoapModel(Report model) {
		ReportSoap soapModel = new ReportSoap();

		soapModel.setReportId(model.getReportId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setEnterpriseId(model.getEnterpriseId());
		soapModel.setContactId(model.getContactId());
		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setContactMethodId(model.getContactMethodId());
		soapModel.setReportDate(model.getReportDate());
		soapModel.setComments(model.getComments());
		soapModel.setProgress(model.getProgress());
		soapModel.setStatus(model.getStatus());
		soapModel.setContractId(model.getContractId());
		soapModel.setCdNameId(model.getCdNameId());

		return soapModel;
	}

	public static ReportSoap[] toSoapModels(Report[] models) {
		ReportSoap[] soapModels = new ReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReportSoap[][] toSoapModels(Report[][] models) {
		ReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReportSoap[] toSoapModels(List<Report> models) {
		List<ReportSoap> soapModels = new ArrayList<ReportSoap>(models.size());

		for (Report model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReportSoap[soapModels.size()]);
	}

	public ReportSoap() {
	}

	public long getPrimaryKey() {
		return _reportId;
	}

	public void setPrimaryKey(long pk) {
		setReportId(pk);
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getEnterpriseId() {
		return _enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getContactDataId() {
		return _contactDataId;
	}

	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;
	}

	public long getContactMethodId() {
		return _contactMethodId;
	}

	public void setContactMethodId(long contactMethodId) {
		_contactMethodId = contactMethodId;
	}

	public Date getReportDate() {
		return _reportDate;
	}

	public void setReportDate(Date reportDate) {
		_reportDate = reportDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public double getProgress() {
		return _progress;
	}

	public void setProgress(double progress) {
		_progress = progress;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
	}

	public long getCdNameId() {
		return _cdNameId;
	}

	public void setCdNameId(long cdNameId) {
		_cdNameId = cdNameId;
	}

	private long _reportId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _userId;
	private long _organizationId;
	private long _enterpriseId;
	private long _contactId;
	private long _contactDataId;
	private long _contactMethodId;
	private Date _reportDate;
	private String _comments;
	private double _progress;
	private int _status;
	private long _contractId;
	private long _cdNameId;
}