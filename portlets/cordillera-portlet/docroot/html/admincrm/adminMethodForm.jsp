<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@ include file="/html/common/init.jsp" %>

<liferay-ui:header title="Update Method" />
<liferay-portlet:actionURL var="updateMethodURL" name="updateMethod" />
<aui:form action="<%=updateMethodURL.toString() %>" method="post" >
	<aui:input type="hidden" name="methodId" value="${method.contactDataMethodId}"></aui:input>
	<aui:fieldset>
		<aui:field-wrapper>
			<aui:input name="name" value="${method.name}" />
		</aui:field-wrapper>
		<aui:field-wrapper>
			<aui:select name="type">
				<aui:option value="<%=ContactDataType.TEXT.ordinal() %>" selected="${method.contactDataType == 0}" ><%=ContactDataType.TEXT.name() %></aui:option>
				<aui:option value="<%=ContactDataType.REFERENCE.ordinal() %>" selected="${method.contactDataType == 1}" ><%=ContactDataType.REFERENCE.name() %></aui:option>
			</aui:select>
		</aui:field-wrapper>
		<aui:field-wrapper>
			<aui:button-row>
				<aui:button type="submit" value="Save"></aui:button>
			</aui:button-row>
		</aui:field-wrapper>
	</aui:fieldset>
</aui:form>
