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
 * Provides the local service utility for AddressBookOrganization. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.AddressBookOrganizationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganizationLocalService
 * @see com.leancrm.portlet.library.service.base.AddressBookOrganizationLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.AddressBookOrganizationLocalServiceImpl
 * @generated
 */
public class AddressBookOrganizationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.AddressBookOrganizationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the address book organization to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookOrganization the address book organization
	* @return the address book organization that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization addAddressBookOrganization(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAddressBookOrganization(addressBookOrganization);
	}

	/**
	* Creates a new address book organization with the primary key. Does not add the address book organization to the database.
	*
	* @param addressBookId the primary key for the new address book organization
	* @return the new address book organization
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization createAddressBookOrganization(
		long addressBookId) {
		return getService().createAddressBookOrganization(addressBookId);
	}

	/**
	* Deletes the address book organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization that was removed
	* @throws PortalException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization deleteAddressBookOrganization(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAddressBookOrganization(addressBookId);
	}

	/**
	* Deletes the address book organization from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookOrganization the address book organization
	* @return the address book organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization deleteAddressBookOrganization(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteAddressBookOrganization(addressBookOrganization);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.AddressBookOrganization fetchAddressBookOrganization(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAddressBookOrganization(addressBookId);
	}

	/**
	* Returns the address book organization with the primary key.
	*
	* @param addressBookId the primary key of the address book organization
	* @return the address book organization
	* @throws PortalException if a address book organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization getAddressBookOrganization(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookOrganization(addressBookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the address book organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address book organizations
	* @param end the upper bound of the range of address book organizations (not inclusive)
	* @return the range of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> getAddressBookOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookOrganizations(start, end);
	}

	/**
	* Returns the number of address book organizations.
	*
	* @return the number of address book organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int getAddressBookOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookOrganizationsCount();
	}

	/**
	* Updates the address book organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookOrganization the address book organization
	* @return the address book organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookOrganization updateAddressBookOrganization(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAddressBookOrganization(addressBookOrganization);
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

	public static java.util.List<com.leancrm.portlet.library.model.AddressBookOrganization> getAddressBookOrganizationList(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookOrganizationList(organizationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AddressBookOrganizationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AddressBookOrganizationLocalService.class.getName());

			if (invokableLocalService instanceof AddressBookOrganizationLocalService) {
				_service = (AddressBookOrganizationLocalService)invokableLocalService;
			}
			else {
				_service = new AddressBookOrganizationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AddressBookOrganizationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AddressBookOrganizationLocalService service) {
	}

	private static AddressBookOrganizationLocalService _service;
}