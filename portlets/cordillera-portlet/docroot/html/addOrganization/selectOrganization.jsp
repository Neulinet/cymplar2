<%@ include file="/html/common/init.jsp" %>

<liferay-ui:error key="<%=CRMErrorKey.UNEXPECTED_ERROR %>" message="unexpected-error-msg"/>
<liferay-ui:error key="<%=CRMErrorKey.INVALID_ORGANIZATION_CODE %>" message="invalid-organization-code-msg"/>
<liferay-portlet:actionURL var="selectOrganizationURL" name="selectOrganization" />
<form action="<%=selectOrganizationURL %>" method="post" name="selectOrganizationFm" class="form-horizontal">
<div class="control-group text-left custom-control-group">
	<label for="code" class="control-label"> Who invite you?</label>
	<div class="controls">
		<aui:input autocomplete="off" id="code" title="" label="" placeholder="Inviter" inlineLabel="true" inlineField="true" name="code" onKeyUp="getOrganizationDetail()"></aui:input>
	</div>
</div>
	<div class="control-group">
		<portlet:renderURL var="showOrganizationAddFormURL">
			<portlet:param name="jspPage" value="/html/addOrganization/companyAddForm.jsp"/>
		</portlet:renderURL>
		<a href="<%=showOrganizationAddFormURL.toString() %>">No One?</a>
	</div>
	<button type="submit" class="btn" id="joinButton" disabled="disabled">Register Organistion</button>
	<div id="organizationCodeDetail" class="alert alert-success hide"></div>
	<div id="organizationCodeError" class="alert alert-danger hide"></div>
</form>


<liferay-portlet:resourceURL id="getOrganizationDetail" var="getOrganizationDetailURL"/>

<script>
function getOrganizationDetail() {
	var code = document.getElementById("<portlet:namespace />code").value;
	if (code.length > 9) {
		YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getOrganizationDetailURL %>',
				{
					data: {
						<portlet:namespace />code:code
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log("Data: " + data);
							console.log("Name: " + data.name);
							console.log("Error: " + data.error);
							if (data.name != null && data.name != 'undefined') {
								document.getElementById("joinButton").disabled = ""; 
								document.getElementById("organizationCodeDetail").innerHTML = data.name;
								document.getElementById("organizationCodeDetail").className = "alert alert-success";
								document.getElementById("organizationCodeError").innerHTML = "";
								document.getElementById("organizationCodeError").className = "alert alert-danger hide";
							} else {
								document.getElementById("joinButton").disabled = "disabled";
								document.getElementById("organizationCodeError").innerHTML = data.error;
								document.getElementById("organizationCodeError").className = "alert alert-danger";
								document.getElementById("organizationCodeDetail").innerHTML = "";
								document.getElementById("organizationCodeDetail").className = "alert alert-success hide";
							}
							
							document.getElementById("<portlet:namespace />code").title = data.error;

						}
					}
				});
			}
		);
	} else if (code.length < 2) {
		document.getElementById("organizationCodeDetail").innerHTML = "";
		document.getElementById("organizationCodeDetail").className = "alert alert-success hide";
		document.getElementById("organizationCodeError").innerHTML = "";
		document.getElementById("organizationCodeError").className = "alert alert-danger hide";
	}
}
</script>