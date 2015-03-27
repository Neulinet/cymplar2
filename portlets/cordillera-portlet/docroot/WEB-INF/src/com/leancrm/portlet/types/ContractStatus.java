package com.leancrm.portlet.types;

public enum ContractStatus {

	COLD(0, "Cold"),
	HOT(100, "Hot"),
	WORM(200, "Worm"),
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
}
