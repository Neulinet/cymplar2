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

import com.leancrm.portlet.library.NoSuchContactContractException;
import com.leancrm.portlet.library.model.ContactContract;
import com.leancrm.portlet.library.model.impl.ContactContractImpl;
import com.leancrm.portlet.library.model.impl.ContactContractModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the contact contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactContractPersistence
 * @see ContactContractUtil
 * @generated
 */
public class ContactContractPersistenceImpl extends BasePersistenceImpl<ContactContract>
	implements ContactContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactContractUtil} to access the contact contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTCONTRACT =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactContract",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTCONTRACT =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactContract",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactContractModelImpl.CONTRACTID_COLUMN_BITMASK |
			ContactContractModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTCONTRACT = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactContract",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contact contracts where contractId = &#63; and contactId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @return the matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactContract> findByContactContract(long contractId,
		long contactId) throws SystemException {
		return findByContactContract(contractId, contactId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ContactContract> findByContactContract(long contractId,
		long contactId, int start, int end) throws SystemException {
		return findByContactContract(contractId, contactId, start, end, null);
	}

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
	@Override
	public List<ContactContract> findByContactContract(long contractId,
		long contactId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTCONTRACT;
			finderArgs = new Object[] { contractId, contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTCONTRACT;
			finderArgs = new Object[] {
					contractId, contactId,
					
					start, end, orderByComparator
				};
		}

		List<ContactContract> list = (List<ContactContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactContract contactContract : list) {
				if ((contractId != contactContract.getContractId()) ||
						(contactId != contactContract.getContactId())) {
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

			query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTRACTID_2);

			query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactContract>(list);
				}
				else {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContactContract_First(long contractId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContactContract_First(contractId,
				contactId, orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the first contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContactContract_First(long contractId,
		long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactContract> list = findByContactContract(contractId,
				contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract findByContactContract_Last(long contractId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContactContract_Last(contractId,
				contactId, orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the last contact contract in the ordered set where contractId = &#63; and contactId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContactContract_Last(long contractId,
		long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactContract(contractId, contactId);

		if (count == 0) {
			return null;
		}

		List<ContactContract> list = findByContactContract(contractId,
				contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract[] findByContactContract_PrevAndNext(
		ContactContractPK contactContractPK, long contractId, long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = findByPrimaryKey(contactContractPK);

		Session session = null;

		try {
			session = openSession();

			ContactContract[] array = new ContactContractImpl[3];

			array[0] = getByContactContract_PrevAndNext(session,
					contactContract, contractId, contactId, orderByComparator,
					true);

			array[1] = contactContract;

			array[2] = getByContactContract_PrevAndNext(session,
					contactContract, contractId, contactId, orderByComparator,
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

	protected ContactContract getByContactContract_PrevAndNext(
		Session session, ContactContract contactContract, long contractId,
		long contactId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTRACTID_2);

		query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTACTID_2);

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
			query.append(ContactContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contractId);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact contracts where contractId = &#63; and contactId = &#63; from the database.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactContract(long contractId, long contactId)
		throws SystemException {
		for (ContactContract contactContract : findByContactContract(
				contractId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(contactContract);
		}
	}

	/**
	 * Returns the number of contact contracts where contractId = &#63; and contactId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param contactId the contact ID
	 * @return the number of matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactContract(long contractId, long contactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTCONTRACT;

		Object[] finderArgs = new Object[] { contractId, contactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTRACTID_2);

			query.append(_FINDER_COLUMN_CONTACTCONTRACT_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

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

	private static final String _FINDER_COLUMN_CONTACTCONTRACT_CONTRACTID_2 = "contactContract.id.contractId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTCONTRACT_CONTACTID_2 = "contactContract.id.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTRACT = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContract",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContract",
			new String[] { Long.class.getName() },
			ContactContractModelImpl.CONTRACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTRACT = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContract",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact contracts where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactContract> findByContract(long contractId)
		throws SystemException {
		return findByContract(contractId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<ContactContract> findByContract(long contractId, int start,
		int end) throws SystemException {
		return findByContract(contractId, start, end, null);
	}

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
	@Override
	public List<ContactContract> findByContract(long contractId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT;
			finderArgs = new Object[] { contractId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTRACT;
			finderArgs = new Object[] { contractId, start, end, orderByComparator };
		}

		List<ContactContract> list = (List<ContactContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactContract contactContract : list) {
				if ((contractId != contactContract.getContractId())) {
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

			query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

				if (!pagination) {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactContract>(list);
				}
				else {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first contact contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContract_First(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContract_First(contractId,
				orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the first contact contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContract_First(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactContract> list = findByContract(contractId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContract_Last(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContract_Last(contractId,
				orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the last contact contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContract_Last(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContract(contractId);

		if (count == 0) {
			return null;
		}

		List<ContactContract> list = findByContract(contractId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract[] findByContract_PrevAndNext(
		ContactContractPK contactContractPK, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = findByPrimaryKey(contactContractPK);

		Session session = null;

		try {
			session = openSession();

			ContactContract[] array = new ContactContractImpl[3];

			array[0] = getByContract_PrevAndNext(session, contactContract,
					contractId, orderByComparator, true);

			array[1] = contactContract;

			array[2] = getByContract_PrevAndNext(session, contactContract,
					contractId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactContract getByContract_PrevAndNext(Session session,
		ContactContract contactContract, long contractId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

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
			query.append(ContactContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contractId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact contracts where contractId = &#63; from the database.
	 *
	 * @param contractId the contract ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContract(long contractId) throws SystemException {
		for (ContactContract contactContract : findByContract(contractId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactContract);
		}
	}

	/**
	 * Returns the number of contact contracts where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the number of matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContract(long contractId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTRACT;

		Object[] finderArgs = new Object[] { contractId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

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

	private static final String _FINDER_COLUMN_CONTRACT_CONTRACTID_2 = "contactContract.id.contractId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContact",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] { Long.class.getName() },
			ContactContractModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact contracts where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactContract> findByContact(long contactId)
		throws SystemException {
		return findByContact(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<ContactContract> findByContact(long contactId, int start,
		int end) throws SystemException {
		return findByContact(contactId, start, end, null);
	}

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
	@Override
	public List<ContactContract> findByContact(long contactId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId, start, end, orderByComparator };
		}

		List<ContactContract> list = (List<ContactContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactContract contactContract : list) {
				if ((contactId != contactContract.getContactId())) {
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

			query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactContract>(list);
				}
				else {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first contact contract in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContact_First(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContact_First(contactId,
				orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the first contact contract in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContact_First(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactContract> list = findByContact(contactId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact contract in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContact_Last(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContact_Last(contactId,
				orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the last contact contract in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContact_Last(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContact(contactId);

		if (count == 0) {
			return null;
		}

		List<ContactContract> list = findByContact(contactId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract[] findByContact_PrevAndNext(
		ContactContractPK contactContractPK, long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = findByPrimaryKey(contactContractPK);

		Session session = null;

		try {
			session = openSession();

			ContactContract[] array = new ContactContractImpl[3];

			array[0] = getByContact_PrevAndNext(session, contactContract,
					contactId, orderByComparator, true);

			array[1] = contactContract;

			array[2] = getByContact_PrevAndNext(session, contactContract,
					contactId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactContract getByContact_PrevAndNext(Session session,
		ContactContract contactContract, long contactId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

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
			query.append(ContactContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact contracts where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContact(long contactId) throws SystemException {
		for (ContactContract contactContract : findByContact(contactId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactContract);
		}
	}

	/**
	 * Returns the number of contact contracts where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContact(long contactId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACT;

		Object[] finderArgs = new Object[] { contactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "contactContract.id.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDSTATE =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactAndState",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDSTATE =
		new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED,
			ContactContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ContactContractModelImpl.CONTACTID_COLUMN_BITMASK |
			ContactContractModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTANDSTATE = new FinderPath(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the contact contracts where contactId = &#63; and active = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @return the matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactContract> findByContactAndState(long contactId,
		boolean active) throws SystemException {
		return findByContactAndState(contactId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ContactContract> findByContactAndState(long contactId,
		boolean active, int start, int end) throws SystemException {
		return findByContactAndState(contactId, active, start, end, null);
	}

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
	@Override
	public List<ContactContract> findByContactAndState(long contactId,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDSTATE;
			finderArgs = new Object[] { contactId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDSTATE;
			finderArgs = new Object[] {
					contactId, active,
					
					start, end, orderByComparator
				};
		}

		List<ContactContract> list = (List<ContactContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactContract contactContract : list) {
				if ((contactId != contactContract.getContactId()) ||
						(active != contactContract.getActive())) {
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

			query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDSTATE_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTANDSTATE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(active);

				if (!pagination) {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactContract>(list);
				}
				else {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first contact contract in the ordered set where contactId = &#63; and active = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByContactAndState_First(long contactId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContactAndState_First(contactId,
				active, orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the first contact contract in the ordered set where contactId = &#63; and active = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContactAndState_First(long contactId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactContract> list = findByContactAndState(contactId, active,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract findByContactAndState_Last(long contactId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByContactAndState_Last(contactId,
				active, orderByComparator);

		if (contactContract != null) {
			return contactContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactContractException(msg.toString());
	}

	/**
	 * Returns the last contact contract in the ordered set where contactId = &#63; and active = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact contract, or <code>null</code> if a matching contact contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByContactAndState_Last(long contactId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactAndState(contactId, active);

		if (count == 0) {
			return null;
		}

		List<ContactContract> list = findByContactAndState(contactId, active,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ContactContract[] findByContactAndState_PrevAndNext(
		ContactContractPK contactContractPK, long contactId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = findByPrimaryKey(contactContractPK);

		Session session = null;

		try {
			session = openSession();

			ContactContract[] array = new ContactContractImpl[3];

			array[0] = getByContactAndState_PrevAndNext(session,
					contactContract, contactId, active, orderByComparator, true);

			array[1] = contactContract;

			array[2] = getByContactAndState_PrevAndNext(session,
					contactContract, contactId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactContract getByContactAndState_PrevAndNext(
		Session session, ContactContract contactContract, long contactId,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_CONTACTANDSTATE_CONTACTID_2);

		query.append(_FINDER_COLUMN_CONTACTANDSTATE_ACTIVE_2);

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
			query.append(ContactContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact contracts where contactId = &#63; and active = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactAndState(long contactId, boolean active)
		throws SystemException {
		for (ContactContract contactContract : findByContactAndState(
				contactId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactContract);
		}
	}

	/**
	 * Returns the number of contact contracts where contactId = &#63; and active = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param active the active
	 * @return the number of matching contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactAndState(long contactId, boolean active)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTANDSTATE;

		Object[] finderArgs = new Object[] { contactId, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDSTATE_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTANDSTATE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_CONTACTANDSTATE_CONTACTID_2 = "contactContract.id.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTANDSTATE_ACTIVE_2 = "contactContract.active = ?";

	public ContactContractPersistenceImpl() {
		setModelClass(ContactContract.class);
	}

	/**
	 * Caches the contact contract in the entity cache if it is enabled.
	 *
	 * @param contactContract the contact contract
	 */
	@Override
	public void cacheResult(ContactContract contactContract) {
		EntityCacheUtil.putResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractImpl.class, contactContract.getPrimaryKey(),
			contactContract);

		contactContract.resetOriginalValues();
	}

	/**
	 * Caches the contact contracts in the entity cache if it is enabled.
	 *
	 * @param contactContracts the contact contracts
	 */
	@Override
	public void cacheResult(List<ContactContract> contactContracts) {
		for (ContactContract contactContract : contactContracts) {
			if (EntityCacheUtil.getResult(
						ContactContractModelImpl.ENTITY_CACHE_ENABLED,
						ContactContractImpl.class,
						contactContract.getPrimaryKey()) == null) {
				cacheResult(contactContract);
			}
			else {
				contactContract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactContract contactContract) {
		EntityCacheUtil.removeResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractImpl.class, contactContract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactContract> contactContracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactContract contactContract : contactContracts) {
			EntityCacheUtil.removeResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
				ContactContractImpl.class, contactContract.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact contract with the primary key. Does not add the contact contract to the database.
	 *
	 * @param contactContractPK the primary key for the new contact contract
	 * @return the new contact contract
	 */
	@Override
	public ContactContract create(ContactContractPK contactContractPK) {
		ContactContract contactContract = new ContactContractImpl();

		contactContract.setNew(true);
		contactContract.setPrimaryKey(contactContractPK);

		return contactContract;
	}

	/**
	 * Removes the contact contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactContractPK the primary key of the contact contract
	 * @return the contact contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract remove(ContactContractPK contactContractPK)
		throws NoSuchContactContractException, SystemException {
		return remove((Serializable)contactContractPK);
	}

	/**
	 * Removes the contact contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact contract
	 * @return the contact contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract remove(Serializable primaryKey)
		throws NoSuchContactContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactContract contactContract = (ContactContract)session.get(ContactContractImpl.class,
					primaryKey);

			if (contactContract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactContract);
		}
		catch (NoSuchContactContractException nsee) {
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
	protected ContactContract removeImpl(ContactContract contactContract)
		throws SystemException {
		contactContract = toUnwrappedModel(contactContract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactContract)) {
				contactContract = (ContactContract)session.get(ContactContractImpl.class,
						contactContract.getPrimaryKeyObj());
			}

			if (contactContract != null) {
				session.delete(contactContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactContract != null) {
			clearCache(contactContract);
		}

		return contactContract;
	}

	@Override
	public ContactContract updateImpl(
		com.leancrm.portlet.library.model.ContactContract contactContract)
		throws SystemException {
		contactContract = toUnwrappedModel(contactContract);

		boolean isNew = contactContract.isNew();

		ContactContractModelImpl contactContractModelImpl = (ContactContractModelImpl)contactContract;

		Session session = null;

		try {
			session = openSession();

			if (contactContract.isNew()) {
				session.save(contactContract);

				contactContract.setNew(false);
			}
			else {
				session.merge(contactContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactContractModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTCONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactContractModelImpl.getOriginalContractId(),
						contactContractModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTCONTRACT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTCONTRACT,
					args);

				args = new Object[] {
						contactContractModelImpl.getContractId(),
						contactContractModelImpl.getContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTCONTRACT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTCONTRACT,
					args);
			}

			if ((contactContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactContractModelImpl.getOriginalContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);

				args = new Object[] { contactContractModelImpl.getContractId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);
			}

			if ((contactContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactContractModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] { contactContractModelImpl.getContactId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}

			if ((contactContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDSTATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactContractModelImpl.getOriginalContactId(),
						contactContractModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDSTATE,
					args);

				args = new Object[] {
						contactContractModelImpl.getContactId(),
						contactContractModelImpl.getActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDSTATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
			ContactContractImpl.class, contactContract.getPrimaryKey(),
			contactContract);

		return contactContract;
	}

	protected ContactContract toUnwrappedModel(ContactContract contactContract) {
		if (contactContract instanceof ContactContractImpl) {
			return contactContract;
		}

		ContactContractImpl contactContractImpl = new ContactContractImpl();

		contactContractImpl.setNew(contactContract.isNew());
		contactContractImpl.setPrimaryKey(contactContract.getPrimaryKey());

		contactContractImpl.setContactId(contactContract.getContactId());
		contactContractImpl.setContractId(contactContract.getContractId());
		contactContractImpl.setActive(contactContract.isActive());

		return contactContractImpl;
	}

	/**
	 * Returns the contact contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact contract
	 * @return the contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactContractException, SystemException {
		ContactContract contactContract = fetchByPrimaryKey(primaryKey);

		if (contactContract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactContract;
	}

	/**
	 * Returns the contact contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactContractException} if it could not be found.
	 *
	 * @param contactContractPK the primary key of the contact contract
	 * @return the contact contract
	 * @throws com.leancrm.portlet.library.NoSuchContactContractException if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract findByPrimaryKey(ContactContractPK contactContractPK)
		throws NoSuchContactContractException, SystemException {
		return findByPrimaryKey((Serializable)contactContractPK);
	}

	/**
	 * Returns the contact contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact contract
	 * @return the contact contract, or <code>null</code> if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactContract contactContract = (ContactContract)EntityCacheUtil.getResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
				ContactContractImpl.class, primaryKey);

		if (contactContract == _nullContactContract) {
			return null;
		}

		if (contactContract == null) {
			Session session = null;

			try {
				session = openSession();

				contactContract = (ContactContract)session.get(ContactContractImpl.class,
						primaryKey);

				if (contactContract != null) {
					cacheResult(contactContract);
				}
				else {
					EntityCacheUtil.putResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
						ContactContractImpl.class, primaryKey,
						_nullContactContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactContractModelImpl.ENTITY_CACHE_ENABLED,
					ContactContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactContract;
	}

	/**
	 * Returns the contact contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactContractPK the primary key of the contact contract
	 * @return the contact contract, or <code>null</code> if a contact contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactContract fetchByPrimaryKey(
		ContactContractPK contactContractPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)contactContractPK);
	}

	/**
	 * Returns all the contact contracts.
	 *
	 * @return the contact contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactContract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ContactContract> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ContactContract> findAll(int start, int end,
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

		List<ContactContract> list = (List<ContactContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTCONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTCONTRACT;

				if (pagination) {
					sql = sql.concat(ContactContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactContract>(list);
				}
				else {
					list = (List<ContactContract>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the contact contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactContract contactContract : findAll()) {
			remove(contactContract);
		}
	}

	/**
	 * Returns the number of contact contracts.
	 *
	 * @return the number of contact contracts
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTCONTRACT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the contact contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactContract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactContract>> listenersList = new ArrayList<ModelListener<ContactContract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactContract>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTCONTRACT = "SELECT contactContract FROM ContactContract contactContract";
	private static final String _SQL_SELECT_CONTACTCONTRACT_WHERE = "SELECT contactContract FROM ContactContract contactContract WHERE ";
	private static final String _SQL_COUNT_CONTACTCONTRACT = "SELECT COUNT(contactContract) FROM ContactContract contactContract";
	private static final String _SQL_COUNT_CONTACTCONTRACT_WHERE = "SELECT COUNT(contactContract) FROM ContactContract contactContract WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactContract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactContract exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactContract exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactContractPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static ContactContract _nullContactContract = new ContactContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactContract> toCacheModel() {
				return _nullContactContractCacheModel;
			}
		};

	private static CacheModel<ContactContract> _nullContactContractCacheModel = new CacheModel<ContactContract>() {
			@Override
			public ContactContract toEntityModel() {
				return _nullContactContract;
			}
		};
}