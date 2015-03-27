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
 * This class is a wrapper for {@link MyAddressBookContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyAddressBookContact
 * @generated
 */
public class MyAddressBookContactWrapper implements MyAddressBookContact,
	ModelWrapper<MyAddressBookContact> {
	public MyAddressBookContactWrapper(
		MyAddressBookContact myAddressBookContact) {
		_myAddressBookContact = myAddressBookContact;
	}

	@Override
	public Class<?> getModelClass() {
		return MyAddressBookContact.class;
	}

	@Override
	public String getModelClassName() {
		return MyAddressBookContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("methodId", getMethodId());
		attributes.put("contactName", getContactName());
		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("enterpriseName", getEnterpriseName());
		attributes.put("contractId", getContractId());
		attributes.put("reportId", getReportId());
		attributes.put("status", getStatus());
		attributes.put("progress", getProgress());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long methodId = (Long)attributes.get("methodId");

		if (methodId != null) {
			setMethodId(methodId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		String enterpriseName = (String)attributes.get("enterpriseName");

		if (enterpriseName != null) {
			setEnterpriseName(enterpriseName);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double progress = (Double)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this my address book contact.
	*
	* @return the primary key of this my address book contact
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK getPrimaryKey() {
		return _myAddressBookContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this my address book contact.
	*
	* @param primaryKey the primary key of this my address book contact
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK primaryKey) {
		_myAddressBookContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this my address book contact.
	*
	* @return the contact ID of this my address book contact
	*/
	@Override
	public long getContactId() {
		return _myAddressBookContact.getContactId();
	}

	/**
	* Sets the contact ID of this my address book contact.
	*
	* @param contactId the contact ID of this my address book contact
	*/
	@Override
	public void setContactId(long contactId) {
		_myAddressBookContact.setContactId(contactId);
	}

	/**
	* Returns the method ID of this my address book contact.
	*
	* @return the method ID of this my address book contact
	*/
	@Override
	public long getMethodId() {
		return _myAddressBookContact.getMethodId();
	}

	/**
	* Sets the method ID of this my address book contact.
	*
	* @param methodId the method ID of this my address book contact
	*/
	@Override
	public void setMethodId(long methodId) {
		_myAddressBookContact.setMethodId(methodId);
	}

	/**
	* Returns the contact name of this my address book contact.
	*
	* @return the contact name of this my address book contact
	*/
	@Override
	public java.lang.String getContactName() {
		return _myAddressBookContact.getContactName();
	}

	/**
	* Sets the contact name of this my address book contact.
	*
	* @param contactName the contact name of this my address book contact
	*/
	@Override
	public void setContactName(java.lang.String contactName) {
		_myAddressBookContact.setContactName(contactName);
	}

	/**
	* Returns the enterprise ID of this my address book contact.
	*
	* @return the enterprise ID of this my address book contact
	*/
	@Override
	public long getEnterpriseId() {
		return _myAddressBookContact.getEnterpriseId();
	}

	/**
	* Sets the enterprise ID of this my address book contact.
	*
	* @param enterpriseId the enterprise ID of this my address book contact
	*/
	@Override
	public void setEnterpriseId(long enterpriseId) {
		_myAddressBookContact.setEnterpriseId(enterpriseId);
	}

	/**
	* Returns the enterprise name of this my address book contact.
	*
	* @return the enterprise name of this my address book contact
	*/
	@Override
	public java.lang.String getEnterpriseName() {
		return _myAddressBookContact.getEnterpriseName();
	}

	/**
	* Sets the enterprise name of this my address book contact.
	*
	* @param enterpriseName the enterprise name of this my address book contact
	*/
	@Override
	public void setEnterpriseName(java.lang.String enterpriseName) {
		_myAddressBookContact.setEnterpriseName(enterpriseName);
	}

	/**
	* Returns the contract ID of this my address book contact.
	*
	* @return the contract ID of this my address book contact
	*/
	@Override
	public long getContractId() {
		return _myAddressBookContact.getContractId();
	}

	/**
	* Sets the contract ID of this my address book contact.
	*
	* @param contractId the contract ID of this my address book contact
	*/
	@Override
	public void setContractId(long contractId) {
		_myAddressBookContact.setContractId(contractId);
	}

	/**
	* Returns the report ID of this my address book contact.
	*
	* @return the report ID of this my address book contact
	*/
	@Override
	public long getReportId() {
		return _myAddressBookContact.getReportId();
	}

	/**
	* Sets the report ID of this my address book contact.
	*
	* @param reportId the report ID of this my address book contact
	*/
	@Override
	public void setReportId(long reportId) {
		_myAddressBookContact.setReportId(reportId);
	}

	/**
	* Returns the status of this my address book contact.
	*
	* @return the status of this my address book contact
	*/
	@Override
	public int getStatus() {
		return _myAddressBookContact.getStatus();
	}

	/**
	* Sets the status of this my address book contact.
	*
	* @param status the status of this my address book contact
	*/
	@Override
	public void setStatus(int status) {
		_myAddressBookContact.setStatus(status);
	}

	/**
	* Returns the progress of this my address book contact.
	*
	* @return the progress of this my address book contact
	*/
	@Override
	public double getProgress() {
		return _myAddressBookContact.getProgress();
	}

	/**
	* Sets the progress of this my address book contact.
	*
	* @param progress the progress of this my address book contact
	*/
	@Override
	public void setProgress(double progress) {
		_myAddressBookContact.setProgress(progress);
	}

	/**
	* Returns the description of this my address book contact.
	*
	* @return the description of this my address book contact
	*/
	@Override
	public java.lang.String getDescription() {
		return _myAddressBookContact.getDescription();
	}

	/**
	* Sets the description of this my address book contact.
	*
	* @param description the description of this my address book contact
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_myAddressBookContact.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _myAddressBookContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_myAddressBookContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _myAddressBookContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_myAddressBookContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _myAddressBookContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _myAddressBookContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_myAddressBookContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myAddressBookContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_myAddressBookContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_myAddressBookContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myAddressBookContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MyAddressBookContactWrapper((MyAddressBookContact)_myAddressBookContact.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.MyAddressBookContact myAddressBookContact) {
		return _myAddressBookContact.compareTo(myAddressBookContact);
	}

	@Override
	public int hashCode() {
		return _myAddressBookContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.MyAddressBookContact> toCacheModel() {
		return _myAddressBookContact.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.MyAddressBookContact toEscapedModel() {
		return new MyAddressBookContactWrapper(_myAddressBookContact.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.MyAddressBookContact toUnescapedModel() {
		return new MyAddressBookContactWrapper(_myAddressBookContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _myAddressBookContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _myAddressBookContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_myAddressBookContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyAddressBookContactWrapper)) {
			return false;
		}

		MyAddressBookContactWrapper myAddressBookContactWrapper = (MyAddressBookContactWrapper)obj;

		if (Validator.equals(_myAddressBookContact,
					myAddressBookContactWrapper._myAddressBookContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MyAddressBookContact getWrappedMyAddressBookContact() {
		return _myAddressBookContact;
	}

	@Override
	public MyAddressBookContact getWrappedModel() {
		return _myAddressBookContact;
	}

	@Override
	public void resetOriginalValues() {
		_myAddressBookContact.resetOriginalValues();
	}

	private MyAddressBookContact _myAddressBookContact;
}