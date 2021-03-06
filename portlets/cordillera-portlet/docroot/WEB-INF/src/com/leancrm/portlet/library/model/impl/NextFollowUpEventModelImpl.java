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

package com.leancrm.portlet.library.model.impl;

import com.leancrm.portlet.library.model.NextFollowUpEvent;
import com.leancrm.portlet.library.model.NextFollowUpEventModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NextFollowUpEvent service. Represents a row in the &quot;crm_NextFollowUpEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.leancrm.portlet.library.model.NextFollowUpEventModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NextFollowUpEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEventImpl
 * @see com.leancrm.portlet.library.model.NextFollowUpEvent
 * @see com.leancrm.portlet.library.model.NextFollowUpEventModel
 * @generated
 */
public class NextFollowUpEventModelImpl extends BaseModelImpl<NextFollowUpEvent>
	implements NextFollowUpEventModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a next follow up event model instance should use the {@link com.leancrm.portlet.library.model.NextFollowUpEvent} interface instead.
	 */
	public static final String TABLE_NAME = "crm_NextFollowUpEvent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventId", Types.BIGINT },
			{ "eventDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "ownerId", Types.BIGINT },
			{ "contractId", Types.BIGINT },
			{ "reportId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table crm_NextFollowUpEvent (eventId LONG not null primary key,eventDate DATE null,status INTEGER,title VARCHAR(75) null,description VARCHAR(75) null,createDate DATE null,ownerId LONG,contractId LONG,reportId LONG)";
	public static final String TABLE_SQL_DROP = "drop table crm_NextFollowUpEvent";
	public static final String ORDER_BY_JPQL = " ORDER BY nextFollowUpEvent.eventId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY crm_NextFollowUpEvent.eventId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.leancrm.portlet.library.model.NextFollowUpEvent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.leancrm.portlet.library.model.NextFollowUpEvent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.leancrm.portlet.library.model.NextFollowUpEvent"),
			true);
	public static long CONTRACTID_COLUMN_BITMASK = 1L;
	public static long REPORTID_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long EVENTID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.leancrm.portlet.library.model.NextFollowUpEvent"));

	public NextFollowUpEventModelImpl() {
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
	public Class<?> getModelClass() {
		return NextFollowUpEvent.class;
	}

	@Override
	public String getModelClassName() {
		return NextFollowUpEvent.class.getName();
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
	}

	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	@Override
	public long getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(long contractId) {
		_columnBitmask |= CONTRACTID_COLUMN_BITMASK;

		if (!_setOriginalContractId) {
			_setOriginalContractId = true;

			_originalContractId = _contractId;
		}

		_contractId = contractId;
	}

	public long getOriginalContractId() {
		return _originalContractId;
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_columnBitmask |= REPORTID_COLUMN_BITMASK;

		if (!_setOriginalReportId) {
			_setOriginalReportId = true;

			_originalReportId = _reportId;
		}

		_reportId = reportId;
	}

	public long getOriginalReportId() {
		return _originalReportId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NextFollowUpEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NextFollowUpEvent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NextFollowUpEvent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NextFollowUpEventImpl nextFollowUpEventImpl = new NextFollowUpEventImpl();

		nextFollowUpEventImpl.setEventId(getEventId());
		nextFollowUpEventImpl.setEventDate(getEventDate());
		nextFollowUpEventImpl.setStatus(getStatus());
		nextFollowUpEventImpl.setTitle(getTitle());
		nextFollowUpEventImpl.setDescription(getDescription());
		nextFollowUpEventImpl.setCreateDate(getCreateDate());
		nextFollowUpEventImpl.setOwnerId(getOwnerId());
		nextFollowUpEventImpl.setContractId(getContractId());
		nextFollowUpEventImpl.setReportId(getReportId());

		nextFollowUpEventImpl.resetOriginalValues();

		return nextFollowUpEventImpl;
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

		if (!(obj instanceof NextFollowUpEvent)) {
			return false;
		}

		NextFollowUpEvent nextFollowUpEvent = (NextFollowUpEvent)obj;

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
	public void resetOriginalValues() {
		NextFollowUpEventModelImpl nextFollowUpEventModelImpl = this;

		nextFollowUpEventModelImpl._originalStatus = nextFollowUpEventModelImpl._status;

		nextFollowUpEventModelImpl._setOriginalStatus = false;

		nextFollowUpEventModelImpl._originalContractId = nextFollowUpEventModelImpl._contractId;

		nextFollowUpEventModelImpl._setOriginalContractId = false;

		nextFollowUpEventModelImpl._originalReportId = nextFollowUpEventModelImpl._reportId;

		nextFollowUpEventModelImpl._setOriginalReportId = false;

		nextFollowUpEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<NextFollowUpEvent> toCacheModel() {
		NextFollowUpEventCacheModel nextFollowUpEventCacheModel = new NextFollowUpEventCacheModel();

		nextFollowUpEventCacheModel.eventId = getEventId();

		Date eventDate = getEventDate();

		if (eventDate != null) {
			nextFollowUpEventCacheModel.eventDate = eventDate.getTime();
		}
		else {
			nextFollowUpEventCacheModel.eventDate = Long.MIN_VALUE;
		}

		nextFollowUpEventCacheModel.status = getStatus();

		nextFollowUpEventCacheModel.title = getTitle();

		String title = nextFollowUpEventCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			nextFollowUpEventCacheModel.title = null;
		}

		nextFollowUpEventCacheModel.description = getDescription();

		String description = nextFollowUpEventCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			nextFollowUpEventCacheModel.description = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			nextFollowUpEventCacheModel.createDate = createDate.getTime();
		}
		else {
			nextFollowUpEventCacheModel.createDate = Long.MIN_VALUE;
		}

		nextFollowUpEventCacheModel.ownerId = getOwnerId();

		nextFollowUpEventCacheModel.contractId = getContractId();

		nextFollowUpEventCacheModel.reportId = getReportId();

		return nextFollowUpEventCacheModel;
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

	private static ClassLoader _classLoader = NextFollowUpEvent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			NextFollowUpEvent.class
		};
	private long _eventId;
	private Date _eventDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private String _title;
	private String _description;
	private Date _createDate;
	private long _ownerId;
	private long _contractId;
	private long _originalContractId;
	private boolean _setOriginalContractId;
	private long _reportId;
	private long _originalReportId;
	private boolean _setOriginalReportId;
	private long _columnBitmask;
	private NextFollowUpEvent _escapedModel;
}