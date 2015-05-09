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
 * Provides the local service utility for AddressBookContactData. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.AddressBookContactDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactDataLocalService
 * @see com.leancrm.portlet.library.service.base.AddressBookContactDataLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.AddressBookContactDataLocalServiceImpl
 * @generated
 */
public class AddressBookContactDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.AddressBookContactDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the address book contact data to the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData addAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAddressBookContactData(addressBookContactData);
	}

	/**
	* Creates a new address book contact data with the primary key. Does not add the address book contact data to the database.
	*
	* @param addressBookContactDataPK the primary key for the new address book contact data
	* @return the new address book contact data
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData createAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK) {
		return getService()
				   .createAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Deletes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data that was removed
	* @throws PortalException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData deleteAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Deletes the address book contact data from the database. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData deleteAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAddressBookContactData(addressBookContactData);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.AddressBookContactData fetchAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAddressBookContactData(addressBookContactDataPK);
	}

	/**
	* Returns the address book contact data with the primary key.
	*
	* @param addressBookContactDataPK the primary key of the address book contact data
	* @return the address book contact data
	* @throws PortalException if a address book contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData getAddressBookContactData(
		com.leancrm.portlet.library.service.persistence.AddressBookContactDataPK addressBookContactDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContactData(addressBookContactDataPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.leancrm.portlet.library.model.AddressBookContactData> getAddressBookContactDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContactDatas(start, end);
	}

	/**
	* Returns the number of address book contact datas.
	*
	* @return the number of address book contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getAddressBookContactDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAddressBookContactDatasCount();
	}

	/**
	* Updates the address book contact data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressBookContactData the address book contact data
	* @return the address book contact data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.AddressBookContactData updateAddressBookContactData(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAddressBookContactData(addressBookContactData);
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

	public static void copyContactData(long contactDataId,
		long addressBookFrom, long addressBookTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.copyContactData(contactDataId, addressBookFrom, addressBookTo);
	}

	/**
	* Remove in cascade.
	* Remove all contact data related to an address book and remove all not read only contact data associated with this.
	*
	* @param addressBookId
	* @throws SystemException
	* @throws PortalException
	*/
	public static void removerContactDatas(long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removerContactDatas(addressBookId);
	}

	public static void removeContactData(long contactDataId, long addressBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeContactData(contactDataId, addressBookId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactData(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactData(addressBook, contactId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataImpl(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataImpl(addressBook, contactId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactData(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactData(addressBook);
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
	public static java.util.Map<java.lang.String, com.leancrm.portlet.library.model.ContactData> getContactDataGroupByMethod(
		com.leancrm.portlet.library.model.AddressBook addressBook,
		java.lang.Long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataGroupByMethod(addressBook, contactId);
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
	public static com.leancrm.portlet.library.model.ContactData getContactData(
		long addressBookId, long contactId, long methodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactData(addressBookId, contactId, methodId);
	}

	public static int getAddressBookContactDatasCount(long contactDataId) {
		return getService().getAddressBookContactDatasCount(contactDataId);
	}

	public static boolean hasContactData(long addressBookId, long contactDataId) {
		return getService().hasContactData(addressBookId, contactDataId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AddressBookContactDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AddressBookContactDataLocalService.class.getName());

			if (invokableLocalService instanceof AddressBookContactDataLocalService) {
				_service = (AddressBookContactDataLocalService)invokableLocalService;
			}
			else {
				_service = new AddressBookContactDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AddressBookContactDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AddressBookContactDataLocalService service) {
	}

	private static AddressBookContactDataLocalService _service;
}