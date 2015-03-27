<%@page import="com.leancrm.portlet.library.service.IndustryLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Industry"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@ include file="/html/common/init.jsp" %>

<liferay-ui:header title="Industry Manager"></liferay-ui:header>

<liferay-portlet:actionURL name="addIndustry" var="addIndustryURL" />
<aui:form action="<%=addIndustryURL.toString() %>" method="post" >
	<aui:fieldset>
		<aui:column>
			<aui:field-wrapper>
				<label class="aui-field-label" for="name">
					Name
				</label>
				<input type="text" id="name" name="name" value="" class="fieldForm" />
			</aui:field-wrapper>
		</aui:column>
		<aui:column>
			<aui:button-row>
				<aui:button type="submit" value="Save" cssClass="buttonInline"></aui:button>
			</aui:button-row>
		</aui:column>
	</aui:fieldset>
</aui:form>
<%
	List<Industry> industryList = IndustryLocalServiceUtil.getAll();

	PortletURL iteratorIndustryURL = renderResponse.createActionURL();
	iteratorIndustryURL.setParameter("jspPage", "/html/admincrm/view.jsp");
%>
<h4>Industry list</h4>
<liferay-ui:error key="error-industry-in-use" message="Could not remove indutry because it used"/>
<liferay-ui:error key="invalid-industry-name-key" message="Invalid industry name"/>
<liferay-ui:error key="unexpected-error-key" message="unexpected-error-msg"/>
<liferay-ui:search-container delta="10" emptyResultsMessage="No Industry" iteratorURL="<%=iteratorIndustryURL %>"  >
	<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(industryList, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%=industryList.size() %>"
		>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
			className="com.leancrm.portlet.library.model.Industry"
			keyProperty="industryId"
			modelVar="industry" >
		<liferay-ui:search-container-column-text name="Id" property="industryId" />
		<liferay-ui:search-container-column-text name="Name" property="name" />
		<liferay-ui:search-container-column-jsp name="Action" path="/html/admincrm/adminIndustryAction.jsp" align="center" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>