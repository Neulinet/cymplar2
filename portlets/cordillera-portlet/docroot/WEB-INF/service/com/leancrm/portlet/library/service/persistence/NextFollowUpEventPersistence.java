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

import com.leancrm.portlet.library.model.NextFollowUpEvent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the next follow up event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEventPersistenceImpl
 * @see NextFollowUpEventUtil
 * @generated
 */
public interface NextFollowUpEventPersistence extends BasePersistence<NextFollowUpEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NextFollowUpEventUtil} to access the next follow up event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the next follow up events where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByContract(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the next follow up events where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @return the range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByContract(
		long contractId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the next follow up events where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByContract(
		long contractId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the next follow up events before and after the current next follow up event in the ordered set where contractId = &#63;.
	*
	* @param eventId the primary key of the current next follow up event
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent[] findByContract_PrevAndNext(
		long eventId, long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the next follow up events where contractId = &#63; from the database.
	*
	* @param contractId the contract ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of next follow up events where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the number of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public int countByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the next follow up events where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the next follow up events where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @return the range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReport(
		long reportId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the next follow up events where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReport(
		long reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByReport_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByReport_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the next follow up events before and after the current next follow up event in the ordered set where reportId = &#63;.
	*
	* @param eventId the primary key of the current next follow up event
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent[] findByReport_PrevAndNext(
		long eventId, long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the next follow up events where reportId = &#63; from the database.
	*
	* @param reportId the report ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of next follow up events where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the number of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public int countByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the next follow up events where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @return the matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReportStatus(
		long reportId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the next follow up events where reportId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param status the status
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @return the range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReportStatus(
		long reportId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the next follow up events where reportId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param status the status
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findByReportStatus(
		long reportId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByReportStatus_First(
		long reportId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByReportStatus_First(
		long reportId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByReportStatus_Last(
		long reportId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByReportStatus_Last(
		long reportId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the next follow up events before and after the current next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	*
	* @param eventId the primary key of the current next follow up event
	* @param reportId the report ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent[] findByReportStatus_PrevAndNext(
		long eventId, long reportId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the next follow up events where reportId = &#63; and status = &#63; from the database.
	*
	* @param reportId the report ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReportStatus(long reportId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of next follow up events where reportId = &#63; and status = &#63;.
	*
	* @param reportId the report ID
	* @param status the status
	* @return the number of matching next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public int countByReportStatus(long reportId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the next follow up event in the entity cache if it is enabled.
	*
	* @param nextFollowUpEvent the next follow up event
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent);

	/**
	* Caches the next follow up events in the entity cache if it is enabled.
	*
	* @param nextFollowUpEvents the next follow up events
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> nextFollowUpEvents);

	/**
	* Creates a new next follow up event with the primary key. Does not add the next follow up event to the database.
	*
	* @param eventId the primary key for the new next follow up event
	* @return the new next follow up event
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent create(
		long eventId);

	/**
	* Removes the next follow up event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the next follow up event
	* @return the next follow up event that was removed
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent remove(
		long eventId)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.NextFollowUpEvent updateImpl(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the next follow up event with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchNextFollowUpEventException} if it could not be found.
	*
	* @param eventId the primary key of the next follow up event
	* @return the next follow up event
	* @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent findByPrimaryKey(
		long eventId)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the next follow up event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the next follow up event
	* @return the next follow up event, or <code>null</code> if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchByPrimaryKey(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the next follow up events.
	*
	* @return the next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the next follow up events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @return the range of next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the next follow up events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of next follow up events
	* @param end the upper bound of the range of next follow up events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the next follow up events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of next follow up events.
	*
	* @return the number of next follow up events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}