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

import com.leancrm.portlet.library.model.MyAddressBookContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the my address book contact service. This utility wraps {@link MyAddressBookContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyAddressBookContactPersistence
 * @see MyAddressBookContactPersistenceImpl
 * @generated
 */
public class MyAddressBookContactUtil {
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
	public static void clearCache(MyAddressBookContact myAddressBookContact) {
		getPersistence().clearCache(myAddressBookContact);
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
	public static List<MyAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyAddressBookContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MyAddressBookContact update(
		MyAddressBookContact myAddressBookContact) throws SystemException {
		return getPersistence().update(myAddressBookContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MyAddressBookContact update(
		MyAddressBookContact myAddressBookContact, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(myAddressBookContact, serviceContext);
	}

	/**
	* Caches the my address book contact in the entity cache if it is enabled.
	*
	* @param myAddressBookContact the my address book contact
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.MyAddressBookContact myAddressBookContact) {
		getPersistence().cacheResult(myAddressBookContact);
	}

	/**
	* Caches the my address book contacts in the entity cache if it is enabled.
	*
	* @param myAddressBookContacts the my address book contacts
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.MyAddressBookContact> myAddressBookContacts) {
		getPersistence().cacheResult(myAddressBookContacts);
	}

	/**
	* Creates a new my address book contact with the primary key. Does not add the my address book contact to the database.
	*
	* @param myAddressBookContactPK the primary key for the new my address book contact
	* @return the new my address book contact
	*/
	public static com.leancrm.portlet.library.model.MyAddressBookContact create(
		com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK myAddressBookContactPK) {
		return getPersistence().create(myAddressBookContactPK);
	}

	/**
	* Removes the my address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param myAddressBookContactPK the primary key of the my address book contact
	* @return the my address book contact that was removed
	* @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.MyAddressBookContact remove(
		com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK myAddressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(myAddressBookContactPK);
	}

	public static com.leancrm.portlet.library.model.MyAddressBookContact updateImpl(
		com.leancrm.portlet.library.model.MyAddressBookContact myAddressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(myAddressBookContact);
	}

	/**
	* Returns the my address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchMyAddressBookContactException} if it could not be found.
	*
	* @param myAddressBookContactPK the primary key of the my address book contact
	* @return the my address book contact
	* @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.MyAddressBookContact findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK myAddressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(myAddressBookContactPK);
	}

	/**
	* Returns the my address book contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param myAddressBookContactPK the primary key of the my address book contact
	* @return the my address book contact, or <code>null</code> if a my address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.MyAddressBookContact fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.MyAddressBookContactPK myAddressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(myAddressBookContactPK);
	}

	/**
	* Returns all the my address book contacts.
	*
	* @return the my address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.MyAddressBookContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the my address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.MyAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of my address book contacts
	* @param end the upper bound of the range of my address book contacts (not inclusive)
	* @return the range of my address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.MyAddressBookContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the my address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.MyAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of my address book contacts
	* @param end the upper bound of the range of my address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of my address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.MyAddressBookContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the my address book contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of my address book contacts.
	*
	* @return the number of my address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MyAddressBookContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MyAddressBookContactPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					MyAddressBookContactPersistence.class.getName());

			ReferenceRegistry.registerReference(MyAddressBookContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MyAddressBookContactPersistence persistence) {
	}

	private static MyAddressBookContactPersistence _persistence;
}