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

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.base.EnterpriseLocalServiceBaseImpl;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Address;
import com.liferay.portal.service.AddressLocalServiceUtil;

/**
 * The implementation of the enterprise local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.EnterpriseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.EnterpriseLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil
 */
public class EnterpriseLocalServiceImpl extends EnterpriseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil} to access the enterprise local service.
	 */
	public Enterprise addEnterprise(String name, long companyId, String taxid, String description, String email, long industry, boolean isPrivate) throws SystemException {
		Enterprise enterprise = enterprisePersistence.create(counterLocalService.increment(Enterprise.class.getName()));
		
		enterprise.setName(name);
		enterprise.setCreateDate(new Date());
		enterprise.setCompanyId(companyId);
		enterprise.setModifiedDate(new Date());
		enterprise.setTaxid(taxid);
		enterprise.setDescription(description);
		enterprise.setEmail(email);
		enterprise.setIndustry(industry);
		enterprise.setIsPrivate(isPrivate? 1 : 0);
		
		return enterprisePersistence.update(enterprise, false);
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws NumberFormatException 
	 */
	public Enterprise addEnterprise(long companyId, long userId, String name, String taxId, String countryId, String description, String email, String industry, String street1,
			String street2, String street3, String zipCode, String city, boolean isPrivate) throws SystemException, NumberFormatException, PortalException {
		
		Enterprise enterprise = null;
		
		long regionId = 0;
		
		int billingAddres = 12000;
		
		Long industryId = ValidationsUtil.isEmpty(industry) ? 0 : Long.parseLong(industry);
		
		enterprise = addEnterprise(name, companyId, taxId, description, email, industryId, isPrivate);
		
		if (StringUtils.isNotBlank(street1)) {
			AddressLocalServiceUtil.addAddress(userId, Enterprise.class.getName(), enterprise.getEnterpriseId(), street1, street2, street3, city, zipCode, regionId, Long.parseLong(countryId), billingAddres, true, true);
		}
		
		return enterprise;
	}
	
	public Enterprise updateEnterprise(long enterpriseId, long companyId, long userId, String name, String taxId, String countryId, String description, String email, String industry, String street1,
			String street2, String street3, String zipCode, String city, boolean isPrivate) throws Exception {
		
		Enterprise enterprise = null;
		try {
			enterprise = getEnterprise(enterpriseId);
			enterprise.setName(name);
			enterprise.setCompanyId(companyId);
			enterprise.setTaxid(taxId);
			enterprise.setDescription(description);
			enterprise.setEmail(email);
			Long industryId = ValidationsUtil.isEmpty(industry) ? 0 : Long.parseLong(industry);
			enterprise.setIndustry(industryId);
			enterprise.setIsPrivate(isPrivate? 1 : 0);
			
			List<Address> addressList = AddressLocalServiceUtil.getAddresses(companyId, Enterprise.class.getName(), enterprise.getEnterpriseId());
			
			if (addressList != null && !addressList.isEmpty()) {
				Address address = addressList.get(0);
				address.setStreet1(street1);
				address.setStreet2(street2);
				address.setStreet3(street3);
				address.setCity(city);
				address.setZip(zipCode);
				address.setCountryId(Long.parseLong(countryId));
				
				AddressLocalServiceUtil.updateAddress(address);
			} else {
				long regionId = 0;
				int billingAddres = 12000;
				AddressLocalServiceUtil.addAddress(userId, Enterprise.class.getName(), enterprise.getEnterpriseId(), street1, street2, street3, city, zipCode, regionId, Long.parseLong(countryId), billingAddres, true, true);
			}
			
			updateEnterprise(enterprise);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		return enterprise;
	}
	
	public List<Enterprise> getAll() throws SystemException {
		return enterprisePersistence.findAll();
	}
	
	public List<Enterprise> getEnterpriseByTax(String taxid) throws SystemException {
		return enterprisePersistence.findByTaxid(taxid);
	}
	
	public List<Enterprise> getEnterpriseByIndustryId(long industryId) throws SystemException {
		return enterprisePersistence.findByIndustry(industryId);
	}
	
	/** Get Enterprise by Name */
	@Override
	public List<Enterprise> findByName(String name) throws SystemException {
		return enterprisePersistence.findByName(name);
	}
}