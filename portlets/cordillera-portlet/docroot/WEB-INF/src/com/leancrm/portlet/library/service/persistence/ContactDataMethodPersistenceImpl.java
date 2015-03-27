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

import com.leancrm.portlet.library.NoSuchContactDataMethodException;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.impl.ContactDataMethodImpl;
import com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl;

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
 * The persistence implementation for the contact data method service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataMethodPersistence
 * @see ContactDataMethodUtil
 * @generated
 */
public class ContactDataMethodPersistenceImpl extends BasePersistenceImpl<ContactDataMethod>
	implements ContactDataMethodPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDataMethodUtil} to access the contact data method persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDataMethodImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED,
			ContactDataMethodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED,
			ContactDataMethodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED,
			ContactDataMethodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED,
			ContactDataMethodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ContactDataMethodModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the contact data methods where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findByName(String name)
		throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact data methods where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of contact data methods
	 * @param end the upper bound of the range of contact data methods (not inclusive)
	 * @return the range of matching contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact data methods where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of contact data methods
	 * @param end the upper bound of the range of contact data methods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findByName(String name, int start, int end,
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

		List<ContactDataMethod> list = (List<ContactDataMethod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactDataMethod contactDataMethod : list) {
				if (!Validator.equals(name, contactDataMethod.getName())) {
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

			query.append(_SQL_SELECT_CONTACTDATAMETHOD_WHERE);

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
				query.append(ContactDataMethodModelImpl.ORDER_BY_JPQL);
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
					list = (List<ContactDataMethod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDataMethod>(list);
				}
				else {
					list = (List<ContactDataMethod>)QueryUtil.list(q,
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
	 * Returns the first contact data method in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data method
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a matching contact data method could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataMethodException, SystemException {
		ContactDataMethod contactDataMethod = fetchByName_First(name,
				orderByComparator);

		if (contactDataMethod != null) {
			return contactDataMethod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataMethodException(msg.toString());
	}

	/**
	 * Returns the first contact data method in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data method, or <code>null</code> if a matching contact data method could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactDataMethod> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact data method in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data method
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a matching contact data method could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataMethodException, SystemException {
		ContactDataMethod contactDataMethod = fetchByName_Last(name,
				orderByComparator);

		if (contactDataMethod != null) {
			return contactDataMethod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataMethodException(msg.toString());
	}

	/**
	 * Returns the last contact data method in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data method, or <code>null</code> if a matching contact data method could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ContactDataMethod> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact data methods before and after the current contact data method in the ordered set where name = &#63;.
	 *
	 * @param contactDataMethodId the primary key of the current contact data method
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact data method
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod[] findByName_PrevAndNext(
		long contactDataMethodId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataMethodException, SystemException {
		ContactDataMethod contactDataMethod = findByPrimaryKey(contactDataMethodId);

		Session session = null;

		try {
			session = openSession();

			ContactDataMethod[] array = new ContactDataMethodImpl[3];

			array[0] = getByName_PrevAndNext(session, contactDataMethod, name,
					orderByComparator, true);

			array[1] = contactDataMethod;

			array[2] = getByName_PrevAndNext(session, contactDataMethod, name,
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

	protected ContactDataMethod getByName_PrevAndNext(Session session,
		ContactDataMethod contactDataMethod, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTDATAMETHOD_WHERE);

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
			query.append(ContactDataMethodModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contactDataMethod);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactDataMethod> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact data methods where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ContactDataMethod contactDataMethod : findByName(name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactDataMethod);
		}
	}

	/**
	 * Returns the number of contact data methods where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching contact data methods
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

			query.append(_SQL_COUNT_CONTACTDATAMETHOD_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "contactDataMethod.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "contactDataMethod.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(contactDataMethod.name IS NULL OR contactDataMethod.name = '')";

	public ContactDataMethodPersistenceImpl() {
		setModelClass(ContactDataMethod.class);
	}

	/**
	 * Caches the contact data method in the entity cache if it is enabled.
	 *
	 * @param contactDataMethod the contact data method
	 */
	@Override
	public void cacheResult(ContactDataMethod contactDataMethod) {
		EntityCacheUtil.putResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodImpl.class, contactDataMethod.getPrimaryKey(),
			contactDataMethod);

		contactDataMethod.resetOriginalValues();
	}

	/**
	 * Caches the contact data methods in the entity cache if it is enabled.
	 *
	 * @param contactDataMethods the contact data methods
	 */
	@Override
	public void cacheResult(List<ContactDataMethod> contactDataMethods) {
		for (ContactDataMethod contactDataMethod : contactDataMethods) {
			if (EntityCacheUtil.getResult(
						ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataMethodImpl.class,
						contactDataMethod.getPrimaryKey()) == null) {
				cacheResult(contactDataMethod);
			}
			else {
				contactDataMethod.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact data methods.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDataMethodImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDataMethodImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact data method.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDataMethod contactDataMethod) {
		EntityCacheUtil.removeResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodImpl.class, contactDataMethod.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactDataMethod> contactDataMethods) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactDataMethod contactDataMethod : contactDataMethods) {
			EntityCacheUtil.removeResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataMethodImpl.class, contactDataMethod.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact data method with the primary key. Does not add the contact data method to the database.
	 *
	 * @param contactDataMethodId the primary key for the new contact data method
	 * @return the new contact data method
	 */
	@Override
	public ContactDataMethod create(long contactDataMethodId) {
		ContactDataMethod contactDataMethod = new ContactDataMethodImpl();

		contactDataMethod.setNew(true);
		contactDataMethod.setPrimaryKey(contactDataMethodId);

		return contactDataMethod;
	}

	/**
	 * Removes the contact data method with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDataMethodId the primary key of the contact data method
	 * @return the contact data method that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod remove(long contactDataMethodId)
		throws NoSuchContactDataMethodException, SystemException {
		return remove((Serializable)contactDataMethodId);
	}

	/**
	 * Removes the contact data method with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact data method
	 * @return the contact data method that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod remove(Serializable primaryKey)
		throws NoSuchContactDataMethodException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactDataMethod contactDataMethod = (ContactDataMethod)session.get(ContactDataMethodImpl.class,
					primaryKey);

			if (contactDataMethod == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDataMethodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactDataMethod);
		}
		catch (NoSuchContactDataMethodException nsee) {
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
	protected ContactDataMethod removeImpl(ContactDataMethod contactDataMethod)
		throws SystemException {
		contactDataMethod = toUnwrappedModel(contactDataMethod);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDataMethod)) {
				contactDataMethod = (ContactDataMethod)session.get(ContactDataMethodImpl.class,
						contactDataMethod.getPrimaryKeyObj());
			}

			if (contactDataMethod != null) {
				session.delete(contactDataMethod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactDataMethod != null) {
			clearCache(contactDataMethod);
		}

		return contactDataMethod;
	}

	@Override
	public ContactDataMethod updateImpl(
		com.leancrm.portlet.library.model.ContactDataMethod contactDataMethod)
		throws SystemException {
		contactDataMethod = toUnwrappedModel(contactDataMethod);

		boolean isNew = contactDataMethod.isNew();

		ContactDataMethodModelImpl contactDataMethodModelImpl = (ContactDataMethodModelImpl)contactDataMethod;

		Session session = null;

		try {
			session = openSession();

			if (contactDataMethod.isNew()) {
				session.save(contactDataMethod);

				contactDataMethod.setNew(false);
			}
			else {
				session.merge(contactDataMethod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactDataMethodModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactDataMethodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactDataMethodModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { contactDataMethodModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataMethodImpl.class, contactDataMethod.getPrimaryKey(),
			contactDataMethod);

		return contactDataMethod;
	}

	protected ContactDataMethod toUnwrappedModel(
		ContactDataMethod contactDataMethod) {
		if (contactDataMethod instanceof ContactDataMethodImpl) {
			return contactDataMethod;
		}

		ContactDataMethodImpl contactDataMethodImpl = new ContactDataMethodImpl();

		contactDataMethodImpl.setNew(contactDataMethod.isNew());
		contactDataMethodImpl.setPrimaryKey(contactDataMethod.getPrimaryKey());

		contactDataMethodImpl.setContactDataMethodId(contactDataMethod.getContactDataMethodId());
		contactDataMethodImpl.setGroupId(contactDataMethod.getGroupId());
		contactDataMethodImpl.setCompanyId(contactDataMethod.getCompanyId());
		contactDataMethodImpl.setName(contactDataMethod.getName());
		contactDataMethodImpl.setTitle(contactDataMethod.getTitle());
		contactDataMethodImpl.setContactDataType(contactDataMethod.getContactDataType());

		return contactDataMethodImpl;
	}

	/**
	 * Returns the contact data method with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data method
	 * @return the contact data method
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDataMethodException, SystemException {
		ContactDataMethod contactDataMethod = fetchByPrimaryKey(primaryKey);

		if (contactDataMethod == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDataMethodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactDataMethod;
	}

	/**
	 * Returns the contact data method with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataMethodException} if it could not be found.
	 *
	 * @param contactDataMethodId the primary key of the contact data method
	 * @return the contact data method
	 * @throws com.leancrm.portlet.library.NoSuchContactDataMethodException if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod findByPrimaryKey(long contactDataMethodId)
		throws NoSuchContactDataMethodException, SystemException {
		return findByPrimaryKey((Serializable)contactDataMethodId);
	}

	/**
	 * Returns the contact data method with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data method
	 * @return the contact data method, or <code>null</code> if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactDataMethod contactDataMethod = (ContactDataMethod)EntityCacheUtil.getResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataMethodImpl.class, primaryKey);

		if (contactDataMethod == _nullContactDataMethod) {
			return null;
		}

		if (contactDataMethod == null) {
			Session session = null;

			try {
				session = openSession();

				contactDataMethod = (ContactDataMethod)session.get(ContactDataMethodImpl.class,
						primaryKey);

				if (contactDataMethod != null) {
					cacheResult(contactDataMethod);
				}
				else {
					EntityCacheUtil.putResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataMethodImpl.class, primaryKey,
						_nullContactDataMethod);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDataMethodModelImpl.ENTITY_CACHE_ENABLED,
					ContactDataMethodImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactDataMethod;
	}

	/**
	 * Returns the contact data method with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDataMethodId the primary key of the contact data method
	 * @return the contact data method, or <code>null</code> if a contact data method with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDataMethod fetchByPrimaryKey(long contactDataMethodId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDataMethodId);
	}

	/**
	 * Returns all the contact data methods.
	 *
	 * @return the contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact data methods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data methods
	 * @param end the upper bound of the range of contact data methods (not inclusive)
	 * @return the range of contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact data methods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact data methods
	 * @param end the upper bound of the range of contact data methods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact data methods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDataMethod> findAll(int start, int end,
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

		List<ContactDataMethod> list = (List<ContactDataMethod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDATAMETHOD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDATAMETHOD;

				if (pagination) {
					sql = sql.concat(ContactDataMethodModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactDataMethod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDataMethod>(list);
				}
				else {
					list = (List<ContactDataMethod>)QueryUtil.list(q,
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
	 * Removes all the contact data methods from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactDataMethod contactDataMethod : findAll()) {
			remove(contactDataMethod);
		}
	}

	/**
	 * Returns the number of contact data methods.
	 *
	 * @return the number of contact data methods
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDATAMETHOD);

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
	 * Initializes the contact data method persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactDataMethod")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactDataMethod>> listenersList = new ArrayList<ModelListener<ContactDataMethod>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactDataMethod>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDataMethodImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDATAMETHOD = "SELECT contactDataMethod FROM ContactDataMethod contactDataMethod";
	private static final String _SQL_SELECT_CONTACTDATAMETHOD_WHERE = "SELECT contactDataMethod FROM ContactDataMethod contactDataMethod WHERE ";
	private static final String _SQL_COUNT_CONTACTDATAMETHOD = "SELECT COUNT(contactDataMethod) FROM ContactDataMethod contactDataMethod";
	private static final String _SQL_COUNT_CONTACTDATAMETHOD_WHERE = "SELECT COUNT(contactDataMethod) FROM ContactDataMethod contactDataMethod WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDataMethod.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactDataMethod exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactDataMethod exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDataMethodPersistenceImpl.class);
	private static ContactDataMethod _nullContactDataMethod = new ContactDataMethodImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactDataMethod> toCacheModel() {
				return _nullContactDataMethodCacheModel;
			}
		};

	private static CacheModel<ContactDataMethod> _nullContactDataMethodCacheModel =
		new CacheModel<ContactDataMethod>() {
			@Override
			public ContactDataMethod toEntityModel() {
				return _nullContactDataMethod;
			}
		};
}