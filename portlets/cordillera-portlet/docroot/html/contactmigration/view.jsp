<%@ include file="/html/common/init.jsp" %>


<%@page import="com.leancrm.portlet.utils.PermissionChecker"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.util.PwdGenerator"%>


<%
String uploadProgressId2 = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>

<c:if test="<%= PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) %>">
	<fieldset>
		<legend>Reports</legend>
		
		<portlet:actionURL var="newImportReportsURL" name="newImportReports">
			<portlet:param name="jspPage" value="/view.jsp" />
		</portlet:actionURL>
		
		<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
		<liferay-ui:error key="error" message="Sorry, an error prevented the upload. Please try again." />
		<liferay-ui:upload-progress id="<%= uploadProgressId2 %>" message="uploading" redirect="<%= newImportReportsURL %>"/>
		
		<aui:form action="<%= newImportReportsURL %>" enctype="multipart/form-data" method="post" >
			<input type="file" name="fileName" size="75"/>
			<input type="submit" value="<liferay-ui:message key="Import" />" onClick="<%= uploadProgressId2 %>.startProgress(); return true;"/>
		</aui:form>
		<hr />
	</fieldset>
</c:if>

