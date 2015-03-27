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

import com.leancrm.portlet.library.NoSuchContactDataPhoneException;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.impl.ContactDataPhoneImpl;
import com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the contact data phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPhonePersistence
 * @see ContactDataPhoneUtil
 * @generated
 */
public class ContactDataPhonePersistenceImpl extends BasePersistenceImpl<ContactDataPhone>
	implements ContactDataPhonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDataPhoneUtil} to access the contact data phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDataPhoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneModelImpl.FINDER_CACHE_ENABLED,
			ContactDataPhoneImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneModelImpl.FINDER_CACHE_ENABLED,
			ContactDataPhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ContactDataPhonePersistenceImpl() {
		setModelClass(ContactDataPhone.class);
	}

	/**
	 * Caches the contact data phone in the entity cache if it is enabled.
	 *
	 * @param contactDataPhone the contact data phone
	 */
	@Override
	public void cacheResult(ContactDataPhone contactDataPhone) {
		EntityCacheUtil.putResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneImpl.class, contactDataPhone.getPrimaryKey(),
			contactDataPhone);

		contactDataPhone.resetOriginalValues();
	}

	/**
	 * Caches the contact data phones in the entity cache if it is enabled.
	 *
	 * @param contactDataPhones the contact data phones
	 */
	@Override
	public void cacheResult(List<ContactDataPhone> contactDataPhones) {
		for (ContactDataPhone contactDataPhone : contactDataPhones) {
			if (EntityCacheUtil.getResult(
						ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataPhoneImpl.class,
						contactDataPhone.getPrimaryKey()) == null) {
				cacheResult(contactDataPhone);
			}
			else {
				contactDataPhone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact data phones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDataPhoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDataPhoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact data phone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDataPhone contactDataPhone) {
		EntityCacheUtil.removeResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneImpl.class, contactDataPhone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactDataPhone> contactDataPhones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactDataPhone contactDataPhone : contactDataPhones) {
			EntityCacheUtil.removeResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataPhoneImpl.class, contactDataPhone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact data phone with the primary key. Does not add the contact data phone to the database.
	 *
	 * @param contactDataId the primary key for the new contact data phone
	 * @return the new contact data phone
	 */
	@Override
	public ContactDataPhone create(long contactDataId) {
		ContactDataPhone contactDataPhone = new ContactDataPhoneImpl();

		contactDataPhone.setNew(true);
		contactDataPhone.setPrimaryKey(contactDataId);

		return contactDataPhone;
	}

	/**
	 * Removes the contact data phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDataId the primary key of the contact data phone
	 * @return the contact data phone that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone remove(long contactDataId)
		throws NoSuchContactDataPhoneException, SystemException {
		return remove((Serializable)contactDataId);
	}

	/**
	 * Removes the contact data phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact data phone
	 * @return the contact data phone that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone remove(Serializable primaryKey)
		throws NoSuchContactDataPhoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactDataPhone contactDataPhone = (ContactDataPhone)session.get(ContactDataPhoneImpl.class,
					primaryKey);

			if (contactDataPhone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDataPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactDataPhone);
		}
		catch (NoSuchContactDataPhoneException nsee) {
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
	protected ContactDataPhone removeImpl(ContactDataPhone contactDataPhone)
		throws SystemException {
		contactDataPhone = toUnwrappedModel(contactDataPhone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDataPhone)) {
				contactDataPhone = (ContactDataPhone)session.get(ContactDataPhoneImpl.class,
						contactDataPhone.getPrimaryKeyObj());
			}

			if (contactDataPhone != null) {
				session.delete(contactDataPhone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactDataPhone != null) {
			clearCache(contactDataPhone);
		}

		return contactDataPhone;
	}

	@Override
	public ContactDataPhone updateImpl(
		com.leancrm.portlet.library.model.ContactDataPhone contactDataPhone)
		throws SystemException {
		contactDataPhone = toUnwrappedModel(contactDataPhone);

		boolean isNew = contactDataPhone.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contactDataPhone.isNew()) {
				session.save(contactDataPhone);

				contactDataPhone.setNew(false);
			}
			else {
				session.merge(contactDataPhone);
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

		EntityCacheUtil.putResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataPhoneImpl.class, contactDataPhone.getPrimaryKey(),
			contactDataPhone);

		return contactDataPhone;
	}

	protected ContactDataPhone toUnwrappedModel(
		ContactDataPhone contactDataPhone) {
		if (contactDataPhone instanceof ContactDataPhoneImpl) {
			return contactDataPhone;
		}

		ContactDataPhoneImpl contactDataPhoneImpl = new ContactDataPhoneImpl();

		contactDataPhoneImpl.setNew(contactDataPhone.isNew());
		contactDataPhoneImpl.setPrimaryKey(contactDataPhone.getPrimaryKey());

		contactDataPhoneImpl.setContactDataId(contactDataPhone.getContactDataId());
		contactDataPhoneImpl.setExtension(contactDataPhone.getExtension());
		contactDataPhoneImpl.setNumber(contactDataPhone.getNumber());

		return contactDataPhoneImpl;
	}

	/**
	 * Returns the contact data phone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data phone
	 * @return the contact data phone
	 * @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDataPhoneException, SystemException {
		ContactDataPhone contactDataPhone = fetchByPrimaryKey(primaryKey);

		if (contactDataPhone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDataPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactDataPhone;
	}

	/**
	 * Returns the contact data phone with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataPhoneException} if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data phone
	 * @return the contact data phone
	 * @throws com.leancrm.portlet.library.NoSuchContactDataPhoneException if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone findByPrimaryKey(long contactDataId)
		throws NoSuchContactDataPhoneException, SystemException {
		return findByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns the contact data phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data phone
	 * @return the contact data phone, or <code>null</code> if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactDataPhone contactDataPhone = (ContactDataPhone)EntityCacheUtil.getResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataPhoneImpl.class, primaryKey);

		if (contactDataPhone == _nullContactDataPhone) {
			return null;
		}

		if (contactDataPhone == null) {
			Session session = null;

			try {
				session = openSession();

				contactDataPhone = (ContactDataPhone)session.get(ContactDataPhoneImpl.class,
						primaryKey);

				if (contactDataPhone != null) {
					cacheResult(contactDataPhone);
				}
				else {
					EntityCacheUtil.putResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataPhoneImpl.class, primaryKey,
						_nullContactDataPhone);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDataPhoneModelImpl.ENTITY_CACHE_ENABLED,
					ContactDataPhoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactDataPhone;
	}

	/**
	 * Returns the contact data phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data phone
	 * @return the contact data phone, or <code>null</code> if a contact data phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataPhone fetchByPrimaryKey(long contactDataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns all the contact data phones.
	 *
	 * @return the contact data phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataPhone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact data phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data phones
	 * @param end the upper bound of the range of contact data phones (not inclusive)
	 * @return the range of contact data phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataPhone> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact data phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data phones
	 * @param end the upper bound of the range of contact data phones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact data phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataPhone> findAll(int start, int end,
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

		List<ContactDataPhone> list = (List<ContactDataPhone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDATAPHONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDATAPHONE;

				if (pagination) {
					sql = sql.concat(ContactDataPhoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactDataPhone>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDataPhone>(list);
				}
				else {
					list = (List<ContactDataPhone>)QueryUtil.list(q,
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
	 * Removes all the contact data phones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactDataPhone contactDataPhone : findAll()) {
			remove(contactDataPhone);
		}
	}

	/**
	 * Returns the number of contact data phones.
	 *
	 * @return the number of contact data phones
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDATAPHONE);

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
	 * Initializes the contact data phone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactDataPhone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactDataPhone>> listenersList = new ArrayList<ModelListener<ContactDataPhone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactDataPhone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDataPhoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDATAPHONE = "SELECT contactDataPhone FROM ContactDataPhone contactDataPhone";
	private static final String _SQL_COUNT_CONTACTDATAPHONE = "SELECT COUNT(contactDataPhone) FROM ContactDataPhone contactDataPhone";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDataPhone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactDataPhone exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDataPhonePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number"
			});
	private static ContactDataPhone _nullContactDataPhone = new ContactDataPhoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactDataPhone> toCacheModel() {
				return _nullContactDataPhoneCacheModel;
			}
		};

	private static CacheModel<ContactDataPhone> _nullContactDataPhoneCacheModel = new CacheModel<ContactDataPhone>() {
			@Override
			public ContactDataPhone toEntityModel() {
				return _nullContactDataPhone;
			}
		};
}