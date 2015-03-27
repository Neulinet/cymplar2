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

import com.leancrm.portlet.library.model.ContactDataPhone;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact data phone service. This utility wraps {@link ContactDataPhonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhonePersistence
 * @see ContactDataPhonePersistenceImpl
 * @generated
 */
public class ContactDataPhoneUtil {
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
	public static void clearCache(ContactDataPhone contactDataPhone) {
		getPersistence().clearCache(contactDataPhone);
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
	public static List<ContactDataPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactDataPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactDataPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ContactDataPhone update(ContactDataPhone contactDataPhone)
		throws SystemException {
		return getPersistence().update(contactDataPhone);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ContactDataPhone update(ContactDataPhone contactDataPhone,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactDataPhone, serviceContext);
	}

	/**
	* Caches the contact data phone in the entity cache if it is enabled.
	*
	* @param contactDataPhone the contact data phone
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone) {
		getPersistence().cacheResult(contactDataPhone);
	}

	/**
	* Caches the contact data phones in the entity cache if it is enabled.
	*
	* @param contactDataPhones the contact data phones
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> contactDataPhones) {
		getPersistence().cacheResult(contactDataPhones);
	}

	/**
	* Creates a new contact data phone with the primary key. Does not add the contact data phone to the database.
	*
	* @param contactDataId the primary key for the new contact data phone
	* @return the new contact data phone
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone create(
		long contactDataId) {
		return getPersistence().create(contactDataId);
	}

	/**
	* Removes the contact data phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone remove(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataPhoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contactDataId);
	}

	public static com.leancrm.portlet.library.model.ContactDataPhone updateImpl(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactDataPhone);
	}

	/**
	* Returns the contact data phone with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataPhoneException} if it could not be found.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone
	* @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone findByPrimaryKey(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataPhoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contactDataId);
	}

	/**
	* Returns the contact data phone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone, or <code>null</code> if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone fetchByPrimaryKey(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactDataId);
	}

	/**
	* Returns all the contact data phones.
	*
	* @return the contact data phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contact data phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data phones
	* @param end the upper bound of the range of contact data phones (not inclusive)
	* @return the range of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contact data phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data phones
	* @param end the upper bound of the range of contact data phones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contact data phones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contact data phones.
	*
	* @return the number of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactDataPhonePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactDataPhonePersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ContactDataPhonePersistence.class.getName());

			ReferenceRegistry.registerReference(ContactDataPhoneUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContactDataPhonePersistence persistence) {
	}

	private static ContactDataPhonePersistence _persistence;
}