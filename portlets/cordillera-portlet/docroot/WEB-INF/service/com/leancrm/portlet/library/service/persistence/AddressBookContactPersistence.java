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

import com.leancrm.portlet.library.model.AddressBookContact;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address book contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactPersistenceImpl
 * @see AddressBookContactUtil
 * @generated
 */
public interface AddressBookContactPersistence extends BasePersistence<AddressBookContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressBookContactUtil} to access the address book contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @return the matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @return the range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByContactAddressBook_First(
		long addressBookId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByContactAddressBook_First(
		long addressBookId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByContactAddressBook_Last(
		long addressBookId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByContactAddressBook_Last(
		long addressBookId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contacts before and after the current address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookContactPK the primary key of the current address book contact
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact[] findByContactAddressBook_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK,
		long addressBookId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contacts where addressBookId = &#63; and contactId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactAddressBook(long addressBookId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contacts where addressBookId = &#63; and contactId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param contactId the contact ID
	* @return the number of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactAddressBook(long addressBookId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contacts where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book contacts where addressBookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @return the range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByAddressBook(
		long addressBookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book contacts where addressBookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param addressBookId the address book ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByAddressBook(
		long addressBookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByAddressBook_First(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByAddressBook_Last(
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contacts before and after the current address book contact in the ordered set where addressBookId = &#63;.
	*
	* @param addressBookContactPK the primary key of the current address book contact
	* @param addressBookId the address book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact[] findByAddressBook_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK,
		long addressBookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contacts where addressBookId = &#63; from the database.
	*
	* @param addressBookId the address book ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contacts where addressBookId = &#63;.
	*
	* @param addressBookId the address book ID
	* @return the number of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByAddressBook(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contacts where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book contacts where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @return the range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book contacts where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findByContact(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book contact in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book contact in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contacts before and after the current address book contact in the ordered set where contactId = &#63;.
	*
	* @param addressBookContactPK the primary key of the current address book contact
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact[] findByContact_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK,
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contacts where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contacts where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the address book contact in the entity cache if it is enabled.
	*
	* @param addressBookContact the address book contact
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact);

	/**
	* Caches the address book contacts in the entity cache if it is enabled.
	*
	* @param addressBookContacts the address book contacts
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookContact> addressBookContacts);

	/**
	* Creates a new address book contact with the primary key. Does not add the address book contact to the database.
	*
	* @param addressBookContactPK the primary key for the new address book contact
	* @return the new address book contact
	*/
	public com.leancrm.portlet.library.model.AddressBookContact create(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK);

	/**
	* Removes the address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact remove(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.AddressBookContact updateImpl(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookContactException} if it could not be found.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact
	* @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.leancrm.portlet.library.NoSuchAddressBookContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact, or <code>null</code> if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookContact fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book contacts.
	*
	* @return the address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @return the range of address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book contacts
	* @param end the upper bound of the range of address book contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book contacts.
	*
	* @return the number of address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}