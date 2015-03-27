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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.service.base.ContactDataMethodLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact data method local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactDataMethodLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactDataMethodLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil
 */
public class ContactDataMethodLocalServiceImpl
	extends ContactDataMethodLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil} to access the contact data method local service.
	 */
	public ContactDataMethod addContactDataMethod(long companyId, String methodName, String methodTitle, int type) throws SystemException {
		
		ContactDataMethod contactDataMethod = contactDataMethodPersistence.create(counterLocalService.increment(ContactDataMethod.class.getName()));
		
		contactDataMethod.setCompanyId(companyId);
		contactDataMethod.setName(methodName);
		contactDataMethod.setTitle(methodTitle);
		contactDataMethod.setContactDataType(type);
		
		return contactDataMethodPersistence.update(contactDataMethod, false);
	}
	
	public List<ContactDataMethod> getAll() {
		try {
			return contactDataMethodPersistence.findAll();
		} catch (SystemException e) {
			return null;
		}
	}
	
	public ContactDataMethod getContactDataMethod(String contactDataMethodId) {
		try {
			long methodId = Long.parseLong(contactDataMethodId);
			return contactDataMethodPersistence.findByPrimaryKey(methodId);
		} catch (Exception e) {
			return null;
		}
	}
	
	public ContactDataMethod getContactDataMethodByName(String methodName) {
		try {
			List<ContactDataMethod> contactDataMethodList = contactDataMethodPersistence.findByName(methodName);
			if (contactDataMethodList != null && contactDataMethodList.size() > 0) {
				return contactDataMethodList.get(0);
			}
			
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Map<String, ContactDataMethod> getContactDataMethodMap() {
		Map<String, ContactDataMethod> contactDataMethodMap = new HashMap<String, ContactDataMethod>();
		
		List<ContactDataMethod> contactDataMethodList = getAll();
		
		if (contactDataMethodList != null) {
			for (ContactDataMethod method : contactDataMethodList) {
				contactDataMethodMap.put(method.getName(), method);
			}
		}
		
		return contactDataMethodMap;
	}
}