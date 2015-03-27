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

import com.leancrm.portlet.library.NoSuchAddressBookContactDataException;
import com.leancrm.portlet.library.model.AddressBookContactData;
import com.leancrm.portlet.library.model.impl.AddressBookContactDataImpl;
import com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the address book contact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactDataPersistence
 * @see AddressBookContactDataUtil
 * @generated
 */
public class AddressBookContactDataPersistenceImpl extends BasePersistenceImpl<AddressBookContactData>
	implements AddressBookContactDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressBookContactDataUtil} to access the address book contact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressBookContactDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESSBOOK =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAddressBook",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAddressBook",
			new String[] { Long.class.getName() },
			AddressBookContactDataModelImpl.ADDRESSBOOKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ADDRESSBOOK = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAddressBook",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book contact datas where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @return the matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBook(long addressBookId)
		throws SystemException {
		return findByAddressBook(addressBookId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contact datas where addressBookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @return the range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBook(long addressBookId,
		int start, int end) throws SystemException {
		return findByAddressBook(addressBookId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contact datas where addressBookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBook(long addressBookId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK;
			finderArgs = new Object[] { addressBookId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESSBOOK;
			finderArgs = new Object[] {
					addressBookId,
					
					start, end, orderByComparator
				};
		}

		List<AddressBookContactData> list = (List<AddressBookContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContactData addressBookContactData : list) {
				if ((addressBookId != addressBookContactData.getAddressBookId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				if (!pagination) {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContactData>(list);
				}
				else {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
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
	 * Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByAddressBook_First(long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByAddressBook_First(addressBookId,
				orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the first address book contact data in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByAddressBook_First(long addressBookId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookContactData> list = findByAddressBook(addressBookId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByAddressBook_Last(long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByAddressBook_Last(addressBookId,
				orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the last address book contact data in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByAddressBook_Last(long addressBookId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAddressBook(addressBookId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContactData> list = findByAddressBook(addressBookId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contact datas before and after the current address book contact data in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookContactDataPK the primary key of the current address book contact data
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData[] findByAddressBook_PrevAndNext(
		AddressBookContactDataPK addressBookContactDataPK, long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = findByPrimaryKey(addressBookContactDataPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContactData[] array = new AddressBookContactDataImpl[3];

			array[0] = getByAddressBook_PrevAndNext(session,
					addressBookContactData, addressBookId, orderByComparator,
					true);

			array[1] = addressBookContactData;

			array[2] = getByAddressBook_PrevAndNext(session,
					addressBookContactData, addressBookId, orderByComparator,
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

	protected AddressBookContactData getByAddressBook_PrevAndNext(
		Session session, AddressBookContactData addressBookContactData,
		long addressBookId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

		query.append(_FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2);

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
			query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(addressBookId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contact datas where addressBookId = &#63; from the database.
	 *
	 * @param addressBookId the address book ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAddressBook(long addressBookId)
		throws SystemException {
		for (AddressBookContactData addressBookContactData : findByAddressBook(
				addressBookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookContactData);
		}
	}

	/**
	 * Returns the number of address book contact datas where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @return the number of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAddressBook(long addressBookId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ADDRESSBOOK;

		Object[] finderArgs = new Object[] { addressBookId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

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

	private static final String _FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2 = "addressBookContactData.id.addressBookId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTDATA =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactData",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTDATA =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactData",
			new String[] { Long.class.getName() },
			AddressBookContactDataModelImpl.CONTACTDATAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTDATA = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactData",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book contact datas where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @return the matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByContactData(long contactDataId)
		throws SystemException {
		return findByContactData(contactDataId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contact datas where contactDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactDataId the contact data ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @return the range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByContactData(long contactDataId,
		int start, int end) throws SystemException {
		return findByContactData(contactDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contact datas where contactDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactDataId the contact data ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByContactData(long contactDataId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTDATA;
			finderArgs = new Object[] { contactDataId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTDATA;
			finderArgs = new Object[] {
					contactDataId,
					
					start, end, orderByComparator
				};
		}

		List<AddressBookContactData> list = (List<AddressBookContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContactData addressBookContactData : list) {
				if ((contactDataId != addressBookContactData.getContactDataId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_CONTACTDATA_CONTACTDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactDataId);

				if (!pagination) {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContactData>(list);
				}
				else {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
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
	 * Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByContactData_First(long contactDataId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByContactData_First(contactDataId,
				orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactDataId=");
		msg.append(contactDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the first address book contact data in the ordered set where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByContactData_First(long contactDataId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookContactData> list = findByContactData(contactDataId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByContactData_Last(long contactDataId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByContactData_Last(contactDataId,
				orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactDataId=");
		msg.append(contactDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the last address book contact data in the ordered set where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByContactData_Last(long contactDataId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContactData(contactDataId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContactData> list = findByContactData(contactDataId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contact datas before and after the current address book contact data in the ordered set where contactDataId = &#63;.
	 *
	 * @param addressBookContactDataPK the primary key of the current address book contact data
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData[] findByContactData_PrevAndNext(
		AddressBookContactDataPK addressBookContactDataPK, long contactDataId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = findByPrimaryKey(addressBookContactDataPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContactData[] array = new AddressBookContactDataImpl[3];

			array[0] = getByContactData_PrevAndNext(session,
					addressBookContactData, contactDataId, orderByComparator,
					true);

			array[1] = addressBookContactData;

			array[2] = getByContactData_PrevAndNext(session,
					addressBookContactData, contactDataId, orderByComparator,
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

	protected AddressBookContactData getByContactData_PrevAndNext(
		Session session, AddressBookContactData addressBookContactData,
		long contactDataId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

		query.append(_FINDER_COLUMN_CONTACTDATA_CONTACTDATAID_2);

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
			query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactDataId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contact datas where contactDataId = &#63; from the database.
	 *
	 * @param contactDataId the contact data ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactData(long contactDataId)
		throws SystemException {
		for (AddressBookContactData addressBookContactData : findByContactData(
				contactDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookContactData);
		}
	}

	/**
	 * Returns the number of address book contact datas where contactDataId = &#63;.
	 *
	 * @param contactDataId the contact data ID
	 * @return the number of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactData(long contactDataId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTDATA;

		Object[] finderArgs = new Object[] { contactDataId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_CONTACTDATA_CONTACTDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactDataId);

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

	private static final String _FINDER_COLUMN_CONTACTDATA_CONTACTDATAID_2 = "addressBookContactData.id.contactDataId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAddressBookContactData",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA =
		new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAddressBookContactData",
			new String[] { Long.class.getName(), Long.class.getName() },
			AddressBookContactDataModelImpl.ADDRESSBOOKID_COLUMN_BITMASK |
			AddressBookContactDataModelImpl.CONTACTDATAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ADDRESSBOOKCONTACTDATA = new FinderPath(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAddressBookContactData",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @return the matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId) throws SystemException {
		return findByAddressBookContactData(addressBookId, contactDataId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @return the range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end)
		throws SystemException {
		return findByAddressBookContactData(addressBookId, contactDataId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findByAddressBookContactData(
		long addressBookId, long contactDataId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA;
			finderArgs = new Object[] { addressBookId, contactDataId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA;
			finderArgs = new Object[] {
					addressBookId, contactDataId,
					
					start, end, orderByComparator
				};
		}

		List<AddressBookContactData> list = (List<AddressBookContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContactData addressBookContactData : list) {
				if ((addressBookId != addressBookContactData.getAddressBookId()) ||
						(contactDataId != addressBookContactData.getContactDataId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_ADDRESSBOOKID_2);

			query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_CONTACTDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				qPos.add(contactDataId);

				if (!pagination) {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContactData>(list);
				}
				else {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
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
	 * Returns the first address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByAddressBookContactData_First(addressBookId,
				contactDataId, orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(", contactDataId=");
		msg.append(contactDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the first address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByAddressBookContactData_First(
		long addressBookId, long contactDataId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookContactData> list = findByAddressBookContactData(addressBookId,
				contactDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByAddressBookContactData_Last(addressBookId,
				contactDataId, orderByComparator);

		if (addressBookContactData != null) {
			return addressBookContactData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(", contactDataId=");
		msg.append(contactDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactDataException(msg.toString());
	}

	/**
	 * Returns the last address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact data, or <code>null</code> if a matching address book contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByAddressBookContactData_Last(
		long addressBookId, long contactDataId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAddressBookContactData(addressBookId, contactDataId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContactData> list = findByAddressBookContactData(addressBookId,
				contactDataId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contact datas before and after the current address book contact data in the ordered set where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookContactDataPK the primary key of the current address book contact data
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData[] findByAddressBookContactData_PrevAndNext(
		AddressBookContactDataPK addressBookContactDataPK, long addressBookId,
		long contactDataId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = findByPrimaryKey(addressBookContactDataPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContactData[] array = new AddressBookContactDataImpl[3];

			array[0] = getByAddressBookContactData_PrevAndNext(session,
					addressBookContactData, addressBookId, contactDataId,
					orderByComparator, true);

			array[1] = addressBookContactData;

			array[2] = getByAddressBookContactData_PrevAndNext(session,
					addressBookContactData, addressBookId, contactDataId,
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

	protected AddressBookContactData getByAddressBookContactData_PrevAndNext(
		Session session, AddressBookContactData addressBookContactData,
		long addressBookId, long contactDataId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE);

		query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_ADDRESSBOOKID_2);

		query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_CONTACTDATAID_2);

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
			query.append(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(addressBookId);

		qPos.add(contactDataId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contact datas where addressBookId = &#63; and contactDataId = &#63; from the database.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAddressBookContactData(long addressBookId,
		long contactDataId) throws SystemException {
		for (AddressBookContactData addressBookContactData : findByAddressBookContactData(
				addressBookId, contactDataId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(addressBookContactData);
		}
	}

	/**
	 * Returns the number of address book contact datas where addressBookId = &#63; and contactDataId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactDataId the contact data ID
	 * @return the number of matching address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAddressBookContactData(long addressBookId,
		long contactDataId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ADDRESSBOOKCONTACTDATA;

		Object[] finderArgs = new Object[] { addressBookId, contactDataId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_ADDRESSBOOKID_2);

			query.append(_FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_CONTACTDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				qPos.add(contactDataId);

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

	private static final String _FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_ADDRESSBOOKID_2 =
		"addressBookContactData.id.addressBookId = ? AND ";
	private static final String _FINDER_COLUMN_ADDRESSBOOKCONTACTDATA_CONTACTDATAID_2 =
		"addressBookContactData.id.contactDataId = ?";

	public AddressBookContactDataPersistenceImpl() {
		setModelClass(AddressBookContactData.class);
	}

	/**
	 * Caches the address book contact data in the entity cache if it is enabled.
	 *
	 * @param addressBookContactData the address book contact data
	 */
	@Override
	public void cacheResult(AddressBookContactData addressBookContactData) {
		EntityCacheUtil.putResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			addressBookContactData.getPrimaryKey(), addressBookContactData);

		addressBookContactData.resetOriginalValues();
	}

	/**
	 * Caches the address book contact datas in the entity cache if it is enabled.
	 *
	 * @param addressBookContactDatas the address book contact datas
	 */
	@Override
	public void cacheResult(
		List<AddressBookContactData> addressBookContactDatas) {
		for (AddressBookContactData addressBookContactData : addressBookContactDatas) {
			if (EntityCacheUtil.getResult(
						AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookContactDataImpl.class,
						addressBookContactData.getPrimaryKey()) == null) {
				cacheResult(addressBookContactData);
			}
			else {
				addressBookContactData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address book contact datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressBookContactDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressBookContactDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address book contact data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressBookContactData addressBookContactData) {
		EntityCacheUtil.removeResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			addressBookContactData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AddressBookContactData> addressBookContactDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressBookContactData addressBookContactData : addressBookContactDatas) {
			EntityCacheUtil.removeResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookContactDataImpl.class,
				addressBookContactData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address book contact data with the primary key. Does not add the address book contact data to the database.
	 *
	 * @param addressBookContactDataPK the primary key for the new address book contact data
	 * @return the new address book contact data
	 */
	@Override
	public AddressBookContactData create(
		AddressBookContactDataPK addressBookContactDataPK) {
		AddressBookContactData addressBookContactData = new AddressBookContactDataImpl();

		addressBookContactData.setNew(true);
		addressBookContactData.setPrimaryKey(addressBookContactDataPK);

		return addressBookContactData;
	}

	/**
	 * Removes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressBookContactDataPK the primary key of the address book contact data
	 * @return the address book contact data that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData remove(
		AddressBookContactDataPK addressBookContactDataPK)
		throws NoSuchAddressBookContactDataException, SystemException {
		return remove((Serializable)addressBookContactDataPK);
	}

	/**
	 * Removes the address book contact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address book contact data
	 * @return the address book contact data that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData remove(Serializable primaryKey)
		throws NoSuchAddressBookContactDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressBookContactData addressBookContactData = (AddressBookContactData)session.get(AddressBookContactDataImpl.class,
					primaryKey);

			if (addressBookContactData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressBookContactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressBookContactData);
		}
		catch (NoSuchAddressBookContactDataException nsee) {
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
	protected AddressBookContactData removeImpl(
		AddressBookContactData addressBookContactData)
		throws SystemException {
		addressBookContactData = toUnwrappedModel(addressBookContactData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressBookContactData)) {
				addressBookContactData = (AddressBookContactData)session.get(AddressBookContactDataImpl.class,
						addressBookContactData.getPrimaryKeyObj());
			}

			if (addressBookContactData != null) {
				session.delete(addressBookContactData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressBookContactData != null) {
			clearCache(addressBookContactData);
		}

		return addressBookContactData;
	}

	@Override
	public AddressBookContactData updateImpl(
		com.leancrm.portlet.library.model.AddressBookContactData addressBookContactData)
		throws SystemException {
		addressBookContactData = toUnwrappedModel(addressBookContactData);

		boolean isNew = addressBookContactData.isNew();

		AddressBookContactDataModelImpl addressBookContactDataModelImpl = (AddressBookContactDataModelImpl)addressBookContactData;

		Session session = null;

		try {
			session = openSession();

			if (addressBookContactData.isNew()) {
				session.save(addressBookContactData);

				addressBookContactData.setNew(false);
			}
			else {
				session.merge(addressBookContactData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressBookContactDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((addressBookContactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactDataModelImpl.getOriginalAddressBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK,
					args);

				args = new Object[] {
						addressBookContactDataModelImpl.getAddressBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK,
					args);
			}

			if ((addressBookContactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTDATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactDataModelImpl.getOriginalContactDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTDATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTDATA,
					args);

				args = new Object[] {
						addressBookContactDataModelImpl.getContactDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTDATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTDATA,
					args);
			}

			if ((addressBookContactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactDataModelImpl.getOriginalAddressBookId(),
						addressBookContactDataModelImpl.getOriginalContactDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOKCONTACTDATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA,
					args);

				args = new Object[] {
						addressBookContactDataModelImpl.getAddressBookId(),
						addressBookContactDataModelImpl.getContactDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOKCONTACTDATA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOKCONTACTDATA,
					args);
			}
		}

		EntityCacheUtil.putResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactDataImpl.class,
			addressBookContactData.getPrimaryKey(), addressBookContactData);

		return addressBookContactData;
	}

	protected AddressBookContactData toUnwrappedModel(
		AddressBookContactData addressBookContactData) {
		if (addressBookContactData instanceof AddressBookContactDataImpl) {
			return addressBookContactData;
		}

		AddressBookContactDataImpl addressBookContactDataImpl = new AddressBookContactDataImpl();

		addressBookContactDataImpl.setNew(addressBookContactData.isNew());
		addressBookContactDataImpl.setPrimaryKey(addressBookContactData.getPrimaryKey());

		addressBookContactDataImpl.setAddressBookId(addressBookContactData.getAddressBookId());
		addressBookContactDataImpl.setContactDataId(addressBookContactData.getContactDataId());
		addressBookContactDataImpl.setActive(addressBookContactData.isActive());

		return addressBookContactDataImpl;
	}

	/**
	 * Returns the address book contact data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book contact data
	 * @return the address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressBookContactDataException, SystemException {
		AddressBookContactData addressBookContactData = fetchByPrimaryKey(primaryKey);

		if (addressBookContactData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressBookContactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressBookContactData;
	}

	/**
	 * Returns the address book contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookContactDataException} if it could not be found.
	 *
	 * @param addressBookContactDataPK the primary key of the address book contact data
	 * @return the address book contact data
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactDataException if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData findByPrimaryKey(
		AddressBookContactDataPK addressBookContactDataPK)
		throws NoSuchAddressBookContactDataException, SystemException {
		return findByPrimaryKey((Serializable)addressBookContactDataPK);
	}

	/**
	 * Returns the address book contact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book contact data
	 * @return the address book contact data, or <code>null</code> if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressBookContactData addressBookContactData = (AddressBookContactData)EntityCacheUtil.getResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookContactDataImpl.class, primaryKey);

		if (addressBookContactData == _nullAddressBookContactData) {
			return null;
		}

		if (addressBookContactData == null) {
			Session session = null;

			try {
				session = openSession();

				addressBookContactData = (AddressBookContactData)session.get(AddressBookContactDataImpl.class,
						primaryKey);

				if (addressBookContactData != null) {
					cacheResult(addressBookContactData);
				}
				else {
					EntityCacheUtil.putResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookContactDataImpl.class, primaryKey,
						_nullAddressBookContactData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressBookContactDataModelImpl.ENTITY_CACHE_ENABLED,
					AddressBookContactDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressBookContactData;
	}

	/**
	 * Returns the address book contact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressBookContactDataPK the primary key of the address book contact data
	 * @return the address book contact data, or <code>null</code> if a address book contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContactData fetchByPrimaryKey(
		AddressBookContactDataPK addressBookContactDataPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressBookContactDataPK);
	}

	/**
	 * Returns all the address book contact datas.
	 *
	 * @return the address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @return the range of address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book contact datas
	 * @param end the upper bound of the range of address book contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address book contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContactData> findAll(int start, int end,
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

		List<AddressBookContactData> list = (List<AddressBookContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSBOOKCONTACTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSBOOKCONTACTDATA;

				if (pagination) {
					sql = sql.concat(AddressBookContactDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContactData>(list);
				}
				else {
					list = (List<AddressBookContactData>)QueryUtil.list(q,
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
	 * Removes all the address book contact datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressBookContactData addressBookContactData : findAll()) {
			remove(addressBookContactData);
		}
	}

	/**
	 * Returns the number of address book contact datas.
	 *
	 * @return the number of address book contact datas
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSBOOKCONTACTDATA);

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
	 * Initializes the address book contact data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.AddressBookContactData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressBookContactData>> listenersList = new ArrayList<ModelListener<AddressBookContactData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressBookContactData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressBookContactDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSBOOKCONTACTDATA = "SELECT addressBookContactData FROM AddressBookContactData addressBookContactData";
	private static final String _SQL_SELECT_ADDRESSBOOKCONTACTDATA_WHERE = "SELECT addressBookContactData FROM AddressBookContactData addressBookContactData WHERE ";
	private static final String _SQL_COUNT_ADDRESSBOOKCONTACTDATA = "SELECT COUNT(addressBookContactData) FROM AddressBookContactData addressBookContactData";
	private static final String _SQL_COUNT_ADDRESSBOOKCONTACTDATA_WHERE = "SELECT COUNT(addressBookContactData) FROM AddressBookContactData addressBookContactData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressBookContactData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressBookContactData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddressBookContactData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressBookContactDataPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static AddressBookContactData _nullAddressBookContactData = new AddressBookContactDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressBookContactData> toCacheModel() {
				return _nullAddressBookContactDataCacheModel;
			}
		};

	private static CacheModel<AddressBookContactData> _nullAddressBookContactDataCacheModel =
		new CacheModel<AddressBookContactData>() {
			@Override
			public AddressBookContactData toEntityModel() {
				return _nullAddressBookContactData;
			}
		};
}