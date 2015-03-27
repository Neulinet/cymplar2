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

import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.EnterpriseModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Enterprise service. Represents a row in the &quot;crm_Enterprise&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.leancrm.portlet.library.model.EnterpriseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EnterpriseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnterpriseImpl
 * @see com.leancrm.portlet.library.model.Enterprise
 * @see com.leancrm.portlet.library.model.EnterpriseModel
 * @generated
 */
public class EnterpriseModelImpl extends BaseModelImpl<Enterprise>
	implements EnterpriseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a enterprise model instance should use the {@link com.leancrm.portlet.library.model.Enterprise} interface instead.
	 */
	public static final String TABLE_NAME = "crm_Enterprise";
	public static final Object[][] TABLE_COLUMNS = {
			{ "enterpriseId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "isPrivate", Types.INTEGER },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "taxid", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "industry", Types.BIGINT },
			{ "email", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table crm_Enterprise (enterpriseId LONG not null primary key,groupId LONG,isPrivate INTEGER,companyId LONG,createDate DATE null,modifiedDate DATE null,name VARCHAR(250) null,taxid VARCHAR(75) null,description VARCHAR(250) null,industry LONG,email VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table crm_Enterprise";
	public static final String ORDER_BY_JPQL = " ORDER BY enterprise.enterpriseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY crm_Enterprise.enterpriseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.leancrm.portlet.library.model.Enterprise"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.leancrm.portlet.library.model.Enterprise"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.leancrm.portlet.library.model.Enterprise"),
			true);
	public static long INDUSTRY_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long TAXID_COLUMN_BITMASK = 4L;
	public static long ENTERPRISEID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.leancrm.portlet.library.model.Enterprise"));

	public EnterpriseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _enterpriseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEnterpriseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _enterpriseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Enterprise.class;
	}

	@Override
	public String getModelClassName() {
		return Enterprise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("groupId", getGroupId());
		attributes.put("isPrivate", getIsPrivate());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("taxid", getTaxid());
		attributes.put("description", getDescription());
		attributes.put("industry", getIndustry());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer isPrivate = (Integer)attributes.get("isPrivate");

		if (isPrivate != null) {
			setIsPrivate(isPrivate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String taxid = (String)attributes.get("taxid");

		if (taxid != null) {
			setTaxid(taxid);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long industry = (Long)attributes.get("industry");

		if (industry != null) {
			setIndustry(industry);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public long getEnterpriseId() {
		return _enterpriseId;
	}

	@Override
	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;
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
	public int getIsPrivate() {
		return _isPrivate;
	}

	@Override
	public void setIsPrivate(int isPrivate) {
		_isPrivate = isPrivate;
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public String getTaxid() {
		if (_taxid == null) {
			return StringPool.BLANK;
		}
		else {
			return _taxid;
		}
	}

	@Override
	public void setTaxid(String taxid) {
		_columnBitmask |= TAXID_COLUMN_BITMASK;

		if (_originalTaxid == null) {
			_originalTaxid = _taxid;
		}

		_taxid = taxid;
	}

	public String getOriginalTaxid() {
		return GetterUtil.getString(_originalTaxid);
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public long getIndustry() {
		return _industry;
	}

	@Override
	public void setIndustry(long industry) {
		_columnBitmask |= INDUSTRY_COLUMN_BITMASK;

		if (!_setOriginalIndustry) {
			_setOriginalIndustry = true;

			_originalIndustry = _industry;
		}

		_industry = industry;
	}

	public long getOriginalIndustry() {
		return _originalIndustry;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Enterprise.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Enterprise toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Enterprise)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EnterpriseImpl enterpriseImpl = new EnterpriseImpl();

		enterpriseImpl.setEnterpriseId(getEnterpriseId());
		enterpriseImpl.setGroupId(getGroupId());
		enterpriseImpl.setIsPrivate(getIsPrivate());
		enterpriseImpl.setCompanyId(getCompanyId());
		enterpriseImpl.setCreateDate(getCreateDate());
		enterpriseImpl.setModifiedDate(getModifiedDate());
		enterpriseImpl.setName(getName());
		enterpriseImpl.setTaxid(getTaxid());
		enterpriseImpl.setDescription(getDescription());
		enterpriseImpl.setIndustry(getIndustry());
		enterpriseImpl.setEmail(getEmail());

		enterpriseImpl.resetOriginalValues();

		return enterpriseImpl;
	}

	@Override
	public int compareTo(Enterprise enterprise) {
		long primaryKey = enterprise.getPrimaryKey();

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

		if (!(obj instanceof Enterprise)) {
			return false;
		}

		Enterprise enterprise = (Enterprise)obj;

		long primaryKey = enterprise.getPrimaryKey();

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
		EnterpriseModelImpl enterpriseModelImpl = this;

		enterpriseModelImpl._originalName = enterpriseModelImpl._name;

		enterpriseModelImpl._originalTaxid = enterpriseModelImpl._taxid;

		enterpriseModelImpl._originalIndustry = enterpriseModelImpl._industry;

		enterpriseModelImpl._setOriginalIndustry = false;

		enterpriseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Enterprise> toCacheModel() {
		EnterpriseCacheModel enterpriseCacheModel = new EnterpriseCacheModel();

		enterpriseCacheModel.enterpriseId = getEnterpriseId();

		enterpriseCacheModel.groupId = getGroupId();

		enterpriseCacheModel.isPrivate = getIsPrivate();

		enterpriseCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			enterpriseCacheModel.createDate = createDate.getTime();
		}
		else {
			enterpriseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			enterpriseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			enterpriseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		enterpriseCacheModel.name = getName();

		String name = enterpriseCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			enterpriseCacheModel.name = null;
		}

		enterpriseCacheModel.taxid = getTaxid();

		String taxid = enterpriseCacheModel.taxid;

		if ((taxid != null) && (taxid.length() == 0)) {
			enterpriseCacheModel.taxid = null;
		}

		enterpriseCacheModel.description = getDescription();

		String description = enterpriseCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			enterpriseCacheModel.description = null;
		}

		enterpriseCacheModel.industry = getIndustry();

		enterpriseCacheModel.email = getEmail();

		String email = enterpriseCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			enterpriseCacheModel.email = null;
		}

		return enterpriseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{enterpriseId=");
		sb.append(getEnterpriseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", isPrivate=");
		sb.append(getIsPrivate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", taxid=");
		sb.append(getTaxid());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", industry=");
		sb.append(getIndustry());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.Enterprise");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>enterpriseId</column-name><column-value><![CDATA[");
		sb.append(getEnterpriseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPrivate</column-name><column-value><![CDATA[");
		sb.append(getIsPrivate());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxid</column-name><column-value><![CDATA[");
		sb.append(getTaxid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>industry</column-name><column-value><![CDATA[");
		sb.append(getIndustry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Enterprise.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Enterprise.class
		};
	private long _enterpriseId;
	private long _groupId;
	private int _isPrivate;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private String _taxid;
	private String _originalTaxid;
	private String _description;
	private long _industry;
	private long _originalIndustry;
	private boolean _setOriginalIndustry;
	private String _email;
	private long _columnBitmask;
	private Enterprise _escapedModel;
}