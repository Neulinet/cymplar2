<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portlet.calendar.service.persistence.CalEventFinderUtil"%>
<%@page import="com.liferay.portlet.calendar.service.persistence.CalEventUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEventConstants"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@ include file="/html/common/init.jsp" %>

<!-- FullCalendar -->
<div id="fullCalendar"></div>
<!-- END FullCalendar -->

<script>
var events = [];
</script>
<%
List<CalEvent> events = CalEventLocalServiceUtil.getEvents(user.getGroupId(), "appointment", 0, 10);
for (CalEvent e : events) {
	Calendar cal = Calendar.getInstance(TimeZoneUtil.getDefault(), LocaleUtil.getDefault());
	cal.setTime(e.getStartDate());
%>
	<script>
		var dd = new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)%>,0,0);
		events[events.length] = {
				title: '<%=e.getTitle() %>',
				start: new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)%>,0,0),
				end: new Date(<%=cal.get(Calendar.YEAR)%>,<%=cal.get(Calendar.MONTH)%>,<%=cal.get(Calendar.DAY_OF_MONTH)%>,<%=cal.get(Calendar.HOUR_OF_DAY)%>,<%=cal.get(Calendar.MINUTE)+30%>,0,0),
				url: 'javascript:showAppDetail("<%=e.getTitle() %>","<%=e.getDescription() %>","<%=cal.get(Calendar.DAY_OF_MONTH)%>/<%=cal.get(Calendar.MONTH)%>/<%=cal.get(Calendar.YEAR)%>")'
		};
	</script>
<%
} 
%>

<script>

$(function() {
	$('#fullCalendar').fullCalendar({
	    header: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'month,agendaWeek,agendaDay'
	    },
	    editable: false,
	    events: events
	});
});

function showAppDetail(title,description,startDate) {
	document.getElementById('calendarTitle').innerHTML = '<strong>Title: </strong>' + title;
	document.getElementById('calendarDescription').innerHTML = '<strong>Description: </strong>' + description;
	document.getElementById('calendarDate').innerHTML = '<strong>Date: </strong>' + startDate;
	document.getElementById("modales").click();
}
</script>