package com.leancrm.portlet.library.service.persistence;

import java.math.BigInteger;
import java.util.List;

import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ColleagueAddressBookContactFinderImpl extends BasePersistenceImpl<ColleagueAddressBookContact> implements ColleagueAddressBookContactFinder {

	public static final String FIND_ALL = "com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactFinderImpl.findAll";
	public static final String FIND_COUNT = "com.leancrm.portlet.library.service.persistence.ColleagueAddressBookContactFinderImpl.count";
	
	@SuppressWarnings("unchecked")
	public List<ColleagueAddressBookContact> findAll(long organizationId, long userId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_ALL);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ColleagueAddressBookContact", ColleagueAddressBookContactImpl.class);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(organizationId);
			qPos.add(userId);
			
			return (List<ColleagueAddressBookContact>) QueryUtil.list(q, getDialect(), start, end);
		} catch(Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public int countAll(long organizationId, long userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_COUNT);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(organizationId);
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