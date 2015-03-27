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
 * This class is a wrapper for {@link Enterprise}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Enterprise
 * @generated
 */
public class EnterpriseWrapper implements Enterprise, ModelWrapper<Enterprise> {
	public EnterpriseWrapper(Enterprise enterprise) {
		_enterprise = enterprise;
	}

	@Override
	public Class<?> getModelClass() {
		return Enterprise.class;
	}

	@Override
	public String getModelClassName() {
		return Enterprise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("groupId", getGroupId());
		attributes.put("isPrivate", getIsPrivate());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("taxid", getTaxid());
		attributes.put("description", getDescription());
		attributes.put("industry", getIndustry());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long enterpriseId = (Long)attributes.get("enterpriseId");

		if (enterpriseId != null) {
			setEnterpriseId(enterpriseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer isPrivate = (Integer)attributes.get("isPrivate");

		if (isPrivate != null) {
			setIsPrivate(isPrivate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String taxid = (String)attributes.get("taxid");

		if (taxid != null) {
			setTaxid(taxid);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long industry = (Long)attributes.get("industry");

		if (industry != null) {
			setIndustry(industry);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	/**
	* Returns the primary key of this enterprise.
	*
	* @return the primary key of this enterprise
	*/
	@Override
	public long getPrimaryKey() {
		return _enterprise.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enterprise.
	*
	* @param primaryKey the primary key of this enterprise
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enterprise.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the enterprise ID of this enterprise.
	*
	* @return the enterprise ID of this enterprise
	*/
	@Override
	public long getEnterpriseId() {
		return _enterprise.getEnterpriseId();
	}

	/**
	* Sets the enterprise ID of this enterprise.
	*
	* @param enterpriseId the enterprise ID of this enterprise
	*/
	@Override
	public void setEnterpriseId(long enterpriseId) {
		_enterprise.setEnterpriseId(enterpriseId);
	}

	/**
	* Returns the group ID of this enterprise.
	*
	* @return the group ID of this enterprise
	*/
	@Override
	public long getGroupId() {
		return _enterprise.getGroupId();
	}

	/**
	* Sets the group ID of this enterprise.
	*
	* @param groupId the group ID of this enterprise
	*/
	@Override
	public void setGroupId(long groupId) {
		_enterprise.setGroupId(groupId);
	}

	/**
	* Returns the is private of this enterprise.
	*
	* @return the is private of this enterprise
	*/
	@Override
	public int getIsPrivate() {
		return _enterprise.getIsPrivate();
	}

	/**
	* Sets the is private of this enterprise.
	*
	* @param isPrivate the is private of this enterprise
	*/
	@Override
	public void setIsPrivate(int isPrivate) {
		_enterprise.setIsPrivate(isPrivate);
	}

	/**
	* Returns the company ID of this enterprise.
	*
	* @return the company ID of this enterprise
	*/
	@Override
	public long getCompanyId() {
		return _enterprise.getCompanyId();
	}

	/**
	* Sets the company ID of this enterprise.
	*
	* @param companyId the company ID of this enterprise
	*/
	@Override
	public void setCompanyId(long companyId) {
		_enterprise.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this enterprise.
	*
	* @return the create date of this enterprise
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _enterprise.getCreateDate();
	}

	/**
	* Sets the create date of this enterprise.
	*
	* @param createDate the create date of this enterprise
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_enterprise.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this enterprise.
	*
	* @return the modified date of this enterprise
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _enterprise.getModifiedDate();
	}

	/**
	* Sets the modified date of this enterprise.
	*
	* @param modifiedDate the modified date of this enterprise
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_enterprise.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this enterprise.
	*
	* @return the name of this enterprise
	*/
	@Override
	public java.lang.String getName() {
		return _enterprise.getName();
	}

	/**
	* Sets the name of this enterprise.
	*
	* @param name the name of this enterprise
	*/
	@Override
	public void setName(java.lang.String name) {
		_enterprise.setName(name);
	}

	/**
	* Returns the taxid of this enterprise.
	*
	* @return the taxid of this enterprise
	*/
	@Override
	public java.lang.String getTaxid() {
		return _enterprise.getTaxid();
	}

	/**
	* Sets the taxid of this enterprise.
	*
	* @param taxid the taxid of this enterprise
	*/
	@Override
	public void setTaxid(java.lang.String taxid) {
		_enterprise.setTaxid(taxid);
	}

	/**
	* Returns the description of this enterprise.
	*
	* @return the description of this enterprise
	*/
	@Override
	public java.lang.String getDescription() {
		return _enterprise.getDescription();
	}

	/**
	* Sets the description of this enterprise.
	*
	* @param description the description of this enterprise
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_enterprise.setDescription(description);
	}

	/**
	* Returns the industry of this enterprise.
	*
	* @return the industry of this enterprise
	*/
	@Override
	public long getIndustry() {
		return _enterprise.getIndustry();
	}

	/**
	* Sets the industry of this enterprise.
	*
	* @param industry the industry of this enterprise
	*/
	@Override
	public void setIndustry(long industry) {
		_enterprise.setIndustry(industry);
	}

	/**
	* Returns the email of this enterprise.
	*
	* @return the email of this enterprise
	*/
	@Override
	public java.lang.String getEmail() {
		return _enterprise.getEmail();
	}

	/**
	* Sets the email of this enterprise.
	*
	* @param email the email of this enterprise
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_enterprise.setEmail(email);
	}

	@Override
	public boolean isNew() {
		return _enterprise.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_enterprise.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _enterprise.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enterprise.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _enterprise.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _enterprise.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enterprise.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enterprise.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_enterprise.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_enterprise.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enterprise.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnterpriseWrapper((Enterprise)_enterprise.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.Enterprise enterprise) {
		return _enterprise.compareTo(enterprise);
	}

	@Override
	public int hashCode() {
		return _enterprise.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.Enterprise> toCacheModel() {
		return _enterprise.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.Enterprise toEscapedModel() {
		return new EnterpriseWrapper(_enterprise.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.Enterprise toUnescapedModel() {
		return new EnterpriseWrapper(_enterprise.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enterprise.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enterprise.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enterprise.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnterpriseWrapper)) {
			return false;
		}

		EnterpriseWrapper enterpriseWrapper = (EnterpriseWrapper)obj;

		if (Validator.equals(_enterprise, enterpriseWrapper._enterprise)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Enterprise getWrappedEnterprise() {
		return _enterprise;
	}

	@Override
	public Enterprise getWrappedModel() {
		return _enterprise;
	}

	@Override
	public void resetOriginalValues() {
		_enterprise.resetOriginalValues();
	}

	private Enterprise _enterprise;
}