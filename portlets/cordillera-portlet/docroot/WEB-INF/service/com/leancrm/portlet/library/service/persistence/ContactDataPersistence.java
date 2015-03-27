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

import com.leancrm.portlet.library.model.ContactData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPersistenceImpl
 * @see ContactDataUtil
 * @generated
 */
public interface ContactDataPersistence extends BasePersistence<ContactData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDataUtil} to access the contact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contact datas where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact datas where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @return the range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact datas where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact datas before and after the current contact data in the ordered set where contactId = &#63;.
	*
	* @param contactDataId the primary key of the current contact data
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData[] findByContact_PrevAndNext(
		long contactDataId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact datas where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact datas where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @return the range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByContactAndMethod_First(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByContactAndMethod_First(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByContactAndMethod_Last(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByContactAndMethod_Last(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact datas before and after the current contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactDataId the primary key of the current contact data
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData[] findByContactAndMethod_PrevAndNext(
		long contactDataId, long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact datas where contactId = &#63; and contactDataMethodId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactAndMethod(long contactId,
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactAndMethod(long contactId, long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact datas where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact datas where contactDataMethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactDataMethodId the contact data method ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @return the range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact datas where contactDataMethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactDataMethodId the contact data method ID
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByMethod_First(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByMethod_First(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByMethod_Last(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByMethod_Last(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact datas before and after the current contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataId the primary key of the current contact data
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData[] findByMethod_PrevAndNext(
		long contactDataId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact datas where contactDataMethodId = &#63; from the database.
	*
	* @param contactDataMethodId the contact data method ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMethod(long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact datas where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByMethod(long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the contact data in the entity cache if it is enabled.
	*
	* @param contactData the contact data
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.ContactData contactData);

	/**
	* Caches the contact datas in the entity cache if it is enabled.
	*
	* @param contactDatas the contact datas
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactData> contactDatas);

	/**
	* Creates a new contact data with the primary key. Does not add the contact data to the database.
	*
	* @param contactDataId the primary key for the new contact data
	* @return the new contact data
	*/
	public com.leancrm.portlet.library.model.ContactData create(
		long contactDataId);

	/**
	* Removes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData remove(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.ContactData updateImpl(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataException} if it could not be found.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData findByPrimaryKey(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data, or <code>null</code> if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactData fetchByPrimaryKey(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact datas.
	*
	* @return the contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @return the range of contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact datas
	* @param end the upper bound of the range of contact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact datas.
	*
	* @return the number of contact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}