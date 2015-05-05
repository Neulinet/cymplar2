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

/**
 * @author Brian Wing Shun Chan
 */
public interface ContractFinder {
	public java.util.List<com.leancrm.portlet.library.model.Report> findConsultantReports(
		java.lang.Long userId, java.lang.Long enterpriseId,
		java.lang.Long contactId, java.lang.Long organizationId,
		java.lang.Long contractId, java.lang.Double fromProgress,
		java.lang.Double toProgress, java.lang.Integer[] statusCodeList,
		java.util.Date fromDate, java.util.Date toDate, int order, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public long countConsultantReports(java.lang.Long userId,
		java.lang.Long enterpriseId, java.lang.Long contactId,
		java.lang.Long organizationId, java.lang.Long contractId,
		java.lang.Double fromProgress, java.lang.Double toProgress,
		java.lang.Integer[] statusCodeList, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;
}