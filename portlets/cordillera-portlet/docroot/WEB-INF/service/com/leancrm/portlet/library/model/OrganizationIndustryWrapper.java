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
 * This class is a wrapper for {@link OrganizationIndustry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationIndustry
 * @generated
 */
public class OrganizationIndustryWrapper implements OrganizationIndustry,
	ModelWrapper<OrganizationIndustry> {
	public OrganizationIndustryWrapper(
		OrganizationIndustry organizationIndustry) {
		_organizationIndustry = organizationIndustry;
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizationIndustry.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizationIndustry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationId", getOrganizationId());
		attributes.put("industryId", getIndustryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long industryId = (Long)attributes.get("industryId");

		if (industryId != null) {
			setIndustryId(industryId);
		}
	}

	/**
	* Returns the primary key of this organization industry.
	*
	* @return the primary key of this organization industry
	*/
	@Override
	public com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK getPrimaryKey() {
		return _organizationIndustry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization industry.
	*
	* @param primaryKey the primary key of this organization industry
	*/
	@Override
	public void setPrimaryKey(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK primaryKey) {
		_organizationIndustry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the organization ID of this organization industry.
	*
	* @return the organization ID of this organization industry
	*/
	@Override
	public long getOrganizationId() {
		return _organizationIndustry.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organization industry.
	*
	* @param organizationId the organization ID of this organization industry
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_organizationIndustry.setOrganizationId(organizationId);
	}

	/**
	* Returns the industry ID of this organization industry.
	*
	* @return the industry ID of this organization industry
	*/
	@Override
	public long getIndustryId() {
		return _organizationIndustry.getIndustryId();
	}

	/**
	* Sets the industry ID of this organization industry.
	*
	* @param industryId the industry ID of this organization industry
	*/
	@Override
	public void setIndustryId(long industryId) {
		_organizationIndustry.setIndustryId(industryId);
	}

	@Override
	public boolean isNew() {
		return _organizationIndustry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organizationIndustry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organizationIndustry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organizationIndustry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organizationIndustry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organizationIndustry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizationIndustry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizationIndustry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organizationIndustry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organizationIndustry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizationIndustry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationIndustryWrapper((OrganizationIndustry)_organizationIndustry.clone());
	}

	@Override
	public int compareTo(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry) {
		return _organizationIndustry.compareTo(organizationIndustry);
	}

	@Override
	public int hashCode() {
		return _organizationIndustry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.OrganizationIndustry> toCacheModel() {
		return _organizationIndustry.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry toEscapedModel() {
		return new OrganizationIndustryWrapper(_organizationIndustry.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry toUnescapedModel() {
		return new OrganizationIndustryWrapper(_organizationIndustry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizationIndustry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organizationIndustry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizationIndustry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationIndustryWrapper)) {
			return false;
		}

		OrganizationIndustryWrapper organizationIndustryWrapper = (OrganizationIndustryWrapper)obj;

		if (Validator.equals(_organizationIndustry,
					organizationIndustryWrapper._organizationIndustry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrganizationIndustry getWrappedOrganizationIndustry() {
		return _organizationIndustry;
	}

	@Override
	public OrganizationIndustry getWrappedModel() {
		return _organizationIndustry;
	}

	@Override
	public void resetOriginalValues() {
		_organizationIndustry.resetOriginalValues();
	}

	private OrganizationIndustry _organizationIndustry;
}