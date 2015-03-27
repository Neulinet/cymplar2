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
import com.leancrm.portlet.library.service.OrganizationIndustryLocalServiceUtil;
import com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationIndustryClp extends BaseModelImpl<OrganizationIndustry>
	implements OrganizationIndustry {
	public OrganizationIndustryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizationIndustry.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizationIndustry.class.getName();
	}

	@Override
	public OrganizationIndustryPK getPrimaryKey() {
		return new OrganizationIndustryPK(_organizationId, _industryId);
	}

	@Override
	public void setPrimaryKey(OrganizationIndustryPK primaryKey) {
		setOrganizationId(primaryKey.organizationId);
		setIndustryId(primaryKey.industryId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new OrganizationIndustryPK(_organizationId, _industryId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((OrganizationIndustryPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationId", getOrganizationId());
		attributes.put("industryId", getIndustryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long industryId = (Long)attributes.get("industryId");

		if (industryId != null) {
			setIndustryId(industryId);
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_organizationIndustryRemoteModel != null) {
			try {
				Class<?> clazz = _organizationIndustryRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_organizationIndustryRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndustryId() {
		return _industryId;
	}

	@Override
	public void setIndustryId(long industryId) {
		_industryId = industryId;

		if (_organizationIndustryRemoteModel != null) {
			try {
				Class<?> clazz = _organizationIndustryRemoteModel.getClass();

				Method method = clazz.getMethod("setIndustryId", long.class);

				method.invoke(_organizationIndustryRemoteModel, industryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrganizationIndustryRemoteModel() {
		return _organizationIndustryRemoteModel;
	}

	public void setOrganizationIndustryRemoteModel(
		BaseModel<?> organizationIndustryRemoteModel) {
		_organizationIndustryRemoteModel = organizationIndustryRemoteModel;
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

		Class<?> remoteModelClass = _organizationIndustryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_organizationIndustryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationIndustryLocalServiceUtil.addOrganizationIndustry(this);
		}
		else {
			OrganizationIndustryLocalServiceUtil.updateOrganizationIndustry(this);
		}
	}

	@Override
	public OrganizationIndustry toEscapedModel() {
		return (OrganizationIndustry)ProxyUtil.newProxyInstance(OrganizationIndustry.class.getClassLoader(),
			new Class[] { OrganizationIndustry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationIndustryClp clone = new OrganizationIndustryClp();

		clone.setOrganizationId(getOrganizationId());
		clone.setIndustryId(getIndustryId());

		return clone;
	}

	@Override
	public int compareTo(OrganizationIndustry organizationIndustry) {
		OrganizationIndustryPK primaryKey = organizationIndustry.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationIndustryClp)) {
			return false;
		}

		OrganizationIndustryClp organizationIndustry = (OrganizationIndustryClp)obj;

		OrganizationIndustryPK primaryKey = organizationIndustry.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{organizationId=");
		sb.append(getOrganizationId());
		sb.append(", industryId=");
		sb.append(getIndustryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.OrganizationIndustry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>industryId</column-name><column-value><![CDATA[");
		sb.append(getIndustryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _organizationId;
	private long _industryId;
	private BaseModel<?> _organizationIndustryRemoteModel;
}