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
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;

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
public class ContactDataMethodClp extends BaseModelImpl<ContactDataMethod>
	implements ContactDataMethod {
	public ContactDataMethodClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataMethod.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataMethod.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contactDataMethodId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactDataMethodId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactDataMethodId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataMethodId", getContactDataMethodId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("contactDataType", getContactDataType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataMethodId = (Long)attributes.get("contactDataMethodId");

		if (contactDataMethodId != null) {
			setContactDataMethodId(contactDataMethodId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer contactDataType = (Integer)attributes.get("contactDataType");

		if (contactDataType != null) {
			setContactDataType(contactDataType);
		}
	}

	@Override
	public long getContactDataMethodId() {
		return _contactDataMethodId;
	}

	@Override
	public void setContactDataMethodId(long contactDataMethodId) {
		_contactDataMethodId = contactDataMethodId;

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataMethodId",
						long.class);

				method.invoke(_contactDataMethodRemoteModel, contactDataMethodId);
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

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contactDataMethodRemoteModel, groupId);
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

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contactDataMethodRemoteModel, companyId);
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

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_contactDataMethodRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_contactDataMethodRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getContactDataType() {
		return _contactDataType;
	}

	@Override
	public void setContactDataType(int contactDataType) {
		_contactDataType = contactDataType;

		if (_contactDataMethodRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataMethodRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataType", int.class);

				method.invoke(_contactDataMethodRemoteModel, contactDataType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactDataMethodRemoteModel() {
		return _contactDataMethodRemoteModel;
	}

	public void setContactDataMethodRemoteModel(
		BaseModel<?> contactDataMethodRemoteModel) {
		_contactDataMethodRemoteModel = contactDataMethodRemoteModel;
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

		Class<?> remoteModelClass = _contactDataMethodRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactDataMethodRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactDataMethodLocalServiceUtil.addContactDataMethod(this);
		}
		else {
			ContactDataMethodLocalServiceUtil.updateContactDataMethod(this);
		}
	}

	@Override
	public ContactDataMethod toEscapedModel() {
		return (ContactDataMethod)ProxyUtil.newProxyInstance(ContactDataMethod.class.getClassLoader(),
			new Class[] { ContactDataMethod.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactDataMethodClp clone = new ContactDataMethodClp();

		clone.setContactDataMethodId(getContactDataMethodId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setContactDataType(getContactDataType());

		return clone;
	}

	@Override
	public int compareTo(ContactDataMethod contactDataMethod) {
		long primaryKey = contactDataMethod.getPrimaryKey();

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

		if (!(obj instanceof ContactDataMethodClp)) {
			return false;
		}

		ContactDataMethodClp contactDataMethod = (ContactDataMethodClp)obj;

		long primaryKey = contactDataMethod.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{contactDataMethodId=");
		sb.append(getContactDataMethodId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", contactDataType=");
		sb.append(getContactDataType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactDataMethod");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDataMethodId</column-name><column-value><![CDATA[");
		sb.append(getContactDataMethodId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDataType</column-name><column-value><![CDATA[");
		sb.append(getContactDataType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactDataMethodId;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _title;
	private int _contactDataType;
	private BaseModel<?> _contactDataMethodRemoteModel;
}