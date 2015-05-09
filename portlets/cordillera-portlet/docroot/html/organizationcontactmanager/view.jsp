<%@ include file="/html/common/init.jsp" %>

<!-- Your Content -->
<h3 class="page-header page-header-top">
	<i class="fa fa-circle-o"></i>
	<liferay-ui:message key="My Colleagues Address Book" />
	<small></small>
</h3>
<p>
	<liferay-ui:error key="unexpected-error-key" message="unexpected-error-message" />
	<%@ include file="/html/organizationcontactmanager/orgContracts.jsp" %>
</p>