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

import com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrganizationIndustrySoap implements Serializable {
	public static OrganizationIndustrySoap toSoapModel(
		OrganizationIndustry model) {
		OrganizationIndustrySoap soapModel = new OrganizationIndustrySoap();

		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setIndustryId(model.getIndustryId());

		return soapModel;
	}

	public static OrganizationIndustrySoap[] toSoapModels(
		OrganizationIndustry[] models) {
		OrganizationIndustrySoap[] soapModels = new OrganizationIndustrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationIndustrySoap[][] toSoapModels(
		OrganizationIndustry[][] models) {
		OrganizationIndustrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationIndustrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationIndustrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationIndustrySoap[] toSoapModels(
		List<OrganizationIndustry> models) {
		List<OrganizationIndustrySoap> soapModels = new ArrayList<OrganizationIndustrySoap>(models.size());

		for (OrganizationIndustry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationIndustrySoap[soapModels.size()]);
	}

	public OrganizationIndustrySoap() {
	}

	public OrganizationIndustryPK getPrimaryKey() {
		return new OrganizationIndustryPK(_organizationId, _industryId);
	}

	public void setPrimaryKey(OrganizationIndustryPK pk) {
		setOrganizationId(pk.organizationId);
		setIndustryId(pk.industryId);
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getIndustryId() {
		return _industryId;
	}

	public void setIndustryId(long industryId) {
		_industryId = industryId;
	}

	private long _organizationId;
	private long _industryId;
}