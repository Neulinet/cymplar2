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
 * Provides the local service utility for ContactContract. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.ContactContractLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactContractLocalService
 * @see com.leancrm.portlet.library.service.base.ContactContractLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.ContactContractLocalServiceImpl
 * @generated
 */
public class ContactContractLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.ContactContractLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact contract to the database. Also notifies the appropriate model listeners.
	*
	* @param contactContract the contact contract
	* @return the contact contract that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactContract addContactContract(
		com.leancrm.portlet.library.model.ContactContract contactContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactContract(contactContract);
	}

	/**
	* Creates a new contact contract with the primary key. Does not add the contact contract to the database.
	*
	* @param contactContractPK the primary key for the new contact contract
	* @return the new contact contract
	*/
	public static com.leancrm.portlet.library.model.ContactContract createContactContract(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK) {
		return getService().createContactContract(contactContractPK);
	}

	/**
	* Deletes the contact contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactContractPK the primary key of the contact contract
	* @return the contact contract that was removed
	* @throws PortalException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactContract deleteContactContract(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactContract(contactContractPK);
	}

	/**
	* Deletes the contact contract from the database. Also notifies the appropriate model listeners.
	*
	* @param contactContract the contact contract
	* @return the contact contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactContract deleteContactContract(
		com.leancrm.portlet.library.model.ContactContract contactContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactContract(contactContract);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.ContactContract fetchContactContract(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactContract(contactContractPK);
	}

	/**
	* Returns the contact contract with the primary key.
	*
	* @param contactContractPK the primary key of the contact contract
	* @return the contact contract
	* @throws PortalException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactContract getContactContract(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactContract(contactContractPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactContract> getContactContracts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactContracts(start, end);
	}

	/**
	* Returns the number of contact contracts.
	*
	* @return the number of contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactContractsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactContractsCount();
	}

	/**
	* Updates the contact contract in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactContract the contact contract
	* @return the contact contract that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactContract updateContactContract(
		com.leancrm.portlet.library.model.ContactContract contactContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactContract(contactContract);
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

	public static java.util.List<com.leancrm.portlet.library.model.ContactContract> getContactContract(
		java.lang.Long contactId, java.lang.Long contractId) {
		return getService().getContactContract(contactId, contractId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactContract> getByContact(
		java.lang.Long contactId) {
		return getService().getByContact(contactId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.ContactContract> getByContract(
		java.lang.Long contractId) {
		return getService().getByContract(contractId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactContractLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactContractLocalService.class.getName());

			if (invokableLocalService instanceof ContactContractLocalService) {
				_service = (ContactContractLocalService)invokableLocalService;
			}
			else {
				_service = new ContactContractLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactContractLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContactContractLocalService service) {
	}

	private static ContactContractLocalService _service;
}