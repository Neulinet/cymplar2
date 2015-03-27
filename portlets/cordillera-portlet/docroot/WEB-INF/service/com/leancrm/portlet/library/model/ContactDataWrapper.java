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
 * This class is a wrapper for {@link ContactData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactData
 * @generated
 */
public class ContactDataWrapper implements ContactData,
	ModelWrapper<ContactData> {
	public ContactDataWrapper(ContactData contactData) {
		_contactData = contactData;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactData.class;
	}

	@Override
	public String getModelClassName() {
		return ContactData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("contactDataType", getContactDataType());
		attributes.put("readOnly", getReadOnly());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("contactDataMethodId", getContactDataMethodId());
		attributes.put("contactId", getContactId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer contactDataType = (Integer)attributes.get("contactDataType");

		if (contactDataType != null) {
			setContactDataType(contactDataType);
		}

		Boolean readOnly = (Boolean)attributes.get("readOnly");

		if (readOnly != null) {
			setReadOnly(readOnly);
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

		Long contactDataMethodId = (Long)attributes.get("contactDataMethodId");

		if (contactDataMethodId != null) {
			setContactDataMethodId(contactDataMethodId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}
	}

	/**
	* Returns the primary key of this contact data.
	*
	* @return the primary key of this contact data
	*/
	@Override
	public long getPrimaryKey() {
		return _contactData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact data.
	*
	* @param primaryKey the primary key of this contact data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact data ID of this contact data.
	*
	* @return the contact data ID of this contact data
	*/
	@Override
	public long getContactDataId() {
		return _contactData.getContactDataId();
	}

	/**
	* Sets the contact data ID of this contact data.
	*
	* @param contactDataId the contact data ID of this contact data
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_contactData.setContactDataId(contactDataId);
	}

	/**
	* Returns the group ID of this contact data.
	*
	* @return the group ID of this contact data
	*/
	@Override
	public long getGroupId() {
		return _contactData.getGroupId();
	}

	/**
	* Sets the group ID of this contact data.
	*
	* @param groupId the group ID of this contact data
	*/
	@Override
	public void setGroupId(long groupId) {
		_contactData.setGroupId(groupId);
	}

	/**
	* Returns the contact data type of this contact data.
	*
	* @return the contact data type of this contact data
	*/
	@Override
	public int getContactDataType() {
		return _contactData.getContactDataType();
	}

	/**
	* Sets the contact data type of this contact data.
	*
	* @param contactDataType the contact data type of this contact data
	*/
	@Override
	public void setContactDataType(int contactDataType) {
		_contactData.setContactDataType(contactDataType);
	}

	/**
	* Returns the read only of this contact data.
	*
	* @return the read only of this contact data
	*/
	@Override
	public boolean getReadOnly() {
		return _contactData.getReadOnly();
	}

	/**
	* Returns <code>true</code> if this contact data is read only.
	*
	* @return <code>true</code> if this contact data is read only; <code>false</code> otherwise
	*/
	@Override
	public boolean isReadOnly() {
		return _contactData.isReadOnly();
	}

	/**
	* Sets whether this contact data is read only.
	*
	* @param readOnly the read only of this contact data
	*/
	@Override
	public void setReadOnly(boolean readOnly) {
		_contactData.setReadOnly(readOnly);
	}

	/**
	* Returns the company ID of this contact data.
	*
	* @return the company ID of this contact data
	*/
	@Override
	public long getCompanyId() {
		return _contactData.getCompanyId();
	}

	/**
	* Sets the company ID of this contact data.
	*
	* @param companyId the company ID of this contact data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contactData.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this contact data.
	*
	* @return the create date of this contact data
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contactData.getCreateDate();
	}

	/**
	* Sets the create date of this contact data.
	*
	* @param createDate the create date of this contact data
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contactData.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contact data.
	*
	* @return the modified date of this contact data
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contactData.getModifiedDate();
	}

	/**
	* Sets the modified date of this contact data.
	*
	* @param modifiedDate the modified date of this contact data
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactData.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the contact data method ID of this contact data.
	*
	* @return the contact data method ID of this contact data
	*/
	@Override
	public long getContactDataMethodId() {
		return _contactData.getContactDataMethodId();
	}

	/**
	* Sets the contact data method ID of this contact data.
	*
	* @param contactDataMethodId the contact data method ID of this contact data
	*/
	@Override
	public void setContactDataMethodId(long contactDataMethodId) {
		_contactData.setContactDataMethodId(contactDataMethodId);
	}

	/**
	* Returns the contact ID of this contact data.
	*
	* @return the contact ID of this contact data
	*/
	@Override
	public long getContactId() {
		return _contactData.getContactId();
	}

	/**
	* Sets the contact ID of this contact data.
	*
	* @param contactId the contact ID of this contact data
	*/
	@Override
	public void setContactId(long contactId) {
		_contactData.setContactId(contactId);
	}

	@Override
	public boolean isNew() {
		return _contactData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDataWrapper((ContactData)_contactData.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactData contactData) {
		return _contactData.compareTo(contactData);
	}

	@Override
	public int hashCode() {
		return _contactData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactData> toCacheModel() {
		return _contactData.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactData toEscapedModel() {
		return new ContactDataWrapper(_contactData.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactData toUnescapedModel() {
		return new ContactDataWrapper(_contactData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataWrapper)) {
			return false;
		}

		ContactDataWrapper contactDataWrapper = (ContactDataWrapper)obj;

		if (Validator.equals(_contactData, contactDataWrapper._contactData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactData getWrappedContactData() {
		return _contactData;
	}

	@Override
	public ContactData getWrappedModel() {
		return _contactData;
	}

	@Override
	public void resetOriginalValues() {
		_contactData.resetOriginalValues();
	}

	private ContactData _contactData;
}