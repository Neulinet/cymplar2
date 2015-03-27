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

package com.leancrm.portlet.library.service.messaging;

import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ClpSerializer;
import com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactContractLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.IndustryLocalServiceUtil;
import com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil;
import com.leancrm.portlet.library.service.OrganizationIndustryLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AddressBookLocalServiceUtil.clearService();

			AddressBookContactLocalServiceUtil.clearService();

			AddressBookContactDataLocalServiceUtil.clearService();

			AddressBookOrganizationLocalServiceUtil.clearService();

			AddressBookUserLocalServiceUtil.clearService();

			ColleagueAddressBookContactLocalServiceUtil.clearService();

			ContactLocalServiceUtil.clearService();

			ContactContractLocalServiceUtil.clearService();

			ContactDataLocalServiceUtil.clearService();

			ContactDataMethodLocalServiceUtil.clearService();

			ContactDataPhoneLocalServiceUtil.clearService();

			ContactDataRefLocalServiceUtil.clearService();

			ContactDataTextLocalServiceUtil.clearService();

			ContractLocalServiceUtil.clearService();

			EnterpriseLocalServiceUtil.clearService();

			IndustryLocalServiceUtil.clearService();

			MyAddressBookContactLocalServiceUtil.clearService();

			NextFollowUpEventLocalServiceUtil.clearService();

			OrganizationIndustryLocalServiceUtil.clearService();

			ReportLocalServiceUtil.clearService();

			UserContractLocalServiceUtil.clearService();
		}
	}
}