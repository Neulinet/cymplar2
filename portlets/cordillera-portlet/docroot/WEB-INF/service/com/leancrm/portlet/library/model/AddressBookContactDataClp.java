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

import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ClpSerializer;
import com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK;

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
public class AddressBookContactDataClp extends BaseModelImpl<AddressBookContactData>
	implements AddressBookContactData {
	public AddressBookContactDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookContactData.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookContactData.class.getName();
	}

	@Override
	public AddressBookContactDataPK getPrimaryKey() {
		return new AddressBookContactDataPK(_addressBookId, _contactDataId);
	}

	@Override
	public void setPrimaryKey(AddressBookContactDataPK primaryKey) {
		setAddressBookId(primaryKey.addressBookId);
		setContactDataId(primaryKey.contactDataId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AddressBookContactDataPK(_addressBookId, _contactDataId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AddressBookContactDataPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("contactDataId", getContactDataId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getAddressBookId() {
		return _addressBookId;
	}

	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;

		if (_addressBookContactDataRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressBookId", long.class);

				method.invoke(_addressBookContactDataRemoteModel, addressBookId);
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

		if (_addressBookContactDataRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataId", long.class);

				method.invoke(_addressBookContactDataRemoteModel, contactDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_addressBookContactDataRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_addressBookContactDataRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressBookContactDataRemoteModel() {
		return _addressBookContactDataRemoteModel;
	}

	public void setAddressBookContactDataRemoteModel(
		BaseModel<?> addressBookContactDataRemoteModel) {
		_addressBookContactDataRemoteModel = addressBookContactDataRemoteModel;
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

		Class<?> remoteModelClass = _addressBookContactDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressBookContactDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressBookContactDataLocalServiceUtil.addAddressBookContactData(this);
		}
		else {
			AddressBookContactDataLocalServiceUtil.updateAddressBookContactData(this);
		}
	}

	@Override
	public AddressBookContactData toEscapedModel() {
		return (AddressBookContactData)ProxyUtil.newProxyInstance(AddressBookContactData.class.getClassLoader(),
			new Class[] { AddressBookContactData.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressBookContactDataClp clone = new AddressBookContactDataClp();

		clone.setAddressBookId(getAddressBookId());
		clone.setContactDataId(getContactDataId());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(AddressBookContactData addressBookContactData) {
		AddressBookContactDataPK primaryKey = addressBookContactData.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookContactDataClp)) {
			return false;
		}

		AddressBookContactDataClp addressBookContactData = (AddressBookContactDataClp)obj;

		AddressBookContactDataPK primaryKey = addressBookContactData.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{addressBookId=");
		sb.append(getAddressBookId());
		sb.append(", contactDataId=");
		sb.append(getContactDataId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.AddressBookContactData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressBookId</column-name><column-value><![CDATA[");
		sb.append(getAddressBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressBookId;
	private long _contactDataId;
	private boolean _active;
	private BaseModel<?> _addressBookContactDataRemoteModel;
}