package com.leancrm.portlet.validator;

public class CompanyValidator extends MessageContainer {

	public boolean validateCompanyName(String companyName) {
		boolean isValid = true;
		
		if (ValidationsUtil.isEmpty(companyName)) {
			addMessage(ErrorKeyword.COMPANY_INVALID);
			isValid = false;
		}
		
		return isValid;
	}
	
	public boolean validateAddress(String countryId, String regionId, String postalCode, String city, String street1, String street2, String street3) {
		boolean isValid = true;
		
		if (!ValidationsUtil.isLong(countryId) || !ValidationsUtil.isCountry(Long.parseLong(countryId))) {
			addMessage(ErrorKeyword.COUNTRY_INVALID);
			isValid = false;
		}
		
		if (ValidationsUtil.isEmpty(postalCode)) {
			addMessage(ErrorKeyword.POSTAL_CODE_INVALID);
			isValid = false;
		}
		
		if (ValidationsUtil.isEmpty(city)) {
			addMessage(ErrorKeyword.CITY_INVALID);
			isValid = false;
		}
		
		if (ValidationsUtil.isEmpty(street1)) {
			addMessage(ErrorKeyword.STREET_INVALID);
			isValid = false;
		}
		
		return isValid;
	}
}
