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
public class ContactDataRefSoap implements Serializable {
	public static ContactDataRefSoap toSoapModel(ContactDataRef model) {
		ContactDataRefSoap soapModel = new ContactDataRefSoap();

		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setRefValue(model.getRefValue());

		return soapModel;
	}

	public static ContactDataRefSoap[] toSoapModels(ContactDataRef[] models) {
		ContactDataRefSoap[] soapModels = new ContactDataRefSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDataRefSoap[][] toSoapModels(ContactDataRef[][] models) {
		ContactDataRefSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDataRefSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDataRefSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDataRefSoap[] toSoapModels(List<ContactDataRef> models) {
		List<ContactDataRefSoap> soapModels = new ArrayList<ContactDataRefSoap>(models.size());

		for (ContactDataRef model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDataRefSoap[soapModels.size()]);
	}

	public ContactDataRefSoap() {
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

	public long getRefValue() {
		return _refValue;
	}

	public void setRefValue(long refValue) {
		_refValue = refValue;
	}

	private long _contactDataId;
	private long _refValue;
}