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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the address book organization service. This utility wraps {@link AddressBookOrganizationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganizationPersistence
 * @see AddressBookOrganizationPersistenceImpl
 * @generated
 */
public class AddressBookOrganizationUtil {
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
		AddressBookOrganization addressBookOrganization) {
		getPersistence().clearCache(addressBookOrganization);
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
	public static List<AddressBookOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AddressBookOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AddressBookOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AddressBookOrganization update(
		AddressBookOrganization addressBookOrganization)
		throws SystemException {
		return getPersistence().update(addressBookOrganization);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AddressBookOrganization update(
		AddressBookOrganization addressBookOrganization,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(addressBookOrganization, serviceContext);
	}

	/**
	* Returns all the address book organizations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganization(organizationId);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganization(organizationId, start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization findByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address book organization, or <code>null</code> if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the last address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization findByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last address book organization in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address book organization, or <code>null</code> if a matching address book organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganization_Last(organizationId, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.AddressBookOrganization[] findByOrganization_PrevAndNext(
		long addressBookId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_PrevAndNext(addressBookId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the address book organizations where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganization(organizationId);
	}

	/**
	* Returns the number of address book organizations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganization(organizationId);
	}

	/**
	* Caches the address book organization in the entity cache if it is enabled.
	*
	* @param addressBookOrganization the address book organization
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization) {
		getPersistence().cacheResult(addressBookOrganization);
	}

	/**
	* Caches the address book organizations in the entity cache if it is enabled.
	*
	* @param addressBookOrganizations the address book organizations
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> addressBookOrganizations) {
		getPersistence().cacheResult(addressBookOrganizations);
	}

	/**
	* Creates a new address book organization with the primary key. Does not add the address book organization to the database.
	*
	* @param addressBookId the primary key for the new address book organization
	* @return the new address book organization
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization create(
		long addressBookId) {
		return getPersistence().create(addressBookId);
	}

	/**
	* Removes the address book organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization that was removed
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization remove(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(addressBookId);
	}

	public static com.leancrm.portlet.library.model.AddressBookOrganization updateImpl(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(addressBookOrganization);
	}

	/**
	* Returns the address book organization with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookOrganizationException} if it could not be found.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization
	* @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization findByPrimaryKey(
		long addressBookId)
		throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(addressBookId);
	}

	/**
	* Returns the address book organization with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization, or <code>null</code> if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization fetchByPrimaryKey(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(addressBookId);
	}

	/**
	* Returns all the address book organizations.
	*
	* @return the address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the address book organizations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of address book organizations.
	*
	* @return the number of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AddressBookOrganizationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AddressBookOrganizationPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					AddressBookOrganizationPersistence.class.getName());

			ReferenceRegistry.registerReference(AddressBookOrganizationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AddressBookOrganizationPersistence persistence) {
	}

	private static AddressBookOrganizationPersistence _persistence;
}