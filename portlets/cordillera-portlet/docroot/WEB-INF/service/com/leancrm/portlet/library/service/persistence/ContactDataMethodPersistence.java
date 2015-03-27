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

import com.leancrm.portlet.library.model.ContactDataMethod;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact data method service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethodPersistenceImpl
 * @see ContactDataMethodUtil
 * @generated
 */
public interface ContactDataMethodPersistence extends BasePersistence<ContactDataMethod> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDataMethodUtil} to access the contact data method persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contact data methods where name = &#63;.
	*
	* @param name the name
	* @return the matching contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact data methods where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of contact data methods
	* @param end the upper bound of the range of contact data methods (not inclusive)
	* @return the range of matching contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact data methods where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of contact data methods
	* @param end the upper bound of the range of contact data methods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data method in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data method
	* @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a matching contact data method could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataMethodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data method in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data method, or <code>null</code> if a matching contact data method could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data method in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data method
	* @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a matching contact data method could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataMethodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data method in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data method, or <code>null</code> if a matching contact data method could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data methods before and after the current contact data method in the ordered set where name = &#63;.
	*
	* @param contactDataMethodId the primary key of the current contact data method
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact data method
	* @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod[] findByName_PrevAndNext(
		long contactDataMethodId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataMethodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact data methods where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact data methods where name = &#63;.
	*
	* @param name the name
	* @return the number of matching contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the contact data method in the entity cache if it is enabled.
	*
	* @param contactDataMethod the contact data method
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod);

	/**
	* Caches the contact data methods in the entity cache if it is enabled.
	*
	* @param contactDataMethods the contact data methods
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> contactDataMethods);

	/**
	* Creates a new contact data method with the primary key. Does not add the contact data method to the database.
	*
	* @param contactDataMethodId the primary key for the new contact data method
	* @return the new contact data method
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod create(
		long contactDataMethodId);

	/**
	* Removes the contact data method with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod remove(
		long contactDataMethodId)
		throws com.leancrm.portlet.library.NoSuchContactDataMethodException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.ContactDataMethod updateImpl(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data method with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataMethodException} if it could not be found.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method
	* @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod findByPrimaryKey(
		long contactDataMethodId)
		throws com.leancrm.portlet.library.NoSuchContactDataMethodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data method with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataMethodId the primary key of the contact data method
	* @return the contact data method, or <code>null</code> if a contact data method with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataMethod fetchByPrimaryKey(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact data methods.
	*
	* @return the contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact data methods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data methods
	* @param end the upper bound of the range of contact data methods (not inclusive)
	* @return the range of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact data methods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data methods
	* @param end the upper bound of the range of contact data methods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataMethod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact data methods from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact data methods.
	*
	* @return the number of contact data methods
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}