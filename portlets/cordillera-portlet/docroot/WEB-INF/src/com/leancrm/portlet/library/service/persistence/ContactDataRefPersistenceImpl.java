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

import com.leancrm.portlet.library.NoSuchContactDataRefException;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.impl.ContactDataRefImpl;
import com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl;

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
 * The persistence implementation for the contact data ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataRefPersistence
 * @see ContactDataRefUtil
 * @generated
 */
public class ContactDataRefPersistenceImpl extends BasePersistenceImpl<ContactDataRef>
	implements ContactDataRefPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDataRefUtil} to access the contact data ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDataRefImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefModelImpl.FINDER_CACHE_ENABLED,
			ContactDataRefImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefModelImpl.FINDER_CACHE_ENABLED,
			ContactDataRefImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ContactDataRefPersistenceImpl() {
		setModelClass(ContactDataRef.class);
	}

	/**
	 * Caches the contact data ref in the entity cache if it is enabled.
	 *
	 * @param contactDataRef the contact data ref
	 */
	@Override
	public void cacheResult(ContactDataRef contactDataRef) {
		EntityCacheUtil.putResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefImpl.class, contactDataRef.getPrimaryKey(),
			contactDataRef);

		contactDataRef.resetOriginalValues();
	}

	/**
	 * Caches the contact data refs in the entity cache if it is enabled.
	 *
	 * @param contactDataRefs the contact data refs
	 */
	@Override
	public void cacheResult(List<ContactDataRef> contactDataRefs) {
		for (ContactDataRef contactDataRef : contactDataRefs) {
			if (EntityCacheUtil.getResult(
						ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataRefImpl.class, contactDataRef.getPrimaryKey()) == null) {
				cacheResult(contactDataRef);
			}
			else {
				contactDataRef.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact data refs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDataRefImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDataRefImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact data ref.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDataRef contactDataRef) {
		EntityCacheUtil.removeResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefImpl.class, contactDataRef.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactDataRef> contactDataRefs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactDataRef contactDataRef : contactDataRefs) {
			EntityCacheUtil.removeResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataRefImpl.class, contactDataRef.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact data ref with the primary key. Does not add the contact data ref to the database.
	 *
	 * @param contactDataId the primary key for the new contact data ref
	 * @return the new contact data ref
	 */
	@Override
	public ContactDataRef create(long contactDataId) {
		ContactDataRef contactDataRef = new ContactDataRefImpl();

		contactDataRef.setNew(true);
		contactDataRef.setPrimaryKey(contactDataId);

		return contactDataRef;
	}

	/**
	 * Removes the contact data ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDataId the primary key of the contact data ref
	 * @return the contact data ref that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef remove(long contactDataId)
		throws NoSuchContactDataRefException, SystemException {
		return remove((Serializable)contactDataId);
	}

	/**
	 * Removes the contact data ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact data ref
	 * @return the contact data ref that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef remove(Serializable primaryKey)
		throws NoSuchContactDataRefException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactDataRef contactDataRef = (ContactDataRef)session.get(ContactDataRefImpl.class,
					primaryKey);

			if (contactDataRef == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDataRefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactDataRef);
		}
		catch (NoSuchContactDataRefException nsee) {
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
	protected ContactDataRef removeImpl(ContactDataRef contactDataRef)
		throws SystemException {
		contactDataRef = toUnwrappedModel(contactDataRef);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDataRef)) {
				contactDataRef = (ContactDataRef)session.get(ContactDataRefImpl.class,
						contactDataRef.getPrimaryKeyObj());
			}

			if (contactDataRef != null) {
				session.delete(contactDataRef);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactDataRef != null) {
			clearCache(contactDataRef);
		}

		return contactDataRef;
	}

	@Override
	public ContactDataRef updateImpl(
		com.leancrm.portlet.library.model.ContactDataRef contactDataRef)
		throws SystemException {
		contactDataRef = toUnwrappedModel(contactDataRef);

		boolean isNew = contactDataRef.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contactDataRef.isNew()) {
				session.save(contactDataRef);

				contactDataRef.setNew(false);
			}
			else {
				session.merge(contactDataRef);
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

		EntityCacheUtil.putResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataRefImpl.class, contactDataRef.getPrimaryKey(),
			contactDataRef);

		return contactDataRef;
	}

	protected ContactDataRef toUnwrappedModel(ContactDataRef contactDataRef) {
		if (contactDataRef instanceof ContactDataRefImpl) {
			return contactDataRef;
		}

		ContactDataRefImpl contactDataRefImpl = new ContactDataRefImpl();

		contactDataRefImpl.setNew(contactDataRef.isNew());
		contactDataRefImpl.setPrimaryKey(contactDataRef.getPrimaryKey());

		contactDataRefImpl.setContactDataId(contactDataRef.getContactDataId());
		contactDataRefImpl.setRefValue(contactDataRef.getRefValue());

		return contactDataRefImpl;
	}

	/**
	 * Returns the contact data ref with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data ref
	 * @return the contact data ref
	 * @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDataRefException, SystemException {
		ContactDataRef contactDataRef = fetchByPrimaryKey(primaryKey);

		if (contactDataRef == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDataRefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactDataRef;
	}

	/**
	 * Returns the contact data ref with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataRefException} if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data ref
	 * @return the contact data ref
	 * @throws com.leancrm.portlet.library.NoSuchContactDataRefException if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef findByPrimaryKey(long contactDataId)
		throws NoSuchContactDataRefException, SystemException {
		return findByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns the contact data ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data ref
	 * @return the contact data ref, or <code>null</code> if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactDataRef contactDataRef = (ContactDataRef)EntityCacheUtil.getResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataRefImpl.class, primaryKey);

		if (contactDataRef == _nullContactDataRef) {
			return null;
		}

		if (contactDataRef == null) {
			Session session = null;

			try {
				session = openSession();

				contactDataRef = (ContactDataRef)session.get(ContactDataRefImpl.class,
						primaryKey);

				if (contactDataRef != null) {
					cacheResult(contactDataRef);
				}
				else {
					EntityCacheUtil.putResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataRefImpl.class, primaryKey,
						_nullContactDataRef);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDataRefModelImpl.ENTITY_CACHE_ENABLED,
					ContactDataRefImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactDataRef;
	}

	/**
	 * Returns the contact data ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data ref
	 * @return the contact data ref, or <code>null</code> if a contact data ref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataRef fetchByPrimaryKey(long contactDataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns all the contact data refs.
	 *
	 * @return the contact data refs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataRef> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact data refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data refs
	 * @param end the upper bound of the range of contact data refs (not inclusive)
	 * @return the range of contact data refs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataRef> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact data refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data refs
	 * @param end the upper bound of the range of contact data refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact data refs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataRef> findAll(int start, int end,
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

		List<ContactDataRef> list = (List<ContactDataRef>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDATAREF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDATAREF;

				if (pagination) {
					sql = sql.concat(ContactDataRefModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactDataRef>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDataRef>(list);
				}
				else {
					list = (List<ContactDataRef>)QueryUtil.list(q,
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
	 * Removes all the contact data refs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactDataRef contactDataRef : findAll()) {
			remove(contactDataRef);
		}
	}

	/**
	 * Returns the number of contact data refs.
	 *
	 * @return the number of contact data refs
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDATAREF);

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
	 * Initializes the contact data ref persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactDataRef")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactDataRef>> listenersList = new ArrayList<ModelListener<ContactDataRef>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactDataRef>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDataRefImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDATAREF = "SELECT contactDataRef FROM ContactDataRef contactDataRef";
	private static final String _SQL_COUNT_CONTACTDATAREF = "SELECT COUNT(contactDataRef) FROM ContactDataRef contactDataRef";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDataRef.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactDataRef exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDataRefPersistenceImpl.class);
	private static ContactDataRef _nullContactDataRef = new ContactDataRefImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactDataRef> toCacheModel() {
				return _nullContactDataRefCacheModel;
			}
		};

	private static CacheModel<ContactDataRef> _nullContactDataRefCacheModel = new CacheModel<ContactDataRef>() {
			@Override
			public ContactDataRef toEntityModel() {
				return _nullContactDataRef;
			}
		};
}