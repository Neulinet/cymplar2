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
 * Provides a wrapper for {@link ContactDataMethodLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethodLocalService
 * @generated
 */
public class ContactDataMethodLocalServiceWrapper
	implements ContactDataMethodLocalService,
		ServiceWrapper<ContactDataMethodLocalService> {
	public ContactDataMethodLocalServiceWrapper(
		ContactDataMethodLocalService contactDataMethodLocalService) {
		_contactDataMethodLocalService = contactDataMethodLocalService;
	}

	/**
	* Adds the contact data method to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod addContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.addContactDataMethod(contactDataMethod);
	}

	/**
	* Creates a new contact data method with the primary key. Does not add the contact data method to the database.
	*
	* @param contactDataMethodId the primary key for the new contact data method
	* @return the new contact data method
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod createContactDataMethod(
		long contactDataMethodId) {
		return _contactDataMethodLocalService.createContactDataMethod(contactDataMethodId);
	}

	/**
	* Deletes the contact data method with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method that was removed
	* @throws PortalException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod deleteContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.deleteContactDataMethod(contactDataMethodId);
	}

	/**
	* Deletes the contact data method from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod deleteContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.deleteContactDataMethod(contactDataMethod);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDataMethodLocalService.dynamicQuery();
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
		return _contactDataMethodLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataMethodLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactDataMethodLocalService.dynamicQuery(dynamicQuery, start,
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
		return _contactDataMethodLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactDataMethodLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod fetchContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.fetchContactDataMethod(contactDataMethodId);
	}

	/**
	* Returns the contact data method with the primary key.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method
	* @throws PortalException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.getContactDataMethod(contactDataMethodId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact data methods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data methods
	* @param end the upper bound of the range of contact data methods (not inclusive)
	* @return the range of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> getContactDataMethods(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.getContactDataMethods(start, end);
	}

	/**
	* Returns the number of contact data methods.
	*
	* @return the number of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactDataMethodsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.getContactDataMethodsCount();
	}

	/**
	* Updates the contact data method in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod updateContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.updateContactDataMethod(contactDataMethod);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactDataMethodLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactDataMethodLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactDataMethodLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod addContactDataMethod(
		long companyId, java.lang.String methodName,
		java.lang.String methodTitle, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDataMethodLocalService.addContactDataMethod(companyId,
			methodName, methodTitle, type);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> getAll() {
		return _contactDataMethodLocalService.getAll();
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethod(
		java.lang.String contactDataMethodId) {
		return _contactDataMethodLocalService.getContactDataMethod(contactDataMethodId);
	}

	@Override
	public com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethodByName(
		java.lang.String methodName) {
		return _contactDataMethodLocalService.getContactDataMethodByName(methodName);
	}

	@Override
	public java.util.Map<java.lang.String, com.leancrm.portlet.library.model.ContactDataMethod> getContactDataMethodMap() {
		return _contactDataMethodLocalService.getContactDataMethodMap();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactDataMethodLocalService getWrappedContactDataMethodLocalService() {
		return _contactDataMethodLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactDataMethodLocalService(
		ContactDataMethodLocalService contactDataMethodLocalService) {
		_contactDataMethodLocalService = contactDataMethodLocalService;
	}

	@Override
	public ContactDataMethodLocalService getWrappedService() {
		return _contactDataMethodLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDataMethodLocalService contactDataMethodLocalService) {
		_contactDataMethodLocalService = contactDataMethodLocalService;
	}

	private ContactDataMethodLocalService _contactDataMethodLocalService;
}