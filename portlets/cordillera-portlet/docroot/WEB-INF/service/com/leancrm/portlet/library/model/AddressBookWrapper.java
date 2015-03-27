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
 * This class is a wrapper for {@link AddressBook}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBook
 * @generated
 */
public class AddressBookWrapper implements AddressBook,
	ModelWrapper<AddressBook> {
	public AddressBookWrapper(AddressBook addressBook) {
		_addressBook = addressBook;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBook.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBook.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("addressBookType", getAddressBookType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long addressBookType = (Long)attributes.get("addressBookType");

		if (addressBookType != null) {
			setAddressBookType(addressBookType);
		}
	}

	/**
	* Returns the primary key of this address book.
	*
	* @return the primary key of this address book
	*/
	@Override
	public long getPrimaryKey() {
		return _addressBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address book.
	*
	* @param primaryKey the primary key of this address book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_addressBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address book ID of this address book.
	*
	* @return the address book ID of this address book
	*/
	@Override
	public long getAddressBookId() {
		return _addressBook.getAddressBookId();
	}

	/**
	* Sets the address book ID of this address book.
	*
	* @param addressBookId the address book ID of this address book
	*/
	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBook.setAddressBookId(addressBookId);
	}

	/**
	* Returns the group ID of this address book.
	*
	* @return the group ID of this address book
	*/
	@Override
	public long getGroupId() {
		return _addressBook.getGroupId();
	}

	/**
	* Sets the group ID of this address book.
	*
	* @param groupId the group ID of this address book
	*/
	@Override
	public void setGroupId(long groupId) {
		_addressBook.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this address book.
	*
	* @return the company ID of this address book
	*/
	@Override
	public long getCompanyId() {
		return _addressBook.getCompanyId();
	}

	/**
	* Sets the company ID of this address book.
	*
	* @param companyId the company ID of this address book
	*/
	@Override
	public void setCompanyId(long companyId) {
		_addressBook.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this address book.
	*
	* @return the create date of this address book
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _addressBook.getCreateDate();
	}

	/**
	* Sets the create date of this address book.
	*
	* @param createDate the create date of this address book
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_addressBook.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this address book.
	*
	* @return the modified date of this address book
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _addressBook.getModifiedDate();
	}

	/**
	* Sets the modified date of this address book.
	*
	* @param modifiedDate the modified date of this address book
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_addressBook.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the address book type of this address book.
	*
	* @return the address book type of this address book
	*/
	@Override
	public long getAddressBookType() {
		return _addressBook.getAddressBookType();
	}

	/**
	* Sets the address book type of this address book.
	*
	* @param addressBookType the address book type of this address book
	*/
	@Override
	public void setAddressBookType(long addressBookType) {
		_addressBook.setAddressBookType(addressBookType);
	}

	@Override
	public boolean isNew() {
		return _addressBook.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressBook.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressBook.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressBook.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressBook.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressBook.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressBook.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressBook.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressBook.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressBook.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressBookWrapper((AddressBook)_addressBook.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.AddressBook addressBook) {
		return _addressBook.compareTo(addressBook);
	}

	@Override
	public int hashCode() {
		return _addressBook.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.AddressBook> toCacheModel() {
		return _addressBook.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBook toEscapedModel() {
		return new AddressBookWrapper(_addressBook.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBook toUnescapedModel() {
		return new AddressBookWrapper(_addressBook.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressBook.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressBook.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBook.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookWrapper)) {
			return false;
		}

		AddressBookWrapper addressBookWrapper = (AddressBookWrapper)obj;

		if (Validator.equals(_addressBook, addressBookWrapper._addressBook)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressBook getWrappedAddressBook() {
		return _addressBook;
	}

	@Override
	public AddressBook getWrappedModel() {
		return _addressBook;
	}

	@Override
	public void resetOriginalValues() {
		_addressBook.resetOriginalValues();
	}

	private AddressBook _addressBook;
}