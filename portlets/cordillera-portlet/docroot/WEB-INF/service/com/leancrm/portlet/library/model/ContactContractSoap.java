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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactContractSoap implements Serializable {
	public static ContactContractSoap toSoapModel(ContactContract model) {
		ContactContractSoap soapModel = new ContactContractSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setContractId(model.getContractId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static ContactContractSoap[] toSoapModels(ContactContract[] models) {
		ContactContractSoap[] soapModels = new ContactContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactContractSoap[][] toSoapModels(
		ContactContract[][] models) {
		ContactContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactContractSoap[] toSoapModels(
		List<ContactContract> models) {
		List<ContactContractSoap> soapModels = new ArrayList<ContactContractSoap>(models.size());

		for (ContactContract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactContractSoap[soapModels.size()]);
	}

	public ContactContractSoap() {
	}

	public ContactContractPK getPrimaryKey() {
		return new ContactContractPK(_contactId, _contractId);
	}

	public void setPrimaryKey(ContactContractPK pk) {
		setContactId(pk.contactId);
		setContractId(pk.contractId);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
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

	private long _contactId;
	private long _contractId;
	private boolean _active;
}