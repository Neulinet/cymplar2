package com.leancrm.portlet.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.reportSearch.ReportResultItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ReportSearchUtils {

	private static Logger logger = Logger.getLogger(ReportSearchUtils.class);
	
	public static final DateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
	
	public static JSONArray getConsultantListAsJson(List<User> consultantList) {
		JSONArray consultants = JSONFactoryUtil.createJSONArray();
		for (User consultant : consultantList) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("id", consultant.getUserId());
			json.put("name", consultant.getFullName());
			consultants.put(json);
		}
		return consultants;
	}
	
	public static JSONArray getEnterpriseListAsJson(List<Report> reportList) {
		JSONArray enterprises = JSONFactoryUtil.createJSONArray();
		if (reportList != null) {
			List<Long> enterpriseProcessed = new ArrayList<Long>();
			for (Report report : reportList) {
				if (!enterpriseProcessed.contains(report.getEnterpriseId())) {
					JSONObject json = JSONFactoryUtil.createJSONObject();
					enterpriseProcessed.add(report.getEnterpriseId());
					json.put("id", report.getEnterpriseId());
					String enterpriseName = "";
					String enterpriseTaxId = "";
					try {
						Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(report.getEnterpriseId());
						enterpriseName = enterprise.getName();
						enterpriseTaxId = enterprise.getTaxid();
					} catch (Exception e) {
						logger.error("Unexpected error when try to get enterprise.", e);
					}
					json.put("name", enterpriseName);
					json.put("taxid", enterpriseTaxId);
					enterprises.put(json);
				}
			}
		}
		return enterprises;
	}
	
	public static JSONArray getContactsAsJson(List<Report> reportList) {
		JSONArray contacts = JSONFactoryUtil.createJSONArray();
		if (reportList != null) {
			ContactDataMethod nameContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
			List<Long> contactProcessed = new ArrayList<Long>();
			for (Report report : reportList) {
				if (!contactProcessed.contains(report.getContactId())) {
					JSONObject json = JSONFactoryUtil.createJSONObject();
					contactProcessed.add(report.getContactId());
					json.put("id", report.getContactId());
					String contactName = "";
					try {
						AddressBook addressBook = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(report.getUserId()));
						ContactData contactDataName = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), report.getContactId(), nameContactMethod.getContactDataMethodId());
						ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataName.getContactDataId());
						contactName = contactDataText.getValue();
					} catch (PortalException e) {
						logger.error("Unexpected error when try to get contact name.", e);
					} catch (SystemException e) {
						logger.error("Unexpected error when try to get contact name.", e);
					}
					json.put("name", contactName);
					contacts.put(json);
				}
			}
		}
		
		return contacts;
	}
	
	public static JSONArray getContractsAsJson(List<Report> reportList) {
		JSONArray contracts = JSONFactoryUtil.createJSONArray();
		if (reportList != null) {
			List<Long> contactProcessed = new ArrayList<Long>();
			for (Report report : reportList) {
				if (!contactProcessed.contains(report.getContractId())) {
					JSONObject json = JSONFactoryUtil.createJSONObject();
					contactProcessed.add(report.getContractId());
					try {
						Contract contract = ContractLocalServiceUtil.getContract(report.getContractId());
						json.put("id", contract.getContractId());
						json.put("description", contract.getDescription());
						json.put("amount", contract.getAmount());
					} catch (PortalException e) {
						logger.error("Unexpected error when try to get contract.", e);
					} catch (SystemException e) {
						logger.error("Unexpected error when try to get contact.", e);
					}
					contracts.put(json);
				}
			}
		}
		return contracts;
	}
	
	public static JSONArray getResultsAsJson(List<Report> reportList) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		JSONArray results = JSONFactoryUtil.createJSONArray();
		if (reportList != null) {
			for (Report report : reportList) {
				try {
					ReportResultItem item = new ReportResultItem(report);
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("reportDate", dateFormat.format(item.getReportDate()));
					json.put("enterpriseName", item.getEnterprise().getName());
					json.put("contractDescription", item.getContract().getDescription());
					json.put("contactFullName", item.getConsultant().getFullName());
					json.put("methodName", item.getMethodUsedName());
					json.put("methodValue", item.getMethodUsedValue());
					json.put("contractProgress", item.getProgress());
					json.put("contractStatus", String.valueOf(item.getStatus()));
					json.put("reportComment", item.getComments());
					results.put(json);
				} catch (PortalException e) {
					logger.error("Unexpected error when try to get report search result.", e);
				} catch (SystemException e) {
					logger.error("Unexpected error when try to get report search result.", e);
				}
			}
		}
		return results;
	}
	
	public static List<ReportResultItem> getResults(List<Report> reportList) {
		List<ReportResultItem> results = new ArrayList<ReportResultItem>();
		if (reportList != null) {
			for (Report report : reportList) {
				try {
					ReportResultItem item = new ReportResultItem(report);
					results.add(item);
				} catch (PortalException e) {
					logger.error("Unexpected error when try to get report search result.", e);
				} catch (SystemException e) {
					logger.error("Unexpected error when try to get report search result.", e);
				}
			}
		}
		return results;
	}
	
	public static List<User> getConsultantList(List<Report> reportList) {
		List<User> consultants = new ArrayList<User>();
		
		if (reportList != null) {
			List<Long> consultantProcessed = new ArrayList<Long>();
			for (Report report : reportList) {
				if (!consultantProcessed.contains(report.getUserId())) {
					consultantProcessed.add(report.getUserId());
					try {
						consultants.add(UserLocalServiceUtil.getUser(report.getUserId()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return consultants;
	}
	
	public static Date getEarlyReportDate(List<Report> reportList) {
		Date date = reportList != null && !reportList.isEmpty() ? reportList.get(0).getReportDate() : new Date();
		return date;
	}
	
	public static String getFirstDigits(String s) {
		char[] chs = s.toCharArray();
		
		StringBuilder builder = new StringBuilder();
		for (char ch : chs) {
			if (ch >= '0' && ch <= '9') {
				builder.append(ch);
			}
		}
		
		return builder.toString();
	}
}
