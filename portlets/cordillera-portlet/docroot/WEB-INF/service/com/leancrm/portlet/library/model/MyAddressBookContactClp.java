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
import com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK;

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
public class MyAddressBookContactClp extends BaseModelImpl<MyAddressBookContact>
	implements MyAddressBookContact {
	public MyAddressBookContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MyAddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return MyAddressBookContact.class.getName();
	}

	@Override
	public MyAddressBookContactPK getPrimaryKey() {
		return new MyAddressBookContactPK(_contactId, _methodId);
	}

	@Override
	public void setPrimaryKey(MyAddressBookContactPK primaryKey) {
		setContactId(primaryKey.contactId);
		setMethodId(primaryKey.methodId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new MyAddressBookContactPK(_contactId, _methodId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((MyAddressBookContactPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("methodId", getMethodId());
		attributes.put("contactName", getContactName());
		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("enterpriseName", getEnterpriseName());
		attributes.put("contractId", getContractId());
		attributes.put("reportId", getReportId());
		attributes.put("status", getStatus());
		attributes.put("progress", getProgress());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long methodId = (Long)attributes.get("methodId");

		if (methodId != null) {
			setMethodId(methodId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		String enterpriseName = (String)attributes.get("enterpriseName");

		if (enterpriseName != null) {
			setEnterpriseName(enterpriseName);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double progress = (Double)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_myAddressBookContactRemoteModel, contactId);
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

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMethodId", long.class);

				method.invoke(_myAddressBookContactRemoteModel, methodId);
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

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactName", String.class);

				method.invoke(_myAddressBookContactRemoteModel, contactName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEnterpriseId() {
		return _enterpriseId;
	}

	@Override
	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEnterpriseId", long.class);

				method.invoke(_myAddressBookContactRemoteModel, enterpriseId);
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

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEnterpriseName",
						String.class);

				method.invoke(_myAddressBookContactRemoteModel, enterpriseName);
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

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", long.class);

				method.invoke(_myAddressBookContactRemoteModel, contractId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_myAddressBookContactRemoteModel, reportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_myAddressBookContactRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(double progress) {
		_progress = progress;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setProgress", double.class);

				method.invoke(_myAddressBookContactRemoteModel, progress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_myAddressBookContactRemoteModel != null) {
			try {
				Class<?> clazz = _myAddressBookContactRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_myAddressBookContactRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMyAddressBookContactRemoteModel() {
		return _myAddressBookContactRemoteModel;
	}

	public void setMyAddressBookContactRemoteModel(
		BaseModel<?> myAddressBookContactRemoteModel) {
		_myAddressBookContactRemoteModel = myAddressBookContactRemoteModel;
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

		Class<?> remoteModelClass = _myAddressBookContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_myAddressBookContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MyAddressBookContactLocalServiceUtil.addMyAddressBookContact(this);
		}
		else {
			MyAddressBookContactLocalServiceUtil.updateMyAddressBookContact(this);
		}
	}

	@Override
	public MyAddressBookContact toEscapedModel() {
		return (MyAddressBookContact)ProxyUtil.newProxyInstance(MyAddressBookContact.class.getClassLoader(),
			new Class[] { MyAddressBookContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MyAddressBookContactClp clone = new MyAddressBookContactClp();

		clone.setContactId(getContactId());
		clone.setMethodId(getMethodId());
		clone.setContactName(getContactName());
		clone.setEnterpriseId(getEnterpriseId());
		clone.setEnterpriseName(getEnterpriseName());
		clone.setContractId(getContractId());
		clone.setReportId(getReportId());
		clone.setStatus(getStatus());
		clone.setProgress(getProgress());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(MyAddressBookContact myAddressBookContact) {
		MyAddressBookContactPK primaryKey = myAddressBookContact.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyAddressBookContactClp)) {
			return false;
		}

		MyAddressBookContactClp myAddressBookContact = (MyAddressBookContactClp)obj;

		MyAddressBookContactPK primaryKey = myAddressBookContact.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", methodId=");
		sb.append(getMethodId());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", enterpriseId=");
		sb.append(getEnterpriseId());
		sb.append(", enterpriseName=");
		sb.append(getEnterpriseName());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.MyAddressBookContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
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
			"<column><column-name>enterpriseId</column-name><column-value><![CDATA[");
		sb.append(getEnterpriseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enterpriseName</column-name><column-value><![CDATA[");
		sb.append(getEnterpriseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private long _methodId;
	private String _contactName;
	private long _enterpriseId;
	private String _enterpriseName;
	private long _contractId;
	private long _reportId;
	private int _status;
	private double _progress;
	private String _description;
	private BaseModel<?> _myAddressBookContactRemoteModel;
}