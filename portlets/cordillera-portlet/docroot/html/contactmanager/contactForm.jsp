<%@page import="com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Enterprise"%>
<%@page import="com.leancrm.portlet.library.service.IndustryLocalServiceUtil"%>
<%@ include file="/html/common/init.jsp" %>

<!-- Company And Contact Form -->

<liferay-portlet:actionURL var="updateContactInfoURL" name="updateContactInfo" />
<form action="<%=updateContactInfoURL.toString() %>" method="post" name="contactForm" id="contactForm" class="form-box remove-margin" autocomplete="off">
<div class="accordionContact dropdown">
	<!-- Company Form Header -->
	<h4 class="form-box-header dropdown-toggle">
		<liferay-ui:message key="Add/Edit New Company" />
		<small>			
		</small>
	</h4>
	<div class="accordionWrap">
	<!-- End Company Form Header -->
	
	<!-- Error messages  -->
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_NAME %>" message="invalid-contact-name-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INPUT_TEXT_TOO_LONG %>" message="text-too-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_CELLPHONE %>" message="invalid-contact-cellphone-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_EMAIL %>" message="invalid-contact-email-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_SKYPE %>" message="invalid-contact-skype-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_POSITION %>" message="invalid-contact-position-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_PHONE %>" message="invalid-contact-phone-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_CONTACT_PERSONAL_EMAIL %>" message="invalid-contact-personal-email-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.EMPTY_ENTERPRISE_NAME %>" message="empty-enterprise-name-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INPUT_TEXT_TOO_LONG %>" message="text-too-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.EMPTY_ENTERPRISE_STREET1 %>" message="empty-enterprise-street1-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.EMPTY_ENTERPRISE_ZIP_CODE %>" message="empty-enterprise-zip-code-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.EMPTY_ENTERPRISE_CITY %>" message="empty-enterprise-city-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.INVALID_ENTERPRISE_EMAIL %>" message="invalid-enterprise-email-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.EMPTY_ENTERPRISE_COUNTRY %>" message="empty-enterprise-country-msg"/>
	<liferay-ui:error key="<%=CRMErrorKey.NON_EXIXTENT_ADDRESS_BOOK %>" message="non-existent-address-book-msg"/>
	
	<!-- Company Fields -->
	<aui:input type="checkbox" id="isPrivate" name="isPrivate" label="Private" autocomplete="off"/>

	<div id="enterpriseInfo">
		<!-- Typeahead -->
		<aui:input type="hidden" name="enterpriseId" label="Enterprise ID" id="enterpriseId" value="" autocomplete="off" />
		<aui:input onblur="javascript:fixEnterpriseSelected()" type="text" id="enterpriseName" name="enterpriseName" placeholder="search.." autocomplete="off" label="Name" />
		<!-- END Typeahead -->
		
		<aui:input type="text" id="description" name="description" autocomplete="off" label="Description"/>
	
		<aui:input type="text" id="enterpriseEmail" name="enterpriseEmail" autocomplete="off" label="Email"/>
	
		<aui:input type="text" id="taxid" name="taxid" autocomplete="off" label="ABN" />
		<!-- <span class="help-block">99-9999999</span> -->
	
		<aui:select id="industryId" name="industryId" label="Industry" autocomplete="off" multiple="multiple" >
			<c:forEach items="<%=IndustryLocalServiceUtil.getAllOrdered() %>" var="industry">
				<aui:option value="${industry.industryId}">${industry.name}</aui:option>
			</c:forEach>
		</aui:select>
	
		<aui:input type="text" id="street1" name="street1" label="Street 1" autocomplete="off" />
	
		<aui:input type="text" id="street2" name="street2" autocomplete="off" label="Street 2" />
	
		<aui:input type="text" id="street3" name="street3" autocomplete="off" label="Suburb" />
	
		<aui:select id="countryId" name="countryId" label="Country" autocomplete="off">
			<c:forEach items="<%=CountryServiceUtil.getCountries() %>" var="country">
				<aui:option value="${country.countryId}">${country.name}</aui:option>
			</c:forEach>
		</aui:select>
	
		<aui:input type="text" id="zip" name="zip" autocomplete="off" label="Postal Code" />
	
		<aui:input type="text" id="city" name="city" autocomplete="off" label="City" />
	</div>
</div>
</div>

	<!-- End Company Fields -->
	<div class="accordionContact dropdown">
	<!-- Contact Form Header -->
	<h4 class="form-box-header dropdown-toggle">
		<liferay-ui:message key="Add/Edit Contact" />
		<small>
			
		</small>
	</h4>
	<!-- End Contact Form Header -->
	<div class="accordionWrap">
	<!-- Contact Fields -->
	<aui:input type="hidden" id="contactId" name="contactId" value="" autocomplete="off" label="" />

	<aui:input type="text" id="fullName" name="fullName" label="Full Name" />

	<aui:input type="text" id="position" name="position" label="Position" />

	<aui:input type="text" id="phone" name="phone" label="Phone" />
	<!-- 	<span class="help-block">(999) 999-9999</span> -->

	<aui:input type="text" id="cellPhone" name="cellPhone" label="Mobile" />
	<!-- 	<span class="help-block">(999) 999-9999</span> -->

	<aui:input type="text" id="skype" name="skype" label="Skype" />

	<aui:input type="text" id="email" name="email" label="Email" />

	<aui:input type="text" id="personalEmail" name="personalEmail" label="Personal Email" />
</div>
</div>
	<div class="buton-wrap">
		<button type="reset" class="btn btn-info">Reset</button>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>	
	<!-- End Contact Fields -->
</form>

 
<liferay-portlet:actionURL var="getEnterprisesURL" name="getEnterprises" />
<liferay-portlet:actionURL var="showEnterpriseDetailURL" name="showEnterpriseDetail" />

<liferay-portlet:resourceURL id="autocomplete" var="autocompleteURL" />

<aui:script use="autocomplete-list,datasource-io">

var datasource = new A.DataSource.IO({
	source: '<%=autocompleteURL%>'
});

AUI().use(
'autocomplete-list',
	function (A) {
		var autoc = new A.AutoCompleteList({
			// allowBrowserAutocomplete: 'false',
			activateFirstItem: 'true',
			inputNode: '#<portlet:namespace />enterpriseName',
			maxResults: 10,
			render: 'true',
			source: datasource,
			requestTemplate: '&<portlet:namespace />keywords={query}',
			on: {
				select: function(event) {
					var result = event.result.raw;
					fillEnterpriseDetail(result);
				},
				clear: function(prevVal, src) {
					//console.log("(clear) Prev Val: " + prevVal);
					cleanEnterpriseDetail();
				},
				query: function(inputValue, query, src) {
					//console.log("(query) Input Value: " + inputValue);
					//console.log("(query) Query: " + query);
				},
				render: function() {
				},
				results: function(data, query, results) {
					//cleanEnterpriseDetail();
					return results;
				}
			},
			resultListLocator: function (response) {
				var responseData = A.JSON.parse(response[0].responseText);
				return responseData.response;
			},
			resultTextLocator: function (result) {
				//if (result.taxid != null && result.taxid != 'undefined' && result.taxid != '') {
				//	return result.enterpriseName + ' (' + result.taxid + ')';
				//} else {
					return result.enterpriseName;
				//}
			},
			//requestTemplate: '',
			//width: 400
		});
	}
);
</aui:script>

<aui:script use="aui-form-validator">

YUI().use(
	'aui-form-validator',
	function(Y) {
		var rules = {
        	<portlet:namespace />enterpriseName: {
        		required: true
        	},
            <portlet:namespace />description: {
        		maxlength: 70
        	},
        	<portlet:namespace />enterpriseEmail: {
                email: true,
                maxlength: 70
        	},
        	<portlet:namespace />street1: {
        		required: true,
        		maxlength: 70
        	},
        	<portlet:namespace />street2: {
        		maxlength: 70
        	},
        	<portlet:namespace />street3: {
        		maxlength: 70
        	},
        	<portlet:namespace />countryId: {
        		required: true
        	},
        	<portlet:namespace />zip: {
        		required: true,
        		maxlength: 20
        	},
        	<portlet:namespace />city: {
        		required: true,
        		maxlength: 70
        	},
        	<portlet:namespace />fullName: {
        		required: true,
        		maxlength: 70
        	},
        	<portlet:namespace />position: {
        		maxlength: 70
        	},
        	<portlet:namespace />email: {
                email: true,
                maxlength: 70
        	},
        	<portlet:namespace />personalEmail: {
                email: true,
                maxlength: 70
        	},
		};
		var fieldStrings = {
			<portlet:namespace />description: 'Company description must be lowest that 70 characters',
			<portlet:namespace />enterpriseEmail: 'Please enter a valid company email address',
			<portlet:namespace />street1: 'Please enter a street 1',
			<portlet:namespace />street2: 'Street 2 must be lowest that 70 characters',
			<portlet:namespace />street3: 'Suburb must be lowest that 70 characters',
			<portlet:namespace />country: 'Please select a Country',
			<portlet:namespace />zip: 'Please enter a Postal Code',
			<portlet:namespace />city: 'Please enter a City',
			<portlet:namespace />fullName: 'Please enter a Contact Full Name',
			<portlet:namespace />position: 'Position must be lowest that 70 characters',
			<portlet:namespace />email: 'Please enter a valid contact email address',
			<portlet:namespace />personalEmail: 'Please enter a valid contact personal email address',
		};
		new Y.FormValidator({
			boundingBox: '#contactForm',
			fieldStrings: fieldStrings,
			rules: rules,
			showAllMessages: true
		});
		
		
		// process clicking on private checkbox
		Y.one('#<portlet:namespace/>isPrivateCheckbox').on('click', function(){
			var isPrivate = document.getElementById("<portlet:namespace />isPrivateCheckbox").checked;
			if (isPrivate) {
				Y.one('#enterpriseInfo').hide();	
			} else {
				Y.one('#enterpriseInfo').show();
			}
			
		});
	}
);
</aui:script>

<script>

function cleanEnterpriseDetail() {
	console.log("Clean Enterprise Detail")
	document.getElementById("<portlet:namespace />isPrivateCheckbox").checked = false;
	document.getElementById("<portlet:namespace />description").value = '';
	document.getElementById("<portlet:namespace />enterpriseEmail").value = '';
	document.getElementById("<portlet:namespace />taxid").value = '';
	document.getElementById("<portlet:namespace />industryId").value = -1; // Multi Select
	document.getElementById("<portlet:namespace />street1").value = '';
	document.getElementById("<portlet:namespace />street2").value = '';
	document.getElementById("<portlet:namespace />street3").value = '';
	document.getElementById("<portlet:namespace />countryId").value = -1;
	document.getElementById("<portlet:namespace />zip").value = '';
	document.getElementById("<portlet:namespace />city").value = '';
}

function fillEnterpriseDetail(enterprise) {
	// according to https://github.com/Neulinet/cymplar/issues/5 - populate only name - but not other data
	document.getElementById("<portlet:namespace />enterpriseName").value = enterprise.enterpriseName;
}    

function fixEnterpriseSelected() {
	var enterpriseId = document.getElementById("<portlet:namespace />enterpriseId").value;
	console.log("EntId: " + enterpriseId);
	if (enterpriseId === null || enterpriseId.length === 0) {
		// document.getElementById("_contactmanager_WAR_cordilleraportlet_enterpriseSelect").value = "";
		cleanEnterpriseDetail();
	}
}

function fillContactForm(data) {
	console.log('DATA EN CONTACT FORM: ' + data);
	document.getElementById('<portlet:namespace />enterpriseId').value = data.enterpriseId;
	console.log('DATA EN CONTACT FORM - ENTERPRISE NAME: ' + data.enterpriseName);
	document.getElementById('<portlet:namespace />enterpriseName').value = data.enterpriseName;
	document.getElementById('<portlet:namespace />description').value = data.enterpriseDescription;
	document.getElementById('<portlet:namespace />enterpriseEmail').value = data.enterpriseEmail;
	document.getElementById('<portlet:namespace />taxid').value = data.enterpriseAbn;
	document.getElementById('<portlet:namespace />industryId').value = data.enterpriseIndustry;
	document.getElementById('<portlet:namespace />street1').value = data.enterpriseStreet1;
	document.getElementById('<portlet:namespace />street2').value = data.enterpriseStreet2;
	document.getElementById('<portlet:namespace />street3').value = data.enterpriseSuburb;
	document.getElementById('<portlet:namespace />countryId').value = data.enterpriseCountry;
	document.getElementById('<portlet:namespace />zip').value = data.enterprisePostalCode;
	document.getElementById('<portlet:namespace />city').value = data.enterpriseCity;
	
	document.getElementById('<portlet:namespace />contactId').value = data.contactId;
	document.getElementById('<portlet:namespace />fullName').value = data.fullName;
	document.getElementById('<portlet:namespace />position').value = data.position;
	document.getElementById('<portlet:namespace />phone').value = data.phone;
	document.getElementById('<portlet:namespace />cellPhone').value = data.mobile;
	document.getElementById('<portlet:namespace />skype').value = data.skype;
	document.getElementById('<portlet:namespace />email').value = data.email;
	document.getElementById('<portlet:namespace />personalEmail').value = data.personalEmail;
}
</script>