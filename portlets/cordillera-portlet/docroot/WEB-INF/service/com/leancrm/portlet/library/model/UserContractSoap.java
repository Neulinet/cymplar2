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

import com.leancrm.portlet.library.service.persistence.UserContractPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserContractSoap implements Serializable {
	public static UserContractSoap toSoapModel(UserContract model) {
		UserContractSoap soapModel = new UserContractSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setContractId(model.getContractId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static UserContractSoap[] toSoapModels(UserContract[] models) {
		UserContractSoap[] soapModels = new UserContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserContractSoap[][] toSoapModels(UserContract[][] models) {
		UserContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserContractSoap[] toSoapModels(List<UserContract> models) {
		List<UserContractSoap> soapModels = new ArrayList<UserContractSoap>(models.size());

		for (UserContract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserContractSoap[soapModels.size()]);
	}

	public UserContractSoap() {
	}

	public UserContractPK getPrimaryKey() {
		return new UserContractPK(_userId, _contractId);
	}

	public void setPrimaryKey(UserContractPK pk) {
		setUserId(pk.userId);
		setContractId(pk.contractId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getContractId() {
		return _contractId;
	}

	public void setContractId(long contractId) {
		_contractId = contractId;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _userId;
	private long _contractId;
	private boolean _active;
}