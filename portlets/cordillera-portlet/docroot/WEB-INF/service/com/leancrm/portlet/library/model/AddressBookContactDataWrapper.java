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
 * This class is a wrapper for {@link AddressBookContactData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactData
 * @generated
 */
public class AddressBookContactDataWrapper implements AddressBookContactData,
	ModelWrapper<AddressBookContactData> {
	public AddressBookContactDataWrapper(
		AddressBookContactData addressBookContactData) {
		_addressBookContactData = addressBookContactData;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookContactData.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookContactData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("contactDataId", getContactDataId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this address book contact data.
	*
	* @return the primary key of this address book contact data
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK getPrimaryKey() {
		return _addressBookContactData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address book contact data.
	*
	* @param primaryKey the primary key of this address book contact data
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK primaryKey) {
		_addressBookContactData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address book ID of this address book contact data.
	*
	* @return the address book ID of this address book contact data
	*/
	@Override
	public long getAddressBookId() {
		return _addressBookContactData.getAddressBookId();
	}

	/**
	* Sets the address book ID of this address book contact data.
	*
	* @param addressBookId the address book ID of this address book contact data
	*/
	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookContactData.setAddressBookId(addressBookId);
	}

	/**
	* Returns the contact data ID of this address book contact data.
	*
	* @return the contact data ID of this address book contact data
	*/
	@Override
	public long getContactDataId() {
		return _addressBookContactData.getContactDataId();
	}

	/**
	* Sets the contact data ID of this address book contact data.
	*
	* @param contactDataId the contact data ID of this address book contact data
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_addressBookContactData.setContactDataId(contactDataId);
	}

	/**
	* Returns the active of this address book contact data.
	*
	* @return the active of this address book contact data
	*/
	@Override
	public boolean getActive() {
		return _addressBookContactData.getActive();
	}

	/**
	* Returns <code>true</code> if this address book contact data is active.
	*
	* @return <code>true</code> if this address book contact data is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _addressBookContactData.isActive();
	}

	/**
	* Sets whether this address book contact data is active.
	*
	* @param active the active of this address book contact data
	*/
	@Override
	public void setActive(boolean active) {
		_addressBookContactData.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _addressBookContactData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressBookContactData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressBookContactData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressBookContactData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressBookContactData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressBookContactData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressBookContactData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressBookContactData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressBookContactData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressBookContactData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressBookContactData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressBookContactDataWrapper((AddressBookContactData)_addressBookContactData.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData) {
		return _addressBookContactData.compareTo(addressBookContactData);
	}

	@Override
	public int hashCode() {
		return _addressBookContactData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.AddressBookContactData> toCacheModel() {
		return _addressBookContactData.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData toEscapedModel() {
		return new AddressBookContactDataWrapper(_addressBookContactData.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData toUnescapedModel() {
		return new AddressBookContactDataWrapper(_addressBookContactData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressBookContactData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressBookContactData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookContactDataWrapper)) {
			return false;
		}

		AddressBookContactDataWrapper addressBookContactDataWrapper = (AddressBookContactDataWrapper)obj;

		if (Validator.equals(_addressBookContactData,
					addressBookContactDataWrapper._addressBookContactData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressBookContactData getWrappedAddressBookContactData() {
		return _addressBookContactData;
	}

	@Override
	public AddressBookContactData getWrappedModel() {
		return _addressBookContactData;
	}

	@Override
	public void resetOriginalValues() {
		_addressBookContactData.resetOriginalValues();
	}

	private AddressBookContactData _addressBookContactData;
}