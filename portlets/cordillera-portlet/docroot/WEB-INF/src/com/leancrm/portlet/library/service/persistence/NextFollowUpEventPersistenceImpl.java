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

import com.leancrm.portlet.library.NoSuchNextFollowUpEventException;
import com.leancrm.portlet.library.model.NextFollowUpEvent;
import com.leancrm.portlet.library.model.impl.NextFollowUpEventImpl;
import com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl;

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
 * The persistence implementation for the next follow up event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NextFollowUpEventPersistence
 * @see NextFollowUpEventUtil
 * @generated
 */
public class NextFollowUpEventPersistenceImpl extends BasePersistenceImpl<NextFollowUpEvent>
	implements NextFollowUpEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NextFollowUpEventUtil} to access the next follow up event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NextFollowUpEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTRACT = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContract",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT =
		new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContract",
			new String[] { Long.class.getName() },
			NextFollowUpEventModelImpl.CONTRACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTRACT = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContract",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the next follow up events where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByContract(long contractId)
		throws SystemException {
		return findByContract(contractId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the next follow up events where contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @return the range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByContract(long contractId, int start,
		int end) throws SystemException {
		return findByContract(contractId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the next follow up events where contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByContract(long contractId, int start,
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

		List<NextFollowUpEvent> list = (List<NextFollowUpEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NextFollowUpEvent nextFollowUpEvent : list) {
				if ((contractId != nextFollowUpEvent.getContractId())) {
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

			query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

			query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

				if (!pagination) {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NextFollowUpEvent>(list);
				}
				else {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
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
	 * Returns the first next follow up event in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByContract_First(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByContract_First(contractId,
				orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the first next follow up event in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByContract_First(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		List<NextFollowUpEvent> list = findByContract(contractId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last next follow up event in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByContract_Last(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByContract_Last(contractId,
				orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the last next follow up event in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByContract_Last(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContract(contractId);

		if (count == 0) {
			return null;
		}

		List<NextFollowUpEvent> list = findByContract(contractId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the next follow up events before and after the current next follow up event in the ordered set where contractId = &#63;.
	 *
	 * @param eventId the primary key of the current next follow up event
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent[] findByContract_PrevAndNext(long eventId,
		long contractId, OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			NextFollowUpEvent[] array = new NextFollowUpEventImpl[3];

			array[0] = getByContract_PrevAndNext(session, nextFollowUpEvent,
					contractId, orderByComparator, true);

			array[1] = nextFollowUpEvent;

			array[2] = getByContract_PrevAndNext(session, nextFollowUpEvent,
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

	protected NextFollowUpEvent getByContract_PrevAndNext(Session session,
		NextFollowUpEvent nextFollowUpEvent, long contractId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

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
			query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contractId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nextFollowUpEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NextFollowUpEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the next follow up events where contractId = &#63; from the database.
	 *
	 * @param contractId the contract ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContract(long contractId) throws SystemException {
		for (NextFollowUpEvent nextFollowUpEvent : findByContract(contractId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(nextFollowUpEvent);
		}
	}

	/**
	 * Returns the number of next follow up events where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the number of matching next follow up events
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

			query.append(_SQL_COUNT_NEXTFOLLOWUPEVENT_WHERE);

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

	private static final String _FINDER_COLUMN_CONTRACT_CONTRACTID_2 = "nextFollowUpEvent.contractId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORT = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReport",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT =
		new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReport",
			new String[] { Long.class.getName() },
			NextFollowUpEventModelImpl.REPORTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORT = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReport",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the next follow up events where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReport(long reportId)
		throws SystemException {
		return findByReport(reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the next follow up events where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @return the range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReport(long reportId, int start,
		int end) throws SystemException {
		return findByReport(reportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the next follow up events where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReport(long reportId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT;
			finderArgs = new Object[] { reportId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORT;
			finderArgs = new Object[] { reportId, start, end, orderByComparator };
		}

		List<NextFollowUpEvent> list = (List<NextFollowUpEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NextFollowUpEvent nextFollowUpEvent : list) {
				if ((reportId != nextFollowUpEvent.getReportId())) {
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

			query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

			query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				if (!pagination) {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NextFollowUpEvent>(list);
				}
				else {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
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
	 * Returns the first next follow up event in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByReport_First(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByReport_First(reportId,
				orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the first next follow up event in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByReport_First(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		List<NextFollowUpEvent> list = findByReport(reportId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last next follow up event in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByReport_Last(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByReport_Last(reportId,
				orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the last next follow up event in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByReport_Last(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReport(reportId);

		if (count == 0) {
			return null;
		}

		List<NextFollowUpEvent> list = findByReport(reportId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the next follow up events before and after the current next follow up event in the ordered set where reportId = &#63;.
	 *
	 * @param eventId the primary key of the current next follow up event
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent[] findByReport_PrevAndNext(long eventId,
		long reportId, OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			NextFollowUpEvent[] array = new NextFollowUpEventImpl[3];

			array[0] = getByReport_PrevAndNext(session, nextFollowUpEvent,
					reportId, orderByComparator, true);

			array[1] = nextFollowUpEvent;

			array[2] = getByReport_PrevAndNext(session, nextFollowUpEvent,
					reportId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NextFollowUpEvent getByReport_PrevAndNext(Session session,
		NextFollowUpEvent nextFollowUpEvent, long reportId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

		query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

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
			query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nextFollowUpEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NextFollowUpEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the next follow up events where reportId = &#63; from the database.
	 *
	 * @param reportId the report ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReport(long reportId) throws SystemException {
		for (NextFollowUpEvent nextFollowUpEvent : findByReport(reportId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(nextFollowUpEvent);
		}
	}

	/**
	 * Returns the number of next follow up events where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the number of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReport(long reportId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORT;

		Object[] finderArgs = new Object[] { reportId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NEXTFOLLOWUPEVENT_WHERE);

			query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

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

	private static final String _FINDER_COLUMN_REPORT_REPORTID_2 = "nextFollowUpEvent.reportId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTSTATUS =
		new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReportStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTATUS =
		new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED,
			NextFollowUpEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReportStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			NextFollowUpEventModelImpl.REPORTID_COLUMN_BITMASK |
			NextFollowUpEventModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTSTATUS = new FinderPath(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReportStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the next follow up events where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @return the matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReportStatus(long reportId, int status)
		throws SystemException {
		return findByReportStatus(reportId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the next follow up events where reportId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @return the range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReportStatus(long reportId,
		int status, int start, int end) throws SystemException {
		return findByReportStatus(reportId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the next follow up events where reportId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findByReportStatus(long reportId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTATUS;
			finderArgs = new Object[] { reportId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTSTATUS;
			finderArgs = new Object[] {
					reportId, status,
					
					start, end, orderByComparator
				};
		}

		List<NextFollowUpEvent> list = (List<NextFollowUpEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NextFollowUpEvent nextFollowUpEvent : list) {
				if ((reportId != nextFollowUpEvent.getReportId()) ||
						(status != nextFollowUpEvent.getStatus())) {
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

			query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

			query.append(_FINDER_COLUMN_REPORTSTATUS_REPORTID_2);

			query.append(_FINDER_COLUMN_REPORTSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				qPos.add(status);

				if (!pagination) {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NextFollowUpEvent>(list);
				}
				else {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
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
	 * Returns the first next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByReportStatus_First(long reportId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByReportStatus_First(reportId,
				status, orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the first next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByReportStatus_First(long reportId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<NextFollowUpEvent> list = findByReportStatus(reportId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByReportStatus_Last(long reportId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByReportStatus_Last(reportId,
				status, orderByComparator);

		if (nextFollowUpEvent != null) {
			return nextFollowUpEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNextFollowUpEventException(msg.toString());
	}

	/**
	 * Returns the last next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching next follow up event, or <code>null</code> if a matching next follow up event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByReportStatus_Last(long reportId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReportStatus(reportId, status);

		if (count == 0) {
			return null;
		}

		List<NextFollowUpEvent> list = findByReportStatus(reportId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the next follow up events before and after the current next follow up event in the ordered set where reportId = &#63; and status = &#63;.
	 *
	 * @param eventId the primary key of the current next follow up event
	 * @param reportId the report ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent[] findByReportStatus_PrevAndNext(long eventId,
		long reportId, int status, OrderByComparator orderByComparator)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			NextFollowUpEvent[] array = new NextFollowUpEventImpl[3];

			array[0] = getByReportStatus_PrevAndNext(session,
					nextFollowUpEvent, reportId, status, orderByComparator, true);

			array[1] = nextFollowUpEvent;

			array[2] = getByReportStatus_PrevAndNext(session,
					nextFollowUpEvent, reportId, status, orderByComparator,
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

	protected NextFollowUpEvent getByReportStatus_PrevAndNext(Session session,
		NextFollowUpEvent nextFollowUpEvent, long reportId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE);

		query.append(_FINDER_COLUMN_REPORTSTATUS_REPORTID_2);

		query.append(_FINDER_COLUMN_REPORTSTATUS_STATUS_2);

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
			query.append(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nextFollowUpEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NextFollowUpEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the next follow up events where reportId = &#63; and status = &#63; from the database.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReportStatus(long reportId, int status)
		throws SystemException {
		for (NextFollowUpEvent nextFollowUpEvent : findByReportStatus(
				reportId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(nextFollowUpEvent);
		}
	}

	/**
	 * Returns the number of next follow up events where reportId = &#63; and status = &#63;.
	 *
	 * @param reportId the report ID
	 * @param status the status
	 * @return the number of matching next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReportStatus(long reportId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTSTATUS;

		Object[] finderArgs = new Object[] { reportId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NEXTFOLLOWUPEVENT_WHERE);

			query.append(_FINDER_COLUMN_REPORTSTATUS_REPORTID_2);

			query.append(_FINDER_COLUMN_REPORTSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_REPORTSTATUS_REPORTID_2 = "nextFollowUpEvent.reportId = ? AND ";
	private static final String _FINDER_COLUMN_REPORTSTATUS_STATUS_2 = "nextFollowUpEvent.status = ?";

	public NextFollowUpEventPersistenceImpl() {
		setModelClass(NextFollowUpEvent.class);
	}

	/**
	 * Caches the next follow up event in the entity cache if it is enabled.
	 *
	 * @param nextFollowUpEvent the next follow up event
	 */
	@Override
	public void cacheResult(NextFollowUpEvent nextFollowUpEvent) {
		EntityCacheUtil.putResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventImpl.class, nextFollowUpEvent.getPrimaryKey(),
			nextFollowUpEvent);

		nextFollowUpEvent.resetOriginalValues();
	}

	/**
	 * Caches the next follow up events in the entity cache if it is enabled.
	 *
	 * @param nextFollowUpEvents the next follow up events
	 */
	@Override
	public void cacheResult(List<NextFollowUpEvent> nextFollowUpEvents) {
		for (NextFollowUpEvent nextFollowUpEvent : nextFollowUpEvents) {
			if (EntityCacheUtil.getResult(
						NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
						NextFollowUpEventImpl.class,
						nextFollowUpEvent.getPrimaryKey()) == null) {
				cacheResult(nextFollowUpEvent);
			}
			else {
				nextFollowUpEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all next follow up events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NextFollowUpEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NextFollowUpEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the next follow up event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NextFollowUpEvent nextFollowUpEvent) {
		EntityCacheUtil.removeResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventImpl.class, nextFollowUpEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NextFollowUpEvent> nextFollowUpEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NextFollowUpEvent nextFollowUpEvent : nextFollowUpEvents) {
			EntityCacheUtil.removeResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
				NextFollowUpEventImpl.class, nextFollowUpEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new next follow up event with the primary key. Does not add the next follow up event to the database.
	 *
	 * @param eventId the primary key for the new next follow up event
	 * @return the new next follow up event
	 */
	@Override
	public NextFollowUpEvent create(long eventId) {
		NextFollowUpEvent nextFollowUpEvent = new NextFollowUpEventImpl();

		nextFollowUpEvent.setNew(true);
		nextFollowUpEvent.setPrimaryKey(eventId);

		return nextFollowUpEvent;
	}

	/**
	 * Removes the next follow up event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the next follow up event
	 * @return the next follow up event that was removed
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent remove(long eventId)
		throws NoSuchNextFollowUpEventException, SystemException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the next follow up event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the next follow up event
	 * @return the next follow up event that was removed
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent remove(Serializable primaryKey)
		throws NoSuchNextFollowUpEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NextFollowUpEvent nextFollowUpEvent = (NextFollowUpEvent)session.get(NextFollowUpEventImpl.class,
					primaryKey);

			if (nextFollowUpEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNextFollowUpEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nextFollowUpEvent);
		}
		catch (NoSuchNextFollowUpEventException nsee) {
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
	protected NextFollowUpEvent removeImpl(NextFollowUpEvent nextFollowUpEvent)
		throws SystemException {
		nextFollowUpEvent = toUnwrappedModel(nextFollowUpEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nextFollowUpEvent)) {
				nextFollowUpEvent = (NextFollowUpEvent)session.get(NextFollowUpEventImpl.class,
						nextFollowUpEvent.getPrimaryKeyObj());
			}

			if (nextFollowUpEvent != null) {
				session.delete(nextFollowUpEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nextFollowUpEvent != null) {
			clearCache(nextFollowUpEvent);
		}

		return nextFollowUpEvent;
	}

	@Override
	public NextFollowUpEvent updateImpl(
		com.leancrm.portlet.library.model.NextFollowUpEvent nextFollowUpEvent)
		throws SystemException {
		nextFollowUpEvent = toUnwrappedModel(nextFollowUpEvent);

		boolean isNew = nextFollowUpEvent.isNew();

		NextFollowUpEventModelImpl nextFollowUpEventModelImpl = (NextFollowUpEventModelImpl)nextFollowUpEvent;

		Session session = null;

		try {
			session = openSession();

			if (nextFollowUpEvent.isNew()) {
				session.save(nextFollowUpEvent);

				nextFollowUpEvent.setNew(false);
			}
			else {
				session.merge(nextFollowUpEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NextFollowUpEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((nextFollowUpEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nextFollowUpEventModelImpl.getOriginalContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);

				args = new Object[] { nextFollowUpEventModelImpl.getContractId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);
			}

			if ((nextFollowUpEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nextFollowUpEventModelImpl.getOriginalReportId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT,
					args);

				args = new Object[] { nextFollowUpEventModelImpl.getReportId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT,
					args);
			}

			if ((nextFollowUpEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nextFollowUpEventModelImpl.getOriginalReportId(),
						nextFollowUpEventModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTATUS,
					args);

				args = new Object[] {
						nextFollowUpEventModelImpl.getReportId(),
						nextFollowUpEventModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
			NextFollowUpEventImpl.class, nextFollowUpEvent.getPrimaryKey(),
			nextFollowUpEvent);

		return nextFollowUpEvent;
	}

	protected NextFollowUpEvent toUnwrappedModel(
		NextFollowUpEvent nextFollowUpEvent) {
		if (nextFollowUpEvent instanceof NextFollowUpEventImpl) {
			return nextFollowUpEvent;
		}

		NextFollowUpEventImpl nextFollowUpEventImpl = new NextFollowUpEventImpl();

		nextFollowUpEventImpl.setNew(nextFollowUpEvent.isNew());
		nextFollowUpEventImpl.setPrimaryKey(nextFollowUpEvent.getPrimaryKey());

		nextFollowUpEventImpl.setEventId(nextFollowUpEvent.getEventId());
		nextFollowUpEventImpl.setEventDate(nextFollowUpEvent.getEventDate());
		nextFollowUpEventImpl.setStatus(nextFollowUpEvent.getStatus());
		nextFollowUpEventImpl.setTitle(nextFollowUpEvent.getTitle());
		nextFollowUpEventImpl.setDescription(nextFollowUpEvent.getDescription());
		nextFollowUpEventImpl.setCreateDate(nextFollowUpEvent.getCreateDate());
		nextFollowUpEventImpl.setOwnerId(nextFollowUpEvent.getOwnerId());
		nextFollowUpEventImpl.setContractId(nextFollowUpEvent.getContractId());
		nextFollowUpEventImpl.setReportId(nextFollowUpEvent.getReportId());

		return nextFollowUpEventImpl;
	}

	/**
	 * Returns the next follow up event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the next follow up event
	 * @return the next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = fetchByPrimaryKey(primaryKey);

		if (nextFollowUpEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNextFollowUpEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nextFollowUpEvent;
	}

	/**
	 * Returns the next follow up event with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchNextFollowUpEventException} if it could not be found.
	 *
	 * @param eventId the primary key of the next follow up event
	 * @return the next follow up event
	 * @throws com.leancrm.portlet.library.NoSuchNextFollowUpEventException if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent findByPrimaryKey(long eventId)
		throws NoSuchNextFollowUpEventException, SystemException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the next follow up event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the next follow up event
	 * @return the next follow up event, or <code>null</code> if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NextFollowUpEvent nextFollowUpEvent = (NextFollowUpEvent)EntityCacheUtil.getResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
				NextFollowUpEventImpl.class, primaryKey);

		if (nextFollowUpEvent == _nullNextFollowUpEvent) {
			return null;
		}

		if (nextFollowUpEvent == null) {
			Session session = null;

			try {
				session = openSession();

				nextFollowUpEvent = (NextFollowUpEvent)session.get(NextFollowUpEventImpl.class,
						primaryKey);

				if (nextFollowUpEvent != null) {
					cacheResult(nextFollowUpEvent);
				}
				else {
					EntityCacheUtil.putResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
						NextFollowUpEventImpl.class, primaryKey,
						_nullNextFollowUpEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NextFollowUpEventModelImpl.ENTITY_CACHE_ENABLED,
					NextFollowUpEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nextFollowUpEvent;
	}

	/**
	 * Returns the next follow up event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the next follow up event
	 * @return the next follow up event, or <code>null</code> if a next follow up event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NextFollowUpEvent fetchByPrimaryKey(long eventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the next follow up events.
	 *
	 * @return the next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the next follow up events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @return the range of next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the next follow up events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.NextFollowUpEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of next follow up events
	 * @param end the upper bound of the range of next follow up events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of next follow up events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NextFollowUpEvent> findAll(int start, int end,
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

		List<NextFollowUpEvent> list = (List<NextFollowUpEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NEXTFOLLOWUPEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEXTFOLLOWUPEVENT;

				if (pagination) {
					sql = sql.concat(NextFollowUpEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NextFollowUpEvent>(list);
				}
				else {
					list = (List<NextFollowUpEvent>)QueryUtil.list(q,
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
	 * Removes all the next follow up events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NextFollowUpEvent nextFollowUpEvent : findAll()) {
			remove(nextFollowUpEvent);
		}
	}

	/**
	 * Returns the number of next follow up events.
	 *
	 * @return the number of next follow up events
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

				Query q = session.createQuery(_SQL_COUNT_NEXTFOLLOWUPEVENT);

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
	 * Initializes the next follow up event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.NextFollowUpEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NextFollowUpEvent>> listenersList = new ArrayList<ModelListener<NextFollowUpEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NextFollowUpEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NextFollowUpEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NEXTFOLLOWUPEVENT = "SELECT nextFollowUpEvent FROM NextFollowUpEvent nextFollowUpEvent";
	private static final String _SQL_SELECT_NEXTFOLLOWUPEVENT_WHERE = "SELECT nextFollowUpEvent FROM NextFollowUpEvent nextFollowUpEvent WHERE ";
	private static final String _SQL_COUNT_NEXTFOLLOWUPEVENT = "SELECT COUNT(nextFollowUpEvent) FROM NextFollowUpEvent nextFollowUpEvent";
	private static final String _SQL_COUNT_NEXTFOLLOWUPEVENT_WHERE = "SELECT COUNT(nextFollowUpEvent) FROM NextFollowUpEvent nextFollowUpEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nextFollowUpEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NextFollowUpEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NextFollowUpEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NextFollowUpEventPersistenceImpl.class);
	private static NextFollowUpEvent _nullNextFollowUpEvent = new NextFollowUpEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NextFollowUpEvent> toCacheModel() {
				return _nullNextFollowUpEventCacheModel;
			}
		};

	private static CacheModel<NextFollowUpEvent> _nullNextFollowUpEventCacheModel =
		new CacheModel<NextFollowUpEvent>() {
			@Override
			public NextFollowUpEvent toEntityModel() {
				return _nullNextFollowUpEvent;
			}
		};
}