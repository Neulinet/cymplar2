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

import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressBookUserClp extends BaseModelImpl<AddressBookUser>
	implements AddressBookUser {
	public AddressBookUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookUser.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookUser.class.getName();
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
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getAddressBookId() {
		return _addressBookId;
	}

	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;

		if (_addressBookUserRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressBookId", long.class);

				method.invoke(_addressBookUserRemoteModel, addressBookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_addressBookUserRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_addressBookUserRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getAddressBookUserRemoteModel() {
		return _addressBookUserRemoteModel;
	}

	public void setAddressBookUserRemoteModel(
		BaseModel<?> addressBookUserRemoteModel) {
		_addressBookUserRemoteModel = addressBookUserRemoteModel;
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

		Class<?> remoteModelClass = _addressBookUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressBookUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressBookUserLocalServiceUtil.addAddressBookUser(this);
		}
		else {
			AddressBookUserLocalServiceUtil.updateAddressBookUser(this);
		}
	}

	@Override
	public AddressBookUser toEscapedModel() {
		return (AddressBookUser)ProxyUtil.newProxyInstance(AddressBookUser.class.getClassLoader(),
			new Class[] { AddressBookUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressBookUserClp clone = new AddressBookUserClp();

		clone.setAddressBookId(getAddressBookId());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(AddressBookUser addressBookUser) {
		long primaryKey = addressBookUser.getPrimaryKey();

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

		if (!(obj instanceof AddressBookUserClp)) {
			return false;
		}

		AddressBookUserClp addressBookUser = (AddressBookUserClp)obj;

		long primaryKey = addressBookUser.getPrimaryKey();

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
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.AddressBookUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressBookId</column-name><column-value><![CDATA[");
		sb.append(getAddressBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressBookId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _addressBookUserRemoteModel;
}