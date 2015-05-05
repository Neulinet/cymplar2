package com.leancrm.portlet.library.service.persistence;

import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Report;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


/** Set of finder methods related to searching leads
 * 
 * @author akakunin
 *
 */
public class ContractFinderImpl extends BasePersistenceImpl<Contract> implements ContractFinder {
	private static String SQL_SELECT_REPORT = "SELECT distinct r  FROM Report r, UserContract uc WHERE r.organizationId = ? and (r.userId = ? or r.contractId = uc.id.contractId and uc.id.userId = ?) ";
	
	private static Log log = LogFactoryUtil.getLog(ContractFinderImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Report> findConsultantReports(Long userId, Long enterpriseId, Long contactId, Long organizationId, Long contractId, Double fromProgress, Double toProgress, Integer[] statusCodeList, Date fromDate, Date toDate, int order, int start, int end)  throws SystemException {
		// first implementation - find all repotrs, related to contracts what user has access (inside specific organization)
		List<Report> list = null;

        StringBundler query = new StringBundler(256);
        
        query.append(SQL_SELECT_REPORT);
        
        
        String sql = query.toString();
        
        
        Session session = null;

        try {
            session = openSession();

            Query q = session.createQuery(sql);

            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(organizationId);
            qPos.add(userId);
            qPos.add(userId);
            
            list = (List<Report>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        return list;
	}
	
	public long countConsultantReports(Long userId, Long enterpriseId, Long contactId, Long organizationId, Long contractId, Double fromProgress, Double toProgress, Integer[] statusCodeList, Date fromDate, Date toDate) throws SystemException {
		return 0;
	}

}
