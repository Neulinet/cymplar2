<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@ include file="/html/common/init.jsp" %>

<h3 class="page-header page-header-top">
	<i class="fa fa-circle-o"></i>
	<liferay-ui:message key="Update colleague role" />
	<small>${userEmail}</small>
</h3>
	<liferay-portlet:actionURL var="updateRoleURL" name="updateRole" />
	<%
		long userId = (Long) request.getAttribute("userId");
	%>
	<form action="<%=updateRoleURL.toString() %>" method="post">
		<aui:input type="hidden" name="userId" value="${userId}" />
		<aui:input type="checkbox" name="companyAdministrator" label="Company Administrator" checked="<%=RoleLocalServiceUtil.hasUserRole(userId, 11855) %>" />
		<aui:input type="checkbox" name="companyConsultant" label="Company Consultant" checked="<%=RoleLocalServiceUtil.hasUserRole(userId, 12023) %>" />

		<div class="buttonBox">
			<portlet:renderURL var="cancelURL">
				<portlet:param name="jspPage" value="/html/colleague/view.jsp"/>
			</portlet:renderURL>
			<a href="<%=cancelURL.toString() %>" data-toggle="tooltip" title="Cancel" class="btn btn-xs btn-info">Cancel</a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>