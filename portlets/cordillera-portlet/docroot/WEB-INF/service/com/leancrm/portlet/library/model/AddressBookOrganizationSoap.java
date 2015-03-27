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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressBookOrganizationSoap implements Serializable {
	public static AddressBookOrganizationSoap toSoapModel(
		AddressBookOrganization model) {
		AddressBookOrganizationSoap soapModel = new AddressBookOrganizationSoap();

		soapModel.setAddressBookId(model.getAddressBookId());
		soapModel.setOrganizationId(model.getOrganizationId());

		return soapModel;
	}

	public static AddressBookOrganizationSoap[] toSoapModels(
		AddressBookOrganization[] models) {
		AddressBookOrganizationSoap[] soapModels = new AddressBookOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressBookOrganizationSoap[][] toSoapModels(
		AddressBookOrganization[][] models) {
		AddressBookOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressBookOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressBookOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressBookOrganizationSoap[] toSoapModels(
		List<AddressBookOrganization> models) {
		List<AddressBookOrganizationSoap> soapModels = new ArrayList<AddressBookOrganizationSoap>(models.size());

		for (AddressBookOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressBookOrganizationSoap[soapModels.size()]);
	}

	public AddressBookOrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _addressBookId;
	}

	public void setPrimaryKey(long pk) {
		setAddressBookId(pk);
	}

	public long getAddressBookId() {
		return _addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	private long _addressBookId;
	private long _organizationId;
}