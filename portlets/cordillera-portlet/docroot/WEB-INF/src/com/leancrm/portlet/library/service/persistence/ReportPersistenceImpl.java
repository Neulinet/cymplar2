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

import com.leancrm.portlet.library.NoSuchReportException;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.impl.ReportImpl;
import com.leancrm.portlet.library.model.impl.ReportModelImpl;

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
 * The persistence implementation for the report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportPersistence
 * @see ReportUtil
 * @generated
 */
public class ReportPersistenceImpl extends BasePersistenceImpl<Report>
	implements ReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReportUtil} to access the report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			ReportModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the reports where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reports where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @return the range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reports where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByUser(long userId, int start, int end,
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

		List<Report> list = (List<Report>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Report report : list) {
				if ((userId != report.getUserId())) {
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

			query.append(_SQL_SELECT_REPORT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Report>(list);
				}
				else {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByUser_First(userId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the first report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Report> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByUser_Last(userId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the last report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Report> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reports before and after the current report in the ordered set where userId = &#63;.
	 *
	 * @param reportId the primary key of the current report
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report[] findByUser_PrevAndNext(long reportId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			Report[] array = new ReportImpl[3];

			array[0] = getByUser_PrevAndNext(session, report, userId,
					orderByComparator, true);

			array[1] = report;

			array[2] = getByUser_PrevAndNext(session, report, userId,
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

	protected Report getByUser_PrevAndNext(Session session, Report report,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORT_WHERE);

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
			query.append(ReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(report);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Report> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reports where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Report report : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(report);
		}
	}

	/**
	 * Returns the number of reports where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching reports
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

			query.append(_SQL_COUNT_REPORT_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "report.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTORGANIZATION =
		new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactOrganization",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTORGANIZATION =
		new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactOrganization",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ReportModelImpl.ENTERPRISEID_COLUMN_BITMASK |
			ReportModelImpl.CONTACTID_COLUMN_BITMASK |
			ReportModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTORGANIZATION = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactOrganization",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @return the matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContactOrganization(long enterpriseId,
		long contactId, long organizationId) throws SystemException {
		return findByContactOrganization(enterpriseId, contactId,
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @return the range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContactOrganization(long enterpriseId,
		long contactId, long organizationId, int start, int end)
		throws SystemException {
		return findByContactOrganization(enterpriseId, contactId,
			organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContactOrganization(long enterpriseId,
		long contactId, long organizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTORGANIZATION;
			finderArgs = new Object[] { enterpriseId, contactId, organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTORGANIZATION;
			finderArgs = new Object[] {
					enterpriseId, contactId, organizationId,
					
					start, end, orderByComparator
				};
		}

		List<Report> list = (List<Report>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Report report : list) {
				if ((enterpriseId != report.getEnterpriseId()) ||
						(contactId != report.getContactId()) ||
						(organizationId != report.getOrganizationId())) {
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

			query.append(_SQL_SELECT_REPORT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ENTERPRISEID_2);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enterpriseId);

				qPos.add(contactId);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Report>(list);
				}
				else {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByContactOrganization_First(long enterpriseId,
		long contactId, long organizationId, OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByContactOrganization_First(enterpriseId,
				contactId, organizationId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enterpriseId=");
		msg.append(enterpriseId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the first report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByContactOrganization_First(long enterpriseId,
		long contactId, long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Report> list = findByContactOrganization(enterpriseId, contactId,
				organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByContactOrganization_Last(long enterpriseId,
		long contactId, long organizationId, OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByContactOrganization_Last(enterpriseId,
				contactId, organizationId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enterpriseId=");
		msg.append(enterpriseId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the last report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByContactOrganization_Last(long enterpriseId,
		long contactId, long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactOrganization(enterpriseId, contactId,
				organizationId);

		if (count == 0) {
			return null;
		}

		List<Report> list = findByContactOrganization(enterpriseId, contactId,
				organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reports before and after the current report in the ordered set where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param reportId the primary key of the current report
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report[] findByContactOrganization_PrevAndNext(long reportId,
		long enterpriseId, long contactId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			Report[] array = new ReportImpl[3];

			array[0] = getByContactOrganization_PrevAndNext(session, report,
					enterpriseId, contactId, organizationId, orderByComparator,
					true);

			array[1] = report;

			array[2] = getByContactOrganization_PrevAndNext(session, report,
					enterpriseId, contactId, organizationId, orderByComparator,
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

	protected Report getByContactOrganization_PrevAndNext(Session session,
		Report report, long enterpriseId, long contactId, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORT_WHERE);

		query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ENTERPRISEID_2);

		query.append(_FINDER_COLUMN_CONTACTORGANIZATION_CONTACTID_2);

		query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ORGANIZATIONID_2);

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
			query.append(ReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(enterpriseId);

		qPos.add(contactId);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(report);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Report> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactOrganization(long enterpriseId, long contactId,
		long organizationId) throws SystemException {
		for (Report report : findByContactOrganization(enterpriseId, contactId,
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(report);
		}
	}

	/**
	 * Returns the number of reports where enterpriseId = &#63; and contactId = &#63; and organizationId = &#63;.
	 *
	 * @param enterpriseId the enterprise ID
	 * @param contactId the contact ID
	 * @param organizationId the organization ID
	 * @return the number of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactOrganization(long enterpriseId, long contactId,
		long organizationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTORGANIZATION;

		Object[] finderArgs = new Object[] {
				enterpriseId, contactId, organizationId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_REPORT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ENTERPRISEID_2);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enterpriseId);

				qPos.add(contactId);

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

	private static final String _FINDER_COLUMN_CONTACTORGANIZATION_ENTERPRISEID_2 =
		"report.enterpriseId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTORGANIZATION_CONTACTID_2 = "report.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTORGANIZATION_ORGANIZATIONID_2 =
		"report.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTRACT = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContract",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT =
		new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, ReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContract",
			new String[] { Long.class.getName() },
			ReportModelImpl.CONTRACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTRACT = new FinderPath(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContract",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the reports where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContract(long contractId)
		throws SystemException {
		return findByContract(contractId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the reports where contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @return the range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContract(long contractId, int start, int end)
		throws SystemException {
		return findByContract(contractId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reports where contractId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contractId the contract ID
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findByContract(long contractId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Report> list = (List<Report>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Report report : list) {
				if ((contractId != report.getContractId())) {
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

			query.append(_SQL_SELECT_REPORT_WHERE);

			query.append(_FINDER_COLUMN_CONTRACT_CONTRACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contractId);

				if (!pagination) {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Report>(list);
				}
				else {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first report in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByContract_First(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByContract_First(contractId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the first report in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByContract_First(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Report> list = findByContract(contractId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByContract_Last(long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = fetchByContract_Last(contractId, orderByComparator);

		if (report != null) {
			return report;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contractId=");
		msg.append(contractId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportException(msg.toString());
	}

	/**
	 * Returns the last report in the ordered set where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report, or <code>null</code> if a matching report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByContract_Last(long contractId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContract(contractId);

		if (count == 0) {
			return null;
		}

		List<Report> list = findByContract(contractId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reports before and after the current report in the ordered set where contractId = &#63;.
	 *
	 * @param reportId the primary key of the current report
	 * @param contractId the contract ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report[] findByContract_PrevAndNext(long reportId, long contractId,
		OrderByComparator orderByComparator)
		throws NoSuchReportException, SystemException {
		Report report = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			Report[] array = new ReportImpl[3];

			array[0] = getByContract_PrevAndNext(session, report, contractId,
					orderByComparator, true);

			array[1] = report;

			array[2] = getByContract_PrevAndNext(session, report, contractId,
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

	protected Report getByContract_PrevAndNext(Session session, Report report,
		long contractId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORT_WHERE);

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
			query.append(ReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contractId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(report);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Report> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reports where contractId = &#63; from the database.
	 *
	 * @param contractId the contract ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContract(long contractId) throws SystemException {
		for (Report report : findByContract(contractId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(report);
		}
	}

	/**
	 * Returns the number of reports where contractId = &#63;.
	 *
	 * @param contractId the contract ID
	 * @return the number of matching reports
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

			query.append(_SQL_COUNT_REPORT_WHERE);

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

	private static final String _FINDER_COLUMN_CONTRACT_CONTRACTID_2 = "report.contractId = ?";

	public ReportPersistenceImpl() {
		setModelClass(Report.class);
	}

	/**
	 * Caches the report in the entity cache if it is enabled.
	 *
	 * @param report the report
	 */
	@Override
	public void cacheResult(Report report) {
		EntityCacheUtil.putResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportImpl.class, report.getPrimaryKey(), report);

		report.resetOriginalValues();
	}

	/**
	 * Caches the reports in the entity cache if it is enabled.
	 *
	 * @param reports the reports
	 */
	@Override
	public void cacheResult(List<Report> reports) {
		for (Report report : reports) {
			if (EntityCacheUtil.getResult(
						ReportModelImpl.ENTITY_CACHE_ENABLED, ReportImpl.class,
						report.getPrimaryKey()) == null) {
				cacheResult(report);
			}
			else {
				report.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Report report) {
		EntityCacheUtil.removeResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportImpl.class, report.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Report> reports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Report report : reports) {
			EntityCacheUtil.removeResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
				ReportImpl.class, report.getPrimaryKey());
		}
	}

	/**
	 * Creates a new report with the primary key. Does not add the report to the database.
	 *
	 * @param reportId the primary key for the new report
	 * @return the new report
	 */
	@Override
	public Report create(long reportId) {
		Report report = new ReportImpl();

		report.setNew(true);
		report.setPrimaryKey(reportId);

		return report;
	}

	/**
	 * Removes the report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the report
	 * @return the report that was removed
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report remove(long reportId)
		throws NoSuchReportException, SystemException {
		return remove((Serializable)reportId);
	}

	/**
	 * Removes the report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the report
	 * @return the report that was removed
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report remove(Serializable primaryKey)
		throws NoSuchReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Report report = (Report)session.get(ReportImpl.class, primaryKey);

			if (report == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(report);
		}
		catch (NoSuchReportException nsee) {
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
	protected Report removeImpl(Report report) throws SystemException {
		report = toUnwrappedModel(report);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(report)) {
				report = (Report)session.get(ReportImpl.class,
						report.getPrimaryKeyObj());
			}

			if (report != null) {
				session.delete(report);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (report != null) {
			clearCache(report);
		}

		return report;
	}

	@Override
	public Report updateImpl(com.leancrm.portlet.library.model.Report report)
		throws SystemException {
		report = toUnwrappedModel(report);

		boolean isNew = report.isNew();

		ReportModelImpl reportModelImpl = (ReportModelImpl)report;

		Session session = null;

		try {
			session = openSession();

			if (report.isNew()) {
				session.save(report);

				report.setNew(false);
			}
			else {
				session.merge(report);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { reportModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { reportModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((reportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportModelImpl.getOriginalEnterpriseId(),
						reportModelImpl.getOriginalContactId(),
						reportModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTORGANIZATION,
					args);

				args = new Object[] {
						reportModelImpl.getEnterpriseId(),
						reportModelImpl.getContactId(),
						reportModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTORGANIZATION,
					args);
			}

			if ((reportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportModelImpl.getOriginalContractId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);

				args = new Object[] { reportModelImpl.getContractId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTRACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTRACT,
					args);
			}
		}

		EntityCacheUtil.putResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
			ReportImpl.class, report.getPrimaryKey(), report);

		return report;
	}

	protected Report toUnwrappedModel(Report report) {
		if (report instanceof ReportImpl) {
			return report;
		}

		ReportImpl reportImpl = new ReportImpl();

		reportImpl.setNew(report.isNew());
		reportImpl.setPrimaryKey(report.getPrimaryKey());

		reportImpl.setReportId(report.getReportId());
		reportImpl.setGroupId(report.getGroupId());
		reportImpl.setCompanyId(report.getCompanyId());
		reportImpl.setCreateDate(report.getCreateDate());
		reportImpl.setUserId(report.getUserId());
		reportImpl.setOrganizationId(report.getOrganizationId());
		reportImpl.setEnterpriseId(report.getEnterpriseId());
		reportImpl.setContactId(report.getContactId());
		reportImpl.setContactDataId(report.getContactDataId());
		reportImpl.setContactMethodId(report.getContactMethodId());
		reportImpl.setReportDate(report.getReportDate());
		reportImpl.setComments(report.getComments());
		reportImpl.setProgress(report.getProgress());
		reportImpl.setStatus(report.getStatus());
		reportImpl.setContractId(report.getContractId());
		reportImpl.setCdNameId(report.getCdNameId());

		return reportImpl;
	}

	/**
	 * Returns the report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the report
	 * @return the report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReportException, SystemException {
		Report report = fetchByPrimaryKey(primaryKey);

		if (report == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return report;
	}

	/**
	 * Returns the report with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchReportException} if it could not be found.
	 *
	 * @param reportId the primary key of the report
	 * @return the report
	 * @throws com.leancrm.portlet.library.NoSuchReportException if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report findByPrimaryKey(long reportId)
		throws NoSuchReportException, SystemException {
		return findByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns the report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the report
	 * @return the report, or <code>null</code> if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Report report = (Report)EntityCacheUtil.getResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
				ReportImpl.class, primaryKey);

		if (report == _nullReport) {
			return null;
		}

		if (report == null) {
			Session session = null;

			try {
				session = openSession();

				report = (Report)session.get(ReportImpl.class, primaryKey);

				if (report != null) {
					cacheResult(report);
				}
				else {
					EntityCacheUtil.putResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
						ReportImpl.class, primaryKey, _nullReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReportModelImpl.ENTITY_CACHE_ENABLED,
					ReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return report;
	}

	/**
	 * Returns the report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the report
	 * @return the report, or <code>null</code> if a report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Report fetchByPrimaryKey(long reportId) throws SystemException {
		return fetchByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns all the reports.
	 *
	 * @return the reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @return the range of reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reports
	 * @param end the upper bound of the range of reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Report> findAll(int start, int end,
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

		List<Report> list = (List<Report>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPORT;

				if (pagination) {
					sql = sql.concat(ReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Report>(list);
				}
				else {
					list = (List<Report>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Report report : findAll()) {
			remove(report);
		}
	}

	/**
	 * Returns the number of reports.
	 *
	 * @return the number of reports
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

				Query q = session.createQuery(_SQL_COUNT_REPORT);

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
	 * Initializes the report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.Report")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Report>> listenersList = new ArrayList<ModelListener<Report>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Report>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REPORT = "SELECT report FROM Report report";
	private static final String _SQL_SELECT_REPORT_WHERE = "SELECT report FROM Report report WHERE ";
	private static final String _SQL_COUNT_REPORT = "SELECT COUNT(report) FROM Report report";
	private static final String _SQL_COUNT_REPORT_WHERE = "SELECT COUNT(report) FROM Report report WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "report.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Report exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Report exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReportPersistenceImpl.class);
	private static Report _nullReport = new ReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Report> toCacheModel() {
				return _nullReportCacheModel;
			}
		};

	private static CacheModel<Report> _nullReportCacheModel = new CacheModel<Report>() {
			@Override
			public Report toEntityModel() {
				return _nullReport;
			}
		};
}