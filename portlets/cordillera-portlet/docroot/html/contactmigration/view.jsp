<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.util.PwdGenerator"%>
<%@ include file="/html/common/init.jsp" %>

<fieldset>
	<legend>Select an Organization</legend>
	<ul>
	<%
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
	for (Organization organization : organizations) {
	%>
		<li>
		<portlet:renderURL var="selectOrganizationURL">
			<portlet:param name="jspPage" value="/html/contactmigration/migration.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(organization.getOrganizationId()) %>"></portlet:param>
		</portlet:renderURL>
		<a href="<%=selectOrganizationURL.toString() %>"><%=organization.getName() %></a>
		</li>	
	<% 
	}
	%>
	</ul>
</fieldset>

<br />

<%
String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>

<fieldset>
	<legend>Companies</legend>
	
	<portlet:actionURL var="inportCompaniesURL" name="inportCompanies">
		<portlet:param name="jspPage" value="/edit.jsp" />
	</portlet:actionURL>
	
	<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
	<liferay-ui:error key="error" message="Sorry, an error prevented the upload. Please try again." />
	<liferay-ui:upload-progress id="<%= uploadProgressId %>" message="uploading" redirect="<%= inportCompaniesURL %>"/>
	
	<aui:form action="<%= inportCompaniesURL %>" enctype="multipart/form-data" method="post" >
		<input type="file" name="fileName" size="75"/>
		<input type="submit" value="<liferay-ui:message key="Import" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>
	</aui:form>
	<hr />
	<portlet:resourceURL var="reportResourceURL">
		<portlet:param name="reportType" value="3"></portlet:param>
	</portlet:resourceURL>
	<aui:button href="<%=reportResourceURL.toString() %>" value="Export"></aui:button>
</fieldset>

<fieldset>
	<legend>Contacts</legend>
	
	<portlet:actionURL var="importContactsURL" name="importContacts">
		<portlet:param name="jspPage" value="/view.jsp" />
	</portlet:actionURL>
	
	<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
	<liferay-ui:error key="error" message="Sorry, an error prevented the upload. Please try again." />
	<liferay-ui:upload-progress id="<%= uploadProgressId %>" message="uploading" redirect="<%= importContactsURL %>"/>
	
	<aui:form action="<%= importContactsURL %>" enctype="multipart/form-data" method="post" >
		<input type="file" name="fileName" size="75"/>
		<input type="submit" value="<liferay-ui:message key="Import" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>
	</aui:form>
	<hr />
</fieldset>

<fieldset>
	<legend>Reports</legend>
	
	<portlet:actionURL var="importReportsURL" name="importReports">
		<portlet:param name="jspPage" value="/view.jsp" />
	</portlet:actionURL>
	
	<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
	<liferay-ui:error key="error" message="Sorry, an error prevented the upload. Please try again." />
	<liferay-ui:upload-progress id="<%= uploadProgressId %>" message="uploading" redirect="<%= importReportsURL %>"/>
	
	<aui:form action="<%= importReportsURL %>" enctype="multipart/form-data" method="post" >
		<input type="file" name="fileName" size="75"/>
		<input type="submit" value="<liferay-ui:message key="Import" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>
	</aui:form>
	<hr />
</fieldset>

importReports
