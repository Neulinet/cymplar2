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
public class ContractSoap implements Serializable {
	public static ContractSoap toSoapModel(Contract model) {
		ContractSoap soapModel = new ContractSoap();

		soapModel.setContractId(model.getContractId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setEnterpriseId(model.getEnterpriseId());
		soapModel.setContactId(model.getContactId());
		soapModel.setDescription(model.getDescription());
		soapModel.setAmount(model.getAmount());

		return soapModel;
	}

	public static ContractSoap[] toSoapModels(Contract[] models) {
		ContractSoap[] soapModels = new ContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[][] toSoapModels(Contract[][] models) {
		ContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[] toSoapModels(List<Contract> models) {
		List<ContractSoap> soapModels = new ArrayList<ContractSoap>(models.size());

		for (Contract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContractSoap[soapModels.size()]);
	}

	public ContractSoap() {
	}

	public long getPrimaryKey() {
		return _contractId;
	}

	public void setPrimaryKey(long pk) {
		setContractId(pk);
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
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

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getEnterpriseId() {
		return _enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	private long _contractId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _organizationId;
	private long _enterpriseId;
	private long _contactId;
	private String _description;
	private double _amount;
}