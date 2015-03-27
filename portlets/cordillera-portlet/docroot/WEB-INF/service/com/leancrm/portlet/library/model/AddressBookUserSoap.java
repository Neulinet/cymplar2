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
public class AddressBookUserSoap implements Serializable {
	public static AddressBookUserSoap toSoapModel(AddressBookUser model) {
		AddressBookUserSoap soapModel = new AddressBookUserSoap();

		soapModel.setAddressBookId(model.getAddressBookId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static AddressBookUserSoap[] toSoapModels(AddressBookUser[] models) {
		AddressBookUserSoap[] soapModels = new AddressBookUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressBookUserSoap[][] toSoapModels(
		AddressBookUser[][] models) {
		AddressBookUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressBookUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressBookUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressBookUserSoap[] toSoapModels(
		List<AddressBookUser> models) {
		List<AddressBookUserSoap> soapModels = new ArrayList<AddressBookUserSoap>(models.size());

		for (AddressBookUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressBookUserSoap[soapModels.size()]);
	}

	public AddressBookUserSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _addressBookId;
	private long _userId;
}