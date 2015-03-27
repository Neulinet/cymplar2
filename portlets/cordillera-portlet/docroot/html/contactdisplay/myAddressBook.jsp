<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.utils.ContactSatusEnum"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContactContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactContract"%>
<%@page import="com.leancrm.portlet.library.service.ReportLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@page import="com.leancrm.portlet.utils.OrganizationUtils"%>
<%@page import="com.leancrm.portlet.sort.ContactComparator"%>
<%@page import="com.leancrm.portlet.utils.AddressBookUtils"%>
<%@page import="com.liferay.portal.model.UserConstants"%>
<%@page import="com.leancrm.portlet.library.service.persistence.ContactDataUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataText"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.AddressBook"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.AddressBookUser"%>
<%@page import="com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.utils.ContactDataMethodEnum"%>
<%@page import="com.leancrm.portlet.library.model.Enterprise"%>
<%@page import="com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataRefLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataRef"%>
<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactData"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.leancrm.portlet.library.model.Contact"%>
<%@ include file="/html/common/init.jsp" %>
<%
PortletURL iteratorURL = renderResponse.createActionURL();
iteratorURL.setParameter("jspPage", "/html/contactmanager/myAddressBookList.jsp");
List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(user.getUserId());
AddressBook myAddressBook = AddressBookLocalServiceUtil.getAddressBook(addressBookUserList.get(0).getAddressBookId());

List<Contact> contactList = AddressBookContactLocalServiceUtil.getContacts(myAddressBook.getAddressBookId());
Collections.sort(contactList, new ContactComparator(myAddressBook));
%>

<script type="text/javascript">
<!--
$(document).ready(function() {
	oTable = $('#myContactList').dataTable({
		"bJQueryUI": true
	});
});
//-->
</script>

<div class="_contactdisplay_WAR_cordilleraportlet_contactManagerContainer">
	<liferay-ui:header title="My Address Book" cssClass="_contactdisplay_WAR_cordilleraportlet_headerTitle"></liferay-ui:header>

	<!-- Success Messages -->
	<liferay-ui:success key="<%=CRMSuccessKey.CONTACT_REMOVED %>" message="contact-removed-msg" />
	
	<table id="myContactList">
		<thead>
			<tr>
				<th>Company</th>
				<th>Contact Full Name</th>
				<th>Contract</th>
				<th>Progress</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Contact contacto : contactList) {
					ContactDataMethod enterpriseContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.ENTERPRISE.getMethodName());
					ContactData enterpriseContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUserList.get(0).getAddressBookId(), contacto.getContactId(), enterpriseContactDataMethod.getContactDataMethodId());
					
					ContactDataMethod nameContactDataMethod = ContactDataMethodLocalServiceUtil.getContactDataMethodByName(ContactDataMethodEnum.NAME.getMethodName());
					ContactData nameContactData = AddressBookContactDataLocalServiceUtil.getContactData(addressBookUserList.get(0).getAddressBookId(), contacto.getContactId(), nameContactDataMethod.getContactDataMethodId());
					
					ContactDataRef contactDataRef = ContactDataRefLocalServiceUtil.getContactDataRef(enterpriseContactData.getContactDataId());
					Enterprise enterprise = EnterpriseLocalServiceUtil.getEnterprise(contactDataRef.getRefValue());
					
					ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(nameContactData.getContactDataId());
					
					Organization myOrganization = OrganizationUtils.getOrganizationByUser(themeDisplay.getUserId());
					
					List<ContactContract> contactContractList = ContactContractLocalServiceUtil.getByContact(contacto.getContactId());
					int totalContracts = contactContractList == null ? 1 : contactContractList.size();
					if (contactContractList != null && !contactContractList.isEmpty()) {
						for (ContactContract contactContract : contactContractList) {
							Contract contract = ContractLocalServiceUtil.getContract(contactContract.getContractId());
							
							if (contract.getEnterpriseId() == contactDataRef.getRefValue() && contract.getOrganizationId() == myOrganization.getOrganizationId()) {
							
								Report lastReport = ReportLocalServiceUtil.getLastReport(contactContract.getContractId());
								String progress = lastReport != null ? lastReport.getProgress() + "%" : "0.0%";
								String status = lastReport != null ? ContactSatusEnum.getStatus(lastReport.getStatus()).name() : "Not contacted yet";
								%>
								<tr>
									<td><%=enterprise.getName() %></td>
									<td><%=contactDataText.getValue() %></td>
									<td><%=contract.getDescription() %></td>
									<td><%=progress %></td>
									<td>
										<%
										int totalUser = AddressBookContactLocalServiceUtil.countAddressBook(contacto.getContactId());
										%>
										
										<liferay-portlet:actionURL portletName="contactmanager_WAR_cordilleraportlet" var="showEditContactURL1" name="showEditContact">
											<liferay-portlet:param name="contactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
										</liferay-portlet:actionURL>
										<liferay-ui:icon image="edit" message="Edit" url="<%=showEditContactURL1.toString() %>" />
										
										<c:if test="<%=totalUser == 1 %>">
											<liferay-portlet:actionURL var="removeContactURL" name="removeContact">
												<liferay-portlet:param name="contactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
											</liferay-portlet:actionURL>
											<%
											  if (RoleServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleConstants.ADMINISTRATOR, true)) {
											%>
												<liferay-ui:icon image="delete" message="Delete" url="<%=removeContactURL.toString() %>" />
											<%} %>
											<liferay-portlet:actionURL name="showReportForm" var="showReportFormURL" portletName="reportmanager_WAR_cordilleraportlet" plid="14126" >
												<liferay-portlet:param name="penterpriseId" value="<%=String.valueOf(enterprise.getEnterpriseId()) %>"/>
												<liferay-portlet:param name="pcontactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
											</liferay-portlet:actionURL>
											<liferay-ui:icon image="site_icon" message="Add Report" url="<%=showReportFormURL.toString() %>" />
										</c:if>
									</td>
								</tr>
						<%
							}
						}
					} else {
						%>
							<tr>
								<td><%=enterprise.getName() %></td>
								<td><%=contactDataText.getValue() %></td>
								<td>N/A</td>
								<td></td>
								<td>
									<%
									int totalUser = AddressBookContactLocalServiceUtil.countAddressBook(contacto.getContactId());
									%>
									
									<liferay-portlet:actionURL portletName="contactmanager_WAR_cordilleraportlet" var="showEditContactURL2" name="showEditContact">
										<liferay-portlet:param name="contactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
									</liferay-portlet:actionURL>
									<liferay-ui:icon image="edit" message="Edit" url="<%=showEditContactURL2.toString() %>" />
									
									<c:if test="<%=totalUser == 1 %>">
										<liferay-portlet:actionURL var="removeContactURL" name="removeContact">
											<liferay-portlet:param name="contactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
										</liferay-portlet:actionURL>
										<%
										  if (RoleServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleConstants.ADMINISTRATOR, true)) {
										%>
											<liferay-ui:icon image="delete" message="Delete" url="<%=removeContactURL.toString() %>" />
										<%} %>
										<liferay-portlet:actionURL name="showReportForm" var="showReportFormURL" portletName="reportmanager_WAR_cordilleraportlet" plid="14126" >
											<liferay-portlet:param name="penterpriseId" value="<%=String.valueOf(enterprise.getEnterpriseId()) %>"/>
											<liferay-portlet:param name="pcontactId" value="<%=String.valueOf(contacto.getContactId()) %>"/>
										</liferay-portlet:actionURL>
										<liferay-ui:icon image="site_icon" message="Add Report" url="<%=showReportFormURL.toString() %>" />
									</c:if>
								</td>
							</tr>
						<%
					}
				}
			%>
		</tbody>
	</table>
</div>