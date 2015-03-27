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

import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataRef;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ContactDataRefLocalServiceBaseImpl;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact data ref local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactDataRefLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactDataRefLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil
 */
public class ContactDataRefLocalServiceImpl
	extends ContactDataRefLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil} to access the contact data ref local service.
	 */
	public ContactDataRef addContactDataRef(long contactDataId, long value) throws SystemException {
		ContactDataRef contactDataRef = contactDataRefPersistence.create(counterLocalService.increment(ContactDataRef.class.getName()));
		
		contactDataRef.setContactDataId(contactDataId);
		contactDataRef.setRefValue(value);
		
		return contactDataRefPersistence.update(contactDataRef, false);
	}
	
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
	public void updateContactDataRef(long contactId, ContactDataMethod contactDataMethod, String value, long addressBookId, long companyId) throws PortalException, SystemException {
		ContactData currentContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, contactDataMethod.getContactDataMethodId());
		
		if (!ValidationsUtil.isEmpty(value)) {
			if (currentContactData == null) {
				// ADD
				ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
				ContactDataRefLocalServiceUtil.addContactDataRef(contactData.getContactDataId(), Long.parseLong(value));
			} else {
				if (currentContactData.isReadOnly()) {
					// REPLACE (REMOVE and ADD)
					AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
					
					ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
					ContactDataRefLocalServiceUtil.addContactDataRef(contactData.getContactDataId(), Long.parseLong(value));
				} else {
					// EDIT
					ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(currentContactData.getContactDataId());
					contactDataRef.setRefValue(Long.parseLong(value));
					ContactDataRefLocalServiceUtil.updateContactDataRef(contactDataRef);
				}
			}
		} else if (currentContactData != null) {
			// REMOVE
			AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
			if (!currentContactData.isReadOnly()) {
				ContactDataLocalServiceUtil.removeContactData(currentContactData);
			} else {
				ContactDataLocalServiceUtil.updateReadOnly(currentContactData);
			}
		}
	}
	
	public void removeContactDataRef(long contactDataId) throws PortalException, SystemException {
		ContactDataRef contactDataRef = contactDataRefPersistence.findByPrimaryKey(contactDataId);
		if (contactDataRef != null) {
			contactDataRefLocalService.deleteContactDataRef(contactDataId);
		}
	}
}