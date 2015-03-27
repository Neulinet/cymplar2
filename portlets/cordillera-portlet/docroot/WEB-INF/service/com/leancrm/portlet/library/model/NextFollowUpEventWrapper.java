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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NextFollowUpEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEvent
 * @generated
 */
public class NextFollowUpEventWrapper implements NextFollowUpEvent,
	ModelWrapper<NextFollowUpEvent> {
	public NextFollowUpEventWrapper(NextFollowUpEvent nextFollowUpEvent) {
		_nextFollowUpEvent = nextFollowUpEvent;
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

	/**
	* Returns the primary key of this next follow up event.
	*
	* @return the primary key of this next follow up event
	*/
	@Override
	public long getPrimaryKey() {
		return _nextFollowUpEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this next follow up event.
	*
	* @param primaryKey the primary key of this next follow up event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nextFollowUpEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event ID of this next follow up event.
	*
	* @return the event ID of this next follow up event
	*/
	@Override
	public long getEventId() {
		return _nextFollowUpEvent.getEventId();
	}

	/**
	* Sets the event ID of this next follow up event.
	*
	* @param eventId the event ID of this next follow up event
	*/
	@Override
	public void setEventId(long eventId) {
		_nextFollowUpEvent.setEventId(eventId);
	}

	/**
	* Returns the event date of this next follow up event.
	*
	* @return the event date of this next follow up event
	*/
	@Override
	public java.util.Date getEventDate() {
		return _nextFollowUpEvent.getEventDate();
	}

	/**
	* Sets the event date of this next follow up event.
	*
	* @param eventDate the event date of this next follow up event
	*/
	@Override
	public void setEventDate(java.util.Date eventDate) {
		_nextFollowUpEvent.setEventDate(eventDate);
	}

	/**
	* Returns the status of this next follow up event.
	*
	* @return the status of this next follow up event
	*/
	@Override
	public int getStatus() {
		return _nextFollowUpEvent.getStatus();
	}

	/**
	* Sets the status of this next follow up event.
	*
	* @param status the status of this next follow up event
	*/
	@Override
	public void setStatus(int status) {
		_nextFollowUpEvent.setStatus(status);
	}

	/**
	* Returns the title of this next follow up event.
	*
	* @return the title of this next follow up event
	*/
	@Override
	public java.lang.String getTitle() {
		return _nextFollowUpEvent.getTitle();
	}

	/**
	* Sets the title of this next follow up event.
	*
	* @param title the title of this next follow up event
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_nextFollowUpEvent.setTitle(title);
	}

	/**
	* Returns the description of this next follow up event.
	*
	* @return the description of this next follow up event
	*/
	@Override
	public java.lang.String getDescription() {
		return _nextFollowUpEvent.getDescription();
	}

	/**
	* Sets the description of this next follow up event.
	*
	* @param description the description of this next follow up event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_nextFollowUpEvent.setDescription(description);
	}

	/**
	* Returns the create date of this next follow up event.
	*
	* @return the create date of this next follow up event
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _nextFollowUpEvent.getCreateDate();
	}

	/**
	* Sets the create date of this next follow up event.
	*
	* @param createDate the create date of this next follow up event
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_nextFollowUpEvent.setCreateDate(createDate);
	}

	/**
	* Returns the owner ID of this next follow up event.
	*
	* @return the owner ID of this next follow up event
	*/
	@Override
	public long getOwnerId() {
		return _nextFollowUpEvent.getOwnerId();
	}

	/**
	* Sets the owner ID of this next follow up event.
	*
	* @param ownerId the owner ID of this next follow up event
	*/
	@Override
	public void setOwnerId(long ownerId) {
		_nextFollowUpEvent.setOwnerId(ownerId);
	}

	/**
	* Returns the contract ID of this next follow up event.
	*
	* @return the contract ID of this next follow up event
	*/
	@Override
	public long getContractId() {
		return _nextFollowUpEvent.getContractId();
	}

	/**
	* Sets the contract ID of this next follow up event.
	*
	* @param contractId the contract ID of this next follow up event
	*/
	@Override
	public void setContractId(long contractId) {
		_nextFollowUpEvent.setContractId(contractId);
	}

	/**
	* Returns the report ID of this next follow up event.
	*
	* @return the report ID of this next follow up event
	*/
	@Override
	public long getReportId() {
		return _nextFollowUpEvent.getReportId();
	}

	/**
	* Sets the report ID of this next follow up event.
	*
	* @param reportId the report ID of this next follow up event
	*/
	@Override
	public void setReportId(long reportId) {
		_nextFollowUpEvent.setReportId(reportId);
	}

	@Override
	public boolean isNew() {
		return _nextFollowUpEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nextFollowUpEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nextFollowUpEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nextFollowUpEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nextFollowUpEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nextFollowUpEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nextFollowUpEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nextFollowUpEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nextFollowUpEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nextFollowUpEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nextFollowUpEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NextFollowUpEventWrapper((NextFollowUpEvent)_nextFollowUpEvent.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent) {
		return _nextFollowUpEvent.compareTo(nextFollowUpEvent);
	}

	@Override
	public int hashCode() {
		return _nextFollowUpEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.NextFollowUpEvent> toCacheModel() {
		return _nextFollowUpEvent.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent toEscapedModel() {
		return new NextFollowUpEventWrapper(_nextFollowUpEvent.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent toUnescapedModel() {
		return new NextFollowUpEventWrapper(_nextFollowUpEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nextFollowUpEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nextFollowUpEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nextFollowUpEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NextFollowUpEventWrapper)) {
			return false;
		}

		NextFollowUpEventWrapper nextFollowUpEventWrapper = (NextFollowUpEventWrapper)obj;

		if (Validator.equals(_nextFollowUpEvent,
					nextFollowUpEventWrapper._nextFollowUpEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NextFollowUpEvent getWrappedNextFollowUpEvent() {
		return _nextFollowUpEvent;
	}

	@Override
	public NextFollowUpEvent getWrappedModel() {
		return _nextFollowUpEvent;
	}

	@Override
	public void resetOriginalValues() {
		_nextFollowUpEvent.resetOriginalValues();
	}

	private NextFollowUpEvent _nextFollowUpEvent;
}