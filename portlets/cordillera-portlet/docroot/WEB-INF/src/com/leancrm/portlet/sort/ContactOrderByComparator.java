package com.leancrm.portlet.sort;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.leancrm.portlet.entity.Contact;

public class ContactOrderByComparator extends OrderByComparator {
	private static final long serialVersionUID = 6588274767747218981L;

	public ContactOrderByComparator(String orderByCol, String orderByType) {
		if ("desc".equalsIgnoreCase(orderByType)) {
			isDesc = true;
		} else {
			isDesc = false;
		}
		
		this.orderByCol = orderByCol;
	}
	

	@Override
	public int compare(Object obj1, Object obj2) {
		Contact contact1 = (Contact)obj1;
		Contact contact2 = (Contact)obj2;
		
		int result = 0;
		
		switch (orderByCol) {
		case "EnterpriseName": {
			result = contact1.getEnterpriseName().compareTo(contact2.getEnterpriseName());
			break;
		}
		case "FullName": {
			result = contact1.getFullName().compareTo(contact2.getFullName());
			break;
		}
		case "Contract": {
			result = contact1.getContractDescription().compareTo(contact2.getContractDescription());
			break;
		}
		case "Progress": {
			result = contact1.getContractProgress().compareTo(contact2.getContractProgress());
			break;
		}
		case "Status": {
			result = contact1.getContractStatus().compareTo(contact2.getContractStatus());
			break;
		}
		}

		if (isDesc) {
			//reverse result
			if (result > 0) {
				result = -1;
			} else if (result < 0) {
				result = 1;
			}
		}
		
		return result;
	}

	@Override
	public String getOrderBy() {
		return orderByCol + ((isDesc) ? " DESC" : "");
	}
	
	@Override
	public boolean isAscending() {
		return !isDesc;
	}
	
	private String orderByCol;
	private boolean isDesc;
}
