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
 * This class is a wrapper for {@link ColleagueAddressBookContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColleagueAddressBookContact
 * @generated
 */
public class ColleagueAddressBookContactWrapper
	implements ColleagueAddressBookContact,
		ModelWrapper<ColleagueAddressBookContact> {
	public ColleagueAddressBookContactWrapper(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		_colleagueAddressBookContact = colleagueAddressBookContact;
	}

	@Override
	public Class<?> getModelClass() {
		return ColleagueAddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return ColleagueAddressBookContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactid", getContactid());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("contactdataid", getContactdataid());
		attributes.put("methodId", getMethodId());
		attributes.put("contactName", getContactName());
		attributes.put("enterpriseName", getEnterpriseName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactid = (Long)attributes.get("contactid");

		if (contactid != null) {
			setContactid(contactid);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long contactdataid = (Long)attributes.get("contactdataid");

		if (contactdataid != null) {
			setContactdataid(contactdataid);
		}

		Long methodId = (Long)attributes.get("methodId");

		if (methodId != null) {
			setMethodId(methodId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String enterpriseName = (String)attributes.get("enterpriseName");

		if (enterpriseName != null) {
			setEnterpriseName(enterpriseName);
		}
	}

	/**
	* Returns the primary key of this colleague address book contact.
	*
	* @return the primary key of this colleague address book contact
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK getPrimaryKey() {
		return _colleagueAddressBookContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this colleague address book contact.
	*
	* @param primaryKey the primary key of this colleague address book contact
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK primaryKey) {
		_colleagueAddressBookContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contactid of this colleague address book contact.
	*
	* @return the contactid of this colleague address book contact
	*/
	@Override
	public long getContactid() {
		return _colleagueAddressBookContact.getContactid();
	}

	/**
	* Sets the contactid of this colleague address book contact.
	*
	* @param contactid the contactid of this colleague address book contact
	*/
	@Override
	public void setContactid(long contactid) {
		_colleagueAddressBookContact.setContactid(contactid);
	}

	/**
	* Returns the email address of this colleague address book contact.
	*
	* @return the email address of this colleague address book contact
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _colleagueAddressBookContact.getEmailAddress();
	}

	/**
	* Sets the email address of this colleague address book contact.
	*
	* @param emailAddress the email address of this colleague address book contact
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_colleagueAddressBookContact.setEmailAddress(emailAddress);
	}

	/**
	* Returns the contactdataid of this colleague address book contact.
	*
	* @return the contactdataid of this colleague address book contact
	*/
	@Override
	public long getContactdataid() {
		return _colleagueAddressBookContact.getContactdataid();
	}

	/**
	* Sets the contactdataid of this colleague address book contact.
	*
	* @param contactdataid the contactdataid of this colleague address book contact
	*/
	@Override
	public void setContactdataid(long contactdataid) {
		_colleagueAddressBookContact.setContactdataid(contactdataid);
	}

	/**
	* Returns the method ID of this colleague address book contact.
	*
	* @return the method ID of this colleague address book contact
	*/
	@Override
	public long getMethodId() {
		return _colleagueAddressBookContact.getMethodId();
	}

	/**
	* Sets the method ID of this colleague address book contact.
	*
	* @param methodId the method ID of this colleague address book contact
	*/
	@Override
	public void setMethodId(long methodId) {
		_colleagueAddressBookContact.setMethodId(methodId);
	}

	/**
	* Returns the contact name of this colleague address book contact.
	*
	* @return the contact name of this colleague address book contact
	*/
	@Override
	public java.lang.String getContactName() {
		return _colleagueAddressBookContact.getContactName();
	}

	/**
	* Sets the contact name of this colleague address book contact.
	*
	* @param contactName the contact name of this colleague address book contact
	*/
	@Override
	public void setContactName(java.lang.String contactName) {
		_colleagueAddressBookContact.setContactName(contactName);
	}

	/**
	* Returns the enterprise name of this colleague address book contact.
	*
	* @return the enterprise name of this colleague address book contact
	*/
	@Override
	public java.lang.String getEnterpriseName() {
		return _colleagueAddressBookContact.getEnterpriseName();
	}

	/**
	* Sets the enterprise name of this colleague address book contact.
	*
	* @param enterpriseName the enterprise name of this colleague address book contact
	*/
	@Override
	public void setEnterpriseName(java.lang.String enterpriseName) {
		_colleagueAddressBookContact.setEnterpriseName(enterpriseName);
	}

	@Override
	public boolean isNew() {
		return _colleagueAddressBookContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_colleagueAddressBookContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _colleagueAddressBookContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_colleagueAddressBookContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _colleagueAddressBookContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _colleagueAddressBookContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_colleagueAddressBookContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _colleagueAddressBookContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_colleagueAddressBookContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_colleagueAddressBookContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_colleagueAddressBookContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ColleagueAddressBookContactWrapper((ColleagueAddressBookContact)_colleagueAddressBookContact.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact) {
		return _colleagueAddressBookContact.compareTo(colleagueAddressBookContact);
	}

	@Override
	public int hashCode() {
		return _colleagueAddressBookContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ColleagueAddressBookContact> toCacheModel() {
		return _colleagueAddressBookContact.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ColleagueAddressBookContact toEscapedModel() {
		return new ColleagueAddressBookContactWrapper(_colleagueAddressBookContact.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ColleagueAddressBookContact toUnescapedModel() {
		return new ColleagueAddressBookContactWrapper(_colleagueAddressBookContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _colleagueAddressBookContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _colleagueAddressBookContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_colleagueAddressBookContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColleagueAddressBookContactWrapper)) {
			return false;
		}

		ColleagueAddressBookContactWrapper colleagueAddressBookContactWrapper = (ColleagueAddressBookContactWrapper)obj;

		if (Validator.equals(_colleagueAddressBookContact,
					colleagueAddressBookContactWrapper._colleagueAddressBookContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ColleagueAddressBookContact getWrappedColleagueAddressBookContact() {
		return _colleagueAddressBookContact;
	}

	@Override
	public ColleagueAddressBookContact getWrappedModel() {
		return _colleagueAddressBookContact;
	}

	@Override
	public void resetOriginalValues() {
		_colleagueAddressBookContact.resetOriginalValues();
	}

	private ColleagueAddressBookContact _colleagueAddressBookContact;
}