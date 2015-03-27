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

import com.leancrm.portlet.library.NoSuchContractException;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.impl.ContractImpl;
import com.leancrm.portlet.library.model.impl.ContractModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContractPersistence
 * @see ContractUtil
 * @generated
 */
public class ContractPersistenceImpl extends BasePersistenceImpl<Contract>
	implements ContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContractUtil} to access the contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContact",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ContractModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ContractModelImpl.ENTERPRISEID_COLUMN_BITMASK |
			ContractModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @return the matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findByContact(long organizationId, long enterpriseId,
		long contactId) throws SystemException {
		return findByContact(organizationId, enterpriseId, contactId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Contract> findByContact(long organizationId, long enterpriseId,
		long contactId, int start, int end) throws SystemException {
		return findByContact(organizationId, enterpriseId, contactId, start,
			end, null);
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
	@Override
	public List<Contract> findByContact(long organizationId, long enterpriseId,
		long contactId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { organizationId, enterpriseId, contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] {
					organizationId, enterpriseId, contactId,
					
					start, end, orderByComparator
				};
		}

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contract contract : list) {
				if ((organizationId != contract.getOrganizationId()) ||
						(enterpriseId != contract.getEnterpriseId()) ||
						(contactId != contract.getContactId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_CONTACT_ENTERPRISEID_2);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(enterpriseId);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Contract findByContact_First(long organizationId, long enterpriseId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByContact_First(organizationId, enterpriseId,
				contactId, orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", enterpriseId=");
		msg.append(enterpriseId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
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
	@Override
	public Contract fetchByContact_First(long organizationId,
		long enterpriseId, long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contract> list = findByContact(organizationId, enterpriseId,
				contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract findByContact_Last(long organizationId, long enterpriseId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByContact_Last(organizationId, enterpriseId,
				contactId, orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", enterpriseId=");
		msg.append(enterpriseId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
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
	@Override
	public Contract fetchByContact_Last(long organizationId, long enterpriseId,
		long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContact(organizationId, enterpriseId, contactId);

		if (count == 0) {
			return null;
		}

		List<Contract> list = findByContact(organizationId, enterpriseId,
				contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract[] findByContact_PrevAndNext(long contractId,
		long organizationId, long enterpriseId, long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = findByPrimaryKey(contractId);

		Session session = null;

		try {
			session = openSession();

			Contract[] array = new ContractImpl[3];

			array[0] = getByContact_PrevAndNext(session, contract,
					organizationId, enterpriseId, contactId, orderByComparator,
					true);

			array[1] = contract;

			array[2] = getByContact_PrevAndNext(session, contract,
					organizationId, enterpriseId, contactId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contract getByContact_PrevAndNext(Session session,
		Contract contract, long organizationId, long enterpriseId,
		long contactId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTRACT_WHERE);

		query.append(_FINDER_COLUMN_CONTACT_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_CONTACT_ENTERPRISEID_2);

		query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(enterpriseId);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; and contactId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContact(long organizationId, long enterpriseId,
		long contactId) throws SystemException {
		for (Contract contract : findByContact(organizationId, enterpriseId,
				contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contract);
		}
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
	@Override
	public int countByContact(long organizationId, long enterpriseId,
		long contactId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACT;

		Object[] finderArgs = new Object[] {
				organizationId, enterpriseId, contactId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_CONTACT_ENTERPRISEID_2);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(enterpriseId);

				qPos.add(contactId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTACT_ORGANIZATIONID_2 = "contract.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACT_ENTERPRISEID_2 = "contract.enterpriseId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "contract.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationAndEnterprise",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationAndEnterprise",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContractModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ContractModelImpl.ENTERPRISEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONANDENTERPRISE =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationAndEnterprise",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contracts where organizationId = &#63; and enterpriseId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param enterpriseId the enterprise ID
	 * @return the matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findByOrganizationAndEnterprise(long organizationId,
		long enterpriseId) throws SystemException {
		return findByOrganizationAndEnterprise(organizationId, enterpriseId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Contract> findByOrganizationAndEnterprise(long organizationId,
		long enterpriseId, int start, int end) throws SystemException {
		return findByOrganizationAndEnterprise(organizationId, enterpriseId,
			start, end, null);
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
	@Override
	public List<Contract> findByOrganizationAndEnterprise(long organizationId,
		long enterpriseId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE;
			finderArgs = new Object[] { organizationId, enterpriseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE;
			finderArgs = new Object[] {
					organizationId, enterpriseId,
					
					start, end, orderByComparator
				};
		}

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contract contract : list) {
				if ((organizationId != contract.getOrganizationId()) ||
						(enterpriseId != contract.getEnterpriseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ENTERPRISEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(enterpriseId);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Contract findByOrganizationAndEnterprise_First(long organizationId,
		long enterpriseId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByOrganizationAndEnterprise_First(organizationId,
				enterpriseId, orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", enterpriseId=");
		msg.append(enterpriseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
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
	@Override
	public Contract fetchByOrganizationAndEnterprise_First(
		long organizationId, long enterpriseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contract> list = findByOrganizationAndEnterprise(organizationId,
				enterpriseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract findByOrganizationAndEnterprise_Last(long organizationId,
		long enterpriseId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByOrganizationAndEnterprise_Last(organizationId,
				enterpriseId, orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", enterpriseId=");
		msg.append(enterpriseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
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
	@Override
	public Contract fetchByOrganizationAndEnterprise_Last(long organizationId,
		long enterpriseId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganizationAndEnterprise(organizationId,
				enterpriseId);

		if (count == 0) {
			return null;
		}

		List<Contract> list = findByOrganizationAndEnterprise(organizationId,
				enterpriseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract[] findByOrganizationAndEnterprise_PrevAndNext(
		long contractId, long organizationId, long enterpriseId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = findByPrimaryKey(contractId);

		Session session = null;

		try {
			session = openSession();

			Contract[] array = new ContractImpl[3];

			array[0] = getByOrganizationAndEnterprise_PrevAndNext(session,
					contract, organizationId, enterpriseId, orderByComparator,
					true);

			array[1] = contract;

			array[2] = getByOrganizationAndEnterprise_PrevAndNext(session,
					contract, organizationId, enterpriseId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contract getByOrganizationAndEnterprise_PrevAndNext(
		Session session, Contract contract, long organizationId,
		long enterpriseId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTRACT_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ENTERPRISEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(enterpriseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contracts where organizationId = &#63; and enterpriseId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param enterpriseId the enterprise ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationAndEnterprise(long organizationId,
		long enterpriseId) throws SystemException {
		for (Contract contract : findByOrganizationAndEnterprise(
				organizationId, enterpriseId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contract);
		}
	}

	/**
	 * Returns the number of contracts where organizationId = &#63; and enterpriseId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param enterpriseId the enterprise ID
	 * @return the number of matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationAndEnterprise(long organizationId,
		long enterpriseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONANDENTERPRISE;

		Object[] finderArgs = new Object[] { organizationId, enterpriseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ENTERPRISEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(enterpriseId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ORGANIZATIONID_2 =
		"contract.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDENTERPRISE_ENTERPRISEID_2 =
		"contract.enterpriseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganization",
			new String[] { Long.class.getName() },
			ContractModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contracts where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findByOrganization(long organizationId)
		throws SystemException {
		return findByOrganization(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Contract> findByOrganization(long organizationId, int start,
		int end) throws SystemException {
		return findByOrganization(organizationId, start, end, null);
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
	@Override
	public List<Contract> findByOrganization(long organizationId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contract contract : list) {
				if ((organizationId != contract.getOrganizationId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Contract findByOrganization_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByOrganization_First(organizationId,
				orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
	}

	/**
	 * Returns the first contract in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contract, or <code>null</code> if a matching contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByOrganization_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contract> list = findByOrganization(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract findByOrganization_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByOrganization_Last(organizationId,
				orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
	}

	/**
	 * Returns the last contract in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contract, or <code>null</code> if a matching contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByOrganization_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganization(organizationId);

		if (count == 0) {
			return null;
		}

		List<Contract> list = findByOrganization(organizationId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract[] findByOrganization_PrevAndNext(long contractId,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = findByPrimaryKey(contractId);

		Session session = null;

		try {
			session = openSession();

			Contract[] array = new ContractImpl[3];

			array[0] = getByOrganization_PrevAndNext(session, contract,
					organizationId, orderByComparator, true);

			array[1] = contract;

			array[2] = getByOrganization_PrevAndNext(session, contract,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contract getByOrganization_PrevAndNext(Session session,
		Contract contract, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTRACT_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contracts where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganization(long organizationId)
		throws SystemException {
		for (Contract contract : findByOrganization(organizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contract);
		}
	}

	/**
	 * Returns the number of contracts where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganization(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATION;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 = "contract.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTERPRISE =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEnterprise",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTERPRISE =
		new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEnterprise",
			new String[] { Long.class.getName() },
			ContractModelImpl.ENTERPRISEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTERPRISE = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEnterprise",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contracts where enterpriseId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @return the matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findByEnterprise(long enterpriseId)
		throws SystemException {
		return findByEnterprise(enterpriseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Contract> findByEnterprise(long enterpriseId, int start, int end)
		throws SystemException {
		return findByEnterprise(enterpriseId, start, end, null);
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
	@Override
	public List<Contract> findByEnterprise(long enterpriseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTERPRISE;
			finderArgs = new Object[] { enterpriseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTERPRISE;
			finderArgs = new Object[] {
					enterpriseId,
					
					start, end, orderByComparator
				};
		}

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contract contract : list) {
				if ((enterpriseId != contract.getEnterpriseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ENTERPRISE_ENTERPRISEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enterpriseId);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Contract findByEnterprise_First(long enterpriseId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByEnterprise_First(enterpriseId,
				orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enterpriseId=");
		msg.append(enterpriseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
	}

	/**
	 * Returns the first contract in the ordered set where enterpriseId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contract, or <code>null</code> if a matching contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByEnterprise_First(long enterpriseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contract> list = findByEnterprise(enterpriseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract findByEnterprise_Last(long enterpriseId,
		OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByEnterprise_Last(enterpriseId,
				orderByComparator);

		if (contract != null) {
			return contract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enterpriseId=");
		msg.append(enterpriseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContractException(msg.toString());
	}

	/**
	 * Returns the last contract in the ordered set where enterpriseId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contract, or <code>null</code> if a matching contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByEnterprise_Last(long enterpriseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEnterprise(enterpriseId);

		if (count == 0) {
			return null;
		}

		List<Contract> list = findByEnterprise(enterpriseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Contract[] findByEnterprise_PrevAndNext(long contractId,
		long enterpriseId, OrderByComparator orderByComparator)
		throws NoSuchContractException, SystemException {
		Contract contract = findByPrimaryKey(contractId);

		Session session = null;

		try {
			session = openSession();

			Contract[] array = new ContractImpl[3];

			array[0] = getByEnterprise_PrevAndNext(session, contract,
					enterpriseId, orderByComparator, true);

			array[1] = contract;

			array[2] = getByEnterprise_PrevAndNext(session, contract,
					enterpriseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contract getByEnterprise_PrevAndNext(Session session,
		Contract contract, long enterpriseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTRACT_WHERE);

		query.append(_FINDER_COLUMN_ENTERPRISE_ENTERPRISEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(enterpriseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contracts where enterpriseId = &#63; from the database.
	 *
	 * @param enterpriseId the enterprise ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEnterprise(long enterpriseId) throws SystemException {
		for (Contract contract : findByEnterprise(enterpriseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contract);
		}
	}

	/**
	 * Returns the number of contracts where enterpriseId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @return the number of matching contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEnterprise(long enterpriseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTERPRISE;

		Object[] finderArgs = new Object[] { enterpriseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTRACT_WHERE);

			query.append(_FINDER_COLUMN_ENTERPRISE_ENTERPRISEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enterpriseId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTERPRISE_ENTERPRISEID_2 = "contract.enterpriseId = ?";

	public ContractPersistenceImpl() {
		setModelClass(Contract.class);
	}

	/**
	 * Caches the contract in the entity cache if it is enabled.
	 *
	 * @param contract the contract
	 */
	@Override
	public void cacheResult(Contract contract) {
		EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey(), contract);

		contract.resetOriginalValues();
	}

	/**
	 * Caches the contracts in the entity cache if it is enabled.
	 *
	 * @param contracts the contracts
	 */
	@Override
	public void cacheResult(List<Contract> contracts) {
		for (Contract contract : contracts) {
			if (EntityCacheUtil.getResult(
						ContractModelImpl.ENTITY_CACHE_ENABLED,
						ContractImpl.class, contract.getPrimaryKey()) == null) {
				cacheResult(contract);
			}
			else {
				contract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contract contract) {
		EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Contract> contracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Contract contract : contracts) {
			EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
				ContractImpl.class, contract.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contract with the primary key. Does not add the contract to the database.
	 *
	 * @param contractId the primary key for the new contract
	 * @return the new contract
	 */
	@Override
	public Contract create(long contractId) {
		Contract contract = new ContractImpl();

		contract.setNew(true);
		contract.setPrimaryKey(contractId);

		return contract;
	}

	/**
	 * Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract remove(long contractId)
		throws NoSuchContractException, SystemException {
		return remove((Serializable)contractId);
	}

	/**
	 * Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract remove(Serializable primaryKey)
		throws NoSuchContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contract contract = (Contract)session.get(ContractImpl.class,
					primaryKey);

			if (contract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contract);
		}
		catch (NoSuchContractException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Contract removeImpl(Contract contract) throws SystemException {
		contract = toUnwrappedModel(contract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contract)) {
				contract = (Contract)session.get(ContractImpl.class,
						contract.getPrimaryKeyObj());
			}

			if (contract != null) {
				session.delete(contract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contract != null) {
			clearCache(contract);
		}

		return contract;
	}

	@Override
	public Contract updateImpl(
		com.leancrm.portlet.library.model.Contract contract)
		throws SystemException {
		contract = toUnwrappedModel(contract);

		boolean isNew = contract.isNew();

		ContractModelImpl contractModelImpl = (ContractModelImpl)contract;

		Session session = null;

		try {
			session = openSession();

			if (contract.isNew()) {
				session.save(contract);

				contract.setNew(false);
			}
			else {
				session.merge(contract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContractModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contractModelImpl.getOriginalOrganizationId(),
						contractModelImpl.getOriginalEnterpriseId(),
						contractModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] {
						contractModelImpl.getOrganizationId(),
						contractModelImpl.getEnterpriseId(),
						contractModelImpl.getContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}

			if ((contractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contractModelImpl.getOriginalOrganizationId(),
						contractModelImpl.getOriginalEnterpriseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDENTERPRISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE,
					args);

				args = new Object[] {
						contractModelImpl.getOrganizationId(),
						contractModelImpl.getEnterpriseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDENTERPRISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDENTERPRISE,
					args);
			}

			if ((contractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contractModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);

				args = new Object[] { contractModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);
			}

			if ((contractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTERPRISE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contractModelImpl.getOriginalEnterpriseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTERPRISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTERPRISE,
					args);

				args = new Object[] { contractModelImpl.getEnterpriseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTERPRISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTERPRISE,
					args);
			}
		}

		EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey(), contract);

		return contract;
	}

	protected Contract toUnwrappedModel(Contract contract) {
		if (contract instanceof ContractImpl) {
			return contract;
		}

		ContractImpl contractImpl = new ContractImpl();

		contractImpl.setNew(contract.isNew());
		contractImpl.setPrimaryKey(contract.getPrimaryKey());

		contractImpl.setContractId(contract.getContractId());
		contractImpl.setGroupId(contract.getGroupId());
		contractImpl.setCompanyId(contract.getCompanyId());
		contractImpl.setCreateDate(contract.getCreateDate());
		contractImpl.setOrganizationId(contract.getOrganizationId());
		contractImpl.setEnterpriseId(contract.getEnterpriseId());
		contractImpl.setContactId(contract.getContactId());
		contractImpl.setDescription(contract.getDescription());
		contractImpl.setAmount(contract.getAmount());

		return contractImpl;
	}

	/**
	 * Returns the contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract
	 * @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByPrimaryKey(primaryKey);

		if (contract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contract;
	}

	/**
	 * Returns the contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContractException} if it could not be found.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract
	 * @throws com.leancrm.portlet.library.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract findByPrimaryKey(long contractId)
		throws NoSuchContractException, SystemException {
		return findByPrimaryKey((Serializable)contractId);
	}

	/**
	 * Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract, or <code>null</code> if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Contract contract = (Contract)EntityCacheUtil.getResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
				ContractImpl.class, primaryKey);

		if (contract == _nullContract) {
			return null;
		}

		if (contract == null) {
			Session session = null;

			try {
				session = openSession();

				contract = (Contract)session.get(ContractImpl.class, primaryKey);

				if (contract != null) {
					cacheResult(contract);
				}
				else {
					EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
						ContractImpl.class, primaryKey, _nullContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
					ContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contract;
	}

	/**
	 * Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract, or <code>null</code> if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByPrimaryKey(long contractId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contractId);
	}

	/**
	 * Returns all the contracts.
	 *
	 * @return the contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Contract> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Contract> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTRACT;

				if (pagination) {
					sql = sql.concat(ContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Contract contract : findAll()) {
			remove(contract);
		}
	}

	/**
	 * Returns the number of contracts.
	 *
	 * @return the number of contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTRACT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.Contract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contract>> listenersList = new ArrayList<ModelListener<Contract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contract>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTRACT = "SELECT contract FROM Contract contract";
	private static final String _SQL_SELECT_CONTRACT_WHERE = "SELECT contract FROM Contract contract WHERE ";
	private static final String _SQL_COUNT_CONTRACT = "SELECT COUNT(contract) FROM Contract contract";
	private static final String _SQL_COUNT_CONTRACT_WHERE = "SELECT COUNT(contract) FROM Contract contract WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contract exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contract exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContractPersistenceImpl.class);
	private static Contract _nullContract = new ContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Contract> toCacheModel() {
				return _nullContractCacheModel;
			}
		};

	private static CacheModel<Contract> _nullContractCacheModel = new CacheModel<Contract>() {
			@Override
			public Contract toEntityModel() {
				return _nullContract;
			}
		};
}