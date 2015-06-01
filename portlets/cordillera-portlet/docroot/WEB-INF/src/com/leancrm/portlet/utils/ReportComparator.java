package com.leancrm.portlet.utils;

import java.util.Comparator;

import org.apache.commons.lang.time.DateUtils;

import com.leancrm.portlet.library.model.Report;
import com.liferay.portal.kernel.util.DateUtil;

public class ReportComparator implements Comparator<Report> {
	public static final int ASC = 1;
	public static final int DESC = -1;
	
	private int order = ASC;
	
	public ReportComparator(int order) {
		this.order = order;
	}
	
	@Override
	public int compare(Report r1, Report r2) {
		return DateUtil.compareTo(r1.getReportDate(),r2.getReportDate()) * order;
	}
}
