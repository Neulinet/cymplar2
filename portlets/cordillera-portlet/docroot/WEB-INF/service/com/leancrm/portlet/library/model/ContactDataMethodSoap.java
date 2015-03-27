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
public class ContactDataMethodSoap implements Serializable {
	public static ContactDataMethodSoap toSoapModel(ContactDataMethod model) {
		ContactDataMethodSoap soapModel = new ContactDataMethodSoap();

		soapModel.setContactDataMethodId(model.getContactDataMethodId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setContactDataType(model.getContactDataType());

		return soapModel;
	}

	public static ContactDataMethodSoap[] toSoapModels(
		ContactDataMethod[] models) {
		ContactDataMethodSoap[] soapModels = new ContactDataMethodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDataMethodSoap[][] toSoapModels(
		ContactDataMethod[][] models) {
		ContactDataMethodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDataMethodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDataMethodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDataMethodSoap[] toSoapModels(
		List<ContactDataMethod> models) {
		List<ContactDataMethodSoap> soapModels = new ArrayList<ContactDataMethodSoap>(models.size());

		for (ContactDataMethod model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDataMethodSoap[soapModels.size()]);
	}

	public ContactDataMethodSoap() {
	}

	public long getPrimaryKey() {
		return _contactDataMethodId;
	}

	public void setPrimaryKey(long pk) {
		setContactDataMethodId(pk);
	}

	public long getContactDataMethodId() {
		return _contactDataMethodId;
	}

	public void setContactDataMethodId(long contactDataMethodId) {
		_contactDataMethodId = contactDataMethodId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getContactDataType() {
		return _contactDataType;
	}

	public void setContactDataType(int contactDataType) {
		_contactDataType = contactDataType;
	}

	private long _contactDataMethodId;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _title;
	private int _contactDataType;
}