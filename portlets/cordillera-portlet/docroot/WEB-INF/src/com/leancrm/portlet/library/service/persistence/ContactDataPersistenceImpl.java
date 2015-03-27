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

import com.leancrm.portlet.library.NoSuchContactDataException;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.impl.ContactDataImpl;
import com.leancrm.portlet.library.model.impl.ContactDataModelImpl;

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
 * The persistence implementation for the contact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataPersistence
 * @see ContactDataUtil
 * @generated
 */
public class ContactDataPersistenceImpl extends BasePersistenceImpl<ContactData>
	implements ContactDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDataUtil} to access the contact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContact",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] { Long.class.getName() },
			ContactDataModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact datas where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContact(long contactId)
		throws SystemException {
		return findByContact(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contact datas where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @return the range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContact(long contactId, int start, int end)
		throws SystemException {
		return findByContact(contactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact datas where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContact(long contactId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ContactData> list = (List<ContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactData contactData : list) {
				if ((contactId != contactData.getContactId())) {
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

			query.append(_SQL_SELECT_CONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				if (!pagination) {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactData>(list);
				}
				else {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contact data in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByContact_First(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByContact_First(contactId,
				orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the first contact data in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByContact_First(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactData> list = findByContact(contactId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact data in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByContact_Last(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByContact_Last(contactId,
				orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the last contact data in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByContact_Last(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContact(contactId);

		if (count == 0) {
			return null;
		}

		List<ContactData> list = findByContact(contactId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact datas before and after the current contact data in the ordered set where contactId = &#63;.
	 *
	 * @param contactDataId the primary key of the current contact data
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData[] findByContact_PrevAndNext(long contactDataId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = findByPrimaryKey(contactDataId);

		Session session = null;

		try {
			session = openSession();

			ContactData[] array = new ContactDataImpl[3];

			array[0] = getByContact_PrevAndNext(session, contactData,
					contactId, orderByComparator, true);

			array[1] = contactData;

			array[2] = getByContact_PrevAndNext(session, contactData,
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

	protected ContactData getByContact_PrevAndNext(Session session,
		ContactData contactData, long contactId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTDATA_WHERE);

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
			query.append(ContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact datas where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContact(long contactId) throws SystemException {
		for (ContactData contactData : findByContact(contactId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactData);
		}
	}

	/**
	 * Returns the number of contact datas where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact datas
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

			query.append(_SQL_COUNT_CONTACTDATA_WHERE);

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

	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "contactData.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDMETHOD =
		new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactAndMethod",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDMETHOD =
		new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactAndMethod",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactDataModelImpl.CONTACTID_COLUMN_BITMASK |
			ContactDataModelImpl.CONTACTDATAMETHODID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTANDMETHOD = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactAndMethod",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @return the matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContactAndMethod(long contactId,
		long contactDataMethodId) throws SystemException {
		return findByContactAndMethod(contactId, contactDataMethodId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @return the range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContactAndMethod(long contactId,
		long contactDataMethodId, int start, int end) throws SystemException {
		return findByContactAndMethod(contactId, contactDataMethodId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByContactAndMethod(long contactId,
		long contactDataMethodId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDMETHOD;
			finderArgs = new Object[] { contactId, contactDataMethodId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDMETHOD;
			finderArgs = new Object[] {
					contactId, contactDataMethodId,
					
					start, end, orderByComparator
				};
		}

		List<ContactData> list = (List<ContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactData contactData : list) {
				if ((contactId != contactData.getContactId()) ||
						(contactDataMethodId != contactData.getContactDataMethodId())) {
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

			query.append(_SQL_SELECT_CONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTDATAMETHODID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(contactDataMethodId);

				if (!pagination) {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactData>(list);
				}
				else {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByContactAndMethod_First(long contactId,
		long contactDataMethodId, OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByContactAndMethod_First(contactId,
				contactDataMethodId, orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", contactDataMethodId=");
		msg.append(contactDataMethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the first contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByContactAndMethod_First(long contactId,
		long contactDataMethodId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactData> list = findByContactAndMethod(contactId,
				contactDataMethodId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByContactAndMethod_Last(long contactId,
		long contactDataMethodId, OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByContactAndMethod_Last(contactId,
				contactDataMethodId, orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", contactDataMethodId=");
		msg.append(contactDataMethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the last contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByContactAndMethod_Last(long contactId,
		long contactDataMethodId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactAndMethod(contactId, contactDataMethodId);

		if (count == 0) {
			return null;
		}

		List<ContactData> list = findByContactAndMethod(contactId,
				contactDataMethodId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact datas before and after the current contact data in the ordered set where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactDataId the primary key of the current contact data
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData[] findByContactAndMethod_PrevAndNext(
		long contactDataId, long contactId, long contactDataMethodId,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = findByPrimaryKey(contactDataId);

		Session session = null;

		try {
			session = openSession();

			ContactData[] array = new ContactDataImpl[3];

			array[0] = getByContactAndMethod_PrevAndNext(session, contactData,
					contactId, contactDataMethodId, orderByComparator, true);

			array[1] = contactData;

			array[2] = getByContactAndMethod_PrevAndNext(session, contactData,
					contactId, contactDataMethodId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactData getByContactAndMethod_PrevAndNext(Session session,
		ContactData contactData, long contactId, long contactDataMethodId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTDATA_WHERE);

		query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTID_2);

		query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTDATAMETHODID_2);

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
			query.append(ContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		qPos.add(contactDataMethodId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact datas where contactId = &#63; and contactDataMethodId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContactAndMethod(long contactId,
		long contactDataMethodId) throws SystemException {
		for (ContactData contactData : findByContactAndMethod(contactId,
				contactDataMethodId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactData);
		}
	}

	/**
	 * Returns the number of contact datas where contactId = &#63; and contactDataMethodId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactDataMethodId the contact data method ID
	 * @return the number of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactAndMethod(long contactId, long contactDataMethodId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTANDMETHOD;

		Object[] finderArgs = new Object[] { contactId, contactDataMethodId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTANDMETHOD_CONTACTDATAMETHODID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(contactDataMethodId);

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

	private static final String _FINDER_COLUMN_CONTACTANDMETHOD_CONTACTID_2 = "contactData.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTANDMETHOD_CONTACTDATAMETHODID_2 =
		"contactData.contactDataMethodId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_METHOD = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMethod",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METHOD =
		new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, ContactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMethod",
			new String[] { Long.class.getName() },
			ContactDataModelImpl.CONTACTDATAMETHODID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_METHOD = new FinderPath(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMethod",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact datas where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @return the matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByMethod(long contactDataMethodId)
		throws SystemException {
		return findByMethod(contactDataMethodId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact datas where contactDataMethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @return the range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByMethod(long contactDataMethodId, int start,
		int end) throws SystemException {
		return findByMethod(contactDataMethodId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact datas where contactDataMethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findByMethod(long contactDataMethodId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METHOD;
			finderArgs = new Object[] { contactDataMethodId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_METHOD;
			finderArgs = new Object[] {
					contactDataMethodId,
					
					start, end, orderByComparator
				};
		}

		List<ContactData> list = (List<ContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactData contactData : list) {
				if ((contactDataMethodId != contactData.getContactDataMethodId())) {
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

			query.append(_SQL_SELECT_CONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_METHOD_CONTACTDATAMETHODID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactDataMethodId);

				if (!pagination) {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactData>(list);
				}
				else {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByMethod_First(long contactDataMethodId,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByMethod_First(contactDataMethodId,
				orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactDataMethodId=");
		msg.append(contactDataMethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the first contact data in the ordered set where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByMethod_First(long contactDataMethodId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactData> list = findByMethod(contactDataMethodId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByMethod_Last(long contactDataMethodId,
		OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByMethod_Last(contactDataMethodId,
				orderByComparator);

		if (contactData != null) {
			return contactData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactDataMethodId=");
		msg.append(contactDataMethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactDataException(msg.toString());
	}

	/**
	 * Returns the last contact data in the ordered set where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact data, or <code>null</code> if a matching contact data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByMethod_Last(long contactDataMethodId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMethod(contactDataMethodId);

		if (count == 0) {
			return null;
		}

		List<ContactData> list = findByMethod(contactDataMethodId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact datas before and after the current contact data in the ordered set where contactDataMethodId = &#63;.
	 *
	 * @param contactDataId the primary key of the current contact data
	 * @param contactDataMethodId the contact data method ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData[] findByMethod_PrevAndNext(long contactDataId,
		long contactDataMethodId, OrderByComparator orderByComparator)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = findByPrimaryKey(contactDataId);

		Session session = null;

		try {
			session = openSession();

			ContactData[] array = new ContactDataImpl[3];

			array[0] = getByMethod_PrevAndNext(session, contactData,
					contactDataMethodId, orderByComparator, true);

			array[1] = contactData;

			array[2] = getByMethod_PrevAndNext(session, contactData,
					contactDataMethodId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactData getByMethod_PrevAndNext(Session session,
		ContactData contactData, long contactDataMethodId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTDATA_WHERE);

		query.append(_FINDER_COLUMN_METHOD_CONTACTDATAMETHODID_2);

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
			query.append(ContactDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactDataMethodId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact datas where contactDataMethodId = &#63; from the database.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMethod(long contactDataMethodId)
		throws SystemException {
		for (ContactData contactData : findByMethod(contactDataMethodId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactData);
		}
	}

	/**
	 * Returns the number of contact datas where contactDataMethodId = &#63;.
	 *
	 * @param contactDataMethodId the contact data method ID
	 * @return the number of matching contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMethod(long contactDataMethodId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_METHOD;

		Object[] finderArgs = new Object[] { contactDataMethodId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTDATA_WHERE);

			query.append(_FINDER_COLUMN_METHOD_CONTACTDATAMETHODID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactDataMethodId);

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

	private static final String _FINDER_COLUMN_METHOD_CONTACTDATAMETHODID_2 = "contactData.contactDataMethodId = ?";

	public ContactDataPersistenceImpl() {
		setModelClass(ContactData.class);
	}

	/**
	 * Caches the contact data in the entity cache if it is enabled.
	 *
	 * @param contactData the contact data
	 */
	@Override
	public void cacheResult(ContactData contactData) {
		EntityCacheUtil.putResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataImpl.class, contactData.getPrimaryKey(), contactData);

		contactData.resetOriginalValues();
	}

	/**
	 * Caches the contact datas in the entity cache if it is enabled.
	 *
	 * @param contactDatas the contact datas
	 */
	@Override
	public void cacheResult(List<ContactData> contactDatas) {
		for (ContactData contactData : contactDatas) {
			if (EntityCacheUtil.getResult(
						ContactDataModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataImpl.class, contactData.getPrimaryKey()) == null) {
				cacheResult(contactData);
			}
			else {
				contactData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactData contactData) {
		EntityCacheUtil.removeResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataImpl.class, contactData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactData> contactDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactData contactData : contactDatas) {
			EntityCacheUtil.removeResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataImpl.class, contactData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contact data with the primary key. Does not add the contact data to the database.
	 *
	 * @param contactDataId the primary key for the new contact data
	 * @return the new contact data
	 */
	@Override
	public ContactData create(long contactDataId) {
		ContactData contactData = new ContactDataImpl();

		contactData.setNew(true);
		contactData.setPrimaryKey(contactDataId);

		return contactData;
	}

	/**
	 * Removes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDataId the primary key of the contact data
	 * @return the contact data that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData remove(long contactDataId)
		throws NoSuchContactDataException, SystemException {
		return remove((Serializable)contactDataId);
	}

	/**
	 * Removes the contact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact data
	 * @return the contact data that was removed
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData remove(Serializable primaryKey)
		throws NoSuchContactDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactData contactData = (ContactData)session.get(ContactDataImpl.class,
					primaryKey);

			if (contactData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactData);
		}
		catch (NoSuchContactDataException nsee) {
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
	protected ContactData removeImpl(ContactData contactData)
		throws SystemException {
		contactData = toUnwrappedModel(contactData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactData)) {
				contactData = (ContactData)session.get(ContactDataImpl.class,
						contactData.getPrimaryKeyObj());
			}

			if (contactData != null) {
				session.delete(contactData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactData != null) {
			clearCache(contactData);
		}

		return contactData;
	}

	@Override
	public ContactData updateImpl(
		com.leancrm.portlet.library.model.ContactData contactData)
		throws SystemException {
		contactData = toUnwrappedModel(contactData);

		boolean isNew = contactData.isNew();

		ContactDataModelImpl contactDataModelImpl = (ContactDataModelImpl)contactData;

		Session session = null;

		try {
			session = openSession();

			if (contactData.isNew()) {
				session.save(contactData);

				contactData.setNew(false);
			}
			else {
				session.merge(contactData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactDataModelImpl.getOriginalContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] { contactDataModelImpl.getContactId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}

			if ((contactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDMETHOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactDataModelImpl.getOriginalContactId(),
						contactDataModelImpl.getOriginalContactDataMethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDMETHOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDMETHOD,
					args);

				args = new Object[] {
						contactDataModelImpl.getContactId(),
						contactDataModelImpl.getContactDataMethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDMETHOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDMETHOD,
					args);
			}

			if ((contactDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METHOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactDataModelImpl.getOriginalContactDataMethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_METHOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METHOD,
					args);

				args = new Object[] {
						contactDataModelImpl.getContactDataMethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_METHOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METHOD,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
			ContactDataImpl.class, contactData.getPrimaryKey(), contactData);

		return contactData;
	}

	protected ContactData toUnwrappedModel(ContactData contactData) {
		if (contactData instanceof ContactDataImpl) {
			return contactData;
		}

		ContactDataImpl contactDataImpl = new ContactDataImpl();

		contactDataImpl.setNew(contactData.isNew());
		contactDataImpl.setPrimaryKey(contactData.getPrimaryKey());

		contactDataImpl.setContactDataId(contactData.getContactDataId());
		contactDataImpl.setGroupId(contactData.getGroupId());
		contactDataImpl.setContactDataType(contactData.getContactDataType());
		contactDataImpl.setReadOnly(contactData.isReadOnly());
		contactDataImpl.setCompanyId(contactData.getCompanyId());
		contactDataImpl.setCreateDate(contactData.getCreateDate());
		contactDataImpl.setModifiedDate(contactData.getModifiedDate());
		contactDataImpl.setContactDataMethodId(contactData.getContactDataMethodId());
		contactDataImpl.setContactId(contactData.getContactId());

		return contactDataImpl;
	}

	/**
	 * Returns the contact data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data
	 * @return the contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDataException, SystemException {
		ContactData contactData = fetchByPrimaryKey(primaryKey);

		if (contactData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactData;
	}

	/**
	 * Returns the contact data with the primary key or throws a {@link com.leancrm.portlet.library.NoSuchContactDataException} if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data
	 * @return the contact data
	 * @throws com.leancrm.portlet.library.NoSuchContactDataException if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData findByPrimaryKey(long contactDataId)
		throws NoSuchContactDataException, SystemException {
		return findByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns the contact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact data
	 * @return the contact data, or <code>null</code> if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactData contactData = (ContactData)EntityCacheUtil.getResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
				ContactDataImpl.class, primaryKey);

		if (contactData == _nullContactData) {
			return null;
		}

		if (contactData == null) {
			Session session = null;

			try {
				session = openSession();

				contactData = (ContactData)session.get(ContactDataImpl.class,
						primaryKey);

				if (contactData != null) {
					cacheResult(contactData);
				}
				else {
					EntityCacheUtil.putResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
						ContactDataImpl.class, primaryKey, _nullContactData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDataModelImpl.ENTITY_CACHE_ENABLED,
					ContactDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactData;
	}

	/**
	 * Returns the contact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDataId the primary key of the contact data
	 * @return the contact data, or <code>null</code> if a contact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactData fetchByPrimaryKey(long contactDataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDataId);
	}

	/**
	 * Returns all the contact datas.
	 *
	 * @return the contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @return the range of contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.ContactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact datas
	 * @param end the upper bound of the range of contact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactData> findAll(int start, int end,
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

		List<ContactData> list = (List<ContactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDATA;

				if (pagination) {
					sql = sql.concat(ContactDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactData>(list);
				}
				else {
					list = (List<ContactData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the contact datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactData contactData : findAll()) {
			remove(contactData);
		}
	}

	/**
	 * Returns the number of contact datas.
	 *
	 * @return the number of contact datas
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDATA);

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
	 * Initializes the contact data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.leancrm.portlet.library.model.ContactData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactData>> listenersList = new ArrayList<ModelListener<ContactData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDATA = "SELECT contactData FROM ContactData contactData";
	private static final String _SQL_SELECT_CONTACTDATA_WHERE = "SELECT contactData FROM ContactData contactData WHERE ";
	private static final String _SQL_COUNT_CONTACTDATA = "SELECT COUNT(contactData) FROM ContactData contactData";
	private static final String _SQL_COUNT_CONTACTDATA_WHERE = "SELECT COUNT(contactData) FROM ContactData contactData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDataPersistenceImpl.class);
	private static ContactData _nullContactData = new ContactDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactData> toCacheModel() {
				return _nullContactDataCacheModel;
			}
		};

	private static CacheModel<ContactData> _nullContactDataCacheModel = new CacheModel<ContactData>() {
			@Override
			public ContactData toEntityModel() {
				return _nullContactData;
			}
		};
}