<%@page import="com.leancrm.portlet.utils.ConstantDefinitions"%>
<%@page import="com.liferay.portal.service.permission.OrganizationPermissionUtil"%>
<%@page import="com.liferay.portal.service.permission.UserPermissionUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.leancrm.portlet.utils.CustomFieldUtils"%>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserGroupServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<% 
PortletURL iteratorURL = renderResponse.createActionURL();
iteratorURL.setParameter("jspPage", "/html/organizationrequest/view.jsp");

User currentUser = PortalUtil.getUser(request);
List<Organization> organizationList = OrganizationLocalServiceUtil.getUserOrganizations(currentUser.getUserId());
List<User> pendingUserList = new ArrayList<User>();
if (organizationList != null && !organizationList.isEmpty()) {
	long currentOrganizationId = organizationList.get(0).getOrganizationId();
	List<User> userList = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
	if (userList != null) {
		for (User pendingUser : userList) {
			long requestOrganizationId = CustomFieldUtils.getCustomValue(pendingUser.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, pendingUser.getUserId());
			if (requestOrganizationId == currentOrganizationId) {
				pendingUserList.add(pendingUser);
			}
		}
	}
}
%>
<c:if test="<%=organizationList != null && !organizationList.isEmpty() && permissionChecker.hasPermission(layout.getGroupId(), Organization.class.getName(), organizationList.get(0).getOrganizationId(), ActionKeys.ASSIGN_MEMBERS) %>">

	<table id="pendingListDataTable" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="cell-small"></th>
				<th><i class="fa fa-envelope-o"></i> Email</th>
				<th class="hidden-xs hidden-sm hidden-md"><i class="fa fa-user"></i> First Name</th>
				<th class="hidden-xs hidden-sm hidden-md"><i class="fa fa-user"></i> Last Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="<%=pendingUserList %>" var="userVar">
				<tr>
					<td class="text-center">
						<div class="btn-group">
							<portlet:actionURL  name="acceptUser" var="acceptUserURL">
								<portlet:param name="userId" value="${userVar.userId}"></portlet:param>
							</portlet:actionURL>
							<a href="<%=acceptUserURL.toString() %>" data-toggle="tooltip" title="Accept" class="btn btn-xs btn-success">Accept</a>
							<portlet:actionURL  name="ignoreUser" var="ignoreUserURL">
								<portlet:param name="userId" value="${userVar.userId}"></portlet:param>
							</portlet:actionURL>
							<a href="<%=ignoreUserURL.toString() %>" data-toggle="tooltip" title="Ignore" class="btn btn-xs btn-danger">Ignore</a>
						</div>
					</td>
					<td>${userVar.emailAddress}</td>
					<td class="hidden-xs hidden-sm hidden-md">${userVar.firstName}</td>
					<td class="hidden-xs hidden-sm hidden-md">${userVar.lastName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</c:if>

<c:if test="<%= !permissionChecker.hasPermission(layout.getGroupId(), Organization.class.getName(), currentUser.getCompanyId(), ActionKeys.ASSIGN_MEMBERS) %>">
	You don't have permission to assign members to the company.
</c:if>
<c:if test="<%=organizationList == null || organizationList.isEmpty()%>">
	You do not belong to any company.
</c:if>
