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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact data service. This utility wraps {@link ContactDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPersistence
 * @see ContactDataPersistenceImpl
 * @generated
 */
public class ContactDataUtil {
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
	public static void clearCache(ContactData contactData) {
		getPersistence().clearCache(contactData);
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
	public static List<ContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ContactData update(ContactData contactData)
		throws SystemException {
		return getPersistence().update(contactData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ContactData update(ContactData contactData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactData, serviceContext);
	}

	/**
	* Returns all the contact datas where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact(contactId);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact(contactId, start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContact(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact(contactId, start, end, orderByComparator);
	}

	/**
	* Returns the first contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData findByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact_First(contactId, orderByComparator);
	}

	/**
	* Returns the first contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContact_First(contactId, orderByComparator);
	}

	/**
	* Returns the last contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData findByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact_Last(contactId, orderByComparator);
	}

	/**
	* Returns the last contact data in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContact_Last(contactId, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.ContactData[] findByContact_PrevAndNext(
		long contactDataId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact_PrevAndNext(contactDataId, contactId,
			orderByComparator);
	}

	/**
	* Removes all the contact datas where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContact(contactId);
	}

	/**
	* Returns the number of contact datas where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContact(contactId);
	}

	/**
	* Returns all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod(contactId, contactDataMethodId);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod(contactId, contactDataMethodId,
			start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByContactAndMethod(
		long contactId, long contactDataMethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod(contactId, contactDataMethodId,
			start, end, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.ContactData findByContactAndMethod_First(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod_First(contactId,
			contactDataMethodId, orderByComparator);
	}

	/**
	* Returns the first contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByContactAndMethod_First(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactAndMethod_First(contactId,
			contactDataMethodId, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.ContactData findByContactAndMethod_Last(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod_Last(contactId, contactDataMethodId,
			orderByComparator);
	}

	/**
	* Returns the last contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByContactAndMethod_Last(
		long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactAndMethod_Last(contactId,
			contactDataMethodId, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.ContactData[] findByContactAndMethod_PrevAndNext(
		long contactDataId, long contactId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndMethod_PrevAndNext(contactDataId,
			contactId, contactDataMethodId, orderByComparator);
	}

	/**
	* Removes all the contact datas where contactId = &#63; and contactDataMethodId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactAndMethod(long contactId,
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactAndMethod(contactId, contactDataMethodId);
	}

	/**
	* Returns the number of contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactDataMethodId the contact data method ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactAndMethod(long contactId,
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContactAndMethod(contactId, contactDataMethodId);
	}

	/**
	* Returns all the contact datas where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @return the matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMethod(contactDataMethodId);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMethod(contactDataMethodId, start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findByMethod(
		long contactDataMethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMethod(contactDataMethodId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData findByMethod_First(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMethod_First(contactDataMethodId, orderByComparator);
	}

	/**
	* Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByMethod_First(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMethod_First(contactDataMethodId, orderByComparator);
	}

	/**
	* Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData findByMethod_Last(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMethod_Last(contactDataMethodId, orderByComparator);
	}

	/**
	* Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByMethod_Last(
		long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMethod_Last(contactDataMethodId, orderByComparator);
	}

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
	public static com.leancrm.portlet.library.model.ContactData[] findByMethod_PrevAndNext(
		long contactDataId, long contactDataMethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMethod_PrevAndNext(contactDataId,
			contactDataMethodId, orderByComparator);
	}

	/**
	* Removes all the contact datas where contactDataMethodId = &#63; from the database.
	*
	* @param contactDataMethodId the contact data method ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMethod(long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMethod(contactDataMethodId);
	}

	/**
	* Returns the number of contact datas where contactDataMethodId = &#63;.
	*
	* @param contactDataMethodId the contact data method ID
	* @return the number of matching contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMethod(long contactDataMethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMethod(contactDataMethodId);
	}

	/**
	* Caches the contact data in the entity cache if it is enabled.
	*
	* @param contactData the contact data
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.ContactData contactData) {
		getPersistence().cacheResult(contactData);
	}

	/**
	* Caches the contact datas in the entity cache if it is enabled.
	*
	* @param contactDatas the contact datas
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactData> contactDatas) {
		getPersistence().cacheResult(contactDatas);
	}

	/**
	* Creates a new contact data with the primary key. Does not add the contact data to the database.
	*
	* @param contactDataId the primary key for the new contact data
	* @return the new contact data
	*/
	public static com.leancrm.portlet.library.model.ContactData create(
		long contactDataId) {
		return getPersistence().create(contactDataId);
	}

	/**
	* Removes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData remove(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contactDataId);
	}

	public static com.leancrm.portlet.library.model.ContactData updateImpl(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactData);
	}

	/**
	* Returns the contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataException} if it could not be found.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data
	* @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData findByPrimaryKey(
		long contactDataId)
		throws com.leancrm.portlet.library.NoSuchContactDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contactDataId);
	}

	/**
	* Returns the contact data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDataId the primary key of the contact data
	* @return the contact data, or <code>null</code> if a contact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.ContactData fetchByPrimaryKey(
		long contactDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactDataId);
	}

	/**
	* Returns all the contact datas.
	*
	* @return the contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.leancrm.portlet.library.model.ContactData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contact datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contact datas.
	*
	* @return the number of contact datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactDataPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ContactDataPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContactDataPersistence persistence) {
	}

	private static ContactDataPersistence _persistence;
}