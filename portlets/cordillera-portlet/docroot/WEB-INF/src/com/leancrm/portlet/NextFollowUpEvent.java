package com.leancrm.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.NoSuchNextFollowUpEventException;
import com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil;
import com.leancrm.portlet.types.FollowUpEventStatus;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NextFollowUpEvent
 */
public class NextFollowUpEvent extends MVCPortlet {
 
	private static Logger logger = Logger.getLogger(NextFollowUpEvent.class);
	
	private void cleanSuccessMessage(ActionRequest actionRequest) {
		SessionMessages.add(actionRequest, "");
	}
	
	public void doneFollowUpEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
		long nextFollowUpEventId = -1;
		try {
			nextFollowUpEventId = ParamUtil.getLong(actionRequest, "nextFollowUpEventId");
			NextFollowUpEventLocalServiceUtil.updateStatus(nextFollowUpEventId, FollowUpEventStatus.COMPLETED.ordinal());
		} catch (NoSuchNextFollowUpEventException e) {
			logger.error("Could not found event with id: " + nextFollowUpEventId);
		} catch (SystemException e) {
			logger.error("Unexpected error.", e);
		}
		
		cleanSuccessMessage(actionRequest);
		actionResponse.setRenderParameter("jspPage", "/html/nextfollowupevent/view.jsp");
	}
	
	public void cancelFollowUpEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
		long nextFollowUpEventId = -1;
		try {
			nextFollowUpEventId = ParamUtil.getLong(actionRequest, "nextFollowUpEventId");
			NextFollowUpEventLocalServiceUtil.updateStatus(nextFollowUpEventId, FollowUpEventStatus.CANCELED.ordinal());
		} catch (NoSuchNextFollowUpEventException e) {
			logger.error("Could not found event with id: " + nextFollowUpEventId);
		} catch (SystemException e) {
			logger.error("Unexpected error.", e);
		}
		
		cleanSuccessMessage(actionRequest);
		SessionMessages.add(actionRequest, "");
		actionResponse.setRenderParameter("jspPage", "/html/nextfollowupevent/view.jsp");
	}
}
