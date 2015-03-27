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

import com.leancrm.portlet.library.model.ContactDataRef;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact data ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRefPersistenceImpl
 * @see ContactDataRefUtil
 * @generated
 */
public interface ContactDataRefPersistence extends BasePersistence<ContactDataRef> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDataRefUtil} to access the contact data ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact data ref in the entity cache if it is enabled.
	*
	* @param contactDataRef the contact data ref
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef);

	/**
	* Caches the contact data refs in the entity cache if it is enabled.
	*
	* @param contactDataRefs the contact data refs
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactDataRef> contactDataRefs);

	/**
	* Creates a new contact data ref with the primary key. Does not add the contact data ref to the database.
	*
	* @param contactDataId the primary key for the new contact data ref
	* @return the new contact data ref
	*/
	public com.leancrm.portlet.library.model.ContactDataRef create(
		long contactDataId);

	/**
	* Removes the contact data ref with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data ref
	* @return the contact data ref that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataRef remove(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataRefException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.ContactDataRef updateImpl(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data ref with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataRefException} if it could not be found.
	*
	* @param contactDataId the primary key of the contact data ref
	* @return the contact data ref
	* @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataRef findByPrimaryKey(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataRefException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data ref with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataId the primary key of the contact data ref
	* @return the contact data ref, or <code>null</code> if a contact data ref with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataRef fetchByPrimaryKey(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact data refs.
	*
	* @return the contact data refs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataRef> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact data refs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data refs
	* @param end the upper bound of the range of contact data refs (not inclusive)
	* @return the range of contact data refs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataRef> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact data refs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data refs
	* @param end the upper bound of the range of contact data refs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact data refs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact data refs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact data refs.
	*
	* @return the number of contact data refs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}