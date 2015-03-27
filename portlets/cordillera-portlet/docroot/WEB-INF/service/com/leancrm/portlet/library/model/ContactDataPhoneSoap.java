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
public class ContactDataPhoneSoap implements Serializable {
	public static ContactDataPhoneSoap toSoapModel(ContactDataPhone model) {
		ContactDataPhoneSoap soapModel = new ContactDataPhoneSoap();

		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setExtension(model.getExtension());
		soapModel.setNumber(model.getNumber());

		return soapModel;
	}

	public static ContactDataPhoneSoap[] toSoapModels(ContactDataPhone[] models) {
		ContactDataPhoneSoap[] soapModels = new ContactDataPhoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDataPhoneSoap[][] toSoapModels(
		ContactDataPhone[][] models) {
		ContactDataPhoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDataPhoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDataPhoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDataPhoneSoap[] toSoapModels(
		List<ContactDataPhone> models) {
		List<ContactDataPhoneSoap> soapModels = new ArrayList<ContactDataPhoneSoap>(models.size());

		for (ContactDataPhone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDataPhoneSoap[soapModels.size()]);
	}

	public ContactDataPhoneSoap() {
	}

	public long getPrimaryKey() {
		return _contactDataId;
	}

	public void setPrimaryKey(long pk) {
		setContactDataId(pk);
	}

	public long getContactDataId() {
		return _contactDataId;
	}

	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;
	}

	public String getExtension() {
		return _extension;
	}

	public void setExtension(String extension) {
		_extension = extension;
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	private long _contactDataId;
	private String _extension;
	private String _number;
}