<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.leancrm.portlet.reportSearch.ReportResultItem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/html/common/init.jsp" %>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<liferay-ui:search-container delta="" curParam="cur1" emptyResultsMessage="No Results">
	<liferay-ui:search-container-results>
		<%
			
			List<ReportResultItem> searchResult = (List<ReportResultItem>) request.getAttribute("searchResultsItems");
			results = searchResult;
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", results.size());
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.reportSearch.ReportResultItem"
		escapedModel="<%= true %>"
		modelVar="aItem" >

	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormat.format(aItem.getReportDate()) %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Company Name"
		value="<%=aItem.getEnterprise().getName() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Contact"
		value="<%=aItem.getContactName() %>" 
	/>
	<liferay-ui:search-container-column-text
		name="Contract"
		value="<%=aItem.getContract().getDescription() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Method"
		value="<%=aItem.getMethodUsedName() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Progress"
		value="<%=String.valueOf(aItem.getProgress()) %>"
	/>
	<liferay-ui:search-container-column-text
		name="Status"
		value="<%=aItem.getStatus().name() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Comments"
		value="<%=aItem.getComments() %>"
	/>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>