<%@ include file="/html/common/init.jsp" %>

<liferay-ui:panel title="Companies and Contacts">
	<portlet:resourceURL var="reportResourceURL">
		<portlet:param name="reportType" value="1"></portlet:param>
		<portlet:param name="organizationId" value="${organizationId}"></portlet:param>
	</portlet:resourceURL>
	<aui:button href="<%=reportResourceURL.toString() %>" value="Export"></aui:button>
</liferay-ui:panel>

<liferay-ui:panel title="Contracts and Reports">
	<portlet:resourceURL var="reportResourceURL">
		<portlet:param name="reportType" value="2"></portlet:param>
		<portlet:param name="organizationId" value="${organizationId}"></portlet:param>
	</portlet:resourceURL>
	<aui:button href="<%=reportResourceURL.toString() %>" value="Export"></aui:button>
</liferay-ui:panel>