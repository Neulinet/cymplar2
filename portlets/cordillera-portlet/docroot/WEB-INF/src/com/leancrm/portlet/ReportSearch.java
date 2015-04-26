package com.leancrm.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.reportSearch.ReportResultItem;
import com.leancrm.portlet.sort.LeadOrderByComparator;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.utils.PermissionChecker;
import com.leancrm.portlet.utils.ReportComparator;
import com.leancrm.portlet.utils.ReportSearchUtils;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ReportSearch extends MVCPortlet {
	
	private Logger logger = Logger.getLogger(ReportSearch.class);
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// call search just during render
		searchImpl(request, response);
		
		super.render(request, response);
	}
	
	
	public void getConsultants(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
			
			List<User> consultantList;
			if (organization != null && PermissionChecker.isOrganizationAdmin(themeDisplay.getUser())) {
				List<Report> reportList = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, null, null, null, organization.getOrganizationId(), null, 0d, 100d, null, null, null);
				consultantList = ReportSearchUtils.getConsultantList(reportList);
			} else {
				consultantList = new ArrayList<User>();
				consultantList.add(themeDisplay.getUser());
			}
			
			json.put("consultants" ,ReportSearchUtils.getConsultantListAsJson(consultantList));
			
			json.put("currentConsultant", themeDisplay.getUserId());
			
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get consultants from report manager.");
			logger.error("Unexpected error when try to get consultants from report manager.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void getEnterprises(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			Long consultantId = ParamUtil.getLong(resourceRequest, "consultantId", 0);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			List<Report> reportList = new ArrayList<Report>();
			Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) && consultantId < 0) {
				reportList = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, null, null, null, organization.getOrganizationId(), null, 0d, 100d, null, null, null);
			} else if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				reportList = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, consultantId, null, null, organization.getOrganizationId(), null, 0d, 100d, null, null, null);
			}
			
			json.put("enterprises", ReportSearchUtils.getEnterpriseListAsJson(reportList));
			json.put("reportDate", ReportSearchUtils.dateFormatter.format(ReportSearchUtils.getEarlyReportDate(reportList)));
			
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get enterprises from report manager.");
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	/**
	 * Search reports by Enterprise Id and User Id.
	 * Return Contact List y Contract List
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void searchByEnterprise(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String enterpriseIdParam = ParamUtil.getString(resourceRequest, "enterpriseId");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Long consultantId = ParamUtil.getLong(resourceRequest, "consultantId", 0);
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
				if (enterpriseId != null) {
					Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
					List<Report> reportList  = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, consultantId, enterpriseId, null, organization.getOrganizationId(), null, 0d, 100d, null, null, null);
					json.put("contacts", ReportSearchUtils.getContactsAsJson(reportList));
					json.put("contracts", ReportSearchUtils.getContractsAsJson(reportList));
					json.put("reportDate", ReportSearchUtils.dateFormatter.format(ReportSearchUtils.getEarlyReportDate(reportList)));
				} else {
					json.put("error", "Could not found an enterprise with id : " + enterpriseIdParam);
				}
			}
		} catch (Exception e) {
			logger.error("Unexpected error when search reports by enterprise. Enterprise Id: " + enterpriseIdParam, e);
			json.put("error", "Unexpected error when search reports by enterprise. Enterprise Id: " + enterpriseIdParam);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void getContracts(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String contactIdParam = ParamUtil.getString(resourceRequest, "contactId");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Long consultantId = ParamUtil.getLong(resourceRequest, "consultantId", 0);
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				Long contactId = ValidationsUtil.existContact(contactIdParam);
				if (contactId != null) {
					long organizationId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
					Long enterpriseId = ParamUtil.getLong(resourceRequest, "enterpriseId", 0);
					List<Report> reportList = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, consultantId, enterpriseId, contactId, organizationId, null, 0d, 100d, null, null, null);
					json.put("contracts", ReportSearchUtils.getContractsAsJson(reportList));
					json.put("reportDate", ReportSearchUtils.dateFormatter.format(ReportSearchUtils.getEarlyReportDate(reportList)));
				} else {
					json.put("error", "Could not found an contact with id : " + contactIdParam);
				}
			}
		} catch (SystemException e) {
			logger.error("Unexpected error when search reports by contact. contact Id: " + contactIdParam, e);
			json.put("error", "Unexpected error when search reports by contact. contact Id: " + contactIdParam);
		} catch (PortalException e) {
			logger.error("Unexpected error when search reports by contact. contact Id: " + contactIdParam, e);
			json.put("error", "Unexpected error when search reports by contact. contact Id: " + contactIdParam);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void getContractDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String contractIdParam = ParamUtil.getString(resourceRequest, "contractId");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Long consultantId = ParamUtil.getLong(resourceRequest, "consultantId", 0);
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				Long contractId = ValidationsUtil.existContract(contractIdParam);
				if (contractId != null) {
					Contract contract = ContractLocalServiceUtil.getContract(contractId);
					List<Report> reportList = ReportLocalServiceUtil.searchReports(ReportComparator.ASC, consultantId, contract.getEnterpriseId(), contract.getContactId(), contract.getOrganizationId(), contract.getContractId(), 0d, 100d, null, null, null);
					json.put("reportDate", ReportSearchUtils.dateFormatter.format(ReportSearchUtils.getEarlyReportDate(reportList)));
				} else {
					json.put("error", "Could not found an contract with id : " + contractIdParam);
				}
			}
		} catch (SystemException e) {
			logger.error("Unexpected error when search reports by contract. contract Id: " + contractIdParam, e);
			json.put("error", "Unexpected error when search reports by contract. contract Id: " + contractIdParam);
		} catch (PortalException e) {
			logger.error("Unexpected error when search reports by contract. contract Id: " + contractIdParam, e);
			json.put("error", "Unexpected error when search reports by contract. contract Id: " + contractIdParam);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	/** Return information about report in JSON format
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	public void getReportInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		Long reportId = ParamUtil.getLong(resourceRequest, "reportId");
		
		try {
			// get report
			Report report = ReportLocalServiceUtil.getReport(reportId);
			
			// convert it into report result item
			ReportResultItem item = new ReportResultItem(report);
			
			// get it as json
			ReportSearchUtils.getReportResultItemAsJson(item, json);
			
		} catch (Exception ex) {
			logger.error("Cannot get report info", ex);
			json.put("error", "Unexpected error when get report by report Id: " + reportId);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void searchJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		Long enterpriseId = ParamUtil.getLong(resourceRequest, "enterpriseId", 0);
		Long contactId = ParamUtil.getLong(resourceRequest, "contact", 0);
		Long contractId = ParamUtil.getLong(resourceRequest, "contract", 0);
		Long consultantId = ParamUtil.getLong(resourceRequest, "consultant", 0);
		Double fromProgress = ParamUtil.getDouble(resourceRequest, "progressFrom", 0);
		Double toProgress = ParamUtil.getDouble(resourceRequest, "progressTo", 100);
		int statusCode1 = ParamUtil.getInteger(resourceRequest, "statusCode1", -1);
		int statusCode2 = ParamUtil.getInteger(resourceRequest, "statusCode2", -1);
		int statusCode3 = ParamUtil.getInteger(resourceRequest, "statusCode3", -1);
		int statusCode4 = ParamUtil.getInteger(resourceRequest, "statusCode4", -1);
		
		Date fromDate = null;
		if (! ValidationsUtil.isEmpty(resourceRequest.getParameter("fromDate"))) {
			fromDate = ParamUtil.getDate(resourceRequest, "fromDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		Date toDate = null;
		if (!ValidationsUtil.isEmpty(resourceRequest.getParameter("toDate"))) {
			toDate = ParamUtil.getDate(resourceRequest, "toDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		logger.info("Enterprise ID: " + enterpriseId);
		logger.info("Contact ID: " + contactId);
		logger.info("Contract ID: " + contractId);
		logger.info("Consultant ID: " + consultantId);
		logger.info("Progress From: " + fromProgress);
		logger.info("Progress To: " + toProgress);
		logger.info("Status Code1: " + statusCode1);
		logger.info("Status Code2: " + statusCode2);
		logger.info("Status Code3: " + statusCode3);
		logger.info("Status Code4: " + statusCode4);
		logger.info("From Date: " + fromDate);
		logger.info("To Date: " + toDate);
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) || themeDisplay.getUserId() == consultantId) {
				Long organizationId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
				
				List<Integer> statusCodeList = new ArrayList<Integer>();
				if (statusCode1 >= 0) {
					statusCodeList.add(statusCode1);
				}
				if (statusCode2 >= 0) {
					statusCodeList.add(statusCode2);
				}
				if (statusCode3 >= 0) {
					statusCodeList.add(statusCode3);
				}
				if (statusCode4 >= 0) {
					statusCodeList.add(statusCode4);
				}
				List<Report> results = ReportLocalServiceUtil.searchReports(ReportComparator.DESC, consultantId, enterpriseId, contactId, organizationId, contractId, fromProgress, toProgress, statusCodeList.toArray(new Integer[statusCodeList.size()]), fromDate, toDate);
				
				json.put("searchResultsItems", ReportSearchUtils.getResultsAsJson(results));
				
				logger.info("Search Reports. Total Report Founds: " + results.size());
			}
		} catch (Exception e) {
			logger.error("Unexpected error when search report.", e);
			json.put("error", "Unexpected error when search report.");
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	
	public void search(ActionRequest request, ActionResponse response) {
		// just copy action params into render
		copyRequestParameters(request, response);
	}
	
	public void search(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//searchImpl(resourceRequest, resourceResponse);
		
		try {
			include("/html/reportsearchresult/results2.jsp", resourceRequest, resourceResponse, PortletRequest.RESOURCE_PHASE);
		} catch (Exception e) {
			logger.error("Unexpected error when search report.", e);
		}
	}
	
	public void searchImpl(PortletRequest request, RenderResponse response) {
		Long enterpriseId = ParamUtil.getLong(request, "enterprise", 0);
		Long contactId = ParamUtil.getLong(request, "contact", 0);
		Long contractId = ParamUtil.getLong(request, "contract", 0);
		Long consultantId = ParamUtil.getLong(request, "consultant", 0);
		Double fromProgress = ParamUtil.getDouble(request, "progressFrom", 0);
		Double toProgress = ParamUtil.getDouble(request, "progressTo", 100);
		
		int statusCode1 = ParamUtil.getInteger(request, "statusCode1", -1);
		int statusCode2 = ParamUtil.getInteger(request, "statusCode2", -1);
		int statusCode3 = ParamUtil.getInteger(request, "statusCode3", -1);
		int statusCode4 = ParamUtil.getInteger(request, "statusCode4", -1);
		
		Date fromDate = null;
		if (! ValidationsUtil.isEmpty(request.getParameter("fromDate"))) {
			fromDate = ParamUtil.getDate(request, "fromDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		Date toDate = null;
		if (!ValidationsUtil.isEmpty(request.getParameter("toDate"))) {
			toDate = ParamUtil.getDate(request, "toDate", new SimpleDateFormat("dd/MM/yyyy"));
		}
		
		logger.debug("Enterprise ID: " + enterpriseId);
		logger.debug("Contact ID: " + contactId);
		logger.debug("Contract ID: " + contractId);
		logger.debug("Consultant ID: " + consultantId);
		logger.debug("Progress From: " + fromProgress);
		logger.debug("Progress To: " + toProgress);
		logger.debug("Status Code1: " + statusCode1);
		logger.debug("Status Code2: " + statusCode2);
		logger.debug("Status Code3: " + statusCode3);
		logger.debug("Status Code4: " + statusCode4);
		logger.debug("From Date: " + fromDate);
		logger.debug("To Date: " + toDate);
		
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String orderByType = ParamUtil.getString(request, "orderByType");
		OrderByComparator comparator = null;

		if (Validator.isNull(orderByType)) {
			orderByType = "asc";	
		}

		if (Validator.isNotNull(orderByCol) &&
			Validator.isNotNull(orderByType)) {
			comparator = new LeadOrderByComparator(orderByCol, orderByType);
		}

		PortletURL portletURL = response.createRenderURL();
		SearchContainer<ReportResultItem> sc = new SearchContainer<ReportResultItem>(request, null, null, "cur1", 10, portletURL, null, null);
		
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			if (!PermissionChecker.isOrganizationAdmin(themeDisplay.getUser())) {
				// user is not organziation admin - so, user see only own contacts
				consultantId = themeDisplay.getUserId();
			}
			
			Long organizationId = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId()).getOrganizationId();
			
			List<Integer> statusCodeList = new ArrayList<Integer>();
			if (statusCode1 >= 0) {
				statusCodeList.add(statusCode1);
			}
			if (statusCode2 >= 0) {
				statusCodeList.add(statusCode2);
			}
			if (statusCode3 >= 0) {
				statusCodeList.add(statusCode3);
			}
			if (statusCode4 >= 0) {
				statusCodeList.add(statusCode4);
			}
			List<Report> results = ReportLocalServiceUtil.searchReports(ReportComparator.DESC, consultantId, enterpriseId, contactId, organizationId, contractId, fromProgress, toProgress, statusCodeList.toArray(new Integer[statusCodeList.size()]), fromDate, toDate);
			 
			List<ReportResultItem> reportResultList = ReportSearchUtils.getResults(results);
			
			// TODO itis better to do soring and getting part of reports by SQL query - not in Java
			// sort records
			if (comparator != null) {
				Collections.sort(reportResultList, comparator);
			}
			logger.info("Search Reports. Total Report Founds: " + reportResultList.size());
			request.setAttribute("searchResultsCount", reportResultList.size());
			
			// get required part
			int start = sc.getStart();
			int end = sc.getEnd();
			reportResultList = ListUtil.subList(reportResultList, start, end);
			request.setAttribute("searchResultsItems", reportResultList);
			
			logger.info("Search Reports. Total Report Founds: " + results.size());
		} catch (Exception e) {
			logger.error("Unexpected error when search report.", e);
		}

	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if ("getConsultants".equals(resourceID)) {
			getConsultants(resourceRequest, resourceResponse);
		} if ("getEnterprises".equals(resourceID)) {
			getEnterprises(resourceRequest, resourceResponse);
		} if ("searchByEnterprise".equals(resourceID)) {
			searchByEnterprise(resourceRequest, resourceResponse);
		} if ("getContracts".equals(resourceID)) {
			getContracts(resourceRequest, resourceResponse);
		} if ("getContractDetail".equals(resourceID)) {
			getContractDetail(resourceRequest, resourceResponse);
		} if ("search".equals(resourceID)) {
			search(resourceRequest, resourceResponse);
		} if ("getReportInfo".equals(resourceID)) {
			getReportInfo(resourceRequest, resourceResponse);
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	/** Delete report
	 * 
	 * @param request
	 * @param response
	 */
	public void removeReport(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long reportId = ParamUtil.getLong(request, "reportId");
		
		logger.info("User " + themeDisplay.getUserId() + " attempts to delete report " + reportId);
		
		try {
			ReportLocalServiceUtil.deleteReport(reportId);
		} catch (Exception ex) {
			logger.error("Cannot remote report", ex);
		}
		
	}
	
    /**
     * Copy request parameters into response request
     * 
     * Used to pass values from original request sent into action into render -
     * to restore entered values
     * 
     * @param request
     * @param response
     */
    public void copyRequestParameters(ActionRequest request, ActionResponse response) {
        // copy parameters from action request to response
        for (Object key : request.getParameterMap().keySet()) {
            String val = request.getParameter((String) key);
            if (val != null && !"image".equals(key) && !((String) key).startsWith("fileName")) {
                response.setRenderParameter((String) key, val);
            }
        }
    }
}
