<%@page import="com.leancrm.portlet.library.service.IndustryLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.ListTypeConstants"%>
<%@ include file="/html/common/init.jsp" %>

<!-- Your Content -->
<div class="add-organization">
<h3 class="">
	Organization name
</h3>

	<liferay-ui:error key="company-invalid" message="company-invalid" />
	<liferay-ui:error key="country-invalid" message="country-invalid" />
	<liferay-ui:error key="postalcode-invalid" message="postalcode-invalid" />
	<liferay-ui:error key="city-invalid" message="city-invalid" />
	<liferay-ui:error key="street-invalid" message="street-invalid" />
	
	<liferay-portlet:actionURL name="createOrganization" var="createOrganizationURL"/>
	<form id="createOrganization" action="<%=createOrganizationURL.toString() %>" method="post" class="form-horizontal form-box remove-margin">
		<div class="form-box-content">
			<div class="control-group row-fluid">
				<!-- Company Name -->
				<div class="controls span6">
						<aui:input type="text" id="name" name="name" placeholder="Company Name" cssClass="span12" value="${name}" label="" autocomplete="off"/>
				</div>
				<!-- Tax Id -->
				<div class="controls span6">
						<aui:input label="" placeholder="ABN" type="text" id="taxId" name="taxId" cssClass="span12" value="${taxId}" autocomplete="off"/>
				</div>
			</div>
			<div class="control-group row-fluid">
				<!-- Industry -->
				<div class="controls">
					<aui:select id="industryId" name="industryId" label="" autocomplete="off" multiple="multiple" cssClass="span8">
						<aui:option value="-1">(Choose an industry)</aui:option>
						<c:forEach items="<%=IndustryLocalServiceUtil.getAllOrdered() %>" var="industry">
							<aui:option value="${industry.industryId}">${industry.name}</aui:option>
						</c:forEach>
					</aui:select>
				</div>
			</div>
			<div class="control-group row-fluid">
				<!-- Country -->
				<div class="controls span6">
					<aui:select id="countryId" label="" name="countryId" cssClass="span12">
						<aui:option value="0">Country</aui:option>
					</aui:select>
				</div>
				<!-- Region -->
				<div class="controls span6">
					<aui:select id="regionId" label="" name="regionId" cssClass="span12">
						<aui:option value="0">Region</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="control-group row-fluid">
				<!-- Postal Code -->
				<div class="controls span6">
						<aui:input label="" type="text" id="postalCode" placeholder="Postal Code" name="postalCode" cssClass="span12" value="${postalCode}" autocomplete="off"/>
				</div>
				<!-- City -->
				<div class="controls span6">
						<aui:input label="" type="text" id="city" name="city" placeholder="City" cssClass="span12" value="${city}" autocomplete="off"/>
				</div>
			</div>
			<div class="control-group row-fluid">
				<!-- Street 1 -->
				<div class="controls span6">
						<aui:input label="" type="text" id="street1" name="street1" placeholder="Street 1" cssClass="span12" value="${street1}" autocomplete="off"/>
				</div>
				<!-- Street 2 -->
				<div class="controls span6">
						<aui:input label="" type="text" id="street2" name="street2" placehoder="Street 2" cssClass="span12" value="${street2}" autocomplete="off"/>
				</div>
			</div>
			<div class="control-group row-fluid">
				<!-- Street 3 -->
				<div class="controls span6">
						<aui:input label="" type="text" id="street3" name="street3" placehoder="Street 3" cssClass="span12" value="${street3}" autocomplete="off"/>
				</div>
				<!-- Other -->
				<div class="controls span6">
						<aui:input label="" type="text" id="Other" name="Other" placeholder="Other" cssClass="span12" value="${Other}" autocomplete="off"/>
					</div>
			</div>
			<div class="form-group clearfix">
				<div class="pull-right">
					<portlet:renderURL var="showCompanyListURL">
						<portlet:param name="jspPage" value="/html/addOrganization/view.jsp"/>
					</portlet:renderURL>
					<button type="button" class="btn btn-warning" onclick="javascript:back('<%=showCompanyListURL.toString() %>')"><i class="fa fa-times"></i> Cancel</button>
					<button type="reset" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
					<button type="submit" class="btn btn-success"><i class="fa fa-check"></i> Submit</button>
				</div>
			</div>
		</div>
	</form>
</div>
	
<!-- End Your Content -->

<script>
	function back(url) {
		console.log("B A C K");
		window.location = url;
	}
</script>

<aui:script use="liferay-dynamic-select,liferay-search-container">
	new Liferay.DynamicSelect(
		[
			{
				select: '<portlet:namespace />countryId',
				selectData: Liferay.Address.getCountries,
				selectDesc: 'name',
				selectId: 'countryId',
				selectVal: '0'
			},
			{
				select: '<portlet:namespace />regionId',
				selectData: Liferay.Address.getRegions,
				selectDesc: 'name',
				selectId: 'regionId',
				selectVal: '0'
			}
		]
	);

	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />parentOrganizationSearchContainer');

	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;
			var tr = link.ancestor('tr');

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);
</aui:script>