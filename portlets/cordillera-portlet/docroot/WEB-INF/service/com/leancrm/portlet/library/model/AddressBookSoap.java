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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressBookSoap implements Serializable {
	public static AddressBookSoap toSoapModel(AddressBook model) {
		AddressBookSoap soapModel = new AddressBookSoap();

		soapModel.setAddressBookId(model.getAddressBookId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAddressBookType(model.getAddressBookType());

		return soapModel;
	}

	public static AddressBookSoap[] toSoapModels(AddressBook[] models) {
		AddressBookSoap[] soapModels = new AddressBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressBookSoap[][] toSoapModels(AddressBook[][] models) {
		AddressBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressBookSoap[] toSoapModels(List<AddressBook> models) {
		List<AddressBookSoap> soapModels = new ArrayList<AddressBookSoap>(models.size());

		for (AddressBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressBookSoap[soapModels.size()]);
	}

	public AddressBookSoap() {
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAddressBookType() {
		return _addressBookType;
	}

	public void setAddressBookType(long addressBookType) {
		_addressBookType = addressBookType;
	}

	private long _addressBookId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _addressBookType;
}