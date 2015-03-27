<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/common/init.jsp" %>

addEvent
<liferay-portlet:actionURL name="addEvent" var="addEventURL" />
<aui:form action="<%=addEventURL.toString() %>" method="post" >
<aui:button type="submit">AddEvent</aui:button>
</aui:form>

<br />

<%@ include file="/html/admincrm/adminMethods.jsp" %>

<br />

<%@ include file="/html/admincrm/adminOrganizations.jsp" %>

<br />

<%@ include file="/html/admincrm/adminIndustry.jsp" %>

<br />
<br />

<liferay-ui:panel title="Create Address Book for User"></liferay-ui:panel>
<liferay-portlet:actionURL name="createAddressBookUser" var="createAddressBookUserURL" />
<aui:form action="<%=createAddressBookUserURL.toString() %>" method="post" >
	<aui:fieldset>
		<aui:field-wrapper>
			<aui:select name="userIdChoosed" label="User">
				<%
					List<User> userList = UserLocalServiceUtil.getCompanyUsers(themeDisplay.getCompanyId(), 0, UserLocalServiceUtil.getUsersCount());
				%>
				<c:forEach items="<%=userList %>" var="user">
					<aui:option value="${user.userId}">${user.firstName} ${user.middleName} ${user.lastName}</aui:option>
				</c:forEach>
			</aui:select>
		</aui:field-wrapper>
		<aui:field-wrapper>
			<aui:input name="addressBookTitle" lable="Title" value="" />
		</aui:field-wrapper>
		<aui:button-row>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:button-row>
	</aui:fieldset>
</aui:form>


<liferay-ui:panel title="Create Address Book for Organization"></liferay-ui:panel>
<liferay-portlet:actionURL name="createAddressBookOrganization" var="createAddressBookOrganizationURL" />
<aui:form action="<%=createAddressBookOrganizationURL.toString() %>" method="post" >
	<aui:fieldset>
		<aui:field-wrapper>
			<aui:select name="orgIdChoosed" label="User">
				<%
					List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
				%>
				<c:forEach items="<%=orgList %>" var="org">
					<aui:option value="${org.organizationId}">${org.name}</aui:option>
				</c:forEach>
			</aui:select>
		</aui:field-wrapper>
		<aui:field-wrapper>
			<aui:input name="addressBookTitle" lable="Title" value="" />
		</aui:field-wrapper>
		<aui:button-row>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:button-row>
	</aui:fieldset>
</aui:form>