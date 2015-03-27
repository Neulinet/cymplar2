<%@page import="com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Enterprise"%>
<%@ include file="/html/common/init.jsp" %>

<!-- Your Content -->
<h3 class="page-header page-header-top">
	<i class="fa fa-circle-o"></i>
	<liferay-ui:message key="My Address Book" />
	<small></small>
</h3>
<p>
	<liferay-ui:error key="unexpected-error-key" message="unexpected-error-message" />
	<%@ include file="/html/contactdisplay/contactList.jsp" %>
</p>