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
 * Provides a wrapper for {@link ContactDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataLocalService
 * @generated
 */
public class ContactDataLocalServiceWrapper implements ContactDataLocalService,
	ServiceWrapper<ContactDataLocalService> {
	public ContactDataLocalServiceWrapper(
		ContactDataLocalService contactDataLocalService) {
		_contactDataLocalService = contactDataLocalService;
	}

	/**
	* Adds the contact data to the database. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData addContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.addContactData(contactData);
	}

	/**
	* Creates a new contact data with the primary key. Does not add the contact data to the database.
	*
	* @param contactDataId the primary key for the new contact data
	* @return the new contact data
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData createContactData(
		long contactDataId) {
		return _contactDataLocalService.createContactData(contactDataId);
	}

	/**
	* Deletes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data that was removed
	* @throws PortalException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData deleteContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.deleteContactData(contactDataId);
	}

	/**
	* Deletes the contact data from the database. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData deleteContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.deleteContactData(contactData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDataLocalService.dynamicQuery();
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
		return _contactDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _contactDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactData fetchContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.fetchContactData(contactDataId);
	}

	/**
	* Returns the contact data with the primary key.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data
	* @throws PortalException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData getContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactData(contactDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @return the range of contact datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDatas(start, end);
	}

	/**
	* Returns the number of contact datas.
	*
	* @return the number of contact datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDatasCount();
	}

	/**
	* Updates the contact data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactData updateContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.updateContactData(contactData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactData addContactData(
		long companyId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		long contactId, long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.addContactData(companyId,
			contactDataMethod, contactId, addressBookId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataList(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDataList(contactId);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataList(
		long contactId, java.lang.String methodName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDataList(contactId, methodName);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataByMethod(
		long contactId, long methodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDataByMethod(contactId,
			methodId);
	}

	@Override
	public void removeByContact(long contactId, long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataLocalService.removeByContact(contactId, addressBookId);
	}

	@Override
	public void removeContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataLocalService.removeContactData(contactData);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataByMethod(
		long methodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.getContactDataByMethod(methodId);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactData setReadOnly(
		long contactDataId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataLocalService.setReadOnly(contactDataId, readOnly);
	}

	@Override
	public void updateReadOnly(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactDataLocalService.updateReadOnly(contactData);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactDataLocalService getWrappedContactDataLocalService() {
		return _contactDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactDataLocalService(
		ContactDataLocalService contactDataLocalService) {
		_contactDataLocalService = contactDataLocalService;
	}

	@Override
	public ContactDataLocalService getWrappedService() {
		return _contactDataLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDataLocalService contactDataLocalService) {
		_contactDataLocalService = contactDataLocalService;
	}

	private ContactDataLocalService _contactDataLocalService;
}