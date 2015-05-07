package com.leancrm.portlet.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Report;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;

public class AddressBookUtils {

	public static AddressBook getAddressBook(User user) {
		try {
			List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(user.getUserId());
			if (addressBookUserList != null && addressBookUserList.size() > 0) {
				return AddressBookLocalServiceUtil.getAddressBook(addressBookUserList.get(0).getAddressBookId());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}
		
		return null;
	}
	
	public static AddressBook getAddressBook(Organization organization) {
		try {
			List<AddressBookOrganization> addressBookOrganizationList = AddressBookOrganizationLocalServiceUtil.getAddressBookOrganizationList(organization.getOrganizationId());
			if (addressBookOrganizationList != null && addressBookOrganizationList.size() > 0) {
				return AddressBookLocalServiceUtil.getAddressBook(addressBookOrganizationList.get(0).getAddressBookId());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		return null;
	}
	
	public static List<Enterprise> getEnterprisesFromAddressBook(long addressBookId) throws PortalException, SystemException {
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookId);
		
		return getEnterprisesFromContacts(addressBookId, contactList);
	}

	/** Get enterprises from contacts
	 * 
	 * @param addressBookId
	 * @param contactList
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static List<Enterprise> getEnterprisesFromContacts(long addressBookId, List<Contact> contactList)  throws PortalException, SystemException {
		Map<Long, Enterprise> enterpriseMap = new HashMap<Long, Enterprise>();
		ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
		
		if (contactList != null) {
			for (Contact contact : contactList) {
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contact.getContactId(), contactDataMethod.getContactDataMethodId());
				
				if (contactData != null) {
					long enterpriseId = ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId()).getRefValue();
					if (!enterpriseMap.containsKey(enterpriseId)) {
						enterpriseMap.put(enterpriseId, EnterpriseLocalServiceUtil.getEnterprise(enterpriseId));
					}
				}
			}
		}
		
		return new ArrayList<Enterprise>(enterpriseMap.values());
	}
	
	
	public static List<Enterprise> getEnterprisesFromAddressBook(AddressBookUser addressBookUser) throws PortalException, SystemException {
		Map<Long, Enterprise> enterpriseMap = new HashMap<Long, Enterprise>();
		List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBookUser.getAddressBookId());
		if (contactList != null) {
			for (Contact contact : contactList) {
				// Otener el contact data que indique la empresa de este contact, de la lista de contact de el address book
				ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
				ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUser.getAddressBookId(), contact.getContactId(), contactDataMethod.getContactDataMethodId());
				if (contactData != null) {
					long enterpriseId = ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId()).getRefValue();
					if (!enterpriseMap.containsKey(enterpriseId)) {
						Organization organization = OrganizationUtils.getOrganizationByUser(addressBookUser.getUserId());
						Report report = ReportLocalServiceUtil.getLastReport(contact.getContactId(), enterpriseId, organization.getOrganizationId());
						if (report != null) {
							enterpriseMap.put(enterpriseId, EnterpriseLocalServiceUtil.getEnterprise(enterpriseId));
						}
					}
				}
			}
		}
		
		return new ArrayList<Enterprise>(enterpriseMap.values());
	}
}
