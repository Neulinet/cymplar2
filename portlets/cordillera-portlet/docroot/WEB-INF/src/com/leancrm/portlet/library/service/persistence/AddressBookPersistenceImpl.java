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

import com.leancrm.portlet.library.NoSuchAddressBookException;
import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.impl.AddressBookImpl;
import com.leancrm.portlet.library.model.impl.AddressBookModelImpl;

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
 * The persistence implementation for the address book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookPersistence
 * @see AddressBookUtil
 * @generated
 */
public class AddressBookPersistenceImpl extends BasePersistenceImpl<AddressBook>
	implements AddressBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressBookUtil} to access the address book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookModelImpl.FINDER_CACHE_ENABLED, AddressBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookModelImpl.FINDER_CACHE_ENABLED, AddressBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AddressBookPersistenceImpl() {
		setModelClass(AddressBook.class);
	}

	/**
	 * Caches the address book in the entity cache if it is enabled.
	 *
	 * @param addressBook the address book
	 */
	@Override
	public void cacheResult(AddressBook addressBook) {
		EntityCacheUtil.putResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookImpl.class, addressBook.getPrimaryKey(), addressBook);

		addressBook.resetOriginalValues();
	}

	/**
	 * Caches the address books in the entity cache if it is enabled.
	 *
	 * @param addressBooks the address books
	 */
	@Override
	public void cacheResult(List<AddressBook> addressBooks) {
		for (AddressBook addressBook : addressBooks) {
			if (EntityCacheUtil.getResult(
						AddressBookModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookImpl.class, addressBook.getPrimaryKey()) == null) {
				cacheResult(addressBook);
			}
			else {
				addressBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressBook addressBook) {
		EntityCacheUtil.removeResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookImpl.class, addressBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AddressBook> addressBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressBook addressBook : addressBooks) {
			EntityCacheUtil.removeResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookImpl.class, addressBook.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address book with the primary key. Does not add the address book to the database.
	 *
	 * @param addressBookId the primary key for the new address book
	 * @return the new address book
	 */
	@Override
	public AddressBook create(long addressBookId) {
		AddressBook addressBook = new AddressBookImpl();

		addressBook.setNew(true);
		addressBook.setPrimaryKey(addressBookId);

		return addressBook;
	}

	/**
	 * Removes the address book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressBookId the primary key of the address book
	 * @return the address book that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook remove(long addressBookId)
		throws NoSuchAddressBookException, SystemException {
		return remove((Serializable)addressBookId);
	}

	/**
	 * Removes the address book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address book
	 * @return the address book that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook remove(Serializable primaryKey)
		throws NoSuchAddressBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressBook addressBook = (AddressBook)session.get(AddressBookImpl.class,
					primaryKey);

			if (addressBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressBook);
		}
		catch (NoSuchAddressBookException nsee) {
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
	protected AddressBook removeImpl(AddressBook addressBook)
		throws SystemException {
		addressBook = toUnwrappedModel(addressBook);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressBook)) {
				addressBook = (AddressBook)session.get(AddressBookImpl.class,
						addressBook.getPrimaryKeyObj());
			}

			if (addressBook != null) {
				session.delete(addressBook);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressBook != null) {
			clearCache(addressBook);
		}

		return addressBook;
	}

	@Override
	public AddressBook updateImpl(
		com.leancrm.portlet.library.model.AddressBook addressBook)
		throws SystemException {
		addressBook = toUnwrappedModel(addressBook);

		boolean isNew = addressBook.isNew();

		Session session = null;

		try {
			session = openSession();

			if (addressBook.isNew()) {
				session.save(addressBook);

				addressBook.setNew(false);
			}
			else {
				session.merge(addressBook);
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

		EntityCacheUtil.putResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookImpl.class, addressBook.getPrimaryKey(), addressBook);

		return addressBook;
	}

	protected AddressBook toUnwrappedModel(AddressBook addressBook) {
		if (addressBook instanceof AddressBookImpl) {
			return addressBook;
		}

		AddressBookImpl addressBookImpl = new AddressBookImpl();

		addressBookImpl.setNew(addressBook.isNew());
		addressBookImpl.setPrimaryKey(addressBook.getPrimaryKey());

		addressBookImpl.setAddressBookId(addressBook.getAddressBookId());
		addressBookImpl.setGroupId(addressBook.getGroupId());
		addressBookImpl.setCompanyId(addressBook.getCompanyId());
		addressBookImpl.setCreateDate(addressBook.getCreateDate());
		addressBookImpl.setModifiedDate(addressBook.getModifiedDate());
		addressBookImpl.setAddressBookType(addressBook.getAddressBookType());

		return addressBookImpl;
	}

	/**
	 * Returns the address book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book
	 * @return the address book
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressBookException, SystemException {
		AddressBook addressBook = fetchByPrimaryKey(primaryKey);

		if (addressBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressBook;
	}

	/**
	 * Returns the address book with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookException} if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book
	 * @return the address book
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookException if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook findByPrimaryKey(long addressBookId)
		throws NoSuchAddressBookException, SystemException {
		return findByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns the address book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book
	 * @return the address book, or <code>null</code> if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressBook addressBook = (AddressBook)EntityCacheUtil.getResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookImpl.class, primaryKey);

		if (addressBook == _nullAddressBook) {
			return null;
		}

		if (addressBook == null) {
			Session session = null;

			try {
				session = openSession();

				addressBook = (AddressBook)session.get(AddressBookImpl.class,
						primaryKey);

				if (addressBook != null) {
					cacheResult(addressBook);
				}
				else {
					EntityCacheUtil.putResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookImpl.class, primaryKey, _nullAddressBook);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressBookModelImpl.ENTITY_CACHE_ENABLED,
					AddressBookImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressBook;
	}

	/**
	 * Returns the address book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book
	 * @return the address book, or <code>null</code> if a address book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBook fetchByPrimaryKey(long addressBookId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns all the address books.
	 *
	 * @return the address books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address books
	 * @param end the upper bound of the range of address books (not inclusive)
	 * @return the range of address books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBook> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address books
	 * @param end the upper bound of the range of address books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address books
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBook> findAll(int start, int end,
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

		List<AddressBook> list = (List<AddressBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSBOOK;

				if (pagination) {
					sql = sql.concat(AddressBookModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBook>(list);
				}
				else {
					list = (List<AddressBook>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the address books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressBook addressBook : findAll()) {
			remove(addressBook);
		}
	}

	/**
	 * Returns the number of address books.
	 *
	 * @return the number of address books
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSBOOK);

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
	 * Initializes the address book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.AddressBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressBook>> listenersList = new ArrayList<ModelListener<AddressBook>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressBook>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSBOOK = "SELECT addressBook FROM AddressBook addressBook";
	private static final String _SQL_COUNT_ADDRESSBOOK = "SELECT COUNT(addressBook) FROM AddressBook addressBook";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressBook exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressBookPersistenceImpl.class);
	private static AddressBook _nullAddressBook = new AddressBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressBook> toCacheModel() {
				return _nullAddressBookCacheModel;
			}
		};

	private static CacheModel<AddressBook> _nullAddressBookCacheModel = new CacheModel<AddressBook>() {
			@Override
			public AddressBook toEntityModel() {
				return _nullAddressBook;
			}
		};
}