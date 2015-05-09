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
 * Provides a wrapper for {@link AddressBookContactDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactDataLocalService
 * @generated
 */
public class AddressBookContactDataLocalServiceWrapper
	implements AddressBookContactDataLocalService,
		ServiceWrapper<AddressBookContactDataLocalService> {
	public AddressBookContactDataLocalServiceWrapper(
		AddressBookContactDataLocalService addressBookContactDataLocalService) {
		_addressBookContactDataLocalService = addressBookContactDataLocalService;
	}

	/**
	* Adds the address book contact data to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData addAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.addAddressBookContactData(addressBookContactData);
	}

	/**
	* Creates a new address book contact data with the primary key. Does not add the address book contact data to the database.
	*
	* @param addressBookContactDataPK the primary key for the new address book contact data
	* @return the new address book contact data
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData createAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK) {
		return _addressBookContactDataLocalService.createAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Deletes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data that was removed
	* @throws PortalException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData deleteAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.deleteAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Deletes the address book contact data from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData deleteAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.deleteAddressBookContactData(addressBookContactData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressBookContactDataLocalService.dynamicQuery();
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
		return _addressBookContactDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookContactDataLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressBookContactDataLocalService.dynamicQuery(dynamicQuery,
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
		return _addressBookContactDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _addressBookContactDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData fetchAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.fetchAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Returns the address book contact data with the primary key.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data
	* @throws PortalException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData getAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getAddressBookContactData(addressBookContactDataPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> getAddressBookContactDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getAddressBookContactDatas(start,
			end);
	}

	/**
	* Returns the number of address book contact datas.
	*
	* @return the number of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAddressBookContactDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getAddressBookContactDatasCount();
	}

	/**
	* Updates the address book contact data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.AddressBookContactData updateAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.updateAddressBookContactData(addressBookContactData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _addressBookContactDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_addressBookContactDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _addressBookContactDataLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void copyContactData(long contactDataId, long addressBookFrom,
		long addressBookTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactDataLocalService.copyContactData(contactDataId,
			addressBookFrom, addressBookTo);
	}

	/**
	* Remove in cascade.
	* Remove all contact data related to an address book and remove all not read only contact data associated with this.
	*
	* @param addressBookId
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public void removerContactDatas(long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactDataLocalService.removerContactDatas(addressBookId);
	}

	@Override
	public void removeContactData(long contactDataId, long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressBookContactDataLocalService.removeContactData(contactDataId,
			addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactData(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getContactData(addressBook,
			contactId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataImpl(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getContactDataImpl(addressBook,
			contactId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactData(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getContactData(addressBook);
	}

	/**
	* Se supone que hay un contact data por method, si no fuera asi habria que reescribir esta funcion
	*
	* @param addressBook
	* @param contactId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.Map<java.lang.String, com.leancrm.portlet.library.model.ContactData> getContactDataGroupByMethod(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getContactDataGroupByMethod(addressBook,
			contactId);
	}

	/**
	* Consideramos que un Address Book contiene datos unicos sobre un contacto. Quiere decir por ejemplo
	* que en un Address Book no habra dos telefonos de un mismo contacto, solo podra haber uno. No se
	* pudo restringir esto desde el modelo de datos.
	*
	* @param addressBookId
	* @param contactId
	* @param methodName
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData getContactData(
		long addressBookId, long contactId, long methodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressBookContactDataLocalService.getContactData(addressBookId,
			contactId, methodId);
	}

	@Override
	public int getAddressBookContactDatasCount(long contactDataId) {
		return _addressBookContactDataLocalService.getAddressBookContactDatasCount(contactDataId);
	}

	@Override
	public boolean hasContactData(long addressBookId, long contactDataId) {
		return _addressBookContactDataLocalService.hasContactData(addressBookId,
			contactDataId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AddressBookContactDataLocalService getWrappedAddressBookContactDataLocalService() {
		return _addressBookContactDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAddressBookContactDataLocalService(
		AddressBookContactDataLocalService addressBookContactDataLocalService) {
		_addressBookContactDataLocalService = addressBookContactDataLocalService;
	}

	@Override
	public AddressBookContactDataLocalService getWrappedService() {
		return _addressBookContactDataLocalService;
	}

	@Override
	public void setWrappedService(
		AddressBookContactDataLocalService addressBookContactDataLocalService) {
		_addressBookContactDataLocalService = addressBookContactDataLocalService;
	}

	private AddressBookContactDataLocalService _addressBookContactDataLocalService;
}