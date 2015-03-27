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
 * This class is a wrapper for {@link Report}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Report
 * @generated
 */
public class ReportWrapper implements Report, ModelWrapper<Report> {
	public ReportWrapper(Report report) {
		_report = report;
	}

	@Override
	public Class<?> getModelClass() {
		return Report.class;
	}

	@Override
	public String getModelClassName() {
		return Report.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("enterpriseId", getEnterpriseId());
		attributes.put("contactId", getContactId());
		attributes.put("contactDataId", getContactDataId());
		attributes.put("contactMethodId", getContactMethodId());
		attributes.put("reportDate", getReportDate());
		attributes.put("comments", getComments());
		attributes.put("progress", getProgress());
		attributes.put("status", getStatus());
		attributes.put("contractId", getContractId());
		attributes.put("cdNameId", getCdNameId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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

		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		Long contactMethodId = (Long)attributes.get("contactMethodId");

		if (contactMethodId != null) {
			setContactMethodId(contactMethodId);
		}

		Date reportDate = (Date)attributes.get("reportDate");

		if (reportDate != null) {
			setReportDate(reportDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Double progress = (Double)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long contractId = (Long)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		Long cdNameId = (Long)attributes.get("cdNameId");

		if (cdNameId != null) {
			setCdNameId(cdNameId);
		}
	}

	/**
	* Returns the primary key of this report.
	*
	* @return the primary key of this report
	*/
	@Override
	public long getPrimaryKey() {
		return _report.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report.
	*
	* @param primaryKey the primary key of this report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_report.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report ID of this report.
	*
	* @return the report ID of this report
	*/
	@Override
	public long getReportId() {
		return _report.getReportId();
	}

	/**
	* Sets the report ID of this report.
	*
	* @param reportId the report ID of this report
	*/
	@Override
	public void setReportId(long reportId) {
		_report.setReportId(reportId);
	}

	/**
	* Returns the group ID of this report.
	*
	* @return the group ID of this report
	*/
	@Override
	public long getGroupId() {
		return _report.getGroupId();
	}

	/**
	* Sets the group ID of this report.
	*
	* @param groupId the group ID of this report
	*/
	@Override
	public void setGroupId(long groupId) {
		_report.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this report.
	*
	* @return the company ID of this report
	*/
	@Override
	public long getCompanyId() {
		return _report.getCompanyId();
	}

	/**
	* Sets the company ID of this report.
	*
	* @param companyId the company ID of this report
	*/
	@Override
	public void setCompanyId(long companyId) {
		_report.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this report.
	*
	* @return the create date of this report
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _report.getCreateDate();
	}

	/**
	* Sets the create date of this report.
	*
	* @param createDate the create date of this report
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_report.setCreateDate(createDate);
	}

	/**
	* Returns the user ID of this report.
	*
	* @return the user ID of this report
	*/
	@Override
	public long getUserId() {
		return _report.getUserId();
	}

	/**
	* Sets the user ID of this report.
	*
	* @param userId the user ID of this report
	*/
	@Override
	public void setUserId(long userId) {
		_report.setUserId(userId);
	}

	/**
	* Returns the user uuid of this report.
	*
	* @return the user uuid of this report
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _report.getUserUuid();
	}

	/**
	* Sets the user uuid of this report.
	*
	* @param userUuid the user uuid of this report
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_report.setUserUuid(userUuid);
	}

	/**
	* Returns the organization ID of this report.
	*
	* @return the organization ID of this report
	*/
	@Override
	public long getOrganizationId() {
		return _report.getOrganizationId();
	}

	/**
	* Sets the organization ID of this report.
	*
	* @param organizationId the organization ID of this report
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_report.setOrganizationId(organizationId);
	}

	/**
	* Returns the enterprise ID of this report.
	*
	* @return the enterprise ID of this report
	*/
	@Override
	public long getEnterpriseId() {
		return _report.getEnterpriseId();
	}

	/**
	* Sets the enterprise ID of this report.
	*
	* @param enterpriseId the enterprise ID of this report
	*/
	@Override
	public void setEnterpriseId(long enterpriseId) {
		_report.setEnterpriseId(enterpriseId);
	}

	/**
	* Returns the contact ID of this report.
	*
	* @return the contact ID of this report
	*/
	@Override
	public long getContactId() {
		return _report.getContactId();
	}

	/**
	* Sets the contact ID of this report.
	*
	* @param contactId the contact ID of this report
	*/
	@Override
	public void setContactId(long contactId) {
		_report.setContactId(contactId);
	}

	/**
	* Returns the contact data ID of this report.
	*
	* @return the contact data ID of this report
	*/
	@Override
	public long getContactDataId() {
		return _report.getContactDataId();
	}

	/**
	* Sets the contact data ID of this report.
	*
	* @param contactDataId the contact data ID of this report
	*/
	@Override
	public void setContactDataId(long contactDataId) {
		_report.setContactDataId(contactDataId);
	}

	/**
	* Returns the contact method ID of this report.
	*
	* @return the contact method ID of this report
	*/
	@Override
	public long getContactMethodId() {
		return _report.getContactMethodId();
	}

	/**
	* Sets the contact method ID of this report.
	*
	* @param contactMethodId the contact method ID of this report
	*/
	@Override
	public void setContactMethodId(long contactMethodId) {
		_report.setContactMethodId(contactMethodId);
	}

	/**
	* Returns the report date of this report.
	*
	* @return the report date of this report
	*/
	@Override
	public java.util.Date getReportDate() {
		return _report.getReportDate();
	}

	/**
	* Sets the report date of this report.
	*
	* @param reportDate the report date of this report
	*/
	@Override
	public void setReportDate(java.util.Date reportDate) {
		_report.setReportDate(reportDate);
	}

	/**
	* Returns the comments of this report.
	*
	* @return the comments of this report
	*/
	@Override
	public java.lang.String getComments() {
		return _report.getComments();
	}

	/**
	* Sets the comments of this report.
	*
	* @param comments the comments of this report
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_report.setComments(comments);
	}

	/**
	* Returns the progress of this report.
	*
	* @return the progress of this report
	*/
	@Override
	public double getProgress() {
		return _report.getProgress();
	}

	/**
	* Sets the progress of this report.
	*
	* @param progress the progress of this report
	*/
	@Override
	public void setProgress(double progress) {
		_report.setProgress(progress);
	}

	/**
	* Returns the status of this report.
	*
	* @return the status of this report
	*/
	@Override
	public int getStatus() {
		return _report.getStatus();
	}

	/**
	* Sets the status of this report.
	*
	* @param status the status of this report
	*/
	@Override
	public void setStatus(int status) {
		_report.setStatus(status);
	}

	/**
	* Returns the contract ID of this report.
	*
	* @return the contract ID of this report
	*/
	@Override
	public long getContractId() {
		return _report.getContractId();
	}

	/**
	* Sets the contract ID of this report.
	*
	* @param contractId the contract ID of this report
	*/
	@Override
	public void setContractId(long contractId) {
		_report.setContractId(contractId);
	}

	/**
	* Returns the cd name ID of this report.
	*
	* @return the cd name ID of this report
	*/
	@Override
	public long getCdNameId() {
		return _report.getCdNameId();
	}

	/**
	* Sets the cd name ID of this report.
	*
	* @param cdNameId the cd name ID of this report
	*/
	@Override
	public void setCdNameId(long cdNameId) {
		_report.setCdNameId(cdNameId);
	}

	@Override
	public boolean isNew() {
		return _report.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_report.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _report.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_report.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _report.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _report.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_report.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _report.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_report.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_report.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_report.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportWrapper((Report)_report.clone());
	}

	@Override
	public int compareTo(com.leancrm.portlet.library.model.Report report) {
		return _report.compareTo(report);
	}

	@Override
	public int hashCode() {
		return _report.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.leancrm.portlet.library.model.Report> toCacheModel() {
		return _report.toCacheModel();
	}

	@Override
	public com.leancrm.portlet.library.model.Report toEscapedModel() {
		return new ReportWrapper(_report.toEscapedModel());
	}

	@Override
	public com.leancrm.portlet.library.model.Report toUnescapedModel() {
		return new ReportWrapper(_report.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _report.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _report.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_report.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportWrapper)) {
			return false;
		}

		ReportWrapper reportWrapper = (ReportWrapper)obj;

		if (Validator.equals(_report, reportWrapper._report)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Report getWrappedReport() {
		return _report;
	}

	@Override
	public Report getWrappedModel() {
		return _report;
	}

	@Override
	public void resetOriginalValues() {
		_report.resetOriginalValues();
	}

	private Report _report;
}