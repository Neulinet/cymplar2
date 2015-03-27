package com.leancrm.portlet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.ContactContract;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.ContactContractLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.types.ContractStatus;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class ContractEntity {

	private Contract contract;
	
	public ContractEntity(Contract contract) throws PortalException, SystemException {
		this.contract = contract;
	}
	
	public ContractEntity(long contractId) throws PortalException, SystemException {
		this.contract = ContractLocalServiceUtil.getContract(contractId);
	}
	
	public Double getAmmount() {
		return contract.getAmount();
	}
	
	public Long getContractId() {
		return contract.getContractId();
	}
	
	public Date getCreateDate() {
		return contract.getCreateDate();
	}
	
	public String getDescription() {
		return contract.getDescription();
	}
	
	public Enterprise getEnterprise() {
		try {
			return EnterpriseLocalServiceUtil.getEnterprise(contract.getEnterpriseId());
		} catch (PortalException e) {
			e.printStackTrace();
			return null;
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Organization getOrganization() {
		try {
			return OrganizationLocalServiceUtil.getOrganization(contract.getOrganizationId());
		} catch (PortalException e) {
			e.printStackTrace();
			return null;
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Double getProgress() {
		ReportEntity lastReport = getLastReport();
		return lastReport.getProgress();
	}
	
	public ContractStatus getStatus() {
		ReportEntity lastReport = getLastReport();
		return lastReport.getStatus();
	}
	
	public ReportEntity getLastReport() {
		try {
			List<Report> beforeReports = ReportLocalServiceUtil.getReportByContract(contract.getContractId());
			if (!ValidationsUtil.isEmpty(beforeReports)) {
				return new ReportEntity(beforeReports.get(beforeReports.size()-1).getReportId());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ReportEntity> getReports() {
		List<ReportEntity> reports = new ArrayList<ReportEntity>();
		
		try {
			List<Report> reportList = ReportLocalServiceUtil.getReportByContract(contract.getContractId());
			if (!ValidationsUtil.isEmpty(reports)) {
				for (Report report : reportList) {
					reports.add(new ReportEntity(report));
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return reports;
	}
	
	public List<ContactEntity> getContacts(long userId) {
		List<ContactEntity> contacts = new ArrayList<ContactEntity>();
		List<ContactContract> contactContractList = ContactContractLocalServiceUtil.getByContract(contract.getContractId());
		if (contactContractList != null) {
			for (ContactContract contactContract : contactContractList) {
				try {
					contacts.add(new ContactEntity(contactContract.getContactId(), userId));
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return contacts;
	}
}
