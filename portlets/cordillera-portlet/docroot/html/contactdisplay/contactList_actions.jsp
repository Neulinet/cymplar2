<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.leancrm.portlet.entity.ContactEntity"%>
<%@ include file="/html/common/consultantInit.jsp" %>
<%@page import="com.leancrm.portlet.entity.Contact"%>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Contact c = (Contact)row.getObject();
	ContactEntity contactEntity = new ContactEntity(themeDisplay.getCompanyId(), c.getContactId(), themeDisplay.getUserId());
	boolean isAdmin = RoleServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.ADMINISTRATOR, true);
%>
<liferay-ui:icon-menu>
	<%
		String contactInfoUrl = "javascript:getContactInfo(" + c.getContactId() + ")";
	%>
	<liferay-ui:icon image="edit" message="Edit" url="<%=contactInfoUrl %>"/>
	
	<%if (isAdmin) {%>
		<portlet:actionURL name="removeContact" var="removeContactURL">
			<portlet:param name="contactId" value="<%=c.getContactId().toString() %>"></portlet:param>
		</portlet:actionURL>
		<liferay-ui:icon image="delete" message="Delete" url="<%=removeContactURL.toString() %>"/>
	<%} %>
</liferay-ui:icon-menu>


<liferay-portlet:resourceURL id="getContactInfo" var="getContactInfoURL"/>
<script>
function getContactInfo(contactId) {
	YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getContactInfoURL %>',
				{
					data: {
						<portlet:namespace />contactId: contactId
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log('DATA: ' + data);
							console.log(document.forms.contactForm.enterpriseId)
							fillContactForm(data);
						}
					}
				});
			}
		);
}
</script>