<%@page import="com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.entity.ContactColleague"%>
<%@ include file="/html/common/consultantInit.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/organizationcontactmanager/contactList.jsp");
%>

<liferay-ui:search-container delta="10" iteratorURL="<%=iteratorURL %>" curParam="cur2" emptyResultsMessage="No Colleague Contacts">
	<liferay-ui:search-container-results>
		<%
			ConsultantEntity consultant = new ConsultantEntity(user);
			List<ContactColleague> contactList = consultant.getMyColleagueContacts(searchContainer.getStart(), searchContainer.getEnd());
			results = contactList;
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", ColleagueAddressBookContactLocalServiceUtil.getTotal(consultant.getOrganization().getOrganizationId(), consultant.getConsultantId()));
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.entity.ContactColleague"
		escapedModel="<%= true %>"
		modelVar="aContact" >

	<liferay-ui:search-container-column-text
		name="EnterpriseName"
		value="<%=aContact.getEnterpriseName() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="FullName"
		value="<%=aContact.getContactName() %>" 
	/>
	
	<liferay-ui:search-container-column-jsp
		path="/html/organizationcontactmanager/contactList_actions.jsp"
		align="center"
	/>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>