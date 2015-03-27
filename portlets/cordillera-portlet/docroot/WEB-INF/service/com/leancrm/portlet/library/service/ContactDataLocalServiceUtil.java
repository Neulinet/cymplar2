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
 * Provides the local service utility for ContactData. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.ContactDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataLocalService
 * @see com.leancrm.portlet.library.service.base.ContactDataLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.ContactDataLocalServiceImpl
 * @generated
 */
public class ContactDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.ContactDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact data to the database. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData addContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactData(contactData);
	}

	/**
	* Creates a new contact data with the primary key. Does not add the contact data to the database.
	*
	* @param contactDataId the primary key for the new contact data
	* @return the new contact data
	*/
	public static com.leancrm.portlet.library.model.ContactData createContactData(
		long contactDataId) {
		return getService().createContactData(contactDataId);
	}

	/**
	* Deletes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data that was removed
	* @throws PortalException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData deleteContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactData(contactDataId);
	}

	/**
	* Deletes the contact data from the database. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData deleteContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactData(contactData);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.ContactData fetchContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactData(contactDataId);
	}

	/**
	* Returns the contact data with the primary key.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data
	* @throws PortalException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData getContactData(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactData(contactDataId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDatas(start, end);
	}

	/**
	* Returns the number of contact datas.
	*
	* @return the number of contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDatasCount();
	}

	/**
	* Updates the contact data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactData the contact data
	* @return the contact data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData updateContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactData(contactData);
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

	public static com.leancrm.portlet.library.model.ContactData addContactData(
		long companyId,
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod,
		long contactId, long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContactData(companyId, contactDataMethod, contactId,
			addressBookId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataList(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataList(contactId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataList(
		long contactId, java.lang.String methodName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataList(contactId, methodName);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataByMethod(
		long contactId, long methodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataByMethod(contactId, methodId);
	}

	public static void removeByContact(long contactId, long addressBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeByContact(contactId, addressBookId);
	}

	public static void removeContactData(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeContactData(contactData);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactData> getContactDataByMethod(
		long methodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactDataByMethod(methodId);
	}

	public static com.leancrm.portlet.library.model.ContactData setReadOnly(
		long contactDataId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().setReadOnly(contactDataId, readOnly);
	}

	public static void updateReadOnly(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateReadOnly(contactData);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactDataLocalService.class.getName());

			if (invokableLocalService instanceof ContactDataLocalService) {
				_service = (ContactDataLocalService)invokableLocalService;
			}
			else {
				_service = new ContactDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContactDataLocalService service) {
	}

	private static ContactDataLocalService _service;
}