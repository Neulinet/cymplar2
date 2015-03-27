package com.leancrm.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.WindowStateException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.reportSearch.ReportResultItem;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.utils.PermissionChecker;
import com.leancrm.portlet.utils.ReportComparator;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ReportSearchResult
 */
public class ReportSearchResult extends MVCPortlet {
 
	private Logger logger = Logger.getLogger(ReportSearchResult.class);

	public void search2(ActionRequest actionRequest, ActionResponse actionResponse) throws ServletException, IOException, WindowStateException {
		Long enterpriseId = ParamUtil.getLong(actionRequest, "enterprise", 0);
		logger.info("Enterprise ID: " + enterpriseId);
		Long contactId = ParamUtil.getLong(actionRequest, "contact", 0);
		logger.info("Contact ID: " + contactId);
		Long contractId = ParamUtil.getLong(actionRequest, "contract", 0);
		logger.info("Contract ID: " + contractId);
		Long consultantId = ParamUtil.getLong(actionRequest, "consultant", 0);
		logger.info("Consultant ID: " + consultantId);
		Double fromProgress = ParamUtil.getDouble(actionRequest, "fromProgress", 0);
		logger.info("Progress From: " + fromProgress);
		Double toProgress = ParamUtil.getDouble(actionRequest, "toProgress", 100);
		logger.info("Progress To: " + toProgress);
		int[] statusCodeList = ParamUtil.getIntegerValues(actionRequest, "statusCode", new int[] {0,100,200,300});
		logger.info("Status Code: " + statusCodeList.toString());
		Date fromDate = ParamUtil.getDate(actionRequest, "fromDate", new SimpleDateFormat("dd/MM/yyyy"));
		String nextDate = ParamUtil.getString(actionRequest, "reportDate");
		logger.info("From Date: " + nextDate);
		Date toDate = ParamUtil.getDate(actionRequest, "toDate", new SimpleDateFormat("dd/MM/yyyy"));
		logger.info("To Date: " + toDate);
		
		List<ReportResultItem> resultItemList = new ArrayList<ReportResultItem>();
		actionRequest.setAttribute("searchResultsItems", resultItemList);
		actionResponse.setRenderParameter("jspPage", "/html/reportsearchresult/results.jsp");
	}
	
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws ServletException, IOException, WindowStateException {
		Long enterpriseId = ParamUtil.getLong(actionRequest, "enterprise", 0);
		Long contactId = ParamUtil.getLong(actionRequest, "contact", 0);
		Long contractId = ParamUtil.getLong(actionRequest, "contract", 0);
		Long consultantId = ParamUtil.getLong(actionRequest, "consultant", 0);
		Double fromProgress = ParamUtil.getDouble(actionRequest, "fromProgress", 0);
		Double toProgress = ParamUtil.getDouble(actionRequest, "toProgress", 100);
		int[] statusCodeList = ParamUtil.getIntegerValues(actionRequest, "statusCode", new int[] {0,100,200,300});
		
		Date fromDate = null;
		if (! ValidationsUtil.isEmpty(actionRequest.getParameter("fromDate"))) {
			fromDate = ParamUtil.getDate(actionRequest, "fromDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		Date toDate = null;
		if (!ValidationsUtil.isEmpty(actionRequest.getParameter("toDate"))) {
			toDate = ParamUtil.getDate(actionRequest, "toDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				Long organizationId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
				
				List<Report> results = ReportLocalServiceUtil.searchReports(ReportComparator.DESC, consultantId, enterpriseId, contactId, organizationId, contractId, fromProgress, toProgress, ArrayUtil.toArray(statusCodeList), fromDate, toDate);
				
				List<ReportResultItem> resultItemList = new ArrayList<ReportResultItem>();
				for (Report report : results) {
					resultItemList.add(new ReportResultItem(report));
				}
				
				actionRequest.setAttribute("searchResultsItems", resultItemList);
//				HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
//				servletRequest.getSession().setAttribute("searchResultsItems", resultItemList);
				
				
				logger.info("Search Reports. Total Report Founds: " + results.size());
				
				actionResponse.setWindowState(LiferayWindowState.EXCLUSIVE);
				actionResponse.setRenderParameter("jspPage", "/html/reportsearchresult/results.jsp");
			}
		} catch (Exception e) {
			logger.error("Unexpected error when search report.", e);
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionRequest.setAttribute("searchResultsItems", new ArrayList<ReportResultItem>());
			actionResponse.setWindowState(LiferayWindowState.EXCLUSIVE);
			actionResponse.setRenderParameter("jspPage", "/html/reportsearch/results.jsp");
		}
	}
}
