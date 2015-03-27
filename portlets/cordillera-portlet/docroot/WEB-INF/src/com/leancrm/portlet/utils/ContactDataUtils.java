package com.leancrm.portlet.utils;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;

public class ContactDataUtils {

	private static Logger logger = Logger.getLogger(ContactDataUtils.class);
	
	private static Long skypeMethodId;
	private static Long cellPhoneMethodId;
	private static Long emailMethodId;
	private static Long nameMethodId;
	private static Long enterpriseMethodId;
	private static Long phoneMethodId;
	private static Long positionMethodId;
	private static Long personalEmailMethodId;

	public static Long getContactDataMethodId(ContactDataMethodEnum methodEnum) {
		switch (methodEnum) {
		case SKYPE:
			if (skypeMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				skypeMethodId = contactDataMethod.getContactDataMethodId();
			}
			return skypeMethodId;
		case CELL_PHONE:
			if (cellPhoneMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				cellPhoneMethodId = contactDataMethod.getContactDataMethodId();
			}
			return cellPhoneMethodId;
		case EMAIL:
			if (emailMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				emailMethodId = contactDataMethod.getContactDataMethodId();
			}
			return emailMethodId;
		case NAME:
			if (nameMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				nameMethodId = contactDataMethod.getContactDataMethodId();
			}
			return nameMethodId;
		case ENTERPRISE:
			if (enterpriseMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				enterpriseMethodId = contactDataMethod.getContactDataMethodId();
			}
			return enterpriseMethodId;
		case PHONE:
			if (phoneMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				phoneMethodId = contactDataMethod.getContactDataMethodId();
			}
			return phoneMethodId;
		case POSITION:
			if (positionMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				positionMethodId = contactDataMethod.getContactDataMethodId();
			}
			return positionMethodId;
		case PERSONAL_EMAIL:
			if (personalEmailMethodId == null) {
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(methodEnum.getMethodName());
				personalEmailMethodId = contactDataMethod.getContactDataMethodId();
			}
			return personalEmailMethodId;
		default:
			return null;		
		}
	}
	
	public static String getContactDataVal(long contactId, long addressBookId, ContactDataMethodEnum method) {
		String value = null;
		try {
			long contactDataMethodId = getContactDataMethodId(method);
			ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, contactDataMethodId);
			if (contactData != null) {
//				logger.info("Contact Data Type: " + contactData.getContactDataType());
//				logger.info("Method Name: " + method.getMethodName());
				ContactDataType type = ContactDataType.getType(contactData.getContactDataType());
				switch (type) {
					case PHONE:
//						logger.info("case: PHONE");
						ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactData.getContactDataId());
						value = ContactDataPhoneLocalServiceUtil.getPhoneNumber(contactDataPhone);
						break;
					case REFERENCE:
//						logger.info("case: REFERENCE");
						ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId());
						value = String.valueOf(contactDataRef.getRefValue());
						break;
					case TEXT:
//						logger.info("case: TEXT");
						ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
						value = contactDataText.getValue();
						break;
					default: 
						value = "";
				}
			}
		} catch (Exception e) {
			logger.warn("Could not read contact data for the method " + method.getMethodName());
		}
		
		return value;
	}
}
