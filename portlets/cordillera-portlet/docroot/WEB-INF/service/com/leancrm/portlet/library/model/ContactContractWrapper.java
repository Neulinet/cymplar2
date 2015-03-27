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
 * This class is a wrapper for {@link ContactContract}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactContract
 * @generated
 */
public class ContactContractWrapper implements ContactContract,
	ModelWrapper<ContactContract> {
	public ContactContractWrapper(ContactContract contactContract) {
		_contactContract = contactContract;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactContract.class;
	}

	@Override
	public String getModelClassName() {
		return ContactContract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("contractId", getContractId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this contact contract.
	*
	* @return the primary key of this contact contract
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.ContactContractPK getPrimaryKey() {
		return _contactContract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact contract.
	*
	* @param primaryKey the primary key of this contact contract
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ContactContractPK primaryKey) {
		_contactContract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this contact contract.
	*
	* @return the contact ID of this contact contract
	*/
	@Override
	public long getContactId() {
		return _contactContract.getContactId();
	}

	/**
	* Sets the contact ID of this contact contract.
	*
	* @param contactId the contact ID of this contact contract
	*/
	@Override
	public void setContactId(long contactId) {
		_contactContract.setContactId(contactId);
	}

	/**
	* Returns the contract ID of this contact contract.
	*
	* @return the contract ID of this contact contract
	*/
	@Override
	public long getContractId() {
		return _contactContract.getContractId();
	}

	/**
	* Sets the contract ID of this contact contract.
	*
	* @param contractId the contract ID of this contact contract
	*/
	@Override
	public void setContractId(long contractId) {
		_contactContract.setContractId(contractId);
	}

	/**
	* Returns the active of this contact contract.
	*
	* @return the active of this contact contract
	*/
	@Override
	public boolean getActive() {
		return _contactContract.getActive();
	}

	/**
	* Returns <code>true</code> if this contact contract is active.
	*
	* @return <code>true</code> if this contact contract is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _contactContract.isActive();
	}

	/**
	* Sets whether this contact contract is active.
	*
	* @param active the active of this contact contract
	*/
	@Override
	public void setActive(boolean active) {
		_contactContract.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _contactContract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactContract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactContract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactContract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactContract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactContract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactContract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactContract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactContract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactContract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactContract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactContractWrapper((ContactContract)_contactContract.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactContract contactContract) {
		return _contactContract.compareTo(contactContract);
	}

	@Override
	public int hashCode() {
		return _contactContract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactContract> toCacheModel() {
		return _contactContract.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactContract toEscapedModel() {
		return new ContactContractWrapper(_contactContract.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactContract toUnescapedModel() {
		return new ContactContractWrapper(_contactContract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactContract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactContract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactContract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactContractWrapper)) {
			return false;
		}

		ContactContractWrapper contactContractWrapper = (ContactContractWrapper)obj;

		if (Validator.equals(_contactContract,
					contactContractWrapper._contactContract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactContract getWrappedContactContract() {
		return _contactContract;
	}

	@Override
	public ContactContract getWrappedModel() {
		return _contactContract;
	}

	@Override
	public void resetOriginalValues() {
		_contactContract.resetOriginalValues();
	}

	private ContactContract _contactContract;
}