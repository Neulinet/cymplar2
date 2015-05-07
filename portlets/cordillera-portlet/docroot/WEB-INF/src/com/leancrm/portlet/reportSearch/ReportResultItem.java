package com.leancrm.portlet.reportSearch;

import java.util.Date;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.leancrm.portlet.utils.AddressBookUtils;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.utils.ContactDataType;
import com.leancrm.portlet.utils.ContactSatusEnum;
import com.leancrm.portlet.utils.ReportSearchUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ReportResultItem {

	private Logger logger = Logger.getLogger(ReportResultItem.class);
	
//	<th>Contact</th>
//	<th>Contract</th>
//	<th>Consultant</th>
//	<th>Method</th>
//	<th>Progress</th>
//	<th>Status</th>
//	<th>Comments</th>
	
	private long reportId;
	private Date reportDate;
	private Enterprise enterprise;
	private Long contractId;
	private Contract contract;
	private Long contactId;
	private String contactName;
	private User consultant;
	private String methodUsedValue;
	private String methodUsedName;
	private double progress;
	private ContactSatusEnum status;
	private String comments;
	private User leadOwner;
	
	private void printReport(Report report) {
		logger.info("Report: " +
		"Comments: " + report.getComments() +
		"Contact data id: " + report.getContactDataId() +
		"Contact Id: " + report.getContactId() +
		"Method Id: " + report.getContactMethodId() +
		"Contract Id: " + report.getContractId() +
		"Create Date: " + report.getCreateDate() +
		"Enterprise Id: " + report.getEnterpriseId() +
		"Organization Id: " + report.getOrganizationId() +
		"Progress: " + report.getProgress() +
		"Report Date: " + report.getReportDate() +
		"Report Id: " + report.getReportId() +
		"Status: " + report.getStatus() +
		"Consultant: " + report.getUserId()
		);
	}
	
	public ReportResultItem(Report report) throws PortalException, SystemException {
		printReport(report);
		reportId = report.getReportId();
		reportDate = report.getReportDate();
		enterprise = EnterpriseLocalServiceUtil.getEnterprise(report.getEnterpriseId());
		contactId = report.getContactId();
		contractId = report.getContractId();
		contract = ContractLocalServiceUtil.getContract(report.getContractId());
		consultant = UserLocalServiceUtil.getUser(report.getUserId());
		
		// List<ContactData> contactData = ContactDataLocalServiceUtil.getContactDataList(report.getContactId(), ContactDataMethodEnum.NAME.getMethodName());
		AddressBook addressBook = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(report.getUserId()));
		ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
		ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), report.getContactId(), contactDataMethod.getContactDataMethodId());
		if (contactData == null) {
			addressBook = AddressBookContactLocalServiceUtil.getFirstAddressBook(contactId);
			contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), report.getContactId(), contactDataMethod.getContactDataMethodId());
		}
		
		contactName = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
		
		ContactData contactDataUsed = ContactDataLocalServiceUtil.getContactData(report.getContactDataId());
		if (contactDataUsed != null) {
			ContactDataMethod methodName = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactDataUsed.getContactDataMethodId());
			methodUsedName = methodName.getName();
			if (contactDataUsed.getContactDataType() == ContactDataType.TEXT.ordinal()) {
				ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(report.getContactDataId());
				methodUsedValue = contactDataText.getValue();
			} else if (contactDataUsed.getContactDataType() == ContactDataType.PHONE.ordinal()) {
				ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(report.getContactDataId());
				methodUsedValue = ReportSearchUtils.getFirstDigits(contactDataPhone.getExtension()) + contactDataPhone.getNumber();
			}
		} else {
			methodUsedName = "";
			methodUsedValue = "";
		}
		progress = report.getProgress();
		status = ContactSatusEnum.getStatus(report.getStatus());
		comments = report.getComments();
		
		// get lead owner
		leadOwner = UserContractLocalServiceUtil.getContractOwner(report.getContractId());
	}
	
	public long getReportId() {
		return reportId;
	}
	
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public User getConsultant() {
		return consultant;
	}

	public void setConsultant(User consultant) {
		this.consultant = consultant;
	}

	public Long getContactId() {
		return contactId;
	}
	
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	public ContactSatusEnum getStatus() {
		return status;
	}

	public void setStatus(ContactSatusEnum status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMethodUsedValue() {
		return methodUsedValue;
	}

	public void setMethodUsedValue(String methodUsedValue) {
		this.methodUsedValue = methodUsedValue;
	}
	
	public String getMethodUsedName() {
		return methodUsedName;
	}

	public void setMethodUsedName(String methodUsedName) {
		this.methodUsedName = methodUsedName;
	}
	
	public User getLeadOwner() {
		return leadOwner;
	}
	
	public void setLeadOwner(User leadOwner) {
		this.leadOwner = leadOwner;
	}
}
