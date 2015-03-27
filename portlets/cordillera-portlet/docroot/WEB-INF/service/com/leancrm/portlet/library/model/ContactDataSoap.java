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
public class ContactDataSoap implements Serializable {
	public static ContactDataSoap toSoapModel(ContactData model) {
		ContactDataSoap soapModel = new ContactDataSoap();

		soapModel.setContactDataId(model.getContactDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setContactDataType(model.getContactDataType());
		soapModel.setReadOnly(model.getReadOnly());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setContactDataMethodId(model.getContactDataMethodId());
		soapModel.setContactId(model.getContactId());

		return soapModel;
	}

	public static ContactDataSoap[] toSoapModels(ContactData[] models) {
		ContactDataSoap[] soapModels = new ContactDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDataSoap[][] toSoapModels(ContactData[][] models) {
		ContactDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDataSoap[] toSoapModels(List<ContactData> models) {
		List<ContactDataSoap> soapModels = new ArrayList<ContactDataSoap>(models.size());

		for (ContactData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDataSoap[soapModels.size()]);
	}

	public ContactDataSoap() {
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getContactDataType() {
		return _contactDataType;
	}

	public void setContactDataType(int contactDataType) {
		_contactDataType = contactDataType;
	}

	public boolean getReadOnly() {
		return _readOnly;
	}

	public boolean isReadOnly() {
		return _readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		_readOnly = readOnly;
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

	public long getContactDataMethodId() {
		return _contactDataMethodId;
	}

	public void setContactDataMethodId(long contactDataMethodId) {
		_contactDataMethodId = contactDataMethodId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	private long _contactDataId;
	private long _groupId;
	private int _contactDataType;
	private boolean _readOnly;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _contactDataMethodId;
	private long _contactId;
}