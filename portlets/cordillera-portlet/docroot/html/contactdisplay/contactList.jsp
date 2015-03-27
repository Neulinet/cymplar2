<%@page import="com.leancrm.portlet.types.ContractStatus"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.entity.Contact"%>
<%@page import="com.leancrm.portlet.entity.ContractEntity"%>
<%@ include file="/html/common/consultantInit.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/contactdisplay/contactList.jsp");
%>

<liferay-ui:search-container delta="10" iteratorURL="<%=iteratorURL %>" curParam="cur1" emptyResultsMessage="No Contacts">
	<liferay-ui:search-container-results>
		<%
			ConsultantEntity consultant = new ConsultantEntity(user);
			List<Contact> contactList = consultant.getMyContacts(searchContainer.getStart(), searchContainer.getEnd());
			results = contactList;
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", MyAddressBookContactLocalServiceUtil.getTotal(consultant.getConsultantId()));
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.entity.Contact"
		escapedModel="<%= true %>"
		keyProperty="contactId"
		modelVar="aContact" >

	<liferay-ui:search-container-column-text
		name="EnterpriseName"
		value="<%=aContact.getEnterpriseName() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="FullName"
		value="<%=aContact.getFullName() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Contract"
		value="<%=aContact.getContractDescription() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Progress"
		value="<%=aContact.getContractProgress() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Status"
		value="<%=aContact.getContractStatus() %>"
	/>

	<liferay-ui:search-container-column-jsp
		path="/html/contactdisplay/contactList_actions.jsp"
		align="center"
	/>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>