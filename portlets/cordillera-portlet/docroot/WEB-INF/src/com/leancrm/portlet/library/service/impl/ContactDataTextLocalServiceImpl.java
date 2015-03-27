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

import java.util.List;

import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.base.ContactDataTextLocalServiceBaseImpl;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact data text local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactDataTextLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactDataTextLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil
 */
public class ContactDataTextLocalServiceImpl
	extends ContactDataTextLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil} to access the contact data text local service.
	 */
	public ContactDataText addContactDataText(long contactDataId, String value) throws SystemException {
		ContactDataText contactDataText = contactDataTextPersistence.create(counterLocalService.increment(ContactDataText.class.getName()));
		contactDataText.setContactDataId(contactDataId);
		contactDataText.setValue(value);
		
		return contactDataTextPersistence.update(contactDataText, false);
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
	public void updateContactDataText(long contactId, ContactDataMethod contactDataMethod, String value, long addressBookId, long companyId) throws PortalException, SystemException {
		ContactData currentContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookId, contactId, contactDataMethod.getContactDataMethodId());
		
		if (!ValidationsUtil.isEmpty(value)) {
			if (currentContactData == null) {
				// ADD
				ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
				ContactDataTextLocalServiceUtil.addContactDataText(contactData.getContactDataId(), value);
			} else {
				if (currentContactData.isReadOnly()) {
					// REPLACE (REMOVE and ADD)
					AddressBookContactDataLocalServiceUtil.removeContactData(currentContactData.getContactDataId(), addressBookId);
					ContactData contactData = ContactDataLocalServiceUtil.addContactData(companyId, contactDataMethod, contactId, addressBookId);
					ContactDataTextLocalServiceUtil.addContactDataText(contactData.getContactDataId(), value);
				} else {
					// EDIT
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(currentContactData.getContactDataId());
					contactDataText.setValue(value);
					ContactDataTextLocalServiceUtil.updateContactDataText(contactDataText);
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
	
	public void removeContactDataText(long contactDataId) throws PortalException, SystemException {
		ContactDataText contactDataText = contactDataTextPersistence.findByPrimaryKey(contactDataId);
		if (contactDataText != null) {
			contactDataTextLocalService.deleteContactDataText(contactDataId);
		}
	}
}