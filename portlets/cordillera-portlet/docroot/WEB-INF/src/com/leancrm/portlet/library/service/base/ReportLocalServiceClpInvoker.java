/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.leancrm.portlet.library.service.base;

import com.leancrm.portlet.library.service.ReportLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReportLocalServiceClpInvoker {
	public ReportLocalServiceClpInvoker() {
		_methodName0 = "addReport";

		_methodParameterTypes0 = new String[] {
				"com.leancrm.portlet.library.model.Report"
			};

		_methodName1 = "createReport";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteReport";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteReport";

		_methodParameterTypes3 = new String[] {
				"com.leancrm.portlet.library.model.Report"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchReport";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getReport";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getReports";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getReportsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateReport";

		_methodParameterTypes15 = new String[] {
				"com.leancrm.portlet.library.model.Report"
			};

		_methodName118 = "getBeanIdentifier";

		_methodParameterTypes118 = new String[] {  };

		_methodName119 = "setBeanIdentifier";

		_methodParameterTypes119 = new String[] { "java.lang.String" };

		_methodName124 = "addReport";

		_methodParameterTypes124 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"long", "double", "java.util.Date", "int", "long", "long"
			};

		_methodName125 = "addReport";

		_methodParameterTypes125 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"long", "double", "java.util.Date", "int", "long", "long",
				"java.util.Date"
			};

		_methodName126 = "updateUserOfReports";

		_methodParameterTypes126 = new String[] { "long", "long" };

		_methodName127 = "getReport";

		_methodParameterTypes127 = new String[] { "long", "long", "long" };

		_methodName128 = "getLastReport";

		_methodParameterTypes128 = new String[] { "long", "long", "long" };

		_methodName129 = "getLastReport";

		_methodParameterTypes129 = new String[] { "long" };

		_methodName130 = "getReportByContract";

		_methodParameterTypes130 = new String[] { "long" };

		_methodName131 = "searchReports";

		_methodParameterTypes131 = new String[] {
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "java.lang.Double",
				"java.lang.Double", "java.lang.Integer[][]", "java.util.Date",
				"java.util.Date"
			};

		_methodName132 = "searchConsultantReports";

		_methodParameterTypes132 = new String[] {
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "java.lang.Double",
				"java.lang.Double", "java.lang.Integer[][]", "java.util.Date",
				"java.util.Date"
			};

		_methodName133 = "countConsultantReports";

		_methodParameterTypes133 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "java.lang.Double",
				"java.lang.Double", "java.lang.Integer[][]", "java.util.Date",
				"java.util.Date"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ReportLocalServiceUtil.addReport((com.leancrm.portlet.library.model.Report)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ReportLocalServiceUtil.createReport(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ReportLocalServiceUtil.deleteReport(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ReportLocalServiceUtil.deleteReport((com.leancrm.portlet.library.model.Report)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ReportLocalServiceUtil.fetchReport(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ReportLocalServiceUtil.getReport(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ReportLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ReportLocalServiceUtil.getReports(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ReportLocalServiceUtil.getReportsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ReportLocalServiceUtil.updateReport((com.leancrm.portlet.library.model.Report)arguments[0]);
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return ReportLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			ReportLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return ReportLocalServiceUtil.addReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Double)arguments[7]).doubleValue(),
				(java.util.Date)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue());
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return ReportLocalServiceUtil.addReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Double)arguments[7]).doubleValue(),
				(java.util.Date)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue(), (java.util.Date)arguments[12]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			ReportLocalServiceUtil.updateUserOfReports(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return ReportLocalServiceUtil.getReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return ReportLocalServiceUtil.getLastReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return ReportLocalServiceUtil.getLastReport(((Long)arguments[0]).longValue());
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return ReportLocalServiceUtil.getReportByContract(((Long)arguments[0]).longValue());
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return ReportLocalServiceUtil.searchReports(((Integer)arguments[0]).intValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				(java.lang.Long)arguments[5], (java.lang.Double)arguments[6],
				(java.lang.Double)arguments[7],
				(java.lang.Integer[])arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return ReportLocalServiceUtil.searchConsultantReports(((Integer)arguments[0]).intValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				(java.lang.Long)arguments[5], (java.lang.Double)arguments[6],
				(java.lang.Double)arguments[7],
				(java.lang.Integer[])arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return ReportLocalServiceUtil.countConsultantReports((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				(java.lang.Double)arguments[5], (java.lang.Double)arguments[6],
				(java.lang.Integer[])arguments[7],
				(java.util.Date)arguments[8], (java.util.Date)arguments[9]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
}