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

import com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyAddressBookContactSoap implements Serializable {
	public static MyAddressBookContactSoap toSoapModel(
		MyAddressBookContact model) {
		MyAddressBookContactSoap soapModel = new MyAddressBookContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setMethodId(model.getMethodId());
		soapModel.setContactName(model.getContactName());
		soapModel.setEnterpriseId(model.getEnterpriseId());
		soapModel.setEnterpriseName(model.getEnterpriseName());
		soapModel.setContractId(model.getContractId());
		soapModel.setReportId(model.getReportId());
		soapModel.setStatus(model.getStatus());
		soapModel.setProgress(model.getProgress());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static MyAddressBookContactSoap[] toSoapModels(
		MyAddressBookContact[] models) {
		MyAddressBookContactSoap[] soapModels = new MyAddressBookContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MyAddressBookContactSoap[][] toSoapModels(
		MyAddressBookContact[][] models) {
		MyAddressBookContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MyAddressBookContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MyAddressBookContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MyAddressBookContactSoap[] toSoapModels(
		List<MyAddressBookContact> models) {
		List<MyAddressBookContactSoap> soapModels = new ArrayList<MyAddressBookContactSoap>(models.size());

		for (MyAddressBookContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MyAddressBookContactSoap[soapModels.size()]);
	}

	public MyAddressBookContactSoap() {
	}

	public MyAddressBookContactPK getPrimaryKey() {
		return new MyAddressBookContactPK(_contactId, _methodId);
	}

	public void setPrimaryKey(MyAddressBookContactPK pk) {
		setContactId(pk.contactId);
		setMethodId(pk.methodId);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
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

	public long getEnterpriseId() {
		return _enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return _enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		_enterpriseName = enterpriseName;
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public double getProgress() {
		return _progress;
	}

	public void setProgress(double progress) {
		_progress = progress;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _contactId;
	private long _methodId;
	private String _contactName;
	private long _enterpriseId;
	private String _enterpriseName;
	private long _contractId;
	private long _reportId;
	private int _status;
	private double _progress;
	private String _description;
}