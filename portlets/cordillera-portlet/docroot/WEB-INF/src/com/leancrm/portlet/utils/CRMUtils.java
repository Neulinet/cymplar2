package com.leancrm.portlet.utils;

import com.leancrm.portlet.validator.ValidationsUtil;

public class CRMUtils {

	public static String notNullValue(String s) {
		if (s==null) {
			return "";
		}
		return s;
	}
	
	public static int[] timeAsArray(String time) {
		int[] aTime = new int[2];
		aTime[0] = 0;
		aTime[1] = 0;
		if (!ValidationsUtil.isEmpty(time)) {
			aTime[0] = Integer.parseInt(time.substring(0, 2));
			aTime[1] = Integer.parseInt(time.substring(3, 5));
		}
		return aTime;
	}
	
	public static int[] dateAsArray(String date) {
		int[] aDate = new int[3];
		aDate[0] = 1;
		aDate[1] = 1;
		aDate[1] = 1900;
		if (!ValidationsUtil.isEmpty(date)) {
			aDate[0] = Integer.parseInt(date.substring(0, 2));
			aDate[1] = Integer.parseInt(date.substring(3, 5));
			aDate[2] = Integer.parseInt(date.substring(6, 10));
		}
		return aDate;
	}
}
