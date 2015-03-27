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
import com.leancrm.portlet.library.service.ContactContractLocalServiceUtil;
import com.leancrm.portlet.library.service.persistence.ContactContractPK;

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
public class ContactContractClp extends BaseModelImpl<ContactContract>
	implements ContactContract {
	public ContactContractClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactContract.class;
	}

	@Override
	public String getModelClassName() {
		return ContactContract.class.getName();
	}

	@Override
	public ContactContractPK getPrimaryKey() {
		return new ContactContractPK(_contactId, _contractId);
	}

	@Override
	public void setPrimaryKey(ContactContractPK primaryKey) {
		setContactId(primaryKey.contactId);
		setContractId(primaryKey.contractId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ContactContractPK(_contactId, _contractId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ContactContractPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("contractId", getContractId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_contactContractRemoteModel != null) {
			try {
				Class<?> clazz = _contactContractRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_contactContractRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(long contractId) {
		_contractId = contractId;

		if (_contactContractRemoteModel != null) {
			try {
				Class<?> clazz = _contactContractRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", long.class);

				method.invoke(_contactContractRemoteModel, contractId);
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

		if (_contactContractRemoteModel != null) {
			try {
				Class<?> clazz = _contactContractRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_contactContractRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactContractRemoteModel() {
		return _contactContractRemoteModel;
	}

	public void setContactContractRemoteModel(
		BaseModel<?> contactContractRemoteModel) {
		_contactContractRemoteModel = contactContractRemoteModel;
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

		Class<?> remoteModelClass = _contactContractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactContractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactContractLocalServiceUtil.addContactContract(this);
		}
		else {
			ContactContractLocalServiceUtil.updateContactContract(this);
		}
	}

	@Override
	public ContactContract toEscapedModel() {
		return (ContactContract)ProxyUtil.newProxyInstance(ContactContract.class.getClassLoader(),
			new Class[] { ContactContract.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactContractClp clone = new ContactContractClp();

		clone.setContactId(getContactId());
		clone.setContractId(getContractId());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(ContactContract contactContract) {
		ContactContractPK primaryKey = contactContract.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactContractClp)) {
			return false;
		}

		ContactContractClp contactContract = (ContactContractClp)obj;

		ContactContractPK primaryKey = contactContract.getPrimaryKey();

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

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactContract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private long _contractId;
	private boolean _active;
	private BaseModel<?> _contactContractRemoteModel;
}