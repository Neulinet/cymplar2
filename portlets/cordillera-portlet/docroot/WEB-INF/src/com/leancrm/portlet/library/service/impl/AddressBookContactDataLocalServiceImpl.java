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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContactData;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.impl.AddressBookContactDataImpl;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.base.AddressBookContactDataLocalServiceBaseImpl;
import com.leancrm.portlet.utils.ContactDataType;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the address book contact data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.AddressBookContactDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.AddressBookContactDataLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil
 */
public class AddressBookContactDataLocalServiceImpl
	extends AddressBookContactDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil} to access the address book contact data local service.
	 */
	
	public void copyContactData(long contactDataId, long addressBookFrom, long addressBookTo) throws SystemException {
		List<AddressBookContactData> addressBookContactDataToList = addressBookContactDataPersistence.findByAddressBookContactData(addressBookTo, contactDataId);
		List<AddressBookContactData> addressBookContactDataFromList = addressBookContactDataPersistence.findByAddressBookContactData(addressBookFrom, contactDataId);
		
		if ( (addressBookContactDataToList == null || addressBookContactDataToList.isEmpty()) && (addressBookContactDataFromList != null && !addressBookContactDataFromList.isEmpty()) ) {
			AddressBookContactData addressBookContactData = new AddressBookContactDataImpl();
			addressBookContactData.setActive(addressBookContactDataFromList.get(0).getActive());
			addressBookContactData.setAddressBookId(addressBookFrom);
			addressBookContactData.setContactDataId(contactDataId);
			
			addressBookContactDataPersistence.update(addressBookContactData, false);
		}
	}
	
	/**
	 * Remove in cascade. 
	 * Remove all contact data related to an address book and remove all not read only contact data associated with this.
	 * @param addressBookId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removerContactDatas(long addressBookId) throws SystemException, PortalException {
		List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBook(addressBookId);
		
		if (addressBookContactDataList != null) {
			for (AddressBookContactData abContactData : addressBookContactDataList) {
				ContactData contactData = ContactDataLocalServiceUtil.getContactData(abContactData.getContactDataId());
				if (contactData != null && !contactData.isReadOnly()) {
					if (contactData.getContactDataType() == ContactDataType.REFERENCE.ordinal()) {
						ContactDataRefLocalServiceUtil.deleteContactDataRef(contactData.getContactDataId());
					} else if (contactData.getContactDataType() == ContactDataType.TEXT.ordinal()) {
						ContactDataTextLocalServiceUtil.deleteContactDataText(contactData.getContactDataId());
					}
					
					ContactDataLocalServiceUtil.removeContactData(contactData);
				}
				
				addressBookContactDataPersistence.remove(abContactData);
			}
		}
	}
	
	public void removeContactData(long contactDataId, long addressBookId) throws SystemException {
		List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBookContactData(addressBookId, contactDataId);
		if (!ValidationsUtil.isEmpty(addressBookContactDataList)) {
			for (AddressBookContactData addressBookContactData : addressBookContactDataList) {
				addressBookContactDataPersistence.remove(addressBookContactData);
			}
		}
	}
	
	public List<ContactData> getContactData(AddressBook addressBook, Long contactId) throws PortalException, SystemException {
		List<ContactData> contactDataList = getContactDataImpl(addressBook, contactId);
		
		if (contactDataList == null || contactDataList.isEmpty()) {
			AddressBook firstAddressBook = addressBookContactLocalService.getFirstAddressBook(contactId);
			if (firstAddressBook != null) {
				contactDataList = getContactDataImpl(firstAddressBook, contactId);
			}
		}
	
		return contactDataList;
	}

	public List<ContactData> getContactDataImpl(AddressBook addressBook, Long contactId) throws PortalException, SystemException {
		List<ContactData> contactDataList = new ArrayList<ContactData>();
	
		List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBook(addressBook.getAddressBookId());
		if (addressBookContactDataList != null && !addressBookContactDataList.isEmpty()) {
			for (AddressBookContactData addressBookContactData : addressBookContactDataList) {
				ContactData contactData = ContactDataLocalServiceUtil.getContactData(addressBookContactData.getContactDataId());
				
				if (contactData != null && contactId != null && contactId > 0 && contactId == contactData.getContactId()) {
					contactDataList.add(ContactDataLocalServiceUtil.getContactData(addressBookContactData.getContactDataId()));
				}
			}
		}
		
		return contactDataList;
	}
	
	public List<ContactData> getContactData(AddressBook addressBook) throws SystemException, PortalException {
		List<ContactData> contactDataList = new ArrayList<ContactData>();
		
		List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBook(addressBook.getAddressBookId());
		if (addressBookContactDataList != null && !addressBookContactDataList.isEmpty()) {
			for (AddressBookContactData addressBookContactData : addressBookContactDataList) {
				ContactData contactData = ContactDataLocalServiceUtil.getContactData(addressBookContactData.getContactDataId());
				if (contactData != null) {
					contactDataList.add(contactData);
				}
			}
		}
		
		return contactDataList;
	}
	
	/**
	 * Se supone que hay un contact data por method, si no fuera asi habria que reescribir esta funcion
	 * @param addressBook
	 * @param contactId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Map<String, ContactData> getContactDataGroupByMethod(AddressBook addressBook, Long contactId) throws PortalException, SystemException {
		Map<String, ContactData> contactDataMap = new HashMap<String, ContactData>();
		
		List<ContactData> ContactDataList = getContactData(addressBook, contactId);
		for (ContactData contactData : ContactDataList) {
			ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactData.getContactDataMethodId());
			contactDataMap.put(method.getName(), contactData);
		}
		
		return contactDataMap;
	}
	
	/**
	 * Consideramos que un Address Book contiene datos unicos sobre un contacto. Quiere decir por ejemplo
	 * que en un Address Book no habra dos telefonos de un mismo contacto, solo podra haber uno. No se
	 * pudo restringir esto desde el modelo de datos.
	 * 
	 * @param addressBookId
	 * @param contactId
	 * @param methodName
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public ContactData getContactData(long addressBookId, long contactId, long methodId) throws SystemException, PortalException {
		ContactData contactData = getContactDataImpl(addressBookId, contactId, methodId);
		if (contactData == null) {
			// try to get it from original address book
			AddressBook firstAddressBook = addressBookContactLocalService.getFirstAddressBook(contactId);
			if (firstAddressBook != null) {
				contactData = getContactDataImpl(firstAddressBook.getAddressBookId(), contactId, methodId);
			}
		}
		
		return contactData;
	}
	
	protected ContactData getContactDataImpl(long addressBookId, long contactId, long methodId) throws SystemException, PortalException {

		List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBook(addressBookId);
		if (addressBookContactDataList != null && !addressBookContactDataList.isEmpty()) {
			for (AddressBookContactData addressBookContactData : addressBookContactDataList) {
				ContactData contactData = ContactDataLocalServiceUtil.getContactData(addressBookContactData.getContactDataId());
				
				ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(contactData.getContactDataMethodId());
				if (contactData != null && contactId == contactData.getContactId() && method.getContactDataMethodId() == methodId ) {
					return contactData;
				}
			}
		}
		
		return null;
	}

	public int getAddressBookContactDatasCount(long contactDataId) {
		try {
			return addressBookContactDataPersistence.findByContactData(contactDataId).size();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public boolean hasContactData(long addressBookId, long contactDataId) {
		try {
			List<AddressBookContactData> addressBookContactDataList = addressBookContactDataPersistence.findByAddressBookContactData(addressBookId, contactDataId);
			return !ValidationsUtil.isEmpty(addressBookContactDataList);
		} catch (Exception e) {
			return false;
		}
	}
}