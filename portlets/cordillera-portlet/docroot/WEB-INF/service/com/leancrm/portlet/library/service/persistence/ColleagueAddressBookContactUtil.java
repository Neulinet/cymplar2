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

import com.leancrm.portlet.library.model.ColleagueAddressBookContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the colleague address book contact service. This utility wraps {@link ColleagueAddressBookContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColleagueAddressBookContactPersistence
 * @see ColleagueAddressBookContactPersistenceImpl
 * @generated
 */
public class ColleagueAddressBookContactUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		getPersistence().clearCache(colleagueAddressBookContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ColleagueAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ColleagueAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ColleagueAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ColleagueAddressBookContact update(
		ColleagueAddressBookContact colleagueAddressBookContact)
		throws SystemException {
		return getPersistence().update(colleagueAddressBookContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ColleagueAddressBookContact update(
		ColleagueAddressBookContact colleagueAddressBookContact,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(colleagueAddressBookContact, serviceContext);
	}

	/**
	* Caches the colleague address book contact in the entity cache if it is enabled.
	*
	* @param colleagueAddressBookContact the colleague address book contact
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact) {
		getPersistence().cacheResult(colleagueAddressBookContact);
	}

	/**
	* Caches the colleague address book contacts in the entity cache if it is enabled.
	*
	* @param colleagueAddressBookContacts the colleague address book contacts
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> colleagueAddressBookContacts) {
		getPersistence().cacheResult(colleagueAddressBookContacts);
	}

	/**
	* Creates a new colleague address book contact with the primary key. Does not add the colleague address book contact to the database.
	*
	* @param colleagueAddressBookContactPK the primary key for the new colleague address book contact
	* @return the new colleague address book contact
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact create(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK) {
		return getPersistence().create(colleagueAddressBookContactPK);
	}

	/**
	* Removes the colleague address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	* @return the colleague address book contact that was removed
	* @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact remove(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(colleagueAddressBookContactPK);
	}

	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact updateImpl(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(colleagueAddressBookContact);
	}

	/**
	* Returns the colleague address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException} if it could not be found.
	*
	* @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	* @return the colleague address book contact
	* @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(colleagueAddressBookContactPK);
	}

	/**
	* Returns the colleague address book contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	* @return the colleague address book contact, or <code>null</code> if a colleague address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ColleagueAddressBookContact fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(colleagueAddressBookContactPK);
	}

	/**
	* Returns all the colleague address book contacts.
	*
	* @return the colleague address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the colleague address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of colleague address book contacts
	* @param end the upper bound of the range of colleague address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of colleague address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ColleagueAddressBookContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the colleague address book contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of colleague address book contacts.
	*
	* @return the number of colleague address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ColleagueAddressBookContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ColleagueAddressBookContactPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ColleagueAddressBookContactPersistence.class.getName());

			ReferenceRegistry.registerReference(ColleagueAddressBookContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ColleagueAddressBookContactPersistence persistence) {
	}

	private static ColleagueAddressBookContactPersistence _persistence;
}