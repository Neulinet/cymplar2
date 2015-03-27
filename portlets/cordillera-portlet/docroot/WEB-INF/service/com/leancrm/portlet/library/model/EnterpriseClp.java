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
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class EnterpriseClp extends BaseModelImpl<Enterprise>
	implements Enterprise {
	public EnterpriseClp() {
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

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setEnterpriseId", long.class);

				method.invoke(_enterpriseRemoteModel, enterpriseId);
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

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_enterpriseRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsPrivate() {
		return _isPrivate;
	}

	@Override
	public void setIsPrivate(int isPrivate) {
		_isPrivate = isPrivate;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPrivate", int.class);

				method.invoke(_enterpriseRemoteModel, isPrivate);
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

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_enterpriseRemoteModel, companyId);
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

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enterpriseRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_enterpriseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_enterpriseRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxid() {
		return _taxid;
	}

	@Override
	public void setTaxid(String taxid) {
		_taxid = taxid;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxid", String.class);

				method.invoke(_enterpriseRemoteModel, taxid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_enterpriseRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndustry() {
		return _industry;
	}

	@Override
	public void setIndustry(long industry) {
		_industry = industry;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setIndustry", long.class);

				method.invoke(_enterpriseRemoteModel, industry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_enterpriseRemoteModel != null) {
			try {
				Class<?> clazz = _enterpriseRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_enterpriseRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEnterpriseRemoteModel() {
		return _enterpriseRemoteModel;
	}

	public void setEnterpriseRemoteModel(BaseModel<?> enterpriseRemoteModel) {
		_enterpriseRemoteModel = enterpriseRemoteModel;
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

		Class<?> remoteModelClass = _enterpriseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enterpriseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnterpriseLocalServiceUtil.addEnterprise(this);
		}
		else {
			EnterpriseLocalServiceUtil.updateEnterprise(this);
		}
	}

	@Override
	public Enterprise toEscapedModel() {
		return (Enterprise)ProxyUtil.newProxyInstance(Enterprise.class.getClassLoader(),
			new Class[] { Enterprise.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnterpriseClp clone = new EnterpriseClp();

		clone.setEnterpriseId(getEnterpriseId());
		clone.setGroupId(getGroupId());
		clone.setIsPrivate(getIsPrivate());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setTaxid(getTaxid());
		clone.setDescription(getDescription());
		clone.setIndustry(getIndustry());
		clone.setEmail(getEmail());

		return clone;
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

		if (!(obj instanceof EnterpriseClp)) {
			return false;
		}

		EnterpriseClp enterprise = (EnterpriseClp)obj;

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

	private long _enterpriseId;
	private long _groupId;
	private int _isPrivate;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _taxid;
	private String _description;
	private long _industry;
	private String _email;
	private BaseModel<?> _enterpriseRemoteModel;
}