<%@page import="com.leancrm.portlet.types.ContractStatus"%>
<%@page import="com.leancrm.portlet.types.FollowUpEventStatus"%>
<%@page import="com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.NextFollowUpEvent"%>
<%@page import="com.leancrm.portlet.entity.ContractEntity"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@ include file="/html/common/init.jsp" %>


<script>
	function viewNextFollowUpEventDetail(detailCompany, detailContract, detailStatus, detailProgress) {
		document.getElementById('detailCompany').value = detailCompany;
		document.getElementById('detailContract').value = detailContract;
		document.getElementById('detailStatus').value = detailStatus;
		document.getElementById('detailProgress').value = detailProgress;
	}
</script>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Report report = (Report) row.getObject();
	ContractEntity contract = new ContractEntity(report.getContractId());
	String contractStatus = ContractStatus.getContractStatus(report.getStatus()).getLabel();
	String onNextFollowUpEventView = "javascript:viewNextFollowUpEventDetail('" + contract.getEnterprise().getName() + "','" + contract.getDescription() + "','" + contractStatus + "','" + report.getProgress() + "')";
	Long nextFollowUpEventId = (Long) request.getAttribute("nextFollowUpEventId");
%>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="preview" message="View" url="<%=onNextFollowUpEventView %>" />
	
	<liferay-portlet:actionURL var="doneFollowUpEventURL" name="doneFollowUpEvent">
		<portlet:param name="nextFollowUpEventId" value="<%=nextFollowUpEventId.toString() %>" />
	</liferay-portlet:actionURL>
	<liferay-ui:icon image="check" message="Done" url="<%=doneFollowUpEventURL.toString() %>" />
	
	<liferay-portlet:actionURL var="cancelFollowUpEventURL" name="cancelFollowUpEvent">
		<portlet:param name="nextFollowUpEventId" value="<%=nextFollowUpEventId.toString() %>" />
	</liferay-portlet:actionURL>
	<liferay-ui:icon image="close" message="Cancel" url="<%=cancelFollowUpEventURL.toString() %>" />
</liferay-ui:icon-menu>