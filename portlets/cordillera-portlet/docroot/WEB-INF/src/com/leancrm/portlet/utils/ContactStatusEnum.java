package com.leancrm.portlet.utils;

public enum ContactStatusEnum {

	COLD(0),
	WARM(100),
	HOT(200),
	INACTIVE(300);
	
	private int statusCode;
	
	private ContactStatusEnum(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public static ContactStatusEnum getStatus(int code) {
		switch (code) {
		case 0: return COLD;
		case 100: return WARM;
		case 200: return HOT;
		case 300: return INACTIVE;
		default:
			return null;
		}
	}
}
