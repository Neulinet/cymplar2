package com.leancrm.portlet.utils;

public enum CleanKey {
	REMOVE_CONTRACTS,
	REMOVE_REPORTS,
	REMOVE_CONTACTS,
	REMOVE_ADDRESS_BOOK,
	REMOVE_USER_GROUP;
	
	public static CleanKey getOptionClean(int ordinal) {
		return values()[ordinal];
	}
}

