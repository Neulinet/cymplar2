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

import com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil;
import com.leancrm.portlet.library.service.ClpSerializer;

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
public class AddressBookOrganizationClp extends BaseModelImpl<AddressBookOrganization>
	implements AddressBookOrganization {
	public AddressBookOrganizationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookOrganization.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _addressBookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAddressBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressBookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	@Override
	public long getAddressBookId() {
		return _addressBookId;
	}

	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;

		if (_addressBookOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressBookId", long.class);

				method.invoke(_addressBookOrganizationRemoteModel, addressBookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_addressBookOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_addressBookOrganizationRemoteModel,
					organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressBookOrganizationRemoteModel() {
		return _addressBookOrganizationRemoteModel;
	}

	public void setAddressBookOrganizationRemoteModel(
		BaseModel<?> addressBookOrganizationRemoteModel) {
		_addressBookOrganizationRemoteModel = addressBookOrganizationRemoteModel;
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

		Class<?> remoteModelClass = _addressBookOrganizationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressBookOrganizationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressBookOrganizationLocalServiceUtil.addAddressBookOrganization(this);
		}
		else {
			AddressBookOrganizationLocalServiceUtil.updateAddressBookOrganization(this);
		}
	}

	@Override
	public AddressBookOrganization toEscapedModel() {
		return (AddressBookOrganization)ProxyUtil.newProxyInstance(AddressBookOrganization.class.getClassLoader(),
			new Class[] { AddressBookOrganization.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressBookOrganizationClp clone = new AddressBookOrganizationClp();

		clone.setAddressBookId(getAddressBookId());
		clone.setOrganizationId(getOrganizationId());

		return clone;
	}

	@Override
	public int compareTo(AddressBookOrganization addressBookOrganization) {
		long primaryKey = addressBookOrganization.getPrimaryKey();

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

		if (!(obj instanceof AddressBookOrganizationClp)) {
			return false;
		}

		AddressBookOrganizationClp addressBookOrganization = (AddressBookOrganizationClp)obj;

		long primaryKey = addressBookOrganization.getPrimaryKey();

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

		sb.append("{addressBookId=");
		sb.append(getAddressBookId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.AddressBookOrganization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressBookId</column-name><column-value><![CDATA[");
		sb.append(getAddressBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressBookId;
	private long _organizationId;
	private BaseModel<?> _addressBookOrganizationRemoteModel;
}