package com.leancrm.portlet.library.service.persistence;

import java.math.BigInteger;
import java.util.List;

import com.leancrm.portlet.library.model.MyAddressBookContact;
import com.leancrm.portlet.library.model.impl.MyAddressBookContactImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class MyAddressBookContactFinderImpl extends BasePersistenceImpl<MyAddressBookContact> implements MyAddressBookContactFinder {

	public static final String FIND_ALL = "com.leancrm.portlet.library.service.persistence.MyAddressBookContactFinderImpl.findAll";
	public static final String FIND_COUNT = "com.leancrm.portlet.library.service.persistence.MyAddressBookContactFinderImpl.count";
	
	@SuppressWarnings("unchecked")
	public List<MyAddressBookContact> findAll(long organizationId, long userId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_ALL);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("MyAddressBookContact", MyAddressBookContactImpl.class);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(organizationId);
			qPos.add(userId);
			qPos.add(userId);
			
			return (List<MyAddressBookContact>) QueryUtil.list(q, getDialect(), start, end);
		} catch(Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public int countAll(long userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_COUNT);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(userId);
			
			BigInteger count = (BigInteger) q.uniqueResult();
			
			return count.intValue() / 2;
		} catch(Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
