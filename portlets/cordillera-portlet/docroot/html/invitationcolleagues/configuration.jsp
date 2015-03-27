<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.leancrm.portlet.invitationcolleagues.util.InvitationUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/common/init.jsp" %>

<%
String portletResource = ParamUtil.getString(request, "portletResource");
System.out.println(portletResource);		
String redirect = ParamUtil.getString(request, "redirect");

PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);

String emailMessageSubject = ParamUtil.getString(request, "emailMessageSubject", InvitationUtil.getEmailMessageSubject(preferences));
String emailMessageBody = ParamUtil.getString(request, "emailMessageBody", InvitationUtil.getEmailMessageBody(preferences));

String editorParam = "emailMessageBody";
String editorContent = emailMessageBody;
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-ui:error key="emailMessageBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailMessageSubject" message="please-enter-a-valid-subject" />

	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" label="subject" name="preferences--emailMessageSubject--" type="text" value="<%= emailMessageSubject %>" />

		<aui:field-wrapper label="body">
			<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

			<aui:input name='<%= "preferences--" + editorParam + "--" %>' type="hidden" />
		</aui:field-wrapper>
	</aui:fieldset>

	<div class="definition-of-terms">
		<h4><liferay-ui:message key="definition-of-terms" /></h4>

		<dl>
			<dt>
				[$FROM_ADDRESS$]
			</dt>
			<dd>
				<liferay-ui:message key="the-address-of-the-email-sender" />
			</dd>
			<dt>
				[$FROM_NAME$]
			</dt>
			<dd>
				<liferay-ui:message key="the-name-of-the-email-sender" />
			</dd>
			<dt>
				[$PAGE_URL$]
			</dt>
			<dd>
				<%= PortalUtil.getLayoutFullURL(layout, themeDisplay) %>
			</dd>
			<dt>
				[$PORTAL_URL$]
			</dt>
			<dd>
				<%= company.getVirtualHostname() %>
			</dd>
			<dt>
				[$COMPANY_NAME$]
			</dt>
			<dd>
				<liferay-ui:message key="the-name-of-the-company" />
			</dd>
			<dt>
				[$COMPANY_CODE$]
			</dt>
			<dd>
				<liferay-ui:message key="the-code-of-the-company" />
			</dd>
		</dl>
	</div>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(editorContent) %>";
	}

	function <portlet:namespace />saveConfiguration() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= editorParam %>.value = window.<portlet:namespace />editor.getHTML();
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.docroot.html.invitationcolleagues.configuration.jsp";
%>