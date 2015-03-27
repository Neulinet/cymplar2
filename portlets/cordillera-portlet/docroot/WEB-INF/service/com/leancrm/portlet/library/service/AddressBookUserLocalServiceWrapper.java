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

package com.leancrm.portlet.library.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressBookUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookUserLocalService
 * @generated
 */
public class AddressBookUserLocalServiceWrapper
	implements AddressBookUserLocalService,
		ServiceWrapper<AddressBookUserLocalService> {
	public AddressBookUserLocalServiceWrapper(
		AddressBookUserLocalService addressBookUserLocalService) {
		_addressBookUserLocalService = addressBookUserLocalService;
	}

	/**
	* Adds the address book user to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookUser the address book user
	* @return the address book user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser addAddressBookUser(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.addAddressBookUser(addressBookUser);
	}

	/**
	* Creates a new address book user with the primary key. Does not add the address book user to the database.
	*
	* @param addressBookId the primary key for the new address book user
	* @return the new address book user
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser createAddressBookUser(
		long addressBookId) {
		return _addressBookUserLocalService.createAddressBookUser(addressBookId);
	}

	/**
	* Deletes the address book user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book user
	* @return the address book user that was removed
	* @throws PortalException if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser deleteAddressBookUser(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.deleteAddressBookUser(addressBookId);
	}

	/**
	* Deletes the address book user from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookUser the address book user
	* @return the address book user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser deleteAddressBookUser(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.deleteAddressBookUser(addressBookUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressBookUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookUser fetchAddressBookUser(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.fetchAddressBookUser(addressBookId);
	}

	/**
	* Returns the address book user with the primary key.
	*
	* @param addressBookId the primary key of the address book user
	* @return the address book user
	* @throws PortalException if a address book user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser getAddressBookUser(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getAddressBookUser(addressBookId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> getAddressBookUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getAddressBookUsers(start, end);
	}

	/**
	* Returns the number of address book users.
	*
	* @return the number of address book users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAddressBookUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getAddressBookUsersCount();
	}

	/**
	* Updates the address book user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookUser the address book user
	* @return the address book user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookUser updateAddressBookUser(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.updateAddressBookUser(addressBookUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _addressBookUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_addressBookUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _addressBookUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookUser> getAddressBookUserList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getAddressBookUserList(userId);
	}

	@Override
	public java.util.List<java.lang.Long> getUsersHaveContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookUserLocalService.getUsersHaveContact(contactId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AddressBookUserLocalService getWrappedAddressBookUserLocalService() {
		return _addressBookUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAddressBookUserLocalService(
		AddressBookUserLocalService addressBookUserLocalService) {
		_addressBookUserLocalService = addressBookUserLocalService;
	}

	@Override
	public AddressBookUserLocalService getWrappedService() {
		return _addressBookUserLocalService;
	}

	@Override
	public void setWrappedService(
		AddressBookUserLocalService addressBookUserLocalService) {
		_addressBookUserLocalService = addressBookUserLocalService;
	}

	private AddressBookUserLocalService _addressBookUserLocalService;
}