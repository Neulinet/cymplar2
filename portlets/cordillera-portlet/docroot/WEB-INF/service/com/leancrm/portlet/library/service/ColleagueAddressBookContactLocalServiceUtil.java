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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ColleagueAddressBookContact. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.ColleagueAddressBookContactLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ColleagueAddressBookContactLocalService
 * @see com.leancrm.portlet.library.service.base.ColleagueAddressBookContactLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.ColleagueAddressBookContactLocalServiceImpl
 * @generated
 */
public class ColleagueAddressBookContactLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.ColleagueAddressBookContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the colleague address book contact to the database. Also notifies the appropriate model listeners.
	*
	* @param colleagueAddressBookContact the colleague address book contact
	* @return the colleague address book contact that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact addColleagueAddressBookContact(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addColleagueAddressBookContact(colleagueAddressBookContact);
	}

	/**
	* Creates a new colleague address book contact with the primary key. Does not add the colleague address book contact to the database.
	*
	* @param colleagueAddressBookContactPK the primary key for the new colleague address book contact
	* @return the new colleague address book contact
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact createColleagueAddressBookContact(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK) {
		return getService()
				   .createColleagueAddressBookContact(colleagueAddressBookContactPK);
	}

	/**
	* Deletes the colleague address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	* @return the colleague address book contact that was removed
	* @throws PortalException if a colleague address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact deleteColleagueAddressBookContact(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteColleagueAddressBookContact(colleagueAddressBookContactPK);
	}

	/**
	* Deletes the colleague address book contact from the database. Also notifies the appropriate model listeners.
	*
	* @param colleagueAddressBookContact the colleague address book contact
	* @return the colleague address book contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact deleteColleagueAddressBookContact(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteColleagueAddressBookContact(colleagueAddressBookContact);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact fetchColleagueAddressBookContact(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchColleagueAddressBookContact(colleagueAddressBookContactPK);
	}

	/**
	* Returns the colleague address book contact with the primary key.
	*
	* @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	* @return the colleague address book contact
	* @throws PortalException if a colleague address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact getColleagueAddressBookContact(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getColleagueAddressBookContact(colleagueAddressBookContactPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the colleague address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of colleague address book contacts
	* @param end the upper bound of the range of colleague address book contacts (not inclusive)
	* @return the range of colleague address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> getColleagueAddressBookContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColleagueAddressBookContacts(start, end);
	}

	/**
	* Returns the number of colleague address book contacts.
	*
	* @return the number of colleague address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int getColleagueAddressBookContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColleagueAddressBookContactsCount();
	}

	/**
	* Updates the colleague address book contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param colleagueAddressBookContact the colleague address book contact
	* @return the colleague address book contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact updateColleagueAddressBookContact(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateColleagueAddressBookContact(colleagueAddressBookContact);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> getAll(
		long organizationId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll(organizationId, userId, start, end);
	}

	public static int getTotal(long organizationId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTotal(organizationId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ColleagueAddressBookContactLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ColleagueAddressBookContactLocalService.class.getName());

			if (invokableLocalService instanceof ColleagueAddressBookContactLocalService) {
				_service = (ColleagueAddressBookContactLocalService)invokableLocalService;
			}
			else {
				_service = new ColleagueAddressBookContactLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ColleagueAddressBookContactLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ColleagueAddressBookContactLocalService service) {
	}

	private static ColleagueAddressBookContactLocalService _service;
}