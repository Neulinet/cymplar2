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

import com.leancrm.portlet.library.model.AddressBookUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address book user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookUserPersistenceImpl
 * @see AddressBookUserUtil
 * @generated
 */
public interface AddressBookUserPersistence extends BasePersistence<AddressBookUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressBookUserUtil} to access the address book user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the address book users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of address book users
	* @param end the upper bound of the range of address book users (not inclusive)
	* @return the range of matching address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of address book users
	* @param end the upper bound of the range of address book users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book user
	* @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a matching address book user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book user, or <code>null</code> if a matching address book user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book user
	* @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a matching address book user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book user, or <code>null</code> if a matching address book user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book users before and after the current address book user in the ordered set where userId = &#63;.
	*
	* @param addressBookId the primary key of the current address book user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book user
	* @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser[] findByUser_PrevAndNext(
		long addressBookId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching address book users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the address book user in the entity cache if it is enabled.
	*
	* @param addressBookUser the address book user
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser);

	/**
	* Caches the address book users in the entity cache if it is enabled.
	*
	* @param addressBookUsers the address book users
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookUser> addressBookUsers);

	/**
	* Creates a new address book user with the primary key. Does not add the address book user to the database.
	*
	* @param addressBookId the primary key for the new address book user
	* @return the new address book user
	*/
	public com.leancrm.portlet.library.model.AddressBookUser create(
		long addressBookId);

	/**
	* Removes the address book user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book user
	* @return the address book user that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser remove(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.AddressBookUser updateImpl(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book user with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookUserException} if it could not be found.
	*
	* @param addressBookId the primary key of the address book user
	* @return the address book user
	* @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser findByPrimaryKey(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookId the primary key of the address book user
	* @return the address book user, or <code>null</code> if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookUser fetchByPrimaryKey(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book users.
	*
	* @return the address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book users
	* @param end the upper bound of the range of address book users (not inclusive)
	* @return the range of address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book users
	* @param end the upper bound of the range of address book users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of address book users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book users.
	*
	* @return the number of address book users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}