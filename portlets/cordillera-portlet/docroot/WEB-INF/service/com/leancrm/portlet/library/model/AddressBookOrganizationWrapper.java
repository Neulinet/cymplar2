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
 * This class is a wrapper for {@link AddressBookOrganization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganization
 * @generated
 */
public class AddressBookOrganizationWrapper implements AddressBookOrganization,
	ModelWrapper<AddressBookOrganization> {
	public AddressBookOrganizationWrapper(
		AddressBookOrganization addressBookOrganization) {
		_addressBookOrganization = addressBookOrganization;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressBookOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return AddressBookOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressBookId", getAddressBookId());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressBookId = (Long)attributes.get("addressBookId");

		if (addressBookId != null) {
			setAddressBookId(addressBookId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	/**
	* Returns the primary key of this address book organization.
	*
	* @return the primary key of this address book organization
	*/
	@Override
	public long getPrimaryKey() {
		return _addressBookOrganization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address book organization.
	*
	* @param primaryKey the primary key of this address book organization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_addressBookOrganization.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address book ID of this address book organization.
	*
	* @return the address book ID of this address book organization
	*/
	@Override
	public long getAddressBookId() {
		return _addressBookOrganization.getAddressBookId();
	}

	/**
	* Sets the address book ID of this address book organization.
	*
	* @param addressBookId the address book ID of this address book organization
	*/
	@Override
	public void setAddressBookId(long addressBookId) {
		_addressBookOrganization.setAddressBookId(addressBookId);
	}

	/**
	* Returns the organization ID of this address book organization.
	*
	* @return the organization ID of this address book organization
	*/
	@Override
	public long getOrganizationId() {
		return _addressBookOrganization.getOrganizationId();
	}

	/**
	* Sets the organization ID of this address book organization.
	*
	* @param organizationId the organization ID of this address book organization
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_addressBookOrganization.setOrganizationId(organizationId);
	}

	@Override
	public boolean isNew() {
		return _addressBookOrganization.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressBookOrganization.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressBookOrganization.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressBookOrganization.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressBookOrganization.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressBookOrganization.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressBookOrganization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressBookOrganization.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressBookOrganization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressBookOrganization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressBookOrganization.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressBookOrganizationWrapper((AddressBookOrganization)_addressBookOrganization.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization) {
		return _addressBookOrganization.compareTo(addressBookOrganization);
	}

	@Override
	public int hashCode() {
		return _addressBookOrganization.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.AddressBookOrganization> toCacheModel() {
		return _addressBookOrganization.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookOrganization toEscapedModel() {
		return new AddressBookOrganizationWrapper(_addressBookOrganization.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookOrganization toUnescapedModel() {
		return new AddressBookOrganizationWrapper(_addressBookOrganization.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressBookOrganization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressBookOrganization.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookOrganization.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressBookOrganizationWrapper)) {
			return false;
		}

		AddressBookOrganizationWrapper addressBookOrganizationWrapper = (AddressBookOrganizationWrapper)obj;

		if (Validator.equals(_addressBookOrganization,
					addressBookOrganizationWrapper._addressBookOrganization)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressBookOrganization getWrappedAddressBookOrganization() {
		return _addressBookOrganization;
	}

	@Override
	public AddressBookOrganization getWrappedModel() {
		return _addressBookOrganization;
	}

	@Override
	public void resetOriginalValues() {
		_addressBookOrganization.resetOriginalValues();
	}

	private AddressBookOrganization _addressBookOrganization;
}