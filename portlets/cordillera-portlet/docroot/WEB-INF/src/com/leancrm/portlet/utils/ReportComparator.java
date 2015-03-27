package com.leancrm.portlet.utils;

import java.util.Comparator;

import com.leancrm.portlet.library.model.Report;

public class ReportComparator implements Comparator<Report> {
	public static final int ASC = 1;
	public static final int DESC = -1;
	
	private int order = ASC;
	
	public ReportComparator(int order) {
		this.order = order;
	}
	
	@Override
	public int compare(Report r1, Report r2) {
		return r1.getReportDate().compareTo(r2.getReportDate()) * order;
	}
}
