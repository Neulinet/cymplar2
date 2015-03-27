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
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;

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
public class ContactDataRefClp extends BaseModelImpl<ContactDataRef>
	implements ContactDataRef {
	public ContactDataRefClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataRef.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataRef.class.getName();
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
		attributes.put("refValue", getRefValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long refValue = (Long)attributes.get("refValue");

		if (refValue != null) {
			setRefValue(refValue);
		}
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;

		if (_contactDataRefRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRefRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataId", long.class);

				method.invoke(_contactDataRefRemoteModel, contactDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRefValue() {
		return _refValue;
	}

	@Override
	public void setRefValue(long refValue) {
		_refValue = refValue;

		if (_contactDataRefRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRefRemoteModel.getClass();

				Method method = clazz.getMethod("setRefValue", long.class);

				method.invoke(_contactDataRefRemoteModel, refValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactDataRefRemoteModel() {
		return _contactDataRefRemoteModel;
	}

	public void setContactDataRefRemoteModel(
		BaseModel<?> contactDataRefRemoteModel) {
		_contactDataRefRemoteModel = contactDataRefRemoteModel;
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

		Class<?> remoteModelClass = _contactDataRefRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactDataRefRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactDataRefLocalServiceUtil.addContactDataRef(this);
		}
		else {
			ContactDataRefLocalServiceUtil.updateContactDataRef(this);
		}
	}

	@Override
	public ContactDataRef toEscapedModel() {
		return (ContactDataRef)ProxyUtil.newProxyInstance(ContactDataRef.class.getClassLoader(),
			new Class[] { ContactDataRef.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactDataRefClp clone = new ContactDataRefClp();

		clone.setContactDataId(getContactDataId());
		clone.setRefValue(getRefValue());

		return clone;
	}

	@Override
	public int compareTo(ContactDataRef contactDataRef) {
		long primaryKey = contactDataRef.getPrimaryKey();

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

		if (!(obj instanceof ContactDataRefClp)) {
			return false;
		}

		ContactDataRefClp contactDataRef = (ContactDataRefClp)obj;

		long primaryKey = contactDataRef.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{contactDataId=");
		sb.append(getContactDataId());
		sb.append(", refValue=");
		sb.append(getRefValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactDataRef");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refValue</column-name><column-value><![CDATA[");
		sb.append(getRefValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactDataId;
	private long _refValue;
	private BaseModel<?> _contactDataRefRemoteModel;
}