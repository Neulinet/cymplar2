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
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactDataClp extends BaseModelImpl<ContactData>
	implements ContactData {
	public ContactDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactData.class;
	}

	@Override
	public String getModelClassName() {
		return ContactData.class.getName();
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
		attributes.put("groupId", getGroupId());
		attributes.put("contactDataType", getContactDataType());
		attributes.put("readOnly", getReadOnly());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("contactDataMethodId", getContactDataMethodId());
		attributes.put("contactId", getContactId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer contactDataType = (Integer)attributes.get("contactDataType");

		if (contactDataType != null) {
			setContactDataType(contactDataType);
		}

		Boolean readOnly = (Boolean)attributes.get("readOnly");

		if (readOnly != null) {
			setReadOnly(readOnly);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long contactDataMethodId = (Long)attributes.get("contactDataMethodId");

		if (contactDataMethodId != null) {
			setContactDataMethodId(contactDataMethodId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataId", long.class);

				method.invoke(_contactDataRemoteModel, contactDataId);
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

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contactDataRemoteModel, groupId);
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

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataType", int.class);

				method.invoke(_contactDataRemoteModel, contactDataType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReadOnly() {
		return _readOnly;
	}

	@Override
	public boolean isReadOnly() {
		return _readOnly;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		_readOnly = readOnly;

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setReadOnly", boolean.class);

				method.invoke(_contactDataRemoteModel, readOnly);
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

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contactDataRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contactDataRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contactDataRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactDataMethodId() {
		return _contactDataMethodId;
	}

	@Override
	public void setContactDataMethodId(long contactDataMethodId) {
		_contactDataMethodId = contactDataMethodId;

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDataMethodId",
						long.class);

				method.invoke(_contactDataRemoteModel, contactDataMethodId);
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

		if (_contactDataRemoteModel != null) {
			try {
				Class<?> clazz = _contactDataRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_contactDataRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactDataRemoteModel() {
		return _contactDataRemoteModel;
	}

	public void setContactDataRemoteModel(BaseModel<?> contactDataRemoteModel) {
		_contactDataRemoteModel = contactDataRemoteModel;
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

		Class<?> remoteModelClass = _contactDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactDataLocalServiceUtil.addContactData(this);
		}
		else {
			ContactDataLocalServiceUtil.updateContactData(this);
		}
	}

	@Override
	public ContactData toEscapedModel() {
		return (ContactData)ProxyUtil.newProxyInstance(ContactData.class.getClassLoader(),
			new Class[] { ContactData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactDataClp clone = new ContactDataClp();

		clone.setContactDataId(getContactDataId());
		clone.setGroupId(getGroupId());
		clone.setContactDataType(getContactDataType());
		clone.setReadOnly(getReadOnly());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setContactDataMethodId(getContactDataMethodId());
		clone.setContactId(getContactId());

		return clone;
	}

	@Override
	public int compareTo(ContactData contactData) {
		long primaryKey = contactData.getPrimaryKey();

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

		if (!(obj instanceof ContactDataClp)) {
			return false;
		}

		ContactDataClp contactData = (ContactDataClp)obj;

		long primaryKey = contactData.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{contactDataId=");
		sb.append(getContactDataId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", contactDataType=");
		sb.append(getContactDataType());
		sb.append(", readOnly=");
		sb.append(getReadOnly());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", contactDataMethodId=");
		sb.append(getContactDataMethodId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDataType</column-name><column-value><![CDATA[");
		sb.append(getContactDataType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readOnly</column-name><column-value><![CDATA[");
		sb.append(getReadOnly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDataMethodId</column-name><column-value><![CDATA[");
		sb.append(getContactDataMethodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactDataId;
	private long _groupId;
	private int _contactDataType;
	private boolean _readOnly;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _contactDataMethodId;
	private long _contactId;
	private BaseModel<?> _contactDataRemoteModel;
}