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

import com.leancrm.portlet.library.model.ContactDataText;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact data text service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataTextPersistenceImpl
 * @see ContactDataTextUtil
 * @generated
 */
public interface ContactDataTextPersistence extends BasePersistence<ContactDataText> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDataTextUtil} to access the contact data text persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact data text in the entity cache if it is enabled.
	*
	* @param contactDataText the contact data text
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.ContactDataText contactDataText);

	/**
	* Caches the contact data texts in the entity cache if it is enabled.
	*
	* @param contactDataTexts the contact data texts
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactDataText> contactDataTexts);

	/**
	* Creates a new contact data text with the primary key. Does not add the contact data text to the database.
	*
	* @param contactDataId the primary key for the new contact data text
	* @return the new contact data text
	*/
	public com.leancrm.portlet.library.model.ContactDataText create(
		long contactDataId);

	/**
	* Removes the contact data text with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data text
	* @return the contact data text that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataText remove(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataTextException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.ContactDataText updateImpl(
		com.leancrm.portlet.library.model.ContactDataText contactDataText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data text with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataTextException} if it could not be found.
	*
	* @param contactDataId the primary key of the contact data text
	* @return the contact data text
	* @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataText findByPrimaryKey(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataTextException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data text with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataId the primary key of the contact data text
	* @return the contact data text, or <code>null</code> if a contact data text with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactDataText fetchByPrimaryKey(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact data texts.
	*
	* @return the contact data texts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataText> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact data texts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data texts
	* @param end the upper bound of the range of contact data texts (not inclusive)
	* @return the range of contact data texts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataText> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact data texts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact data texts
	* @param end the upper bound of the range of contact data texts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact data texts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactDataText> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact data texts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact data texts.
	*
	* @return the number of contact data texts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}