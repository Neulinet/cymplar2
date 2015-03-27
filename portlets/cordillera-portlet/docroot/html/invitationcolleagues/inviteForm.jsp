<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="java.util.Set"%>
<%@page import="com.leancrm.portlet.invitationcolleagues.util.InvitationUtil"%>
<%@ include file="/html/common/init.jsp" %>

<liferay-ui:error key="<%=CRMErrorKey.INVALID_ORGANIZATION_GENERATED_CODE %>" message="invalid-organization-generate-code-msg"/>

	<portlet:actionURL var="sendInvitationsURL" name="sendInvitations" />
	<form action="<%= sendInvitationsURL.toString() %>" method="post" name="inviteForm" id="inviteForm" class="form-horizontal form-box remove-margin">
		<!-- Form Header -->
		<h4 class="form-box-header">
			<liferay-ui:message key="Enter one email address per line" />
			<small>
				
			</small>
		</h4>

		<!-- Form Content -->
		<div class="form-box-content">
			<%
			Set invalidEmailAddresses = (Set)SessionErrors.get(renderRequest, "emailAddresses");
		
			int emailMessageMaxRecipients = InvitationUtil.getEmailMessageMaxRecipients();
		
			for (int i = 0; i < emailMessageMaxRecipients; i++) {
				String emailAddress = ParamUtil.getString(request, "emailAddress" + i);
			%>
	
			<c:if test='<%= (invalidEmailAddresses != null) && invalidEmailAddresses.contains("emailAddress" + i) %>'>
				<div class="portlet-msg-error">
					<liferay-ui:message key="please-enter-a-valid-email-address" />
				</div>
			</c:if>
	
			<div class="form-group">
				<div class="col-md-12">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope fa-fw"></i></span>
						<aui:input type="text" id='<%= "emailAddress" + i %>' label="" name='<%= "emailAddress" + i %>' title='<%= LanguageUtil.get(pageContext, "email-address") + StringPool.SPACE + (i + 1) %>' value="" class="form-control" />
					</div>
				</div>
			</div>
			<%
			}
			%>
			<div class="form-group form-actions">
				<div class="col-md-10 col-md-offset-3">
					<button type="reset" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
					<button type="submit" class="btn btn-success"><i class="fa fa-check"></i> Submit</button>
				</div>
			</div>
		</div>
		<!-- END Form Content -->
	</form>
	<!-- END Form Validation -->
	
	<!-- Javascript code only for this page -->
	<script>
	    $(function() {
	
	        /* For advanced usage and examples please check out
	         *  Jquery Validation   -> https://github.com/jzaefferer/jquery-validation
	         */
	        
	        /* Initialize Form Validation */
	        $('#inviteForm').validate({
	            errorClass: 'help-block',
	            errorElement: 'span',
	            errorPlacement: function(error, e) {
	                e.parents('.form-group > div').append(error);
	            },
	            highlight: function(e) {
	                $(e).closest('.form-group').removeClass('has-success has-error').addClass('has-error');
	                $(e).closest('.help-block').remove();
	            },
	            success: function(e) {
	                // You can use the following if you would like to highlight with green color the input after successful validation!
	                e.closest('.form-group').removeClass('has-success has-error'); // e.closest('.form-group').removeClass('has-success has-error').addClass('has-success');
	                e.closest('.help-block').remove();
	                e.closest('.help-inline').remove();
	            },
	            rules: {
	            	emailAddress0: {
	                    required: true,
	                    email: true
	                },
	                emailAddress1: {
	                    required: true,
	                    email: true
	                },
	                emailAddress2: {
	                    required: true,
	                    email: true
	                },
	                emailAddress3: {
	                    required: true,
	                    email: true
	                },
	                emailAddress4: {
	                    required: true,
	                    email: true
	                }
	            },
	            messages: {
	            	emailAddress0: 'Please enter a valid email address',
	            	emailAddress1: 'Please enter a valid email address',
	            	emailAddress2: 'Please enter a valid email address',
	            	emailAddress3: 'Please enter a valid email address',
	            	emailAddress4: 'Please enter a valid email address'
	            }
	        });
	    });
	</script>