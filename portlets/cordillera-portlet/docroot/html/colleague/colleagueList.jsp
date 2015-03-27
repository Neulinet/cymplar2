<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ include file="/html/common/init.jsp" %>
<%
List<Organization> organizationList = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());
List<User> colleagueList = new ArrayList<User>();
if (!organizationList.isEmpty()) {
	List<User> userOrganizationList = UserLocalServiceUtil.getOrganizationUsers(organizationList.get(0).getOrganizationId());
	for (User userOrganization : userOrganizationList) {
		if (userOrganization.getUserId() != user.getUserId()) {
			colleagueList.add(userOrganization);
		}
	}
	Collections.sort(colleagueList, new Comparator<User>() {
		public int compare(User u1, User u2) {
			String fullName1 = u1.getLastName() + u1.getFirstName();
			String fullName2 = u2.getLastName() + u2.getFirstName();
			
			return fullName1.compareTo(fullName2);
		}
	});
}

PortletURL iteratorURL = renderResponse.createActionURL();
iteratorURL.setParameter("jspPage", "/html/colleague/view.jsp");

boolean hasAdminPermission = permissionChecker.hasPermission(layout.getGroupId(), Role.class.getName(), PortalUtil.getUser(request).getCompanyId(), ActionKeys.ASSIGN_MEMBERS);
%>

<liferay-portlet:actionURL var="updateRoleURL" name="updateRole" />

<table id="colleagueListDataTable" class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th></th>
			<th>Email</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
	</thead>
	<tbody>
		<% for (int i=0; i<colleagueList.size(); i++) { %>
			<c:set var="userVar" value="<%=colleagueList.get(i) %>" />
			<tr>
				<td class="text-center">
					<div class="">
						<c:if test="<%=hasAdminPermission %>">
						
							<portlet:actionURL name="showAssignRole" var="showAssignRoleURL">
								<liferay-portlet:param name="userId" value="<%=String.valueOf(colleagueList.get(i).getUserId()) %>"/>
								<liferay-portlet:param name="userEmail" value="<%=String.valueOf(colleagueList.get(i).getEmailAddress()) %>"/>
							</portlet:actionURL>
							<a href="<%=showAssignRoleURL.toString() %>" data-toggle="tooltip" title="Role" class="btn btn-success">Roler</a>
							<liferay-portlet:actionURL var="removeColleagueURL" name="removeColleague">
								<liferay-portlet:param name="userId" value="<%=String.valueOf(colleagueList.get(i).getUserId()) %>"/>
							</liferay-portlet:actionURL>
							<a href="<%=removeColleagueURL.toString() %>" data-toggle="tooltip" title="Delete" class="btn">Delete</a>
							
<!-- 							<a href="" data-toggle="tooltip" title="Assign as" class="btn btn-xs btn-info"><i class="fa fa-gear"></i></a> -->
						
<!-- 						<a href="javascript:void(0)" data-toggle="tooltip" title="Lock" class="btn btn-xs btn-warning"><i class="fa fa-lock"></i></a> -->
							
<!-- 							<a href="" data-toggle="tooltip" title="Delete" class="btn btn-xs btn-danger"><i class="fa fa-minus"></i></a> -->
						</c:if>
					</div>
				</td>
				<td>${userVar.emailAddress}</td>
				<td>${userVar.firstName}</td>
				<td>${userVar.lastName}</td>
			</tr>
		<%}%>
	</tbody>
</table>