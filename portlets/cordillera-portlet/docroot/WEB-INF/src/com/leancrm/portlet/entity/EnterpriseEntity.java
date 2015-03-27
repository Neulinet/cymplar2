package com.leancrm.portlet.entity;

import java.util.List;

import com.leancrm.portlet.library.model.Enterprise;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Address;
import com.liferay.portal.service.AddressLocalServiceUtil;

public class EnterpriseEntity {

	private Enterprise enterprise;
	private List<Address> addressList;
	
	public EnterpriseEntity(Enterprise enterprise, long companyId) throws SystemException {
		this.enterprise = enterprise;
		addressList = AddressLocalServiceUtil.getAddresses(companyId, Enterprise.class.getName(), enterprise.getEnterpriseId());
	}
	
	public long getEnterpriseId() {
		return enterprise.getEnterpriseId();
	}
	
	public boolean isPrivate() {
		return enterprise.getIsPrivate() == 1;
	}
	
	public String getName() {
		return enterprise.getName();
	}
	
	public String getDescription() {
		return enterprise.getDescription();
	}
	
	public String getEmail() {
		return enterprise.getEmail();
	}
	
	public String getAbn() {
		return enterprise.getTaxid();
	}
	
	public long getIndustry() {
		return enterprise.getIndustry();
	}
	
	public String getStreet1() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getStreet1();
		}
		
		return "";
	}
	
	public String getStreet2() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getStreet2();
		}

		return "";
	}
	
	public String getSuburb() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getStreet3();
		}

		return "";
	}
	
	public long getCountryId() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getCountry().getCountryId();
		}

		return 0;
	}
	
	public String getPostalCode() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getZip();
		}
		
		return "";
	}
	
	public String getCity() {
		if (addressList != null && !addressList.isEmpty()) {
			return addressList.get(0).getCity();
		}

		return "";
	}
}
