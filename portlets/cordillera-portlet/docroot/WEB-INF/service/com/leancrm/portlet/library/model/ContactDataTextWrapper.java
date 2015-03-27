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
 * This class is a wrapper for {@link ContactDataText}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataText
 * @generated
 */
public class ContactDataTextWrapper implements ContactDataText,
	ModelWrapper<ContactDataText> {
	public ContactDataTextWrapper(ContactDataText contactDataText) {
		_contactDataText = contactDataText;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataText.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataText.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this contact data text.
	*
	* @return the primary key of this contact data text
	*/
	@Override
	public long getPrimaryKey() {
		return _contactDataText.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact data text.
	*
	* @param primaryKey the primary key of this contact data text
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactDataText.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact data ID of this contact data text.
	*
	* @return the contact data ID of this contact data text
	*/
	@Override
	public long getContactDataId() {
		return _contactDataText.getContactDataId();
	}

	/**
	* Sets the contact data ID of this contact data text.
	*
	* @param contactDataId the contact data ID of this contact data text
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataText.setContactDataId(contactDataId);
	}

	/**
	* Returns the value of this contact data text.
	*
	* @return the value of this contact data text
	*/
	@Override
	public java.lang.String getValue() {
		return _contactDataText.getValue();
	}

	/**
	* Sets the value of this contact data text.
	*
	* @param value the value of this contact data text
	*/
	@Override
	public void setValue(java.lang.String value) {
		_contactDataText.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _contactDataText.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactDataText.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactDataText.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactDataText.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactDataText.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactDataText.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactDataText.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactDataText.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactDataText.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactDataText.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactDataText.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDataTextWrapper((ContactDataText)_contactDataText.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactDataText contactDataText) {
		return _contactDataText.compareTo(contactDataText);
	}

	@Override
	public int hashCode() {
		return _contactDataText.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactDataText> toCacheModel() {
		return _contactDataText.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataText toEscapedModel() {
		return new ContactDataTextWrapper(_contactDataText.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataText toUnescapedModel() {
		return new ContactDataTextWrapper(_contactDataText.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactDataText.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactDataText.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactDataText.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataTextWrapper)) {
			return false;
		}

		ContactDataTextWrapper contactDataTextWrapper = (ContactDataTextWrapper)obj;

		if (Validator.equals(_contactDataText,
					contactDataTextWrapper._contactDataText)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactDataText getWrappedContactDataText() {
		return _contactDataText;
	}

	@Override
	public ContactDataText getWrappedModel() {
		return _contactDataText;
	}

	@Override
	public void resetOriginalValues() {
		_contactDataText.resetOriginalValues();
	}

	private ContactDataText _contactDataText;
}