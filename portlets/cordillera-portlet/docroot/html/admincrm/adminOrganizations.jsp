<%@page import="com.leancrm.portlet.library.service.AddressBookLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contact"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.leancrm.portlet.utils.AddressBookUtils"%>
<%@page import="com.leancrm.portlet.library.model.AddressBook"%>
<%@ include file="/html/common/init.jsp" %>

<liferay-ui:header title="Organization Manager"></liferay-ui:header>

<%
	List<Organization> organizationList = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());

	PortletURL orgIteratorURL = renderResponse.createActionURL();
	orgIteratorURL.setParameter("jspPage", "/html/admincrm/view.jsp");
%>
<h4>Organization list</h4>
<liferay-ui:error key="error-method-in-use" message="Could not remove method because it used"/>
<liferay-ui:error key="invalid-method-name-key" message="Invalid method name"/>
<liferay-ui:error key="unexpected-error-key" message="unexpected-error-msg"/>
<liferay-ui:search-container delta="10" emptyResultsMessage="No Organization" iteratorURL="<%=orgIteratorURL %>"  >
	<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(organizationList, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%=organizationList.size() %>"
		>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
			className="com.liferay.portal.model.Organization"
			keyProperty="organizationId"
			modelVar="organization">
		<liferay-ui:search-container-column-text name="Id" property="organizationId" />
		<liferay-ui:search-container-column-text name="Name" property="name" />
		<%
			AddressBook organizationAddressBook = AddressBookUtils.getAddressBook(organization);
		%>
		<liferay-ui:search-container-column-text name="Address Book" value='<%=String.valueOf(organizationAddressBook != null) %>' />
		<%
			List<User> consultantList = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
		%>
		<liferay-ui:search-container-column-text name="Total Consultants" value='<%=String.valueOf(consultantList.size()) %>' />
		<%
			if (organizationAddressBook != null) {
				List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(organizationAddressBook.getAddressBookId());
		%>
				<liferay-ui:search-container-column-text name="Total Contacts" value='<%=String.valueOf(contactList.size()) %>' />
		<%  } else {%>
				<liferay-ui:search-container-column-text name="Total Contacts" value='0' />
		<%  } %>
		<liferay-ui:search-container-column-jsp name="Action" path="/html/admincrm/adminOrganizationsAction.jsp" align="center" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<br />

<div id="organizationDetail"></div>