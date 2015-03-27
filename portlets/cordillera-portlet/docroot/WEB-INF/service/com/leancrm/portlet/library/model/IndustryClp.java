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
import com.leancrm.portlet.library.service.IndustryLocalServiceUtil;

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
public class IndustryClp extends BaseModelImpl<Industry> implements Industry {
	public IndustryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Industry.class;
	}

	@Override
	public String getModelClassName() {
		return Industry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _industryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIndustryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _industryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("industryId", getIndustryId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long industryId = (Long)attributes.get("industryId");

		if (industryId != null) {
			setIndustryId(industryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getIndustryId() {
		return _industryId;
	}

	@Override
	public void setIndustryId(long industryId) {
		_industryId = industryId;

		if (_industryRemoteModel != null) {
			try {
				Class<?> clazz = _industryRemoteModel.getClass();

				Method method = clazz.getMethod("setIndustryId", long.class);

				method.invoke(_industryRemoteModel, industryId);
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

		if (_industryRemoteModel != null) {
			try {
				Class<?> clazz = _industryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_industryRemoteModel, groupId);
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

		if (_industryRemoteModel != null) {
			try {
				Class<?> clazz = _industryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_industryRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIndustryRemoteModel() {
		return _industryRemoteModel;
	}

	public void setIndustryRemoteModel(BaseModel<?> industryRemoteModel) {
		_industryRemoteModel = industryRemoteModel;
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

		Class<?> remoteModelClass = _industryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_industryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IndustryLocalServiceUtil.addIndustry(this);
		}
		else {
			IndustryLocalServiceUtil.updateIndustry(this);
		}
	}

	@Override
	public Industry toEscapedModel() {
		return (Industry)ProxyUtil.newProxyInstance(Industry.class.getClassLoader(),
			new Class[] { Industry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IndustryClp clone = new IndustryClp();

		clone.setIndustryId(getIndustryId());
		clone.setGroupId(getGroupId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Industry industry) {
		long primaryKey = industry.getPrimaryKey();

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

		if (!(obj instanceof IndustryClp)) {
			return false;
		}

		IndustryClp industry = (IndustryClp)obj;

		long primaryKey = industry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{industryId=");
		sb.append(getIndustryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.Industry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>industryId</column-name><column-value><![CDATA[");
		sb.append(getIndustryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _industryId;
	private long _groupId;
	private String _name;
	private BaseModel<?> _industryRemoteModel;
}