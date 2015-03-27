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
 * Provides a wrapper for {@link AddressBookContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactLocalService
 * @generated
 */
public class AddressBookContactLocalServiceWrapper
	implements AddressBookContactLocalService,
		ServiceWrapper<AddressBookContactLocalService> {
	public AddressBookContactLocalServiceWrapper(
		AddressBookContactLocalService addressBookContactLocalService) {
		_addressBookContactLocalService = addressBookContactLocalService;
	}

	/**
	* Adds the address book contact to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact addAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.addAddressBookContact(addressBookContact);
	}

	/**
	* Creates a new address book contact with the primary key. Does not add the address book contact to the database.
	*
	* @param addressBookContactPK the primary key for the new address book contact
	* @return the new address book contact
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact createAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK) {
		return _addressBookContactLocalService.createAddressBookContact(addressBookContactPK);
	}

	/**
	* Deletes the address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact that was removed
	* @throws PortalException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact deleteAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.deleteAddressBookContact(addressBookContactPK);
	}

	/**
	* Deletes the address book contact from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact deleteAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.deleteAddressBookContact(addressBookContact);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressBookContactLocalService.dynamicQuery();
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
		return _addressBookContactLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookContactLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookContactLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _addressBookContactLocalService.dynamicQueryCount(dynamicQuery);
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
		return _addressBookContactLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContact fetchAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.fetchAddressBookContact(addressBookContactPK);
	}

	/**
	* Returns the address book contact with the primary key.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact
	* @throws PortalException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact getAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getAddressBookContact(addressBookContactPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getAddressBookContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getAddressBookContacts(start, end);
	}

	/**
	* Returns the number of address book contacts.
	*
	* @return the number of address book contacts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAddressBookContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getAddressBookContactsCount();
	}

	/**
	* Updates the address book contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContact updateAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.updateAddressBookContact(addressBookContact);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _addressBookContactLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_addressBookContactLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _addressBookContactLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void copyContact(long contactId, long addressBookFrom,
		long addressBookTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactLocalService.copyContact(contactId, addressBookFrom,
			addressBookTo);
	}

	/**
	* Remove all contacts related to an address book.
	*
	* @param addressBookId
	* @throws SystemException
	*/
	@Override
	public void removeAddressBookContact(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactLocalService.removeAddressBookContact(addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getByAddressBook(addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getByContact(contactId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Contact> getContacts(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getContacts(addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getContactsByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getContactsByAddressBook(addressBookId);
	}

	@Override
	public java.util.Map<java.lang.Long, com.leancrm.portlet.library.model.AddressBookContact> getContactsByAddressBookAsMap(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.getContactsByAddressBookAsMap(addressBookId);
	}

	@Override
	public int countAddressBook(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactLocalService.countAddressBook(contactId);
	}

	@Override
	public boolean hasContact(long addressBookId, long contactId) {
		return _addressBookContactLocalService.hasContact(addressBookId,
			contactId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AddressBookContactLocalService getWrappedAddressBookContactLocalService() {
		return _addressBookContactLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAddressBookContactLocalService(
		AddressBookContactLocalService addressBookContactLocalService) {
		_addressBookContactLocalService = addressBookContactLocalService;
	}

	@Override
	public AddressBookContactLocalService getWrappedService() {
		return _addressBookContactLocalService;
	}

	@Override
	public void setWrappedService(
		AddressBookContactLocalService addressBookContactLocalService) {
		_addressBookContactLocalService = addressBookContactLocalService;
	}

	private AddressBookContactLocalService _addressBookContactLocalService;
}