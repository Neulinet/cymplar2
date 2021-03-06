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

import com.leancrm.portlet.library.NoSuchIndustryException;
import com.leancrm.portlet.library.model.Industry;
import com.leancrm.portlet.library.model.impl.IndustryImpl;
import com.leancrm.portlet.library.model.impl.IndustryModelImpl;

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
 * The persistence implementation for the industry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndustryPersistence
 * @see IndustryUtil
 * @generated
 */
public class IndustryPersistenceImpl extends BasePersistenceImpl<Industry>
	implements IndustryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IndustryUtil} to access the industry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IndustryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, IndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, IndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, IndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, IndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			IndustryModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the industries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the industries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of matching industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the industries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findByName(String name, int start, int end,
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

		List<Industry> list = (List<Industry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Industry industry : list) {
				if (!Validator.equals(name, industry.getName())) {
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

			query.append(_SQL_SELECT_INDUSTRY_WHERE);

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
				query.append(IndustryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Industry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Industry>(list);
				}
				else {
					list = (List<Industry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first industry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a matching industry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchIndustryException, SystemException {
		Industry industry = fetchByName_First(name, orderByComparator);

		if (industry != null) {
			return industry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIndustryException(msg.toString());
	}

	/**
	 * Returns the first industry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry, or <code>null</code> if a matching industry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Industry> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last industry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a matching industry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchIndustryException, SystemException {
		Industry industry = fetchByName_Last(name, orderByComparator);

		if (industry != null) {
			return industry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIndustryException(msg.toString());
	}

	/**
	 * Returns the last industry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry, or <code>null</code> if a matching industry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Industry> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the industries before and after the current industry in the ordered set where name = &#63;.
	 *
	 * @param industryId the primary key of the current industry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next industry
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry[] findByName_PrevAndNext(long industryId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchIndustryException, SystemException {
		Industry industry = findByPrimaryKey(industryId);

		Session session = null;

		try {
			session = openSession();

			Industry[] array = new IndustryImpl[3];

			array[0] = getByName_PrevAndNext(session, industry, name,
					orderByComparator, true);

			array[1] = industry;

			array[2] = getByName_PrevAndNext(session, industry, name,
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

	protected Industry getByName_PrevAndNext(Session session,
		Industry industry, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INDUSTRY_WHERE);

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
			query.append(IndustryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(industry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Industry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the industries where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Industry industry : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(industry);
		}
	}

	/**
	 * Returns the number of industries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching industries
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

			query.append(_SQL_COUNT_INDUSTRY_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "industry.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "industry.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(industry.name IS NULL OR industry.name = '')";

	public IndustryPersistenceImpl() {
		setModelClass(Industry.class);
	}

	/**
	 * Caches the industry in the entity cache if it is enabled.
	 *
	 * @param industry the industry
	 */
	@Override
	public void cacheResult(Industry industry) {
		EntityCacheUtil.putResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryImpl.class, industry.getPrimaryKey(), industry);

		industry.resetOriginalValues();
	}

	/**
	 * Caches the industries in the entity cache if it is enabled.
	 *
	 * @param industries the industries
	 */
	@Override
	public void cacheResult(List<Industry> industries) {
		for (Industry industry : industries) {
			if (EntityCacheUtil.getResult(
						IndustryModelImpl.ENTITY_CACHE_ENABLED,
						IndustryImpl.class, industry.getPrimaryKey()) == null) {
				cacheResult(industry);
			}
			else {
				industry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all industries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IndustryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IndustryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the industry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Industry industry) {
		EntityCacheUtil.removeResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryImpl.class, industry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Industry> industries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Industry industry : industries) {
			EntityCacheUtil.removeResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
				IndustryImpl.class, industry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new industry with the primary key. Does not add the industry to the database.
	 *
	 * @param industryId the primary key for the new industry
	 * @return the new industry
	 */
	@Override
	public Industry create(long industryId) {
		Industry industry = new IndustryImpl();

		industry.setNew(true);
		industry.setPrimaryKey(industryId);

		return industry;
	}

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry that was removed
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry remove(long industryId)
		throws NoSuchIndustryException, SystemException {
		return remove((Serializable)industryId);
	}

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the industry
	 * @return the industry that was removed
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry remove(Serializable primaryKey)
		throws NoSuchIndustryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Industry industry = (Industry)session.get(IndustryImpl.class,
					primaryKey);

			if (industry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIndustryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(industry);
		}
		catch (NoSuchIndustryException nsee) {
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
	protected Industry removeImpl(Industry industry) throws SystemException {
		industry = toUnwrappedModel(industry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(industry)) {
				industry = (Industry)session.get(IndustryImpl.class,
						industry.getPrimaryKeyObj());
			}

			if (industry != null) {
				session.delete(industry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (industry != null) {
			clearCache(industry);
		}

		return industry;
	}

	@Override
	public Industry updateImpl(
		com.leancrm.portlet.library.model.Industry industry)
		throws SystemException {
		industry = toUnwrappedModel(industry);

		boolean isNew = industry.isNew();

		IndustryModelImpl industryModelImpl = (IndustryModelImpl)industry;

		Session session = null;

		try {
			session = openSession();

			if (industry.isNew()) {
				session.save(industry);

				industry.setNew(false);
			}
			else {
				session.merge(industry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IndustryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((industryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { industryModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { industryModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
			IndustryImpl.class, industry.getPrimaryKey(), industry);

		return industry;
	}

	protected Industry toUnwrappedModel(Industry industry) {
		if (industry instanceof IndustryImpl) {
			return industry;
		}

		IndustryImpl industryImpl = new IndustryImpl();

		industryImpl.setNew(industry.isNew());
		industryImpl.setPrimaryKey(industry.getPrimaryKey());

		industryImpl.setIndustryId(industry.getIndustryId());
		industryImpl.setGroupId(industry.getGroupId());
		industryImpl.setName(industry.getName());

		return industryImpl;
	}

	/**
	 * Returns the industry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the industry
	 * @return the industry
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIndustryException, SystemException {
		Industry industry = fetchByPrimaryKey(primaryKey);

		if (industry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIndustryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return industry;
	}

	/**
	 * Returns the industry with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchIndustryException} if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry
	 * @throws com.leancrm.portlet.library.NoSuchIndustryException if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry findByPrimaryKey(long industryId)
		throws NoSuchIndustryException, SystemException {
		return findByPrimaryKey((Serializable)industryId);
	}

	/**
	 * Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the industry
	 * @return the industry, or <code>null</code> if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Industry industry = (Industry)EntityCacheUtil.getResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
				IndustryImpl.class, primaryKey);

		if (industry == _nullIndustry) {
			return null;
		}

		if (industry == null) {
			Session session = null;

			try {
				session = openSession();

				industry = (Industry)session.get(IndustryImpl.class, primaryKey);

				if (industry != null) {
					cacheResult(industry);
				}
				else {
					EntityCacheUtil.putResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
						IndustryImpl.class, primaryKey, _nullIndustry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IndustryModelImpl.ENTITY_CACHE_ENABLED,
					IndustryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return industry;
	}

	/**
	 * Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry, or <code>null</code> if a industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Industry fetchByPrimaryKey(long industryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)industryId);
	}

	/**
	 * Returns all the industries.
	 *
	 * @return the industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.IndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Industry> findAll(int start, int end,
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

		List<Industry> list = (List<Industry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INDUSTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INDUSTRY;

				if (pagination) {
					sql = sql.concat(IndustryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Industry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Industry>(list);
				}
				else {
					list = (List<Industry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the industries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Industry industry : findAll()) {
			remove(industry);
		}
	}

	/**
	 * Returns the number of industries.
	 *
	 * @return the number of industries
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

				Query q = session.createQuery(_SQL_COUNT_INDUSTRY);

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
	 * Initializes the industry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.Industry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Industry>> listenersList = new ArrayList<ModelListener<Industry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Industry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IndustryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INDUSTRY = "SELECT industry FROM Industry industry";
	private static final String _SQL_SELECT_INDUSTRY_WHERE = "SELECT industry FROM Industry industry WHERE ";
	private static final String _SQL_COUNT_INDUSTRY = "SELECT COUNT(industry) FROM Industry industry";
	private static final String _SQL_COUNT_INDUSTRY_WHERE = "SELECT COUNT(industry) FROM Industry industry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "industry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Industry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Industry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IndustryPersistenceImpl.class);
	private static Industry _nullIndustry = new IndustryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Industry> toCacheModel() {
				return _nullIndustryCacheModel;
			}
		};

	private static CacheModel<Industry> _nullIndustryCacheModel = new CacheModel<Industry>() {
			@Override
			public Industry toEntityModel() {
				return _nullIndustry;
			}
		};
}