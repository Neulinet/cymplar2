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
 * This class is a wrapper for {@link AddressBookUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookUser
 * @generated
 */
public class AddressBookUserWrapper implements AddressBookUser,
	ModelWrapper<AddressBookUser> {
	public AddressBookUserWrapper(AddressBookUser addressBookUser) {
		_addressBookUser = addressBookUser;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookUser.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this address book user.
	*
	* @return the primary key of this address book user
	*/
	@Override
	public long getPrimaryKey() {
		return _addressBookUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address book user.
	*
	* @param primaryKey the primary key of this address book user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_addressBookUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address book ID of this address book user.
	*
	* @return the address book ID of this address book user
	*/
	@Override
	public long getAddressBookId() {
		return _addressBookUser.getAddressBookId();
	}

	/**
	* Sets the address book ID of this address book user.
	*
	* @param addressBookId the address book ID of this address book user
	*/
	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookUser.setAddressBookId(addressBookId);
	}

	/**
	* Returns the user ID of this address book user.
	*
	* @return the user ID of this address book user
	*/
	@Override
	public long getUserId() {
		return _addressBookUser.getUserId();
	}

	/**
	* Sets the user ID of this address book user.
	*
	* @param userId the user ID of this address book user
	*/
	@Override
	public void setUserId(long userId) {
		_addressBookUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this address book user.
	*
	* @return the user uuid of this address book user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this address book user.
	*
	* @param userUuid the user uuid of this address book user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_addressBookUser.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _addressBookUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressBookUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressBookUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressBookUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressBookUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressBookUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressBookUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressBookUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressBookUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressBookUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressBookUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressBookUserWrapper((AddressBookUser)_addressBookUser.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser) {
		return _addressBookUser.compareTo(addressBookUser);
	}

	@Override
	public int hashCode() {
		return _addressBookUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.AddressBookUser> toCacheModel() {
		return _addressBookUser.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookUser toEscapedModel() {
		return new AddressBookUserWrapper(_addressBookUser.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookUser toUnescapedModel() {
		return new AddressBookUserWrapper(_addressBookUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressBookUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressBookUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookUserWrapper)) {
			return false;
		}

		AddressBookUserWrapper addressBookUserWrapper = (AddressBookUserWrapper)obj;

		if (Validator.equals(_addressBookUser,
					addressBookUserWrapper._addressBookUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressBookUser getWrappedAddressBookUser() {
		return _addressBookUser;
	}

	@Override
	public AddressBookUser getWrappedModel() {
		return _addressBookUser;
	}

	@Override
	public void resetOriginalValues() {
		_addressBookUser.resetOriginalValues();
	}

	private AddressBookUser _addressBookUser;
}