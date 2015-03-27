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
 * Provides the local service utility for ContactDataPhone. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.ContactDataPhoneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhoneLocalService
 * @see com.leancrm.portlet.library.service.base.ContactDataPhoneLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.ContactDataPhoneLocalServiceImpl
 * @generated
 */
public class ContactDataPhoneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.ContactDataPhoneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact data phone to the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone addContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactDataPhone(contactDataPhone);
	}

	/**
	* Creates a new contact data phone with the primary key. Does not add the contact data phone to the database.
	*
	* @param contactDataId the primary key for the new contact data phone
	* @return the new contact data phone
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone createContactDataPhone(
		long contactDataId) {
		return getService().createContactDataPhone(contactDataId);
	}

	/**
	* Deletes the contact data phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone that was removed
	* @throws PortalException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone deleteContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactDataPhone(contactDataId);
	}

	/**
	* Deletes the contact data phone from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone deleteContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactDataPhone(contactDataPhone);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.ContactDataPhone fetchContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactDataPhone(contactDataId);
	}

	/**
	* Returns the contact data phone with the primary key.
	*
	* @param contactDataId the primary key of the contact data phone
	* @return the contact data phone
	* @throws PortalException if a contact data phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone getContactDataPhone(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataPhone(contactDataId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.leancrm.portlet.library.model.ContactDataPhone> getContactDataPhones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataPhones(start, end);
	}

	/**
	* Returns the number of contact data phones.
	*
	* @return the number of contact data phones
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactDataPhonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataPhonesCount();
	}

	/**
	* Updates the contact data phone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactDataPhone the contact data phone
	* @return the contact data phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactDataPhone updateContactDataPhone(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactDataPhone(contactDataPhone);
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

	public static com.leancrm.portlet.library.model.ContactDataPhone addContactDataPhone(
		long contactDataId, java.lang.String number, java.lang.String extension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactDataPhone(contactDataId, number, extension);
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
	public static void updateContactDataPhone(long contactId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		java.lang.String number, java.lang.String extension,
		long addressBookId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateContactDataPhone(contactId, contactDataMethod, number,
			extension, addressBookId, companyId);
	}

	public static java.lang.String getPhoneNumber(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone) {
		return getService().getPhoneNumber(contactDataPhone);
	}

	public static void removeContactDataPhone(long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeContactDataPhone(contactDataId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactDataPhoneLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactDataPhoneLocalService.class.getName());

			if (invokableLocalService instanceof ContactDataPhoneLocalService) {
				_service = (ContactDataPhoneLocalService)invokableLocalService;
			}
			else {
				_service = new ContactDataPhoneLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactDataPhoneLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContactDataPhoneLocalService service) {
	}

	private static ContactDataPhoneLocalService _service;
}