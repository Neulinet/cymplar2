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
public class ContactDataTextSoap implements Serializable {
	public static ContactDataTextSoap toSoapModel(ContactDataText model) {
		ContactDataTextSoap soapModel = new ContactDataTextSoap();

		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ContactDataTextSoap[] toSoapModels(ContactDataText[] models) {
		ContactDataTextSoap[] soapModels = new ContactDataTextSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDataTextSoap[][] toSoapModels(
		ContactDataText[][] models) {
		ContactDataTextSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDataTextSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDataTextSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDataTextSoap[] toSoapModels(
		List<ContactDataText> models) {
		List<ContactDataTextSoap> soapModels = new ArrayList<ContactDataTextSoap>(models.size());

		for (ContactDataText model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDataTextSoap[soapModels.size()]);
	}

	public ContactDataTextSoap() {
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _contactDataId;
	private String _value;
}