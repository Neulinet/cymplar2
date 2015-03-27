<%@page import="com.leancrm.portlet.library.service.AddressBookLocalServiceUtil"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.leancrm.portlet.library.model.Contact"%>
<%@page import="com.leancrm.portlet.utils.AddressBookUtils"%>
<%@page import="com.leancrm.portlet.library.model.AddressBook"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

<%
	long organizationId = Long.parseLong(request.getParameter("organizationId"));
	List<User> consultantList = UserLocalServiceUtil.getOrganizationUsers(organizationId);

	PortletURL consIteratorURL = renderResponse.createActionURL();
	consIteratorURL.setParameter("jspPage", "/html/admincrm/view.jsp");
%>
<h4>Consultant list</h4>
<liferay-ui:error key="error-method-in-use" message="Could not remove method because it used"/>
<liferay-ui:error key="invalid-method-name-key" message="Invalid method name"/>
<liferay-ui:error key="unexpected-error-key" message="unexpected-error-msg"/>
<liferay-ui:search-container delta="10" emptyResultsMessage="No Organization" iteratorURL="<%=consIteratorURL %>"  >
	<liferay-ui:search-container-results 
	
			results="<%=ListUtil.subList(consultantList, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%=consultantList.size() %>"
		>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.liferay.portal.model.User"
			keyProperty="userId"
			modelVar="user">
		<liferay-ui:search-container-column-text name="Id" property="userId" />
		<liferay-ui:search-container-column-text name="Name" property="fullName" />
		<liferay-ui:search-container-column-text name="Create Date" property="createDate" />
		<%
			AddressBook userAddressBook = AddressBookUtils.getAddressBook(user);
		%>
		<liferay-ui:search-container-column-text name="Address Book" value='<%=String.valueOf(userAddressBook != null) %>' />
		<%
			if (userAddressBook != null) {
				List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(userAddressBook.getAddressBookId());
		%>
				<liferay-ui:search-container-column-text name="Total Contacts" value='<%=String.valueOf(contactList.size()) %>' />
		<%  } else {%>
				<liferay-ui:search-container-column-text name="Total Contacts" value='0' />
		<%  } %>
		<liferay-ui:search-container-column-jsp name="Action" path="/html/admincrm/adminOrganizationsDetailAction.jsp" align="center" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>