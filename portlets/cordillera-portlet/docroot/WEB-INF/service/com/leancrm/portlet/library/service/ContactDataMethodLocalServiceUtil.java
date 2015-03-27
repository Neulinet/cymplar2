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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ContactDataMethod. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.ContactDataMethodLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethodLocalService
 * @see com.leancrm.portlet.library.service.base.ContactDataMethodLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.ContactDataMethodLocalServiceImpl
 * @generated
 */
public class ContactDataMethodLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.ContactDataMethodLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact data method to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod addContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactDataMethod(contactDataMethod);
	}

	/**
	* Creates a new contact data method with the primary key. Does not add the contact data method to the database.
	*
	* @param contactDataMethodId the primary key for the new contact data method
	* @return the new contact data method
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod createContactDataMethod(
		long contactDataMethodId) {
		return getService().createContactDataMethod(contactDataMethodId);
	}

	/**
	* Deletes the contact data method with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method that was removed
	* @throws PortalException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod deleteContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactDataMethod(contactDataMethodId);
	}

	/**
	* Deletes the contact data method from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod deleteContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactDataMethod(contactDataMethod);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.leancrm.portlet.library.model.ContactDataMethod fetchContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactDataMethod(contactDataMethodId);
	}

	/**
	* Returns the contact data method with the primary key.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method
	* @throws PortalException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataMethod(contactDataMethodId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> getContactDataMethods(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataMethods(start, end);
	}

	/**
	* Returns the number of contact data methods.
	*
	* @return the number of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactDataMethodsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataMethodsCount();
	}

	/**
	* Updates the contact data method in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethod the contact data method
	* @return the contact data method that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataMethod updateContactDataMethod(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactDataMethod(contactDataMethod);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.leancrm.portlet.library.model.ContactDataMethod addContactDataMethod(
		long companyId, java.lang.String methodName,
		java.lang.String methodTitle, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContactDataMethod(companyId, methodName, methodTitle,
			type);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> getAll() {
		return getService().getAll();
	}

	public static com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethod(
		java.lang.String contactDataMethodId) {
		return getService().getContactDataMethod(contactDataMethodId);
	}

	public static com.leancrm.portlet.library.model.ContactDataMethod getContactDataMethodByName(
		java.lang.String methodName) {
		return getService().getContactDataMethodByName(methodName);
	}

	public static java.util.Map<java.lang.String, com.leancrm.portlet.library.model.ContactDataMethod> getContactDataMethodMap() {
		return getService().getContactDataMethodMap();
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactDataMethodLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactDataMethodLocalService.class.getName());

			if (invokableLocalService instanceof ContactDataMethodLocalService) {
				_service = (ContactDataMethodLocalService)invokableLocalService;
			}
			else {
				_service = new ContactDataMethodLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactDataMethodLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContactDataMethodLocalService service) {
	}

	private static ContactDataMethodLocalService _service;
}