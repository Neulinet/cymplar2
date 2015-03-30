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
		<%
			String rowStyle = "leads-status-" + aItem.getStatus().name().toLowerCase();
		%>
	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormat.format(aItem.getReportDate()) %>"
		cssClass='<%= "leads-date " + rowStyle %>' 
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
		value="<%=aItem.getMethodUsedValue() %>"
		cssClass='<%= "leads-method " + rowStyle %>'
	/>
	<liferay-ui:search-container-column-text
		name="Progress"
		value="<%=String.valueOf(aItem.getProgress()) %>"
		cssClass='<%= "leads-progress " + rowStyle %>'
	/>
	<liferay-ui:search-container-column-text
		name="Status"
		value='<%=aItem.getStatus() == null ? "" : aItem.getStatus().name() %>'
		cssClass='<%= "leads-status " + rowStyle %>'
	/>
	<liferay-ui:search-container-column-text
		name="Comments"
		value="<%=aItem.getComments() %>"
		cssClass='<%= "leads-comments " + rowStyle %>'
	/>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>