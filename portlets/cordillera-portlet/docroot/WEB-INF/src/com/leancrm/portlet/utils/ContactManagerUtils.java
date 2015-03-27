package com.leancrm.portlet.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataPhone;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ContactManagerUtils {
	
	private static Logger logger = Logger.getLogger(ContactManagerUtils.class);
	
	public static List<ContactInfo> getContactInfoList(long addressBookId) throws PortalException, SystemException {
		List<ContactInfo> contactInfoList = new ArrayList<ContactInfo>();
		
		List<AddressBookContact> aBookContacList = AddressBookContactLocalServiceUtil.getContactsByAddressBook(addressBookId);
		for (AddressBookContact aBookContact : aBookContacList) {
			contactInfoList.add(getContactInfo(aBookContact.getContactId(), aBookContact.getAddressBookId()));
		}
		
		return contactInfoList;
	}
	
	/**
	 * - Dado un usuario
	 * - Obtener la organizacion a la que pertenece
	 * - Obtener los contactos que esa organizacion tiene
	 * - Obtener los consultants de esa organizacion distinto al usuario parametro (collegues)
	 * - Obtener los contactos de estos consultants obtenidos
	 * 
	 * Tener en cuenta que contactos de igual id (contactId) pertenecientes a diferentes Address Book
	 * pueden tener distinta informacion.
	 * */
	public static List<ContactInfo> getColleaguesContacts(long userId) throws PortalException, SystemException {
		List<ContactInfo> resultContactList = new ArrayList<ContactInfo>();

		Organization userOrganization = OrganizationUtils.getOrganizationByUser(userId);
		if (userOrganization != null) {
			AddressBook organizationABook = AddressBookUtils.getAddressBook(userOrganization);
			
			if (organizationABook != null) {
				resultContactList.addAll(ContactManagerUtils.getContactInfoList(organizationABook.getAddressBookId()));
				
				List<User> colleagueList = UserLocalServiceUtil.getOrganizationUsers(userOrganization.getOrganizationId());
				for (User colleague : colleagueList) {
					if (colleague.getUserId() != userId) {
						AddressBook colleagueABook = AddressBookUtils.getAddressBook(colleague);
						if (colleagueABook != null) {
							resultContactList.addAll(ContactManagerUtils.getContactInfoList(colleagueABook.getAddressBookId()));
						} else {
							logger.info("User with id " + colleague.getUserId() + ", doesn't have an address book.");
						}
					}
				}
			} else {
				logger.info("Organization with id " + userOrganization.getOrganizationId() + ", doesn't have an address book.");
			}
		} else {
			logger.info("User with id " + userId + ", no belongs in any organization");
		}
		
		return resultContactList;
	}
	
	public static ContactInfo getContactInfo(long contactId, long addressBookId) throws SystemException, PortalException {
		ContactInfo contactInfo = new ContactInfo();
		
		AddressBook addressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookId);
		Map<String, ContactData> contactDataMap = AddressBookContactDataLocalServiceUtil.getContactDataGroupByMethod(addressBook, contactId);
		
		contactInfo.setContactId(String.valueOf(contactId));
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.ENTERPRISE.getMethodName())) {
			ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(contactDataMap.get(ContactDataMethodEnum.ENTERPRISE.getMethodName()).getContactDataId());
			Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(contactDataRef.getRefValue());
			contactInfo.setEnterpriseId(String.valueOf(enterprise.getEnterpriseId()));
			contactInfo.setEnterpriseName(enterprise.getName());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.NAME.getMethodName())) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataMap.get(ContactDataMethodEnum.NAME.getMethodName()).getContactDataId());
			contactInfo.setFullName(contactDataText.getValue());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.CELL_PHONE.getMethodName())) {
			ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactDataMap.get(ContactDataMethodEnum.CELL_PHONE.getMethodName()).getContactDataId());
			contactInfo.setCellPhone(contactDataPhone.getNumber());
			contactInfo.setCellPhoneExt(contactDataPhone.getExtension());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.PHONE.getMethodName())) {
			ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(contactDataMap.get(ContactDataMethodEnum.PHONE.getMethodName()).getContactDataId());
			contactInfo.setPhone(contactDataPhone.getNumber());
			contactInfo.setPhoneExt(contactDataPhone.getExtension());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.SKYPE.getMethodName())) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataMap.get(ContactDataMethodEnum.SKYPE.getMethodName()).getContactDataId());
			contactInfo.setSkype(contactDataText.getValue());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.POSITION.getMethodName())) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataMap.get(ContactDataMethodEnum.POSITION.getMethodName()).getContactDataId());
			contactInfo.setPosition(contactDataText.getValue());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.EMAIL.getMethodName())) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataMap.get(ContactDataMethodEnum.EMAIL.getMethodName()).getContactDataId());
			contactInfo.setEmail(contactDataText.getValue());
		}
		
		if (contactDataMap.containsKey(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName())) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataMap.get(ContactDataMethodEnum.PERSONAL_EMAIL.getMethodName()).getContactDataId());
			contactInfo.setPersonalEmail(contactDataText.getValue());
		}
		
		return contactInfo;
	}
	
	/**
	 * Construye un Mapa de parametros usando el nombre del metodo como clave y su valor como resultado
	 * @param actionRequest
	 * @param paramArray
	 * @return Map de parametros con metodos unicos
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static Map<String, String> buildParamMap(ActionRequest actionRequest, String[] paramArray) throws PortalException, SystemException {
		Map<String, String> paramMap = new HashMap<String, String>();
		
		for (String param : paramArray) {
			String methodNumber = ParamUtil.getString(actionRequest, param + "Method");
			ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethod(methodNumber);
			if (contactDataMethod != null) {
				String value = ParamUtil.getString(actionRequest, param);
				if (value != null && !value.trim().isEmpty()) {
					ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactDataMethod.getContactDataMethodId());
					paramMap.put(method.getName(), value);
				}
			}
		}
		
		return paramMap;
	}
//	
//	public static ContactData getContactData(long contactId, String contactMethodName) {
//		try {
//			List<ContactData> contactDataList = ContactDataLocalServiceUtil.getContactDataList(contactId, contactMethodName);
//			if (contactDataList != null && !contactDataList.isEmpty()) {
//				return contactDataList.get(0);
//			} else {
//				return null;
//			}
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public static boolean contacDataValueEqualTo(ContactData contactData, Object value) throws PortalException, SystemException {
//		if (contactData.getContactDataType() == ContactDataType.REFERENCE.ordinal()) {
//			ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId());
//			return contactDataRef != null && value.equals(contactDataRef.getRefValue());
//		} else {
//			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
//			return contactDataText != null && value.equals(contactDataText.getValue());
//		}
//	}
	
	/**
	 * @param companyId
	 * @param methodId
	 * @param contactId
	 * @param value
	 * @param addressBookId
	 * @throws PortalException
	 * @throws SystemException
	 */
//	public static ContactData addContactData(long companyId, ContactDataMethod contactDataMethod, long contactId, long addressBookId) throws PortalException, SystemException {
//		ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId);
//		
//		AddressBookContactData addressBookContactData = new AddressBookContactDataImpl();
//		addressBookContactData.setActive(true);
//		addressBookContactData.setAddressBookId(addressBookId);
//		addressBookContactData.setContactDataId(contactData.getContactDataId());
//		
//		AddressBookContactDataLocalServiceUtil.addAddressBookContactData(addressBookContactData);
//		
//		return contactData;
//	}
	
//	/**
//	 * Get current contact data based on method, addressBook and contactId
//	 * ADD if there is not current data or the current data is Read Only
//	 * 
//	 * EDIT if current value is not equal to the new value
//	 * 
//	 * REMOVE if current value exist, remove from the address book and if current value is not read only remove contact data
//	 * 
//	 * @param contactId
//	 * @param method
//	 * @param value
//	 * @param addressBookId
//	 * @param companyId
//	 * @throws PortalException
//	 * @throws SystemException
//	 */
//	public static void updateTextContactData(long contactId, ContactDataMethodEnum method, String value, long addressBookId, long companyId) throws PortalException, SystemException {
//		ContactData currentContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, method.getMethodName());
//		
//		if (!ValidationsUtil.isEmpty(value)) {
//			if (currentContactData == null) {
//				// ADD
//				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//				ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//				ContactDataTextLocalServiceUtil.addContactDataText(contactData.getContactDataId(), value);
//			} else {
//				if (currentContactData.isReadOnly()) {
//					// REPLACE (REMOVE and ADD)
//					AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//					ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//					ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//					ContactDataTextLocalServiceUtil.addContactDataText(contactData.getContactDataId(), value);
//				} else {
//					// EDIT
//					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(currentContactData.getContactDataId());
//					contactDataText.setValue(value);
//					ContactDataTextLocalServiceUtil.updateContactDataText(contactDataText);
//				}
//			}
//		} else if (currentContactData != null) {
//			// REMOVE
//			AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//			if (!currentContactData.isReadOnly()) {
//				ContactDataLocalServiceUtil.removeContactData(currentContactData);
//			} else {
//				ContactDataLocalServiceUtil.updateReadOnly(currentContactData);
//			}
//		}
//	}
	
//	/**
//	 * Get current contact data based on method, addressBook and contactId
//	 * ADD if there is not current data or the current data is Read Only
//	 * 
//	 * EDIT if current value is not equal to the new value
//	 * 
//	 * REMOVE if current value exist, remove from the address book and if current value is not read only remove contact data
//	 * 
//	 * @param contactId
//	 * @param method
//	 * @param value
//	 * @param addressBookId
//	 * @param companyId
//	 * @throws PortalException
//	 * @throws SystemException
//	 */
//	public static void updateRefContactData(long contactId, ContactDataMethodEnum method, String value, long addressBookId, long companyId) throws PortalException, SystemException {
//		ContactData currentContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, method.getMethodName());
//		
//		if (!ValidationsUtil.isEmpty(value)) {
//			if (currentContactData == null) {
//				// ADD
//				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//				ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//				ContactDataRefLocalServiceUtil.addContactDataRef(contactData.getContactDataId(), Long.parseLong(value));
//			} else {
//				if (currentContactData.isReadOnly()) {
//					// REPLACE (REMOVE and ADD)
//					AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//					
//					ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//					ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//					ContactDataRefLocalServiceUtil.addContactDataRef(contactData.getContactDataId(), Long.parseLong(value));
//				} else {
//					// EDIT
//					ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(currentContactData.getContactDataId());
//					contactDataRef.setRefValue(Long.parseLong(value));
//					ContactDataRefLocalServiceUtil.updateContactDataRef(contactDataRef);
//				}
//			}
//		} else if (currentContactData != null) {
//			// REMOVE
//			AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//			if (!currentContactData.isReadOnly()) {
//				ContactDataLocalServiceUtil.removeContactData(currentContactData);
//			} else {
//				ContactDataLocalServiceUtil.updateReadOnly(currentContactData);
//			}
//		}
//	}
	
//	/**
//	 * Get current contact data based on method, addressBook and contactId
//	 * ADD if there is not current data or the current data is Read Only
//	 * 
//	 * EDIT if current value is not equal to the new value
//	 * 
//	 * REMOVE if current value exist, remove from the address book and if current value is not read only remove contact data
//	 * 
//	 * @param contactId
//	 * @param method
//	 * @param value
//	 * @param addressBookId
//	 * @param companyId
//	 * @throws PortalException
//	 * @throws SystemException
//	 */
//	public static void updatePhoneContactData(long contactId, ContactDataMethodEnum method, String number, String extension, long addressBookId, long companyId) throws PortalException, SystemException {
//		ContactData currentContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, method.getMethodName());
//		
//		if (!ValidationsUtil.isEmpty(number) && ValidationsUtil.isEmpty(extension)) {
//			if (currentContactData == null) {
//				// ADD
//				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//				ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//				ContactDataPhoneLocalServiceUtil.addContactDataPhone(contactData.getContactDataId(), number, extension);
//			} else {
//				if (currentContactData.isReadOnly()) {
//					// REPLACE (REMOVE and ADD)
//					AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//					
//					ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//					ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
//					ContactDataPhoneLocalServiceUtil.addContactDataPhone(contactData.getContactDataId(), number, extension);
//				} else {
//					// EDIT
//					ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(currentContactData.getContactDataId());
//					contactDataPhone.setNumber(number);
//					contactDataPhone.setExtension(extension);
//					ContactDataPhoneLocalServiceUtil.updateContactDataPhone(contactDataPhone);
//				}
//			}
//		} else if (currentContactData != null) {
//			// REMOVE
//			AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
//			if (!currentContactData.isReadOnly()) {
//				ContactDataLocalServiceUtil.removeContactData(currentContactData);
//			} else {
//				ContactDataLocalServiceUtil.updateReadOnly(currentContactData);
//			}
//		}
//	}
	
	/**
	 * Get current contact data based on method, addressBook and contactId
	 * ADD if there is not current data or the current data is Read Only
	 * 
	 * EDIT if current value is not equal to the new value
	 * 
	 * REMOVE if current value exist, remove from the address book and if current value is not read only remove contact data
	 * 
	 * @param contactId
	 * @param method
	 * @param value
	 * @param addressBookId
	 * @param companyId
	 * @throws PortalException
	 * @throws SystemException
	 */
//	public static void updateContactData(long contactId, ContactDataMethodEnum method, String value, long addressBookId, long companyId) throws PortalException, SystemException {
//		List<ContactData> currentContactDataList = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, method.getMethodName());
//		//ContactData currentContactData = ContactManagerUtils.getContactData(contactId, method.getMethodName());
//		if (!ValidationsUtil.isEmpty(value)) {
//			if (currentContactDataList.isEmpty() || currentContactDataList.get(0).isReadOnly()) {
//				// ADD
//				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(method.getMethodName());
//				addContactData(companyId, contactDataMethod, contactId, value, addressBookId);						
//			} else if (! ContactManagerUtils.contacDataValueEqualTo(currentContactDataList.get(0), value)) {
//				// EDIT
//				if (currentContactDataList.get(0).getContactDataType() == ContactDataType.TEXT.ordinal()) {
//					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(currentContactDataList.get(0).getContactDataId());
//					contactDataText.setValue(value);
//					ContactDataTextLocalServiceUtil.updateContactDataText(contactDataText);
//				} else {
//					ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(currentContactDataList.get(0).getContactDataId());
//					contactDataRef.setRefValue(Long.parseLong(value));
//					ContactDataRefLocalServiceUtil.updateContactDataRef(contactDataRef);
//				}
//			}
//		} else if (!currentContactDataList.isEmpty()) {
//			// REMOVE
//			AddressBookContactDataLocalServiceUtil.removeContactData(currentContactDataList.get(0).getContactDataId(), addressBookId);
//			if (!currentContactDataList.get(0).isReadOnly()) {
//				ContactDataLocalServiceUtil.removeContactData(currentContactDataList.get(0));
//			} else {
//				updateReadOnly(currentContactDataList.get(0));
//			}
//		}
//	}
	
}
