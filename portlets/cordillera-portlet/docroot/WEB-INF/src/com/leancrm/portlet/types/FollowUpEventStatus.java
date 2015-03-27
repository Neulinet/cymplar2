package com.leancrm.portlet.types;

public enum FollowUpEventStatus {

	NONE("None"),
	PENDING("Pending"),
	COMPLETED("Completed"),
	CANCELED("Canceled")
	;
	
	private String label;
	
	private FollowUpEventStatus(String label) {
		
	}
	
	public String getLabel() {
		return label;
	}
}
