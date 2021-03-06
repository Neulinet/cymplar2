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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ContactData service. Represents a row in the &quot;crm_ContactData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.leancrm.portlet.library.model.impl.ContactDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactData
 * @see com.leancrm.portlet.library.model.impl.ContactDataImpl
 * @see com.leancrm.portlet.library.model.impl.ContactDataModelImpl
 * @generated
 */
public interface ContactDataModel extends BaseModel<ContactData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact data model instance should use the {@link ContactData} interface instead.
	 */

	/**
	 * Returns the primary key of this contact data.
	 *
	 * @return the primary key of this contact data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contact data.
	 *
	 * @param primaryKey the primary key of this contact data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contact data ID of this contact data.
	 *
	 * @return the contact data ID of this contact data
	 */
	public long getContactDataId();

	/**
	 * Sets the contact data ID of this contact data.
	 *
	 * @param contactDataId the contact data ID of this contact data
	 */
	public void setContactDataId(long contactDataId);

	/**
	 * Returns the group ID of this contact data.
	 *
	 * @return the group ID of this contact data
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this contact data.
	 *
	 * @param groupId the group ID of this contact data
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the contact data type of this contact data.
	 *
	 * @return the contact data type of this contact data
	 */
	public int getContactDataType();

	/**
	 * Sets the contact data type of this contact data.
	 *
	 * @param contactDataType the contact data type of this contact data
	 */
	public void setContactDataType(int contactDataType);

	/**
	 * Returns the read only of this contact data.
	 *
	 * @return the read only of this contact data
	 */
	public boolean getReadOnly();

	/**
	 * Returns <code>true</code> if this contact data is read only.
	 *
	 * @return <code>true</code> if this contact data is read only; <code>false</code> otherwise
	 */
	public boolean isReadOnly();

	/**
	 * Sets whether this contact data is read only.
	 *
	 * @param readOnly the read only of this contact data
	 */
	public void setReadOnly(boolean readOnly);

	/**
	 * Returns the company ID of this contact data.
	 *
	 * @return the company ID of this contact data
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this contact data.
	 *
	 * @param companyId the company ID of this contact data
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this contact data.
	 *
	 * @return the create date of this contact data
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this contact data.
	 *
	 * @param createDate the create date of this contact data
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this contact data.
	 *
	 * @return the modified date of this contact data
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this contact data.
	 *
	 * @param modifiedDate the modified date of this contact data
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the contact data method ID of this contact data.
	 *
	 * @return the contact data method ID of this contact data
	 */
	public long getContactDataMethodId();

	/**
	 * Sets the contact data method ID of this contact data.
	 *
	 * @param contactDataMethodId the contact data method ID of this contact data
	 */
	public void setContactDataMethodId(long contactDataMethodId);

	/**
	 * Returns the contact ID of this contact data.
	 *
	 * @return the contact ID of this contact data
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this contact data.
	 *
	 * @param contactId the contact ID of this contact data
	 */
	public void setContactId(long contactId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ContactData contactData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ContactData> toCacheModel();

	@Override
	public ContactData toEscapedModel();

	@Override
	public ContactData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}