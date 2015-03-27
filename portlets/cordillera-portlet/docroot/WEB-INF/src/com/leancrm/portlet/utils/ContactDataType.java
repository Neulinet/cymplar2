package com.leancrm.portlet.utils;

import org.apache.log4j.Logger;

public enum ContactDataType {

	TEXT, // 0
	REFERENCE, // 1
	PHONE; // 2

	private static Logger logger = Logger.getLogger(ContactDataType.class);
	
	private ContactDataType() {
	}
	
	public static ContactDataType getType(int ordinal) {
		try {
			return values()[ordinal];
		} catch (Exception e) {
			logger.warn("Error when try to get ContactDataType with ordinal: " + ordinal, e);
			return null;
		}
	}
	
	public static ContactDataType getType(String name) {
		for (ContactDataType type : values()) {
			if (type.name().equals(name)) {
				return type;
			}
		}
		
		return null;
	}
}
