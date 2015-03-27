<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/common/init.jsp" %>

<portlet:actionURL var="showOrganizationDetailURL" name="showOrganizationDetail" />

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Organization organization = (Organization) row.getObject();

PortletURL organizationDetailRenderURL = renderResponse.createRenderURL();
organizationDetailRenderURL.setWindowState(LiferayWindowState.EXCLUSIVE);
organizationDetailRenderURL.setParameter("jspPage","/html/admincrm/adminOrganizationsDetail.jsp");
organizationDetailRenderURL.setParameter("organizationId", String.valueOf(organization.getOrganizationId()));

String showOrganizationDetailJS = "javascript: showOrganizationDetail('" + organizationDetailRenderURL.toString() + "','" + organization.getOrganizationId() + "');";

PortletURL organizationCleanPopupRenderURL = renderResponse.createRenderURL();
organizationCleanPopupRenderURL.setWindowState(LiferayWindowState.EXCLUSIVE);
organizationCleanPopupRenderURL.setParameter("jspPage","/html/admincrm/adminOrganizationsCleanPopup.jsp");
organizationCleanPopupRenderURL.setParameter("organizationId", String.valueOf(organization.getOrganizationId()));

String showOrganizationCleanPopupJS = "javascript: showOrganizationCleanPopup('" + organizationCleanPopupRenderURL.toString() + "');";

%>

<liferay-ui:icon image="view" message="View" url="<%=showOrganizationDetailJS %>"/>
<liferay-ui:icon image="remove" message="Remove" url="<%=showOrganizationCleanPopupJS %>"/>