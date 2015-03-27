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
 * This class is a wrapper for {@link ContactDataMethod}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethod
 * @generated
 */
public class ContactDataMethodWrapper implements ContactDataMethod,
	ModelWrapper<ContactDataMethod> {
	public ContactDataMethodWrapper(ContactDataMethod contactDataMethod) {
		_contactDataMethod = contactDataMethod;
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataMethod.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataMethod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataMethodId", getContactDataMethodId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("contactDataType", getContactDataType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataMethodId = (Long)attributes.get("contactDataMethodId");

		if (contactDataMethodId != null) {
			setContactDataMethodId(contactDataMethodId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer contactDataType = (Integer)attributes.get("contactDataType");

		if (contactDataType != null) {
			setContactDataType(contactDataType);
		}
	}

	/**
	* Returns the primary key of this contact data method.
	*
	* @return the primary key of this contact data method
	*/
	@Override
	public long getPrimaryKey() {
		return _contactDataMethod.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact data method.
	*
	* @param primaryKey the primary key of this contact data method
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactDataMethod.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact data method ID of this contact data method.
	*
	* @return the contact data method ID of this contact data method
	*/
	@Override
	public long getContactDataMethodId() {
		return _contactDataMethod.getContactDataMethodId();
	}

	/**
	* Sets the contact data method ID of this contact data method.
	*
	* @param contactDataMethodId the contact data method ID of this contact data method
	*/
	@Override
	public void setContactDataMethodId(long contactDataMethodId) {
		_contactDataMethod.setContactDataMethodId(contactDataMethodId);
	}

	/**
	* Returns the group ID of this contact data method.
	*
	* @return the group ID of this contact data method
	*/
	@Override
	public long getGroupId() {
		return _contactDataMethod.getGroupId();
	}

	/**
	* Sets the group ID of this contact data method.
	*
	* @param groupId the group ID of this contact data method
	*/
	@Override
	public void setGroupId(long groupId) {
		_contactDataMethod.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contact data method.
	*
	* @return the company ID of this contact data method
	*/
	@Override
	public long getCompanyId() {
		return _contactDataMethod.getCompanyId();
	}

	/**
	* Sets the company ID of this contact data method.
	*
	* @param companyId the company ID of this contact data method
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contactDataMethod.setCompanyId(companyId);
	}

	/**
	* Returns the name of this contact data method.
	*
	* @return the name of this contact data method
	*/
	@Override
	public java.lang.String getName() {
		return _contactDataMethod.getName();
	}

	/**
	* Sets the name of this contact data method.
	*
	* @param name the name of this contact data method
	*/
	@Override
	public void setName(java.lang.String name) {
		_contactDataMethod.setName(name);
	}

	/**
	* Returns the title of this contact data method.
	*
	* @return the title of this contact data method
	*/
	@Override
	public java.lang.String getTitle() {
		return _contactDataMethod.getTitle();
	}

	/**
	* Sets the title of this contact data method.
	*
	* @param title the title of this contact data method
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_contactDataMethod.setTitle(title);
	}

	/**
	* Returns the contact data type of this contact data method.
	*
	* @return the contact data type of this contact data method
	*/
	@Override
	public int getContactDataType() {
		return _contactDataMethod.getContactDataType();
	}

	/**
	* Sets the contact data type of this contact data method.
	*
	* @param contactDataType the contact data type of this contact data method
	*/
	@Override
	public void setContactDataType(int contactDataType) {
		_contactDataMethod.setContactDataType(contactDataType);
	}

	@Override
	public boolean isNew() {
		return _contactDataMethod.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactDataMethod.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactDataMethod.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactDataMethod.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactDataMethod.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactDataMethod.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactDataMethod.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactDataMethod.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactDataMethod.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactDataMethod.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactDataMethod.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDataMethodWrapper((ContactDataMethod)_contactDataMethod.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod) {
		return _contactDataMethod.compareTo(contactDataMethod);
	}

	@Override
	public int hashCode() {
		return _contactDataMethod.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.ContactDataMethod> toCacheModel() {
		return _contactDataMethod.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod toEscapedModel() {
		return new ContactDataMethodWrapper(_contactDataMethod.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod toUnescapedModel() {
		return new ContactDataMethodWrapper(_contactDataMethod.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactDataMethod.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactDataMethod.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactDataMethod.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataMethodWrapper)) {
			return false;
		}

		ContactDataMethodWrapper contactDataMethodWrapper = (ContactDataMethodWrapper)obj;

		if (Validator.equals(_contactDataMethod,
					contactDataMethodWrapper._contactDataMethod)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactDataMethod getWrappedContactDataMethod() {
		return _contactDataMethod;
	}

	@Override
	public ContactDataMethod getWrappedModel() {
		return _contactDataMethod;
	}

	@Override
	public void resetOriginalValues() {
		_contactDataMethod.resetOriginalValues();
	}

	private ContactDataMethod _contactDataMethod;
}