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

package com.leancrm.portlet.library.model.impl;

import com.leancrm.portlet.library.model.AddressBookOrganization;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressBookOrganization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganization
 * @generated
 */
public class AddressBookOrganizationCacheModel implements CacheModel<AddressBookOrganization>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{addressBookId=");
		sb.append(addressBookId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressBookOrganization toEntityModel() {
		AddressBookOrganizationImpl addressBookOrganizationImpl = new AddressBookOrganizationImpl();

		addressBookOrganizationImpl.setAddressBookId(addressBookId);
		addressBookOrganizationImpl.setOrganizationId(organizationId);

		addressBookOrganizationImpl.resetOriginalValues();

		return addressBookOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressBookId = objectInput.readLong();
		organizationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressBookId);
		objectOutput.writeLong(organizationId);
	}

	public long addressBookId;
	public long organizationId;
}