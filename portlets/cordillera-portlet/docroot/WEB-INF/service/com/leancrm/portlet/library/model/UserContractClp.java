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
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.leancrm.portlet.library.service.persistence.UserContractPK;

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
public class UserContractClp extends BaseModelImpl<UserContract>
	implements UserContract {
	public UserContractClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserContract.class;
	}

	@Override
	public String getModelClassName() {
		return UserContract.class.getName();
	}

	@Override
	public UserContractPK getPrimaryKey() {
		return new UserContractPK(_userId, _contractId);
	}

	@Override
	public void setPrimaryKey(UserContractPK primaryKey) {
		setUserId(primaryKey.userId);
		setContractId(primaryKey.contractId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserContractPK(_userId, _contractId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserContractPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("contractId", getContractId());
		attributes.put("active", getActive());
		attributes.put("accessLevel", getAccessLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer accessLevel = (Integer)attributes.get("accessLevel");

		if (accessLevel != null) {
			setAccessLevel(accessLevel);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userContractRemoteModel != null) {
			try {
				Class<?> clazz = _userContractRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userContractRemoteModel, userId);
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

	@Override
	public long getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(long contractId) {
		_contractId = contractId;

		if (_userContractRemoteModel != null) {
			try {
				Class<?> clazz = _userContractRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", long.class);

				method.invoke(_userContractRemoteModel, contractId);
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

		if (_userContractRemoteModel != null) {
			try {
				Class<?> clazz = _userContractRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_userContractRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAccessLevel() {
		return _accessLevel;
	}

	@Override
	public void setAccessLevel(int accessLevel) {
		_accessLevel = accessLevel;

		if (_userContractRemoteModel != null) {
			try {
				Class<?> clazz = _userContractRemoteModel.getClass();

				Method method = clazz.getMethod("setAccessLevel", int.class);

				method.invoke(_userContractRemoteModel, accessLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserContractRemoteModel() {
		return _userContractRemoteModel;
	}

	public void setUserContractRemoteModel(BaseModel<?> userContractRemoteModel) {
		_userContractRemoteModel = userContractRemoteModel;
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

		Class<?> remoteModelClass = _userContractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userContractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserContractLocalServiceUtil.addUserContract(this);
		}
		else {
			UserContractLocalServiceUtil.updateUserContract(this);
		}
	}

	@Override
	public UserContract toEscapedModel() {
		return (UserContract)ProxyUtil.newProxyInstance(UserContract.class.getClassLoader(),
			new Class[] { UserContract.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserContractClp clone = new UserContractClp();

		clone.setUserId(getUserId());
		clone.setContractId(getContractId());
		clone.setActive(getActive());
		clone.setAccessLevel(getAccessLevel());

		return clone;
	}

	@Override
	public int compareTo(UserContract userContract) {
		UserContractPK primaryKey = userContract.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserContractClp)) {
			return false;
		}

		UserContractClp userContract = (UserContractClp)obj;

		UserContractPK primaryKey = userContract.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", accessLevel=");
		sb.append(getAccessLevel());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.UserContract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessLevel</column-name><column-value><![CDATA[");
		sb.append(getAccessLevel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _contractId;
	private boolean _active;
	private int _accessLevel;
	private BaseModel<?> _userContractRemoteModel;
}