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

import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ClpSerializer;
import com.leancrm.portlet.library.service.persistence.AddressBookContactPK;

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
public class AddressBookContactClp extends BaseModelImpl<AddressBookContact>
	implements AddressBookContact {
	public AddressBookContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookContact.class.getName();
	}

	@Override
	public AddressBookContactPK getPrimaryKey() {
		return new AddressBookContactPK(_addressBookId, _contactId);
	}

	@Override
	public void setPrimaryKey(AddressBookContactPK primaryKey) {
		setAddressBookId(primaryKey.addressBookId);
		setContactId(primaryKey.contactId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AddressBookContactPK(_addressBookId, _contactId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AddressBookContactPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("assignedTo", getAssignedTo());
		attributes.put("currentProgress", getCurrentProgress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long assignedTo = (Long)attributes.get("assignedTo");

		if (assignedTo != null) {
			setAssignedTo(assignedTo);
		}

		Double currentProgress = (Double)attributes.get("currentProgress");

		if (currentProgress != null) {
			setCurrentProgress(currentProgress);
		}
	}

	@Override
	public long getAddressBookId() {
		return _addressBookId;
	}

	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressBookId", long.class);

				method.invoke(_addressBookContactRemoteModel, addressBookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_addressBookContactRemoteModel, contactId);
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

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_addressBookContactRemoteModel, groupId);
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

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_addressBookContactRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssignedTo() {
		return _assignedTo;
	}

	@Override
	public void setAssignedTo(long assignedTo) {
		_assignedTo = assignedTo;

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignedTo", long.class);

				method.invoke(_addressBookContactRemoteModel, assignedTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCurrentProgress() {
		return _currentProgress;
	}

	@Override
	public void setCurrentProgress(double currentProgress) {
		_currentProgress = currentProgress;

		if (_addressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _addressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentProgress",
						double.class);

				method.invoke(_addressBookContactRemoteModel, currentProgress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressBookContactRemoteModel() {
		return _addressBookContactRemoteModel;
	}

	public void setAddressBookContactRemoteModel(
		BaseModel<?> addressBookContactRemoteModel) {
		_addressBookContactRemoteModel = addressBookContactRemoteModel;
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

		Class<?> remoteModelClass = _addressBookContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressBookContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressBookContactLocalServiceUtil.addAddressBookContact(this);
		}
		else {
			AddressBookContactLocalServiceUtil.updateAddressBookContact(this);
		}
	}

	@Override
	public AddressBookContact toEscapedModel() {
		return (AddressBookContact)ProxyUtil.newProxyInstance(AddressBookContact.class.getClassLoader(),
			new Class[] { AddressBookContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressBookContactClp clone = new AddressBookContactClp();

		clone.setAddressBookId(getAddressBookId());
		clone.setContactId(getContactId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setAssignedTo(getAssignedTo());
		clone.setCurrentProgress(getCurrentProgress());

		return clone;
	}

	@Override
	public int compareTo(AddressBookContact addressBookContact) {
		AddressBookContactPK primaryKey = addressBookContact.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookContactClp)) {
			return false;
		}

		AddressBookContactClp addressBookContact = (AddressBookContactClp)obj;

		AddressBookContactPK primaryKey = addressBookContact.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{addressBookId=");
		sb.append(getAddressBookId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", assignedTo=");
		sb.append(getAssignedTo());
		sb.append(", currentProgress=");
		sb.append(getCurrentProgress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.AddressBookContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressBookId</column-name><column-value><![CDATA[");
		sb.append(getAddressBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
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
			"<column><column-name>assignedTo</column-name><column-value><![CDATA[");
		sb.append(getAssignedTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentProgress</column-name><column-value><![CDATA[");
		sb.append(getCurrentProgress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressBookId;
	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _assignedTo;
	private double _currentProgress;
	private BaseModel<?> _addressBookContactRemoteModel;
}