<%@ include file="/html/common/init.jsp" %>

<liferay-ui:header title="Update Industry" />
<liferay-portlet:actionURL var="updateIndustryURL" name="updateIndustry" />
<aui:form action="<%=updateIndustryURL.toString() %>" method="post" >
	<aui:input type="hidden" name="industryId" value="${industry.industryId}"></aui:input>
	<aui:fieldset>
		<aui:field-wrapper>
			<aui:input name="name" value="${industry.name}" />
		</aui:field-wrapper>
		<aui:field-wrapper>
			<aui:button-row>
				<aui:button type="submit" value="Save"></aui:button>
			</aui:button-row>
		</aui:field-wrapper>
	</aui:fieldset>
</aui:form>
