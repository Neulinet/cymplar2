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

import com.leancrm.portlet.library.NoSuchOrganizationIndustryException;
import com.leancrm.portlet.library.model.OrganizationIndustry;
import com.leancrm.portlet.library.model.impl.OrganizationIndustryImpl;
import com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the organization industry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationIndustryPersistence
 * @see OrganizationIndustryUtil
 * @generated
 */
public class OrganizationIndustryPersistenceImpl extends BasePersistenceImpl<OrganizationIndustry>
	implements OrganizationIndustryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationIndustryUtil} to access the organization industry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationIndustryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryModelImpl.FINDER_CACHE_ENABLED,
			OrganizationIndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryModelImpl.FINDER_CACHE_ENABLED,
			OrganizationIndustryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrganizationIndustryPersistenceImpl() {
		setModelClass(OrganizationIndustry.class);
	}

	/**
	 * Caches the organization industry in the entity cache if it is enabled.
	 *
	 * @param organizationIndustry the organization industry
	 */
	@Override
	public void cacheResult(OrganizationIndustry organizationIndustry) {
		EntityCacheUtil.putResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryImpl.class,
			organizationIndustry.getPrimaryKey(), organizationIndustry);

		organizationIndustry.resetOriginalValues();
	}

	/**
	 * Caches the organization industries in the entity cache if it is enabled.
	 *
	 * @param organizationIndustries the organization industries
	 */
	@Override
	public void cacheResult(List<OrganizationIndustry> organizationIndustries) {
		for (OrganizationIndustry organizationIndustry : organizationIndustries) {
			if (EntityCacheUtil.getResult(
						OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationIndustryImpl.class,
						organizationIndustry.getPrimaryKey()) == null) {
				cacheResult(organizationIndustry);
			}
			else {
				organizationIndustry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organization industries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationIndustryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationIndustryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization industry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationIndustry organizationIndustry) {
		EntityCacheUtil.removeResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryImpl.class, organizationIndustry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrganizationIndustry> organizationIndustries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganizationIndustry organizationIndustry : organizationIndustries) {
			EntityCacheUtil.removeResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationIndustryImpl.class,
				organizationIndustry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organization industry with the primary key. Does not add the organization industry to the database.
	 *
	 * @param organizationIndustryPK the primary key for the new organization industry
	 * @return the new organization industry
	 */
	@Override
	public OrganizationIndustry create(
		OrganizationIndustryPK organizationIndustryPK) {
		OrganizationIndustry organizationIndustry = new OrganizationIndustryImpl();

		organizationIndustry.setNew(true);
		organizationIndustry.setPrimaryKey(organizationIndustryPK);

		return organizationIndustry;
	}

	/**
	 * Removes the organization industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationIndustryPK the primary key of the organization industry
	 * @return the organization industry that was removed
	 * @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry remove(
		OrganizationIndustryPK organizationIndustryPK)
		throws NoSuchOrganizationIndustryException, SystemException {
		return remove((Serializable)organizationIndustryPK);
	}

	/**
	 * Removes the organization industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization industry
	 * @return the organization industry that was removed
	 * @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry remove(Serializable primaryKey)
		throws NoSuchOrganizationIndustryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganizationIndustry organizationIndustry = (OrganizationIndustry)session.get(OrganizationIndustryImpl.class,
					primaryKey);

			if (organizationIndustry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationIndustryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizationIndustry);
		}
		catch (NoSuchOrganizationIndustryException nsee) {
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
	protected OrganizationIndustry removeImpl(
		OrganizationIndustry organizationIndustry) throws SystemException {
		organizationIndustry = toUnwrappedModel(organizationIndustry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationIndustry)) {
				organizationIndustry = (OrganizationIndustry)session.get(OrganizationIndustryImpl.class,
						organizationIndustry.getPrimaryKeyObj());
			}

			if (organizationIndustry != null) {
				session.delete(organizationIndustry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organizationIndustry != null) {
			clearCache(organizationIndustry);
		}

		return organizationIndustry;
	}

	@Override
	public OrganizationIndustry updateImpl(
		com.leancrm.portlet.library.model.OrganizationIndustry organizationIndustry)
		throws SystemException {
		organizationIndustry = toUnwrappedModel(organizationIndustry);

		boolean isNew = organizationIndustry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (organizationIndustry.isNew()) {
				session.save(organizationIndustry);

				organizationIndustry.setNew(false);
			}
			else {
				session.merge(organizationIndustry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationIndustryImpl.class,
			organizationIndustry.getPrimaryKey(), organizationIndustry);

		return organizationIndustry;
	}

	protected OrganizationIndustry toUnwrappedModel(
		OrganizationIndustry organizationIndustry) {
		if (organizationIndustry instanceof OrganizationIndustryImpl) {
			return organizationIndustry;
		}

		OrganizationIndustryImpl organizationIndustryImpl = new OrganizationIndustryImpl();

		organizationIndustryImpl.setNew(organizationIndustry.isNew());
		organizationIndustryImpl.setPrimaryKey(organizationIndustry.getPrimaryKey());

		organizationIndustryImpl.setOrganizationId(organizationIndustry.getOrganizationId());
		organizationIndustryImpl.setIndustryId(organizationIndustry.getIndustryId());

		return organizationIndustryImpl;
	}

	/**
	 * Returns the organization industry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization industry
	 * @return the organization industry
	 * @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationIndustryException, SystemException {
		OrganizationIndustry organizationIndustry = fetchByPrimaryKey(primaryKey);

		if (organizationIndustry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationIndustryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organizationIndustry;
	}

	/**
	 * Returns the organization industry with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchOrganizationIndustryException} if it could not be found.
	 *
	 * @param organizationIndustryPK the primary key of the organization industry
	 * @return the organization industry
	 * @throws com.leancrm.portlet.library.NoSuchOrganizationIndustryException if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry findByPrimaryKey(
		OrganizationIndustryPK organizationIndustryPK)
		throws NoSuchOrganizationIndustryException, SystemException {
		return findByPrimaryKey((Serializable)organizationIndustryPK);
	}

	/**
	 * Returns the organization industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization industry
	 * @return the organization industry, or <code>null</code> if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrganizationIndustry organizationIndustry = (OrganizationIndustry)EntityCacheUtil.getResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationIndustryImpl.class, primaryKey);

		if (organizationIndustry == _nullOrganizationIndustry) {
			return null;
		}

		if (organizationIndustry == null) {
			Session session = null;

			try {
				session = openSession();

				organizationIndustry = (OrganizationIndustry)session.get(OrganizationIndustryImpl.class,
						primaryKey);

				if (organizationIndustry != null) {
					cacheResult(organizationIndustry);
				}
				else {
					EntityCacheUtil.putResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationIndustryImpl.class, primaryKey,
						_nullOrganizationIndustry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizationIndustryModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationIndustryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organizationIndustry;
	}

	/**
	 * Returns the organization industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationIndustryPK the primary key of the organization industry
	 * @return the organization industry, or <code>null</code> if a organization industry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationIndustry fetchByPrimaryKey(
		OrganizationIndustryPK organizationIndustryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)organizationIndustryPK);
	}

	/**
	 * Returns all the organization industries.
	 *
	 * @return the organization industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationIndustry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization industries
	 * @param end the upper bound of the range of organization industries (not inclusive)
	 * @return the range of organization industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationIndustry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.OrganizationIndustryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization industries
	 * @param end the upper bound of the range of organization industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization industries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationIndustry> findAll(int start, int end,
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

		List<OrganizationIndustry> list = (List<OrganizationIndustry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATIONINDUSTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONINDUSTRY;

				if (pagination) {
					sql = sql.concat(OrganizationIndustryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrganizationIndustry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizationIndustry>(list);
				}
				else {
					list = (List<OrganizationIndustry>)QueryUtil.list(q,
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
	 * Removes all the organization industries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrganizationIndustry organizationIndustry : findAll()) {
			remove(organizationIndustry);
		}
	}

	/**
	 * Returns the number of organization industries.
	 *
	 * @return the number of organization industries
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

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONINDUSTRY);

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
	 * Initializes the organization industry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.OrganizationIndustry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganizationIndustry>> listenersList = new ArrayList<ModelListener<OrganizationIndustry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganizationIndustry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationIndustryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZATIONINDUSTRY = "SELECT organizationIndustry FROM OrganizationIndustry organizationIndustry";
	private static final String _SQL_COUNT_ORGANIZATIONINDUSTRY = "SELECT COUNT(organizationIndustry) FROM OrganizationIndustry organizationIndustry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationIndustry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganizationIndustry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationIndustryPersistenceImpl.class);
	private static OrganizationIndustry _nullOrganizationIndustry = new OrganizationIndustryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrganizationIndustry> toCacheModel() {
				return _nullOrganizationIndustryCacheModel;
			}
		};

	private static CacheModel<OrganizationIndustry> _nullOrganizationIndustryCacheModel =
		new CacheModel<OrganizationIndustry>() {
			@Override
			public OrganizationIndustry toEntityModel() {
				return _nullOrganizationIndustry;
			}
		};
}