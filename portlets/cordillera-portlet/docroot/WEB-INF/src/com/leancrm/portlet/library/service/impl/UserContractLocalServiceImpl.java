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

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.ContractConstants;
import com.leancrm.portlet.library.model.UserContract;
import com.leancrm.portlet.library.model.impl.UserContractImpl;
import com.leancrm.portlet.library.service.base.UserContractLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

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
	private Logger logger = Logger.getLogger(UserContractLocalServiceImpl.class);
	
	public UserContract addUserContract(long userId, long contractId, int accessLevel) throws SystemException {
		
		// TODO check different cases:
		// 1. Only one owner allowed - so, then we add userContract with owner access level - we should remove
		// 2. Only one pair user<->contract allowed - so, if we already have related between them - it should be updated - not the new added
		
		if (accessLevel == ContractConstants.ACCESS_OWNER) {
			// check - does this contract already has owner?
			List<UserContract> userContracts = userContractPersistence.findByContractAccess(contractId, ContractConstants.ACCESS_OWNER);
			UserContract sameUserContract = null;
			
			// if has - remove all of them (except itself)
			for (UserContract userContractToCheck : userContracts) {
				if (userContractToCheck.getUserId() != userId) {
					try {
						userContractPersistence.removeByUserContract(userContractToCheck.getUserId(), contractId);
					} catch (Exception ex) {
						logger.warn("Cannot remove user contract", ex);
					}
				} else {
					sameUserContract = userContractToCheck;
				}
			}
			
			if (sameUserContract != null) {
				return sameUserContract;
			}
		} 
		
		// check - do we already have record for this pair user <-> contract?
		UserContract userContractToCheck = null;
		try {
			userContractToCheck = userContractPersistence.findByUserContract(userId, contractId);
		} catch (Exception ex) {} // just ignore error here
		
		if (userContractToCheck != null) {
			// exists - check should we update or ignore
			if (userContractToCheck.getAccessLevel() == ContractConstants.ACCESS_OWNER) {
				logger.warn("Cannot reduce owner access level - first need reassign contract to some other user");
				return null;
			} else if (userContractToCheck.getAccessLevel() == accessLevel) {
				// change to same level - do not do anything
				return userContractToCheck;
			} else {
				userContractToCheck.setAccessLevel(accessLevel);
				userContractToCheck.setModifiedDate(new Date());
				userContractPersistence.update(userContractToCheck);
				
				return userContractToCheck;
			}
		}
		

		/// add new user <-> contract relation
		UserContract userContract = new UserContractImpl();
		
		userContract.setUserId(userId);
		userContract.setContractId(contractId);
		userContract.setActive(true);
		userContract.setAccessLevel(accessLevel);
		
		Date now = new Date();
		userContract.setCreateDate(now);
		userContract.setModifiedDate(now);
		
		return userContractPersistence.update(userContract);
	}
	
	@Override
	public UserContract getByUserContract(long userId, long contractId) {
		try {
			UserContract userContract = userContractPersistence.findByUserContract(userId, contractId);
			return userContract;
		} catch (Exception e) {
			logger.error("getContractByUser method: " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public User getContractOwner(long contractId) {
		try {
			List<UserContract> userContracts = userContractPersistence.findByContractAccess(contractId, ContractConstants.ACCESS_OWNER);
			
			if (userContracts.size() < 1) {
				logger.warn("Cannot find owner for contract " + contractId);
				return null;
			}
			
			if (userContracts.size() > 1) {
				logger.warn("Found more then 1 owner for contract " + contractId);
			}
			
			return UserLocalServiceUtil.getUser(userContracts.get(0).getUserId());
		} catch (Exception ex) {
			logger.error("Cannot find owner for contract " + contractId, ex);
		}
		
		return null;
	}
}