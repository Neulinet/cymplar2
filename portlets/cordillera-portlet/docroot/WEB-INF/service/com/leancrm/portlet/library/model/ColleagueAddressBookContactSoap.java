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

import com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ColleagueAddressBookContactSoap implements Serializable {
	public static ColleagueAddressBookContactSoap toSoapModel(
		ColleagueAddressBookContact model) {
		ColleagueAddressBookContactSoap soapModel = new ColleagueAddressBookContactSoap();

		soapModel.setContactid(model.getContactid());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setContactdataid(model.getContactdataid());
		soapModel.setMethodId(model.getMethodId());
		soapModel.setContactName(model.getContactName());
		soapModel.setEnterpriseName(model.getEnterpriseName());

		return soapModel;
	}

	public static ColleagueAddressBookContactSoap[] toSoapModels(
		ColleagueAddressBookContact[] models) {
		ColleagueAddressBookContactSoap[] soapModels = new ColleagueAddressBookContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ColleagueAddressBookContactSoap[][] toSoapModels(
		ColleagueAddressBookContact[][] models) {
		ColleagueAddressBookContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ColleagueAddressBookContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ColleagueAddressBookContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ColleagueAddressBookContactSoap[] toSoapModels(
		List<ColleagueAddressBookContact> models) {
		List<ColleagueAddressBookContactSoap> soapModels = new ArrayList<ColleagueAddressBookContactSoap>(models.size());

		for (ColleagueAddressBookContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ColleagueAddressBookContactSoap[soapModels.size()]);
	}

	public ColleagueAddressBookContactSoap() {
	}

	public ColleagueAddressBookContactPK getPrimaryKey() {
		return new ColleagueAddressBookContactPK(_contactid, _methodId);
	}

	public void setPrimaryKey(ColleagueAddressBookContactPK pk) {
		setContactid(pk.contactid);
		setMethodId(pk.methodId);
	}

	public long getContactid() {
		return _contactid;
	}

	public void setContactid(long contactid) {
		_contactid = contactid;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getContactdataid() {
		return _contactdataid;
	}

	public void setContactdataid(long contactdataid) {
		_contactdataid = contactdataid;
	}

	public long getMethodId() {
		return _methodId;
	}

	public void setMethodId(long methodId) {
		_methodId = methodId;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getEnterpriseName() {
		return _enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		_enterpriseName = enterpriseName;
	}

	private long _contactid;
	private String _emailAddress;
	private long _contactdataid;
	private long _methodId;
	private String _contactName;
	private String _enterpriseName;
}