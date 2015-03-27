package com.leancrm.portlet.entity;

import java.util.Date;

import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.impl.ReportImpl;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.types.ContractStatus;
import com.leancrm.portlet.utils.ContactDataType;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ReportEntity {

	private Report report = new ReportImpl();
	
	public ReportEntity(Report report) {
		this.report = report;
	}
	
	public ReportEntity(long reportId) throws PortalException, SystemException {
		report = ReportLocalServiceUtil.getReport(reportId);
	}
	
	public String getContactName() throws PortalException, SystemException {
		Long contactDataId = ValidationsUtil.existContactData(report.getCdNameId());
		
		if (contactDataId != null) {
			return ContactDataTextLocalServiceUtil.getContactDataText(contactDataId).getValue();
		}
		
		return "";
	}
	
	public String getContactData() throws PortalException, SystemException {
		Long contactDataId = ValidationsUtil.existContactData(report.getContactDataId());
		
		if (contactDataId != null) {
			ContactData contactData = ContactDataLocalServiceUtil.getContactData(contactDataId);
			if (contactData != null) {
				ContactDataType type = ContactDataType.getType(contactData.getContactDataType());
				switch (type) {
					case PHONE:
						ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactDataId);
						return ContactDataPhoneLocalServiceUtil.getPhoneNumber(contactDataPhone);
					case TEXT:
						ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataId);
						return contactDataText.getValue();
				default:
					break;
				}
			}
		}
		return "";
	}
	
	public String getComments() {
		return report.getComments();
	}

	public long getContactId() {
		return report.getContactId();
	}

	public String getMethodName() throws PortalException, SystemException {
		Long contactDataMethodId = ValidationsUtil.existContactDataMethod(report.getContactMethodId());
		
		if (contactDataMethodId != null) {
			ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactDataMethodId);
			return contactDataMethod.getName();
		}
		
		return "";
	}
	
	public ContractEntity getContract() {
		try {
			return new ContractEntity(report.getContractId());
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Date getCreateDate() {
		return report.getCreateDate();
	}
	
	public long getEnterpriseId() {
		return report.getEnterpriseId();
	}
	
	public long getOrganizationId() {
		return report.getOrganizationId();
	}
	
	public double getProgress() {
		return report.getProgress();
	}
	
	public ContractStatus getStatus() {
		return ContractStatus.getContractStatus(report.getStatus());
	}
	
	public User getConsultant() throws PortalException, SystemException {
		Long userId = ValidationsUtil.existUser(report.getUserId());
		
		if (userId != null) {
			return UserLocalServiceUtil.getUser(userId);
		}

		return null;
	}
	
	public Date getReportDate() {
		return report.getReportDate();
	}
	
	public long getReportId() {
		return report.getReportId();
	}
}
