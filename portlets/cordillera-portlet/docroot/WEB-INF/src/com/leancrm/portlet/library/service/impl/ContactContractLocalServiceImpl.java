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

import com.leancrm.portlet.library.model.ContactContract;
import com.leancrm.portlet.library.service.base.ContactContractLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact contract local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.ContactContractLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.ContactContractLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.ContactContractLocalServiceUtil
 */
public class ContactContractLocalServiceImpl
	extends ContactContractLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.ContactContractLocalServiceUtil} to access the contact contract local service.
	 */
	
	public List<ContactContract> getContactContract(Long contactId, Long contractId) {
		try {
			return contactContractPersistence.findByContactContract(contactId, contractId);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ContactContract> getByContact(Long contactId) {
		try {
			return contactContractPersistence.findByContact(contactId);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ContactContract> getByContract(Long contractId) {
		try {
			return contactContractPersistence.findByContract(contractId);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
}