/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.leancrm.portlet.library.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.ContactContract;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.impl.ContactContractImpl;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ReportLocalServiceBaseImpl;
import com.leancrm.portlet.utils.ReportComparator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ReportLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ReportLocalServiceUtil
 */
public class ReportLocalServiceImpl extends ReportLocalServiceBaseImpl {
	private Logger logger = Logger.getLogger(ReportLocalServiceImpl.class);
	
	private DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public Report addReport(long companyId, long contractId, long contactId, String comments, long contactDataId, 
			long enterpriseId, long organizationId, double progress, Date reportDate, int status, long userId, long cdNameId) throws SystemException, PortalException {
		
		return addReport(companyId, contractId, contactId, comments, contactDataId, enterpriseId, organizationId, progress, reportDate, status, userId, cdNameId, new Date());
	}

	public Report addReport(long companyId, long contractId, long contactId, String comments, long contactDataId, 
			long enterpriseId, long organizationId, double progress, Date reportDate, int status, long userId, long cdNameId, Date createDate) throws SystemException, PortalException {
		
		Report report = reportPersistence.create(counterLocalService.increment(Report.class.getName()));
		report.setComments(comments);
		report.setCompanyId(companyId);
		report.setContactDataId(contactDataId);
		report.setContactId(contactId);
		if (contactDataId > 0) {
			ContactData contactData = contactDataLocalService.getContactData(contactDataId);
			report.setContactMethodId(contactData.getContactDataMethodId());
		} else {
			report.setContactMethodId(0);
		}
		report.setContractId(contractId);
		report.setCreateDate(createDate);
		report.setEnterpriseId(enterpriseId);
		report.setOrganizationId(organizationId);
		report.setProgress(progress);
		report.setReportDate(reportDate);
		report.setStatus(status);
		report.setUserId(userId);
		report.setCdNameId(cdNameId);
		
		List<ContactContract> contactContractList = contactContractPersistence.findByContactContract(contractId, contactId);
		if (contactContractList == null || contactContractList.isEmpty()) {
			ContactContract contactContract = new ContactContractImpl();
			contactContract.setContactId(contactId);
			contactContract.setContractId(contractId);
			
			contactContractLocalService.addContactContract(contactContract);
		}
		
		return reportPersistence.update(report, false);
	}
	
	/**
	 * Update the user of reports
	 * @param userId
	 * @throws SystemException
	 */
	public void updateUserOfReports(long oUserId, long nUserId) throws SystemException {
		List<Report> reportList = reportPersistence.findByUser(oUserId);
		
		if (reportList != null) {
			for (Report report : reportList) {
				report.setUserId(nUserId);
				reportPersistence.update(report, false);
			}
		}
	}
	
	public List<Report> getReport(long contactId, long enterpriseId, long organizationId) throws SystemException {
		List<Report> reportListResult = new ArrayList<Report>();
		
		List<Report> reportList = reportPersistence.findByContactOrganization(enterpriseId, contactId, organizationId);
		
		reportListResult.addAll(reportList);
		
		Collections.sort(reportListResult, new Comparator<Report>() {

			@Override
			public int compare(Report o1, Report o2) {
				return o1.getCreateDate().compareTo(o2.getCreateDate());
			}
		});
		
		return reportListResult;
	}
	
	public Report getLastReport(long contactId, long enterpriseId, long organizationId) throws SystemException {
		List<Report> reportListResult = getReport(contactId, enterpriseId, organizationId);
		
		if (reportListResult != null && !reportListResult.isEmpty()) {
			return reportListResult.get(reportListResult.size()-1);
		} else {
			return null;
		}
	}
	
	public Report getLastReport(long contractId) throws SystemException {
		List<Report> reportListResult = getReportByContract(contractId);
		
		if (reportListResult != null && !reportListResult.isEmpty()) {
			return reportListResult.get(reportListResult.size()-1);
		} else {
			return null;
		}
	}
	
	public List<Report> getReportByContract(long contractId) throws SystemException {
		List<Report> reportListResult = new ArrayList<Report>();
		
		List<Report> reportList = reportPersistence.findByContract(contractId);
		
		reportListResult.addAll(reportList);
		
		Collections.sort(reportListResult, new Comparator<Report>() {
			public int compare(Report o1, Report o2) {
				return o1.getCreateDate().compareTo(o2.getCreateDate());
			}
		});
		
		return reportListResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<Report> searchReports(int order, Long userId, Long enterpriseId, Long contactId, Long organizationId, Long contractId, Double fromProgress, Double toProgress, Integer[] statusCodeList, Date fromDate, Date toDate) throws SystemException {
		logger.debug("- - - - - - - ReportLocalServiceImpl - - - - - - -");
		logger.debug("Search Report By: ");
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Report.class);
		
		if (enterpriseId != null && enterpriseId > 0) {
			query.add(PropertyFactoryUtil.forName("enterpriseId").eq(enterpriseId));
			logger.debug("  --  EnterpriseId: " + enterpriseId);
		}
		
		if (contactId != null && contactId > 0) {
			query.add(PropertyFactoryUtil.forName("contactId").eq(contactId));
			logger.debug("  --  ContactId: " + contactId);
		}

		if (contractId != null && contractId > 0) {
			query.add(PropertyFactoryUtil.forName("contractId").eq(contractId));
			logger.debug("  --  ContractId: " + contractId);
		}
		
		if (organizationId != null && organizationId > 0) {
			query.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
			logger.debug("  --  OrganizationId: " + organizationId);
		}

		if (userId != null && userId > 0) {
			query.add(PropertyFactoryUtil.forName("userId").eq(userId));
			logger.debug("  --  ConsultantId: " + userId);
		}
		
		if (statusCodeList != null && statusCodeList.length > 0) {
			query.add(PropertyFactoryUtil.forName("status").in(statusCodeList));
			logger.debug("  --  Status: " + Arrays.toString(statusCodeList));
		}
		
		query.add(PropertyFactoryUtil.forName("progress").between(fromProgress, toProgress));
		logger.debug("  --  Progress: " + fromProgress + " | " + toProgress);
		
		if (fromDate != null && toDate != null) {
			query.add(PropertyFactoryUtil.forName("reportDate").between(fromDate, toDate));
			logger.debug("  --  Date: " + formatDate.format(fromDate) + " | " + formatDate.format(toDate));
		} else if (fromDate != null) {
			query.add(PropertyFactoryUtil.forName("reportDate").ge(fromDate));
			logger.debug("  --  Date: >> " + formatDate.format(fromDate));
		} else if (toDate != null) {
			query.add(PropertyFactoryUtil.forName("reportDate").le(toDate));
			logger.debug("  --  Date: << " + formatDate.format(toDate));
		}
		
		List<Report> results = new ArrayList<Report>();
		results.addAll(ReportLocalServiceUtil.dynamicQuery(query));
		
		Collections.sort(results, new ReportComparator(order));
		
		logger.debug("Total Results: " + results.size());
		
		logger.debug("- - - - - - - - - - - - - - - - - - - - - - - - -");
		
		return results;
	}

	private void logger(String string) {
		// TODO Auto-generated method stub
		
	}
}