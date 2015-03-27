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
 * Provides a wrapper for {@link AddressBookLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookLocalService
 * @generated
 */
public class AddressBookLocalServiceWrapper implements AddressBookLocalService,
	ServiceWrapper<AddressBookLocalService> {
	public AddressBookLocalServiceWrapper(
		AddressBookLocalService addressBookLocalService) {
		_addressBookLocalService = addressBookLocalService;
	}

	/**
	* Adds the address book to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBook the address book
	* @return the address book that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook addAddressBook(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.addAddressBook(addressBook);
	}

	/**
	* Creates a new address book with the primary key. Does not add the address book to the database.
	*
	* @param addressBookId the primary key for the new address book
	* @return the new address book
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook createAddressBook(
		long addressBookId) {
		return _addressBookLocalService.createAddressBook(addressBookId);
	}

	/**
	* Deletes the address book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book
	* @return the address book that was removed
	* @throws PortalException if a address book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook deleteAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.deleteAddressBook(addressBookId);
	}

	/**
	* Deletes the address book from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBook the address book
	* @return the address book that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook deleteAddressBook(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.deleteAddressBook(addressBook);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressBookLocalService.dynamicQuery();
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
		return _addressBookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _addressBookLocalService.dynamicQueryCount(dynamicQuery);
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
		return _addressBookLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBook fetchAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.fetchAddressBook(addressBookId);
	}

	/**
	* Returns the address book with the primary key.
	*
	* @param addressBookId the primary key of the address book
	* @return the address book
	* @throws PortalException if a address book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook getAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getAddressBook(addressBookId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBook> getAddressBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getAddressBooks(start, end);
	}

	/**
	* Returns the number of address books.
	*
	* @return the number of address books
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAddressBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getAddressBooksCount();
	}

	/**
	* Updates the address book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBook the address book
	* @return the address book that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBook updateAddressBook(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.updateAddressBook(addressBook);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _addressBookLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_addressBookLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _addressBookLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBook addAddressBook(
		long companyId, long addressBookType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.addAddressBook(companyId,
			addressBookType);
	}

	@Override
	public void addAddressBookOrganization(long organizationId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookLocalService.addAddressBookOrganization(organizationId,
			companyId);
	}

	@Override
	public void addAddressBookUser(long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookLocalService.addAddressBookUser(userId, companyId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Contact> getContacts(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getContacts(addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Contact> getContactsOrderByName(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookLocalService.getContactsOrderByName(addressBookId);
	}

	@Override
	public void addContact(long addressBookId, long contactId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookLocalService.addContact(addressBookId, contactId, companyId);
	}

	@Override
	public void addContactData(long addressBookId, long contactDataId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookLocalService.addContactData(addressBookId, contactDataId,
			companyId);
	}

	@Override
	public void removeContactData(long addressBookId, long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_addressBookLocalService.removeContactData(addressBookId, contactDataId);
	}

	@Override
	public boolean hasContact(long addressBookId, long contactId) {
		return _addressBookLocalService.hasContact(addressBookId, contactId);
	}

	@Override
	public boolean hasContactData(long addressBookId, long contactDataId) {
		return _addressBookLocalService.hasContactData(addressBookId,
			contactDataId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AddressBookLocalService getWrappedAddressBookLocalService() {
		return _addressBookLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAddressBookLocalService(
		AddressBookLocalService addressBookLocalService) {
		_addressBookLocalService = addressBookLocalService;
	}

	@Override
	public AddressBookLocalService getWrappedService() {
		return _addressBookLocalService;
	}

	@Override
	public void setWrappedService(
		AddressBookLocalService addressBookLocalService) {
		_addressBookLocalService = addressBookLocalService;
	}

	private AddressBookLocalService _addressBookLocalService;
}