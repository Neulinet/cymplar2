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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserContract}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserContract
 * @generated
 */
public class UserContractWrapper implements UserContract,
	ModelWrapper<UserContract> {
	public UserContractWrapper(UserContract userContract) {
		_userContract = userContract;
	}

	@Override
	public Class<?> getModelClass() {
		return UserContract.class;
	}

	@Override
	public String getModelClassName() {
		return UserContract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("contractId", getContractId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this user contract.
	*
	* @return the primary key of this user contract
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.UserContractPK getPrimaryKey() {
		return _userContract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user contract.
	*
	* @param primaryKey the primary key of this user contract
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.UserContractPK primaryKey) {
		_userContract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user contract.
	*
	* @return the user ID of this user contract
	*/
	@Override
	public long getUserId() {
		return _userContract.getUserId();
	}

	/**
	* Sets the user ID of this user contract.
	*
	* @param userId the user ID of this user contract
	*/
	@Override
	public void setUserId(long userId) {
		_userContract.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user contract.
	*
	* @return the user uuid of this user contract
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContract.getUserUuid();
	}

	/**
	* Sets the user uuid of this user contract.
	*
	* @param userUuid the user uuid of this user contract
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userContract.setUserUuid(userUuid);
	}

	/**
	* Returns the contract ID of this user contract.
	*
	* @return the contract ID of this user contract
	*/
	@Override
	public long getContractId() {
		return _userContract.getContractId();
	}

	/**
	* Sets the contract ID of this user contract.
	*
	* @param contractId the contract ID of this user contract
	*/
	@Override
	public void setContractId(long contractId) {
		_userContract.setContractId(contractId);
	}

	/**
	* Returns the active of this user contract.
	*
	* @return the active of this user contract
	*/
	@Override
	public boolean getActive() {
		return _userContract.getActive();
	}

	/**
	* Returns <code>true</code> if this user contract is active.
	*
	* @return <code>true</code> if this user contract is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _userContract.isActive();
	}

	/**
	* Sets whether this user contract is active.
	*
	* @param active the active of this user contract
	*/
	@Override
	public void setActive(boolean active) {
		_userContract.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _userContract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userContract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userContract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userContract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userContract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userContract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userContract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userContract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userContract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userContract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userContract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserContractWrapper((UserContract)_userContract.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.UserContract userContract) {
		return _userContract.compareTo(userContract);
	}

	@Override
	public int hashCode() {
		return _userContract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.UserContract> toCacheModel() {
		return _userContract.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.UserContract toEscapedModel() {
		return new UserContractWrapper(_userContract.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.UserContract toUnescapedModel() {
		return new UserContractWrapper(_userContract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userContract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userContract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userContract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserContractWrapper)) {
			return false;
		}

		UserContractWrapper userContractWrapper = (UserContractWrapper)obj;

		if (Validator.equals(_userContract, userContractWrapper._userContract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserContract getWrappedUserContract() {
		return _userContract;
	}

	@Override
	public UserContract getWrappedModel() {
		return _userContract;
	}

	@Override
	public void resetOriginalValues() {
		_userContract.resetOriginalValues();
	}

	private UserContract _userContract;
}