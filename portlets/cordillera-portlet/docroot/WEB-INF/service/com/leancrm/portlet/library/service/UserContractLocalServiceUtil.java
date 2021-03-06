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
 * Provides the local service utility for UserContract. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.UserContractLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserContractLocalService
 * @see com.leancrm.portlet.library.service.base.UserContractLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.UserContractLocalServiceImpl
 * @generated
 */
public class UserContractLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.UserContractLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user contract to the database. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract addUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserContract(userContract);
	}

	/**
	* Creates a new user contract with the primary key. Does not add the user contract to the database.
	*
	* @param userContractPK the primary key for the new user contract
	* @return the new user contract
	*/
	public static com.leancrm.portlet.library.model.UserContract createUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK) {
		return getService().createUserContract(userContractPK);
	}

	/**
	* Deletes the user contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract that was removed
	* @throws PortalException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract deleteUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserContract(userContractPK);
	}

	/**
	* Deletes the user contract from the database. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract deleteUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserContract(userContract);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.leancrm.portlet.library.model.UserContract fetchUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserContract(userContractPK);
	}

	/**
	* Returns the user contract with the primary key.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract
	* @throws PortalException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract getUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserContract(userContractPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> getUserContracts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserContracts(start, end);
	}

	/**
	* Returns the number of user contracts.
	*
	* @return the number of user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserContractsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserContractsCount();
	}

	/**
	* Updates the user contract in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract updateUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserContract(userContract);
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

	public static com.leancrm.portlet.library.model.UserContract addUserContract(
		long userId, long contractId, int accessLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserContract(userId, contractId, accessLevel);
	}

	public static com.leancrm.portlet.library.model.UserContract getByUserContract(
		long userId, long contractId) {
		return getService().getByUserContract(userId, contractId);
	}

	public static com.liferay.portal.model.User getContractOwner(
		long contractId) {
		return getService().getContractOwner(contractId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserContractLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserContractLocalService.class.getName());

			if (invokableLocalService instanceof UserContractLocalService) {
				_service = (UserContractLocalService)invokableLocalService;
			}
			else {
				_service = new UserContractLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserContractLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserContractLocalService service) {
	}

	private static UserContractLocalService _service;
}