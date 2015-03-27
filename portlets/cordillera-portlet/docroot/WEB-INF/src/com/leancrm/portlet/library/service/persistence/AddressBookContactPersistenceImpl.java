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

import com.leancrm.portlet.library.NoSuchAddressBookContactException;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl;

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
 * The persistence implementation for the address book contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressBookContactPersistence
 * @see AddressBookContactUtil
 * @generated
 */
public class AddressBookContactPersistenceImpl extends BasePersistenceImpl<AddressBookContact>
	implements AddressBookContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressBookContactUtil} to access the address book contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressBookContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTADDRESSBOOK =
		new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactAddressBook",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTADDRESSBOOK =
		new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactAddressBook",
			new String[] { Long.class.getName(), Long.class.getName() },
			AddressBookContactModelImpl.ADDRESSBOOKID_COLUMN_BITMASK |
			AddressBookContactModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTADDRESSBOOK = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactAddressBook",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @return the matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId) throws SystemException {
		return findByContactAddressBook(addressBookId, contactId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @return the range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId, int start, int end)
		throws SystemException {
		return findByContactAddressBook(addressBookId, contactId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the address book contacts where addressBookId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContactAddressBook(
		long addressBookId, long contactId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTADDRESSBOOK;
			finderArgs = new Object[] { addressBookId, contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTADDRESSBOOK;
			finderArgs = new Object[] {
					addressBookId, contactId,
					
					start, end, orderByComparator
				};
		}

		List<AddressBookContact> list = (List<AddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContact addressBookContact : list) {
				if ((addressBookId != addressBookContact.getAddressBookId()) ||
						(contactId != addressBookContact.getContactId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_ADDRESSBOOKID_2);

			query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<AddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContact>(list);
				}
				else {
					list = (List<AddressBookContact>)QueryUtil.list(q,
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
	 * Returns the first address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByContactAddressBook_First(
		long addressBookId, long contactId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByContactAddressBook_First(addressBookId,
				contactId, orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the first address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByContactAddressBook_First(
		long addressBookId, long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AddressBookContact> list = findByContactAddressBook(addressBookId,
				contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByContactAddressBook_Last(
		long addressBookId, long contactId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByContactAddressBook_Last(addressBookId,
				contactId, orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(", contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the last address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByContactAddressBook_Last(
		long addressBookId, long contactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactAddressBook(addressBookId, contactId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContact> list = findByContactAddressBook(addressBookId,
				contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contacts before and after the current address book contact in the ordered set where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookContactPK the primary key of the current address book contact
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact[] findByContactAddressBook_PrevAndNext(
		AddressBookContactPK addressBookContactPK, long addressBookId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = findByPrimaryKey(addressBookContactPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContact[] array = new AddressBookContactImpl[3];

			array[0] = getByContactAddressBook_PrevAndNext(session,
					addressBookContact, addressBookId, contactId,
					orderByComparator, true);

			array[1] = addressBookContact;

			array[2] = getByContactAddressBook_PrevAndNext(session,
					addressBookContact, addressBookId, contactId,
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

	protected AddressBookContact getByContactAddressBook_PrevAndNext(
		Session session, AddressBookContact addressBookContact,
		long addressBookId, long contactId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

		query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_ADDRESSBOOKID_2);

		query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_CONTACTID_2);

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
			query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(addressBookId);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contacts where addressBookId = &#63; and contactId = &#63; from the database.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactAddressBook(long addressBookId, long contactId)
		throws SystemException {
		for (AddressBookContact addressBookContact : findByContactAddressBook(
				addressBookId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(addressBookContact);
		}
	}

	/**
	 * Returns the number of address book contacts where addressBookId = &#63; and contactId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param contactId the contact ID
	 * @return the number of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactAddressBook(long addressBookId, long contactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTADDRESSBOOK;

		Object[] finderArgs = new Object[] { addressBookId, contactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_ADDRESSBOOKID_2);

			query.append(_FINDER_COLUMN_CONTACTADDRESSBOOK_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				qPos.add(contactId);

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

	private static final String _FINDER_COLUMN_CONTACTADDRESSBOOK_ADDRESSBOOKID_2 =
		"addressBookContact.id.addressBookId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTADDRESSBOOK_CONTACTID_2 = "addressBookContact.id.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESSBOOK =
		new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAddressBook",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK =
		new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAddressBook",
			new String[] { Long.class.getName() },
			AddressBookContactModelImpl.ADDRESSBOOKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ADDRESSBOOK = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAddressBook",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book contacts where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @return the matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByAddressBook(long addressBookId)
		throws SystemException {
		return findByAddressBook(addressBookId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contacts where addressBookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @return the range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByAddressBook(long addressBookId,
		int start, int end) throws SystemException {
		return findByAddressBook(addressBookId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contacts where addressBookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param addressBookId the address book ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByAddressBook(long addressBookId,
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

		List<AddressBookContact> list = (List<AddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContact addressBookContact : list) {
				if ((addressBookId != addressBookContact.getAddressBookId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

			query.append(_FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(addressBookId);

				if (!pagination) {
					list = (List<AddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContact>(list);
				}
				else {
					list = (List<AddressBookContact>)QueryUtil.list(q,
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
	 * Returns the first address book contact in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByAddressBook_First(long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByAddressBook_First(addressBookId,
				orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the first address book contact in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByAddressBook_First(long addressBookId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookContact> list = findByAddressBook(addressBookId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByAddressBook_Last(long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByAddressBook_Last(addressBookId,
				orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("addressBookId=");
		msg.append(addressBookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the last address book contact in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByAddressBook_Last(long addressBookId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAddressBook(addressBookId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContact> list = findByAddressBook(addressBookId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contacts before and after the current address book contact in the ordered set where addressBookId = &#63;.
	 *
	 * @param addressBookContactPK the primary key of the current address book contact
	 * @param addressBookId the address book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact[] findByAddressBook_PrevAndNext(
		AddressBookContactPK addressBookContactPK, long addressBookId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = findByPrimaryKey(addressBookContactPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContact[] array = new AddressBookContactImpl[3];

			array[0] = getByAddressBook_PrevAndNext(session,
					addressBookContact, addressBookId, orderByComparator, true);

			array[1] = addressBookContact;

			array[2] = getByAddressBook_PrevAndNext(session,
					addressBookContact, addressBookId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddressBookContact getByAddressBook_PrevAndNext(Session session,
		AddressBookContact addressBookContact, long addressBookId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

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
			query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(addressBookId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contacts where addressBookId = &#63; from the database.
	 *
	 * @param addressBookId the address book ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAddressBook(long addressBookId)
		throws SystemException {
		for (AddressBookContact addressBookContact : findByAddressBook(
				addressBookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookContact);
		}
	}

	/**
	 * Returns the number of address book contacts where addressBookId = &#63;.
	 *
	 * @param addressBookId the address book ID
	 * @return the number of matching address book contacts
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

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACT_WHERE);

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

	private static final String _FINDER_COLUMN_ADDRESSBOOK_ADDRESSBOOKID_2 = "addressBookContact.id.addressBookId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContact",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED,
			AddressBookContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] { Long.class.getName() },
			AddressBookContactModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address book contacts where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContact(long contactId)
		throws SystemException {
		return findByContact(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the address book contacts where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @return the range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContact(long contactId, int start,
		int end) throws SystemException {
		return findByContact(contactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contacts where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findByContact(long contactId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId, start, end, orderByComparator };
		}

		List<AddressBookContact> list = (List<AddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressBookContact addressBookContact : list) {
				if ((contactId != addressBookContact.getContactId())) {
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

			query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<AddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContact>(list);
				}
				else {
					list = (List<AddressBookContact>)QueryUtil.list(q,
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
	 * Returns the first address book contact in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByContact_First(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByContact_First(contactId,
				orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the first address book contact in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByContact_First(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressBookContact> list = findByContact(contactId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address book contact in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByContact_Last(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByContact_Last(contactId,
				orderByComparator);

		if (addressBookContact != null) {
			return addressBookContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressBookContactException(msg.toString());
	}

	/**
	 * Returns the last address book contact in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address book contact, or <code>null</code> if a matching address book contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByContact_Last(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContact(contactId);

		if (count == 0) {
			return null;
		}

		List<AddressBookContact> list = findByContact(contactId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address book contacts before and after the current address book contact in the ordered set where contactId = &#63;.
	 *
	 * @param addressBookContactPK the primary key of the current address book contact
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact[] findByContact_PrevAndNext(
		AddressBookContactPK addressBookContactPK, long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = findByPrimaryKey(addressBookContactPK);

		Session session = null;

		try {
			session = openSession();

			AddressBookContact[] array = new AddressBookContactImpl[3];

			array[0] = getByContact_PrevAndNext(session, addressBookContact,
					contactId, orderByComparator, true);

			array[1] = addressBookContact;

			array[2] = getByContact_PrevAndNext(session, addressBookContact,
					contactId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddressBookContact getByContact_PrevAndNext(Session session,
		AddressBookContact addressBookContact, long contactId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSBOOKCONTACT_WHERE);

		query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

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
			query.append(AddressBookContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressBookContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressBookContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address book contacts where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContact(long contactId) throws SystemException {
		for (AddressBookContact addressBookContact : findByContact(contactId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressBookContact);
		}
	}

	/**
	 * Returns the number of address book contacts where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContact(long contactId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACT;

		Object[] finderArgs = new Object[] { contactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESSBOOKCONTACT_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

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

	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "addressBookContact.id.contactId = ?";

	public AddressBookContactPersistenceImpl() {
		setModelClass(AddressBookContact.class);
	}

	/**
	 * Caches the address book contact in the entity cache if it is enabled.
	 *
	 * @param addressBookContact the address book contact
	 */
	@Override
	public void cacheResult(AddressBookContact addressBookContact) {
		EntityCacheUtil.putResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactImpl.class, addressBookContact.getPrimaryKey(),
			addressBookContact);

		addressBookContact.resetOriginalValues();
	}

	/**
	 * Caches the address book contacts in the entity cache if it is enabled.
	 *
	 * @param addressBookContacts the address book contacts
	 */
	@Override
	public void cacheResult(List<AddressBookContact> addressBookContacts) {
		for (AddressBookContact addressBookContact : addressBookContacts) {
			if (EntityCacheUtil.getResult(
						AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookContactImpl.class,
						addressBookContact.getPrimaryKey()) == null) {
				cacheResult(addressBookContact);
			}
			else {
				addressBookContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address book contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressBookContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressBookContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address book contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressBookContact addressBookContact) {
		EntityCacheUtil.removeResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactImpl.class, addressBookContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AddressBookContact> addressBookContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressBookContact addressBookContact : addressBookContacts) {
			EntityCacheUtil.removeResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookContactImpl.class, addressBookContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address book contact with the primary key. Does not add the address book contact to the database.
	 *
	 * @param addressBookContactPK the primary key for the new address book contact
	 * @return the new address book contact
	 */
	@Override
	public AddressBookContact create(AddressBookContactPK addressBookContactPK) {
		AddressBookContact addressBookContact = new AddressBookContactImpl();

		addressBookContact.setNew(true);
		addressBookContact.setPrimaryKey(addressBookContactPK);

		return addressBookContact;
	}

	/**
	 * Removes the address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressBookContactPK the primary key of the address book contact
	 * @return the address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact remove(AddressBookContactPK addressBookContactPK)
		throws NoSuchAddressBookContactException, SystemException {
		return remove((Serializable)addressBookContactPK);
	}

	/**
	 * Removes the address book contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address book contact
	 * @return the address book contact that was removed
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact remove(Serializable primaryKey)
		throws NoSuchAddressBookContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressBookContact addressBookContact = (AddressBookContact)session.get(AddressBookContactImpl.class,
					primaryKey);

			if (addressBookContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressBookContact);
		}
		catch (NoSuchAddressBookContactException nsee) {
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
	protected AddressBookContact removeImpl(
		AddressBookContact addressBookContact) throws SystemException {
		addressBookContact = toUnwrappedModel(addressBookContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressBookContact)) {
				addressBookContact = (AddressBookContact)session.get(AddressBookContactImpl.class,
						addressBookContact.getPrimaryKeyObj());
			}

			if (addressBookContact != null) {
				session.delete(addressBookContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressBookContact != null) {
			clearCache(addressBookContact);
		}

		return addressBookContact;
	}

	@Override
	public AddressBookContact updateImpl(
		com.leancrm.portlet.library.model.AddressBookContact addressBookContact)
		throws SystemException {
		addressBookContact = toUnwrappedModel(addressBookContact);

		boolean isNew = addressBookContact.isNew();

		AddressBookContactModelImpl addressBookContactModelImpl = (AddressBookContactModelImpl)addressBookContact;

		Session session = null;

		try {
			session = openSession();

			if (addressBookContact.isNew()) {
				session.save(addressBookContact);

				addressBookContact.setNew(false);
			}
			else {
				session.merge(addressBookContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressBookContactModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((addressBookContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTADDRESSBOOK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactModelImpl.getOriginalAddressBookId(),
						addressBookContactModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTADDRESSBOOK,
					args);

				args = new Object[] {
						addressBookContactModelImpl.getAddressBookId(),
						addressBookContactModelImpl.getContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTADDRESSBOOK,
					args);
			}

			if ((addressBookContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactModelImpl.getOriginalAddressBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK,
					args);

				args = new Object[] {
						addressBookContactModelImpl.getAddressBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESSBOOK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESSBOOK,
					args);
			}

			if ((addressBookContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressBookContactModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] { addressBookContactModelImpl.getContactId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}
		}

		EntityCacheUtil.putResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
			AddressBookContactImpl.class, addressBookContact.getPrimaryKey(),
			addressBookContact);

		return addressBookContact;
	}

	protected AddressBookContact toUnwrappedModel(
		AddressBookContact addressBookContact) {
		if (addressBookContact instanceof AddressBookContactImpl) {
			return addressBookContact;
		}

		AddressBookContactImpl addressBookContactImpl = new AddressBookContactImpl();

		addressBookContactImpl.setNew(addressBookContact.isNew());
		addressBookContactImpl.setPrimaryKey(addressBookContact.getPrimaryKey());

		addressBookContactImpl.setAddressBookId(addressBookContact.getAddressBookId());
		addressBookContactImpl.setContactId(addressBookContact.getContactId());
		addressBookContactImpl.setGroupId(addressBookContact.getGroupId());
		addressBookContactImpl.setCompanyId(addressBookContact.getCompanyId());
		addressBookContactImpl.setAssignedTo(addressBookContact.getAssignedTo());
		addressBookContactImpl.setCurrentProgress(addressBookContact.getCurrentProgress());

		return addressBookContactImpl;
	}

	/**
	 * Returns the address book contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book contact
	 * @return the address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressBookContactException, SystemException {
		AddressBookContact addressBookContact = fetchByPrimaryKey(primaryKey);

		if (addressBookContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressBookContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressBookContact;
	}

	/**
	 * Returns the address book contact with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchAddressBookContactException} if it could not be found.
	 *
	 * @param addressBookContactPK the primary key of the address book contact
	 * @return the address book contact
	 * @throws com.leancrm.portlet.library.NoSuchAddressBookContactException if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact findByPrimaryKey(
		AddressBookContactPK addressBookContactPK)
		throws NoSuchAddressBookContactException, SystemException {
		return findByPrimaryKey((Serializable)addressBookContactPK);
	}

	/**
	 * Returns the address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address book contact
	 * @return the address book contact, or <code>null</code> if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressBookContact addressBookContact = (AddressBookContact)EntityCacheUtil.getResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
				AddressBookContactImpl.class, primaryKey);

		if (addressBookContact == _nullAddressBookContact) {
			return null;
		}

		if (addressBookContact == null) {
			Session session = null;

			try {
				session = openSession();

				addressBookContact = (AddressBookContact)session.get(AddressBookContactImpl.class,
						primaryKey);

				if (addressBookContact != null) {
					cacheResult(addressBookContact);
				}
				else {
					EntityCacheUtil.putResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
						AddressBookContactImpl.class, primaryKey,
						_nullAddressBookContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressBookContactModelImpl.ENTITY_CACHE_ENABLED,
					AddressBookContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressBookContact;
	}

	/**
	 * Returns the address book contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressBookContactPK the primary key of the address book contact
	 * @return the address book contact, or <code>null</code> if a address book contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressBookContact fetchByPrimaryKey(
		AddressBookContactPK addressBookContactPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)addressBookContactPK);
	}

	/**
	 * Returns all the address book contacts.
	 *
	 * @return the address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @return the range of address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address book contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.AddressBookContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address book contacts
	 * @param end the upper bound of the range of address book contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address book contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressBookContact> findAll(int start, int end,
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

		List<AddressBookContact> list = (List<AddressBookContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSBOOKCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSBOOKCONTACT;

				if (pagination) {
					sql = sql.concat(AddressBookContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressBookContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressBookContact>(list);
				}
				else {
					list = (List<AddressBookContact>)QueryUtil.list(q,
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
	 * Removes all the address book contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressBookContact addressBookContact : findAll()) {
			remove(addressBookContact);
		}
	}

	/**
	 * Returns the number of address book contacts.
	 *
	 * @return the number of address book contacts
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSBOOKCONTACT);

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
	 * Initializes the address book contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.AddressBookContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressBookContact>> listenersList = new ArrayList<ModelListener<AddressBookContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressBookContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressBookContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSBOOKCONTACT = "SELECT addressBookContact FROM AddressBookContact addressBookContact";
	private static final String _SQL_SELECT_ADDRESSBOOKCONTACT_WHERE = "SELECT addressBookContact FROM AddressBookContact addressBookContact WHERE ";
	private static final String _SQL_COUNT_ADDRESSBOOKCONTACT = "SELECT COUNT(addressBookContact) FROM AddressBookContact addressBookContact";
	private static final String _SQL_COUNT_ADDRESSBOOKCONTACT_WHERE = "SELECT COUNT(addressBookContact) FROM AddressBookContact addressBookContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressBookContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressBookContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddressBookContact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressBookContactPersistenceImpl.class);
	private static AddressBookContact _nullAddressBookContact = new AddressBookContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressBookContact> toCacheModel() {
				return _nullAddressBookContactCacheModel;
			}
		};

	private static CacheModel<AddressBookContact> _nullAddressBookContactCacheModel =
		new CacheModel<AddressBookContact>() {
			@Override
			public AddressBookContact toEntityModel() {
				return _nullAddressBookContact;
			}
		};
}