package com.leancrm.portlet.sort;

import java.util.Comparator;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ContactComparator implements Comparator<Contact> {

	private AddressBook addressBook;
	
	public ContactComparator(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
	@Override
	public int compare(Contact c1, Contact c2) {

		try {
			ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
			
			ContactData contactName1;
		
			contactName1 = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), c1.getContactId(), contactDataMethod.getContactDataMethodId());
		
			ContactData contactName2 = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), c2.getContactId(), contactDataMethod.getContactDataMethodId());
			
			if (contactName1 != null) {
				if (contactName2 != null) {
					try {
						ContactDataText contactDataName1 = ContactDataTextLocalServiceUtil.getContactDataText(contactName1.getContactDataId());
						ContactDataText contactDataName2 = ContactDataTextLocalServiceUtil.getContactDataText(contactName2.getContactDataId());
						
						return contactDataName1.getValue().compareTo(contactDataName2.getValue());
					} catch (PortalException e) {
						return 0;
					} catch (SystemException e) {
						return 0;
					}
				} else {
					return 1;
				}
			} else {
				if (contactName2 != null) {
					return -1;
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
