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
 * Provides a wrapper for {@link NextFollowUpEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEventLocalService
 * @generated
 */
public class NextFollowUpEventLocalServiceWrapper
	implements NextFollowUpEventLocalService,
		ServiceWrapper<NextFollowUpEventLocalService> {
	public NextFollowUpEventLocalServiceWrapper(
		NextFollowUpEventLocalService nextFollowUpEventLocalService) {
		_nextFollowUpEventLocalService = nextFollowUpEventLocalService;
	}

	/**
	* Adds the next follow up event to the database. Also notifies the appropriate model listeners.
	*
	* @param nextFollowUpEvent the next follow up event
	* @return the next follow up event that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent addNextFollowUpEvent(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.addNextFollowUpEvent(nextFollowUpEvent);
	}

	/**
	* Creates a new next follow up event with the primary key. Does not add the next follow up event to the database.
	*
	* @param eventId the primary key for the new next follow up event
	* @return the new next follow up event
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent createNextFollowUpEvent(
		long eventId) {
		return _nextFollowUpEventLocalService.createNextFollowUpEvent(eventId);
	}

	/**
	* Deletes the next follow up event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the next follow up event
	* @return the next follow up event that was removed
	* @throws PortalException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent deleteNextFollowUpEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.deleteNextFollowUpEvent(eventId);
	}

	/**
	* Deletes the next follow up event from the database. Also notifies the appropriate model listeners.
	*
	* @param nextFollowUpEvent the next follow up event
	* @return the next follow up event that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent deleteNextFollowUpEvent(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.deleteNextFollowUpEvent(nextFollowUpEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nextFollowUpEventLocalService.dynamicQuery();
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
		return _nextFollowUpEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nextFollowUpEventLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nextFollowUpEventLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _nextFollowUpEventLocalService.dynamicQueryCount(dynamicQuery);
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
		return _nextFollowUpEventLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent fetchNextFollowUpEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.fetchNextFollowUpEvent(eventId);
	}

	/**
	* Returns the next follow up event with the primary key.
	*
	* @param eventId the primary key of the next follow up event
	* @return the next follow up event
	* @throws PortalException if a next follow up event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent getNextFollowUpEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getNextFollowUpEvent(eventId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> getNextFollowUpEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getNextFollowUpEvents(start, end);
	}

	/**
	* Returns the number of next follow up events.
	*
	* @return the number of next follow up events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNextFollowUpEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getNextFollowUpEventsCount();
	}

	/**
	* Updates the next follow up event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nextFollowUpEvent the next follow up event
	* @return the next follow up event that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent updateNextFollowUpEvent(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.updateNextFollowUpEvent(nextFollowUpEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _nextFollowUpEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nextFollowUpEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _nextFollowUpEventLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent addNextFollowUpEvent(
		long contractId, long reportId, java.lang.String title,
		java.lang.String description, java.util.Date eventDate, long ownerId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.addNextFollowUpEvent(contractId,
			reportId, title, description, eventDate, ownerId, status);
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent updateStatus(
		long nextFollowUpEventId, int status)
		throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.updateStatus(nextFollowUpEventId,
			status);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.NextFollowUpEvent> getByStatus(
		long reportId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getByStatus(reportId, status);
	}

	@Override
	public com.leancrm.portlet.library.model.NextFollowUpEvent getLastEventByStatus(
		long reportId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nextFollowUpEventLocalService.getLastEventByStatus(reportId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NextFollowUpEventLocalService getWrappedNextFollowUpEventLocalService() {
		return _nextFollowUpEventLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNextFollowUpEventLocalService(
		NextFollowUpEventLocalService nextFollowUpEventLocalService) {
		_nextFollowUpEventLocalService = nextFollowUpEventLocalService;
	}

	@Override
	public NextFollowUpEventLocalService getWrappedService() {
		return _nextFollowUpEventLocalService;
	}

	@Override
	public void setWrappedService(
		NextFollowUpEventLocalService nextFollowUpEventLocalService) {
		_nextFollowUpEventLocalService = nextFollowUpEventLocalService;
	}

	private NextFollowUpEventLocalService _nextFollowUpEventLocalService;
}