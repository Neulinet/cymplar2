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
 * Provides a wrapper for {@link EnterpriseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnterpriseLocalService
 * @generated
 */
public class EnterpriseLocalServiceWrapper implements EnterpriseLocalService,
	ServiceWrapper<EnterpriseLocalService> {
	public EnterpriseLocalServiceWrapper(
		EnterpriseLocalService enterpriseLocalService) {
		_enterpriseLocalService = enterpriseLocalService;
	}

	/**
	* Adds the enterprise to the database. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise addEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.addEnterprise(enterprise);
	}

	/**
	* Creates a new enterprise with the primary key. Does not add the enterprise to the database.
	*
	* @param enterpriseId the primary key for the new enterprise
	* @return the new enterprise
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise createEnterprise(
		long enterpriseId) {
		return _enterpriseLocalService.createEnterprise(enterpriseId);
	}

	/**
	* Deletes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise that was removed
	* @throws PortalException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise deleteEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.deleteEnterprise(enterpriseId);
	}

	/**
	* Deletes the enterprise from the database. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise deleteEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.deleteEnterprise(enterprise);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enterpriseLocalService.dynamicQuery();
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
		return _enterpriseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enterpriseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enterpriseLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _enterpriseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _enterpriseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.Enterprise fetchEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.fetchEnterprise(enterpriseId);
	}

	/**
	* Returns the enterprise with the primary key.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise
	* @throws PortalException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise getEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getEnterprise(enterpriseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the enterprises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @return the range of enterprises
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterprises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getEnterprises(start, end);
	}

	/**
	* Returns the number of enterprises.
	*
	* @return the number of enterprises
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEnterprisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getEnterprisesCount();
	}

	/**
	* Updates the enterprise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise updateEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.updateEnterprise(enterprise);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enterpriseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enterpriseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enterpriseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.leancrm.portlet.library.model.Enterprise addEnterprise(
		java.lang.String name, long companyId, java.lang.String taxid,
		java.lang.String description, java.lang.String email, long industry,
		boolean isPrivate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.addEnterprise(name, companyId, taxid,
			description, email, industry, isPrivate);
	}

	/**
	* @param actionRequest
	* @param actionResponse
	* @throws SystemException
	* @throws PortalException
	* @throws NumberFormatException
	*/
	@Override
	public com.leancrm.portlet.library.model.Enterprise addEnterprise(
		long companyId, long userId, java.lang.String name,
		java.lang.String taxId, java.lang.String countryId,
		java.lang.String description, java.lang.String email,
		java.lang.String industry, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zipCode, java.lang.String city, boolean isPrivate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _enterpriseLocalService.addEnterprise(companyId, userId, name,
			taxId, countryId, description, email, industry, street1, street2,
			street3, zipCode, city, isPrivate);
	}

	@Override
	public com.leancrm.portlet.library.model.Enterprise updateEnterprise(
		long enterpriseId, long companyId, long userId, java.lang.String name,
		java.lang.String taxId, java.lang.String countryId,
		java.lang.String description, java.lang.String email,
		java.lang.String industry, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zipCode, java.lang.String city, boolean isPrivate)
		throws java.lang.Exception {
		return _enterpriseLocalService.updateEnterprise(enterpriseId,
			companyId, userId, name, taxId, countryId, description, email,
			industry, street1, street2, street3, zipCode, city, isPrivate);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getAll();
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterpriseByTax(
		java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getEnterpriseByTax(taxid);
	}

	@Override
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterpriseByIndustryId(
		long industryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enterpriseLocalService.getEnterpriseByIndustryId(industryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnterpriseLocalService getWrappedEnterpriseLocalService() {
		return _enterpriseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnterpriseLocalService(
		EnterpriseLocalService enterpriseLocalService) {
		_enterpriseLocalService = enterpriseLocalService;
	}

	@Override
	public EnterpriseLocalService getWrappedService() {
		return _enterpriseLocalService;
	}

	@Override
	public void setWrappedService(EnterpriseLocalService enterpriseLocalService) {
		_enterpriseLocalService = enterpriseLocalService;
	}

	private EnterpriseLocalService _enterpriseLocalService;
}