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
import com.leancrm.portlet.library.model.ReportModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Report service. Represents a row in the &quot;crm_Report&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.leancrm.portlet.library.model.ReportModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReportImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportImpl
 * @see com.leancrm.portlet.library.model.Report
 * @see com.leancrm.portlet.library.model.ReportModel
 * @generated
 */
public class ReportModelImpl extends BaseModelImpl<Report>
	implements ReportModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a report model instance should use the {@link com.leancrm.portlet.library.model.Report} interface instead.
	 */
	public static final String TABLE_NAME = "crm_Report";
	public static final Object[][] TABLE_COLUMNS = {
			{ "reportId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "enterpriseId", Types.BIGINT },
			{ "contactId", Types.BIGINT },
			{ "contactDataId", Types.BIGINT },
			{ "contactMethodId", Types.BIGINT },
			{ "reportDate", Types.TIMESTAMP },
			{ "comments", Types.VARCHAR },
			{ "progress", Types.DOUBLE },
			{ "status", Types.INTEGER },
			{ "contractId", Types.BIGINT },
			{ "cdNameId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table crm_Report (reportId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,userId LONG,organizationId LONG,enterpriseId LONG,contactId LONG,contactDataId LONG,contactMethodId LONG,reportDate DATE null,comments VARCHAR(500) null,progress DOUBLE,status INTEGER,contractId LONG,cdNameId LONG)";
	public static final String TABLE_SQL_DROP = "drop table crm_Report";
	public static final String ORDER_BY_JPQL = " ORDER BY report.reportId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY crm_Report.reportId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.leancrm.portlet.library.model.Report"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.leancrm.portlet.library.model.Report"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.leancrm.portlet.library.model.Report"),
			true);
	public static long CONTACTID_COLUMN_BITMASK = 1L;
	public static long CONTRACTID_COLUMN_BITMASK = 2L;
	public static long ENTERPRISEID_COLUMN_BITMASK = 4L;
	public static long ORGANIZATIONID_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;
	public static long REPORTID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.leancrm.portlet.library.model.Report"));

	public ReportModelImpl() {
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
	public Class<?> getModelClass() {
		return Report.class;
	}

	@Override
	public String getModelClassName() {
		return Report.class.getName();
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
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask |= ORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	@Override
	public long getEnterpriseId() {
		return _enterpriseId;
	}

	@Override
	public void setEnterpriseId(long enterpriseId) {
		_columnBitmask |= ENTERPRISEID_COLUMN_BITMASK;

		if (!_setOriginalEnterpriseId) {
			_setOriginalEnterpriseId = true;

			_originalEnterpriseId = _enterpriseId;
		}

		_enterpriseId = enterpriseId;
	}

	public long getOriginalEnterpriseId() {
		return _originalEnterpriseId;
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_columnBitmask |= CONTACTID_COLUMN_BITMASK;

		if (!_setOriginalContactId) {
			_setOriginalContactId = true;

			_originalContactId = _contactId;
		}

		_contactId = contactId;
	}

	public long getOriginalContactId() {
		return _originalContactId;
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;
	}

	@Override
	public long getContactMethodId() {
		return _contactMethodId;
	}

	@Override
	public void setContactMethodId(long contactMethodId) {
		_contactMethodId = contactMethodId;
	}

	@Override
	public Date getReportDate() {
		return _reportDate;
	}

	@Override
	public void setReportDate(Date reportDate) {
		_reportDate = reportDate;
	}

	@Override
	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
	}

	@Override
	public double getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(double progress) {
		_progress = progress;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(long contractId) {
		_columnBitmask |= CONTRACTID_COLUMN_BITMASK;

		if (!_setOriginalContractId) {
			_setOriginalContractId = true;

			_originalContractId = _contractId;
		}

		_contractId = contractId;
	}

	public long getOriginalContractId() {
		return _originalContractId;
	}

	@Override
	public long getCdNameId() {
		return _cdNameId;
	}

	@Override
	public void setCdNameId(long cdNameId) {
		_cdNameId = cdNameId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Report.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Report toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Report)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReportImpl reportImpl = new ReportImpl();

		reportImpl.setReportId(getReportId());
		reportImpl.setGroupId(getGroupId());
		reportImpl.setCompanyId(getCompanyId());
		reportImpl.setCreateDate(getCreateDate());
		reportImpl.setUserId(getUserId());
		reportImpl.setOrganizationId(getOrganizationId());
		reportImpl.setEnterpriseId(getEnterpriseId());
		reportImpl.setContactId(getContactId());
		reportImpl.setContactDataId(getContactDataId());
		reportImpl.setContactMethodId(getContactMethodId());
		reportImpl.setReportDate(getReportDate());
		reportImpl.setComments(getComments());
		reportImpl.setProgress(getProgress());
		reportImpl.setStatus(getStatus());
		reportImpl.setContractId(getContractId());
		reportImpl.setCdNameId(getCdNameId());

		reportImpl.resetOriginalValues();

		return reportImpl;
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

		if (!(obj instanceof Report)) {
			return false;
		}

		Report report = (Report)obj;

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
	public void resetOriginalValues() {
		ReportModelImpl reportModelImpl = this;

		reportModelImpl._originalUserId = reportModelImpl._userId;

		reportModelImpl._setOriginalUserId = false;

		reportModelImpl._originalOrganizationId = reportModelImpl._organizationId;

		reportModelImpl._setOriginalOrganizationId = false;

		reportModelImpl._originalEnterpriseId = reportModelImpl._enterpriseId;

		reportModelImpl._setOriginalEnterpriseId = false;

		reportModelImpl._originalContactId = reportModelImpl._contactId;

		reportModelImpl._setOriginalContactId = false;

		reportModelImpl._originalContractId = reportModelImpl._contractId;

		reportModelImpl._setOriginalContractId = false;

		reportModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Report> toCacheModel() {
		ReportCacheModel reportCacheModel = new ReportCacheModel();

		reportCacheModel.reportId = getReportId();

		reportCacheModel.groupId = getGroupId();

		reportCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			reportCacheModel.createDate = createDate.getTime();
		}
		else {
			reportCacheModel.createDate = Long.MIN_VALUE;
		}

		reportCacheModel.userId = getUserId();

		reportCacheModel.organizationId = getOrganizationId();

		reportCacheModel.enterpriseId = getEnterpriseId();

		reportCacheModel.contactId = getContactId();

		reportCacheModel.contactDataId = getContactDataId();

		reportCacheModel.contactMethodId = getContactMethodId();

		Date reportDate = getReportDate();

		if (reportDate != null) {
			reportCacheModel.reportDate = reportDate.getTime();
		}
		else {
			reportCacheModel.reportDate = Long.MIN_VALUE;
		}

		reportCacheModel.comments = getComments();

		String comments = reportCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			reportCacheModel.comments = null;
		}

		reportCacheModel.progress = getProgress();

		reportCacheModel.status = getStatus();

		reportCacheModel.contractId = getContractId();

		reportCacheModel.cdNameId = getCdNameId();

		return reportCacheModel;
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

	private static ClassLoader _classLoader = Report.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Report.class };
	private long _reportId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private long _enterpriseId;
	private long _originalEnterpriseId;
	private boolean _setOriginalEnterpriseId;
	private long _contactId;
	private long _originalContactId;
	private boolean _setOriginalContactId;
	private long _contactDataId;
	private long _contactMethodId;
	private Date _reportDate;
	private String _comments;
	private double _progress;
	private int _status;
	private long _contractId;
	private long _originalContractId;
	private boolean _setOriginalContractId;
	private long _cdNameId;
	private long _columnBitmask;
	private Report _escapedModel;
}