package com.leancrm.portlet.utils;

public enum AddressBookType {

	ORGANIZATION(0),
	USER(1);
	
	private int typeId;
	
	private AddressBookType(int typeId) {
		this.typeId = typeId;
	}
	
	public int getTypeId() {
		return typeId;
	}
}
