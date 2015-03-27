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
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.AddressBookContactData;
import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.impl.AddressBookContactDataImpl;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.model.impl.AddressBookOrganizationImpl;
import com.leancrm.portlet.library.model.impl.AddressBookUserImpl;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.base.AddressBookLocalServiceBaseImpl;
import com.leancrm.portlet.sort.ContactComparator;
import com.leancrm.portlet.utils.AddressBookType;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the address book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.AddressBookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.AddressBookLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.AddressBookLocalServiceUtil
 */
public class AddressBookLocalServiceImpl extends AddressBookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.AddressBookLocalServiceUtil} to access the address book local service.
	 */
	public AddressBook addAddressBook(long companyId, long addressBookType) throws SystemException {
		AddressBook addressBook = addressBookPersistence.create(counterLocalService.increment(AddressBook.class.getName()));
		
		addressBook.setCompanyId(companyId);
		addressBook.setCreateDate(new Date());
		addressBook.setModifiedDate(new Date());
		addressBook.setAddressBookType(addressBookType);
		
		return addressBookPersistence.update(addressBook, false);
	}
	
	public void addAddressBookOrganization(long organizationId, long companyId) throws SystemException {
		AddressBook addressBook = addAddressBook(companyId, AddressBookType.ORGANIZATION.getTypeId());
		
		AddressBookOrganization addressBookOrganization = new AddressBookOrganizationImpl();
		addressBookOrganization.setAddressBookId(addressBook.getAddressBookId());
		addressBookOrganization.setOrganizationId(organizationId);
		
		addressBookOrganizationPersistence.update(addressBookOrganization, false);
	}
	
	public void addAddressBookUser(long userId, long companyId) throws SystemException {
		AddressBook addressBook = addAddressBook(companyId, AddressBookType.USER.getTypeId());
		
		AddressBookUser addressBookUser = new AddressBookUserImpl();
		addressBookUser.setAddressBookId(addressBook.getAddressBookId());
		addressBookUser.setUserId(userId);
		
		addressBookUserPersistence.update(addressBookUser, false);
	}
	
	public List<Contact> getContacts(long addressBookId) throws PortalException, SystemException {
		List<Contact> contactList = new ArrayList<Contact>();
		
		List<AddressBookContact> addressBookContactList = AddressBookContactLocalServiceUtil.getByAddressBook(addressBookId);
		if (!ValidationsUtil.isEmpty(addressBookContactList)) {
			for (AddressBookContact addressBookContact : addressBookContactList) {
				contactList.add(ContactLocalServiceUtil.getContact(addressBookContact.getContactId()));
			}
		}
		
		return contactList;
	}
	
	public List<Contact> getContactsOrderByName(long addressBookId) throws PortalException, SystemException {
		List<Contact> contactList = getContacts(addressBookId);
		if (!ValidationsUtil.isEmpty(contactList)) {
			Collections.sort(contactList, new ContactComparator(AddressBookLocalServiceUtil.getAddressBook(addressBookId)));
		}
		
		return contactList;
	}
	
	public void addContact(long addressBookId, long contactId, long companyId) throws SystemException {
		AddressBookContact addressBookContact = new AddressBookContactImpl();
		addressBookContact.setAddressBookId(addressBookId);
		addressBookContact.setCompanyId(companyId);
		addressBookContact.setContactId(contactId);
		
		AddressBookContactLocalServiceUtil.addAddressBookContact(addressBookContact);
	}
	
	public void addContactData(long addressBookId, long contactDataId, long companyId) throws SystemException {
		AddressBookContactData addressBookContactData = new AddressBookContactDataImpl();
		addressBookContactData.setActive(true);
		addressBookContactData.setAddressBookId(addressBookId);
		addressBookContactData.setContactDataId(contactDataId);
		
		AddressBookContactDataLocalServiceUtil.addAddressBookContactData(addressBookContactData);
	}
	
	public void removeContactData(long addressBookId, long contactDataId) throws PortalException, SystemException {
		if (hasContactData(addressBookId, contactDataId)) {
			ContactData contactData = ContactDataLocalServiceUtil.getContactData(contactDataId);
			if (contactData != null && contactData.isReadOnly()) {
				AddressBookContactDataLocalServiceUtil.removeContactData(contactDataId, addressBookId);
				// Update isreadonly
			} else {
				AddressBookContactDataLocalServiceUtil.removeContactData(contactDataId, addressBookId);
				// delete from contactdata/Text/Ref/Phone
				// delete from contactdata
				
			}
		}
	}
	
	public boolean hasContact(long addressBookId, long contactId) {
		return AddressBookContactLocalServiceUtil.hasContact(addressBookId, contactId);
	}
	
	public boolean hasContactData(long addressBookId, long contactDataId) {
		return AddressBookContactDataLocalServiceUtil.hasContactData(addressBookId, contactDataId);
	}
}