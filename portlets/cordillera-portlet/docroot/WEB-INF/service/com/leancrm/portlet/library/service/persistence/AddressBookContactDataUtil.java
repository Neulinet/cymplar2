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

import com.leancrm.portlet.library.model.AddressBookContactData;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the address book contact data service. This utility wraps {@link AddressBookContactDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactDataPersistence
 * @see AddressBookContactDataPersistenceImpl
 * @generated
 */
public class AddressBookContactDataUtil {
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
	public static void clearCache(AddressBookContactData addressBookContactData) {
		getPersistence().clearCache(addressBookContactData);
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
	public static List<AddressBookContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AddressBookContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AddressBookContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AddressBookContactData update(
		AddressBookContactData addressBookContactData)
		throws SystemException {
		return getPersistence().update(addressBookContactData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AddressBookContactData update(
		AddressBookContactData addressBookContactData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(addressBookContactData, serviceContext);
	}

	/**
	* Returns all the address book contact datas where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAddressBook(addressBookId);
	}

	/**
	* Returns a range of all the address book contact datas where addressBookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @return the range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAddressBook(addressBookId, start, end);
	}

	/**
	* Returns an ordered range of all the address book contact datas where addressBookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBook(addressBookId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBook_First(addressBookId, orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAddressBook_First(addressBookId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBook_Last(addressBookId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAddressBook_Last(addressBookId, orderByComparator);
	}

	/**
	* Returns the address book contact datas before and after the current address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookContactDataPK the primary key of the current address book contact data
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData[] findByAddressBook_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBook_PrevAndNext(addressBookContactDataPK,
			addressBookId, orderByComparator);
	}

	/**
	* Removes all the address book contact datas where addressBookId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAddressBook(addressBookId);
	}

	/**
	* Returns the number of address book contact datas where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAddressBook(addressBookId);
	}

	/**
	* Returns all the address book contact datas where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContactData(contactDataId);
	}

	/**
	* Returns a range of all the address book contact datas where contactDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactDataId the contact data ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @return the range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContactData(contactDataId, start, end);
	}

	/**
	* Returns an ordered range of all the address book contact datas where contactDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactDataId the contact data ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactData(contactDataId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByContactData_First(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactData_First(contactDataId, orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByContactData_First(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactData_First(contactDataId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByContactData_Last(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactData_Last(contactDataId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByContactData_Last(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactData_Last(contactDataId, orderByComparator);
	}

	/**
	* Returns the address book contact datas before and after the current address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param addressBookContactDataPK the primary key of the current address book contact data
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData[] findByContactData_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactData_PrevAndNext(addressBookContactDataPK,
			contactDataId, orderByComparator);
	}

	/**
	* Removes all the address book contact datas where contactDataId = &#63; from the database.
	*
	* @param contactDataId the contact data ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactData(long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactData(contactDataId);
	}

	/**
	* Returns the number of address book contact datas where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactData(long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContactData(contactDataId);
	}

	/**
	* Returns all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData(addressBookId, contactDataId);
	}

	/**
	* Returns a range of all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @return the range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData(addressBookId, contactDataId,
			start, end);
	}

	/**
	* Returns an ordered range of all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData(addressBookId, contactDataId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData_First(addressBookId,
			contactDataId, orderByComparator);
	}

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAddressBookContactData_First(addressBookId,
			contactDataId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData_Last(addressBookId,
			contactDataId, orderByComparator);
	}

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAddressBookContactData_Last(addressBookId,
			contactDataId, orderByComparator);
	}

	/**
	* Returns the address book contact datas before and after the current address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookContactDataPK the primary key of the current address book contact data
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData[] findByAddressBookContactData_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAddressBookContactData_PrevAndNext(addressBookContactDataPK,
			addressBookId, contactDataId, orderByComparator);
	}

	/**
	* Removes all the address book contact datas where addressBookId = &#63; and contactDataId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAddressBookContactData(long addressBookId,
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAddressBookContactData(addressBookId, contactDataId);
	}

	/**
	* Returns the number of address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAddressBookContactData(long addressBookId,
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAddressBookContactData(addressBookId, contactDataId);
	}

	/**
	* Caches the address book contact data in the entity cache if it is enabled.
	*
	* @param addressBookContactData the address book contact data
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData) {
		getPersistence().cacheResult(addressBookContactData);
	}

	/**
	* Caches the address book contact datas in the entity cache if it is enabled.
	*
	* @param addressBookContactDatas the address book contact datas
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> addressBookContactDatas) {
		getPersistence().cacheResult(addressBookContactDatas);
	}

	/**
	* Creates a new address book contact data with the primary key. Does not add the address book contact data to the database.
	*
	* @param addressBookContactDataPK the primary key for the new address book contact data
	* @return the new address book contact data
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData create(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK) {
		return getPersistence().create(addressBookContactDataPK);
	}

	/**
	* Removes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData remove(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(addressBookContactDataPK);
	}

	public static com.leancrm.portlet.library.model.AddressBookContactData updateImpl(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(addressBookContactData);
	}

	/**
	* Returns the address book contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookContactDataException} if it could not be found.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(addressBookContactDataPK);
	}

	/**
	* Returns the address book contact data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data, or <code>null</code> if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(addressBookContactDataPK);
	}

	/**
	* Returns all the address book contact datas.
	*
	* @return the address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the address book contact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @return the range of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the address book contact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book contact datas
	* @param end the upper bound of the range of address book contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the address book contact datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of address book contact datas.
	*
	* @return the number of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AddressBookContactDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AddressBookContactDataPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					AddressBookContactDataPersistence.class.getName());

			ReferenceRegistry.registerReference(AddressBookContactDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AddressBookContactDataPersistence persistence) {
	}

	private static AddressBookContactDataPersistence _persistence;
}