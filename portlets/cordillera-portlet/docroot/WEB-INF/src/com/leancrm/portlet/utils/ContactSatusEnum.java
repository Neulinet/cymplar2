package com.leancrm.portlet.utils;

public enum ContactSatusEnum {

	COLD(0),
	WARM(100),
	HOT(200),
	INACTIVE(300);
	
	private int statusCode;
	
	private ContactSatusEnum(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public static ContactSatusEnum getStatus(int code) {
		switch (code) {
		case 0: return COLD;
		case 100: return WARM;
		case 200: return HOT;
		default:
			return null;
		}
	}
}
