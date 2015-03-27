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

package com.leancrm.portlet.library.service.persistence;

import com.leancrm.portlet.library.model.OrganizationIndustry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the organization industry service. This utility wraps {@link OrganizationIndustryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationIndustryPersistence
 * @see OrganizationIndustryPersistenceImpl
 * @generated
 */
public class OrganizationIndustryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(OrganizationIndustry organizationIndustry) {
		getPersistence().clearCache(organizationIndustry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationIndustry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationIndustry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationIndustry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrganizationIndustry update(
		OrganizationIndustry organizationIndustry) throws SystemException {
		return getPersistence().update(organizationIndustry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrganizationIndustry update(
		OrganizationIndustry organizationIndustry, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(organizationIndustry, serviceContext);
	}

	/**
	* Caches the organization industry in the entity cache if it is enabled.
	*
	* @param organizationIndustry the organization industry
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry) {
		getPersistence().cacheResult(organizationIndustry);
	}

	/**
	* Caches the organization industries in the entity cache if it is enabled.
	*
	* @param organizationIndustries the organization industries
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.OrganizationIndustry> organizationIndustries) {
		getPersistence().cacheResult(organizationIndustries);
	}

	/**
	* Creates a new organization industry with the primary key. Does not add the organization industry to the database.
	*
	* @param organizationIndustryPK the primary key for the new organization industry
	* @return the new organization industry
	*/
	public static com.leancrm.portlet.library.model.OrganizationIndustry create(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK) {
		return getPersistence().create(organizationIndustryPK);
	}

	/**
	* Removes the organization industry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationIndustryPK the primary key of the organization industry
	* @return the organization industry that was removed
	* @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.OrganizationIndustry remove(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(organizationIndustryPK);
	}

	public static com.leancrm.portlet.library.model.OrganizationIndustry updateImpl(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(organizationIndustry);
	}

	/**
	* Returns the organization industry with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchOrganizationIndustryException} if it could not be found.
	*
	* @param organizationIndustryPK the primary key of the organization industry
	* @return the organization industry
	* @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.OrganizationIndustry findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(organizationIndustryPK);
	}

	/**
	* Returns the organization industry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param organizationIndustryPK the primary key of the organization industry
	* @return the organization industry, or <code>null</code> if a organization industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.OrganizationIndustry fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.OrganizationIndustryPK organizationIndustryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(organizationIndustryPK);
	}

	/**
	* Returns all the organization industries.
	*
	* @return the organization industries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.OrganizationIndustry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.leancrm.portlet.library.model.OrganizationIndustry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the organization industries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization industries
	* @param end the upper bound of the range of organization industries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organization industries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.OrganizationIndustry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the organization industries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organization industries.
	*
	* @return the number of organization industries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrganizationIndustryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrganizationIndustryPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					OrganizationIndustryPersistence.class.getName());

			ReferenceRegistry.registerReference(OrganizationIndustryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrganizationIndustryPersistence persistence) {
	}

	private static OrganizationIndustryPersistence _persistence;
}