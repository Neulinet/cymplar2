<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.leancrm.portlet.utils.CleanKey"%>
<%@ include file="/html/common/init.jsp" %>

<portlet:actionURL var="cleanUserURL" name="cleanUser" windowState="<%=LiferayWindowState.NORMAL.toString() %>" />
<h5>What do you want remove?</h5>
<br />
<aui:form action="<%=cleanUserURL.toString() %>" method="post" >
	<input type="hidden" name="userId" value="${param.userId}" />
	<aui:field-wrapper>
		<input name="cleans" type="checkbox" value="<%=String.valueOf(CleanKey.REMOVE_ADDRESS_BOOK.ordinal()) %>" />
		Remove Address Book
	</aui:field-wrapper>
	<aui:field-wrapper>
		<input name="cleans" type="checkbox" value="<%=String.valueOf(CleanKey.REMOVE_CONTACTS.ordinal()) %>" />
		Remove Contacts
	</aui:field-wrapper>
	<aui:field-wrapper>
		<input name="cleans" type="checkbox" value="<%=String.valueOf(CleanKey.REMOVE_USER_GROUP.ordinal()) %>" />
		Unlink Consultant  
	</aui:field-wrapper>
	<aui:field-wrapper>
		<input name="cleans" type="checkbox" value="<%=String.valueOf(CleanKey.REMOVE_REPORTS.ordinal()) %>" />
		Remove Reports
	</aui:field-wrapper>
	<input type="submit" value="Save" />
</aui:form>