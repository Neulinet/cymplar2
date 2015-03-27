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
 * Provides a wrapper for {@link ContactDataRefLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRefLocalService
 * @generated
 */
public class ContactDataRefLocalServiceWrapper
	implements ContactDataRefLocalService,
		ServiceWrapper<ContactDataRefLocalService> {
	public ContactDataRefLocalServiceWrapper(
		ContactDataRefLocalService contactDataRefLocalService) {
		_contactDataRefLocalService = contactDataRefLocalService;
	}

	/**
	* Adds the contact data ref to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataRef the contact data ref
	* @return the contact data ref that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef addContactDataRef(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.addContactDataRef(contactDataRef);
	}

	/**
	* Creates a new contact data ref with the primary key. Does not add the contact data ref to the database.
	*
	* @param contactDataId the primary key for the new contact data ref
	* @return the new contact data ref
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef createContactDataRef(
		long contactDataId) {
		return _contactDataRefLocalService.createContactDataRef(contactDataId);
	}

	/**
	* Deletes the contact data ref with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data ref
	* @return the contact data ref that was removed
	* @throws PortalException if a contact data ref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef deleteContactDataRef(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.deleteContactDataRef(contactDataId);
	}

	/**
	* Deletes the contact data ref from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataRef the contact data ref
	* @return the contact data ref that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef deleteContactDataRef(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.deleteContactDataRef(contactDataRef);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDataRefLocalService.dynamicQuery();
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
		return _contactDataRefLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataRefLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataRefLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contactDataRefLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactDataRefLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataRef fetchContactDataRef(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.fetchContactDataRef(contactDataId);
	}

	/**
	* Returns the contact data ref with the primary key.
	*
	* @param contactDataId the primary key of the contact data ref
	* @return the contact data ref
	* @throws PortalException if a contact data ref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef getContactDataRef(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.getContactDataRef(contactDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact data refs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data refs
	* @param end the upper bound of the range of contact data refs (not inclusive)
	* @return the range of contact data refs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactDataRef> getContactDataRefs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.getContactDataRefs(start, end);
	}

	/**
	* Returns the number of contact data refs.
	*
	* @return the number of contact data refs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactDataRefsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.getContactDataRefsCount();
	}

	/**
	* Updates the contact data ref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataRef the contact data ref
	* @return the contact data ref that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataRef updateContactDataRef(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.updateContactDataRef(contactDataRef);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactDataRefLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactDataRefLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactDataRefLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataRef addContactDataRef(
		long contactDataId, long value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataRefLocalService.addContactDataRef(contactDataId,
			value);
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
	public void updateContactDataRef(long contactId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		java.lang.String value, long addressBookId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataRefLocalService.updateContactDataRef(contactId,
			contactDataMethod, value, addressBookId, companyId);
	}

	@Override
	public void removeContactDataRef(long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataRefLocalService.removeContactDataRef(contactDataId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactDataRefLocalService getWrappedContactDataRefLocalService() {
		return _contactDataRefLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactDataRefLocalService(
		ContactDataRefLocalService contactDataRefLocalService) {
		_contactDataRefLocalService = contactDataRefLocalService;
	}

	@Override
	public ContactDataRefLocalService getWrappedService() {
		return _contactDataRefLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDataRefLocalService contactDataRefLocalService) {
		_contactDataRefLocalService = contactDataRefLocalService;
	}

	private ContactDataRefLocalService _contactDataRefLocalService;
}