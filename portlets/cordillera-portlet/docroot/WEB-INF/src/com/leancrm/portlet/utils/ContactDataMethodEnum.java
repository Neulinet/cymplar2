package com.leancrm.portlet.utils;

public enum ContactDataMethodEnum {

	SKYPE(1000, "skype"),
	CELL_PHONE(1001, "cell_phone"),
	EMAIL(1003, "email"),
	NAME(1004, "name"),
	ENTERPRISE(1002, "enterprise"),
	PHONE(1005, "phone"),
	POSITION(1006, "position"),
	PERSONAL_EMAIL(1007, "personal_email");
	
	
	private long methodId;
	private String methodName;
	
	private ContactDataMethodEnum(long methodId, String methodName) {
		this.methodId = methodId;
		this.methodName = methodName;
	}
	
	public long getMethodId() {
		return methodId;
	}
	
	public String getMethodName() {
		return methodName;
	}
}
