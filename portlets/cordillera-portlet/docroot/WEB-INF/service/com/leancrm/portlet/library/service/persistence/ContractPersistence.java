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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContractPersistenceImpl
 * @see ContractUtil
 * @generated
 */
public interface ContractPersistence extends BasePersistence<Contract> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContractUtil} to access the contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByContact(
		long organizationId, long enterpriseId, long contactId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract findByContact_First(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract fetchByContact_First(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract findByContact_Last(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract fetchByContact_Last(
		long organizationId, long enterpriseId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract[] findByContact_PrevAndNext(
		long contractId, long organizationId, long enterpriseId,
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContact(long organizationId, long enterpriseId,
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param contactId the contact ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContact(long organizationId, long enterpriseId,
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganizationAndEnterprise(
		long organizationId, long enterpriseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract findByOrganizationAndEnterprise_First(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByOrganizationAndEnterprise_First(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract findByOrganizationAndEnterprise_Last(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contract in the ordered set where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByOrganizationAndEnterprise_Last(
		long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract[] findByOrganizationAndEnterprise_PrevAndNext(
		long contractId, long organizationId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationAndEnterprise(long organizationId,
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts where organizationId = &#63; and enterpriseId = &#63;.
	*
	* @param organizationId the organization ID
	* @param enterpriseId the enterprise ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationAndEnterprise(long organizationId,
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contracts where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract findByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract findByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contract in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract[] findByOrganization_PrevAndNext(
		long contractId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contracts where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @return the matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findByEnterprise(
		long enterpriseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract findByEnterprise_First(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByEnterprise_First(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract findByEnterprise_Last(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contract in the ordered set where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contract, or <code>null</code> if a matching contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByEnterprise_Last(
		long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.leancrm.portlet.library.model.Contract[] findByEnterprise_PrevAndNext(
		long contractId, long enterpriseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts where enterpriseId = &#63; from the database.
	*
	* @param enterpriseId the enterprise ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEnterprise(long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts where enterpriseId = &#63;.
	*
	* @param enterpriseId the enterprise ID
	* @return the number of matching contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByEnterprise(long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the contract in the entity cache if it is enabled.
	*
	* @param contract the contract
	*/
	public void cacheResult(com.leancrm.portlet.library.model.Contract contract);

	/**
	* Caches the contracts in the entity cache if it is enabled.
	*
	* @param contracts the contracts
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.Contract> contracts);

	/**
	* Creates a new contract with the primary key. Does not add the contract to the database.
	*
	* @param contractId the primary key for the new contract
	* @return the new contract
	*/
	public com.leancrm.portlet.library.model.Contract create(long contractId);

	/**
	* Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contractId the primary key of the contract
	* @return the contract that was removed
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract remove(long contractId)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.Contract updateImpl(
		com.leancrm.portlet.library.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContractException} if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract
	* @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract findByPrimaryKey(
		long contractId)
		throws com.leancrm.portlet.library.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract, or <code>null</code> if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.Contract fetchByPrimaryKey(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contracts.
	*
	* @return the contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.Contract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.leancrm.portlet.library.model.Contract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts.
	*
	* @return the number of contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}