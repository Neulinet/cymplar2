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

package com.leancrm.portlet.invitationcolleagues.util;

import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.ContentUtil;
//import com.liferay.portal.util.PropsUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class InvitationUtil {

	public static String getEmailMessageBody(PortletPreferences preferences) {
		String emailMessageBody = preferences.getValue(
			"emailMessageBody", StringPool.BLANK);

		if (Validator.isNotNull(emailMessageBody)) {
			return emailMessageBody;
		}
		else {
			return ContentUtil.get("com/leancrm/portlet/invitationcolleagues/dependencies/email_message_body.tmpl");
		}
	}

	public static int getEmailMessageMaxRecipients() {
		return GetterUtil.getInteger(5);
	}

	public static String getEmailMessageSubject(
		PortletPreferences preferences) {

		String emailMessageSubject = preferences.getValue(
			"emailMessageSubject", StringPool.BLANK);

		if (Validator.isNotNull(emailMessageSubject)) {
			return emailMessageSubject;
		}
		else {
			return ContentUtil.get("com/leancrm/portlet/invitationcolleagues/dependencies/email_message_subject.tmpl");
		}
	}

}