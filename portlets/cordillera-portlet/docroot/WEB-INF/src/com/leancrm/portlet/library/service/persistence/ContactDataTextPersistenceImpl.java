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

import com.leancrm.portlet.library.NoSuchContactDataTextException;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.impl.ContactDataTextImpl;
import com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl;

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
 * The persistence implementation for the contact data text service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataTextPersistence
 * @see ContactDataTextUtil
 * @generated
 */
public class ContactDataTextPersistenceImpl extends BasePersistenceImpl<ContactDataText>
	implements ContactDataTextPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDataTextUtil} to access the contact data text persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDataTextImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextModelImpl.FINDER_CACHE_ENABLED,
			ContactDataTextImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextModelImpl.FINDER_CACHE_ENABLED,
			ContactDataTextImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ContactDataTextPersistenceImpl() {
		setModelClass(ContactDataText.class);
	}

	/**
	 * Caches the contact data text in the entity cache if it is enabled.
	 *
	 * @param contactDataText the contact data text
	 */
	@Override
	public void cacheResult(ContactDataText contactDataText) {
		EntityCacheUtil.putResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextImpl.class, contactDataText.getPrimaryKey(),
			contactDataText);

		contactDataText.resetOriginalValues();
	}

	/**
	 * Caches the contact data texts in the entity cache if it is enabled.
	 *
	 * @param contactDataTexts the contact data texts
	 */
	@Override
	public void cacheResult(List<ContactDataText> contactDataTexts) {
		for (ContactDataText contactDataText : contactDataTexts) {
			if (EntityCacheUtil.getResult(
						ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataTextImpl.class,
						contactDataText.getPrimaryKey()) == null) {
				cacheResult(contactDataText);
			}
			else {
				contactDataText.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact data texts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDataTextImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDataTextImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact data text.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDataText contactDataText) {
		EntityCacheUtil.removeResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextImpl.class, contactDataText.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactDataText> contactDataTexts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactDataText contactDataText : contactDataTexts) {
			EntityCacheUtil.removeResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataTextImpl.class, contactDataText.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact data text with the primary key. Does not add the contact data text to the database.
	 *
	 * @param contactDataId the primary key for the new contact data text
	 * @return the new contact data text
	 */
	@Override
	public ContactDataText create(long contactDataId) {
		ContactDataText contactDataText = new ContactDataTextImpl();

		contactDataText.setNew(true);
		contactDataText.setPrimaryKey(contactDataId);

		return contactDataText;
	}

	/**
	 * Removes the contact data text with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDataId the primary key of the contact data text
	 * @return the contact data text that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText remove(long contactDataId)
		throws NoSuchContactDataTextException, SystemException {
		return remove((Serializable)contactDataId);
	}

	/**
	 * Removes the contact data text with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact data text
	 * @return the contact data text that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText remove(Serializable primaryKey)
		throws NoSuchContactDataTextException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactDataText contactDataText = (ContactDataText)session.get(ContactDataTextImpl.class,
					primaryKey);

			if (contactDataText == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDataTextException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactDataText);
		}
		catch (NoSuchContactDataTextException nsee) {
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
	protected ContactDataText removeImpl(ContactDataText contactDataText)
		throws SystemException {
		contactDataText = toUnwrappedModel(contactDataText);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDataText)) {
				contactDataText = (ContactDataText)session.get(ContactDataTextImpl.class,
						contactDataText.getPrimaryKeyObj());
			}

			if (contactDataText != null) {
				session.delete(contactDataText);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactDataText != null) {
			clearCache(contactDataText);
		}

		return contactDataText;
	}

	@Override
	public ContactDataText updateImpl(
		com.leancrm.portlet.library.model.ContactDataText contactDataText)
		throws SystemException {
		contactDataText = toUnwrappedModel(contactDataText);

		boolean isNew = contactDataText.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contactDataText.isNew()) {
				session.save(contactDataText);

				contactDataText.setNew(false);
			}
			else {
				session.merge(contactDataText);
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

		EntityCacheUtil.putResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataTextImpl.class, contactDataText.getPrimaryKey(),
			contactDataText);

		return contactDataText;
	}

	protected ContactDataText toUnwrappedModel(ContactDataText contactDataText) {
		if (contactDataText instanceof ContactDataTextImpl) {
			return contactDataText;
		}

		ContactDataTextImpl contactDataTextImpl = new ContactDataTextImpl();

		contactDataTextImpl.setNew(contactDataText.isNew());
		contactDataTextImpl.setPrimaryKey(contactDataText.getPrimaryKey());

		contactDataTextImpl.setContactDataId(contactDataText.getContactDataId());
		contactDataTextImpl.setValue(contactDataText.getValue());

		return contactDataTextImpl;
	}

	/**
	 * Returns the contact data text with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data text
	 * @return the contact data text
	 * @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDataTextException, SystemException {
		ContactDataText contactDataText = fetchByPrimaryKey(primaryKey);

		if (contactDataText == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDataTextException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactDataText;
	}

	/**
	 * Returns the contact data text with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataTextException} if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data text
	 * @return the contact data text
	 * @throws com.leancrm.portlet.library.NoSuchContactDataTextException if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText findByPrimaryKey(long contactDataId)
		throws NoSuchContactDataTextException, SystemException {
		return findByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns the contact data text with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data text
	 * @return the contact data text, or <code>null</code> if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactDataText contactDataText = (ContactDataText)EntityCacheUtil.getResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataTextImpl.class, primaryKey);

		if (contactDataText == _nullContactDataText) {
			return null;
		}

		if (contactDataText == null) {
			Session session = null;

			try {
				session = openSession();

				contactDataText = (ContactDataText)session.get(ContactDataTextImpl.class,
						primaryKey);

				if (contactDataText != null) {
					cacheResult(contactDataText);
				}
				else {
					EntityCacheUtil.putResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataTextImpl.class, primaryKey,
						_nullContactDataText);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDataTextModelImpl.ENTITY_CACHE_ENABLED,
					ContactDataTextImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactDataText;
	}

	/**
	 * Returns the contact data text with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data text
	 * @return the contact data text, or <code>null</code> if a contact data text with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataText fetchByPrimaryKey(long contactDataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns all the contact data texts.
	 *
	 * @return the contact data texts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataText> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact data texts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data texts
	 * @param end the upper bound of the range of contact data texts (not inclusive)
	 * @return the range of contact data texts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataText> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact data texts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataTextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data texts
	 * @param end the upper bound of the range of contact data texts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact data texts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataText> findAll(int start, int end,
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

		List<ContactDataText> list = (List<ContactDataText>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDATATEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDATATEXT;

				if (pagination) {
					sql = sql.concat(ContactDataTextModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactDataText>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDataText>(list);
				}
				else {
					list = (List<ContactDataText>)QueryUtil.list(q,
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
	 * Removes all the contact data texts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactDataText contactDataText : findAll()) {
			remove(contactDataText);
		}
	}

	/**
	 * Returns the number of contact data texts.
	 *
	 * @return the number of contact data texts
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDATATEXT);

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
	 * Initializes the contact data text persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactDataText")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactDataText>> listenersList = new ArrayList<ModelListener<ContactDataText>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactDataText>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDataTextImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDATATEXT = "SELECT contactDataText FROM ContactDataText contactDataText";
	private static final String _SQL_COUNT_CONTACTDATATEXT = "SELECT COUNT(contactDataText) FROM ContactDataText contactDataText";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDataText.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactDataText exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDataTextPersistenceImpl.class);
	private static ContactDataText _nullContactDataText = new ContactDataTextImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactDataText> toCacheModel() {
				return _nullContactDataTextCacheModel;
			}
		};

	private static CacheModel<ContactDataText> _nullContactDataTextCacheModel = new CacheModel<ContactDataText>() {
			@Override
			public ContactDataText toEntityModel() {
				return _nullContactDataText;
			}
		};
}