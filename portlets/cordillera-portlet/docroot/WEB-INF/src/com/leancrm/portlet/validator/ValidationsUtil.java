package com.leancrm.portlet.validator;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.utils.ContactDataType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;


public class ValidationsUtil {

	private static Logger logger = Logger.getLogger(ValidationsUtil.class);
	
	public static boolean isDate(String s, SimpleDateFormat formatter) {
		try {
			formatter.parse(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Valida que el formato de un email sea el correcto
	 * @param email
	 * @return True si el formato del email es el correcto
	 */
	public static boolean validateEmail(String email, boolean mandatory) {
		if (email != null && !email.trim().isEmpty()) {
			if (lenghtLowerThan(email, 140)) {
				String emailpattern = "^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$"; 
				Pattern emailRE = Pattern.compile(emailpattern);
				return emailRE.matcher(email).matches();
			}
			
			return false;
		} else {
			return !mandatory;
		}
	}

	/**
	 * Valida que el contact position sea el correcto
	 * @param phone
	 * @return True si el contact position es correcto
	 */
	public static boolean validatePosition(String position, boolean mandatory) {
		if (position != null && !position.trim().isEmpty()) {
			return lenghtLowerThan(position, 140);
		} else {
			return !mandatory;
		}
	}
	
	/**
	 * Valida que el formato de un telefono sea el correcto
	 * @param phone
	 * @return True si el formato del telefono es el correcto
	 */
	public static boolean validatePhone(String phone, String phoneExt, boolean mandatory) {
		if (phone != null && !phone.trim().isEmpty() && phoneExt != null && !phoneExt.trim().isEmpty()) {
			if (lenghtLowerThan(phone+phoneExt, 140)) {
				String clrPhone = phone.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
				String numericpattern = "[0-9]+";
				Pattern phoneRE = Pattern.compile(numericpattern);
				return clrPhone.trim().length() < 15 && phoneRE.matcher(clrPhone).matches();
			}
			
			return false;
		} else {
			return !mandatory;
		}
	}
	
	/**
	 * Valida que el formato de skype sea correcto
	 * @param skype
	 * @param mandatory
	 * @param unique
	 * @return
	 */
	public static boolean validateSkype(String skype, boolean mandatory) {
		if (skype != null && !skype.trim().isEmpty()) {
			if (lenghtLowerThan(skype, 140)) {
				String skypePattern = "^[A-Za-z0-9._%+-]+";
				Pattern skypeRE = Pattern.compile(skypePattern);
				return skypeRE.matcher(skype).matches();
			}
			
			return false;
		} else {
			return !mandatory;
		}
	}
	
	public static boolean validateContactName(String contactName, boolean mandatory) {
		if (contactName != null && !contactName.trim().isEmpty()) {
			return lenghtLowerThan(contactName, 140);
		} else {
			return !mandatory;
		}
	}
	
	public static boolean isCellPhoneDuplicated(long userId, long contactId, String number, String extension) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod cellPhoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.CELL_PHONE.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), cellPhoneContactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactData.getContactDataId());
					if (contactDataPhone.getNumber().equals(number) && contactDataPhone.getExtension().equals(extension)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isHomePhoneDuplicated(long userId, long contactId, String number, String extension) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod phoneContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PHONE.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), phoneContactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactData.getContactDataId());
					if (contactDataPhone.getNumber().equals(number) && contactDataPhone.getExtension().equals(extension)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isWorkEmailDuplicated(long userId, long contactId, String email) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod emailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.EMAIL.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), emailContactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
					if (contactDataText.getValue().equals(email)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isPersonalEmailDuplicated(long userId, long contactId, String email) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod personalEmailContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), personalEmailContactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
					if (contactDataText.getValue().equals(email)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isSkypeDuplicated(long userId, long contactId, String skype) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod skypeContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.SKYPE.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), skypeContactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
					if (contactDataText.getValue().equals(skype)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isContactNameDuplicated(long userId, long contactId, long enterpriseId, String contactName) throws SystemException, PortalException {
		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(userId);
		AddressBookUser addressBookUser = addressBookUserList.get(0);
		
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		for (Contact contact : contactList) {
			if (contact.getContactId() != contactId) {
				ContactDataMethod enterpriseContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
				ContactData enterpriseContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), enterpriseContactDataMethod.getContactDataMethodId());
				
				ContactDataMethod nameContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
				ContactData nameContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), nameContactDataMethod.getContactDataMethodId());
			
				if (enterpriseContactData != null && nameContactData != null) {
					ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(enterpriseContactData.getContactDataId());
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(nameContactData.getContactDataId());
					
					if (contactDataRef.getRefValue() == enterpriseId && contactDataText.getValue().equalsIgnoreCase(contactName)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
//	public static boolean hasDuplicatedFields(long reqOwner, String reqContactId, String reqCellPhone, String reqCellPhoneExt, String reqEmail, String reqEnterpriseId, String reqFullName, 
//			String reqSkype, String reqPosition, String reqPhone, String reqPhoneExt, String reqPersonalEmail, List<String> errorList) throws SystemException, PortalException {
//		boolean hasDuplicated = false;
//
//		List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(reqOwner);
//			
//		AddressBookUser addressBookUser = addressBookUserList.get(0);
//		List<Contact> contactList = AddressBookContactLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
//		for (Contact contact : contactList) {
//			if ( !String.valueOf(contact.getContactId()).equals(reqContactId) ) {
//				boolean enterpriseEqual = false;
//				boolean contactNameEqual = false;
//				
//				AddressBook addressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookUser.getAddressBookId());
//				List<ContactData> contactDataList = AddressBookContactDataLocalServiceUtil.getContactData(addressBook, contact.getContactId());
//				for (ContactData contactData : contactDataList) {
//				
//					ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactData.getContactDataMethodId());
//					
//					if (ContactDataMethodEnum.CELL_PHONE.getMethodName().equals(method.getName())) {
//						String contactCellPhone = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
//						if (contactCellPhone.equals(reqCellPhoneExt + "_" + reqCellPhone)) {
//							errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_CELLPHONE);
//							hasDuplicated = true;
//						}
//					} else if (ContactDataMethodEnum.EMAIL.getMethodName().equals(method.getName())) {
//						String contactEmail = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
//						if (contactEmail.equals(reqEmail)) {
//							errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_EMAIL);
//							hasDuplicated = true;
//						}
//					} else if (ContactDataMethodEnum.ENTERPRISE.getMethodName().equals(method.getName())) {
//						long enterpriseId = ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId()).getRefValue();
//						if (String.valueOf(enterpriseId).equals(reqEnterpriseId)) {
//							if (contactNameEqual) {
//								errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_NAME);
//								hasDuplicated = true;
//							} else {
//								enterpriseEqual = true;
//							}
//						}
//					} else if (ContactDataMethodEnum.NAME.getMethodName().equals(method.getName())) {
//						if (reqFullName.equalsIgnoreCase(ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue())) {
//							if (enterpriseEqual) {
//								errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_NAME);
//								hasDuplicated = true;
//							} else {
//								contactNameEqual = true;
//							}
//						}
//					} else if (ContactDataMethodEnum.PHONE.getMethodName().equals(method.getName())) {
//						String contactPhone = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
//						if (contactPhone.equals(reqPhoneExt + "_" + reqPhone)) {
//							errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_PHONE);
//							hasDuplicated = true;
//						}
//					} else if (ContactDataMethodEnum.SKYPE.getMethodName().equals(method.getName())) {
//						String contactSkype = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
//						if (contactSkype.equals(reqSkype)) {
//							errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_SKYPE);
//							hasDuplicated = true;
//						}
//					} else if (ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName().equals(method.getName())) {
//						String contactPersonalEmail = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
//						if (contactPersonalEmail.equals(reqPersonalEmail)) {
//							errorList.add(LeancrmErrorKey.DUPLICATED_CONTACT_PERSONAL_EMAIL);
//							hasDuplicated = true;
//						}
//					}
//				}
//			}
//		}
//		
//		return hasDuplicated;
//	}
	
	public static boolean validateEnterpriseRequest(String reqEnterpriseName, String reqEnterpriseTaxId, String reqEnterpriseCountryId,
			String enterpriseDescription, String enterpriseEmail, String enterpriseIndustry, String enterpriseStreet1, String enterpriseStreet2, String enterpriseStreet3,
			String enterpriseZipCode, String enterpriseCity, boolean isPrivate, List<String> errorList) {
		boolean isEnterpriseValid = true;
		
		try {
			if (isEmpty(reqEnterpriseName) && !isPrivate) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise name empty");
				errorList.add(CRMErrorKey.EMPTY_ENTERPRISE_NAME);
			} else if (!lenghtLowerThan(reqEnterpriseName, 250)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise name too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			}
			
			if (!lenghtLowerThan(reqEnterpriseTaxId, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise taxid too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			}
			
			if (!lenghtLowerThan(enterpriseDescription, 250)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise description too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			}
			
			if (!lenghtLowerThan(enterpriseStreet1, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise street1 too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			} else if (isEmpty(enterpriseStreet1) && !isPrivate) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an empty enterprise street1");
				errorList.add(CRMErrorKey.EMPTY_ENTERPRISE_STREET1);
			}
			
			if (!lenghtLowerThan(enterpriseStreet2, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise street2 too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			}
			
			if (!lenghtLowerThan(enterpriseStreet3, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise street3 too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			}
			
			if (!lenghtLowerThan(enterpriseZipCode, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise zip code too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			} else if (isEmpty(enterpriseZipCode) && !isPrivate) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an empty enterprise zip code");
				errorList.add(CRMErrorKey.EMPTY_ENTERPRISE_ZIP_CODE);
			}
			
			if (!lenghtLowerThan(enterpriseCity, 70)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an enterprise city too long");
				errorList.add(CRMErrorKey.INPUT_TEXT_TOO_LONG);
			} else if (isEmpty(enterpriseCity) && !isPrivate) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an empty enterprise city");
				errorList.add(CRMErrorKey.EMPTY_ENTERPRISE_CITY);
			}
			
			if (!ValidationsUtil.validateEmail(enterpriseEmail, false)) {
				isEnterpriseValid = false;
				logger.warn("Tried to save an invalid enterprise email");
				errorList.add(CRMErrorKey.INVALID_ENTERPRISE_EMAIL);
			}
			
//			if (isEmpty(reqEnterpriseTaxId)) {
//				isEnterpriseValid = false;
//				logger.error("Tried to save a tax id empty");
//				errorList.add(LeancrmErrorKey.EMPTY_ENTERPRISE_TAXID);
//			} else {
//				List<Enterprise> registeredEnterpriseList = EnterpriseLocalServiceUtil.getEnterpriseByTax(reqEnterpriseTaxId);
//				if (registeredEnterpriseList != null && !registeredEnterpriseList.isEmpty()) {
//					isEnterpriseValid = false;
//					logger.warn("The taxid already exists in that country");
//					errorList.add(LeancrmErrorKey.DUPLICATED_ENTERPRISE_TAX_ID);
//				}
//			}
			
			if (isEmpty(reqEnterpriseCountryId) && !isPrivate) {
				isEnterpriseValid = false;    
				logger.error("Tried tov save a country id empty");
				errorList.add(CRMErrorKey.EMPTY_ENTERPRISE_COUNTRY);
			}
		} catch (Exception e) {
			logger.error("Unexpected error when verify an enterprise.", e);
			errorList.add(CRMErrorKey.UNEXPECTED_ERROR);
			isEnterpriseValid = false;
		}
		
		return isEnterpriseValid;
	}
	
	/**
	 * @param reqOwner
	 * @param reqContactId
	 * @param reqFullName
	 * @param reqCellPhone
	 * @param reqEmail
	 * @param reqSkype
	 * @param reqPosition
	 * @param reqPhone
	 * @param reqPersonalEmail
	 * @param errorList
	 * @return
	 */
	public static boolean validateContactRequest(long reqOwner, String reqContactId, String reqFullName, String reqCellPhone, String reqCellPhoneExt, String reqEmail, String reqSkype,
			String reqPosition, String reqPhone, String reqPhoneExt, String reqPersonalEmail, List<String> errorList) {
		
		boolean contactNameValid = validateContactName(reqFullName, true);
		if (!contactNameValid) errorList.add(CRMErrorKey.INVALID_CONTACT_NAME);
		boolean cellPhoneValid = validatePhone(reqCellPhone, reqCellPhoneExt, false);
		if (!cellPhoneValid) errorList.add(CRMErrorKey.INVALID_CONTACT_CELLPHONE);
		boolean emailValid = ValidationsUtil.validateEmail(reqEmail, false);
		if (!emailValid) errorList.add(CRMErrorKey.INVALID_CONTACT_EMAIL);
		boolean skypeValid = validateSkype(reqSkype, false);
		if (!skypeValid) errorList.add(CRMErrorKey.INVALID_CONTACT_SKYPE);
		boolean positionValid = validatePosition(reqPosition, false);
		if (!positionValid) errorList.add(CRMErrorKey.INVALID_CONTACT_POSITION);
		boolean phoneValid = validatePhone(reqPhone, reqPhoneExt, false);
		if (!phoneValid) errorList.add(CRMErrorKey.INVALID_CONTACT_PHONE);
		boolean personalEmailValid = ValidationsUtil.validateEmail(reqPersonalEmail, false);
		if (!personalEmailValid) errorList.add(CRMErrorKey.INVALID_CONTACT_PERSONAL_EMAIL);
		
		return contactNameValid 
				&& cellPhoneValid 
				&& emailValid 
				&& skypeValid
				&& positionValid
				&& phoneValid
				&& personalEmailValid;
	}
	
	public static boolean validateAditionalInfo(long userId, long contactId, long enterpriseId, String contactFullName, String cellPhone, String cellPhoneExt, String workEmail, 
			String skype, String position, String homePhone, String homePhoneExt, String personalEmail, List<String> errorList) throws SystemException, PortalException {
		
		boolean isValid = true;
		
		if (!validateContactName(contactFullName, true)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_NAME);
			isValid = false;
		} else if (isContactNameDuplicated(userId, contactId, enterpriseId, contactFullName)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_NAME);
			isValid = false;
		}
		
		if (!validatePhone(cellPhone, cellPhoneExt, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_CELLPHONE);
			isValid = false;
		} else if (isCellPhoneDuplicated(userId, contactId, cellPhone, cellPhoneExt)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_CELLPHONE);
			isValid = false;
		}
		
		if (!ValidationsUtil.validateEmail(workEmail, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_EMAIL);
			isValid = false;
		} else if (isWorkEmailDuplicated(userId, contactId, workEmail)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_EMAIL);
			isValid = false;
		}
		
		if (!validateSkype(skype, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_SKYPE);
			isValid = false;
		} else if (isSkypeDuplicated(userId, contactId, skype)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_SKYPE);
			isValid = false;
		}
		
		if (!validatePosition(position, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_POSITION);
			isValid = false;
		}
		
		if (!validatePhone(homePhone, homePhoneExt, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_PHONE);
			isValid = false;
		} else if (isHomePhoneDuplicated(userId, contactId, homePhone, homePhoneExt)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_PHONE);
			isValid = false;
		}
		
		if (!ValidationsUtil.validateEmail(personalEmail, false)) {
			errorList.add(CRMErrorKey.INVALID_CONTACT_PERSONAL_EMAIL);
			isValid = false;
		} else if (isPersonalEmailDuplicated(userId, contactId, personalEmail)) {
			errorList.add(CRMErrorKey.DUPLICATED_CONTACT_PERSONAL_EMAIL);
			isValid = false;
		}
		
		return isValid;
	}
	
	public static boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
	
	public static boolean isEmpty(List<?> value) {
		return value == null || value.isEmpty();
	}
	
	public static Long existContactDataMethod(long contactDataMethodId) {
		return existContactDataMethod(String.valueOf(contactDataMethodId));
	}
	
	public static Long existContactDataMethod(String contactDataMethodId) {
		try {
			if (!isEmpty(contactDataMethodId)) {
				Long id = Long.parseLong(contactDataMethodId);
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethod(id);
				if (contactDataMethod != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact data method with id " + contactDataMethodId);
		}
		
		return null;
	}
	
	public static Long existContactData(long contactDataId) {
		return existContactData(String.valueOf(contactDataId));
	}
	
	public static Long existContactData(String contactDataId) {
		try {
			if (!isEmpty(contactDataId)) {
				Long id = Long.parseLong(contactDataId);
				ContactData contactData = ContactDataLocalServiceUtil.getContactData(id);
				if (contactData != null) {
					ContactDataType type = ContactDataType.getType(contactData.getContactDataType());
					switch (type) {
						case PHONE:
							return existContactDataPhone(contactDataId);
						case REFERENCE:
							return existContactDataRef(contactDataId);
						case TEXT:
							return existContactDataText(contactDataId);
					}
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact data with id " + contactDataId);
		}
		
		return null;
	}
	
	public static Long existContactDataText(long contactDataId) {
		return existContactDataText(String.valueOf(contactDataId));
	}
	
	public static Long existContactDataText(String contactDataId) {
		try {
			if (!isEmpty(contactDataId)) {
				Long id = Long.parseLong(contactDataId);
				ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(id);
				if (contactDataText != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact data text with id " + contactDataId);
		}
		
		return null;
	}
	
	public static Long existContactDataRef(long contactDataId) {
		return existContactDataRef(String.valueOf(contactDataId));
	}
	
	public static Long existContactDataRef(String contactDataId) {
		try {
			if (!isEmpty(contactDataId)) {
				Long id = Long.parseLong(contactDataId);
				ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(id);
				if (contactDataRef != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact data ref with id " + contactDataId);
		}
		
		return null;
	}
	
	public static Long existContactDataPhone(long contactDataId) {
		return existContactDataPhone(String.valueOf(contactDataId));
	}
	
	public static Long existContactDataPhone(String contactDataId) {
		try {
			if (!isEmpty(contactDataId)) {
				Long id = Long.parseLong(contactDataId);
				ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(id);
				if (contactDataPhone != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact data phone with id " + contactDataId);
		}
		
		return null;
	}
	
	public static Long existContact(String contactId) {
		try {
			if (!isEmpty(contactId)) {
				Long id = Long.parseLong(contactId);
				Contact contact = ContactLocalServiceUtil.getContact(id);
				if (contact != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contact with id " + contactId);
		}
		
		return null;
	}
	
	public static Long existEnterprise(String enterpriseId) {
		try {
			if (!isEmpty(enterpriseId)) {
				Long id = Long.parseLong(enterpriseId);
				Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(id);
				if (enterprise != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get enterprise with id " + enterpriseId);
		}
		
		return null;
	}
	
	public static Long existContract(String contractId) {
		try {
			if (!isEmpty(contractId)) {
				Long id = Long.parseLong(contractId);
				Contract contract = ContractLocalServiceUtil.getContract(id);
				if (contract != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get contract with id " + contractId);
		}
		
		return null;
	}
	
	public static Long existUser(long userId) {
		return existUser(String.valueOf(userId));
	}
	
	public static Long existUser(String userId) {
		try {
			if (!isEmpty(userId)) {
				Long id = Long.parseLong(userId);
				User user = UserLocalServiceUtil.getUser(id);
				if (user != null) {
					return id;
				}
			}
		} catch (Exception e) {
			logger.warn("Exception when try to get user with id " + userId);
		}
		
		return null;
	}
	
	public static boolean isLong(String number) {
		try {
			Long.parseLong(number);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isCountry(long countryId) {
		try {
			Country country = CountryServiceUtil.getCountry(countryId);
			
			return country != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isRegion(long regionId) {
		try {
			Region region = RegionServiceUtil.getRegion(regionId);
			
			return region != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isCompany(long companyId) {
		try {
			Organization company = OrganizationLocalServiceUtil.getOrganization(companyId);
			
			return company != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isUserGroup(long userGroupId) {
		try {
			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(userGroupId);
			
			return userGroup != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean lenghtLowerThan(String s, int limit) {
		return s == null || s.length() < limit;
	}
}
