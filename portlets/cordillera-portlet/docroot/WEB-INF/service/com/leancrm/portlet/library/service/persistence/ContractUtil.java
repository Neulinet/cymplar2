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

import com.leancrm.portlet.library.model.Contract;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contract service. This utility wraps {@link ContractPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContractPersistence
 * @see ContractPersistenceImpl
 * @generated
 */
public class ContractUtil {
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
	public static void clearCache(Contract contract) {
		getPersistence().clearCache(contract);
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
	public static List<Contract> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Contract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Contract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Contract update(Contract contract) throws SystemException {
		return getPersistence().update(contract);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Contract update(Contract contract,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contract, serviceContext);
	}

	/**
	* Returns all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact(organizationId, enterpriseId, contactId);
	}

	/**
	* Returns a range of all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact(organizationId, enterpriseId, contactId,
			start, end);
	}

	/**
	* Returns an ordered range of all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact(organizationId, enterpriseId, contactId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByContact_First(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact_First(organizationId, enterpriseId,
			contactId, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByContact_First(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContact_First(organizationId, enterpriseId,
			contactId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByContact_Last(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact_Last(organizationId, enterpriseId, contactId,
			orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByContact_Last(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContact_Last(organizationId, enterpriseId,
			contactId, orderByComparator);
	}

	/**
	* Returns the contracts before and after the current contract in the ordered set where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param contractId the primary key of the current contract
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract[] findByContact_PrevAndNext(
		long contractId, long organizationId, long enterpriseId,
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact_PrevAndNext(contractId, organizationId,
			enterpriseId, contactId, orderByComparator);
	}

	/**
	* Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContact(long organizationId, long enterpriseId,
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContact(organizationId, enterpriseId, contactId);
	}

	/**
	* Returns the number of contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContact(long organizationId, long enterpriseId,
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContact(organizationId, enterpriseId, contactId);
	}

	/**
	* Returns all the contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise(organizationId, enterpriseId);
	}

	/**
	* Returns a range of all the contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise(organizationId,
			enterpriseId, start, end);
	}

	/**
	* Returns an ordered range of all the contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise(organizationId,
			enterpriseId, start, end, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByOrganizationAndEnterprise_First(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise_First(organizationId,
			enterpriseId, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByOrganizationAndEnterprise_First(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndEnterprise_First(organizationId,
			enterpriseId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByOrganizationAndEnterprise_Last(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise_Last(organizationId,
			enterpriseId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByOrganizationAndEnterprise_Last(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationAndEnterprise_Last(organizationId,
			enterpriseId, orderByComparator);
	}

	/**
	* Returns the contracts before and after the current contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param contractId the primary key of the current contract
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract[] findByOrganizationAndEnterprise_PrevAndNext(
		long contractId, long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationAndEnterprise_PrevAndNext(contractId,
			organizationId, enterpriseId, orderByComparator);
	}

	/**
	* Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationAndEnterprise(long organizationId,
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOrganizationAndEnterprise(organizationId, enterpriseId);
	}

	/**
	* Returns the number of contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationAndEnterprise(long organizationId,
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrganizationAndEnterprise(organizationId,
			enterpriseId);
	}

	/**
	* Returns all the contracts where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganization(organizationId);
	}

	/**
	* Returns a range of all the contracts where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganization(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the contracts where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganization_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the contracts before and after the current contract in the ordered set where organizationId = &#63;.
	*
	* @param contractId the primary key of the current contract
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract[] findByOrganization_PrevAndNext(
		long contractId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganization_PrevAndNext(contractId, organizationId,
			orderByComparator);
	}

	/**
	* Removes all the contracts where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganization(organizationId);
	}

	/**
	* Returns the number of contracts where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganization(organizationId);
	}

	/**
	* Returns all the contracts where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEnterprise(enterpriseId);
	}

	/**
	* Returns a range of all the contracts where enterpriseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param enterpriseId the enterprise ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEnterprise(enterpriseId, start, end);
	}

	/**
	* Returns an ordered range of all the contracts where enterpriseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param enterpriseId the enterprise ID
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEnterprise(enterpriseId, start, end, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByEnterprise_First(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEnterprise_First(enterpriseId, orderByComparator);
	}

	/**
	* Returns the first contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByEnterprise_First(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEnterprise_First(enterpriseId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByEnterprise_Last(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEnterprise_Last(enterpriseId, orderByComparator);
	}

	/**
	* Returns the last contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByEnterprise_Last(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEnterprise_Last(enterpriseId, orderByComparator);
	}

	/**
	* Returns the contracts before and after the current contract in the ordered set where enterpriseId = &#63;.
	*
	* @param contractId the primary key of the current contract
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract[] findByEnterprise_PrevAndNext(
		long contractId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEnterprise_PrevAndNext(contractId, enterpriseId,
			orderByComparator);
	}

	/**
	* Removes all the contracts where enterpriseId = &#63; from the database.
	*
	* @param enterpriseId the enterprise ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEnterprise(long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEnterprise(enterpriseId);
	}

	/**
	* Returns the number of contracts where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEnterprise(long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEnterprise(enterpriseId);
	}

	/**
	* Caches the contract in the entity cache if it is enabled.
	*
	* @param contract the contract
	*/
	public static void cacheResult(
		com.leancrm.portlet.library.model.Contract contract) {
		getPersistence().cacheResult(contract);
	}

	/**
	* Caches the contracts in the entity cache if it is enabled.
	*
	* @param contracts the contracts
	*/
	public static void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Contract> contracts) {
		getPersistence().cacheResult(contracts);
	}

	/**
	* Creates a new contract with the primary key. Does not add the contract to the database.
	*
	* @param contractId the primary key for the new contract
	* @return the new contract
	*/
	public static com.leancrm.portlet.library.model.Contract create(
		long contractId) {
		return getPersistence().create(contractId);
	}

	/**
	* Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contractId the primary key of the contract
	* @return the contract that was removed
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract remove(
		long contractId)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contractId);
	}

	public static com.leancrm.portlet.library.model.Contract updateImpl(
		com.leancrm.portlet.library.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contract);
	}

	/**
	* Returns the contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContractException} if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract findByPrimaryKey(
		long contractId)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contractId);
	}

	/**
	* Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract, or <code>null</code> if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Contract fetchByPrimaryKey(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contractId);
	}

	/**
	* Returns all the contracts.
	*
	* @return the contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Contract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contracts.
	*
	* @return the number of contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContractPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContractPersistence)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ContractPersistence.class.getName());

			ReferenceRegistry.registerReference(ContractUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContractPersistence persistence) {
	}

	private static ContractPersistence _persistence;
}