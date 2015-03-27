package com.leancrm.portlet.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.utils.CRMUtils;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.utils.ContactDataUtils;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ContactEntity {

	private Logger logger = Logger.getLogger(ContactEntity.class);
	
	protected long companyId;
	protected long contactId;
	protected long addressBookId;
	private ConsultantEntity consultant;
	
	public ContactEntity(long contactId, long userId) throws PortalException, SystemException {
		this.contactId = contactId;
		this.consultant = new ConsultantEntity(userId);
		this.addressBookId = consultant.getAddressBook().getAddressBookId();
	}
	
	public ContactEntity(long companyId, long contactId, long userId) throws PortalException, SystemException {
		this.companyId = companyId;
		this.contactId = contactId;
		this.consultant = new ConsultantEntity(userId);
		this.addressBookId = consultant.getAddressBook().getAddressBookId();
	}
	
	public long getContactId() {
		return contactId;
	}
	
	public String getName() {
		return ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.NAME);
	}
	
	public EnterpriseEntity getEnterpriseEntity() {
		Enterprise enterprise = getEnterprise();
		if (enterprise != null) {
			try {
				return new EnterpriseEntity(enterprise, companyId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Enterprise getEnterprise() {
		try {
			String value = ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.ENTERPRISE);
			if (!ValidationsUtil.isEmpty(value)) {
				return EnterpriseLocalServiceUtil.getEnterprise(Long.parseLong(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		
		return null;
	}

	public String getCellPhone() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.CELL_PHONE));
	}

	public String getPhone() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.PHONE));
	}
	
	public String getSkype() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.SKYPE));
	}

	public String getEmail() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.EMAIL));
	}
	
	public String getPersonalEmail() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.PERSONAL_EMAIL));
	}
	
	public String getPosition() {
		return CRMUtils.notNullValue(ContactDataUtils.getContactDataVal(contactId, addressBookId, ContactDataMethodEnum.POSITION));
	}
	
	public List<ContractEntity> getContracts() {
		List<ContractEntity> contracts = new ArrayList<ContractEntity>();
		
		try {
			Enterprise enterprise = getEnterprise();
			if (enterprise != null) {
				logger.info("getContracts, enterprise: " + enterprise.getEnterpriseId());
				logger.info("getContracts, get contract list: userId:" + consultant.getConsultantId() + ", contactId:" + contactId + ", organizationId:" + consultant.getOrganization().getOrganizationId() + ", enterpriseId:" + enterprise.getEnterpriseId());
				List<Contract> contractList = ContractLocalServiceUtil.getContractList(consultant.getConsultantId(), contactId, consultant.getOrganization().getOrganizationId(), enterprise.getEnterpriseId());
				logger.info("getContracts, Total contract list: " + contractList.size());
				
				if (!ValidationsUtil.isEmpty(contractList)) {
					for (Contract contract : contractList) {
						try {
							contracts.add(new ContractEntity(contract));
						} catch (PortalException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		
		return contracts;
	}
	
	public List<ConsultantEntity> getOwners() {
		return new ArrayList<ConsultantEntity>(Arrays.asList(consultant));
	}
}
