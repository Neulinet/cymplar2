/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.leancrm.portlet.library.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class ContractFinderUtil {
	public static java.util.List<com.leancrm.portlet.library.model.Report> findConsultantReports(
		java.lang.Long userId, java.lang.Long enterpriseId,
		java.lang.Long contactId, java.lang.Long organizationId,
		java.lang.Long contractId, java.lang.Double fromProgress,
		java.lang.Double toProgress,
		java.util.List<java.lang.Integer> statusCodeList,
		java.util.Date fromDate, java.util.Date toDate, int order, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findConsultantReports(userId, enterpriseId, contactId,
			organizationId, contractId, fromProgress, toProgress,
			statusCodeList, fromDate, toDate, order, start, end);
	}

	public static long countConsultantReports(java.lang.Long userId,
		java.lang.Long enterpriseId, java.lang.Long contactId,
		java.lang.Long organizationId, java.lang.Long contractId,
		java.lang.Double fromProgress, java.lang.Double toProgress,
		java.util.List<java.lang.Integer> statusCodeList,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countConsultantReports(userId, enterpriseId, contactId,
			organizationId, contractId, fromProgress, toProgress,
			statusCodeList, fromDate, toDate);
	}

	public static java.util.List<com.leancrm.portlet.library.model.Contact> findConsultantContacts(
		long consultantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findConsultantContacts(consultantId);
	}

	public static java.util.List<com.leancrm.portlet.library.model.Contract> findConsultantContracts(
		long consultantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findConsultantContracts(consultantId);
	}

	public static ContractFinder getFinder() {
		if (_finder == null) {
			_finder = (ContractFinder)PortletBeanLocatorUtil.locate(com.leancrm.portlet.library.service.ClpSerializer.getServletContextName(),
					ContractFinder.class.getName());

			ReferenceRegistry.registerReference(ContractFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContractFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContractFinderUtil.class, "_finder");
	}

	private static ContractFinder _finder;
}