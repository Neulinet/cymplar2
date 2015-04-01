package com.leancrm.portlet.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class CustomFieldUtils {

	public static void setCustomValue(long companyId, String columnName, long userId, String value) throws PortalException, SystemException {
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoValueLocalServiceUtil.addValue(companyId, User.class.getName(), table.getName(), columnName, userId, value);
	}
	
	public static void setCustomValue(long companyId, String columnName, Organization org, String value) throws PortalException, SystemException {
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, Organization.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoValueLocalServiceUtil.addValue(companyId, Organization.class.getName(), table.getName(), columnName, org.getOrganizationId(), value);
	}
	public static void setCustomValue(long companyId, String columnName, Organization org, String[] value) throws PortalException, SystemException {
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, Organization.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoValueLocalServiceUtil.addValue(companyId, Organization.class.getName(), table.getName(), columnName, org.getOrganizationId(), value);
	}
	
	public static void setCustomValue(long companyId, String columnName, long userId, long value) throws PortalException, SystemException {
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoValueLocalServiceUtil.addValue(companyId, User.class.getName(), table.getName(), columnName, userId, value);
	}
	
	public static long getCustomValue(long companyId, String columnName, long userId) throws PortalException, SystemException {
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(companyId, User.class.getName(), table.getName(), columnName, userId);
		return value != null ? value.getLong() : -1;
	}
	
}
