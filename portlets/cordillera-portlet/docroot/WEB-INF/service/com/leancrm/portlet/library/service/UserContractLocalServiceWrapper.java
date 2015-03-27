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
 * Provides a wrapper for {@link UserContractLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserContractLocalService
 * @generated
 */
public class UserContractLocalServiceWrapper implements UserContractLocalService,
	ServiceWrapper<UserContractLocalService> {
	public UserContractLocalServiceWrapper(
		UserContractLocalService userContractLocalService) {
		_userContractLocalService = userContractLocalService;
	}

	/**
	* Adds the user contract to the database. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract addUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.addUserContract(userContract);
	}

	/**
	* Creates a new user contract with the primary key. Does not add the user contract to the database.
	*
	* @param userContractPK the primary key for the new user contract
	* @return the new user contract
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract createUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK) {
		return _userContractLocalService.createUserContract(userContractPK);
	}

	/**
	* Deletes the user contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract that was removed
	* @throws PortalException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract deleteUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.deleteUserContract(userContractPK);
	}

	/**
	* Deletes the user contract from the database. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract deleteUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.deleteUserContract(userContract);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userContractLocalService.dynamicQuery();
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
		return _userContractLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _userContractLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userContractLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.UserContract fetchUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.fetchUserContract(userContractPK);
	}

	/**
	* Returns the user contract with the primary key.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract
	* @throws PortalException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract getUserContract(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.getUserContract(userContractPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.leancrm.portlet.library.model.UserContract> getUserContracts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.getUserContracts(start, end);
	}

	/**
	* Returns the number of user contracts.
	*
	* @return the number of user contracts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserContractsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.getUserContractsCount();
	}

	/**
	* Updates the user contract in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userContract the user contract
	* @return the user contract that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.UserContract updateUserContract(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.updateUserContract(userContract);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userContractLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userContractLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userContractLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.UserContract addUserContract(
		long userId, long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userContractLocalService.addUserContract(userId, contractId);
	}

	@Override
	public com.leancrm.portlet.library.model.Contract getByUserContract(
		long userId, long contractId) {
		return _userContractLocalService.getByUserContract(userId, contractId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserContractLocalService getWrappedUserContractLocalService() {
		return _userContractLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserContractLocalService(
		UserContractLocalService userContractLocalService) {
		_userContractLocalService = userContractLocalService;
	}

	@Override
	public UserContractLocalService getWrappedService() {
		return _userContractLocalService;
	}

	@Override
	public void setWrappedService(
		UserContractLocalService userContractLocalService) {
		_userContractLocalService = userContractLocalService;
	}

	private UserContractLocalService _userContractLocalService;
}