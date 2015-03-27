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

package com.leancrm.portlet.library.service.persistence;

import com.leancrm.portlet.library.model.Report;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportPersistenceImpl
 * @see ReportUtil
 * @generated
 */
public interface ReportPersistence extends BasePersistence<Report> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportUtil} to access the report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the reports where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @return the range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the reports where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the reports before and after the current report in the ordered set where userId = &#63;.
	*
	* @param reportId the primary key of the current report
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report[] findByUser_PrevAndNext(
		long reportId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reports where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @return the matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContactOrganization(
		long enterpriseId, long contactId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @return the range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContactOrganization(
		long enterpriseId, long contactId, long organizationId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContactOrganization(
		long enterpriseId, long contactId, long organizationId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByContactOrganization_First(
		long enterpriseId, long contactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByContactOrganization_First(
		long enterpriseId, long contactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByContactOrganization_Last(
		long enterpriseId, long contactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByContactOrganization_Last(
		long enterpriseId, long contactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the reports before and after the current report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param reportId the primary key of the current report
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report[] findByContactOrganization_PrevAndNext(
		long reportId, long enterpriseId, long contactId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63; from the database.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactOrganization(long enterpriseId, long contactId,
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param organizationId the organization ID
	* @return the number of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactOrganization(long enterpriseId, long contactId,
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reports where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContract(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the reports where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @return the range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContract(
		long contractId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the reports where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findByContract(
		long contractId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the reports before and after the current report in the ordered set where contractId = &#63;.
	*
	* @param reportId the primary key of the current report
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report[] findByContract_PrevAndNext(
		long reportId, long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reports where contractId = &#63; from the database.
	*
	* @param contractId the contract ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the number of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the report in the entity cache if it is enabled.
	*
	* @param report the report
	*/
	public void cacheResult(com.leancrm.portlet.library.model.Report report);

	/**
	* Caches the reports in the entity cache if it is enabled.
	*
	* @param reports the reports
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Report> reports);

	/**
	* Creates a new report with the primary key. Does not add the report to the database.
	*
	* @param reportId the primary key for the new report
	* @return the new report
	*/
	public com.leancrm.portlet.library.model.Report create(long reportId);

	/**
	* Removes the report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the report
	* @return the report that was removed
	* @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report remove(long reportId)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.Report updateImpl(
		com.leancrm.portlet.library.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchReportException} if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report
	* @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report findByPrimaryKey(
		long reportId)
		throws com.leancrm.portlet.library.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report, or <code>null</code> if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Report fetchByPrimaryKey(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reports.
	*
	* @return the reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Report> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Report> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports.
	*
	* @return the number of reports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}