<%@page import="com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.utils.MailUtils"%>
<%@page import="com.leancrm.portlet.library.service.ContactContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactContract"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.AddressBookUser"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.utils.ContactSatusEnum"%>
<%@page import="com.leancrm.portlet.library.service.ReportLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@page import="com.leancrm.portlet.utils.AddressBookType"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataText"%>
<%@page import="com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Enterprise"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataRef"%>
<%@page import="com.leancrm.portlet.utils.ContactDataMethodEnum"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactData"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.utils.AddressBookUtils"%>
<%@page import="com.leancrm.portlet.library.model.AddressBook"%>
<%@page import="com.leancrm.portlet.library.model.AddressBookContact"%>
<%@page import="com.leancrm.portlet.utils.OrganizationUtils"%>
<%@ include file="/html/common/init.jsp" %>

	<%
		
		PortletURL iteratorURL = renderResponse.createActionURL();
		iteratorURL.setParameter("jspPage", "/html/organizationcontactmanager/view.jsp");
		
		Organization myOrganization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());

		List<AddressBookContact> resultContactList = new ArrayList<AddressBookContact>();
		if (myOrganization != null) {
			AddressBook organizationAddressBook = AddressBookUtils.getAddressBook(myOrganization);
			if (organizationAddressBook != null) {
				Map<Long, AddressBookContact> organizationContactMap = AddressBookContactLocalServiceUtil.getContactsByAddressBookAsMap(organizationAddressBook.getAddressBookId());
				
				resultContactList.addAll(organizationContactMap.values());
				
				List<User> colleagueList = UserLocalServiceUtil.getOrganizationUsers(myOrganization.getOrganizationId());
				if (colleagueList != null && !colleagueList.isEmpty()) {
					for (User colleague : colleagueList) {
						if (colleague.getUserId() != user.getUserId()) {
							AddressBook colleagueAddressBook = AddressBookUtils.getAddressBook(colleague);
							if (colleagueAddressBook != null) {
								List<AddressBookContact> colleagueContactList = AddressBookContactLocalServiceUtil.getContactsByAddressBook(colleagueAddressBook.getAddressBookId());
								if (colleagueContactList != null) {
									for (AddressBookContact colleagueContact : colleagueContactList) {
										if (!organizationContactMap.containsKey(colleagueContact.getContactId())) {
											resultContactList.add(colleagueContact);
										}
									}
								}
							}
						}
					}
				}
			} else {
	%>
				<div class="portlet-msg-alert"> Could not found an address book for your organization </div>
	<%
			}
		} else {
	%>
			<div class="portlet-msg-alert"> You do not belong to an organization </div>
	<%
		}
	%>
	
<table id="contactCollegueList" class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="cell-small"></th>
			<th>Company</th>
			<th>Contact Full Name</th>
			<th class="hidden-xs hidden-sm hidden-md">Contract Description</th>
			<th class="hidden-xs hidden-sm hidden-md">Progress</th>
			<th class="hidden-xs hidden-sm hidden-md">Status</th>
		</tr>
	</thead>
	<tbody>
		<%
		ContactDataMethod enterpriseContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
		ContactDataMethod nameContactMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
		for (AddressBookContact addressBookContact : resultContactList) {
			ContactData enterpriseContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookContact.getAddressBookId(), addressBookContact.getContactId(), enterpriseContactMethod.getContactDataMethodId());
			ContactData contactDataName = AddressBookContactDataLocalServiceUtil.getContactData(addressBookContact.getAddressBookId(), addressBookContact.getContactId(), nameContactMethod.getContactDataMethodId());

			ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(enterpriseContactData.getContactDataId());
			Enterprise enterprise = null; 
			if (contactDataRef != null && contactDataRef.getRefValue() > 0) {
				enterprise = EnterpriseLocalServiceUtil.getEnterprise(contactDataRef.getRefValue());
			}
			
			ContactDataText contactDataText = null;
			if (contactDataName != null) {
				contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(contactDataName.getContactDataId());
			}
			
			String enterpriseName = "";
			String contactName = "";
			
			if (contactDataText != null) {
				contactName = contactDataText.getValue(); 
			}
			
			if (enterprise != null) {
				enterpriseName = enterprise.getName();
			}
			
			List<ContactContract> contactContractList = ContactContractLocalServiceUtil.getByContact(addressBookContact.getContactId());
			int totalContracts = contactContractList == null ? 1 : contactContractList.size();
			if (contactContractList != null && !contactContractList.isEmpty()) {
				for (ContactContract contactContract : contactContractList) {
					Contract contract = ContractLocalServiceUtil.getContract(contactContract.getContractId());
					Report lastReport = ReportLocalServiceUtil.getLastReport(contactContract.getContractId());
					String progress = lastReport != null ? lastReport.getProgress() + "%" : "0.0%";
					String status = lastReport != null ? ContactSatusEnum.getStatus(lastReport.getStatus()).name() : "Not contacted yet";
					%>
					<tr>
						<td class="text-center">
							<div class="btn-group">
								<%
								AddressBook addressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookContact.getAddressBookId());
								String ownerLabel = "";
								
								User colleague = null;
								if (addressBookContact.getAssignedTo() > 0) {
									colleague = UserLocalServiceUtil.getUser(addressBookContact.getAssignedTo());
									// ownerLabel = "Assigned to: ";
								} else {
									if (addressBook.getAddressBookType() == AddressBookType.USER.getTypeId()) {
										AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUser(addressBook.getAddressBookId());
										if (addressBookUser != null) {
											colleague = UserLocalServiceUtil.getUser(addressBookUser.getUserId());
											// ownerLabel = "Owner: ";
										}
									}
								}
								%>
								<c:if test="<%=colleague != null%>">
										<a href="mailto:<%=colleague.getEmailAddress() %>"><%=colleague.getEmailAddress() %></a><br />
										<liferay-ui:icon image="reply" message="Request Lead" url="" />
								</c:if>
								<c:if test="<%=colleague == null %>">
									Not Assigned
								</c:if>
							</div>
						</td>
						<td><%=enterpriseName %></td>
						<td><%=contactName %></td>
						<td class="hidden-xs hidden-sm hidden-md"><%=contract.getDescription() %></td>
						<td class="hidden-xs hidden-sm hidden-md"><%=progress %></td>
						<td class="hidden-xs hidden-sm hidden-md"><%=status %></td>
					</tr>
					<%
				}
			} else {
		%>
				<tr>
					<td class="text-center">
						<div class="btn-group">
							<%
							AddressBook addressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookContact.getAddressBookId());
							String ownerLabel = "";
							
							User colleague = null;
							if (addressBookContact.getAssignedTo() > 0) {
								colleague = UserLocalServiceUtil.getUser(addressBookContact.getAssignedTo());
								// ownerLabel = "Assigned to: ";
							} else {
								if (addressBook.getAddressBookType() == AddressBookType.USER.getTypeId()) {
									AddressBookUser addressBookUser = AddressBookUserLocalServiceUtil.getAddressBookUser(addressBook.getAddressBookId());
									if (addressBookUser != null) {
										colleague = UserLocalServiceUtil.getUser(addressBookUser.getUserId());
										// ownerLabel = "Owner: ";
									}
								}
							}
							%>
							<c:if test="<%=colleague != null%>">
									<a href="mailto:<%=colleague.getEmailAddress() %>"><%=colleague.getEmailAddress() %></a><br />
									<liferay-ui:icon image="reply" message="Request Lead" url="" />
							</c:if>
							<c:if test="<%=colleague == null %>">
								Not Assigned
							</c:if>
						</div>
					</td>
					<td><%=enterpriseName %></td>
					<td><%=contactName %></td>
					<td class="hidden-xs hidden-sm hidden-md">N/A</td>
					<td class="hidden-xs hidden-sm hidden-md"></td>
					<td class="hidden-xs hidden-sm hidden-md"></td>
				</tr>
		<%	}
		} 
		%>
	</tbody>
</table>


<!-- Javascript code only for this page -->
<script>
    $(function() {
        /* Initialize Datatables */
        $('#contactCollegueList').dataTable({"aoColumnDefs": [{"bSortable": false, "aTargets": [0]}]});
        $('.dataTables_filter input').attr('placeholder', 'Search');
    });
</script>
