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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.base.AddressBookContactLocalServiceBaseImpl;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the address book contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.AddressBookContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.AddressBookContactLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil
 */
public class AddressBookContactLocalServiceImpl
	extends AddressBookContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil} to access the address book contact local service.
	 */
	
	public void copyContact(long contactId, long addressBookFrom, long addressBookTo) throws SystemException {
		List<AddressBookContact> addressBookContactListFrom = addressBookContactPersistence.findByContactAddressBook(addressBookFrom, contactId);
		
		if ( !hasContact(addressBookTo, contactId) && hasContact(addressBookFrom, contactId) ) {
			AddressBookContact addressBookContact = new AddressBookContactImpl();
			addressBookContact.setAddressBookId(addressBookFrom);
			addressBookContact.setCompanyId(addressBookContactListFrom.get(0).getCompanyId());
			addressBookContact.setContactId(contactId);
			addressBookContact.setCurrentProgress(addressBookContactListFrom.get(0).getCurrentProgress());
			
			addressBookContactPersistence.update(addressBookContact, false);
		} 
	}
	
	/**
	 * Remove all contacts related to an address book.
	 * @param addressBookId
	 * @throws SystemException
	 */
	public void removeAddressBookContact(long addressBookId) throws SystemException {
		List<AddressBookContact> addressBookContactList = addressBookContactPersistence.findByAddressBook(addressBookId);
		
		if (addressBookContactList != null) {
			for (AddressBookContact addressBookContact : addressBookContactList) {
				addressBookContactPersistence.remove(addressBookContact);
			}
		}
	}
	
	public List<AddressBookContact> getByAddressBook(long addressBookId) throws SystemException, PortalException {
		return addressBookContactPersistence.findByAddressBook(addressBookId);
	}
	
	public List<AddressBookContact> getByContact(long contactId) throws SystemException {
		return addressBookContactPersistence.findByContact(contactId);
	}
	
	// borrar
	public List<Contact> getContacts(long addressBookId) throws SystemException, PortalException {
		List<Contact> contactList = new ArrayList<Contact>();
		
		List<AddressBookContact> addressBookContactList = addressBookContactPersistence.findByAddressBook(addressBookId);
		if (addressBookContactList != null && !addressBookContactList.isEmpty()) {
			for (AddressBookContact addressBookContact : addressBookContactList) {
				contactList.add(ContactLocalServiceUtil.getContact(addressBookContact.getContactId()));
			}
		}
		
		return contactList;
	}
	
	public List<AddressBookContact> getContactsByAddressBook(long addressBookId) throws SystemException, PortalException {
		List<AddressBookContact> addressBookContactList = new ArrayList<AddressBookContact>();
		
		addressBookContactList.addAll(addressBookContactPersistence.findByAddressBook(addressBookId));
		
		Collections.sort(addressBookContactList, new Comparator<AddressBookContact>() {
			public int compare(AddressBookContact contact1, AddressBookContact contact2) {
				try {
					ContactDataMethod nameContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
					ContactData contactDataName1 = AddressBookContactDataLocalServiceUtil.getContactData(contact1.getAddressBookId(), contact1.getContactId(), nameContactMethod.getContactDataMethodId());
					ContactData contactDataName2 = AddressBookContactDataLocalServiceUtil.getContactData(contact2.getAddressBookId(), contact2.getContactId(), nameContactMethod.getContactDataMethodId());
					
					if (contactDataName1 != null) {
						if (contactDataName2 != null) {
							String contactName1 = ContactDataTextLocalServiceUtil.getContactDataText(contactDataName1.getContactDataId()).getValue();
							String contactName2 = ContactDataTextLocalServiceUtil.getContactDataText(contactDataName2.getContactDataId()).getValue();
							return contactName1.compareTo(contactName2);
						} else {
							return 1;
						}
					} else {
						if (contactDataName2 != null) {
							return -1;
						} else {
							return 0;
						}
					}
				} catch (Exception e) {
					return 0;
				}
			}
		});
		
		return addressBookContactList;
	}

	public Map<Long, AddressBookContact> getContactsByAddressBookAsMap(long addressBookId) throws SystemException, PortalException {
		Map<Long, AddressBookContact> addressBookContactMap = new HashMap<Long, AddressBookContact>();
		
		for (AddressBookContact addressBookContact : addressBookContactPersistence.findByAddressBook(addressBookId)) {
			addressBookContactMap.put(addressBookContact.getAddressBookId(), addressBookContact);
		}
		
		return addressBookContactMap;
	}

	public int countAddressBook(long contactId) throws SystemException {
		return addressBookContactPersistence.findByContact(contactId).size();
	}
	
	public boolean hasContact(long addressBookId, long contactId) {
		try {
			List<AddressBookContact> addressBookContactList = addressBookContactPersistence.findByContactAddressBook(addressBookId, contactId);
			return !ValidationsUtil.isEmpty(addressBookContactList);
		} catch (Exception e) {
			return false;
		}
	}
}