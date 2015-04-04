<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.leancrm.portlet.sort.ContactOrderByComparator"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.leancrm.portlet.types.ContractStatus"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.entity.Contact"%>
<%@page import="com.leancrm.portlet.entity.ContractEntity"%>
<%@ include file="/html/common/consultantInit.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/contactdisplay/contactList.jsp");


String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
OrderByComparator comparator = null;

if (Validator.isNull(orderByType)) {
	orderByType = "asc";	
}

if (Validator.isNotNull(orderByCol) &&
	Validator.isNotNull(orderByType)) {
	comparator = new ContactOrderByComparator(orderByCol, orderByType);
}


%>

<liferay-ui:search-container delta="10" 
						     iteratorURL="<%=iteratorURL %>" 
						     curParam="cur1" 
						     emptyResultsMessage="No Contacts"
						     orderByCol="<%= orderByCol %>"
							 orderByType="<%= orderByType %>"
						     >
	<liferay-ui:search-container-results>
		<%
			ConsultantEntity consultant = new ConsultantEntity(user);
			List<Contact> contactList = consultant.getMyContacts(searchContainer.getStart(), searchContainer.getEnd(), comparator);
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
		orderable="<%= true %>"
		name="EnterpriseName"
		value="<%=aContact.getEnterpriseName() %>" 
	/>
	<liferay-ui:search-container-column-text
		orderable="<%= true %>"
		name="FullName"
		value="<%=aContact.getFullName() %>" 
	/>
	<liferay-ui:search-container-column-text
		orderable="<%= true %>"
		name="Contract"
		value="<%=aContact.getContractDescription() %>" 
	/>
	<liferay-ui:search-container-column-text
		orderable="<%= true %>"
		name="Progress"
		value="<%=aContact.getContractProgress() %>"
	/>
	<liferay-ui:search-container-column-text
		orderable="<%= true %>"
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