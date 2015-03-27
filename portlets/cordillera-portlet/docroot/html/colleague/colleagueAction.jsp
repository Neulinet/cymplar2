<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<portlet:actionURL name="showAssignRole" var="showAssignRoleURL" />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
User userRow = (User) row.getObject();

String assigneRolePopupJS = "javascript: showAssignRolePopup('" + showAssignRoleURL.toString() + "','" + userRow.getUserId() + "');";

boolean hasAdminPermission = permissionChecker.hasPermission(layout.getGroupId(), Role.class.getName(), PortalUtil.getUser(request).getCompanyId(), ActionKeys.ASSIGN_MEMBERS);
%>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit_draft" message="Messeage" url="" />

	<c:if test="<%=hasAdminPermission %>">
		<liferay-ui:icon image="assign" message="Assign as" url="<%=assigneRolePopupJS %>"/>
	</c:if>
	
	<c:if test="<%=hasAdminPermission %>">
		<liferay-ui:icon image="lock" message="Block" url=""/>
	</c:if>
	
	<c:if test="<%=hasAdminPermission %>">
		<liferay-portlet:actionURL var="removeColleagueURL" name="removeColleague">
			<liferay-portlet:param name="userId" value="<%=String.valueOf(userRow.getUserId()) %>"/>
		</liferay-portlet:actionURL>
		<liferay-ui:icon image="leave" message="Remove" url="<%=removeColleagueURL.toString() %>"/>
	</c:if>
</liferay-ui:icon-menu>
