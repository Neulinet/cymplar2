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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.ContactContract;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.model.impl.ContactContractImpl;
import com.leancrm.portlet.library.service.ContactContractLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ContractLocalServiceBaseImpl;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contract local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContractLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContractLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContractLocalServiceUtil
 */
public class ContractLocalServiceImpl extends ContractLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContractLocalServiceUtil} to access the contract local service.
	 */
	public Contract addContract(long companyId, long contactId, long enterpriseId, long organizationId, String description, double amount) throws SystemException {
		Contract contract = contractPersistence.create(counterLocalService.increment(Contract.class.getName()));
		
		contract.setCompanyId(companyId);
		contract.setContactId(contactId);
		contract.setCreateDate(new Date());
		contract.setEnterpriseId(enterpriseId);
		contract.setOrganizationId(organizationId);
		contract.setAmount(amount);
		contract.setDescription(description);
		
		ContactContract contactContract = new ContactContractImpl();
		contactContract.setContactId(contactId);
		contactContract.setContractId(contract.getContractId());
		
		contactContractLocalService.addContactContract(contactContract);
		
		return contractPersistence.update(contract);
	}
	
	public Contract updateAmount(long contractId, double amount) throws SystemException, PortalException {
		Contract contract = getContract(contractId);
		contract.setAmount(amount);
		
		return contractPersistence.update(contract);
	}
	
	/**
	 * Remove Cascade.
	 * Remove all the contracts related to one Organization and remove all the reports related to every contract.
	 * @param organizationId
	 * @throws SystemException
	 */
	public void removeOrganizationContracts(long organizationId) throws SystemException {
		List<Contract> contractList = contractPersistence.findByOrganization(organizationId);
		
		if (contractList != null) {
			for (Contract contract : contractList) {
				List<Report> reportList = ReportLocalServiceUtil.getReportByContract(contract.getContractId());
				if (reportList != null) {
					for (Report report : reportList) {
						reportPersistence.remove(report);
					}
				}
				
				contractPersistence.remove(contract);
			}
		}
	}
	
	/**
	 * Obtener lista de contratos del contacto
	 * Filtrar por organizacion y empresa del contacto
	 * 
	 * @param userId
	 * @param contactId
	 * @param organizationId
	 * @param enterpriseId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<Contract> getOrganizationContractList(long contactId, long organizationId, long enterpriseId) throws SystemException, PortalException {
		List<Contract> contractList = new ArrayList<Contract>();
		
		List<ContactContract> contactContractList = ContactContractLocalServiceUtil.getByContact(contactId);
		if (contactContractList != null) {
			for (ContactContract contactContract : contactContractList) {
				Contract contract = contractLocalService.getContract(contactContract.getContractId());
				if (contract.getOrganizationId() == organizationId && contract.getEnterpriseId() == enterpriseId) {
					contractList.add(contract);
				}
			}
		}
		
		return contractList;
	}
		
	/**
	 * Obtener lista de contratos del contacto
	 * Filtrar por contactos relacionados al consultor (user)
	 * Filtrar por organizacion y empresa del contacto
	 * 
	 * @param userId
	 * @param contactId
	 * @param organizationId
	 * @param enterpriseId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<Contract> getContractList(long userId, long contactId, long organizationId, long enterpriseId) throws SystemException, PortalException {
		List<Contract> contractList = new ArrayList<Contract>();
		
		List<ContactContract> contactContractList = ContactContractLocalServiceUtil.getByContact(contactId);
		if (contactContractList != null) {
			for (ContactContract contactContract : contactContractList) {
				List<UserContract> userContractList = userContractPersistence.findByUserContract(userId, contactContract.getContractId());
				if (!ValidationsUtil.isEmpty(userContractList)) {
					Contract contract = contractLocalService.getContract(contactContract.getContractId());
					if (contract.getOrganizationId() == organizationId && contract.getEnterpriseId() == enterpriseId) {
						contractList.add(contract);
					}
				}
			}
		}
		
		return contractList;
	}
	
	public List<Contract> getContractList(long organizationId, long enterpriseId) throws SystemException {
		return contractPersistence.findByOrganizationAndEnterprise(organizationId, enterpriseId);
	}
	
	// TODO: CREATE CUTOM QUERY
	public List<Contract> getContractList(long organizationId, long enterpriseId, long userId) throws SystemException {
		List<Contract> result = new ArrayList<Contract>();
		List<Contract> allContractList = contractPersistence.findByOrganizationAndEnterprise(organizationId, enterpriseId);
		for (Contract contract : allContractList) {
			if (userContractLocalService.getByUserContract(userId, contract.getContractId()) != null) {
				result.add(contract);
			}
		}
		return result;
	}
	
	public List<Contract> getContractsByOrganization(long organizationId) throws SystemException {
		return contractPersistence.findByOrganization(organizationId);
	}
	
	public List<Contract> getContractsByUser(long userId) throws SystemException, PortalException {
		List<UserContract> userContractList = userContractPersistence.findByUser(userId);
		List<Contract> contractList = new ArrayList<Contract>();
		for (UserContract uc : userContractList) {
			contractList.add(getContract(uc.getContractId()));
		}
		return contractList;
	}

}