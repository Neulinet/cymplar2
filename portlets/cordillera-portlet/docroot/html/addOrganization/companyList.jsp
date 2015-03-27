<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@ include file="/html/common/init.jsp" %>
<%
PortletURL iteratorURL = renderResponse.createActionURL();
iteratorURL.setParameter("jspPage", "/html/addOrganization/view.jsp");

List<Organization> organizationList = new ArrayList<Organization>();
organizationList.addAll(OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount()));

Collections.sort(organizationList, new Comparator<Organization>() {
	public int compare(Organization o1, Organization o2) {
		return o1.getName().compareTo(o2.getName());
	}
});
%>
<!-- Your Content -->
<h3 class="page-header page-header-top">
	<i class="fa fa-circle-o"></i>
	Membership
	<small>
		Join a company or create a new
	</small>
</h3>
<table id="companyListDataTable" class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="cell-small"></th>
			<th>Name</th>
			<th>Country</th>
			<th class="hidden-xs hidden-sm hidden-md">Region</th>
		</tr>
	</thead>
	<tbody>
		<% for (Organization organization : organizationList) { %>
			<tr>
				<td class="text-center">
					<div class="btn-group">
						<portlet:actionURL  name="selectCompany" var="selectCompanyURL">
							<portlet:param name="organizationId" value="<%=String.valueOf(organization.getOrganizationId()) %>"></portlet:param>
						</portlet:actionURL>
						<a href="<%=selectCompanyURL.toString() %>" data-toggle="tooltip" title="Select" class="btn btn-xs btn-success">Select</a>
					</div>
				</td>
				<%
				List<Address> addressList = AddressLocalServiceUtil.getAddresses(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
				String countryName = "";
				String regionName = "";
				if (addressList != null && !addressList.isEmpty()) {
					countryName = addressList.get(0).getCountry().getName();
					regionName = addressList.get(0).getRegion().getName();
				}
				%>
				<td><%=organization.getName() %></td>
				<td><%=countryName %></td>
				<td class="hidden-xs hidden-sm hidden-md"><%=regionName %></td>
			</tr>
		<%} %>
	</tbody>
</table>

<div class="well push">
	<portlet:renderURL var="showOrganizationAddFormURL">
		<portlet:param name="jspPage" value="/html/addOrganization/companyAddForm.jsp"/>
	</portlet:renderURL>
	<a href="<%=showOrganizationAddFormURL.toString() %>">Add a new company</a>
</div>
<!-- End Your Content -->