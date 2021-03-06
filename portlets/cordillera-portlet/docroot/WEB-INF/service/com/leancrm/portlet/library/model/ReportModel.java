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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Report service. Represents a row in the &quot;crm_Report&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.leancrm.portlet.library.model.impl.ReportModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.leancrm.portlet.library.model.impl.ReportImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Report
 * @see com.leancrm.portlet.library.model.impl.ReportImpl
 * @see com.leancrm.portlet.library.model.impl.ReportModelImpl
 * @generated
 */
public interface ReportModel extends BaseModel<Report> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a report model instance should use the {@link Report} interface instead.
	 */

	/**
	 * Returns the primary key of this report.
	 *
	 * @return the primary key of this report
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this report.
	 *
	 * @param primaryKey the primary key of this report
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the report ID of this report.
	 *
	 * @return the report ID of this report
	 */
	public long getReportId();

	/**
	 * Sets the report ID of this report.
	 *
	 * @param reportId the report ID of this report
	 */
	public void setReportId(long reportId);

	/**
	 * Returns the group ID of this report.
	 *
	 * @return the group ID of this report
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this report.
	 *
	 * @param groupId the group ID of this report
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this report.
	 *
	 * @return the company ID of this report
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this report.
	 *
	 * @param companyId the company ID of this report
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this report.
	 *
	 * @return the create date of this report
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this report.
	 *
	 * @param createDate the create date of this report
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the user ID of this report.
	 *
	 * @return the user ID of this report
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this report.
	 *
	 * @param userId the user ID of this report
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this report.
	 *
	 * @return the user uuid of this report
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this report.
	 *
	 * @param userUuid the user uuid of this report
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the organization ID of this report.
	 *
	 * @return the organization ID of this report
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this report.
	 *
	 * @param organizationId the organization ID of this report
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the enterprise ID of this report.
	 *
	 * @return the enterprise ID of this report
	 */
	public long getEnterpriseId();

	/**
	 * Sets the enterprise ID of this report.
	 *
	 * @param enterpriseId the enterprise ID of this report
	 */
	public void setEnterpriseId(long enterpriseId);

	/**
	 * Returns the contact ID of this report.
	 *
	 * @return the contact ID of this report
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this report.
	 *
	 * @param contactId the contact ID of this report
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the contact data ID of this report.
	 *
	 * @return the contact data ID of this report
	 */
	public long getContactDataId();

	/**
	 * Sets the contact data ID of this report.
	 *
	 * @param contactDataId the contact data ID of this report
	 */
	public void setContactDataId(long contactDataId);

	/**
	 * Returns the contact method ID of this report.
	 *
	 * @return the contact method ID of this report
	 */
	public long getContactMethodId();

	/**
	 * Sets the contact method ID of this report.
	 *
	 * @param contactMethodId the contact method ID of this report
	 */
	public void setContactMethodId(long contactMethodId);

	/**
	 * Returns the report date of this report.
	 *
	 * @return the report date of this report
	 */
	public Date getReportDate();

	/**
	 * Sets the report date of this report.
	 *
	 * @param reportDate the report date of this report
	 */
	public void setReportDate(Date reportDate);

	/**
	 * Returns the comments of this report.
	 *
	 * @return the comments of this report
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this report.
	 *
	 * @param comments the comments of this report
	 */
	public void setComments(String comments);

	/**
	 * Returns the progress of this report.
	 *
	 * @return the progress of this report
	 */
	public double getProgress();

	/**
	 * Sets the progress of this report.
	 *
	 * @param progress the progress of this report
	 */
	public void setProgress(double progress);

	/**
	 * Returns the status of this report.
	 *
	 * @return the status of this report
	 */
	public int getStatus();

	/**
	 * Sets the status of this report.
	 *
	 * @param status the status of this report
	 */
	public void setStatus(int status);

	/**
	 * Returns the contract ID of this report.
	 *
	 * @return the contract ID of this report
	 */
	public long getContractId();

	/**
	 * Sets the contract ID of this report.
	 *
	 * @param contractId the contract ID of this report
	 */
	public void setContractId(long contractId);

	/**
	 * Returns the cd name ID of this report.
	 *
	 * @return the cd name ID of this report
	 */
	public long getCdNameId();

	/**
	 * Sets the cd name ID of this report.
	 *
	 * @param cdNameId the cd name ID of this report
	 */
	public void setCdNameId(long cdNameId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Report report);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Report> toCacheModel();

	@Override
	public Report toEscapedModel();

	@Override
	public Report toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}