<%@page import="com.leancrm.portlet.utils.ReportSearchUtils"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataPhoneLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataPhone"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataTextLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataText"%>
<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.leancrm.portlet.entity.ContactEntity"%>
<%@page import="com.leancrm.portlet.library.service.ContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contact"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactData"%>
<%@page import="com.leancrm.portlet.utils.ReportManagerUtils"%>
<%@page import="com.leancrm.portlet.types.FollowUpEventStatus"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@page import="com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.NextFollowUpEvent"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.entity.ConsultantEntity"%>
<%@ include file="/html/common/init.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/nextfollowupevent/view.jsp");
%>

<liferay-ui:search-container delta="10" iteratorURL="<%=iteratorURL %>" curParam="cur" emptyResultsMessage="No Events">
	<liferay-ui:search-container-results>
		<%
			ConsultantEntity consultant = new ConsultantEntity(user);
			List<Contract> contracts = ContractLocalServiceUtil.getContractsByUser(user.getUserId()); // Preguntar por Organizacion tambien
			List<Report> lastReportList = new ArrayList<Report>();
			if (contracts != null) {
				for (Contract c : contracts) {
					Report lastReport = ReportManagerUtils.getLastReport(c.getContractId());
					if (lastReport != null) {
						NextFollowUpEvent nextEvent = NextFollowUpEventLocalServiceUtil.getLastEventByStatus(lastReport.getReportId(), FollowUpEventStatus.PENDING.ordinal());
						if (nextEvent != null) {
							lastReportList.add(lastReport);
						}
					}
				}
			}
			
			results = lastReportList;
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", results.size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.leancrm.portlet.library.model.Report"
		escapedModel="<%= true %>"
		modelVar="aReport" >

		<%
			Contract contract = ContractLocalServiceUtil.getContract(aReport.getContractId());
			ContactData cd = ContactDataLocalServiceUtil.getContactData(aReport.getContactDataId());
			ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(cd.getContactDataMethodId());
			ContactEntity contactEntity = new ContactEntity(aReport.getContactId(), themeDisplay.getUserId());
			NextFollowUpEvent nextEvent = NextFollowUpEventLocalServiceUtil.getLastEventByStatus(aReport.getReportId(), FollowUpEventStatus.PENDING.ordinal());
			request.setAttribute("nextFollowUpEventId", nextEvent.getEventId());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		%>

	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormat.format(nextEvent.getEventDate()) %>" 
	/>

	<liferay-ui:search-container-column-text
		name="Contact"
		value="<%=contactEntity.getName() %>" 
	/>
	
	<liferay-ui:search-container-column-text
		name="Contract"
		value="<%=contract.getDescription() %>" 
	/>
	
	<liferay-ui:search-container-column-text
		name="Method">
		<%
		String methodValue = "";
		if (method.getContactDataType() == ContactDataType.TEXT.ordinal()) {
			ContactDataText contactDataText = ContactDataTextLocalServiceUtil.getContactDataText(aReport.getContactDataId());
			methodValue = contactDataText.getValue();
		} else if (method.getContactDataType() == ContactDataType.PHONE.ordinal()) {
			ContactDataPhone contactDataPhone = ContactDataPhoneLocalServiceUtil.getContactDataPhone(aReport.getContactDataId());
			methodValue = ReportSearchUtils.getFirstDigits(contactDataPhone.getExtension()) + contactDataPhone.getNumber();
		}
		%>
		<%= methodValue %>
	</liferay-ui:search-container-column-text> 
	
	
	<liferay-ui:search-container-column-text
		name="Comment"
		value="<%=aReport.getComments() %>" 
	/>
	
	<liferay-ui:search-container-column-jsp
		name="Actions"
		path="/html/nextfollowupevent/followUpEvent_actions.jsp"
		align="center"
	/>
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>