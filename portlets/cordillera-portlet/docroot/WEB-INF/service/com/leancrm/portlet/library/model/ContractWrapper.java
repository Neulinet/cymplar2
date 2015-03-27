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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contract}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contract
 * @generated
 */
public class ContractWrapper implements Contract, ModelWrapper<Contract> {
	public ContractWrapper(Contract contract) {
		_contract = contract;
	}

	@Override
	public Class<?> getModelClass() {
		return Contract.class;
	}

	@Override
	public String getModelClassName() {
		return Contract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contractId", getContractId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("contactId", getContactId());
		attributes.put("description", getDescription());
		attributes.put("amount", getAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}
	}

	/**
	* Returns the primary key of this contract.
	*
	* @return the primary key of this contract
	*/
	@Override
	public long getPrimaryKey() {
		return _contract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contract.
	*
	* @param primaryKey the primary key of this contract
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contract ID of this contract.
	*
	* @return the contract ID of this contract
	*/
	@Override
	public long getContractId() {
		return _contract.getContractId();
	}

	/**
	* Sets the contract ID of this contract.
	*
	* @param contractId the contract ID of this contract
	*/
	@Override
	public void setContractId(long contractId) {
		_contract.setContractId(contractId);
	}

	/**
	* Returns the group ID of this contract.
	*
	* @return the group ID of this contract
	*/
	@Override
	public long getGroupId() {
		return _contract.getGroupId();
	}

	/**
	* Sets the group ID of this contract.
	*
	* @param groupId the group ID of this contract
	*/
	@Override
	public void setGroupId(long groupId) {
		_contract.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contract.
	*
	* @return the company ID of this contract
	*/
	@Override
	public long getCompanyId() {
		return _contract.getCompanyId();
	}

	/**
	* Sets the company ID of this contract.
	*
	* @param companyId the company ID of this contract
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contract.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this contract.
	*
	* @return the create date of this contract
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contract.getCreateDate();
	}

	/**
	* Sets the create date of this contract.
	*
	* @param createDate the create date of this contract
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contract.setCreateDate(createDate);
	}

	/**
	* Returns the organization ID of this contract.
	*
	* @return the organization ID of this contract
	*/
	@Override
	public long getOrganizationId() {
		return _contract.getOrganizationId();
	}

	/**
	* Sets the organization ID of this contract.
	*
	* @param organizationId the organization ID of this contract
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_contract.setOrganizationId(organizationId);
	}

	/**
	* Returns the enterprise ID of this contract.
	*
	* @return the enterprise ID of this contract
	*/
	@Override
	public long getEnterpriseId() {
		return _contract.getEnterpriseId();
	}

	/**
	* Sets the enterprise ID of this contract.
	*
	* @param enterpriseId the enterprise ID of this contract
	*/
	@Override
	public void setEnterpriseId(long enterpriseId) {
		_contract.setEnterpriseId(enterpriseId);
	}

	/**
	* Returns the contact ID of this contract.
	*
	* @return the contact ID of this contract
	*/
	@Override
	public long getContactId() {
		return _contract.getContactId();
	}

	/**
	* Sets the contact ID of this contract.
	*
	* @param contactId the contact ID of this contract
	*/
	@Override
	public void setContactId(long contactId) {
		_contract.setContactId(contactId);
	}

	/**
	* Returns the description of this contract.
	*
	* @return the description of this contract
	*/
	@Override
	public java.lang.String getDescription() {
		return _contract.getDescription();
	}

	/**
	* Sets the description of this contract.
	*
	* @param description the description of this contract
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_contract.setDescription(description);
	}

	/**
	* Returns the amount of this contract.
	*
	* @return the amount of this contract
	*/
	@Override
	public double getAmount() {
		return _contract.getAmount();
	}

	/**
	* Sets the amount of this contract.
	*
	* @param amount the amount of this contract
	*/
	@Override
	public void setAmount(double amount) {
		_contract.setAmount(amount);
	}

	@Override
	public boolean isNew() {
		return _contract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContractWrapper((Contract)_contract.clone());
	}

	@Override
	public int compareTo(com.leancrm.portlet.library.model.Contract contract) {
		return _contract.compareTo(contract);
	}

	@Override
	public int hashCode() {
		return _contract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.Contract> toCacheModel() {
		return _contract.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.Contract toEscapedModel() {
		return new ContractWrapper(_contract.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.Contract toUnescapedModel() {
		return new ContractWrapper(_contract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContractWrapper)) {
			return false;
		}

		ContractWrapper contractWrapper = (ContractWrapper)obj;

		if (Validator.equals(_contract, contractWrapper._contract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contract getWrappedContract() {
		return _contract;
	}

	@Override
	public Contract getWrappedModel() {
		return _contract;
	}

	@Override
	public void resetOriginalValues() {
		_contract.resetOriginalValues();
	}

	private Contract _contract;
}