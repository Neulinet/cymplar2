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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ContactLocalServiceBaseImpl;
import com.leancrm.portlet.library.service.persistence.ContractFinderUtil;
import com.leancrm.portlet.utils.ContactDataMethodEnum;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactLocalServiceUtil
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactLocalServiceUtil} to access the contact local service.
	 */
	public Contact addContact(long companyId) throws SystemException {
		Contact contact = contactPersistence.create(counterLocalService.increment(Contact.class.getName()));
		
		contact.setCompanyId(companyId);
		contact.setCreateDate(new Date());
		contact.setModifiedDate(new Date());
		
		return contactPersistence.update(contact);
	}
	
	public void removeContact(long contactId, long addressBookId) throws SystemException, PortalException {
		List<AddressBookContact> totalAddressBookContactList = addressBookContactPersistence.findByContact(contactId);
		
		if (totalAddressBookContactList != null && totalAddressBookContactList.size() > 0) {
			// SI ESTA SOLO EN EL ADDRESS BOOK EN CUESTION
			if (totalAddressBookContactList.size() == 1 && totalAddressBookContactList.get(0).getAddressBookId() == addressBookId) {
				addressBookContactPersistence.remove(totalAddressBookContactList.get(0)); // REMOVER DEL ADDRESS BOOK
				contactDataLocalService.removeByContact(contactId, addressBookId); // REMOVER CONTACT DATA'S
				contactPersistence.remove(contactId); // REMOVER CONTACT
			// SI ESTA EN MAS DE UN ADDRESS BOOK
			} else if (totalAddressBookContactList.size() > 1) {
				for (AddressBookContact addressBookContact : totalAddressBookContactList) {
					if (addressBookContact.getAddressBookId() == addressBookId) {
						addressBookContactPersistence.remove(totalAddressBookContactList.get(0));
						contactDataLocalService.removeByContact(contactId, addressBookId);
					}
				}
			}
		} else { // None AB contains this contact. Never should be here
			contactPersistence.remove(contactId);
		}
		
		// ACTUALIZAR CONTRATOS
	}
	
	public ContactDataText getName(long contactId, long addressBookId) throws PortalException, SystemException {
		ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
		ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, contactDataMethod.getContactDataMethodId());
		if (contactData != null) {
			return ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId());
		}
		
		return null;
	}

	/** Find contact for specified enterprise by name
	 * If several contacts found - first will be returned
	 * 
	 * TODO Replace to database select
	 * 
	 * @param userId
	 * @param addressBookId
	 * @param enterpriseId
	 * @param name
	 * @return
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	@Override
	public Contact findByName(long userId, long addressBookId, long enterpriseId, String name) throws SystemException, PortalException {
		ContactDataMethod enterpriseContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
		
		for (Contact contact : ContactLocalServiceUtil.getConsultantContacts(userId)) {
			ContactData contactDataEnterprise = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contact.getContactId(), enterpriseContactMethod.getContactDataMethodId());
			
			// compare enterprises
			if (contactDataEnterprise != null && enterpriseId == ContactDataRefLocalServiceUtil.getContactDataRef(contactDataEnterprise.getContactDataId()).getRefValue()) {
				String contactName = getName(contact.getContactId(), addressBookId).getValue();
				
				// compare names
				if (StringUtils.equals(contactName, name)) {
					return contact;
				}
			}
		}
		
		return null;
	}
	
	public ContactDataRef getEnterprise(long contactId, long addressBookId) throws PortalException, SystemException {
		ContactDataMethod contactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
		ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, contactDataMethod.getContactDataMethodId());
		if (contactData != null) {
			return ContactDataRefLocalServiceUtil.getContactDataRef(contactData.getContactDataId());
		}
		
		return null;
	}
	
	/**
	 * Clean Contacts.
	 * Remove contacts that don't have any contact data assigned.
	 * @throws SystemException
	 */
	public void cleanContacs() throws SystemException {
		List<Contact> contactList = contactPersistence.findAll();
		
		if (contactList != null) {
			for (Contact contact : contactList) {
				List<ContactData> contactDataList = ContactDataLocalServiceUtil.getContactDataList(contact.getContactId());
				if (contactDataList == null || contactDataList.isEmpty()) {
					contactPersistence.remove(contact);
				}
			}
		}
	}
	
	public List<ContactDataMethod> getContactMethodList(long contactId, long addressBookId) throws PortalException, SystemException {
		List<ContactDataMethod> contactDataMethodList = new ArrayList<ContactDataMethod>();
		
		AddressBook addressBook = addressBookLocalService.getAddressBook(addressBookId);
		List<ContactData> contactDataList = AddressBookContactDataLocalServiceUtil.getContactData(addressBook, contactId);
		if (contactDataList != null) {
			Map<Long, Boolean> methodAddedMap = new HashMap<Long, Boolean>();
			for (ContactData contactData : contactDataList) {
				if (!methodAddedMap.containsKey(contactData.getContactDataMethodId())) {
					contactDataMethodList.add(contactDataMethodPersistence.findByPrimaryKey(contactData.getContactDataMethodId()));
					methodAddedMap.put(contactData.getContactDataMethodId(), true);
				}
			}
		}
		
		return contactDataMethodList;
	}
	
	/** Return all contacts specified consultant has access (own contacts or contacts related to shared leads
	 * 
	 * @param consultantId
	 * @return
	 */
	@Override
	public List<Contact> getConsultantContacts(long consultantId) throws SystemException {
		return ContractFinderUtil.findConsultantContacts(consultantId);
	}
}