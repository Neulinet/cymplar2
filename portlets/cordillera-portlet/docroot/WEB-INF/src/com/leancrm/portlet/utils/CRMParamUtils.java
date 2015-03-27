package com.leancrm.portlet.utils;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class CRMParamUtils {

	public static void copyRequestParameters(ActionRequest actionRequest, String... params) {
		for (String paramName :  params) {
			String value = ParamUtil.getString(actionRequest, paramName);
			actionRequest.setAttribute(paramName, value);
		}
	}
	
	public static String getCheckboxValue(int value) {
		return value == 1 ? "on" : "";
	}
}
