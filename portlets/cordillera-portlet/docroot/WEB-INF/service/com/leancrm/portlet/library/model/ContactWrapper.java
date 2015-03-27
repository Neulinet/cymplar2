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
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
	public ContactWrapper(Contact contact) {
		_contact = contact;
	}

	@Override
	public Class<?> getModelClass() {
		return Contact.class;
	}

	@Override
	public String getModelClassName() {
		return Contact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this contact.
	*
	* @return the primary key of this contact
	*/
	@Override
	public long getPrimaryKey() {
		return _contact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact.
	*
	* @param primaryKey the primary key of this contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this contact.
	*
	* @return the contact ID of this contact
	*/
	@Override
	public long getContactId() {
		return _contact.getContactId();
	}

	/**
	* Sets the contact ID of this contact.
	*
	* @param contactId the contact ID of this contact
	*/
	@Override
	public void setContactId(long contactId) {
		_contact.setContactId(contactId);
	}

	/**
	* Returns the group ID of this contact.
	*
	* @return the group ID of this contact
	*/
	@Override
	public long getGroupId() {
		return _contact.getGroupId();
	}

	/**
	* Sets the group ID of this contact.
	*
	* @param groupId the group ID of this contact
	*/
	@Override
	public void setGroupId(long groupId) {
		_contact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contact.
	*
	* @return the company ID of this contact
	*/
	@Override
	public long getCompanyId() {
		return _contact.getCompanyId();
	}

	/**
	* Sets the company ID of this contact.
	*
	* @param companyId the company ID of this contact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contact.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this contact.
	*
	* @return the create date of this contact
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contact.getCreateDate();
	}

	/**
	* Sets the create date of this contact.
	*
	* @param createDate the create date of this contact
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contact.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contact.
	*
	* @return the modified date of this contact
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contact.getModifiedDate();
	}

	/**
	* Sets the modified date of this contact.
	*
	* @param modifiedDate the modified date of this contact
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contact.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _contact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactWrapper((Contact)_contact.clone());
	}

	@Override
	public int compareTo(com.leancrm.portlet.library.model.Contact contact) {
		return _contact.compareTo(contact);
	}

	@Override
	public int hashCode() {
		return _contact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.Contact> toCacheModel() {
		return _contact.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.Contact toEscapedModel() {
		return new ContactWrapper(_contact.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.Contact toUnescapedModel() {
		return new ContactWrapper(_contact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactWrapper)) {
			return false;
		}

		ContactWrapper contactWrapper = (ContactWrapper)obj;

		if (Validator.equals(_contact, contactWrapper._contact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contact getWrappedContact() {
		return _contact;
	}

	@Override
	public Contact getWrappedModel() {
		return _contact;
	}

	@Override
	public void resetOriginalValues() {
		_contact.resetOriginalValues();
	}

	private Contact _contact;
}