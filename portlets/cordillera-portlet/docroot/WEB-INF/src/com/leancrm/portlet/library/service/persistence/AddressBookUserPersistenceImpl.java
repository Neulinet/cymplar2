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

import com.leancrm.portlet.library.NoSuchAddressBookUserException;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.impl.AddressBookUserImpl;
import com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl;

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
 * The persistence implementation for the address book user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookUserPersistence
 * @see AddressBookUserUtil
 * @generated
 */
public class AddressBookUserPersistenceImpl extends BasePersistenceImpl<AddressBookUser>
	implements AddressBookUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressBookUserUtil} to access the address book user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressBookUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED,
			AddressBookUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED,
			AddressBookUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED,
			AddressBookUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED,
			AddressBookUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			AddressBookUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of address book users
	 * @param end the upper bound of the range of address book users (not inclusive)
	 * @return the range of matching address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of address book users
	 * @param end the upper bound of the range of address book users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findByUser(long userId, int start, int end,
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

		List<AddressBookUser> list = (List<AddressBookUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookUser addressBookUser : list) {
				if ((userId != addressBookUser.getUserId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKUSER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AddressBookUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookUser>(list);
				}
				else {
					list = (List<AddressBookUser>)QueryUtil.list(q,
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
	 * Returns the first address book user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book user
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a matching address book user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookUserException, SystemException {
		AddressBookUser addressBookUser = fetchByUser_First(userId,
				orderByComparator);

		if (addressBookUser != null) {
			return addressBookUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookUserException(msg.toString());
	}

	/**
	 * Returns the first address book user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book user, or <code>null</code> if a matching address book user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookUser> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book user
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a matching address book user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookUserException, SystemException {
		AddressBookUser addressBookUser = fetchByUser_Last(userId,
				orderByComparator);

		if (addressBookUser != null) {
			return addressBookUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookUserException(msg.toString());
	}

	/**
	 * Returns the last address book user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book user, or <code>null</code> if a matching address book user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<AddressBookUser> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book users before and after the current address book user in the ordered set where userId = &#63;.
	 *
	 * @param addressBookId the primary key of the current address book user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book user
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser[] findByUser_PrevAndNext(long addressBookId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookUserException, SystemException {
		AddressBookUser addressBookUser = findByPrimaryKey(addressBookId);

		Session session = null;

		try {
			session = openSession();

			AddressBookUser[] array = new AddressBookUserImpl[3];

			array[0] = getByUser_PrevAndNext(session, addressBookUser, userId,
					orderByComparator, true);

			array[1] = addressBookUser;

			array[2] = getByUser_PrevAndNext(session, addressBookUser, userId,
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

	protected AddressBookUser getByUser_PrevAndNext(Session session,
		AddressBookUser addressBookUser, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKUSER_WHERE);

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
			query.append(AddressBookUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (AddressBookUser addressBookUser : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookUser);
		}
	}

	/**
	 * Returns the number of address book users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching address book users
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

			query.append(_SQL_COUNT_ADDRESSBOOKUSER_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "addressBookUser.userId = ?";

	public AddressBookUserPersistenceImpl() {
		setModelClass(AddressBookUser.class);
	}

	/**
	 * Caches the address book user in the entity cache if it is enabled.
	 *
	 * @param addressBookUser the address book user
	 */
	@Override
	public void cacheResult(AddressBookUser addressBookUser) {
		EntityCacheUtil.putResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserImpl.class, addressBookUser.getPrimaryKey(),
			addressBookUser);

		addressBookUser.resetOriginalValues();
	}

	/**
	 * Caches the address book users in the entity cache if it is enabled.
	 *
	 * @param addressBookUsers the address book users
	 */
	@Override
	public void cacheResult(List<AddressBookUser> addressBookUsers) {
		for (AddressBookUser addressBookUser : addressBookUsers) {
			if (EntityCacheUtil.getResult(
						AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookUserImpl.class,
						addressBookUser.getPrimaryKey()) == null) {
				cacheResult(addressBookUser);
			}
			else {
				addressBookUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address book users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressBookUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressBookUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address book user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressBookUser addressBookUser) {
		EntityCacheUtil.removeResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserImpl.class, addressBookUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AddressBookUser> addressBookUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressBookUser addressBookUser : addressBookUsers) {
			EntityCacheUtil.removeResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookUserImpl.class, addressBookUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address book user with the primary key. Does not add the address book user to the database.
	 *
	 * @param addressBookId the primary key for the new address book user
	 * @return the new address book user
	 */
	@Override
	public AddressBookUser create(long addressBookId) {
		AddressBookUser addressBookUser = new AddressBookUserImpl();

		addressBookUser.setNew(true);
		addressBookUser.setPrimaryKey(addressBookId);

		return addressBookUser;
	}

	/**
	 * Removes the address book user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressBookId the primary key of the address book user
	 * @return the address book user that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser remove(long addressBookId)
		throws NoSuchAddressBookUserException, SystemException {
		return remove((Serializable)addressBookId);
	}

	/**
	 * Removes the address book user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address book user
	 * @return the address book user that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser remove(Serializable primaryKey)
		throws NoSuchAddressBookUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressBookUser addressBookUser = (AddressBookUser)session.get(AddressBookUserImpl.class,
					primaryKey);

			if (addressBookUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressBookUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressBookUser);
		}
		catch (NoSuchAddressBookUserException nsee) {
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
	protected AddressBookUser removeImpl(AddressBookUser addressBookUser)
		throws SystemException {
		addressBookUser = toUnwrappedModel(addressBookUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressBookUser)) {
				addressBookUser = (AddressBookUser)session.get(AddressBookUserImpl.class,
						addressBookUser.getPrimaryKeyObj());
			}

			if (addressBookUser != null) {
				session.delete(addressBookUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressBookUser != null) {
			clearCache(addressBookUser);
		}

		return addressBookUser;
	}

	@Override
	public AddressBookUser updateImpl(
		com.leancrm.portlet.library.model.AddressBookUser addressBookUser)
		throws SystemException {
		addressBookUser = toUnwrappedModel(addressBookUser);

		boolean isNew = addressBookUser.isNew();

		AddressBookUserModelImpl addressBookUserModelImpl = (AddressBookUserModelImpl)addressBookUser;

		Session session = null;

		try {
			session = openSession();

			if (addressBookUser.isNew()) {
				session.save(addressBookUser);

				addressBookUser.setNew(false);
			}
			else {
				session.merge(addressBookUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressBookUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((addressBookUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookUserModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { addressBookUserModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookUserImpl.class, addressBookUser.getPrimaryKey(),
			addressBookUser);

		return addressBookUser;
	}

	protected AddressBookUser toUnwrappedModel(AddressBookUser addressBookUser) {
		if (addressBookUser instanceof AddressBookUserImpl) {
			return addressBookUser;
		}

		AddressBookUserImpl addressBookUserImpl = new AddressBookUserImpl();

		addressBookUserImpl.setNew(addressBookUser.isNew());
		addressBookUserImpl.setPrimaryKey(addressBookUser.getPrimaryKey());

		addressBookUserImpl.setAddressBookId(addressBookUser.getAddressBookId());
		addressBookUserImpl.setUserId(addressBookUser.getUserId());

		return addressBookUserImpl;
	}

	/**
	 * Returns the address book user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book user
	 * @return the address book user
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressBookUserException, SystemException {
		AddressBookUser addressBookUser = fetchByPrimaryKey(primaryKey);

		if (addressBookUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressBookUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressBookUser;
	}

	/**
	 * Returns the address book user with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookUserException} if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book user
	 * @return the address book user
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookUserException if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser findByPrimaryKey(long addressBookId)
		throws NoSuchAddressBookUserException, SystemException {
		return findByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns the address book user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book user
	 * @return the address book user, or <code>null</code> if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressBookUser addressBookUser = (AddressBookUser)EntityCacheUtil.getResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookUserImpl.class, primaryKey);

		if (addressBookUser == _nullAddressBookUser) {
			return null;
		}

		if (addressBookUser == null) {
			Session session = null;

			try {
				session = openSession();

				addressBookUser = (AddressBookUser)session.get(AddressBookUserImpl.class,
						primaryKey);

				if (addressBookUser != null) {
					cacheResult(addressBookUser);
				}
				else {
					EntityCacheUtil.putResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookUserImpl.class, primaryKey,
						_nullAddressBookUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressBookUserModelImpl.ENTITY_CACHE_ENABLED,
					AddressBookUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressBookUser;
	}

	/**
	 * Returns the address book user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book user
	 * @return the address book user, or <code>null</code> if a address book user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookUser fetchByPrimaryKey(long addressBookId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns all the address book users.
	 *
	 * @return the address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book users
	 * @param end the upper bound of the range of address book users (not inclusive)
	 * @return the range of address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book users
	 * @param end the upper bound of the range of address book users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address book users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookUser> findAll(int start, int end,
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

		List<AddressBookUser> list = (List<AddressBookUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSBOOKUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSBOOKUSER;

				if (pagination) {
					sql = sql.concat(AddressBookUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressBookUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookUser>(list);
				}
				else {
					list = (List<AddressBookUser>)QueryUtil.list(q,
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
	 * Removes all the address book users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressBookUser addressBookUser : findAll()) {
			remove(addressBookUser);
		}
	}

	/**
	 * Returns the number of address book users.
	 *
	 * @return the number of address book users
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSBOOKUSER);

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
	 * Initializes the address book user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.AddressBookUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressBookUser>> listenersList = new ArrayList<ModelListener<AddressBookUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressBookUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressBookUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSBOOKUSER = "SELECT addressBookUser FROM AddressBookUser addressBookUser";
	private static final String _SQL_SELECT_ADDRESSBOOKUSER_WHERE = "SELECT addressBookUser FROM AddressBookUser addressBookUser WHERE ";
	private static final String _SQL_COUNT_ADDRESSBOOKUSER = "SELECT COUNT(addressBookUser) FROM AddressBookUser addressBookUser";
	private static final String _SQL_COUNT_ADDRESSBOOKUSER_WHERE = "SELECT COUNT(addressBookUser) FROM AddressBookUser addressBookUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressBookUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressBookUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddressBookUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressBookUserPersistenceImpl.class);
	private static AddressBookUser _nullAddressBookUser = new AddressBookUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressBookUser> toCacheModel() {
				return _nullAddressBookUserCacheModel;
			}
		};

	private static CacheModel<AddressBookUser> _nullAddressBookUserCacheModel = new CacheModel<AddressBookUser>() {
			@Override
			public AddressBookUser toEntityModel() {
				return _nullAddressBookUser;
			}
		};
}