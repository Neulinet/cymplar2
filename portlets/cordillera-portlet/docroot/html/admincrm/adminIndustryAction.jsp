<%@page import="com.leancrm.portlet.library.model.Industry"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Industry industry = (Industry) row.getObject();
%>
<portlet:actionURL var="showIndustryFormURL" name="showIndustryForm" />
<portlet:actionURL var="removeIndustryURL" name="removeIndustry">
	<portlet:param name="industryId" value="<%=String.valueOf(industry.getIndustryId()) %>"/>
</portlet:actionURL>
<%

String industryFormPopupJS = "javascript: showIndustryFormPopup('" + showIndustryFormURL.toString() + "','" + industry.getIndustryId() + "');";

boolean hasAdminPermission = permissionChecker.hasPermission(layout.getGroupId(), Role.class.getName(), PortalUtil.getUser(request).getCompanyId(), ActionKeys.ASSIGN_MEMBERS);

String removeIndustryJS = "javascript: removeIndustry('" + removeIndustryURL.toString() + "','" + industry.getName() + "');";
%>

<c:if test="<%=hasAdminPermission %>">
	<liferay-ui:icon image="edit" message="Edit" url="<%=industryFormPopupJS %>"/>
</c:if>

<c:if test="<%=hasAdminPermission %>">
	<liferay-ui:icon image="leave" message="Remove" url="<%=removeIndustryJS.toString() %>"/>
</c:if>
