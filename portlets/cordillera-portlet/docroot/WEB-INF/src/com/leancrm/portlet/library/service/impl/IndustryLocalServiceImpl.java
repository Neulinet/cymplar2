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
import java.util.Comparator;
import java.util.List;

import com.leancrm.portlet.library.model.Industry;
import com.leancrm.portlet.library.service.base.IndustryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the industry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.IndustryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.IndustryLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.IndustryLocalServiceUtil
 */
public class IndustryLocalServiceImpl extends IndustryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.IndustryLocalServiceUtil} to access the industry local service.
	 */
	public Industry addIndustry(String name) throws SystemException {
		Industry industry = industryPersistence.create(counterLocalService.increment(Industry.class.getName()));
		industry.setName(name);
		
		return industryPersistence.update(industry, false);
	}
	
	public List<Industry> getAll() {
		try {
			return industryPersistence.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Industry> getAllOrdered() {
		try {
			List<Industry> industryList = new ArrayList<Industry>();
			industryList.addAll(industryPersistence.findAll());
			Collections.sort(industryList, new Comparator<Industry>() {
				public int compare(Industry i1, Industry i2) {
					return i1.getName().compareTo(i2.getName());
				}
			});
			
			return industryList;
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Industry> getIndustryByName(String name) {
		try {
			return industryPersistence.findByName(name);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
}