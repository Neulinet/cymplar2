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
import java.util.List;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContactData;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.impl.AddressBookContactDataImpl;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ContactDataLocalServiceBaseImpl;
import com.leancrm.portlet.utils.ContactDataType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactDataLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactDataLocalServiceUtil
 */
public class ContactDataLocalServiceImpl extends ContactDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactDataLocalServiceUtil} to access the contact data local service.
	 */
	
	public ContactData getContactData(long contactDataId) {
		ContactData contactData = null;
		try {
			contactData  = super.getContactData(contactDataId);
		} catch(Exception e) {
			contactData = null;
		}
		
		return contactData;
	}
	
	public ContactData addContactData(long companyId, ContactDataMethod contactDataMethod, long contactId, long addressBookId) throws SystemException, PortalException {
		ContactData contactData = contactDataPersistence.create(counterLocalService.increment(ContactData.class.getName()));
		
		contactData.setCompanyId(companyId);
		contactData.setContactDataMethodId(contactDataMethod.getContactDataMethodId());
		contactData.setContactDataType(contactDataMethod.getContactDataType());
		contactData.setContactId(contactId);
		contactData.setCreateDate(new Date());
		contactData.setModifiedDate(new Date());
		contactData.setReadOnly(false);
		
		AddressBookContactData addressBookContactData = new AddressBookContactDataImpl();
		addressBookContactData.setActive(true);
		addressBookContactData.setAddressBookId(addressBookId);
		addressBookContactData.setContactDataId(contactData.getContactDataId());
		
		AddressBookContactDataLocalServiceUtil.addAddressBookContactData(addressBookContactData);

		contactData = contactDataPersistence.update(contactData, false);
		
		return contactData;
	}
	
	public List<ContactData> getContactDataList(long contactId) throws SystemException {
		List<ContactData> contactDataList = new ArrayList<ContactData>();
		
		if (contactDataPersistence.findByContact(contactId) != null) {
			for (ContactData contactData : contactDataPersistence.findByContact(contactId)) {
				contactDataList.add(contactData);
			}
		}
		
		return contactDataList;
	}
	
	public List<ContactData> getContactDataList(long contactId, String methodName) throws SystemException, PortalException {
		List<ContactData> contactDataList = new ArrayList<ContactData>();
		
		if (contactDataPersistence.findByContact(contactId) != null) {
			for (ContactData contactData : contactDataPersistence.findByContact(contactId)) {
				ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactData.getContactDataMethodId());
				if (method.getName().equals(methodName)) {
					contactDataList.add(contactData);
				}
			}
		}
		
		return contactDataList;
	}
	
	public List<ContactData> getContactDataByMethod(long contactId, long methodId) throws SystemException {
		List<ContactData> contactDataList = new ArrayList<ContactData>();
		
		if (contactDataPersistence.findByContactAndMethod(contactId, methodId) != null) {
			for (ContactData contactData : contactDataPersistence.findByContactAndMethod(contactId, methodId)) {
				contactDataList.add(contactData);
			}
		}
		
		return contactDataList;
	}
	
	public void removeByContact(long contactId, long addressBookId) throws SystemException, PortalException {
		
		AddressBook addressBook = addressBookPersistence.fetchByPrimaryKey(addressBookId);
		List<ContactData> contactDataList = addressBookContactDataLocalService.getContactData(addressBook, contactId);

		for (ContactData contactData : contactDataList) {
			List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByContactData(contactData.getContactDataId());
			
			if (addressBookContactDataList != null && !addressBookContactDataList.isEmpty()) {
				if (addressBookContactDataList.size() == 1 && addressBookContactDataList.get(0).getAddressBookId() == addressBookId) {
					addressBookContactDataPersistence.remove(addressBookContactDataList.get(0));
					removeContactData(contactData);
				} else if (addressBookContactDataList.size() > 1) {
					for (AddressBookContactData addressBookContactData : addressBookContactDataList) {
						if (addressBookContactData.getAddressBookId() == addressBookId) {
							addressBookContactDataPersistence.remove(addressBookContactData);
						}
					}
				}
			} else { // Non AB contain this Contact data, No should be here
				removeContactData(contactData);
			}
		}
	}
	
	public void removeContactData(ContactData contactData) throws SystemException, PortalException {
		if (contactData != null) {
			if (contactData.getContactDataType() == ContactDataType.TEXT.ordinal()) {
				ContactDataTextLocalServiceUtil.removeContactDataText(contactData.getContactDataId());
			} else if (contactData.getContactDataType() == ContactDataType.REFERENCE.ordinal()) {
				ContactDataRefLocalServiceUtil.removeContactDataRef(contactData.getContactDataId());
			} else {
				ContactDataPhoneLocalServiceUtil.removeContactDataPhone(contactData.getContactDataId());
			}
			
			contactDataPersistence.remove(contactData.getContactDataId());
		}
	}
	
	public List<ContactData> getContactDataByMethod(long methodId) throws SystemException {
		return contactDataPersistence.findByMethod(methodId);
	}
	
	public ContactData setReadOnly(long contactDataId, boolean readOnly) throws PortalException, SystemException {
		ContactData contactData = ContactDataLocalServiceUtil.getContactData(contactDataId);
		if (contactData != null) {
			contactData.setReadOnly(readOnly);
			return contactDataPersistence.update(contactData, false);
		} else {
			return null;
		}
	}
	
	public void updateReadOnly(ContactData contactData) throws SystemException, PortalException {
		int total = AddressBookContactDataLocalServiceUtil.getAddressBookContactDatasCount(contactData.getContactDataId());
		if (total == 1) {
			contactData.setReadOnly(false);
			ContactDataLocalServiceUtil.updateContactData(contactData);
		} else if (total == 0) { // NO DEBIERA
			ContactDataLocalServiceUtil.removeContactData(contactData);
		}
	}
}