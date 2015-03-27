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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ContactDataPhone service. Represents a row in the &quot;crm_ContactDataPhone&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhone
 * @see com.leancrm.portlet.library.model.impl.ContactDataPhoneImpl
 * @see com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl
 * @generated
 */
public interface ContactDataPhoneModel extends BaseModel<ContactDataPhone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact data phone model instance should use the {@link ContactDataPhone} interface instead.
	 */

	/**
	 * Returns the primary key of this contact data phone.
	 *
	 * @return the primary key of this contact data phone
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contact data phone.
	 *
	 * @param primaryKey the primary key of this contact data phone
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contact data ID of this contact data phone.
	 *
	 * @return the contact data ID of this contact data phone
	 */
	public long getContactDataId();

	/**
	 * Sets the contact data ID of this contact data phone.
	 *
	 * @param contactDataId the contact data ID of this contact data phone
	 */
	public void setContactDataId(long contactDataId);

	/**
	 * Returns the extension of this contact data phone.
	 *
	 * @return the extension of this contact data phone
	 */
	@AutoEscape
	public String getExtension();

	/**
	 * Sets the extension of this contact data phone.
	 *
	 * @param extension the extension of this contact data phone
	 */
	public void setExtension(String extension);

	/**
	 * Returns the number of this contact data phone.
	 *
	 * @return the number of this contact data phone
	 */
	@AutoEscape
	public String getNumber();

	/**
	 * Sets the number of this contact data phone.
	 *
	 * @param number the number of this contact data phone
	 */
	public void setNumber(String number);

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
	public int compareTo(ContactDataPhone contactDataPhone);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ContactDataPhone> toCacheModel();

	@Override
	public ContactDataPhone toEscapedModel();

	@Override
	public ContactDataPhone toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}