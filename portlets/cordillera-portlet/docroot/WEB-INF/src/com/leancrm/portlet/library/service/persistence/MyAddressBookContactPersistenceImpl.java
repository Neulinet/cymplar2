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

import com.leancrm.portlet.library.NoSuchMyAddressBookContactException;
import com.leancrm.portlet.library.model.MyAddressBookContact;
import com.leancrm.portlet.library.model.impl.MyAddressBookContactImpl;
import com.leancrm.portlet.library.model.impl.MyAddressBookContactModelImpl;

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
 * The persistence implementation for the my address book contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyAddressBookContactPersistence
 * @see MyAddressBookContactUtil
 * @generated
 */
public class MyAddressBookContactPersistenceImpl extends BasePersistenceImpl<MyAddressBookContact>
	implements MyAddressBookContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MyAddressBookContactUtil} to access the my address book contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MyAddressBookContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			MyAddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			MyAddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MyAddressBookContactPersistenceImpl() {
		setModelClass(MyAddressBookContact.class);
	}

	/**
	 * Caches the my address book contact in the entity cache if it is enabled.
	 *
	 * @param myAddressBookContact the my address book contact
	 */
	@Override
	public void cacheResult(MyAddressBookContact myAddressBookContact) {
		EntityCacheUtil.putResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactImpl.class,
			myAddressBookContact.getPrimaryKey(), myAddressBookContact);

		myAddressBookContact.resetOriginalValues();
	}

	/**
	 * Caches the my address book contacts in the entity cache if it is enabled.
	 *
	 * @param myAddressBookContacts the my address book contacts
	 */
	@Override
	public void cacheResult(List<MyAddressBookContact> myAddressBookContacts) {
		for (MyAddressBookContact myAddressBookContact : myAddressBookContacts) {
			if (EntityCacheUtil.getResult(
						MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						MyAddressBookContactImpl.class,
						myAddressBookContact.getPrimaryKey()) == null) {
				cacheResult(myAddressBookContact);
			}
			else {
				myAddressBookContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all my address book contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MyAddressBookContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MyAddressBookContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the my address book contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyAddressBookContact myAddressBookContact) {
		EntityCacheUtil.removeResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactImpl.class, myAddressBookContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MyAddressBookContact> myAddressBookContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MyAddressBookContact myAddressBookContact : myAddressBookContacts) {
			EntityCacheUtil.removeResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				MyAddressBookContactImpl.class,
				myAddressBookContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new my address book contact with the primary key. Does not add the my address book contact to the database.
	 *
	 * @param myAddressBookContactPK the primary key for the new my address book contact
	 * @return the new my address book contact
	 */
	@Override
	public MyAddressBookContact create(
		MyAddressBookContactPK myAddressBookContactPK) {
		MyAddressBookContact myAddressBookContact = new MyAddressBookContactImpl();

		myAddressBookContact.setNew(true);
		myAddressBookContact.setPrimaryKey(myAddressBookContactPK);

		return myAddressBookContact;
	}

	/**
	 * Removes the my address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myAddressBookContactPK the primary key of the my address book contact
	 * @return the my address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact remove(
		MyAddressBookContactPK myAddressBookContactPK)
		throws NoSuchMyAddressBookContactException, SystemException {
		return remove((Serializable)myAddressBookContactPK);
	}

	/**
	 * Removes the my address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my address book contact
	 * @return the my address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact remove(Serializable primaryKey)
		throws NoSuchMyAddressBookContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyAddressBookContact myAddressBookContact = (MyAddressBookContact)session.get(MyAddressBookContactImpl.class,
					primaryKey);

			if (myAddressBookContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(myAddressBookContact);
		}
		catch (NoSuchMyAddressBookContactException nsee) {
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
	protected MyAddressBookContact removeImpl(
		MyAddressBookContact myAddressBookContact) throws SystemException {
		myAddressBookContact = toUnwrappedModel(myAddressBookContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myAddressBookContact)) {
				myAddressBookContact = (MyAddressBookContact)session.get(MyAddressBookContactImpl.class,
						myAddressBookContact.getPrimaryKeyObj());
			}

			if (myAddressBookContact != null) {
				session.delete(myAddressBookContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (myAddressBookContact != null) {
			clearCache(myAddressBookContact);
		}

		return myAddressBookContact;
	}

	@Override
	public MyAddressBookContact updateImpl(
		com.leancrm.portlet.library.model.MyAddressBookContact myAddressBookContact)
		throws SystemException {
		myAddressBookContact = toUnwrappedModel(myAddressBookContact);

		boolean isNew = myAddressBookContact.isNew();

		Session session = null;

		try {
			session = openSession();

			if (myAddressBookContact.isNew()) {
				session.save(myAddressBookContact);

				myAddressBookContact.setNew(false);
			}
			else {
				session.merge(myAddressBookContact);
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

		EntityCacheUtil.putResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			MyAddressBookContactImpl.class,
			myAddressBookContact.getPrimaryKey(), myAddressBookContact);

		return myAddressBookContact;
	}

	protected MyAddressBookContact toUnwrappedModel(
		MyAddressBookContact myAddressBookContact) {
		if (myAddressBookContact instanceof MyAddressBookContactImpl) {
			return myAddressBookContact;
		}

		MyAddressBookContactImpl myAddressBookContactImpl = new MyAddressBookContactImpl();

		myAddressBookContactImpl.setNew(myAddressBookContact.isNew());
		myAddressBookContactImpl.setPrimaryKey(myAddressBookContact.getPrimaryKey());

		myAddressBookContactImpl.setContactId(myAddressBookContact.getContactId());
		myAddressBookContactImpl.setMethodId(myAddressBookContact.getMethodId());
		myAddressBookContactImpl.setContactName(myAddressBookContact.getContactName());
		myAddressBookContactImpl.setEnterpriseId(myAddressBookContact.getEnterpriseId());
		myAddressBookContactImpl.setEnterpriseName(myAddressBookContact.getEnterpriseName());
		myAddressBookContactImpl.setContractId(myAddressBookContact.getContractId());
		myAddressBookContactImpl.setReportId(myAddressBookContact.getReportId());
		myAddressBookContactImpl.setStatus(myAddressBookContact.getStatus());
		myAddressBookContactImpl.setProgress(myAddressBookContact.getProgress());
		myAddressBookContactImpl.setDescription(myAddressBookContact.getDescription());

		return myAddressBookContactImpl;
	}

	/**
	 * Returns the my address book contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my address book contact
	 * @return the my address book contact
	 * @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyAddressBookContactException, SystemException {
		MyAddressBookContact myAddressBookContact = fetchByPrimaryKey(primaryKey);

		if (myAddressBookContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return myAddressBookContact;
	}

	/**
	 * Returns the my address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchMyAddressBookContactException} if it could not be found.
	 *
	 * @param myAddressBookContactPK the primary key of the my address book contact
	 * @return the my address book contact
	 * @throws com.leancrm.portlet.library.NoSuchMyAddressBookContactException if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact findByPrimaryKey(
		MyAddressBookContactPK myAddressBookContactPK)
		throws NoSuchMyAddressBookContactException, SystemException {
		return findByPrimaryKey((Serializable)myAddressBookContactPK);
	}

	/**
	 * Returns the my address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my address book contact
	 * @return the my address book contact, or <code>null</code> if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MyAddressBookContact myAddressBookContact = (MyAddressBookContact)EntityCacheUtil.getResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				MyAddressBookContactImpl.class, primaryKey);

		if (myAddressBookContact == _nullMyAddressBookContact) {
			return null;
		}

		if (myAddressBookContact == null) {
			Session session = null;

			try {
				session = openSession();

				myAddressBookContact = (MyAddressBookContact)session.get(MyAddressBookContactImpl.class,
						primaryKey);

				if (myAddressBookContact != null) {
					cacheResult(myAddressBookContact);
				}
				else {
					EntityCacheUtil.putResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						MyAddressBookContactImpl.class, primaryKey,
						_nullMyAddressBookContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MyAddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
					MyAddressBookContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return myAddressBookContact;
	}

	/**
	 * Returns the my address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myAddressBookContactPK the primary key of the my address book contact
	 * @return the my address book contact, or <code>null</code> if a my address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyAddressBookContact fetchByPrimaryKey(
		MyAddressBookContactPK myAddressBookContactPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)myAddressBookContactPK);
	}

	/**
	 * Returns all the my address book contacts.
	 *
	 * @return the my address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyAddressBookContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.MyAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my address book contacts
	 * @param end the upper bound of the range of my address book contacts (not inclusive)
	 * @return the range of my address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyAddressBookContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the my address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.MyAddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my address book contacts
	 * @param end the upper bound of the range of my address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyAddressBookContact> findAll(int start, int end,
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

		List<MyAddressBookContact> list = (List<MyAddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYADDRESSBOOKCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYADDRESSBOOKCONTACT;

				if (pagination) {
					sql = sql.concat(MyAddressBookContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MyAddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyAddressBookContact>(list);
				}
				else {
					list = (List<MyAddressBookContact>)QueryUtil.list(q,
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
	 * Removes all the my address book contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MyAddressBookContact myAddressBookContact : findAll()) {
			remove(myAddressBookContact);
		}
	}

	/**
	 * Returns the number of my address book contacts.
	 *
	 * @return the number of my address book contacts
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

				Query q = session.createQuery(_SQL_COUNT_MYADDRESSBOOKCONTACT);

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
	 * Initializes the my address book contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.MyAddressBookContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyAddressBookContact>> listenersList = new ArrayList<ModelListener<MyAddressBookContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyAddressBookContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyAddressBookContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MYADDRESSBOOKCONTACT = "SELECT myAddressBookContact FROM MyAddressBookContact myAddressBookContact";
	private static final String _SQL_COUNT_MYADDRESSBOOKCONTACT = "SELECT COUNT(myAddressBookContact) FROM MyAddressBookContact myAddressBookContact";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myAddressBookContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyAddressBookContact exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MyAddressBookContactPersistenceImpl.class);
	private static MyAddressBookContact _nullMyAddressBookContact = new MyAddressBookContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MyAddressBookContact> toCacheModel() {
				return _nullMyAddressBookContactCacheModel;
			}
		};

	private static CacheModel<MyAddressBookContact> _nullMyAddressBookContactCacheModel =
		new CacheModel<MyAddressBookContact>() {
			@Override
			public MyAddressBookContact toEntityModel() {
				return _nullMyAddressBookContact;
			}
		};
}