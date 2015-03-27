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
public class EnterpriseSoap implements Serializable {
	public static EnterpriseSoap toSoapModel(Enterprise model) {
		EnterpriseSoap soapModel = new EnterpriseSoap();

		soapModel.setEnterpriseId(model.getEnterpriseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setIsPrivate(model.getIsPrivate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setTaxid(model.getTaxid());
		soapModel.setDescription(model.getDescription());
		soapModel.setIndustry(model.getIndustry());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static EnterpriseSoap[] toSoapModels(Enterprise[] models) {
		EnterpriseSoap[] soapModels = new EnterpriseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnterpriseSoap[][] toSoapModels(Enterprise[][] models) {
		EnterpriseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnterpriseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnterpriseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnterpriseSoap[] toSoapModels(List<Enterprise> models) {
		List<EnterpriseSoap> soapModels = new ArrayList<EnterpriseSoap>(models.size());

		for (Enterprise model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnterpriseSoap[soapModels.size()]);
	}

	public EnterpriseSoap() {
	}

	public long getPrimaryKey() {
		return _enterpriseId;
	}

	public void setPrimaryKey(long pk) {
		setEnterpriseId(pk);
	}

	public long getEnterpriseId() {
		return _enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		_enterpriseId = enterpriseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getIsPrivate() {
		return _isPrivate;
	}

	public void setIsPrivate(int isPrivate) {
		_isPrivate = isPrivate;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTaxid() {
		return _taxid;
	}

	public void setTaxid(String taxid) {
		_taxid = taxid;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getIndustry() {
		return _industry;
	}

	public void setIndustry(long industry) {
		_industry = industry;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _enterpriseId;
	private long _groupId;
	private int _isPrivate;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _taxid;
	private String _description;
	private long _industry;
	private String _email;
}