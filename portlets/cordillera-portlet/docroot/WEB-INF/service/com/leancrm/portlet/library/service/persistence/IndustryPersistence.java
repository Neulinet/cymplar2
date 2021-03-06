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

import com.leancrm.portlet.library.model.Industry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the industry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndustryPersistenceImpl
 * @see IndustryUtil
 * @generated
 */
public interface IndustryPersistence extends BasePersistence<Industry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IndustryUtil} to access the industry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the industries where name = &#63;.
	*
	* @param name the name
	* @return the matching industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the industries where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of industries
	* @param end the upper bound of the range of industries (not inclusive)
	* @return the range of matching industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the industries where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of industries
	* @param end the upper bound of the range of industries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first industry in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching industry
	* @throws com.leancrm.portlet.library.NoSuchIndustryException if a matching industry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchIndustryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first industry in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching industry, or <code>null</code> if a matching industry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last industry in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching industry
	* @throws com.leancrm.portlet.library.NoSuchIndustryException if a matching industry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchIndustryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last industry in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching industry, or <code>null</code> if a matching industry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the industries before and after the current industry in the ordered set where name = &#63;.
	*
	* @param industryId the primary key of the current industry
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next industry
	* @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry[] findByName_PrevAndNext(
		long industryId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchIndustryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the industries where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of industries where name = &#63;.
	*
	* @param name the name
	* @return the number of matching industries
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the industry in the entity cache if it is enabled.
	*
	* @param industry the industry
	*/
	public void cacheResult(com.leancrm.portlet.library.model.Industry industry);

	/**
	* Caches the industries in the entity cache if it is enabled.
	*
	* @param industries the industries
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Industry> industries);

	/**
	* Creates a new industry with the primary key. Does not add the industry to the database.
	*
	* @param industryId the primary key for the new industry
	* @return the new industry
	*/
	public com.leancrm.portlet.library.model.Industry create(long industryId);

	/**
	* Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param industryId the primary key of the industry
	* @return the industry that was removed
	* @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry remove(long industryId)
		throws com.leancrm.portlet.library.NoSuchIndustryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.Industry updateImpl(
		com.leancrm.portlet.library.model.Industry industry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the industry with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchIndustryException} if it could not be found.
	*
	* @param industryId the primary key of the industry
	* @return the industry
	* @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry findByPrimaryKey(
		long industryId)
		throws com.leancrm.portlet.library.NoSuchIndustryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param industryId the primary key of the industry
	* @return the industry, or <code>null</code> if a industry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Industry fetchByPrimaryKey(
		long industryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the industries.
	*
	* @return the industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the industries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of industries
	* @param end the upper bound of the range of industries (not inclusive)
	* @return the range of industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the industries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of industries
	* @param end the upper bound of the range of industries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of industries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Industry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the industries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of industries.
	*
	* @return the number of industries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}