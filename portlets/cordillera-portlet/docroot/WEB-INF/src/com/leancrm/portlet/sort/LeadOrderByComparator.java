package com.leancrm.portlet.sort;

import com.leancrm.portlet.reportSearch.ReportResultItem;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class LeadOrderByComparator extends OrderByComparator {
	private static final long serialVersionUID = -8642827702606396268L;
	
	public LeadOrderByComparator(String orderByCol, String orderByType) {
		if ("desc".equalsIgnoreCase(orderByType)) {
			isDesc = true;
		} else {
			isDesc = false;
		}
		
		this.orderByCol = orderByCol;
	}
	

	@Override
	public int compare(Object obj1, Object obj2) {
		ReportResultItem lead1 = (ReportResultItem)obj1;
		ReportResultItem lead2 = (ReportResultItem)obj2;
		
		int result = 0;
		
		switch (orderByCol) {
		case "Date": {
			result = DateUtil.compareTo(lead1.getReportDate(), lead2.getReportDate());
			break;
		}
		case "Status": {
			result = lead1.getStatus().compareTo(lead2.getStatus());
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
