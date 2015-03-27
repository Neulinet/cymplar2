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
 * This class is a wrapper for {@link AddressBookContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContact
 * @generated
 */
public class AddressBookContactWrapper implements AddressBookContact,
	ModelWrapper<AddressBookContact> {
	public AddressBookContactWrapper(AddressBookContact addressBookContact) {
		_addressBookContact = addressBookContact;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("assignedTo", getAssignedTo());
		attributes.put("currentProgress", getCurrentProgress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long assignedTo = (Long)attributes.get("assignedTo");

		if (assignedTo != null) {
			setAssignedTo(assignedTo);
		}

		Double currentProgress = (Double)attributes.get("currentProgress");

		if (currentProgress != null) {
			setCurrentProgress(currentProgress);
		}
	}

	/**
	* Returns the primary key of this address book contact.
	*
	* @return the primary key of this address book contact
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.AddressBookContactPK getPrimaryKey() {
		return _addressBookContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address book contact.
	*
	* @param primaryKey the primary key of this address book contact
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK primaryKey) {
		_addressBookContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address book ID of this address book contact.
	*
	* @return the address book ID of this address book contact
	*/
	@Override
	public long getAddressBookId() {
		return _addressBookContact.getAddressBookId();
	}

	/**
	* Sets the address book ID of this address book contact.
	*
	* @param addressBookId the address book ID of this address book contact
	*/
	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookContact.setAddressBookId(addressBookId);
	}

	/**
	* Returns the contact ID of this address book contact.
	*
	* @return the contact ID of this address book contact
	*/
	@Override
	public long getContactId() {
		return _addressBookContact.getContactId();
	}

	/**
	* Sets the contact ID of this address book contact.
	*
	* @param contactId the contact ID of this address book contact
	*/
	@Override
	public void setContactId(long contactId) {
		_addressBookContact.setContactId(contactId);
	}

	/**
	* Returns the group ID of this address book contact.
	*
	* @return the group ID of this address book contact
	*/
	@Override
	public long getGroupId() {
		return _addressBookContact.getGroupId();
	}

	/**
	* Sets the group ID of this address book contact.
	*
	* @param groupId the group ID of this address book contact
	*/
	@Override
	public void setGroupId(long groupId) {
		_addressBookContact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this address book contact.
	*
	* @return the company ID of this address book contact
	*/
	@Override
	public long getCompanyId() {
		return _addressBookContact.getCompanyId();
	}

	/**
	* Sets the company ID of this address book contact.
	*
	* @param companyId the company ID of this address book contact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_addressBookContact.setCompanyId(companyId);
	}

	/**
	* Returns the assigned to of this address book contact.
	*
	* @return the assigned to of this address book contact
	*/
	@Override
	public long getAssignedTo() {
		return _addressBookContact.getAssignedTo();
	}

	/**
	* Sets the assigned to of this address book contact.
	*
	* @param assignedTo the assigned to of this address book contact
	*/
	@Override
	public void setAssignedTo(long assignedTo) {
		_addressBookContact.setAssignedTo(assignedTo);
	}

	/**
	* Returns the current progress of this address book contact.
	*
	* @return the current progress of this address book contact
	*/
	@Override
	public double getCurrentProgress() {
		return _addressBookContact.getCurrentProgress();
	}

	/**
	* Sets the current progress of this address book contact.
	*
	* @param currentProgress the current progress of this address book contact
	*/
	@Override
	public void setCurrentProgress(double currentProgress) {
		_addressBookContact.setCurrentProgress(currentProgress);
	}

	@Override
	public boolean isNew() {
		return _addressBookContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressBookContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressBookContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressBookContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressBookContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressBookContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressBookContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressBookContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressBookContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressBookContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressBookContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressBookContactWrapper((AddressBookContact)_addressBookContact.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact) {
		return _addressBookContact.compareTo(addressBookContact);
	}

	@Override
	public int hashCode() {
		return _addressBookContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.AddressBookContact> toCacheModel() {
		return _addressBookContact.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContact toEscapedModel() {
		return new AddressBookContactWrapper(_addressBookContact.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContact toUnescapedModel() {
		return new AddressBookContactWrapper(_addressBookContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressBookContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressBookContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookContactWrapper)) {
			return false;
		}

		AddressBookContactWrapper addressBookContactWrapper = (AddressBookContactWrapper)obj;

		if (Validator.equals(_addressBookContact,
					addressBookContactWrapper._addressBookContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressBookContact getWrappedAddressBookContact() {
		return _addressBookContact;
	}

	@Override
	public AddressBookContact getWrappedModel() {
		return _addressBookContact;
	}

	@Override
	public void resetOriginalValues() {
		_addressBookContact.resetOriginalValues();
	}

	private AddressBookContact _addressBookContact;
}