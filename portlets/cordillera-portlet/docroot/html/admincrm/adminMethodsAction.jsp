<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ContactDataMethod method = (ContactDataMethod) row.getObject();
%>
<portlet:actionURL var="showMethodFormURL" name="showMethodForm" />
<portlet:actionURL var="removeMethodURL" name="removeMethod">
	<portlet:param name="methodId" value="<%=String.valueOf(method.getContactDataMethodId()) %>"/>
</portlet:actionURL>
<%

String methodFormPopupJS = "javascript: showMethodFormPopup('" + showMethodFormURL.toString() + "','" + method.getContactDataMethodId() + "');";

boolean hasAdminPermission = permissionChecker.hasPermission(layout.getGroupId(), Role.class.getName(), PortalUtil.getUser(request).getCompanyId(), ActionKeys.ASSIGN_MEMBERS);

String removeMethodJS = "javascript: removeMethod('" + removeMethodURL.toString() + "','" + method.getName() + "');";
%>

<c:if test="<%=hasAdminPermission %>">
	<liferay-ui:icon image="edit" message="Edit" url="<%=methodFormPopupJS %>"/>
</c:if>

<c:if test="<%=hasAdminPermission %>">
	<liferay-ui:icon image="leave" message="Remove" url="<%=removeMethodJS.toString() %>"/>
</c:if>
