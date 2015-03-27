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

import com.leancrm.portlet.library.NoSuchUserContractException;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.model.impl.UserContractImpl;
import com.leancrm.portlet.library.model.impl.UserContractModelImpl;

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
 * The persistence implementation for the user contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserContractPersistence
 * @see UserContractUtil
 * @generated
 */
public class UserContractPersistenceImpl extends BasePersistenceImpl<UserContract>
	implements UserContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserContractUtil} to access the user contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCONTRACT =
		new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserContract",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCONTRACT =
		new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserContract",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserContractModelImpl.USERID_COLUMN_BITMASK |
			UserContractModelImpl.CONTRACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERCONTRACT = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserContract",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user contracts where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @return the matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByUserContract(long userId, long contractId)
		throws SystemException {
		return findByUserContract(userId, contractId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user contracts where userId = &#63; and contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of user contracts
	 * @param end the upper bound of the range of user contracts (not inclusive)
	 * @return the range of matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByUserContract(long userId, long contractId,
		int start, int end) throws SystemException {
		return findByUserContract(userId, contractId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user contracts where userId = &#63; and contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.UserContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of user contracts
	 * @param end the upper bound of the range of user contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByUserContract(long userId, long contractId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCONTRACT;
			finderArgs = new Object[] { userId, contractId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCONTRACT;
			finderArgs = new Object[] {
					userId, contractId,
					
					start, end, orderByComparator
				};
		}

		List<UserContract> list = (List<UserContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserContract userContract : list) {
				if ((userId != userContract.getUserId()) ||
						(contractId != userContract.getContractId())) {
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

			query.append(_SQL_SELECT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USERCONTRACT_USERID_2);

			query.append(_FINDER_COLUMN_USERCONTRACT_CONTRACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(contractId);

				if (!pagination) {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserContract>(list);
				}
				else {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user contract in the ordered set where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByUserContract_First(long userId, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUserContract_First(userId,
				contractId, orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the first user contract in the ordered set where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByUserContract_First(long userId, long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserContract> list = findByUserContract(userId, contractId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user contract in the ordered set where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByUserContract_Last(long userId, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUserContract_Last(userId,
				contractId, orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the last user contract in the ordered set where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByUserContract_Last(long userId, long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserContract(userId, contractId);

		if (count == 0) {
			return null;
		}

		List<UserContract> list = findByUserContract(userId, contractId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user contracts before and after the current user contract in the ordered set where userId = &#63; and contractId = &#63;.
	 *
	 * @param userContractPK the primary key of the current user contract
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract[] findByUserContract_PrevAndNext(
		UserContractPK userContractPK, long userId, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = findByPrimaryKey(userContractPK);

		Session session = null;

		try {
			session = openSession();

			UserContract[] array = new UserContractImpl[3];

			array[0] = getByUserContract_PrevAndNext(session, userContract,
					userId, contractId, orderByComparator, true);

			array[1] = userContract;

			array[2] = getByUserContract_PrevAndNext(session, userContract,
					userId, contractId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserContract getByUserContract_PrevAndNext(Session session,
		UserContract userContract, long userId, long contractId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_USERCONTRACT_USERID_2);

		query.append(_FINDER_COLUMN_USERCONTRACT_CONTRACTID_2);

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
			query.append(UserContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(contractId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user contracts where userId = &#63; and contractId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserContract(long userId, long contractId)
		throws SystemException {
		for (UserContract userContract : findByUserContract(userId, contractId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userContract);
		}
	}

	/**
	 * Returns the number of user contracts where userId = &#63; and contractId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contractId the contract ID
	 * @return the number of matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserContract(long userId, long contractId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERCONTRACT;

		Object[] finderArgs = new Object[] { userId, contractId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USERCONTRACT_USERID_2);

			query.append(_FINDER_COLUMN_USERCONTRACT_CONTRACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERCONTRACT_USERID_2 = "userContract.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERCONTRACT_CONTRACTID_2 = "userContract.id.contractId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTRACT = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContract",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT =
		new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContract",
			new String[] { Long.class.getName() },
			UserContractModelImpl.CONTRACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTRACT = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContract",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user contracts where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByContract(long contractId)
		throws SystemException {
		return findByContract(contractId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<UserContract> findByContract(long contractId, int start, int end)
		throws SystemException {
		return findByContract(contractId, start, end, null);
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
	@Override
	public List<UserContract> findByContract(long contractId, int start,
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

		List<UserContract> list = (List<UserContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserContract userContract : list) {
				if ((contractId != userContract.getContractId())) {
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

			query.append(_SQL_SELECT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

				if (!pagination) {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserContract>(list);
				}
				else {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByContract_First(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByContract_First(contractId,
				orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the first user contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByContract_First(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserContract> list = findByContract(contractId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract findByContract_Last(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByContract_Last(contractId,
				orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the last user contract in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByContract_Last(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContract(contractId);

		if (count == 0) {
			return null;
		}

		List<UserContract> list = findByContract(contractId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract[] findByContract_PrevAndNext(
		UserContractPK userContractPK, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = findByPrimaryKey(userContractPK);

		Session session = null;

		try {
			session = openSession();

			UserContract[] array = new UserContractImpl[3];

			array[0] = getByContract_PrevAndNext(session, userContract,
					contractId, orderByComparator, true);

			array[1] = userContract;

			array[2] = getByContract_PrevAndNext(session, userContract,
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

	protected UserContract getByContract_PrevAndNext(Session session,
		UserContract userContract, long contractId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCONTRACT_WHERE);

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
			query.append(UserContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contractId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user contracts where contractId = &#63; from the database.
	 *
	 * @param contractId the contract ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContract(long contractId) throws SystemException {
		for (UserContract userContract : findByContract(contractId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userContract);
		}
	}

	/**
	 * Returns the number of user contracts where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the number of matching user contracts
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

			query.append(_SQL_COUNT_USERCONTRACT_WHERE);

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

	private static final String _FINDER_COLUMN_CONTRACT_CONTRACTID_2 = "userContract.id.contractId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			UserContractModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user contracts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserContract> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<UserContract> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserContract> list = (List<UserContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserContract userContract : list) {
				if ((userId != userContract.getUserId())) {
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

			query.append(_SQL_SELECT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserContract>(list);
				}
				else {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user contract in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUser_First(userId, orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the first user contract in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserContract> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUser_Last(userId, orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
	}

	/**
	 * Returns the last user contract in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user contract, or <code>null</code> if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<UserContract> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract[] findByUser_PrevAndNext(
		UserContractPK userContractPK, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = findByPrimaryKey(userContractPK);

		Session session = null;

		try {
			session = openSession();

			UserContract[] array = new UserContractImpl[3];

			array[0] = getByUser_PrevAndNext(session, userContract, userId,
					orderByComparator, true);

			array[1] = userContract;

			array[2] = getByUser_PrevAndNext(session, userContract, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserContract getByUser_PrevAndNext(Session session,
		UserContract userContract, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(UserContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user contracts where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (UserContract userContract : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userContract);
		}
	}

	/**
	 * Returns the number of user contracts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "userContract.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDSTATE =
		new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAndState",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDSTATE =
		new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, UserContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			UserContractModelImpl.USERID_COLUMN_BITMASK |
			UserContractModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDSTATE = new FinderPath(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserAndState",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the user contracts where userId = &#63; and active = &#63;.
	 *
	 * @param userId the user ID
	 * @param active the active
	 * @return the matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findByUserAndState(long userId, boolean active)
		throws SystemException {
		return findByUserAndState(userId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserContract> findByUserAndState(long userId, boolean active,
		int start, int end) throws SystemException {
		return findByUserAndState(userId, active, start, end, null);
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
	@Override
	public List<UserContract> findByUserAndState(long userId, boolean active,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDSTATE;
			finderArgs = new Object[] { userId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDSTATE;
			finderArgs = new Object[] {
					userId, active,
					
					start, end, orderByComparator
				};
		}

		List<UserContract> list = (List<UserContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserContract userContract : list) {
				if ((userId != userContract.getUserId()) ||
						(active != userContract.getActive())) {
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

			query.append(_SQL_SELECT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USERANDSTATE_USERID_2);

			query.append(_FINDER_COLUMN_USERANDSTATE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(active);

				if (!pagination) {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserContract>(list);
				}
				else {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user contract in the ordered set where userId = &#63; and active = &#63;.
	 *
	 * @param userId the user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a matching user contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByUserAndState_First(long userId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUserAndState_First(userId, active,
				orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
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
	@Override
	public UserContract fetchByUserAndState_First(long userId, boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserContract> list = findByUserAndState(userId, active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract findByUserAndState_Last(long userId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByUserAndState_Last(userId, active,
				orderByComparator);

		if (userContract != null) {
			return userContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserContractException(msg.toString());
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
	@Override
	public UserContract fetchByUserAndState_Last(long userId, boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserAndState(userId, active);

		if (count == 0) {
			return null;
		}

		List<UserContract> list = findByUserAndState(userId, active, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserContract[] findByUserAndState_PrevAndNext(
		UserContractPK userContractPK, long userId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = findByPrimaryKey(userContractPK);

		Session session = null;

		try {
			session = openSession();

			UserContract[] array = new UserContractImpl[3];

			array[0] = getByUserAndState_PrevAndNext(session, userContract,
					userId, active, orderByComparator, true);

			array[1] = userContract;

			array[2] = getByUserAndState_PrevAndNext(session, userContract,
					userId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserContract getByUserAndState_PrevAndNext(Session session,
		UserContract userContract, long userId, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCONTRACT_WHERE);

		query.append(_FINDER_COLUMN_USERANDSTATE_USERID_2);

		query.append(_FINDER_COLUMN_USERANDSTATE_ACTIVE_2);

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
			query.append(UserContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user contracts where userId = &#63; and active = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserAndState(long userId, boolean active)
		throws SystemException {
		for (UserContract userContract : findByUserAndState(userId, active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userContract);
		}
	}

	/**
	 * Returns the number of user contracts where userId = &#63; and active = &#63;.
	 *
	 * @param userId the user ID
	 * @param active the active
	 * @return the number of matching user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserAndState(long userId, boolean active)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERANDSTATE;

		Object[] finderArgs = new Object[] { userId, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_USERANDSTATE_USERID_2);

			query.append(_FINDER_COLUMN_USERANDSTATE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERANDSTATE_USERID_2 = "userContract.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDSTATE_ACTIVE_2 = "userContract.active = ?";

	public UserContractPersistenceImpl() {
		setModelClass(UserContract.class);
	}

	/**
	 * Caches the user contract in the entity cache if it is enabled.
	 *
	 * @param userContract the user contract
	 */
	@Override
	public void cacheResult(UserContract userContract) {
		EntityCacheUtil.putResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractImpl.class, userContract.getPrimaryKey(), userContract);

		userContract.resetOriginalValues();
	}

	/**
	 * Caches the user contracts in the entity cache if it is enabled.
	 *
	 * @param userContracts the user contracts
	 */
	@Override
	public void cacheResult(List<UserContract> userContracts) {
		for (UserContract userContract : userContracts) {
			if (EntityCacheUtil.getResult(
						UserContractModelImpl.ENTITY_CACHE_ENABLED,
						UserContractImpl.class, userContract.getPrimaryKey()) == null) {
				cacheResult(userContract);
			}
			else {
				userContract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserContract userContract) {
		EntityCacheUtil.removeResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractImpl.class, userContract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserContract> userContracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserContract userContract : userContracts) {
			EntityCacheUtil.removeResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
				UserContractImpl.class, userContract.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user contract with the primary key. Does not add the user contract to the database.
	 *
	 * @param userContractPK the primary key for the new user contract
	 * @return the new user contract
	 */
	@Override
	public UserContract create(UserContractPK userContractPK) {
		UserContract userContract = new UserContractImpl();

		userContract.setNew(true);
		userContract.setPrimaryKey(userContractPK);

		return userContract;
	}

	/**
	 * Removes the user contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userContractPK the primary key of the user contract
	 * @return the user contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract remove(UserContractPK userContractPK)
		throws NoSuchUserContractException, SystemException {
		return remove((Serializable)userContractPK);
	}

	/**
	 * Removes the user contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user contract
	 * @return the user contract that was removed
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract remove(Serializable primaryKey)
		throws NoSuchUserContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserContract userContract = (UserContract)session.get(UserContractImpl.class,
					primaryKey);

			if (userContract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userContract);
		}
		catch (NoSuchUserContractException nsee) {
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
	protected UserContract removeImpl(UserContract userContract)
		throws SystemException {
		userContract = toUnwrappedModel(userContract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userContract)) {
				userContract = (UserContract)session.get(UserContractImpl.class,
						userContract.getPrimaryKeyObj());
			}

			if (userContract != null) {
				session.delete(userContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userContract != null) {
			clearCache(userContract);
		}

		return userContract;
	}

	@Override
	public UserContract updateImpl(
		com.leancrm.portlet.library.model.UserContract userContract)
		throws SystemException {
		userContract = toUnwrappedModel(userContract);

		boolean isNew = userContract.isNew();

		UserContractModelImpl userContractModelImpl = (UserContractModelImpl)userContract;

		Session session = null;

		try {
			session = openSession();

			if (userContract.isNew()) {
				session.save(userContract);

				userContract.setNew(false);
			}
			else {
				session.merge(userContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserContractModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userContractModelImpl.getOriginalUserId(),
						userContractModelImpl.getOriginalContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCONTRACT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCONTRACT,
					args);

				args = new Object[] {
						userContractModelImpl.getUserId(),
						userContractModelImpl.getContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCONTRACT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCONTRACT,
					args);
			}

			if ((userContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userContractModelImpl.getOriginalContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);

				args = new Object[] { userContractModelImpl.getContractId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);
			}

			if ((userContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userContractModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { userContractModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((userContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDSTATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userContractModelImpl.getOriginalUserId(),
						userContractModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDSTATE,
					args);

				args = new Object[] {
						userContractModelImpl.getUserId(),
						userContractModelImpl.getActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDSTATE,
					args);
			}
		}

		EntityCacheUtil.putResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
			UserContractImpl.class, userContract.getPrimaryKey(), userContract);

		return userContract;
	}

	protected UserContract toUnwrappedModel(UserContract userContract) {
		if (userContract instanceof UserContractImpl) {
			return userContract;
		}

		UserContractImpl userContractImpl = new UserContractImpl();

		userContractImpl.setNew(userContract.isNew());
		userContractImpl.setPrimaryKey(userContract.getPrimaryKey());

		userContractImpl.setUserId(userContract.getUserId());
		userContractImpl.setContractId(userContract.getContractId());
		userContractImpl.setActive(userContract.isActive());

		return userContractImpl;
	}

	/**
	 * Returns the user contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user contract
	 * @return the user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserContractException, SystemException {
		UserContract userContract = fetchByPrimaryKey(primaryKey);

		if (userContract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userContract;
	}

	/**
	 * Returns the user contract with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchUserContractException} if it could not be found.
	 *
	 * @param userContractPK the primary key of the user contract
	 * @return the user contract
	 * @throws com.leancrm.portlet.library.NoSuchUserContractException if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract findByPrimaryKey(UserContractPK userContractPK)
		throws NoSuchUserContractException, SystemException {
		return findByPrimaryKey((Serializable)userContractPK);
	}

	/**
	 * Returns the user contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user contract
	 * @return the user contract, or <code>null</code> if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserContract userContract = (UserContract)EntityCacheUtil.getResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
				UserContractImpl.class, primaryKey);

		if (userContract == _nullUserContract) {
			return null;
		}

		if (userContract == null) {
			Session session = null;

			try {
				session = openSession();

				userContract = (UserContract)session.get(UserContractImpl.class,
						primaryKey);

				if (userContract != null) {
					cacheResult(userContract);
				}
				else {
					EntityCacheUtil.putResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
						UserContractImpl.class, primaryKey, _nullUserContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserContractModelImpl.ENTITY_CACHE_ENABLED,
					UserContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userContract;
	}

	/**
	 * Returns the user contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userContractPK the primary key of the user contract
	 * @return the user contract, or <code>null</code> if a user contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserContract fetchByPrimaryKey(UserContractPK userContractPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userContractPK);
	}

	/**
	 * Returns all the user contracts.
	 *
	 * @return the user contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserContract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserContract> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<UserContract> findAll(int start, int end,
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

		List<UserContract> list = (List<UserContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERCONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERCONTRACT;

				if (pagination) {
					sql = sql.concat(UserContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserContract>(list);
				}
				else {
					list = (List<UserContract>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserContract userContract : findAll()) {
			remove(userContract);
		}
	}

	/**
	 * Returns the number of user contracts.
	 *
	 * @return the number of user contracts
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

				Query q = session.createQuery(_SQL_COUNT_USERCONTRACT);

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
	 * Initializes the user contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.UserContract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserContract>> listenersList = new ArrayList<ModelListener<UserContract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserContract>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERCONTRACT = "SELECT userContract FROM UserContract userContract";
	private static final String _SQL_SELECT_USERCONTRACT_WHERE = "SELECT userContract FROM UserContract userContract WHERE ";
	private static final String _SQL_COUNT_USERCONTRACT = "SELECT COUNT(userContract) FROM UserContract userContract";
	private static final String _SQL_COUNT_USERCONTRACT_WHERE = "SELECT COUNT(userContract) FROM UserContract userContract WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userContract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserContract exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserContract exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserContractPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static UserContract _nullUserContract = new UserContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserContract> toCacheModel() {
				return _nullUserContractCacheModel;
			}
		};

	private static CacheModel<UserContract> _nullUserContractCacheModel = new CacheModel<UserContract>() {
			@Override
			public UserContract toEntityModel() {
				return _nullUserContract;
			}
		};
}