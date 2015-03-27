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
public class IndustrySoap implements Serializable {
	public static IndustrySoap toSoapModel(Industry model) {
		IndustrySoap soapModel = new IndustrySoap();

		soapModel.setIndustryId(model.getIndustryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static IndustrySoap[] toSoapModels(Industry[] models) {
		IndustrySoap[] soapModels = new IndustrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IndustrySoap[][] toSoapModels(Industry[][] models) {
		IndustrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IndustrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new IndustrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IndustrySoap[] toSoapModels(List<Industry> models) {
		List<IndustrySoap> soapModels = new ArrayList<IndustrySoap>(models.size());

		for (Industry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IndustrySoap[soapModels.size()]);
	}

	public IndustrySoap() {
	}

	public long getPrimaryKey() {
		return _industryId;
	}

	public void setPrimaryKey(long pk) {
		setIndustryId(pk);
	}

	public long getIndustryId() {
		return _industryId;
	}

	public void setIndustryId(long industryId) {
		_industryId = industryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _industryId;
	private long _groupId;
	private String _name;
}