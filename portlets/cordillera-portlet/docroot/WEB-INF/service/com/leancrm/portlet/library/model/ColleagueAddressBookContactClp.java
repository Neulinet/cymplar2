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
import com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK;

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
public class ColleagueAddressBookContactClp extends BaseModelImpl<ColleagueAddressBookContact>
	implements ColleagueAddressBookContact {
	public ColleagueAddressBookContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ColleagueAddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return ColleagueAddressBookContact.class.getName();
	}

	@Override
	public ColleagueAddressBookContactPK getPrimaryKey() {
		return new ColleagueAddressBookContactPK(_contactid, _methodId);
	}

	@Override
	public void setPrimaryKey(ColleagueAddressBookContactPK primaryKey) {
		setContactid(primaryKey.contactid);
		setMethodId(primaryKey.methodId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ColleagueAddressBookContactPK(_contactid, _methodId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ColleagueAddressBookContactPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactid", getContactid());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("contactdataid", getContactdataid());
		attributes.put("methodId", getMethodId());
		attributes.put("contactName", getContactName());
		attributes.put("enterpriseName", getEnterpriseName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactid = (Long)attributes.get("contactid");

		if (contactid != null) {
			setContactid(contactid);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long contactdataid = (Long)attributes.get("contactdataid");

		if (contactdataid != null) {
			setContactdataid(contactdataid);
		}

		Long methodId = (Long)attributes.get("methodId");

		if (methodId != null) {
			setMethodId(methodId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String enterpriseName = (String)attributes.get("enterpriseName");

		if (enterpriseName != null) {
			setEnterpriseName(enterpriseName);
		}
	}

	@Override
	public long getContactid() {
		return _contactid;
	}

	@Override
	public void setContactid(long contactid) {
		_contactid = contactid;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactid", long.class);

				method.invoke(_colleagueAddressBookContactRemoteModel, contactid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_colleagueAddressBookContactRemoteModel,
					emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactdataid() {
		return _contactdataid;
	}

	@Override
	public void setContactdataid(long contactdataid) {
		_contactdataid = contactdataid;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactdataid", long.class);

				method.invoke(_colleagueAddressBookContactRemoteModel,
					contactdataid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMethodId() {
		return _methodId;
	}

	@Override
	public void setMethodId(long methodId) {
		_methodId = methodId;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMethodId", long.class);

				method.invoke(_colleagueAddressBookContactRemoteModel, methodId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactName() {
		return _contactName;
	}

	@Override
	public void setContactName(String contactName) {
		_contactName = contactName;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactName", String.class);

				method.invoke(_colleagueAddressBookContactRemoteModel,
					contactName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEnterpriseName() {
		return _enterpriseName;
	}

	@Override
	public void setEnterpriseName(String enterpriseName) {
		_enterpriseName = enterpriseName;

		if (_colleagueAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _colleagueAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEnterpriseName",
						String.class);

				method.invoke(_colleagueAddressBookContactRemoteModel,
					enterpriseName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getColleagueAddressBookContactRemoteModel() {
		return _colleagueAddressBookContactRemoteModel;
	}

	public void setColleagueAddressBookContactRemoteModel(
		BaseModel<?> colleagueAddressBookContactRemoteModel) {
		_colleagueAddressBookContactRemoteModel = colleagueAddressBookContactRemoteModel;
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

		Class<?> remoteModelClass = _colleagueAddressBookContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_colleagueAddressBookContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ColleagueAddressBookContactLocalServiceUtil.addColleagueAddressBookContact(this);
		}
		else {
			ColleagueAddressBookContactLocalServiceUtil.updateColleagueAddressBookContact(this);
		}
	}

	@Override
	public ColleagueAddressBookContact toEscapedModel() {
		return (ColleagueAddressBookContact)ProxyUtil.newProxyInstance(ColleagueAddressBookContact.class.getClassLoader(),
			new Class[] { ColleagueAddressBookContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ColleagueAddressBookContactClp clone = new ColleagueAddressBookContactClp();

		clone.setContactid(getContactid());
		clone.setEmailAddress(getEmailAddress());
		clone.setContactdataid(getContactdataid());
		clone.setMethodId(getMethodId());
		clone.setContactName(getContactName());
		clone.setEnterpriseName(getEnterpriseName());

		return clone;
	}

	@Override
	public int compareTo(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		ColleagueAddressBookContactPK primaryKey = colleagueAddressBookContact.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColleagueAddressBookContactClp)) {
			return false;
		}

		ColleagueAddressBookContactClp colleagueAddressBookContact = (ColleagueAddressBookContactClp)obj;

		ColleagueAddressBookContactPK primaryKey = colleagueAddressBookContact.getPrimaryKey();

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

		sb.append("{contactid=");
		sb.append(getContactid());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", contactdataid=");
		sb.append(getContactdataid());
		sb.append(", methodId=");
		sb.append(getMethodId());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", enterpriseName=");
		sb.append(getEnterpriseName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.leancrm.portlet.library.model.ColleagueAddressBookContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactid</column-name><column-value><![CDATA[");
		sb.append(getContactid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactdataid</column-name><column-value><![CDATA[");
		sb.append(getContactdataid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>methodId</column-name><column-value><![CDATA[");
		sb.append(getMethodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactName</column-name><column-value><![CDATA[");
		sb.append(getContactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enterpriseName</column-name><column-value><![CDATA[");
		sb.append(getEnterpriseName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactid;
	private String _emailAddress;
	private long _contactdataid;
	private long _methodId;
	private String _contactName;
	private String _enterpriseName;
	private BaseModel<?> _colleagueAddressBookContactRemoteModel;
}