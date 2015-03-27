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
 * Provides a wrapper for {@link ContactDataTextLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataTextLocalService
 * @generated
 */
public class ContactDataTextLocalServiceWrapper
	implements ContactDataTextLocalService,
		ServiceWrapper<ContactDataTextLocalService> {
	public ContactDataTextLocalServiceWrapper(
		ContactDataTextLocalService contactDataTextLocalService) {
		_contactDataTextLocalService = contactDataTextLocalService;
	}

	/**
	* Adds the contact data text to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataText the contact data text
	* @return the contact data text that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText addContactDataText(
		com.leancrm.portlet.library.model.ContactDataText contactDataText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.addContactDataText(contactDataText);
	}

	/**
	* Creates a new contact data text with the primary key. Does not add the contact data text to the database.
	*
	* @param contactDataId the primary key for the new contact data text
	* @return the new contact data text
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText createContactDataText(
		long contactDataId) {
		return _contactDataTextLocalService.createContactDataText(contactDataId);
	}

	/**
	* Deletes the contact data text with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data text
	* @return the contact data text that was removed
	* @throws PortalException if a contact data text with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText deleteContactDataText(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.deleteContactDataText(contactDataId);
	}

	/**
	* Deletes the contact data text from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataText the contact data text
	* @return the contact data text that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText deleteContactDataText(
		com.leancrm.portlet.library.model.ContactDataText contactDataText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.deleteContactDataText(contactDataText);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDataTextLocalService.dynamicQuery();
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
		return _contactDataTextLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataTextLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataTextLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contactDataTextLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactDataTextLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataText fetchContactDataText(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.fetchContactDataText(contactDataId);
	}

	/**
	* Returns the contact data text with the primary key.
	*
	* @param contactDataId the primary key of the contact data text
	* @return the contact data text
	* @throws PortalException if a contact data text with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText getContactDataText(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.getContactDataText(contactDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact data texts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data texts
	* @param end the upper bound of the range of contact data texts (not inclusive)
	* @return the range of contact data texts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactDataText> getContactDataTexts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.getContactDataTexts(start, end);
	}

	/**
	* Returns the number of contact data texts.
	*
	* @return the number of contact data texts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactDataTextsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.getContactDataTextsCount();
	}

	/**
	* Updates the contact data text in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataText the contact data text
	* @return the contact data text that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataText updateContactDataText(
		com.leancrm.portlet.library.model.ContactDataText contactDataText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.updateContactDataText(contactDataText);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactDataTextLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactDataTextLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactDataTextLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataText addContactDataText(
		long contactDataId, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataTextLocalService.addContactDataText(contactDataId,
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
	public void updateContactDataText(long contactId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		java.lang.String value, long addressBookId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataTextLocalService.updateContactDataText(contactId,
			contactDataMethod, value, addressBookId, companyId);
	}

	@Override
	public void removeContactDataText(long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataTextLocalService.removeContactDataText(contactDataId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactDataTextLocalService getWrappedContactDataTextLocalService() {
		return _contactDataTextLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactDataTextLocalService(
		ContactDataTextLocalService contactDataTextLocalService) {
		_contactDataTextLocalService = contactDataTextLocalService;
	}

	@Override
	public ContactDataTextLocalService getWrappedService() {
		return _contactDataTextLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDataTextLocalService contactDataTextLocalService) {
		_contactDataTextLocalService = contactDataTextLocalService;
	}

	private ContactDataTextLocalService _contactDataTextLocalService;
}