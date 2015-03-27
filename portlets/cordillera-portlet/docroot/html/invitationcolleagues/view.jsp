<%@ include file="/html/common/init.jsp" %>

<!-- Your Content -->
<h3 class="page-header page-header-top">
	<i class="fa fa-circle-o"></i>
	<liferay-ui:message key="invite-colleagues" />
	<small></small>
</h3>
<p>
	<liferay-ui:success key="invitationSent" message="your-invitations-have-been-sent" />
	
	<jsp:directive.include file="/html/invitationcolleagues/inviteForm.jsp" />
</p>
<!-- End Your Content -->