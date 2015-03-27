<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.utils.ContactDataType"%>
<%@ include file="/html/common/init.jsp" %>

<liferay-ui:header title="Method Manager"></liferay-ui:header>

<liferay-portlet:actionURL name="addMethod" var="addMethodURL" />
<aui:form action="<%=addMethodURL.toString() %>" method="post" >
	<aui:fieldset>
		<aui:column>
			<aui:field-wrapper>
				<label class="aui-field-label" for="name">
					Name
				</label>
				<aui:input type="text" id="name" name="name" value="" class="fieldForm" />
			</aui:field-wrapper>
		</aui:column>
		<aui:column>
			<aui:field-wrapper>
				<label class="aui-field-label" for="type">
					Type
				</label>
				<aui:select id="type" name="type" class="fieldForm" >
					<aui:option value="<%=ContactDataType.TEXT.ordinal() %>" selected="true" ><%=ContactDataType.TEXT.name() %></aui:option>
					<aui:option value="<%=ContactDataType.REFERENCE.ordinal() %>" ><%=ContactDataType.REFERENCE.name() %></aui:option>
				</aui:select>
			</aui:field-wrapper>
		</aui:column>
		<aui:column>
			<aui:button-row>
				<aui:button type="submit" value="Save" cssClass="buttonInline"></aui:button>
			</aui:button-row>
		</aui:column>
	</aui:fieldset>
</aui:form>
<%
	List<ContactDataMethod> methodList = ContactDataMethodLocalServiceUtil.getAll();

	PortletURL iteratorURL = renderResponse.createActionURL();
	iteratorURL.setParameter("jspPage", "/html/admincrm/view.jsp");
%>
<h4>Method list</h4>
<liferay-ui:error key="error-method-in-use" message="Could not remove method because it used"/>
<liferay-ui:error key="invalid-method-name-key" message="Invalid method name"/>
<liferay-ui:error key="unexpected-error-key" message="unexpected-error-msg"/>
<liferay-ui:search-container delta="10" emptyResultsMessage="No Methods" iteratorURL="<%=iteratorURL %>"  >
	<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(methodList, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%=methodList.size() %>"
		>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
			className="com.leancrm.portlet.library.model.ContactDataMethod"
			keyProperty="contactDataMethodId"
			modelVar="contactDataMethod" >
		<liferay-ui:search-container-column-text name="Id" property="contactDataMethodId" />
		<liferay-ui:search-container-column-text name="Name" property="name" />
		<% if (contactDataMethod.getContactDataType() == ContactDataType.TEXT.ordinal()) {%>
			<liferay-ui:search-container-column-text name="Type" value='<%=ContactDataType.TEXT.name() + " (" + ContactDataType.TEXT.ordinal() + ")"%>' />
		<% } else {%>
			<liferay-ui:search-container-column-text name="Type" value='<%=ContactDataType.REFERENCE.name() + " (" + ContactDataType.REFERENCE.ordinal() + ")" %>' />
		<% } %>
		<liferay-ui:search-container-column-jsp name="Action" path="/html/admincrm/adminMethodsAction.jsp" align="center" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>