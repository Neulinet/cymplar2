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

import com.leancrm.portlet.library.model.UserContract;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user contract service. This utility wraps {@link UserContractPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserContractPersistence
 * @see UserContractPersistenceImpl
 * @generated
 */
public class UserContractUtil {
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
	public static void clearCache(UserContract userContract) {
		getPersistence().clearCache(userContract);
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
	public static List<UserContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserContract update(UserContract userContract)
		throws SystemException {
		return getPersistence().update(userContract);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserContract update(UserContract userContract,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userContract, serviceContext);
	}

	/**
	* Returns the user contract where userId = &#63; and contractId = &#63; or throws a {@link com.leancrm.portlet.library.NoSuchUserContractException} if it could not be found.
	*
	* @param userId the user ID
	* @param contractId the contract ID
	* @return the matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByUserContract(
		long userId, long contractId)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserContract(userId, contractId);
	}

	/**
	* Returns the user contract where userId = &#63; and contractId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param contractId the contract ID
	* @return the matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUserContract(
		long userId, long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserContract(userId, contractId);
	}

	/**
	* Returns the user contract where userId = &#63; and contractId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param contractId the contract ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUserContract(
		long userId, long contractId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserContract(userId, contractId, retrieveFromCache);
	}

	/**
	* Removes the user contract where userId = &#63; and contractId = &#63; from the database.
	*
	* @param userId the user ID
	* @param contractId the contract ID
	* @return the user contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract removeByUserContract(
		long userId, long contractId)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserContract(userId, contractId);
	}

	/**
	* Returns the number of user contracts where userId = &#63; and contractId = &#63;.
	*
	* @param userId the user ID
	* @param contractId the contract ID
	* @return the number of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserContract(long userId, long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserContract(userId, contractId);
	}

	/**
	* Returns all the user contracts where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContract(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContract(contractId);
	}

	/**
	* Returns a range of all the user contracts where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContract(
		long contractId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContract(contractId, start, end);
	}

	/**
	* Returns an ordered range of all the user contracts where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContract(
		long contractId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContract(contractId, start, end, orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContract_First(contractId, orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContract_First(contractId, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContract_Last(contractId, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContract_Last(contractId, orderByComparator);
	}

	/**
	* Returns the user contracts before and after the current user contract in the ordered set where contractId = &#63;.
	*
	* @param userContractPK the primary key of the current user contract
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract[] findByContract_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK,
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContract_PrevAndNext(userContractPK, contractId,
			orderByComparator);
	}

	/**
	* Removes all the user contracts where contractId = &#63; from the database.
	*
	* @param contractId the contract ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContract(contractId);
	}

	/**
	* Returns the number of user contracts where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the number of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContract(contractId);
	}

	/**
	* Returns all the user contracts where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the user contracts where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the user contracts where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the user contracts before and after the current user contract in the ordered set where userId = &#63;.
	*
	* @param userContractPK the primary key of the current user contract
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract[] findByUser_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(userContractPK, userId,
			orderByComparator);
	}

	/**
	* Removes all the user contracts where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of user contracts where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the user contracts where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @return the matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUserAndState(
		long userId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserAndState(userId, active);
	}

	/**
	* Returns a range of all the user contracts where userId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param active the active
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUserAndState(
		long userId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserAndState(userId, active, start, end);
	}

	/**
	* Returns an ordered range of all the user contracts where userId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param active the active
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByUserAndState(
		long userId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndState(userId, active, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByUserAndState_First(
		long userId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndState_First(userId, active, orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUserAndState_First(
		long userId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndState_First(userId, active, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByUserAndState_Last(
		long userId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndState_Last(userId, active, orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByUserAndState_Last(
		long userId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndState_Last(userId, active, orderByComparator);
	}

	/**
	* Returns the user contracts before and after the current user contract in the ordered set where userId = &#63; and active = &#63;.
	*
	* @param userContractPK the primary key of the current user contract
	* @param userId the user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract[] findByUserAndState_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK,
		long userId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndState_PrevAndNext(userContractPK, userId,
			active, orderByComparator);
	}

	/**
	* Removes all the user contracts where userId = &#63; and active = &#63; from the database.
	*
	* @param userId the user ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserAndState(long userId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserAndState(userId, active);
	}

	/**
	* Returns the number of user contracts where userId = &#63; and active = &#63;.
	*
	* @param userId the user ID
	* @param active the active
	* @return the number of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserAndState(long userId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserAndState(userId, active);
	}

	/**
	* Returns all the user contracts where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @return the matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContractAccess(
		long contractId, int accessLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContractAccess(contractId, accessLevel);
	}

	/**
	* Returns a range of all the user contracts where contractId = &#63; and accessLevel = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContractAccess(
		long contractId, int accessLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContractAccess(contractId, accessLevel, start, end);
	}

	/**
	* Returns an ordered range of all the user contracts where contractId = &#63; and accessLevel = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findByContractAccess(
		long contractId, int accessLevel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContractAccess(contractId, accessLevel, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByContractAccess_First(
		long contractId, int accessLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContractAccess_First(contractId, accessLevel,
			orderByComparator);
	}

	/**
	* Returns the first user contract in the ordered set where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByContractAccess_First(
		long contractId, int accessLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContractAccess_First(contractId, accessLevel,
			orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByContractAccess_Last(
		long contractId, int accessLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContractAccess_Last(contractId, accessLevel,
			orderByComparator);
	}

	/**
	* Returns the last user contract in the ordered set where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByContractAccess_Last(
		long contractId, int accessLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContractAccess_Last(contractId, accessLevel,
			orderByComparator);
	}

	/**
	* Returns the user contracts before and after the current user contract in the ordered set where contractId = &#63; and accessLevel = &#63;.
	*
	* @param userContractPK the primary key of the current user contract
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract[] findByContractAccess_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK,
		long contractId, int accessLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContractAccess_PrevAndNext(userContractPK,
			contractId, accessLevel, orderByComparator);
	}

	/**
	* Removes all the user contracts where contractId = &#63; and accessLevel = &#63; from the database.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContractAccess(long contractId, int accessLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContractAccess(contractId, accessLevel);
	}

	/**
	* Returns the number of user contracts where contractId = &#63; and accessLevel = &#63;.
	*
	* @param contractId the contract ID
	* @param accessLevel the access level
	* @return the number of matching user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContractAccess(long contractId, int accessLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContractAccess(contractId, accessLevel);
	}

	/**
	* Caches the user contract in the entity cache if it is enabled.
	*
	* @param userContract the user contract
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.UserContract userContract) {
		getPersistence().cacheResult(userContract);
	}

	/**
	* Caches the user contracts in the entity cache if it is enabled.
	*
	* @param userContracts the user contracts
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.UserContract> userContracts) {
		getPersistence().cacheResult(userContracts);
	}

	/**
	* Creates a new user contract with the primary key. Does not add the user contract to the database.
	*
	* @param userContractPK the primary key for the new user contract
	* @return the new user contract
	*/
	public static com.leancrm.portlet.library.model.UserContract create(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK) {
		return getPersistence().create(userContractPK);
	}

	/**
	* Removes the user contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract that was removed
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract remove(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userContractPK);
	}

	public static com.leancrm.portlet.library.model.UserContract updateImpl(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userContract);
	}

	/**
	* Returns the user contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchUserContractException} if it could not be found.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract
	* @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.leancrm.portlet.library.NoSuchUserContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userContractPK);
	}

	/**
	* Returns the user contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userContractPK the primary key of the user contract
	* @return the user contract, or <code>null</code> if a user contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.UserContract fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.UserContractPK userContractPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userContractPK);
	}

	/**
	* Returns all the user contracts.
	*
	* @return the user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @return the range of user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user contracts
	* @param end the upper bound of the range of user contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.UserContract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user contracts.
	*
	* @return the number of user contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserContractPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserContractPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					UserContractPersistence.class.getName());

			ReferenceRegistry.registerReference(UserContractUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserContractPersistence persistence) {
	}

	private static UserContractPersistence _persistence;
}