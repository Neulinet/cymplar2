<%@ include file="/html/common/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Organization organization = (Organization) row.getObject();
%>

<portlet:actionURL  name="selectCompany" var="selectCompanyURL">
	<portlet:param name="organizationId" value="<%=String.valueOf(organization.getOrganizationId()) %>"></portlet:param>
</portlet:actionURL>
<liferay-ui:icon image="join" message="Select" url="<%=selectCompanyURL.toString() %>"/>