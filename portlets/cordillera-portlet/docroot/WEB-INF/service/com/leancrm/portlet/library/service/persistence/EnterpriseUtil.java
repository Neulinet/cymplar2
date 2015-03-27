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

import com.leancrm.portlet.library.model.Enterprise;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the enterprise service. This utility wraps {@link EnterprisePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnterprisePersistence
 * @see EnterprisePersistenceImpl
 * @generated
 */
public class EnterpriseUtil {
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
	public static void clearCache(Enterprise enterprise) {
		getPersistence().clearCache(enterprise);
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
	public static List<Enterprise> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Enterprise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Enterprise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Enterprise update(Enterprise enterprise)
		throws SystemException {
		return getPersistence().update(enterprise);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Enterprise update(Enterprise enterprise,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(enterprise, serviceContext);
	}

	/**
	* Returns all the enterprises where name = &#63;.
	*
	* @param name the name
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the enterprises where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @return the range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the enterprises where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the enterprises before and after the current enterprise in the ordered set where name = &#63;.
	*
	* @param enterpriseId the primary key of the current enterprise
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise[] findByName_PrevAndNext(
		long enterpriseId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_PrevAndNext(enterpriseId, name, orderByComparator);
	}

	/**
	* Removes all the enterprises where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of enterprises where name = &#63;.
	*
	* @param name the name
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the enterprises where taxid = &#63;.
	*
	* @param taxid the taxid
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxid(taxid);
	}

	/**
	* Returns a range of all the enterprises where taxid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxid the taxid
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @return the range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxid(taxid, start, end);
	}

	/**
	* Returns an ordered range of all the enterprises where taxid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxid the taxid
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxid(taxid, start, end, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByTaxid_First(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxid_First(taxid, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByTaxid_First(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTaxid_First(taxid, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByTaxid_Last(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxid_Last(taxid, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByTaxid_Last(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTaxid_Last(taxid, orderByComparator);
	}

	/**
	* Returns the enterprises before and after the current enterprise in the ordered set where taxid = &#63;.
	*
	* @param enterpriseId the primary key of the current enterprise
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise[] findByTaxid_PrevAndNext(
		long enterpriseId, java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaxid_PrevAndNext(enterpriseId, taxid,
			orderByComparator);
	}

	/**
	* Removes all the enterprises where taxid = &#63; from the database.
	*
	* @param taxid the taxid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaxid(java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaxid(taxid);
	}

	/**
	* Returns the number of enterprises where taxid = &#63;.
	*
	* @param taxid the taxid
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaxid(java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaxid(taxid);
	}

	/**
	* Returns all the enterprises where industry = &#63;.
	*
	* @param industry the industry
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIndustry(industry);
	}

	/**
	* Returns a range of all the enterprises where industry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param industry the industry
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @return the range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIndustry(industry, start, end);
	}

	/**
	* Returns an ordered range of all the enterprises where industry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param industry the industry
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIndustry(industry, start, end, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByIndustry_First(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIndustry_First(industry, orderByComparator);
	}

	/**
	* Returns the first enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByIndustry_First(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIndustry_First(industry, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByIndustry_Last(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIndustry_Last(industry, orderByComparator);
	}

	/**
	* Returns the last enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByIndustry_Last(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIndustry_Last(industry, orderByComparator);
	}

	/**
	* Returns the enterprises before and after the current enterprise in the ordered set where industry = &#63;.
	*
	* @param enterpriseId the primary key of the current enterprise
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise[] findByIndustry_PrevAndNext(
		long enterpriseId, long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIndustry_PrevAndNext(enterpriseId, industry,
			orderByComparator);
	}

	/**
	* Removes all the enterprises where industry = &#63; from the database.
	*
	* @param industry the industry
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIndustry(long industry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIndustry(industry);
	}

	/**
	* Returns the number of enterprises where industry = &#63;.
	*
	* @param industry the industry
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIndustry(long industry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIndustry(industry);
	}

	/**
	* Caches the enterprise in the entity cache if it is enabled.
	*
	* @param enterprise the enterprise
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.Enterprise enterprise) {
		getPersistence().cacheResult(enterprise);
	}

	/**
	* Caches the enterprises in the entity cache if it is enabled.
	*
	* @param enterprises the enterprises
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Enterprise> enterprises) {
		getPersistence().cacheResult(enterprises);
	}

	/**
	* Creates a new enterprise with the primary key. Does not add the enterprise to the database.
	*
	* @param enterpriseId the primary key for the new enterprise
	* @return the new enterprise
	*/
	public static com.leancrm.portlet.library.model.Enterprise create(
		long enterpriseId) {
		return getPersistence().create(enterpriseId);
	}

	/**
	* Removes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise that was removed
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise remove(
		long enterpriseId)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enterpriseId);
	}

	public static com.leancrm.portlet.library.model.Enterprise updateImpl(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enterprise);
	}

	/**
	* Returns the enterprise with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchEnterpriseException} if it could not be found.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise findByPrimaryKey(
		long enterpriseId)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enterpriseId);
	}

	/**
	* Returns the enterprise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise, or <code>null</code> if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise fetchByPrimaryKey(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enterpriseId);
	}

	/**
	* Returns all the enterprises.
	*
	* @return the enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the enterprises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enterprises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enterprises.
	*
	* @return the number of enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnterprisePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnterprisePersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					EnterprisePersistence.class.getName());

			ReferenceRegistry.registerReference(EnterpriseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EnterprisePersistence persistence) {
	}

	private static EnterprisePersistence _persistence;
}