package com.leancrm.portlet.library.service.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.impl.ContactImpl;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


/** Set of finder methods related to searching leads
 * 
 * @author akakunin
 *
 */
public class ContractFinderImpl extends BasePersistenceImpl<Contract> implements ContractFinder {
	private static final String _SQL_SELECT_REPORT_WHERE = "SELECT distinct r  FROM Report r, UserContract uc WHERE ";
	private static final String _FINDER_COLUMN_ORGANiZATION_ID = "r.organizationId = ?";
	private static final String _FINDER_COLUMN_USER_ID = "(r.userId = ? or r.contractId = uc.id.contractId and uc.id.userId = ?)";
	private static final String _FINDER_COLUMN_ENTERPRISE_ID = "r.enterpriseId = ?";
	private static final String _FINDER_COLUMN_CONTACT_ID = "r.contactId = ?";
	private static final String _FINDER_COLUMN_CONTRACT_ID = "r.contractId = ?";
	private static final String _FINDER_COLUMN_STATUSES = "r.status in [$STATUSES$]";
	private static final String _FINDER_COLUMN_PROGRESS = "(r.progress between ? and ?)";
	private static final String _FINDER_COLUMN_REPORTDATE_BETWEEN = "(r.reportDate between ? and ?)";
	private static final String _FINDER_COLUMN_REPORTDATE_FROM = "r.reportDate >= ?";
	private static final String _FINDER_COLUMN_REPORTDATE_TO = "r.reportDate <= ?";
	
	
	/** Search for all contacts, linked with user via UserContract with permission OWNER or COMMITER or contacts in user address book
	 * 
	 */
	private static final String _SQL_SELECT_CONTACTS = "SELECT c.* from crm_contact c, crm_contract cntr, crm_usercontract uc where uc.userId = ? and uc.accessLevel in (0,2) and uc.contractId = cntr.contractId and cntr.contactId = c.contactId " +
													   " UNION " + 
													   "SELECT c.* from crm_contact c, crm_addressbookcontact ac, crm_addressbookuser au where au.userId = ? and au.addressBookId = ac.addressBookId and ac.contactId = c.contactId";
	
	private static final String _SQL_SELECT_COMPANY_CONTRACTS = " SELECT c FROM Contract c WHERE c.organizationId = ? AND c.contractId NOT IN (SELECT uc.id.contractId FROM UserContract uc WHERE uc.id.userId = ?)";
	
	private static Log logger = LogFactoryUtil.getLog(ContractFinderImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> findConsultantReports(Long userId, Long enterpriseId, Long contactId, Long organizationId, Long contractId, Double fromProgress, Double toProgress, List<Integer> statusCodeList, Date fromDate, Date toDate, int order, int start, int end)  throws SystemException {
		// first implementation - find all repotrs, related to contracts what user has access (inside specific organization)
		List<Report> list = null;
		List<String> queries = new ArrayList<String>();
		
		if (organizationId != null && organizationId > 0) {
			queries.add(_FINDER_COLUMN_ORGANiZATION_ID);
		}
		if (userId != null && userId > 0) {
			queries.add(_FINDER_COLUMN_USER_ID);
		}
		
		if (enterpriseId != null && enterpriseId > 0) {
			queries.add(_FINDER_COLUMN_ENTERPRISE_ID);
		}
		
		if (contactId != null && contactId > 0) {
			queries.add(_FINDER_COLUMN_CONTACT_ID);
		}

		if (contractId != null && contractId > 0) {
			queries.add(_FINDER_COLUMN_CONTRACT_ID);
		}
		
		
		if (statusCodeList != null && statusCodeList.size() > 0) {
			queries.add(_FINDER_COLUMN_STATUSES);
		}
		
		queries.add(_FINDER_COLUMN_PROGRESS);
		
		
		if (fromDate != null && toDate != null) {
			queries.add(_FINDER_COLUMN_REPORTDATE_BETWEEN);
		} else if (fromDate != null) {
			queries.add(_FINDER_COLUMN_REPORTDATE_FROM);
		} else if (toDate != null) {
			queries.add(_FINDER_COLUMN_REPORTDATE_TO);
		}
		
        StringBundler query = new StringBundler(256);
        
        query.append(_SQL_SELECT_REPORT_WHERE);
        
        query.append(ListUtil.toString(queries, (String)null, " AND "));

        
        String sql = query.toString();
        
        if (statusCodeList != null && statusCodeList.size() > 0) {
        	String statuses = "(" + ListUtil.toString(statusCodeList, (String)null, ",") + ")";
            sql = StringUtil.replace(sql, "[$STATUSES$]", statuses);		
        }

        logger.debug("SQL: " + sql);
        
        
        Session session = null;

        try {
            session = openSession();

            Query q = session.createQuery(sql);

            QueryPos qPos = QueryPos.getInstance(q);
    		if (organizationId != null && organizationId > 0) {
                qPos.add(organizationId);
    		}
    		if (userId != null && userId > 0) {
                qPos.add(userId);
                qPos.add(userId);
    		}
    		if (enterpriseId != null && enterpriseId > 0) {
    			qPos.add(enterpriseId);
    		}
    		
    		if (contactId != null && contactId > 0) {
    			qPos.add(contactId);
    		}

    		if (contractId != null && contractId > 0) {
    			qPos.add(contractId);
    		}
    		
    		qPos.add(fromProgress);
    		qPos.add(toProgress);
    		
    		if (fromDate != null) {
    			qPos.add(fromDate);
    		} 
    		
    		if (toDate != null) {
    			qPos.add(toDate);
    		}
    		
            list = (List<Report>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        return list;
	}
	
	@Override
	public int countConsultantReports(Long userId, Long enterpriseId, Long contactId, Long organizationId, Long contractId, Double fromProgress, Double toProgress, List<Integer> statusCodeList, Date fromDate, Date toDate) throws SystemException {
		return 0;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findConsultantContacts(long consultantId)  throws SystemException {
		String sql = _SQL_SELECT_CONTACTS;
		List<Contact> list = null;
		
		Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);
            q.addEntity("crm_contact", ContactImpl.class);
            
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(consultantId);
            qPos.add(consultantId);
    		
            list = (List<Contact>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findConsultantContracts(long consultantId)  throws SystemException {
		return null;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findCompanyContracts(long organizationId, long consultantId, int start, int end)  throws SystemException {
		String sql = _SQL_SELECT_COMPANY_CONTRACTS;
		List<Contract> list = null;
		
		Session session = null;

        try {
            session = openSession();

            Query q = session.createQuery(sql);
            
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(organizationId);
            qPos.add(consultantId);
    		
            list = (List<Contract>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        return list;
	}
	
	@Override
	public int countCompanyContracts(long organizationId, long consultantId)   throws SystemException {
		// TODO need to be implemented
		return 0;
	}
	
}
