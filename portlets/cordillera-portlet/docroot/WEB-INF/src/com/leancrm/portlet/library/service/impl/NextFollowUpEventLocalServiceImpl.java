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

package com.leancrm.portlet.library.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.leancrm.portlet.library.NoSuchNextFollowUpEventException;
import com.leancrm.portlet.library.model.NextFollowUpEvent;
import com.leancrm.portlet.library.service.base.NextFollowUpEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the next follow up event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.leancrm.portlet.library.service.NextFollowUpEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leancrm.portlet.library.service.base.NextFollowUpEventLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil
 */
public class NextFollowUpEventLocalServiceImpl
	extends NextFollowUpEventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil} to access the next follow up event local service.
	 */
	
	public NextFollowUpEvent addNextFollowUpEvent(long contractId, long reportId, String title, String description, Date eventDate, long ownerId, int status) throws SystemException {
		NextFollowUpEvent nextFollowUpEvent = nextFollowUpEventPersistence.create(counterLocalService.increment(NextFollowUpEvent.class.getName()));
		nextFollowUpEvent.setContractId(contractId);
		nextFollowUpEvent.setCreateDate(new Date());
		nextFollowUpEvent.setDescription(description);
		nextFollowUpEvent.setEventDate(eventDate);
		nextFollowUpEvent.setOwnerId(ownerId);
		nextFollowUpEvent.setReportId(reportId);
		nextFollowUpEvent.setStatus(status);
		nextFollowUpEvent.setTitle(title);
		return nextFollowUpEventPersistence.update(nextFollowUpEvent);
	}
	
	public NextFollowUpEvent updateStatus(long nextFollowUpEventId, int status) throws NoSuchNextFollowUpEventException, SystemException {
		NextFollowUpEvent nextFollowUpEvent = nextFollowUpEventPersistence.findByPrimaryKey(nextFollowUpEventId);
		nextFollowUpEvent.setStatus(status);
		return nextFollowUpEventPersistence.update(nextFollowUpEvent);
	}
	
	public List<NextFollowUpEvent> getByStatus(long reportId, int status) throws SystemException {
		return nextFollowUpEventPersistence.findByReportStatus(reportId, status);
	}
	
	public NextFollowUpEvent getLastEventByStatus(long reportId, int status) throws SystemException {
		List<NextFollowUpEvent> events = new ArrayList<NextFollowUpEvent>(nextFollowUpEventPersistence.findByReportStatus(reportId, status));
		if (!events.isEmpty()) {
			Collections.sort(events, new Comparator<NextFollowUpEvent>() {
				public int compare(NextFollowUpEvent e1, NextFollowUpEvent e2) {
					return e1.getEventDate().compareTo(e2.getEventDate());
				}
			});
			return events.get(events.size()-1);
		}
		return null;
	}
}