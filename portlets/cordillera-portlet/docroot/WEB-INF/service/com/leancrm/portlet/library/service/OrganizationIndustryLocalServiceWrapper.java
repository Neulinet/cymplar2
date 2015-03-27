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
 * Provides a wrapper for {@link OrganizationIndustryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationIndustryLocalService
 * @generated
 */
public class OrganizationIndustryLocalServiceWrapper
	implements OrganizationIndustryLocalService,
		ServiceWrapper<OrganizationIndustryLocalService> {
	public OrganizationIndustryLocalServiceWrapper(
		OrganizationIndustryLocalService organizationIndustryLocalService) {
		_organizationIndustryLocalService = organizationIndustryLocalService;
	}

	/**
	* Adds the organization industry to the database. Also notifies the appropriate model listeners.
	*
	* @param organizationIndustry the organization industry
	* @return the organization industry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry addOrganizationIndustry(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.addOrganizationIndustry(organizationIndustry);
	}

	/**
	* Creates a new organization industry with the primary key. Does not add the organization industry to the database.
	*
	* @param organizationIndustryPK the primary key for the new organization industry
	* @return the new organization industry
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry createOrganizationIndustry(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK) {
		return _organizationIndustryLocalService.createOrganizationIndustry(organizationIndustryPK);
	}

	/**
	* Deletes the organization industry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationIndustryPK the primary key of the organization industry
	* @return the organization industry that was removed
	* @throws PortalException if a organization industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry deleteOrganizationIndustry(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.deleteOrganizationIndustry(organizationIndustryPK);
	}

	/**
	* Deletes the organization industry from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationIndustry the organization industry
	* @return the organization industry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry deleteOrganizationIndustry(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.deleteOrganizationIndustry(organizationIndustry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationIndustryLocalService.dynamicQuery();
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
		return _organizationIndustryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationIndustryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationIndustryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _organizationIndustryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizationIndustryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry fetchOrganizationIndustry(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.fetchOrganizationIndustry(organizationIndustryPK);
	}

	/**
	* Returns the organization industry with the primary key.
	*
	* @param organizationIndustryPK the primary key of the organization industry
	* @return the organization industry
	* @throws PortalException if a organization industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry getOrganizationIndustry(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.getOrganizationIndustry(organizationIndustryPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organization industries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization industries
	* @param end the upper bound of the range of organization industries (not inclusive)
	* @return the range of organization industries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.leancrm.portlet.library.model.OrganizationIndustry> getOrganizationIndustries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.getOrganizationIndustries(start,
			end);
	}

	/**
	* Returns the number of organization industries.
	*
	* @return the number of organization industries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganizationIndustriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.getOrganizationIndustriesCount();
	}

	/**
	* Updates the organization industry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizationIndustry the organization industry
	* @return the organization industry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.leancrm.portlet.library.model.OrganizationIndustry updateOrganizationIndustry(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationIndustryLocalService.updateOrganizationIndustry(organizationIndustry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizationIndustryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizationIndustryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizationIndustryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizationIndustryLocalService getWrappedOrganizationIndustryLocalService() {
		return _organizationIndustryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizationIndustryLocalService(
		OrganizationIndustryLocalService organizationIndustryLocalService) {
		_organizationIndustryLocalService = organizationIndustryLocalService;
	}

	@Override
	public OrganizationIndustryLocalService getWrappedService() {
		return _organizationIndustryLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationIndustryLocalService organizationIndustryLocalService) {
		_organizationIndustryLocalService = organizationIndustryLocalService;
	}

	private OrganizationIndustryLocalService _organizationIndustryLocalService;
}