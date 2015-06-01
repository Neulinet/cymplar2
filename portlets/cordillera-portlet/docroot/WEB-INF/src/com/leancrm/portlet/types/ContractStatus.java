package com.leancrm.portlet.types;

public enum ContractStatus {

	COLD(0, "Cold"),
	WARM(100, "Warm"),
	HOT(200, "Hot"),
	INACTIVE(300, "Inactive");
	
	private int pow;
	private String label;
	
	private ContractStatus(int pow, String label) {
		this.pow = pow;
		this.label = label;
	}
	
	public int getPow() {
		return pow;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static ContractStatus getContractStatus(int pow) {
		for (ContractStatus status : values()) {
			if (status.getPow() == pow) {
				return status;
			}
		}
		
		return null;
	}
	
	public static ContractStatus getContractStatus(String name) {
		for (ContractStatus status : values()) {
			if (status.getLabel().equals(name)) {
				return status;
			}
		}
		
		return null;
	}
	
}
