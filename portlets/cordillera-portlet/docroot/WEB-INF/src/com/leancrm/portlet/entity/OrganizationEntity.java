package com.leancrm.portlet.entity;

import java.util.ArrayList;
import java.util.List;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class OrganizationEntity {

	private Organization organization;
	
	public OrganizationEntity(long organizationId) throws PortalException, SystemException {
		this.organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	
	public long getOrganizationId() {
		return organization.getOrganizationId();
	}
	
	public OrganizationEntity(Organization organization) {
		this.organization = organization;
	}
	
	public String getName() {
		return this.organization.getName();
	}
	
	public long getCompanyId() {
		return this.organization.getCompanyId();
	}
	
	public AddressBook getAddressBook() {
		try {
			List<AddressBookOrganization> addressBookOrganization = AddressBookOrganizationLocalServiceUtil.getAddressBookOrganizationList(organization.getOrganizationId());
			if (!ValidationsUtil.isEmpty(addressBookOrganization)) {
				return AddressBookLocalServiceUtil.getAddressBook(addressBookOrganization.get(0).getAddressBookId());
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ContractEntity> getContracts() {
		List<ContractEntity> contracts = new ArrayList<ContractEntity>();
		try {
			List<Contract> contractList = ContractLocalServiceUtil.getContractsByOrganization(getOrganizationId());
			if (contractList != null) {
				for (Contract contract : contractList) {
					contracts.add(new ContractEntity(contract));
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return contracts;
	}
	
	public List<ConsultantEntity> getConsultants() {
		List<ConsultantEntity> consultants = new ArrayList<ConsultantEntity>();
		
		try {
			List<User> userList = UserLocalServiceUtil.getOrganizationUsers(getOrganizationId());
			if (userList != null) {
				for (User user : userList) {
					consultants.add(new ConsultantEntity(user));
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return consultants;
	}
	
	public List<ConsultantEntity> getAdminConsultants() {
		List<ConsultantEntity> adminConsultants = new ArrayList<ConsultantEntity>();
		
		List<ConsultantEntity> consultants = getConsultants();
		for (ConsultantEntity consultant : consultants) {
			try {
				if (RoleServiceUtil.hasUserRole(consultant.getConsultantId(), consultant.getCompanyId(), "", true)) {
					adminConsultants.add(consultant);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return adminConsultants;
	}

}
