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

import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.model.impl.UserContractImpl;
import com.leancrm.portlet.library.service.base.UserContractLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the user contract local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.UserContractLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.UserContractLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.UserContractLocalServiceUtil
 */
public class UserContractLocalServiceImpl
	extends UserContractLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.UserContractLocalServiceUtil} to access the user contract local service.
	 */
	
	public UserContract addUserContract(long userId, long contractId) throws SystemException {
		UserContract userContract = new UserContractImpl();
		userContract.setUserId(userId);
		userContract.setContractId(contractId);
		userContract.setActive(true);
		
		return userContractLocalService.addUserContract(userContract);
	}
	
	public Contract getByUserContract(long userId, long contractId) {
		try {
			List<UserContract> contracts = userContractPersistence.findByUserContract(userId, contractId);
			if (contracts != null && !contracts.isEmpty() && contracts.get(0).isActive()) {
				return contractLocalService.getContract(contracts.get(0).getContractId());
			}
		} catch (Exception e) {
			System.out.println("[ERROR] [UserContractLocalServiceImpl] getContractByUser method: " + e.getMessage());
		}
		return null;
	}
	
}