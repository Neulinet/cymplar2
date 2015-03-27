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

import com.leancrm.portlet.library.service.persistence.AddressBookContactPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressBookContactSoap implements Serializable {
	public static AddressBookContactSoap toSoapModel(AddressBookContact model) {
		AddressBookContactSoap soapModel = new AddressBookContactSoap();

		soapModel.setAddressBookId(model.getAddressBookId());
		soapModel.setContactId(model.getContactId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAssignedTo(model.getAssignedTo());
		soapModel.setCurrentProgress(model.getCurrentProgress());

		return soapModel;
	}

	public static AddressBookContactSoap[] toSoapModels(
		AddressBookContact[] models) {
		AddressBookContactSoap[] soapModels = new AddressBookContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressBookContactSoap[][] toSoapModels(
		AddressBookContact[][] models) {
		AddressBookContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressBookContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressBookContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressBookContactSoap[] toSoapModels(
		List<AddressBookContact> models) {
		List<AddressBookContactSoap> soapModels = new ArrayList<AddressBookContactSoap>(models.size());

		for (AddressBookContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressBookContactSoap[soapModels.size()]);
	}

	public AddressBookContactSoap() {
	}

	public AddressBookContactPK getPrimaryKey() {
		return new AddressBookContactPK(_addressBookId, _contactId);
	}

	public void setPrimaryKey(AddressBookContactPK pk) {
		setAddressBookId(pk.addressBookId);
		setContactId(pk.contactId);
	}

	public long getAddressBookId() {
		return _addressBookId;
	}

	public void setAddressBookId(long addressBookId) {
		_addressBookId = addressBookId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
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

	public long getAssignedTo() {
		return _assignedTo;
	}

	public void setAssignedTo(long assignedTo) {
		_assignedTo = assignedTo;
	}

	public double getCurrentProgress() {
		return _currentProgress;
	}

	public void setCurrentProgress(double currentProgress) {
		_currentProgress = currentProgress;
	}

	private long _addressBookId;
	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _assignedTo;
	private double _currentProgress;
}