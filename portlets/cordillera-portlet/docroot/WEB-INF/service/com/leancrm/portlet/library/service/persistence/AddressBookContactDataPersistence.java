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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address book contact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactDataPersistenceImpl
 * @see AddressBookContactDataUtil
 * @generated
 */
public interface AddressBookContactDataPersistence extends BasePersistence<AddressBookContactData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressBookContactDataUtil} to access the address book contact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the address book contact datas where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBook(
		long addressBookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData findByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData findByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.AddressBookContactData[] findByAddressBook_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contact datas where addressBookId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contact datas where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contact datas where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByContactData(
		long contactDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData findByContactData_First(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByContactData_First(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData findByContactData_Last(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByContactData_Last(
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.AddressBookContactData[] findByContactData_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contact datas where contactDataId = &#63; from the database.
	*
	* @param contactDataId the contact data ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactData(long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contact datas where contactDataId = &#63;.
	*
	* @param contactDataId the contact data ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactData(long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @return the matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.AddressBookContactData findByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.AddressBookContactData findByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.AddressBookContactData[] findByAddressBookContactData_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK,
		long addressBookId, long contactDataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contact datas where addressBookId = &#63; and contactDataId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAddressBookContactData(long addressBookId,
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactDataId the contact data ID
	* @return the number of matching address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByAddressBookContactData(long addressBookId,
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the address book contact data in the entity cache if it is enabled.
	*
	* @param addressBookContactData the address book contact data
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData);

	/**
	* Caches the address book contact datas in the entity cache if it is enabled.
	*
	* @param addressBookContactDatas the address book contact datas
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> addressBookContactDatas);

	/**
	* Creates a new address book contact data with the primary key. Does not add the address book contact data to the database.
	*
	* @param addressBookContactDataPK the primary key for the new address book contact data
	* @return the new address book contact data
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData create(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK);

	/**
	* Removes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData remove(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.AddressBookContactData updateImpl(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookContactDataException} if it could not be found.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contact data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data, or <code>null</code> if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContactData fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contact datas.
	*
	* @return the address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contact datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contact datas.
	*
	* @return the number of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}