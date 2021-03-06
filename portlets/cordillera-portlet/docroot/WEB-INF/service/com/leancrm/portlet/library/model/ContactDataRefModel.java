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

/**
 * The base model interface for the ContactDataRef service. Represents a row in the &quot;crm_ContactDataRef&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.leancrm.portlet.library.model.impl.ContactDataRefImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRef
 * @see com.leancrm.portlet.library.model.impl.ContactDataRefImpl
 * @see com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl
 * @generated
 */
public interface ContactDataRefModel extends BaseModel<ContactDataRef> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact data ref model instance should use the {@link ContactDataRef} interface instead.
	 */

	/**
	 * Returns the primary key of this contact data ref.
	 *
	 * @return the primary key of this contact data ref
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contact data ref.
	 *
	 * @param primaryKey the primary key of this contact data ref
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contact data ID of this contact data ref.
	 *
	 * @return the contact data ID of this contact data ref
	 */
	public long getContactDataId();

	/**
	 * Sets the contact data ID of this contact data ref.
	 *
	 * @param contactDataId the contact data ID of this contact data ref
	 */
	public void setContactDataId(long contactDataId);

	/**
	 * Returns the ref value of this contact data ref.
	 *
	 * @return the ref value of this contact data ref
	 */
	public long getRefValue();

	/**
	 * Sets the ref value of this contact data ref.
	 *
	 * @param refValue the ref value of this contact data ref
	 */
	public void setRefValue(long refValue);

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
	public int compareTo(ContactDataRef contactDataRef);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ContactDataRef> toCacheModel();

	@Override
	public ContactDataRef toEscapedModel();

	@Override
	public ContactDataRef toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}