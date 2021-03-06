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

import com.leancrm.portlet.library.service.persistence.ContactContractPK;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ContactContract service. Represents a row in the &quot;crm_ContactContract&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.leancrm.portlet.library.model.impl.ContactContractImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactContract
 * @see com.leancrm.portlet.library.model.impl.ContactContractImpl
 * @see com.leancrm.portlet.library.model.impl.ContactContractModelImpl
 * @generated
 */
public interface ContactContractModel extends BaseModel<ContactContract> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact contract model instance should use the {@link ContactContract} interface instead.
	 */

	/**
	 * Returns the primary key of this contact contract.
	 *
	 * @return the primary key of this contact contract
	 */
	public ContactContractPK getPrimaryKey();

	/**
	 * Sets the primary key of this contact contract.
	 *
	 * @param primaryKey the primary key of this contact contract
	 */
	public void setPrimaryKey(ContactContractPK primaryKey);

	/**
	 * Returns the contact ID of this contact contract.
	 *
	 * @return the contact ID of this contact contract
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this contact contract.
	 *
	 * @param contactId the contact ID of this contact contract
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the contract ID of this contact contract.
	 *
	 * @return the contract ID of this contact contract
	 */
	public long getContractId();

	/**
	 * Sets the contract ID of this contact contract.
	 *
	 * @param contractId the contract ID of this contact contract
	 */
	public void setContractId(long contractId);

	/**
	 * Returns the active of this contact contract.
	 *
	 * @return the active of this contact contract
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this contact contract is active.
	 *
	 * @return <code>true</code> if this contact contract is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this contact contract is active.
	 *
	 * @param active the active of this contact contract
	 */
	public void setActive(boolean active);

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
	public int compareTo(ContactContract contactContract);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ContactContract> toCacheModel();

	@Override
	public ContactContract toEscapedModel();

	@Override
	public ContactContract toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}