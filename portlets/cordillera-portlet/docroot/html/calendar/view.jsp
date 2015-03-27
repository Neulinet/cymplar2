<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@ include file="/html/common/init.jsp" %>

<div id="myScheduler">&nbsp;</div>
<script>
YUI().use( 'aui-scheduler', function(Y) 
	{
		var events = [];
		
		<%
		List<CalEvent> events = CalEventLocalServiceUtil.getEvents(user.getGroupId(), "appointment", 0, 10);
		for (CalEvent e : events) {
			Calendar cal = Calendar.getInstance(TimeZoneUtil.getDefault(), LocaleUtil.getDefault());
			cal.setTime(e.getStartDate());
		%>
				var dd = new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)%>,0,0);
				events[events.length] = {
						content: 'Title: <%=e.getTitle() %>. Description: <%=e.getDescription() %>. Date: <%=cal.get(Calendar.DAY_OF_MONTH)%>/<%=cal.get(Calendar.MONTH)%>/<%=cal.get(Calendar.YEAR)%>',
						startDate: new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)%>,0,0),
						endDate: new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)+30%>,0,0),
				};
		<%
		} 
		%>

		var eventRecorder = new Y.SchedulerEventRecorder(); 
		var weekView = new Y.SchedulerWeekView(); 
		
		new Y.Scheduler( { 
			boundingBox: '#myScheduler', 
			date: new Date(), 
			eventRecorder: eventRecorder, 
			items: events, 
			render: true, 
			views: [weekView] 
		} ); 
	} 
);
</script>
