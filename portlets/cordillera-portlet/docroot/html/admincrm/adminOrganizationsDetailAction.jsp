<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
User aUser = (User) row.getObject();

PortletURL userCleanPopupRenderURL = renderResponse.createRenderURL();
userCleanPopupRenderURL.setWindowState(LiferayWindowState.EXCLUSIVE);
userCleanPopupRenderURL.setParameter("jspPage","/html/admincrm/adminOrganizationsCleanDetailPopup.jsp");
userCleanPopupRenderURL.setParameter("userId", String.valueOf(aUser.getUserId()));

String showUserCleanPopupJS = "javascript: showUserCleanPopup('" + userCleanPopupRenderURL.toString() + "');";

%>

<liferay-ui:icon image="remove" message="Remove" url="<%=showUserCleanPopupJS %>" />