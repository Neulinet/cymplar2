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

import com.leancrm.portlet.library.NoSuchAddressBookOrganizationException;
import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.model.impl.AddressBookOrganizationImpl;
import com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl;

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
 * The persistence implementation for the address book organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookOrganizationPersistence
 * @see AddressBookOrganizationUtil
 * @generated
 */
public class AddressBookOrganizationPersistenceImpl extends BasePersistenceImpl<AddressBookOrganization>
	implements AddressBookOrganizationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressBookOrganizationUtil} to access the address book organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressBookOrganizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganization",
			new String[] { Long.class.getName() },
			AddressBookOrganizationModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findByOrganization(long organizationId)
		throws SystemException {
		return findByOrganization(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of address book organizations
	 * @param end the upper bound of the range of address book organizations (not inclusive)
	 * @return the range of matching address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end) throws SystemException {
		return findByOrganization(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of address book organizations
	 * @param end the upper bound of the range of address book organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findByOrganization(
		long organizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<AddressBookOrganization> list = (List<AddressBookOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookOrganization addressBookOrganization : list) {
				if ((organizationId != addressBookOrganization.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<AddressBookOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookOrganization>(list);
				}
				else {
					list = (List<AddressBookOrganization>)QueryUtil.list(q,
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
	 * Returns the first address book organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book organization
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization findByOrganization_First(
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookOrganizationException, SystemException {
		AddressBookOrganization addressBookOrganization = fetchByOrganization_First(organizationId,
				orderByComparator);

		if (addressBookOrganization != null) {
			return addressBookOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookOrganizationException(msg.toString());
	}

	/**
	 * Returns the first address book organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book organization, or <code>null</code> if a matching address book organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization fetchByOrganization_First(
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AddressBookOrganization> list = findByOrganization(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book organization
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a matching address book organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization findByOrganization_Last(
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookOrganizationException, SystemException {
		AddressBookOrganization addressBookOrganization = fetchByOrganization_Last(organizationId,
				orderByComparator);

		if (addressBookOrganization != null) {
			return addressBookOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookOrganizationException(msg.toString());
	}

	/**
	 * Returns the last address book organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book organization, or <code>null</code> if a matching address book organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization fetchByOrganization_Last(
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganization(organizationId);

		if (count == 0) {
			return null;
		}

		List<AddressBookOrganization> list = findByOrganization(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book organizations before and after the current address book organization in the ordered set where organizationId = &#63;.
	 *
	 * @param addressBookId the primary key of the current address book organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book organization
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization[] findByOrganization_PrevAndNext(
		long addressBookId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookOrganizationException, SystemException {
		AddressBookOrganization addressBookOrganization = findByPrimaryKey(addressBookId);

		Session session = null;

		try {
			session = openSession();

			AddressBookOrganization[] array = new AddressBookOrganizationImpl[3];

			array[0] = getByOrganization_PrevAndNext(session,
					addressBookOrganization, organizationId, orderByComparator,
					true);

			array[1] = addressBookOrganization;

			array[2] = getByOrganization_PrevAndNext(session,
					addressBookOrganization, organizationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddressBookOrganization getByOrganization_PrevAndNext(
		Session session, AddressBookOrganization addressBookOrganization,
		long organizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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
			query.append(AddressBookOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganization(long organizationId)
		throws SystemException {
		for (AddressBookOrganization addressBookOrganization : findByOrganization(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookOrganization);
		}
	}

	/**
	 * Returns the number of address book organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganization(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATION;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESSBOOKORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 = "addressBookOrganization.organizationId = ?";

	public AddressBookOrganizationPersistenceImpl() {
		setModelClass(AddressBookOrganization.class);
	}

	/**
	 * Caches the address book organization in the entity cache if it is enabled.
	 *
	 * @param addressBookOrganization the address book organization
	 */
	@Override
	public void cacheResult(AddressBookOrganization addressBookOrganization) {
		EntityCacheUtil.putResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			addressBookOrganization.getPrimaryKey(), addressBookOrganization);

		addressBookOrganization.resetOriginalValues();
	}

	/**
	 * Caches the address book organizations in the entity cache if it is enabled.
	 *
	 * @param addressBookOrganizations the address book organizations
	 */
	@Override
	public void cacheResult(
		List<AddressBookOrganization> addressBookOrganizations) {
		for (AddressBookOrganization addressBookOrganization : addressBookOrganizations) {
			if (EntityCacheUtil.getResult(
						AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookOrganizationImpl.class,
						addressBookOrganization.getPrimaryKey()) == null) {
				cacheResult(addressBookOrganization);
			}
			else {
				addressBookOrganization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address book organizations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressBookOrganizationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressBookOrganizationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address book organization.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressBookOrganization addressBookOrganization) {
		EntityCacheUtil.removeResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			addressBookOrganization.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<AddressBookOrganization> addressBookOrganizations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressBookOrganization addressBookOrganization : addressBookOrganizations) {
			EntityCacheUtil.removeResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookOrganizationImpl.class,
				addressBookOrganization.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address book organization with the primary key. Does not add the address book organization to the database.
	 *
	 * @param addressBookId the primary key for the new address book organization
	 * @return the new address book organization
	 */
	@Override
	public AddressBookOrganization create(long addressBookId) {
		AddressBookOrganization addressBookOrganization = new AddressBookOrganizationImpl();

		addressBookOrganization.setNew(true);
		addressBookOrganization.setPrimaryKey(addressBookId);

		return addressBookOrganization;
	}

	/**
	 * Removes the address book organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressBookId the primary key of the address book organization
	 * @return the address book organization that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization remove(long addressBookId)
		throws NoSuchAddressBookOrganizationException, SystemException {
		return remove((Serializable)addressBookId);
	}

	/**
	 * Removes the address book organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address book organization
	 * @return the address book organization that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization remove(Serializable primaryKey)
		throws NoSuchAddressBookOrganizationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressBookOrganization addressBookOrganization = (AddressBookOrganization)session.get(AddressBookOrganizationImpl.class,
					primaryKey);

			if (addressBookOrganization == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressBookOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressBookOrganization);
		}
		catch (NoSuchAddressBookOrganizationException nsee) {
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
	protected AddressBookOrganization removeImpl(
		AddressBookOrganization addressBookOrganization)
		throws SystemException {
		addressBookOrganization = toUnwrappedModel(addressBookOrganization);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressBookOrganization)) {
				addressBookOrganization = (AddressBookOrganization)session.get(AddressBookOrganizationImpl.class,
						addressBookOrganization.getPrimaryKeyObj());
			}

			if (addressBookOrganization != null) {
				session.delete(addressBookOrganization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressBookOrganization != null) {
			clearCache(addressBookOrganization);
		}

		return addressBookOrganization;
	}

	@Override
	public AddressBookOrganization updateImpl(
		com.leancrm.portlet.library.model.AddressBookOrganization addressBookOrganization)
		throws SystemException {
		addressBookOrganization = toUnwrappedModel(addressBookOrganization);

		boolean isNew = addressBookOrganization.isNew();

		AddressBookOrganizationModelImpl addressBookOrganizationModelImpl = (AddressBookOrganizationModelImpl)addressBookOrganization;

		Session session = null;

		try {
			session = openSession();

			if (addressBookOrganization.isNew()) {
				session.save(addressBookOrganization);

				addressBookOrganization.setNew(false);
			}
			else {
				session.merge(addressBookOrganization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressBookOrganizationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((addressBookOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookOrganizationModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);

				args = new Object[] {
						addressBookOrganizationModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);
			}
		}

		EntityCacheUtil.putResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookOrganizationImpl.class,
			addressBookOrganization.getPrimaryKey(), addressBookOrganization);

		return addressBookOrganization;
	}

	protected AddressBookOrganization toUnwrappedModel(
		AddressBookOrganization addressBookOrganization) {
		if (addressBookOrganization instanceof AddressBookOrganizationImpl) {
			return addressBookOrganization;
		}

		AddressBookOrganizationImpl addressBookOrganizationImpl = new AddressBookOrganizationImpl();

		addressBookOrganizationImpl.setNew(addressBookOrganization.isNew());
		addressBookOrganizationImpl.setPrimaryKey(addressBookOrganization.getPrimaryKey());

		addressBookOrganizationImpl.setAddressBookId(addressBookOrganization.getAddressBookId());
		addressBookOrganizationImpl.setOrganizationId(addressBookOrganization.getOrganizationId());

		return addressBookOrganizationImpl;
	}

	/**
	 * Returns the address book organization with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book organization
	 * @return the address book organization
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressBookOrganizationException, SystemException {
		AddressBookOrganization addressBookOrganization = fetchByPrimaryKey(primaryKey);

		if (addressBookOrganization == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressBookOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressBookOrganization;
	}

	/**
	 * Returns the address book organization with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookOrganizationException} if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book organization
	 * @return the address book organization
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookOrganizationException if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization findByPrimaryKey(long addressBookId)
		throws NoSuchAddressBookOrganizationException, SystemException {
		return findByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns the address book organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book organization
	 * @return the address book organization, or <code>null</code> if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressBookOrganization addressBookOrganization = (AddressBookOrganization)EntityCacheUtil.getResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookOrganizationImpl.class, primaryKey);

		if (addressBookOrganization == _nullAddressBookOrganization) {
			return null;
		}

		if (addressBookOrganization == null) {
			Session session = null;

			try {
				session = openSession();

				addressBookOrganization = (AddressBookOrganization)session.get(AddressBookOrganizationImpl.class,
						primaryKey);

				if (addressBookOrganization != null) {
					cacheResult(addressBookOrganization);
				}
				else {
					EntityCacheUtil.putResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookOrganizationImpl.class, primaryKey,
						_nullAddressBookOrganization);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressBookOrganizationModelImpl.ENTITY_CACHE_ENABLED,
					AddressBookOrganizationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressBookOrganization;
	}

	/**
	 * Returns the address book organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressBookId the primary key of the address book organization
	 * @return the address book organization, or <code>null</code> if a address book organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookOrganization fetchByPrimaryKey(long addressBookId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressBookId);
	}

	/**
	 * Returns all the address book organizations.
	 *
	 * @return the address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book organizations
	 * @param end the upper bound of the range of address book organizations (not inclusive)
	 * @return the range of address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book organizations
	 * @param end the upper bound of the range of address book organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address book organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookOrganization> findAll(int start, int end,
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

		List<AddressBookOrganization> list = (List<AddressBookOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSBOOKORGANIZATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSBOOKORGANIZATION;

				if (pagination) {
					sql = sql.concat(AddressBookOrganizationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressBookOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookOrganization>(list);
				}
				else {
					list = (List<AddressBookOrganization>)QueryUtil.list(q,
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
	 * Removes all the address book organizations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressBookOrganization addressBookOrganization : findAll()) {
			remove(addressBookOrganization);
		}
	}

	/**
	 * Returns the number of address book organizations.
	 *
	 * @return the number of address book organizations
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSBOOKORGANIZATION);

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
	 * Initializes the address book organization persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.AddressBookOrganization")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressBookOrganization>> listenersList = new ArrayList<ModelListener<AddressBookOrganization>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressBookOrganization>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressBookOrganizationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSBOOKORGANIZATION = "SELECT addressBookOrganization FROM AddressBookOrganization addressBookOrganization";
	private static final String _SQL_SELECT_ADDRESSBOOKORGANIZATION_WHERE = "SELECT addressBookOrganization FROM AddressBookOrganization addressBookOrganization WHERE ";
	private static final String _SQL_COUNT_ADDRESSBOOKORGANIZATION = "SELECT COUNT(addressBookOrganization) FROM AddressBookOrganization addressBookOrganization";
	private static final String _SQL_COUNT_ADDRESSBOOKORGANIZATION_WHERE = "SELECT COUNT(addressBookOrganization) FROM AddressBookOrganization addressBookOrganization WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressBookOrganization.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressBookOrganization exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddressBookOrganization exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressBookOrganizationPersistenceImpl.class);
	private static AddressBookOrganization _nullAddressBookOrganization = new AddressBookOrganizationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressBookOrganization> toCacheModel() {
				return _nullAddressBookOrganizationCacheModel;
			}
		};

	private static CacheModel<AddressBookOrganization> _nullAddressBookOrganizationCacheModel =
		new CacheModel<AddressBookOrganization>() {
			@Override
			public AddressBookOrganization toEntityModel() {
				return _nullAddressBookOrganization;
			}
		};
}