<%@page import="com.leancrm.portlet.validator.ValidationsUtil"%>
<%@page import="com.leancrm.portlet.utils.ConstantDefinitions"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.leancrm.portlet.utils.CustomFieldUtils"%>
<%@ include file="/html/common/init.jsp" %>

	<%
	User currentUser = user;
	List<Organization> userOrganizationList = OrganizationLocalServiceUtil.getUserOrganizations(currentUser.getUserId());
	%>
	<div class="find-company">
		<div class="text-center">
			<c:if test="<%=userOrganizationList.isEmpty() %>">
				<%
					long requestOrganizationId = CustomFieldUtils.getCustomValue(currentUser.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, currentUser.getUserId());
				%>
				<c:if test="<%=ValidationsUtil.isCompany(requestOrganizationId)%>">
					<!-- Your Content -->
					<h3>
						Welcome to CYMPLAR
					</h3>
						
					<!-- Error Tabs -->
					<div class="row">
						<div class="col-md-offset-2 col-md-8">
							<div class=" error-container">
								<p>
									We have notified your company manager. <br/>
									Please log in back again once you receive the acceptance email.
								</p>
								<p>
									<portlet:actionURL name="removeRequest" var="removeRequestURL" />
									Click <aui:a href="<%=removeRequestURL.toString() %>">here</aui:a> to change the company.
								</p>
							</div>
						</div>
					</div>
					<!-- END Error Tabs -->
				</c:if>
				<c:if test="<%=!ValidationsUtil.isCompany(requestOrganizationId) %>">
					<!-- Your Content -->
					<h3>
						Welcome to CYMPLAR
					</h3>
					<p>
						This page is for you to join a company or create your own 
					</p>
					<!-- jsp:directive.include file="/html/addOrganization/companyList.jsp" / -->
					<jsp:directive.include file="/html/addOrganization/selectOrganization.jsp" />
				</c:if>
			</c:if>
			<c:if test="<%=!userOrganizationList.isEmpty() %>">
				<!-- Your Content -->
				<h3>
					Welcome to CYMPLAR
					<small></small>
				</h3>
				<!-- Error Tabs -->
				<div class="row">
					<div class="col-md-offset-2 col-md-8">
						<div class=" error-container">
							<p>
								You are in the company <%=userOrganizationList.get(0).getName() %>
							</p>
						</div>
					</div>
				</div>
				<!-- END Error Tabs -->
			</c:if>
		</div>
	</div>