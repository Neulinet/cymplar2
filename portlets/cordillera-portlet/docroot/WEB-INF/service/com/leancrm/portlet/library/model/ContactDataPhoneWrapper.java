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
 * This class is a wrapper for {@link ContactDataPhone}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhone
 * @generated
 */
public class ContactDataPhoneWrapper implements ContactDataPhone,
	ModelWrapper<ContactDataPhone> {
	public ContactDataPhoneWrapper(ContactDataPhone contactDataPhone) {
		_contactDataPhone = contactDataPhone;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataPhone.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataPhone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("extension", getExtension());
		attributes.put("number", getNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		String extension = (String)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}
	}

	/**
	* Returns the primary key of this contact data phone.
	*
	* @return the primary key of this contact data phone
	*/
	@Override
	public long getPrimaryKey() {
		return _contactDataPhone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact data phone.
	*
	* @param primaryKey the primary key of this contact data phone
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactDataPhone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact data ID of this contact data phone.
	*
	* @return the contact data ID of this contact data phone
	*/
	@Override
	public long getContactDataId() {
		return _contactDataPhone.getContactDataId();
	}

	/**
	* Sets the contact data ID of this contact data phone.
	*
	* @param contactDataId the contact data ID of this contact data phone
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataPhone.setContactDataId(contactDataId);
	}

	/**
	* Returns the extension of this contact data phone.
	*
	* @return the extension of this contact data phone
	*/
	@Override
	public java.lang.String getExtension() {
		return _contactDataPhone.getExtension();
	}

	/**
	* Sets the extension of this contact data phone.
	*
	* @param extension the extension of this contact data phone
	*/
	@Override
	public void setExtension(java.lang.String extension) {
		_contactDataPhone.setExtension(extension);
	}

	/**
	* Returns the number of this contact data phone.
	*
	* @return the number of this contact data phone
	*/
	@Override
	public java.lang.String getNumber() {
		return _contactDataPhone.getNumber();
	}

	/**
	* Sets the number of this contact data phone.
	*
	* @param number the number of this contact data phone
	*/
	@Override
	public void setNumber(java.lang.String number) {
		_contactDataPhone.setNumber(number);
	}

	@Override
	public boolean isNew() {
		return _contactDataPhone.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactDataPhone.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactDataPhone.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactDataPhone.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactDataPhone.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactDataPhone.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactDataPhone.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactDataPhone.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactDataPhone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactDataPhone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactDataPhone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDataPhoneWrapper((ContactDataPhone)_contactDataPhone.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone) {
		return _contactDataPhone.compareTo(contactDataPhone);
	}

	@Override
	public int hashCode() {
		return _contactDataPhone.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactDataPhone> toCacheModel() {
		return _contactDataPhone.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone toEscapedModel() {
		return new ContactDataPhoneWrapper(_contactDataPhone.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone toUnescapedModel() {
		return new ContactDataPhoneWrapper(_contactDataPhone.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactDataPhone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactDataPhone.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactDataPhone.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataPhoneWrapper)) {
			return false;
		}

		ContactDataPhoneWrapper contactDataPhoneWrapper = (ContactDataPhoneWrapper)obj;

		if (Validator.equals(_contactDataPhone,
					contactDataPhoneWrapper._contactDataPhone)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactDataPhone getWrappedContactDataPhone() {
		return _contactDataPhone;
	}

	@Override
	public ContactDataPhone getWrappedModel() {
		return _contactDataPhone;
	}

	@Override
	public void resetOriginalValues() {
		_contactDataPhone.resetOriginalValues();
	}

	private ContactDataPhone _contactDataPhone;
}