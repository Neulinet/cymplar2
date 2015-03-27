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

import com.leancrm.portlet.library.model.AddressBook;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookPersistenceImpl
 * @see AddressBookUtil
 * @generated
 */
public interface AddressBookPersistence extends BasePersistence<AddressBook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressBookUtil} to access the address book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the address book in the entity cache if it is enabled.
	*
	* @param addressBook the address book
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.AddressBook addressBook);

	/**
	* Caches the address books in the entity cache if it is enabled.
	*
	* @param addressBooks the address books
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBook> addressBooks);

	/**
	* Creates a new address book with the primary key. Does not add the address book to the database.
	*
	* @param addressBookId the primary key for the new address book
	* @return the new address book
	*/
	public com.leancrm.portlet.library.model.AddressBook create(
		long addressBookId);

	/**
	* Removes the address book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book
	* @return the address book that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBook remove(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.AddressBook updateImpl(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookException} if it could not be found.
	*
	* @param addressBookId the primary key of the address book
	* @return the address book
	* @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBook findByPrimaryKey(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookId the primary key of the address book
	* @return the address book, or <code>null</code> if a address book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBook fetchByPrimaryKey(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address books.
	*
	* @return the address books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBook> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address books
	* @param end the upper bound of the range of address books (not inclusive)
	* @return the range of address books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBook> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address books
	* @param end the upper bound of the range of address books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of address books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address books from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address books.
	*
	* @return the number of address books
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}