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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactDataRef}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRef
 * @generated
 */
public class ContactDataRefWrapper implements ContactDataRef,
	ModelWrapper<ContactDataRef> {
	public ContactDataRefWrapper(ContactDataRef contactDataRef) {
		_contactDataRef = contactDataRef;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataRef.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataRef.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("refValue", getRefValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long refValue = (Long)attributes.get("refValue");

		if (refValue != null) {
			setRefValue(refValue);
		}
	}

	/**
	* Returns the primary key of this contact data ref.
	*
	* @return the primary key of this contact data ref
	*/
	@Override
	public long getPrimaryKey() {
		return _contactDataRef.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact data ref.
	*
	* @param primaryKey the primary key of this contact data ref
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactDataRef.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact data ID of this contact data ref.
	*
	* @return the contact data ID of this contact data ref
	*/
	@Override
	public long getContactDataId() {
		return _contactDataRef.getContactDataId();
	}

	/**
	* Sets the contact data ID of this contact data ref.
	*
	* @param contactDataId the contact data ID of this contact data ref
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataRef.setContactDataId(contactDataId);
	}

	/**
	* Returns the ref value of this contact data ref.
	*
	* @return the ref value of this contact data ref
	*/
	@Override
	public long getRefValue() {
		return _contactDataRef.getRefValue();
	}

	/**
	* Sets the ref value of this contact data ref.
	*
	* @param refValue the ref value of this contact data ref
	*/
	@Override
	public void setRefValue(long refValue) {
		_contactDataRef.setRefValue(refValue);
	}

	@Override
	public boolean isNew() {
		return _contactDataRef.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactDataRef.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactDataRef.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactDataRef.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactDataRef.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactDataRef.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactDataRef.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactDataRef.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactDataRef.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactDataRef.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactDataRef.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDataRefWrapper((ContactDataRef)_contactDataRef.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef) {
		return _contactDataRef.compareTo(contactDataRef);
	}

	@Override
	public int hashCode() {
		return _contactDataRef.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactDataRef> toCacheModel() {
		return _contactDataRef.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataRef toEscapedModel() {
		return new ContactDataRefWrapper(_contactDataRef.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataRef toUnescapedModel() {
		return new ContactDataRefWrapper(_contactDataRef.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactDataRef.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactDataRef.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactDataRef.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataRefWrapper)) {
			return false;
		}

		ContactDataRefWrapper contactDataRefWrapper = (ContactDataRefWrapper)obj;

		if (Validator.equals(_contactDataRef,
					contactDataRefWrapper._contactDataRef)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactDataRef getWrappedContactDataRef() {
		return _contactDataRef;
	}

	@Override
	public ContactDataRef getWrappedModel() {
		return _contactDataRef;
	}

	@Override
	public void resetOriginalValues() {
		_contactDataRef.resetOriginalValues();
	}

	private ContactDataRef _contactDataRef;
}