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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NextFollowUpEventSoap implements Serializable {
	public static NextFollowUpEventSoap toSoapModel(NextFollowUpEvent model) {
		NextFollowUpEventSoap soapModel = new NextFollowUpEventSoap();

		soapModel.setEventId(model.getEventId());
		soapModel.setEventDate(model.getEventDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setContractId(model.getContractId());
		soapModel.setReportId(model.getReportId());

		return soapModel;
	}

	public static NextFollowUpEventSoap[] toSoapModels(
		NextFollowUpEvent[] models) {
		NextFollowUpEventSoap[] soapModels = new NextFollowUpEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NextFollowUpEventSoap[][] toSoapModels(
		NextFollowUpEvent[][] models) {
		NextFollowUpEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NextFollowUpEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NextFollowUpEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NextFollowUpEventSoap[] toSoapModels(
		List<NextFollowUpEvent> models) {
		List<NextFollowUpEventSoap> soapModels = new ArrayList<NextFollowUpEventSoap>(models.size());

		for (NextFollowUpEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NextFollowUpEventSoap[soapModels.size()]);
	}

	public NextFollowUpEventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Date getEventDate() {
		return _eventDate;
	}

	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
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
}