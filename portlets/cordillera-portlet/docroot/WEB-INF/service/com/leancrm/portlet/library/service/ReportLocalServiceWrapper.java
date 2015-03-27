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

package com.leancrm.portlet.library.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportLocalService
 * @generated
 */
public class ReportLocalServiceWrapper implements ReportLocalService,
	ServiceWrapper<ReportLocalService> {
	public ReportLocalServiceWrapper(ReportLocalService reportLocalService) {
		_reportLocalService = reportLocalService;
	}

	/**
	* Adds the report to the database. Also notifies the appropriate model listeners.
	*
	* @param report the report
	* @return the report that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Report addReport(
		com.leancrm.portlet.library.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.addReport(report);
	}

	/**
	* Creates a new report with the primary key. Does not add the report to the database.
	*
	* @param reportId the primary key for the new report
	* @return the new report
	*/
	@Override
	public com.leancrm.portlet.library.model.Report createReport(long reportId) {
		return _reportLocalService.createReport(reportId);
	}

	/**
	* Deletes the report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the report
	* @return the report that was removed
	* @throws PortalException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Report deleteReport(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.deleteReport(reportId);
	}

	/**
	* Deletes the report from the database. Also notifies the appropriate model listeners.
	*
	* @param report the report
	* @return the report that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Report deleteReport(
		com.leancrm.portlet.library.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.deleteReport(report);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _reportLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.leancrm.portlet.library.model.Report fetchReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.fetchReport(reportId);
	}

	/**
	* Returns the report with the primary key.
	*
	* @param reportId the primary key of the report
	* @return the report
	* @throws PortalException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Report getReport(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getReport(reportId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @return the range of reports
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.Report> getReports(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getReports(start, end);
	}

	/**
	* Returns the number of reports.
	*
	* @return the number of reports
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getReportsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getReportsCount();
	}

	/**
	* Updates the report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param report the report
	* @return the report that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Report updateReport(
		com.leancrm.portlet.library.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.updateReport(report);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _reportLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reportLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _reportLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.Report addReport(long companyId,
		long contractId, long contactId, java.lang.String comments,
		long contactDataId, long enterpriseId, long organizationId,
		double progress, java.util.Date reportDate, int status, long userId,
		long cdNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.addReport(companyId, contractId, contactId,
			comments, contactDataId, enterpriseId, organizationId, progress,
			reportDate, status, userId, cdNameId);
	}

	@Override
	public com.leancrm.portlet.library.model.Report addReport(long companyId,
		long contractId, long contactId, java.lang.String comments,
		long contactDataId, long enterpriseId, long organizationId,
		double progress, java.util.Date reportDate, int status, long userId,
		long cdNameId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.addReport(companyId, contractId, contactId,
			comments, contactDataId, enterpriseId, organizationId, progress,
			reportDate, status, userId, cdNameId, createDate);
	}

	/**
	* Update the user of reports
	*
	* @param userId
	* @throws SystemException
	*/
	@Override
	public void updateUserOfReports(long oUserId, long nUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportLocalService.updateUserOfReports(oUserId, nUserId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Report> getReport(
		long contactId, long enterpriseId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getReport(contactId, enterpriseId,
			organizationId);
	}

	@Override
	public com.leancrm.portlet.library.model.Report getLastReport(
		long contactId, long enterpriseId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getLastReport(contactId, enterpriseId,
			organizationId);
	}

	@Override
	public com.leancrm.portlet.library.model.Report getLastReport(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getLastReport(contractId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Report> getReportByContract(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.getReportByContract(contractId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Report> searchReports(
		int order, java.lang.Long userId, java.lang.Long enterpriseId,
		java.lang.Long contactId, java.lang.Long organizationId,
		java.lang.Long contractId, java.lang.Double fromProgress,
		java.lang.Double toProgress, java.lang.Integer[] statusCodeList,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportLocalService.searchReports(order, userId, enterpriseId,
			contactId, organizationId, contractId, fromProgress, toProgress,
			statusCodeList, fromDate, toDate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ReportLocalService getWrappedReportLocalService() {
		return _reportLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedReportLocalService(
		ReportLocalService reportLocalService) {
		_reportLocalService = reportLocalService;
	}

	@Override
	public ReportLocalService getWrappedService() {
		return _reportLocalService;
	}

	@Override
	public void setWrappedService(ReportLocalService reportLocalService) {
		_reportLocalService = reportLocalService;
	}

	private ReportLocalService _reportLocalService;
}