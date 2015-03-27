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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the enterprise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnterprisePersistenceImpl
 * @see EnterpriseUtil
 * @generated
 */
public interface EnterprisePersistence extends BasePersistence<Enterprise> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnterpriseUtil} to access the enterprise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the enterprises where name = &#63;.
	*
	* @param name the name
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Enterprise[] findByName_PrevAndNext(
		long enterpriseId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enterprises where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enterprises where name = &#63;.
	*
	* @param name the name
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enterprises where taxid = &#63;.
	*
	* @param taxid the taxid
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByTaxid(
		java.lang.String taxid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByTaxid_First(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByTaxid_First(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByTaxid_Last(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where taxid = &#63;.
	*
	* @param taxid the taxid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByTaxid_Last(
		java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Enterprise[] findByTaxid_PrevAndNext(
		long enterpriseId, java.lang.String taxid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enterprises where taxid = &#63; from the database.
	*
	* @param taxid the taxid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaxid(java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enterprises where taxid = &#63;.
	*
	* @param taxid the taxid
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaxid(java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enterprises where industry = &#63;.
	*
	* @param industry the industry
	* @return the matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findByIndustry(
		long industry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByIndustry_First(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByIndustry_First(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByIndustry_Last(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last enterprise in the ordered set where industry = &#63;.
	*
	* @param industry the industry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByIndustry_Last(
		long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Enterprise[] findByIndustry_PrevAndNext(
		long enterpriseId, long industry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enterprises where industry = &#63; from the database.
	*
	* @param industry the industry
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIndustry(long industry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enterprises where industry = &#63;.
	*
	* @param industry the industry
	* @return the number of matching enterprises
	* @throws SystemException if a system exception occurred
	*/
	public int countByIndustry(long industry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the enterprise in the entity cache if it is enabled.
	*
	* @param enterprise the enterprise
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.Enterprise enterprise);

	/**
	* Caches the enterprises in the entity cache if it is enabled.
	*
	* @param enterprises the enterprises
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Enterprise> enterprises);

	/**
	* Creates a new enterprise with the primary key. Does not add the enterprise to the database.
	*
	* @param enterpriseId the primary key for the new enterprise
	* @return the new enterprise
	*/
	public com.leancrm.portlet.library.model.Enterprise create(
		long enterpriseId);

	/**
	* Removes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise that was removed
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise remove(
		long enterpriseId)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.Enterprise updateImpl(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enterprise with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchEnterpriseException} if it could not be found.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise
	* @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise findByPrimaryKey(
		long enterpriseId)
		throws com.leancrm.portlet.library.NoSuchEnterpriseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enterprise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise, or <code>null</code> if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Enterprise fetchByPrimaryKey(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enterprises.
	*
	* @return the enterprises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Enterprise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enterprises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enterprises.
	*
	* @return the number of enterprises
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}