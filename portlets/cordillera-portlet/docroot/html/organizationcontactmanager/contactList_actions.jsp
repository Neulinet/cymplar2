<%@ include file="/html/common/consultantInit.jsp" %>
<%@page import="com.leancrm.portlet.entity.ContactColleague"%>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ContactColleague c = (ContactColleague)row.getObject();

	if (c.getOwnerEmail() != null && !c.getOwnerEmail().isEmpty()) {
		String mailUrl = "mailto:" + c.getOwnerEmail();
%>
		<liferay-ui:icon-menu>
			<liferay-ui:icon image="reply" message="Send Email" url="<%=mailUrl %>" />
			<!-- liferay-ui:icon image="post" message="Request Lead" url="" / -->
		</liferay-ui:icon-menu>
<%	} else { %>
		Not Assigned
<%	} %>
