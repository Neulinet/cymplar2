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
 * This class is a wrapper for {@link Industry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Industry
 * @generated
 */
public class IndustryWrapper implements Industry, ModelWrapper<Industry> {
	public IndustryWrapper(Industry industry) {
		_industry = industry;
	}

	@Override
	public Class<?> getModelClass() {
		return Industry.class;
	}

	@Override
	public String getModelClassName() {
		return Industry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("industryId", getIndustryId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long industryId = (Long)attributes.get("industryId");

		if (industryId != null) {
			setIndustryId(industryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this industry.
	*
	* @return the primary key of this industry
	*/
	@Override
	public long getPrimaryKey() {
		return _industry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this industry.
	*
	* @param primaryKey the primary key of this industry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_industry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the industry ID of this industry.
	*
	* @return the industry ID of this industry
	*/
	@Override
	public long getIndustryId() {
		return _industry.getIndustryId();
	}

	/**
	* Sets the industry ID of this industry.
	*
	* @param industryId the industry ID of this industry
	*/
	@Override
	public void setIndustryId(long industryId) {
		_industry.setIndustryId(industryId);
	}

	/**
	* Returns the group ID of this industry.
	*
	* @return the group ID of this industry
	*/
	@Override
	public long getGroupId() {
		return _industry.getGroupId();
	}

	/**
	* Sets the group ID of this industry.
	*
	* @param groupId the group ID of this industry
	*/
	@Override
	public void setGroupId(long groupId) {
		_industry.setGroupId(groupId);
	}

	/**
	* Returns the name of this industry.
	*
	* @return the name of this industry
	*/
	@Override
	public java.lang.String getName() {
		return _industry.getName();
	}

	/**
	* Sets the name of this industry.
	*
	* @param name the name of this industry
	*/
	@Override
	public void setName(java.lang.String name) {
		_industry.setName(name);
	}

	@Override
	public boolean isNew() {
		return _industry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_industry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _industry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_industry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _industry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _industry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_industry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _industry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_industry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_industry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_industry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IndustryWrapper((Industry)_industry.clone());
	}

	@Override
	public int compareTo(com.leancrm.portlet.library.model.Industry industry) {
		return _industry.compareTo(industry);
	}

	@Override
	public int hashCode() {
		return _industry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.Industry> toCacheModel() {
		return _industry.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.Industry toEscapedModel() {
		return new IndustryWrapper(_industry.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.Industry toUnescapedModel() {
		return new IndustryWrapper(_industry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _industry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _industry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_industry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IndustryWrapper)) {
			return false;
		}

		IndustryWrapper industryWrapper = (IndustryWrapper)obj;

		if (Validator.equals(_industry, industryWrapper._industry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Industry getWrappedIndustry() {
		return _industry;
	}

	@Override
	public Industry getWrappedModel() {
		return _industry;
	}

	@Override
	public void resetOriginalValues() {
		_industry.resetOriginalValues();
	}

	private Industry _industry;
}