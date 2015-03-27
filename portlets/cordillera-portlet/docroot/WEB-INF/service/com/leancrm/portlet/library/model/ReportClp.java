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

import com.leancrm.portlet.library.service.ClpSerializer;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ReportClp extends BaseModelImpl<Report> implements Report {
	public ReportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Report.class;
	}

	@Override
	public String getModelClassName() {
		return Report.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("contactId", getContactId());
		attributes.put("contactDataId", getContactDataId());
		attributes.put("contactMethodId", getContactMethodId());
		attributes.put("reportDate", getReportDate());
		attributes.put("comments", getComments());
		attributes.put("progress", getProgress());
		attributes.put("status", getStatus());
		attributes.put("contractId", getContractId());
		attributes.put("cdNameId", getCdNameId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long contactMethodId = (Long)attributes.get("contactMethodId");

		if (contactMethodId != null) {
			setContactMethodId(contactMethodId);
		}

		Date reportDate = (Date)attributes.get("reportDate");

		if (reportDate != null) {
			setReportDate(reportDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Double progress = (Double)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long cdNameId = (Long)attributes.get("cdNameId");

		if (cdNameId != null) {
			setCdNameId(cdNameId);
		}
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_reportRemoteModel, reportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_reportRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_reportRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_reportRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_reportRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_reportRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEnterpriseId() {
		return _enterpriseId;
	}

	@Override
	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setEnterpriseId", long.class);

				method.invoke(_reportRemoteModel, enterpriseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_reportRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataId", long.class);

				method.invoke(_reportRemoteModel, contactDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactMethodId() {
		return _contactMethodId;
	}

	@Override
	public void setContactMethodId(long contactMethodId) {
		_contactMethodId = contactMethodId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setContactMethodId", long.class);

				method.invoke(_reportRemoteModel, contactMethodId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReportDate() {
		return _reportDate;
	}

	@Override
	public void setReportDate(Date reportDate) {
		_reportDate = reportDate;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportDate", Date.class);

				method.invoke(_reportRemoteModel, reportDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_reportRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(double progress) {
		_progress = progress;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setProgress", double.class);

				method.invoke(_reportRemoteModel, progress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_reportRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(long contractId) {
		_contractId = contractId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", long.class);

				method.invoke(_reportRemoteModel, contractId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCdNameId() {
		return _cdNameId;
	}

	@Override
	public void setCdNameId(long cdNameId) {
		_cdNameId = cdNameId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setCdNameId", long.class);

				method.invoke(_reportRemoteModel, cdNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReportRemoteModel() {
		return _reportRemoteModel;
	}

	public void setReportRemoteModel(BaseModel<?> reportRemoteModel) {
		_reportRemoteModel = reportRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _reportRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_reportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReportLocalServiceUtil.addReport(this);
		}
		else {
			ReportLocalServiceUtil.updateReport(this);
		}
	}

	@Override
	public Report toEscapedModel() {
		return (Report)ProxyUtil.newProxyInstance(Report.class.getClassLoader(),
			new Class[] { Report.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReportClp clone = new ReportClp();

		clone.setReportId(getReportId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setUserId(getUserId());
		clone.setOrganizationId(getOrganizationId());
		clone.setEnterpriseId(getEnterpriseId());
		clone.setContactId(getContactId());
		clone.setContactDataId(getContactDataId());
		clone.setContactMethodId(getContactMethodId());
		clone.setReportDate(getReportDate());
		clone.setComments(getComments());
		clone.setProgress(getProgress());
		clone.setStatus(getStatus());
		clone.setContractId(getContractId());
		clone.setCdNameId(getCdNameId());

		return clone;
	}

	@Override
	public int compareTo(Report report) {
		long primaryKey = report.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportClp)) {
			return false;
		}

		ReportClp report = (ReportClp)obj;

		long primaryKey = report.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{reportId=");
		sb.append(getReportId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", enterpriseId=");
		sb.append(getEnterpriseId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", contactDataId=");
		sb.append(getContactDataId());
		sb.append(", contactMethodId=");
		sb.append(getContactMethodId());
		sb.append(", reportDate=");
		sb.append(getReportDate());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", cdNameId=");
		sb.append(getCdNameId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.Report");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enterpriseId</column-name><column-value><![CDATA[");
		sb.append(getEnterpriseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactMethodId</column-name><column-value><![CDATA[");
		sb.append(getContactMethodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportDate</column-name><column-value><![CDATA[");
		sb.append(getReportDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cdNameId</column-name><column-value><![CDATA[");
		sb.append(getCdNameId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _reportId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _reportRemoteModel;
}