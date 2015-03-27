package com.leancrm.portlet.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.leancrm.portlet.utils.CRMErrorKey;

public class ReportValidator {

	private static Logger logger = Logger.getLogger(ReportValidator.class);
	
	public static void validateComments(String comments, List<String> errorList) {
		if (ValidationsUtil.isEmpty(comments) || !ValidationsUtil.lenghtLowerThan(comments, 500)) {
			errorList.add(CRMErrorKey.EMPTY_REPORT_COMMENT);
		}
	}
	
	public static void validateContact(String contactIdParam, List<String> errorList) {
		Long contactId = ValidationsUtil.existContact(contactIdParam);
		
		if (contactId == null) {
			errorList.add(CRMErrorKey.INVALID_REPORT_CONTACT);
		}
	}
	
	public static void validateContactData(String contactDataIdParam, List<String> errorList) {
		Long contactDataId = ValidationsUtil.existContactData(contactDataIdParam);
		
		if (contactDataId == null) {
			errorList.add(CRMErrorKey.INVALID_REPORT_CONTACTDATA);
		}
	}
	
	public static void validateEnterprise(String enterpriseIdParam, List<String> errorList) {
		Long enterpriseId = ValidationsUtil.existEnterprise(enterpriseIdParam);
		
		if (enterpriseId == null) {
			errorList.add(CRMErrorKey.INVALID_REPORT_ENTERPRISE);
		}
	}
	
	public static void validateContract(String contractIdParam, List<String> errorList) {
		Long contractId = ValidationsUtil.existContract(contractIdParam);
		
		if (contractId == null) {
			errorList.add(CRMErrorKey.INVALID_CONTRACT_SELECTED);
		}
	}
	
	public static void validateProgress(String progressParam, double lastProgress, List<String> errorList) {
		if (!ValidationsUtil.isDouble(progressParam)) {
			errorList.add(CRMErrorKey.INVALID_REPORT_PROGRESS);
		} else {
			double progress = Double.parseDouble(progressParam);
//			logger.info("Current Progress: " + lastProgress);
//			logger.info("New Progress: " + progress);
			if (progress < lastProgress) {
//				logger.info("Wrong progress");
				errorList.add(CRMErrorKey.LOWER_REPORT_PROGRESS);
			} else {
//				logger.info("Succcess progress");
			}
		}
	}
	
	public static void validateDate(String dateParam, Date lastDate, List<String> errorList) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		if (ValidationsUtil.isDate(dateParam, formatter)) {
			try {
				Date date = formatter.parse(dateParam);
				if (lastDate != null) {
//					logger.info("Current report date: " + formatter.format(lastDate));
				} else {
//					logger.info("No before report");
				}
//				logger.info("New report date: " + dateParam);
				if (lastDate != null && !date.equals(lastDate) && !date.after(lastDate)) {
//					logger.info("Result: es anterior. ERROR");
					errorList.add(CRMErrorKey.INVALID_REPORT_DATE);
				} else {
//					logger.info("Result: es posterior. OK");
				}
			} catch (ParseException e) {
				logger.error("Error validating the report date:"+dateParam, e);
				errorList.add(CRMErrorKey.UNEXPECTED_ERROR);
			}
		} else {
			errorList.add(CRMErrorKey.INVALID_REPORT_DATE);
		}
	}
	
	public static void validateReport(String contactDataId, String progress, double lastProgress, String date, Date lastDate, String comments, String status, List<String> errorList) {
		validateContactData(contactDataId, errorList);
		validateProgress(progress, lastProgress, errorList);
		validateDate(date, lastDate, errorList);
		validateComments(comments, errorList);
	}
}
