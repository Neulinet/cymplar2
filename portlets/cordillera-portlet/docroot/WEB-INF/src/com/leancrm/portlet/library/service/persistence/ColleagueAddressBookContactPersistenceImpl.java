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

import com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException;
import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactImpl;
import com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl;

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
 * The persistence implementation for the colleague address book contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColleagueAddressBookContactPersistence
 * @see ColleagueAddressBookContactUtil
 * @generated
 */
public class ColleagueAddressBookContactPersistenceImpl
	extends BasePersistenceImpl<ColleagueAddressBookContact>
	implements ColleagueAddressBookContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ColleagueAddressBookContactUtil} to access the colleague address book contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ColleagueAddressBookContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			ColleagueAddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			ColleagueAddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public ColleagueAddressBookContactPersistenceImpl() {
		setModelClass(ColleagueAddressBookContact.class);
	}

	/**
	 * Caches the colleague address book contact in the entity cache if it is enabled.
	 *
	 * @param colleagueAddressBookContact the colleague address book contact
	 */
	@Override
	public void cacheResult(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		EntityCacheUtil.putResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactImpl.class,
			colleagueAddressBookContact.getPrimaryKey(),
			colleagueAddressBookContact);

		colleagueAddressBookContact.resetOriginalValues();
	}

	/**
	 * Caches the colleague address book contacts in the entity cache if it is enabled.
	 *
	 * @param colleagueAddressBookContacts the colleague address book contacts
	 */
	@Override
	public void cacheResult(
		List<ColleagueAddressBookContact> colleagueAddressBookContacts) {
		for (ColleagueAddressBookContact colleagueAddressBookContact : colleagueAddressBookContacts) {
			if (EntityCacheUtil.getResult(
						ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						ColleagueAddressBookContactImpl.class,
						colleagueAddressBookContact.getPrimaryKey()) == null) {
				cacheResult(colleagueAddressBookContact);
			}
			else {
				colleagueAddressBookContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all colleague address book contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ColleagueAddressBookContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ColleagueAddressBookContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the colleague address book contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		EntityCacheUtil.removeResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactImpl.class,
			colleagueAddressBookContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ColleagueAddressBookContact> colleagueAddressBookContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ColleagueAddressBookContact colleagueAddressBookContact : colleagueAddressBookContacts) {
			EntityCacheUtil.removeResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				ColleagueAddressBookContactImpl.class,
				colleagueAddressBookContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new colleague address book contact with the primary key. Does not add the colleague address book contact to the database.
	 *
	 * @param colleagueAddressBookContactPK the primary key for the new colleague address book contact
	 * @return the new colleague address book contact
	 */
	@Override
	public ColleagueAddressBookContact create(
		ColleagueAddressBookContactPK colleagueAddressBookContactPK) {
		ColleagueAddressBookContact colleagueAddressBookContact = new ColleagueAddressBookContactImpl();

		colleagueAddressBookContact.setNew(true);
		colleagueAddressBookContact.setPrimaryKey(colleagueAddressBookContactPK);

		return colleagueAddressBookContact;
	}

	/**
	 * Removes the colleague address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	 * @return the colleague address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact remove(
		ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws NoSuchColleagueAddressBookContactException, SystemException {
		return remove((Serializable)colleagueAddressBookContactPK);
	}

	/**
	 * Removes the colleague address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the colleague address book contact
	 * @return the colleague address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact remove(Serializable primaryKey)
		throws NoSuchColleagueAddressBookContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ColleagueAddressBookContact colleagueAddressBookContact = (ColleagueAddressBookContact)session.get(ColleagueAddressBookContactImpl.class,
					primaryKey);

			if (colleagueAddressBookContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchColleagueAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(colleagueAddressBookContact);
		}
		catch (NoSuchColleagueAddressBookContactException nsee) {
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
	protected ColleagueAddressBookContact removeImpl(
		ColleagueAddressBookContact colleagueAddressBookContact)
		throws SystemException {
		colleagueAddressBookContact = toUnwrappedModel(colleagueAddressBookContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(colleagueAddressBookContact)) {
				colleagueAddressBookContact = (ColleagueAddressBookContact)session.get(ColleagueAddressBookContactImpl.class,
						colleagueAddressBookContact.getPrimaryKeyObj());
			}

			if (colleagueAddressBookContact != null) {
				session.delete(colleagueAddressBookContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (colleagueAddressBookContact != null) {
			clearCache(colleagueAddressBookContact);
		}

		return colleagueAddressBookContact;
	}

	@Override
	public ColleagueAddressBookContact updateImpl(
		com.leancrm.portlet.library.model.ColleagueAddressBookContact colleagueAddressBookContact)
		throws SystemException {
		colleagueAddressBookContact = toUnwrappedModel(colleagueAddressBookContact);

		boolean isNew = colleagueAddressBookContact.isNew();

		Session session = null;

		try {
			session = openSession();

			if (colleagueAddressBookContact.isNew()) {
				session.save(colleagueAddressBookContact);

				colleagueAddressBookContact.setNew(false);
			}
			else {
				session.merge(colleagueAddressBookContact);
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

		EntityCacheUtil.putResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			ColleagueAddressBookContactImpl.class,
			colleagueAddressBookContact.getPrimaryKey(),
			colleagueAddressBookContact);

		return colleagueAddressBookContact;
	}

	protected ColleagueAddressBookContact toUnwrappedModel(
		ColleagueAddressBookContact colleagueAddressBookContact) {
		if (colleagueAddressBookContact instanceof ColleagueAddressBookContactImpl) {
			return colleagueAddressBookContact;
		}

		ColleagueAddressBookContactImpl colleagueAddressBookContactImpl = new ColleagueAddressBookContactImpl();

		colleagueAddressBookContactImpl.setNew(colleagueAddressBookContact.isNew());
		colleagueAddressBookContactImpl.setPrimaryKey(colleagueAddressBookContact.getPrimaryKey());

		colleagueAddressBookContactImpl.setContactid(colleagueAddressBookContact.getContactid());
		colleagueAddressBookContactImpl.setEmailAddress(colleagueAddressBookContact.getEmailAddress());
		colleagueAddressBookContactImpl.setContactdataid(colleagueAddressBookContact.getContactdataid());
		colleagueAddressBookContactImpl.setMethodId(colleagueAddressBookContact.getMethodId());
		colleagueAddressBookContactImpl.setContactName(colleagueAddressBookContact.getContactName());
		colleagueAddressBookContactImpl.setEnterpriseName(colleagueAddressBookContact.getEnterpriseName());

		return colleagueAddressBookContactImpl;
	}

	/**
	 * Returns the colleague address book contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the colleague address book contact
	 * @return the colleague address book contact
	 * @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchColleagueAddressBookContactException, SystemException {
		ColleagueAddressBookContact colleagueAddressBookContact = fetchByPrimaryKey(primaryKey);

		if (colleagueAddressBookContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchColleagueAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return colleagueAddressBookContact;
	}

	/**
	 * Returns the colleague address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException} if it could not be found.
	 *
	 * @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	 * @return the colleague address book contact
	 * @throws com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact findByPrimaryKey(
		ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws NoSuchColleagueAddressBookContactException, SystemException {
		return findByPrimaryKey((Serializable)colleagueAddressBookContactPK);
	}

	/**
	 * Returns the colleague address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the colleague address book contact
	 * @return the colleague address book contact, or <code>null</code> if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ColleagueAddressBookContact colleagueAddressBookContact = (ColleagueAddressBookContact)EntityCacheUtil.getResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				ColleagueAddressBookContactImpl.class, primaryKey);

		if (colleagueAddressBookContact == _nullColleagueAddressBookContact) {
			return null;
		}

		if (colleagueAddressBookContact == null) {
			Session session = null;

			try {
				session = openSession();

				colleagueAddressBookContact = (ColleagueAddressBookContact)session.get(ColleagueAddressBookContactImpl.class,
						primaryKey);

				if (colleagueAddressBookContact != null) {
					cacheResult(colleagueAddressBookContact);
				}
				else {
					EntityCacheUtil.putResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						ColleagueAddressBookContactImpl.class, primaryKey,
						_nullColleagueAddressBookContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ColleagueAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
					ColleagueAddressBookContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return colleagueAddressBookContact;
	}

	/**
	 * Returns the colleague address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param colleagueAddressBookContactPK the primary key of the colleague address book contact
	 * @return the colleague address book contact, or <code>null</code> if a colleague address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ColleagueAddressBookContact fetchByPrimaryKey(
		ColleagueAddressBookContactPK colleagueAddressBookContactPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)colleagueAddressBookContactPK);
	}

	/**
	 * Returns all the colleague address book contacts.
	 *
	 * @return the colleague address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ColleagueAddressBookContact> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the colleague address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of colleague address book contacts
	 * @param end the upper bound of the range of colleague address book contacts (not inclusive)
	 * @return the range of colleague address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ColleagueAddressBookContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the colleague address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of colleague address book contacts
	 * @param end the upper bound of the range of colleague address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of colleague address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ColleagueAddressBookContact> findAll(int start, int end,
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

		List<ColleagueAddressBookContact> list = (List<ColleagueAddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COLLEAGUEADDRESSBOOKCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COLLEAGUEADDRESSBOOKCONTACT;

				if (pagination) {
					sql = sql.concat(ColleagueAddressBookContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ColleagueAddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ColleagueAddressBookContact>(list);
				}
				else {
					list = (List<ColleagueAddressBookContact>)QueryUtil.list(q,
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
	 * Removes all the colleague address book contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ColleagueAddressBookContact colleagueAddressBookContact : findAll()) {
			remove(colleagueAddressBookContact);
		}
	}

	/**
	 * Returns the number of colleague address book contacts.
	 *
	 * @return the number of colleague address book contacts
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

				Query q = session.createQuery(_SQL_COUNT_COLLEAGUEADDRESSBOOKCONTACT);

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
	 * Initializes the colleague address book contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ColleagueAddressBookContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ColleagueAddressBookContact>> listenersList = new ArrayList<ModelListener<ColleagueAddressBookContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ColleagueAddressBookContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ColleagueAddressBookContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COLLEAGUEADDRESSBOOKCONTACT = "SELECT colleagueAddressBookContact FROM ColleagueAddressBookContact colleagueAddressBookContact";
	private static final String _SQL_COUNT_COLLEAGUEADDRESSBOOKCONTACT = "SELECT COUNT(colleagueAddressBookContact) FROM ColleagueAddressBookContact colleagueAddressBookContact";
	private static final String _ORDER_BY_ENTITY_ALIAS = "colleagueAddressBookContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ColleagueAddressBookContact exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ColleagueAddressBookContactPersistenceImpl.class);
	private static ColleagueAddressBookContact _nullColleagueAddressBookContact = new ColleagueAddressBookContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ColleagueAddressBookContact> toCacheModel() {
				return _nullColleagueAddressBookContactCacheModel;
			}
		};

	private static CacheModel<ColleagueAddressBookContact> _nullColleagueAddressBookContactCacheModel =
		new CacheModel<ColleagueAddressBookContact>() {
			@Override
			public ColleagueAddressBookContact toEntityModel() {
				return _nullColleagueAddressBookContact;
			}
		};
}