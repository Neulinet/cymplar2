<%@page import="com.leancrm.portlet.library.ContractConstants"%>
<%@page import="com.leancrm.portlet.utils.PermissionChecker"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.utils.OrganizationUtils"%>
<%@page import="com.leancrm.portlet.library.service.ReportLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.sort.LeadOrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/common/init.jsp" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.leancrm.portlet.reportSearch.ReportResultItem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String currentURL = PortalUtil.getCurrentURL(request);

    // TODO clarify permissions - who can remove leads
	boolean isAdmin = RoleServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.ADMINISTRATOR, true);
    
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	OrderByComparator comparator = null;

	if (Validator.isNull(orderByType)) {
		orderByType = "asc";	
	}

	if (Validator.isNotNull(orderByCol) &&
		Validator.isNotNull(orderByType)) {
		comparator = new LeadOrderByComparator(orderByCol, orderByType);
	}

%>
<liferay-ui:search-container delta="10" 
							curParam="cur1" 
							emptyResultsMessage="No Leads" 
							orderByCol="<%= orderByCol %>"
							orderByType="<%= orderByType %>"
						     >
	<liferay-ui:search-container-results>
		<%
			
			List<ReportResultItem> searchResult = (List<ReportResultItem>) request.getAttribute("searchResultsItems");
			int searchResultCount = (Integer) request.getAttribute("searchResultsCount");
			results = searchResult;
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", searchResultCount);
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.reportSearch.ReportResultItem"
		escapedModel="<%= true %>"
		modelVar="aItem" >
		<%
			String rowStyle = "leads-status-" + aItem.getStatus().name().toLowerCase();
		%>
	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormat.format(aItem.getReportDate()) %>"
		cssClass='<%= "leads-date " + rowStyle %>'
		orderable="<%= true %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Company Name"
		value="<%=aItem.getEnterprise().getName() %>"
		cssClass='<%= "leads-company " + rowStyle %>' 
	/>
	<liferay-ui:search-container-column-text
		name="Contact"
		value="<%=aItem.getContactName() %>"
		cssClass='<%= "leads-contact " + rowStyle %>' 
	/>
	<liferay-ui:search-container-column-text
		name="Contract"
		value="<%=aItem.getContract().getDescription() %>"
		cssClass='<%= "leads-contract " + rowStyle %>'
	/>
	<liferay-ui:search-container-column-text
		name="Method"
		cssClass='<%= "leads-method " + rowStyle %>'
	>
		<c:choose>
			<c:when test='<%= aItem.getMethodUsedName().equals("email") %>'>
				<a href='<%="mailto:" + aItem.getMethodUsedValue() %>'>email</a>
			</c:when>
			<c:otherwise>
				<%=aItem.getMethodUsedValue() %>
			</c:otherwise>
		</c:choose>
		
		
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text
		name="Progress"
		value="<%=String.valueOf(aItem.getProgress()) %>"
		cssClass='<%= "leads-progress " + rowStyle %>'
	/>
	<liferay-ui:search-container-column-text
		name="Status"
		value='<%=aItem.getStatus() == null ? "" : aItem.getStatus().name() %>'
		cssClass='<%= "leads-status " + rowStyle %>'
		orderable="<%= true %>"
	/>
	<liferay-ui:search-container-column-text
		name="Comments"
		value="<%=aItem.getComments() %>"
		cssClass='<%= "leads-comments " + rowStyle %>'
	/>
	
	<liferay-ui:search-container-column-text
		name="Actions"
		cssClass='<%= "leads-actions "%>'
	>
			<c:if test="<%= PermissionChecker.canCommentContract(aItem.getContractId(), themeDisplay.getUser()) %>">
				<%
					String reportInfoUrl = "javascript:addReportInfo(" + aItem.getReportId() + ")";
				%>
				<liferay-ui:icon image="edit" message="New Comment" url="<%=reportInfoUrl %>"/>		
			</c:if>		
		
			<%-- Share action displayed only for admins and lead owner --%>
			<%
				if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser()) ||
						aItem.getLeadOwner() != null && aItem.getLeadOwner().getUserId() == themeDisplay.getUserId()) {
					String shareLeadURL = "javascript:onShareLeadClick(" + aItem.getReportId() + ")";
			%>
				<liferay-ui:icon
					image="share"
					message="Share Lead"
					method="get"
	                url='<%= shareLeadURL %>'
				/>
			
			<%
				}
			%>
					
			<%-- Only admin can remove lead --%>
			<%
				if (PermissionChecker.isOrganizationAdmin(themeDisplay.getUser())) {
					String reassignURL = "javascript:onReassignClick(" + aItem.getReportId() + ")";
			%>
				<portlet:actionURL name="removeReport" var="removeReportURL">
					<portlet:param name="reportId" value="<%= String.valueOf(aItem.getReportId()) %>"/>
					<%--Strange, but standard redirect is not working as expected. Probably because portlet called in ajax --%>
					<!-- portlet:param name="redirect" value="<%= currentURL %>"/ -->
				</portlet:actionURL>
				<liferay-ui:icon-delete message="Delete" url="<%= removeReportURL.toString() %>" confirmation="Are you really want to remove this lead?"/>
			<%  } %>
			
	</liferay-ui:search-container-column-text>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<liferay-portlet:resourceURL id="getReportInfo" var="getReportInfoURL"/>
<script>
function addReportInfo(reportId) {
	YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getReportInfoURL %>',
				{
					data: {
						<portlet:namespace />reportId: reportId
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log('DATA: ' + data);
							fillReportFormForAdd(data);
						}
					}
				});
			}
		);
}


</script>


<%-- Reassign Form --%>
<%
Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());

List<User> consultantList;
if (organization != null) {
	consultantList = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
} else {
	consultantList = new ArrayList<User>();
	consultantList.add(themeDisplay.getUser());
}


%>
<portlet:actionURL name="shareLead" var="shareLeadActionURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>

<div class="hide share-lead-dialog">
	<aui:form action="<%= shareLeadActionURL %>" method="post" name="shareLeadForm">
		<aui:input type="hidden" name="reportId"/>

		<aui:select label="Consultant" id="consultant" name="consultant" class="form-control" autocomplete="off">
			<aui:option value="-1">Choose a consultant...</aui:option>
			<% for (User consultant : consultantList) { %>
				<aui:option value="<%= consultant.getUserId() %>"><%= consultant.getFullName() %></aui:option>
			<% } %>
		</aui:select>
		
		<aui:select label="Lead Access Level" id="leadAccess" name="leadAccess" class="form-control" autocomplete="off">
			<aui:option value="-1">Choose lead access level...</aui:option>
			<aui:option value="<%= ContractConstants.ACCESS_READ %>">Reader</aui:option>
			<aui:option value="<%= ContractConstants.ACCESS_CONTRIBUTE %>">Contributor</aui:option>
			<aui:option value="<%= ContractConstants.ACCESS_OWNER %>">Owner</aui:option>
		</aui:select>		
	</aui:form>
</div>

<script>
	function onShareLeadClick(reportId) {
			
		YUI().use(
				'liferay-util-window',
				function (Y) {
					var reassignDialog = Y.one('.share-lead-dialog');
					var form = reassignDialog.one('#<portlet:namespace/>shareLeadForm');
					reassignDialog.show();
					var reportIdField = form.one('#<portlet:namespace/>reportId');
			    	reportIdField.set('value', reportId);
					
					var popUp = Liferay.Util.Window.getWindow(
		                    {
		                        dialog: {
		                            bodyContent: reassignDialog,
		                            toolbars: {
		                                footer: [
		                                    {
		                                        label: 'Share Lead',
		                                        on: {
		                                            click: function() {
		                                                reassignDialog.hide();
		                                                popUp.hide();
		                                                submitForm(form);


		                                            }
		                                        }
		                                    },
		                                    {
		                                        label: Liferay.Language.get('cancel'),
		                                        on: {
		                                            click: function() {
		                                            	reassignDialog.hide();
		                                                popUp.hide();
		                                            }
		                                        }
		                                    }
		                                ]
		                            },
		                            width: 400,
		                            height: 350
		                        },
		                        title: 'Share Lead'
		                    }
		                ).render();

					
				}
			);
	}
</script>