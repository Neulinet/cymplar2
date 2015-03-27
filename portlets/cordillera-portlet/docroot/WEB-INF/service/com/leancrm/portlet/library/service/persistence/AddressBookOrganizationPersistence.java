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

import com.leancrm.portlet.library.model.AddressBookOrganization;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address book organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganizationPersistenceImpl
 * @see AddressBookOrganizationUtil
 * @generated
 */
public interface AddressBookOrganizationPersistence extends BasePersistence<AddressBookOrganization> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressBookOrganizationUtil} to access the address book organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the address book organizations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book organizations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of address book organizations
	* @param end the upper bound of the range of address book organizations (not inclusive)
	* @return the range of matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book organizations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of address book organizations
	* @param end the upper bound of the range of address book organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization findByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book organization, or <code>null</code> if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization findByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book organization, or <code>null</code> if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book organizations before and after the current address book organization in the ordered set where organizationId = &#63;.
	*
	* @param addressBookId the primary key of the current address book organization
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization[] findByOrganization_PrevAndNext(
		long addressBookId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book organizations where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book organizations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the address book organization in the entity cache if it is enabled.
	*
	* @param addressBookOrganization the address book organization
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization);

	/**
	* Caches the address book organizations in the entity cache if it is enabled.
	*
	* @param addressBookOrganizations the address book organizations
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> addressBookOrganizations);

	/**
	* Creates a new address book organization with the primary key. Does not add the address book organization to the database.
	*
	* @param addressBookId the primary key for the new address book organization
	* @return the new address book organization
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization create(
		long addressBookId);

	/**
	* Removes the address book organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization remove(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.AddressBookOrganization updateImpl(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book organization with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookOrganizationException} if it could not be found.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization findByPrimaryKey(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address book organization with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization, or <code>null</code> if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.AddressBookOrganization fetchByPrimaryKey(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the address book organizations.
	*
	* @return the address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the address book organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book organizations
	* @param end the upper bound of the range of address book organizations (not inclusive)
	* @return the range of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the address book organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book organizations
	* @param end the upper bound of the range of address book organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the address book organizations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of address book organizations.
	*
	* @return the number of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}