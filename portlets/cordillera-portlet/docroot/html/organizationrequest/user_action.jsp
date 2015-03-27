<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
User pendingUser = (User) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL  name="acceptUser" var="acceptUserURL">
		<portlet:param name="userId" value="<%=String.valueOf(pendingUser.getUserId()) %>"></portlet:param>
	</portlet:actionURL>
	<liferay-ui:icon image="add_user" message="Accept" url="<%=acceptUserURL.toString() %>"/>
	
	<portlet:actionURL  name="ignoreUser" var="ignoreUserURL">
		<portlet:param name="userId" value="<%=String.valueOf(pendingUser.getUserId()) %>"></portlet:param>
	</portlet:actionURL>
	<liferay-ui:icon image="deactivate" message="Ignore" url="<%=ignoreUserURL.toString() %>"/>
</liferay-ui:icon-menu>