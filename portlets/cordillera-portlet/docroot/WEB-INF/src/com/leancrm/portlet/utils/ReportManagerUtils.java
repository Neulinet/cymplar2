package com.leancrm.portlet.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class ReportManagerUtils {

	public static Report getLastReport(long contractId) throws SystemException {
		List<Report> beforeReports = ReportLocalServiceUtil.getReportByContract(contractId);
		if (beforeReports != null && !beforeReports.isEmpty()) {
			return beforeReports.get(beforeReports.size()-1);
		} else {
			return null;
		}
	}
	
	public static JSONArray getContactAsJson(List<Contact> contactList, long enterpriseId, long addressBookId) throws PortalException, SystemException {
		JSONArray contacts = JSONFactoryUtil.createJSONArray();
		if (contactList != null) {
			ContactDataMethod enterpriseContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
			ContactDataMethod nameContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
			for (Contact contact : contactList) {
				ContactData contactDataEnterprise = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contact.getContactId(), enterpriseContactMethod.getContactDataMethodId());
				if (enterpriseId == ContactDataRefLocalServiceUtil.getContactDataRef(contactDataEnterprise.getContactDataId()).getRefValue()) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("id", contact.getContactId());
					ContactData contactDataName = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contact.getContactId(), nameContactMethod.getContactDataMethodId());
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataName.getContactDataId());
					object.put("name", contactDataText.getValue());
					contacts.put(object);
				}
			}
		}
		return contacts;
	}
	
	public static JSONArray getContactDataAsJson(List<ContactData> contactDataList) throws PortalException, SystemException {
		JSONArray methods = JSONFactoryUtil.createJSONArray();
		if (contactDataList != null) {
			for (ContactData contactData : contactDataList) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactData.getContactDataMethodId());
				if (!contactDataMethod.getName().equals(ContactDataMethodEnum.NAME.getMethodName()) 
						&& !contactDataMethod.getName().equals(ContactDataMethodEnum.ENTERPRISE.getMethodName())
						&& !contactDataMethod.getName().equals(ContactDataMethodEnum.POSITION.getMethodName())) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("id", contactData.getContactDataId());
					object.put("name", contactDataMethod.getName());
					methods.put(object);
				}
			}
		}
		return methods;
	}
	
	public static JSONArray getContractListAsJson(List<Contract> contractList) {
		JSONArray contracts = JSONFactoryUtil.createJSONArray();
		if (contractList != null) {
			for (Contract contract : contractList) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("id", contract.getContractId());
				object.put("description", contract.getDescription());
				object.put("amount", contract.getAmount());
				contracts.put(object);
			}
		}
		return contracts;
	}
	
	public static String getEnterpriseListAsJson(List<Enterprise> enterpriseList) {
		StringBuilder json = new StringBuilder();
		
		boolean firstEnterprise = true;
		json.append("{\"enterprises\":");
		json.append("[");
		for (Enterprise enterprise : enterpriseList) {
			if (!firstEnterprise) {
				json.append(",");
			}
			json.append("{");
			json.append("\"id\":\"" + enterprise.getEnterpriseId() + "\"");
			json.append(",");
			json.append("\"name\":\"" + enterprise.getName() + "\"");
			json.append(",");
			json.append("\"taxid\":\"" + enterprise.getTaxid() + "\"");
			json.append("}");
			
			firstEnterprise = false;
		}
		json.append("]");
		json.append("}");
		
		return json.toString();
	}
	
	public static JSONObject getContractDetail(Contract contract) throws SystemException {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if (contract != null) {
			double currentProgress = 0;
			int statusCode = 0;
			long mindate = -1;
			String lastReportDate = "";
			String comments = "";
			Report lastReport;
			lastReport = getLastReport(contract.getContractId());

			if (lastReport != null) {
				currentProgress = lastReport.getProgress();
				statusCode = lastReport.getStatus();
				long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
				mindate = ( lastReport.getReportDate().getTime() - new Date().getTime() ) / MILLSECS_PER_DAY;
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				lastReportDate = dateFormat.format(lastReport.getReportDate());
				comments = lastReport.getComments();
			}
			
			json.put("id", + contract.getContractId());
			json.put("description", contract.getDescription());
			json.put("amount", contract.getAmount());
			json.put("progress", currentProgress);
			json.put("statusCode", statusCode);
			json.put("minDate", mindate);
			json.put("lastDate", lastReportDate);
			json.put("comments", comments);
		}
		return json;
	}
}
