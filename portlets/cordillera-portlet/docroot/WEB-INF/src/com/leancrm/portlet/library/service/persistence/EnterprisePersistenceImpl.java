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

import com.leancrm.portlet.library.NoSuchEnterpriseException;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.impl.EnterpriseImpl;
import com.leancrm.portlet.library.model.impl.EnterpriseModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the enterprise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnterprisePersistence
 * @see EnterpriseUtil
 * @generated
 */
public class EnterprisePersistenceImpl extends BasePersistenceImpl<Enterprise>
	implements EnterprisePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnterpriseUtil} to access the enterprise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnterpriseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			EnterpriseModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enterprises where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enterprises where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @return the range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enterprises where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Enterprise> list = (List<Enterprise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Enterprise enterprise : list) {
				if (!Validator.equals(name, enterprise.getName())) {
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

			query.append(_SQL_SELECT_ENTERPRISE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Enterprise>(list);
				}
				else {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first enterprise in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByName_First(name, orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the first enterprise in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Enterprise> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enterprise in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByName_Last(name, orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the last enterprise in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Enterprise> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enterprises before and after the current enterprise in the ordered set where name = &#63;.
	 *
	 * @param enterpriseId the primary key of the current enterprise
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise[] findByName_PrevAndNext(long enterpriseId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = findByPrimaryKey(enterpriseId);

		Session session = null;

		try {
			session = openSession();

			Enterprise[] array = new EnterpriseImpl[3];

			array[0] = getByName_PrevAndNext(session, enterprise, name,
					orderByComparator, true);

			array[1] = enterprise;

			array[2] = getByName_PrevAndNext(session, enterprise, name,
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

	protected Enterprise getByName_PrevAndNext(Session session,
		Enterprise enterprise, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTERPRISE_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enterprise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Enterprise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enterprises where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Enterprise enterprise : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(enterprise);
		}
	}

	/**
	 * Returns the number of enterprises where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTERPRISE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "enterprise.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "enterprise.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(enterprise.name IS NULL OR enterprise.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXID = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaxid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaxid",
			new String[] { String.class.getName() },
			EnterpriseModelImpl.TAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXID = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaxid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enterprises where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @return the matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByTaxid(String taxid) throws SystemException {
		return findByTaxid(taxid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enterprises where taxid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxid the taxid
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @return the range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByTaxid(String taxid, int start, int end)
		throws SystemException {
		return findByTaxid(taxid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enterprises where taxid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxid the taxid
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByTaxid(String taxid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID;
			finderArgs = new Object[] { taxid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXID;
			finderArgs = new Object[] { taxid, start, end, orderByComparator };
		}

		List<Enterprise> list = (List<Enterprise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Enterprise enterprise : list) {
				if (!Validator.equals(taxid, enterprise.getTaxid())) {
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

			query.append(_SQL_SELECT_ENTERPRISE_WHERE);

			boolean bindTaxid = false;

			if (taxid == null) {
				query.append(_FINDER_COLUMN_TAXID_TAXID_1);
			}
			else if (taxid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAXID_TAXID_3);
			}
			else {
				bindTaxid = true;

				query.append(_FINDER_COLUMN_TAXID_TAXID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaxid) {
					qPos.add(taxid);
				}

				if (!pagination) {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Enterprise>(list);
				}
				else {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first enterprise in the ordered set where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByTaxid_First(String taxid,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByTaxid_First(taxid, orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxid=");
		msg.append(taxid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the first enterprise in the ordered set where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByTaxid_First(String taxid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Enterprise> list = findByTaxid(taxid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enterprise in the ordered set where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByTaxid_Last(String taxid,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByTaxid_Last(taxid, orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxid=");
		msg.append(taxid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the last enterprise in the ordered set where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByTaxid_Last(String taxid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTaxid(taxid);

		if (count == 0) {
			return null;
		}

		List<Enterprise> list = findByTaxid(taxid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enterprises before and after the current enterprise in the ordered set where taxid = &#63;.
	 *
	 * @param enterpriseId the primary key of the current enterprise
	 * @param taxid the taxid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise[] findByTaxid_PrevAndNext(long enterpriseId,
		String taxid, OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = findByPrimaryKey(enterpriseId);

		Session session = null;

		try {
			session = openSession();

			Enterprise[] array = new EnterpriseImpl[3];

			array[0] = getByTaxid_PrevAndNext(session, enterprise, taxid,
					orderByComparator, true);

			array[1] = enterprise;

			array[2] = getByTaxid_PrevAndNext(session, enterprise, taxid,
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

	protected Enterprise getByTaxid_PrevAndNext(Session session,
		Enterprise enterprise, String taxid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTERPRISE_WHERE);

		boolean bindTaxid = false;

		if (taxid == null) {
			query.append(_FINDER_COLUMN_TAXID_TAXID_1);
		}
		else if (taxid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TAXID_TAXID_3);
		}
		else {
			bindTaxid = true;

			query.append(_FINDER_COLUMN_TAXID_TAXID_2);
		}

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
			query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTaxid) {
			qPos.add(taxid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enterprise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Enterprise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enterprises where taxid = &#63; from the database.
	 *
	 * @param taxid the taxid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTaxid(String taxid) throws SystemException {
		for (Enterprise enterprise : findByTaxid(taxid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(enterprise);
		}
	}

	/**
	 * Returns the number of enterprises where taxid = &#63;.
	 *
	 * @param taxid the taxid
	 * @return the number of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTaxid(String taxid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAXID;

		Object[] finderArgs = new Object[] { taxid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTERPRISE_WHERE);

			boolean bindTaxid = false;

			if (taxid == null) {
				query.append(_FINDER_COLUMN_TAXID_TAXID_1);
			}
			else if (taxid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAXID_TAXID_3);
			}
			else {
				bindTaxid = true;

				query.append(_FINDER_COLUMN_TAXID_TAXID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaxid) {
					qPos.add(taxid);
				}

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

	private static final String _FINDER_COLUMN_TAXID_TAXID_1 = "enterprise.taxid IS NULL";
	private static final String _FINDER_COLUMN_TAXID_TAXID_2 = "enterprise.taxid = ?";
	private static final String _FINDER_COLUMN_TAXID_TAXID_3 = "(enterprise.taxid IS NULL OR enterprise.taxid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INDUSTRY = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIndustry",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INDUSTRY =
		new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, EnterpriseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIndustry",
			new String[] { Long.class.getName() },
			EnterpriseModelImpl.INDUSTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INDUSTRY = new FinderPath(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIndustry",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the enterprises where industry = &#63;.
	 *
	 * @param industry the industry
	 * @return the matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByIndustry(long industry)
		throws SystemException {
		return findByIndustry(industry, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the enterprises where industry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param industry the industry
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @return the range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByIndustry(long industry, int start, int end)
		throws SystemException {
		return findByIndustry(industry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enterprises where industry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param industry the industry
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findByIndustry(long industry, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INDUSTRY;
			finderArgs = new Object[] { industry };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INDUSTRY;
			finderArgs = new Object[] { industry, start, end, orderByComparator };
		}

		List<Enterprise> list = (List<Enterprise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Enterprise enterprise : list) {
				if ((industry != enterprise.getIndustry())) {
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

			query.append(_SQL_SELECT_ENTERPRISE_WHERE);

			query.append(_FINDER_COLUMN_INDUSTRY_INDUSTRY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(industry);

				if (!pagination) {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Enterprise>(list);
				}
				else {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first enterprise in the ordered set where industry = &#63;.
	 *
	 * @param industry the industry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByIndustry_First(long industry,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByIndustry_First(industry,
				orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("industry=");
		msg.append(industry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the first enterprise in the ordered set where industry = &#63;.
	 *
	 * @param industry the industry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByIndustry_First(long industry,
		OrderByComparator orderByComparator) throws SystemException {
		List<Enterprise> list = findByIndustry(industry, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enterprise in the ordered set where industry = &#63;.
	 *
	 * @param industry the industry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByIndustry_Last(long industry,
		OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByIndustry_Last(industry, orderByComparator);

		if (enterprise != null) {
			return enterprise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("industry=");
		msg.append(industry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnterpriseException(msg.toString());
	}

	/**
	 * Returns the last enterprise in the ordered set where industry = &#63;.
	 *
	 * @param industry the industry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enterprise, or <code>null</code> if a matching enterprise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByIndustry_Last(long industry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIndustry(industry);

		if (count == 0) {
			return null;
		}

		List<Enterprise> list = findByIndustry(industry, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enterprises before and after the current enterprise in the ordered set where industry = &#63;.
	 *
	 * @param enterpriseId the primary key of the current enterprise
	 * @param industry the industry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise[] findByIndustry_PrevAndNext(long enterpriseId,
		long industry, OrderByComparator orderByComparator)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = findByPrimaryKey(enterpriseId);

		Session session = null;

		try {
			session = openSession();

			Enterprise[] array = new EnterpriseImpl[3];

			array[0] = getByIndustry_PrevAndNext(session, enterprise, industry,
					orderByComparator, true);

			array[1] = enterprise;

			array[2] = getByIndustry_PrevAndNext(session, enterprise, industry,
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

	protected Enterprise getByIndustry_PrevAndNext(Session session,
		Enterprise enterprise, long industry,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTERPRISE_WHERE);

		query.append(_FINDER_COLUMN_INDUSTRY_INDUSTRY_2);

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
			query.append(EnterpriseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(industry);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enterprise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Enterprise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enterprises where industry = &#63; from the database.
	 *
	 * @param industry the industry
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIndustry(long industry) throws SystemException {
		for (Enterprise enterprise : findByIndustry(industry,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enterprise);
		}
	}

	/**
	 * Returns the number of enterprises where industry = &#63;.
	 *
	 * @param industry the industry
	 * @return the number of matching enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIndustry(long industry) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INDUSTRY;

		Object[] finderArgs = new Object[] { industry };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTERPRISE_WHERE);

			query.append(_FINDER_COLUMN_INDUSTRY_INDUSTRY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(industry);

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

	private static final String _FINDER_COLUMN_INDUSTRY_INDUSTRY_2 = "enterprise.industry = ?";

	public EnterprisePersistenceImpl() {
		setModelClass(Enterprise.class);
	}

	/**
	 * Caches the enterprise in the entity cache if it is enabled.
	 *
	 * @param enterprise the enterprise
	 */
	@Override
	public void cacheResult(Enterprise enterprise) {
		EntityCacheUtil.putResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseImpl.class, enterprise.getPrimaryKey(), enterprise);

		enterprise.resetOriginalValues();
	}

	/**
	 * Caches the enterprises in the entity cache if it is enabled.
	 *
	 * @param enterprises the enterprises
	 */
	@Override
	public void cacheResult(List<Enterprise> enterprises) {
		for (Enterprise enterprise : enterprises) {
			if (EntityCacheUtil.getResult(
						EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
						EnterpriseImpl.class, enterprise.getPrimaryKey()) == null) {
				cacheResult(enterprise);
			}
			else {
				enterprise.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enterprises.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnterpriseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnterpriseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enterprise.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Enterprise enterprise) {
		EntityCacheUtil.removeResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseImpl.class, enterprise.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Enterprise> enterprises) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Enterprise enterprise : enterprises) {
			EntityCacheUtil.removeResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
				EnterpriseImpl.class, enterprise.getPrimaryKey());
		}
	}

	/**
	 * Creates a new enterprise with the primary key. Does not add the enterprise to the database.
	 *
	 * @param enterpriseId the primary key for the new enterprise
	 * @return the new enterprise
	 */
	@Override
	public Enterprise create(long enterpriseId) {
		Enterprise enterprise = new EnterpriseImpl();

		enterprise.setNew(true);
		enterprise.setPrimaryKey(enterpriseId);

		return enterprise;
	}

	/**
	 * Removes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enterpriseId the primary key of the enterprise
	 * @return the enterprise that was removed
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise remove(long enterpriseId)
		throws NoSuchEnterpriseException, SystemException {
		return remove((Serializable)enterpriseId);
	}

	/**
	 * Removes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enterprise
	 * @return the enterprise that was removed
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise remove(Serializable primaryKey)
		throws NoSuchEnterpriseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Enterprise enterprise = (Enterprise)session.get(EnterpriseImpl.class,
					primaryKey);

			if (enterprise == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnterpriseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enterprise);
		}
		catch (NoSuchEnterpriseException nsee) {
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
	protected Enterprise removeImpl(Enterprise enterprise)
		throws SystemException {
		enterprise = toUnwrappedModel(enterprise);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enterprise)) {
				enterprise = (Enterprise)session.get(EnterpriseImpl.class,
						enterprise.getPrimaryKeyObj());
			}

			if (enterprise != null) {
				session.delete(enterprise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enterprise != null) {
			clearCache(enterprise);
		}

		return enterprise;
	}

	@Override
	public Enterprise updateImpl(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws SystemException {
		enterprise = toUnwrappedModel(enterprise);

		boolean isNew = enterprise.isNew();

		EnterpriseModelImpl enterpriseModelImpl = (EnterpriseModelImpl)enterprise;

		Session session = null;

		try {
			session = openSession();

			if (enterprise.isNew()) {
				session.save(enterprise);

				enterprise.setNew(false);
			}
			else {
				session.merge(enterprise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EnterpriseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((enterpriseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enterpriseModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { enterpriseModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((enterpriseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enterpriseModelImpl.getOriginalTaxid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID,
					args);

				args = new Object[] { enterpriseModelImpl.getTaxid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID,
					args);
			}

			if ((enterpriseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INDUSTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enterpriseModelImpl.getOriginalIndustry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INDUSTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INDUSTRY,
					args);

				args = new Object[] { enterpriseModelImpl.getIndustry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INDUSTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INDUSTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
			EnterpriseImpl.class, enterprise.getPrimaryKey(), enterprise);

		return enterprise;
	}

	protected Enterprise toUnwrappedModel(Enterprise enterprise) {
		if (enterprise instanceof EnterpriseImpl) {
			return enterprise;
		}

		EnterpriseImpl enterpriseImpl = new EnterpriseImpl();

		enterpriseImpl.setNew(enterprise.isNew());
		enterpriseImpl.setPrimaryKey(enterprise.getPrimaryKey());

		enterpriseImpl.setEnterpriseId(enterprise.getEnterpriseId());
		enterpriseImpl.setGroupId(enterprise.getGroupId());
		enterpriseImpl.setIsPrivate(enterprise.getIsPrivate());
		enterpriseImpl.setCompanyId(enterprise.getCompanyId());
		enterpriseImpl.setCreateDate(enterprise.getCreateDate());
		enterpriseImpl.setModifiedDate(enterprise.getModifiedDate());
		enterpriseImpl.setName(enterprise.getName());
		enterpriseImpl.setTaxid(enterprise.getTaxid());
		enterpriseImpl.setDescription(enterprise.getDescription());
		enterpriseImpl.setIndustry(enterprise.getIndustry());
		enterpriseImpl.setEmail(enterprise.getEmail());

		return enterpriseImpl;
	}

	/**
	 * Returns the enterprise with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enterprise
	 * @return the enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnterpriseException, SystemException {
		Enterprise enterprise = fetchByPrimaryKey(primaryKey);

		if (enterprise == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnterpriseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enterprise;
	}

	/**
	 * Returns the enterprise with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchEnterpriseException} if it could not be found.
	 *
	 * @param enterpriseId the primary key of the enterprise
	 * @return the enterprise
	 * @throws com.leancrm.portlet.library.NoSuchEnterpriseException if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise findByPrimaryKey(long enterpriseId)
		throws NoSuchEnterpriseException, SystemException {
		return findByPrimaryKey((Serializable)enterpriseId);
	}

	/**
	 * Returns the enterprise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enterprise
	 * @return the enterprise, or <code>null</code> if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Enterprise enterprise = (Enterprise)EntityCacheUtil.getResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
				EnterpriseImpl.class, primaryKey);

		if (enterprise == _nullEnterprise) {
			return null;
		}

		if (enterprise == null) {
			Session session = null;

			try {
				session = openSession();

				enterprise = (Enterprise)session.get(EnterpriseImpl.class,
						primaryKey);

				if (enterprise != null) {
					cacheResult(enterprise);
				}
				else {
					EntityCacheUtil.putResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
						EnterpriseImpl.class, primaryKey, _nullEnterprise);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnterpriseModelImpl.ENTITY_CACHE_ENABLED,
					EnterpriseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enterprise;
	}

	/**
	 * Returns the enterprise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enterpriseId the primary key of the enterprise
	 * @return the enterprise, or <code>null</code> if a enterprise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enterprise fetchByPrimaryKey(long enterpriseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)enterpriseId);
	}

	/**
	 * Returns all the enterprises.
	 *
	 * @return the enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enterprises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @return the range of enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enterprises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enterprises
	 * @param end the upper bound of the range of enterprises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enterprises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Enterprise> findAll(int start, int end,
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

		List<Enterprise> list = (List<Enterprise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENTERPRISE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTERPRISE;

				if (pagination) {
					sql = sql.concat(EnterpriseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Enterprise>(list);
				}
				else {
					list = (List<Enterprise>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the enterprises from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Enterprise enterprise : findAll()) {
			remove(enterprise);
		}
	}

	/**
	 * Returns the number of enterprises.
	 *
	 * @return the number of enterprises
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

				Query q = session.createQuery(_SQL_COUNT_ENTERPRISE);

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
	 * Initializes the enterprise persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.Enterprise")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Enterprise>> listenersList = new ArrayList<ModelListener<Enterprise>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Enterprise>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnterpriseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENTERPRISE = "SELECT enterprise FROM Enterprise enterprise";
	private static final String _SQL_SELECT_ENTERPRISE_WHERE = "SELECT enterprise FROM Enterprise enterprise WHERE ";
	private static final String _SQL_COUNT_ENTERPRISE = "SELECT COUNT(enterprise) FROM Enterprise enterprise";
	private static final String _SQL_COUNT_ENTERPRISE_WHERE = "SELECT COUNT(enterprise) FROM Enterprise enterprise WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enterprise.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Enterprise exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Enterprise exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnterprisePersistenceImpl.class);
	private static Enterprise _nullEnterprise = new EnterpriseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Enterprise> toCacheModel() {
				return _nullEnterpriseCacheModel;
			}
		};

	private static CacheModel<Enterprise> _nullEnterpriseCacheModel = new CacheModel<Enterprise>() {
			@Override
			public Enterprise toEntityModel() {
				return _nullEnterprise;
			}
		};
}