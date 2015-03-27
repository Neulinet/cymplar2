package com.leancrm.portlet.validator;

import java.util.List;

import com.leancrm.portlet.utils.CRMErrorKey;

public class ContractValidator {

	public static void validateContact(String contactIdParam, List<String> errorList) {
		Long contactId = ValidationsUtil.existContact(contactIdParam);
		if (contactId == null) {
			errorList.add(CRMErrorKey.INVALID_REPORT_CONTACT);
		}
	}
	
	public static void validateEnterprise(String enterpriseIdParam, List<String> errorList) {
		Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
		
		if (enterpriseId == null) {
			errorList.add(CRMErrorKey.INVALID_REPORT_ENTERPRISE);
		}
	}
	
	public static void validateDescription(String description, List<String> errorList) {
		if (ValidationsUtil.isEmpty(description)) {
			errorList.add(CRMErrorKey.EMPTY_CONTRACT_DESCRIPTION);
		}
	}
	
	public static void validateAmount(String amountParam, List<String> errorList) {
		if (ValidationsUtil.isEmpty(amountParam) || !ValidationsUtil.isDouble(amountParam)) {
			errorList.add(CRMErrorKey.INVALID_CONTRACT_AMOUNT);
		}
	}
	
	public static void validateContract(String contactId, String enterpriseId, String description, String amount, List<String> errorList) {
		validateContact(contactId, errorList);
		validateEnterprise(enterpriseId, errorList);
		validateDescription(description, errorList);
		validateAmount(amount, errorList);
	}
}
