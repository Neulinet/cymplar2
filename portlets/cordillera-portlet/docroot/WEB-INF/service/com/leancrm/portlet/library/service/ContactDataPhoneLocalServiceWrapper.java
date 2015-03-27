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
 * Provides a wrapper for {@link ContactDataPhoneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhoneLocalService
 * @generated
 */
public class ContactDataPhoneLocalServiceWrapper
	implements ContactDataPhoneLocalService,
		ServiceWrapper<ContactDataPhoneLocalService> {
	public ContactDataPhoneLocalServiceWrapper(
		ContactDataPhoneLocalService contactDataPhoneLocalService) {
		_contactDataPhoneLocalService = contactDataPhoneLocalService;
	}

	/**
	* Adds the contact data phone to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone addContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.addContactDataPhone(contactDataPhone);
	}

	/**
	* Creates a new contact data phone with the primary key. Does not add the contact data phone to the database.
	*
	* @param contactDataId the primary key for the new contact data phone
	* @return the new contact data phone
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone createContactDataPhone(
		long contactDataId) {
		return _contactDataPhoneLocalService.createContactDataPhone(contactDataId);
	}

	/**
	* Deletes the contact data phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone that was removed
	* @throws PortalException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone deleteContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.deleteContactDataPhone(contactDataId);
	}

	/**
	* Deletes the contact data phone from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone deleteContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.deleteContactDataPhone(contactDataPhone);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDataPhoneLocalService.dynamicQuery();
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
		return _contactDataPhoneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataPhoneLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataPhoneLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contactDataPhoneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactDataPhoneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone fetchContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.fetchContactDataPhone(contactDataId);
	}

	/**
	* Returns the contact data phone with the primary key.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone
	* @throws PortalException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone getContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.getContactDataPhone(contactDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact data phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data phones
	* @param end the upper bound of the range of contact data phones (not inclusive)
	* @return the range of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> getContactDataPhones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.getContactDataPhones(start, end);
	}

	/**
	* Returns the number of contact data phones.
	*
	* @return the number of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactDataPhonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.getContactDataPhonesCount();
	}

	/**
	* Updates the contact data phone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone updateContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.updateContactDataPhone(contactDataPhone);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactDataPhoneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactDataPhoneLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactDataPhoneLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataPhone addContactDataPhone(
		long contactDataId, java.lang.String number, java.lang.String extension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataPhoneLocalService.addContactDataPhone(contactDataId,
			number, extension);
	}

	/**
	* Get current contact data based on method, addressBook and contactId
	* ADD if there is not current data or the current data is Read Only
	*
	* EDIT if current value is not equal to the new value
	*
	* REMOVE if current value exist, remove from the address book and if current value is not read only remove contact data
	*
	* @param contactId
	* @param method
	* @param value
	* @param addressBookId
	* @param companyId
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void updateContactDataPhone(long contactId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		java.lang.String number, java.lang.String extension,
		long addressBookId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataPhoneLocalService.updateContactDataPhone(contactId,
			contactDataMethod, number, extension, addressBookId, companyId);
	}

	@Override
	public java.lang.String getPhoneNumber(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone) {
		return _contactDataPhoneLocalService.getPhoneNumber(contactDataPhone);
	}

	@Override
	public void removeContactDataPhone(long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataPhoneLocalService.removeContactDataPhone(contactDataId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactDataPhoneLocalService getWrappedContactDataPhoneLocalService() {
		return _contactDataPhoneLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactDataPhoneLocalService(
		ContactDataPhoneLocalService contactDataPhoneLocalService) {
		_contactDataPhoneLocalService = contactDataPhoneLocalService;
	}

	@Override
	public ContactDataPhoneLocalService getWrappedService() {
		return _contactDataPhoneLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDataPhoneLocalService contactDataPhoneLocalService) {
		_contactDataPhoneLocalService = contactDataPhoneLocalService;
	}

	private ContactDataPhoneLocalService _contactDataPhoneLocalService;
}