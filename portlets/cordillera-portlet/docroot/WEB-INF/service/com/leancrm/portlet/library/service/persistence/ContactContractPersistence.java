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

import com.leancrm.portlet.library.model.ContactContract;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactContractPersistenceImpl
 * @see ContactContractUtil
 * @generated
 */
public interface ContactContractPersistence extends BasePersistence<ContactContract> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactContractUtil} to access the contact contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contact contracts where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @return the matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactContract(
		long contractId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact contracts where contractId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactContract(
		long contractId, long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact contracts where contractId = &#63; and contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactContract(
		long contractId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContactContract_First(
		long contractId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContactContract_First(
		long contractId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContactContract_Last(
		long contractId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContactContract_Last(
		long contractId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contracts before and after the current contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	*
	* @param contactContractPK the primary key of the current contact contract
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract[] findByContactContract_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK,
		long contractId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact contracts where contractId = &#63; and contactId = &#63; from the database.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactContract(long contractId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact contracts where contractId = &#63; and contactId = &#63;.
	*
	* @param contractId the contract ID
	* @param contactId the contact ID
	* @return the number of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactContract(long contractId, long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact contracts where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContract(
		long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact contracts where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContract(
		long contractId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact contracts where contractId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contractId the contract ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContract(
		long contractId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContract_First(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContract_Last(
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contracts before and after the current contact contract in the ordered set where contractId = &#63;.
	*
	* @param contactContractPK the primary key of the current contact contract
	* @param contractId the contract ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract[] findByContract_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK,
		long contractId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact contracts where contractId = &#63; from the database.
	*
	* @param contractId the contract ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact contracts where contractId = &#63;.
	*
	* @param contractId the contract ID
	* @return the number of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContract(long contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact contracts where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact contracts where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact contracts where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContact(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contracts before and after the current contact contract in the ordered set where contactId = &#63;.
	*
	* @param contactContractPK the primary key of the current contact contract
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract[] findByContact_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK,
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact contracts where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact contracts where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact contracts where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @return the matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactAndState(
		long contactId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact contracts where contactId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param active the active
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactAndState(
		long contactId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact contracts where contactId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactId the contact ID
	* @param active the active
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findByContactAndState(
		long contactId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContactAndState_First(
		long contactId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact contract in the ordered set where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContactAndState_First(
		long contactId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByContactAndState_Last(
		long contactId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contact contract in the ordered set where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByContactAndState_Last(
		long contactId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contracts before and after the current contact contract in the ordered set where contactId = &#63; and active = &#63;.
	*
	* @param contactContractPK the primary key of the current contact contract
	* @param contactId the contact ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract[] findByContactAndState_PrevAndNext(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK,
		long contactId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact contracts where contactId = &#63; and active = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactAndState(long contactId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact contracts where contactId = &#63; and active = &#63;.
	*
	* @param contactId the contact ID
	* @param active the active
	* @return the number of matching contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactAndState(long contactId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the contact contract in the entity cache if it is enabled.
	*
	* @param contactContract the contact contract
	*/
	public void cacheResult(
		com.leancrm.portlet.library.model.ContactContract contactContract);

	/**
	* Caches the contact contracts in the entity cache if it is enabled.
	*
	* @param contactContracts the contact contracts
	*/
	public void cacheResult(
		java.util.List<com.leancrm.portlet.library.model.ContactContract> contactContracts);

	/**
	* Creates a new contact contract with the primary key. Does not add the contact contract to the database.
	*
	* @param contactContractPK the primary key for the new contact contract
	* @return the new contact contract
	*/
	public com.leancrm.portlet.library.model.ContactContract create(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK);

	/**
	* Removes the contact contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactContractPK the primary key of the contact contract
	* @return the contact contract that was removed
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract remove(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.leancrm.portlet.library.model.ContactContract updateImpl(
		com.leancrm.portlet.library.model.ContactContract contactContract)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactContractException} if it could not be found.
	*
	* @param contactContractPK the primary key of the contact contract
	* @return the contact contract
	* @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract findByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.leancrm.portlet.library.NoSuchContactContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactContractPK the primary key of the contact contract
	* @return the contact contract, or <code>null</code> if a contact contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.leancrm.portlet.library.model.ContactContract fetchByPrimaryKey(
		com.leancrm.portlet.library.service.persistence.ContactContractPK contactContractPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact contracts.
	*
	* @return the contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @return the range of contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact contracts
	* @param end the upper bound of the range of contact contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.leancrm.portlet.library.model.ContactContract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact contracts.
	*
	* @return the number of contact contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}