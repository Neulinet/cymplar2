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
 * Provides the local service utility for AddressBookContact. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.AddressBookContactLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactLocalService
 * @see com.leancrm.portlet.library.service.base.AddressBookContactLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.AddressBookContactLocalServiceImpl
 * @generated
 */
public class AddressBookContactLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.AddressBookContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the address book contact to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact addAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAddressBookContact(addressBookContact);
	}

	/**
	* Creates a new address book contact with the primary key. Does not add the address book contact to the database.
	*
	* @param addressBookContactPK the primary key for the new address book contact
	* @return the new address book contact
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact createAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK) {
		return getService().createAddressBookContact(addressBookContactPK);
	}

	/**
	* Deletes the address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact that was removed
	* @throws PortalException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact deleteAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAddressBookContact(addressBookContactPK);
	}

	/**
	* Deletes the address book contact from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact deleteAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAddressBookContact(addressBookContact);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.AddressBookContact fetchAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAddressBookContact(addressBookContactPK);
	}

	/**
	* Returns the address book contact with the primary key.
	*
	* @param addressBookContactPK the primary key of the address book contact
	* @return the address book contact
	* @throws PortalException if a address book contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact getAddressBookContact(
		com.leancrm.portlet.library.service.persistence.AddressBookContactPK addressBookContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContact(addressBookContactPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getAddressBookContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContacts(start, end);
	}

	/**
	* Returns the number of address book contacts.
	*
	* @return the number of address book contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int getAddressBookContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContactsCount();
	}

	/**
	* Updates the address book contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookContact the address book contact
	* @return the address book contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContact updateAddressBookContact(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAddressBookContact(addressBookContact);
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

	public static void copyContact(long contactId, long addressBookFrom,
		long addressBookTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().copyContact(contactId, addressBookFrom, addressBookTo);
	}

	/**
	* Remove all contacts related to an address book.
	*
	* @param addressBookId
	* @throws SystemException
	*/
	public static void removeAddressBookContact(long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeAddressBookContact(addressBookId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByAddressBook(addressBookId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByContact(contactId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.Contact> getContacts(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContacts(addressBookId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContact> getContactsByAddressBook(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsByAddressBook(addressBookId);
	}

	public static java.util.Map<java.lang.Long, com.leancrm.portlet.library.model.AddressBookContact> getContactsByAddressBookAsMap(
		long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsByAddressBookAsMap(addressBookId);
	}

	public static int countAddressBook(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAddressBook(contactId);
	}

	public static boolean hasContact(long addressBookId, long contactId) {
		return getService().hasContact(addressBookId, contactId);
	}

	/**
	* Return first address book there contact appears
	*
	* @param contactId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.leancrm.portlet.library.model.AddressBook getFirstAddressBook(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFirstAddressBook(contactId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AddressBookContactLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AddressBookContactLocalService.class.getName());

			if (invokableLocalService instanceof AddressBookContactLocalService) {
				_service = (AddressBookContactLocalService)invokableLocalService;
			}
			else {
				_service = new AddressBookContactLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AddressBookContactLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AddressBookContactLocalService service) {
	}

	private static AddressBookContactLocalService _service;
}