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
import com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil;

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
public class NextFollowUpEventClp extends BaseModelImpl<NextFollowUpEvent>
	implements NextFollowUpEvent {
	public NextFollowUpEventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NextFollowUpEvent.class;
	}

	@Override
	public String getModelClassName() {
		return NextFollowUpEvent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("eventDate", getEventDate());
		attributes.put("status", getStatus());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("ownerId", getOwnerId());
		attributes.put("contractId", getContractId());
		attributes.put("reportId", getReportId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_nextFollowUpEventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDate", Date.class);

				method.invoke(_nextFollowUpEventRemoteModel, eventDate);
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

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_nextFollowUpEventRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_nextFollowUpEventRemoteModel, title);
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

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_nextFollowUpEventRemoteModel, description);
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

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_nextFollowUpEventRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerId", long.class);

				method.invoke(_nextFollowUpEventRemoteModel, ownerId);
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

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", long.class);

				method.invoke(_nextFollowUpEventRemoteModel, contractId);
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

		if (_nextFollowUpEventRemoteModel != null) {
			try {
				Class<?> clazz = _nextFollowUpEventRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_nextFollowUpEventRemoteModel, reportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNextFollowUpEventRemoteModel() {
		return _nextFollowUpEventRemoteModel;
	}

	public void setNextFollowUpEventRemoteModel(
		BaseModel<?> nextFollowUpEventRemoteModel) {
		_nextFollowUpEventRemoteModel = nextFollowUpEventRemoteModel;
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

		Class<?> remoteModelClass = _nextFollowUpEventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_nextFollowUpEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NextFollowUpEventLocalServiceUtil.addNextFollowUpEvent(this);
		}
		else {
			NextFollowUpEventLocalServiceUtil.updateNextFollowUpEvent(this);
		}
	}

	@Override
	public NextFollowUpEvent toEscapedModel() {
		return (NextFollowUpEvent)ProxyUtil.newProxyInstance(NextFollowUpEvent.class.getClassLoader(),
			new Class[] { NextFollowUpEvent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NextFollowUpEventClp clone = new NextFollowUpEventClp();

		clone.setEventId(getEventId());
		clone.setEventDate(getEventDate());
		clone.setStatus(getStatus());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setCreateDate(getCreateDate());
		clone.setOwnerId(getOwnerId());
		clone.setContractId(getContractId());
		clone.setReportId(getReportId());

		return clone;
	}

	@Override
	public int compareTo(NextFollowUpEvent nextFollowUpEvent) {
		long primaryKey = nextFollowUpEvent.getPrimaryKey();

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

		if (!(obj instanceof NextFollowUpEventClp)) {
			return false;
		}

		NextFollowUpEventClp nextFollowUpEvent = (NextFollowUpEventClp)obj;

		long primaryKey = nextFollowUpEvent.getPrimaryKey();

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

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", eventDate=");
		sb.append(getEventDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.NextFollowUpEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDate</column-name><column-value><![CDATA[");
		sb.append(getEventDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventId;
	private Date _eventDate;
	private int _status;
	private String _title;
	private String _description;
	private Date _createDate;
	private long _ownerId;
	private long _contractId;
	private long _reportId;
	private BaseModel<?> _nextFollowUpEventRemoteModel;
}