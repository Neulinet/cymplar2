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

import com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressBookContactDataSoap implements Serializable {
	public static AddressBookContactDataSoap toSoapModel(
		AddressBookContactData model) {
		AddressBookContactDataSoap soapModel = new AddressBookContactDataSoap();

		soapModel.setAddressBookId(model.getAddressBookId());
		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static AddressBookContactDataSoap[] toSoapModels(
		AddressBookContactData[] models) {
		AddressBookContactDataSoap[] soapModels = new AddressBookContactDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressBookContactDataSoap[][] toSoapModels(
		AddressBookContactData[][] models) {
		AddressBookContactDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressBookContactDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressBookContactDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressBookContactDataSoap[] toSoapModels(
		List<AddressBookContactData> models) {
		List<AddressBookContactDataSoap> soapModels = new ArrayList<AddressBookContactDataSoap>(models.size());

		for (AddressBookContactData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressBookContactDataSoap[soapModels.size()]);
	}

	public AddressBookContactDataSoap() {
	}

	public AddressBookContactDataPK getPrimaryKey() {
		return new AddressBookContactDataPK(_addressBookId, _contactDataId);
	}

	public void setPrimaryKey(AddressBookContactDataPK pk) {
		setAddressBookId(pk.addressBookId);
		setContactDataId(pk.contactDataId);
	}

	public long getAddressBookId() {
		return _addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;
	}

	public long getContactDataId() {
		return _contactDataId;
	}

	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _addressBookId;
	private long _contactDataId;
	private boolean _active;
}