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
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;

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
public class ContactDataPhoneClp extends BaseModelImpl<ContactDataPhone>
	implements ContactDataPhone {
	public ContactDataPhoneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataPhone.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataPhone.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contactDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("extension", getExtension());
		attributes.put("number", getNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		String extension = (String)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;

		if (_contactDataPhoneRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataPhoneRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataId", long.class);

				method.invoke(_contactDataPhoneRemoteModel, contactDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtension() {
		return _extension;
	}

	@Override
	public void setExtension(String extension) {
		_extension = extension;

		if (_contactDataPhoneRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataPhoneRemoteModel.getClass();

				Method method = clazz.getMethod("setExtension", String.class);

				method.invoke(_contactDataPhoneRemoteModel, extension);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNumber() {
		return _number;
	}

	@Override
	public void setNumber(String number) {
		_number = number;

		if (_contactDataPhoneRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataPhoneRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", String.class);

				method.invoke(_contactDataPhoneRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactDataPhoneRemoteModel() {
		return _contactDataPhoneRemoteModel;
	}

	public void setContactDataPhoneRemoteModel(
		BaseModel<?> contactDataPhoneRemoteModel) {
		_contactDataPhoneRemoteModel = contactDataPhoneRemoteModel;
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

		Class<?> remoteModelClass = _contactDataPhoneRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactDataPhoneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactDataPhoneLocalServiceUtil.addContactDataPhone(this);
		}
		else {
			ContactDataPhoneLocalServiceUtil.updateContactDataPhone(this);
		}
	}

	@Override
	public ContactDataPhone toEscapedModel() {
		return (ContactDataPhone)ProxyUtil.newProxyInstance(ContactDataPhone.class.getClassLoader(),
			new Class[] { ContactDataPhone.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactDataPhoneClp clone = new ContactDataPhoneClp();

		clone.setContactDataId(getContactDataId());
		clone.setExtension(getExtension());
		clone.setNumber(getNumber());

		return clone;
	}

	@Override
	public int compareTo(ContactDataPhone contactDataPhone) {
		long primaryKey = contactDataPhone.getPrimaryKey();

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

		if (!(obj instanceof ContactDataPhoneClp)) {
			return false;
		}

		ContactDataPhoneClp contactDataPhone = (ContactDataPhoneClp)obj;

		long primaryKey = contactDataPhone.getPrimaryKey();

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

		sb.append("{contactDataId=");
		sb.append(getContactDataId());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactDataPhone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactDataId;
	private String _extension;
	private String _number;
	private BaseModel<?> _contactDataPhoneRemoteModel;
}