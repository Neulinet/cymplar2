<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.leancrm.portlet.library.service.UserContractLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>

<%@page import="com.leancrm.portlet.utils.AddressBookUtils"%>
<%@page import="com.leancrm.portlet.utils.ContactDataMethodEnum"%>
<%@page import="com.leancrm.portlet.utils.OrganizationUtils"%>
<%@page import="com.leancrm.portlet.utils.ContactStatusEnum"%>

<%@page import="com.leancrm.portlet.library.ContractConstants"%>

<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@page import="com.leancrm.portlet.library.model.AddressBook"%>
<%@page import="com.leancrm.portlet.library.model.Enterprise"%>
<%@page import="com.leancrm.portlet.library.model.ContactData"%>

<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ReportLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil"%>

<%
	ContactDataMethod contactDataName = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String currentURL = PortalUtil.getCurrentURL(request);
	
	Organization organization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
	
%>
<liferay-ui:search-container delta="10" 
							curParam="cur1" 
							emptyResultsMessage="No Unshared Company Leads">
	<liferay-ui:search-container-results>
		<%
			
			List<Contract> contracts = ContractLocalServiceUtil.getCompanyContracts(organization.getOrganizationId(), themeDisplay.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			int contractsCount = contracts.size();
			
			pageContext.setAttribute("results", contracts);
			pageContext.setAttribute("total", contractsCount);
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.library.model.Contract"
		escapedModel="<%= true %>"
		modelVar="contract" >
		
		<%
			Report report = ReportLocalServiceUtil.getLastReport(contract.getContractId());
			Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(contract.getEnterpriseId());
			Date lastReportDate = report.getReportDate();
			
			AddressBook addressBook = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(report.getUserId()));
			ContactData contactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBook.getAddressBookId(), report.getContactId(), contactDataName.getContactDataMethodId());
			
			String contactName = ContactDataTextLocalServiceUtil.getContactDataText(contactData.getContactDataId()).getValue();
			ContactStatusEnum status = ContactStatusEnum.getStatus(report.getStatus());

			String rowStyle = "leads-status-" + status.name().toLowerCase();
			User owner = UserContractLocalServiceUtil.getContractOwner(contract.getContractId());
		%>
		<liferay-ui:search-container-column-text
			name="Company Name"
			value="<%=enterprise.getName() %>"
			cssClass='<%= rowStyle %>' 
		/>
		<liferay-ui:search-container-column-text
			name="Contact"
			value="<%= contactName %>"
			cssClass='<%= rowStyle %>' 
		/>
		<liferay-ui:search-container-column-text
			name="Contract"
			value="<%=contract.getDescription() %>"
			cssClass='<%= rowStyle %>'
		/>
		<liferay-ui:search-container-column-text
			name="Last Contact"
			value="<%=dateFormat.format(lastReportDate) %>"
			cssClass='<%= rowStyle %>'
			orderable="<%= true %>" 
		/>
		<liferay-ui:search-container-column-text
			name="Status"
			value='<%=status == null ? "" : status.name() %>'
			cssClass='<%= rowStyle %>'
			orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
			name="Owner"
			value='<%= owner.getFullName() %>'
			cssClass='<%= rowStyle %>'
			orderable="<%= false  %>"
		/>
		<liferay-ui:search-container-column-text
			name="Actions"
		>
			<%
				String requestLeadURL = "javascript:onRequestLeadClick(" + contract.getContractId() + ")";
			%>
				<liferay-ui:icon
					image="share"
					message="Request Lead"
					method="get"
	                url='<%= requestLeadURL %>'
				/>
			
		</liferay-ui:search-container-column-text>		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<portlet:actionURL name="requestLead" var="requestLeadActionURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>
<portlet:resourceURL id="getContractUsers" var="getContractUsersURL"/>

<div class="hide request-lead-dialog">
	<aui:form action="<%= requestLeadActionURL %>" method="post" name="requestLeadForm">
		<aui:input type="hidden" name="contractId"/>

		<aui:select label="Consultant" id="consultant" name="consultant" class="form-control" autocomplete="off">
			<aui:option value="-1">Choose user to request...</aui:option>
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
	function onRequestLeadClick(contractId) {
			
		YUI().use(
				'liferay-util-window',
				function (Y) {
					var requestDialog = Y.one('.request-lead-dialog');
					var form = requestDialog.one('#<portlet:namespace/>requestLeadForm');
					requestDialog.show();
					var contractIdField = form.one('#<portlet:namespace/>contractId');
			    	contractIdField.set('value', contractId);
			    	fillContractUsers(contractId);
			    	
					var popUp = Liferay.Util.Window.getWindow(
		                    {
		                        dialog: {
		                            bodyContent: requestDialog,
		                            toolbars: {
		                                footer: [
		                                    {
		                                        label: 'Request Lead',
		                                        on: {
		                                            click: function() {
		                                                requestDialog.hide();
		                                                popUp.hide();
		                                                submitForm(form);


		                                            }
		                                        }
		                                    },
		                                    {
		                                        label: Liferay.Language.get('cancel'),
		                                        on: {
		                                            click: function() {
		                                            	requestDialog.hide();
		                                                popUp.hide();
		                                            }
		                                        }
		                                    }
		                                ]
		                            },
		                            width: 400,
		                            height: 350
		                        },
		                        title: 'Request Lead'
		                    }
		                ).render();

					
				}
			);
	}
	
	function fillContractUsers(contractId) {
		YUI().use(
				'aui-io-request',
				function (Y) {
					Y.io.request('<%=getContractUsersURL%>',
					{
						data: {
							<portlet:namespace />contractId: contractId
						},
						dataType: 'json',
						on: {
							success: function() {
								var data = this.get('responseData');
								var users = data.users;
								console.log("contract users: " + users);
								
								var selectUsers = document.getElementById('<portlet:namespace />consultant');
								
								// fill users
								var options = '<option value="-1">Choose user to request...</option>';
								for (var i=0; i < users.length; i++) {
									options += '<option value="' + users[i].userId + '">' + users[i].name + '</option>';
								}
								selectUsers.innerHTML = options;
							}
						}
					});
				}
			);
		
	}
</script>