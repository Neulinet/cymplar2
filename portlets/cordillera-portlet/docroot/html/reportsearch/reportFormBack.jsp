<%@ include file="/html/common/init.jsp" %>

<liferay-portlet:actionURL var="searchURL" name="search" portletName="reportSearchResult_WAR_cordilleraportlet" />
<form action="<%=searchURL.toString() %>" method="post" name="searchReportForm" id="searchReportForm" class="form-horizontal form-box remove-margin">
	<!-- Form Header -->
	<h4 class="form-box-header">
		<liferay-ui:message key="" />
		<small>
		</small>
	</h4>

	<!-- Form Content -->
	<div class="form-box-content">
		<!-- Consultant Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportsearch_WAR_cordilleraportlet_consultant">Consultant</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getEnterprisesURL" name="getEnterprises" />
				<select id="_reportsearch_WAR_cordilleraportlet_consultant" name="consultant" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getEnterpriseList(this, '<%=getEnterprisesURL.toString() %>')">
					<option value="-1">Choose a ...</option>
				</select>
				<input type="hidden" name="consultantId" value="<%=user.getUserId() %>" />
			</div>
		</div>
		<!-- Company Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportsearch_WAR_cordilleraportlet_enterprise">Company</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="searchByEnterpriseURL" name="searchByEnterprise" />
				<select id="_reportsearch_WAR_cordilleraportlet_enterprise" name="enterprise" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContactsAndContracts(this, '<%=searchByEnterpriseURL %>')">
					<option value="-1">Choose a company...</option>
				</select>
			</div>
		</div>
		<!-- Contact Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportsearch_WAR_cordilleraportlet_contact">Contact</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getContractsURL" name="getContracts" />
				<select id="_reportsearch_WAR_cordilleraportlet_contact" name="contact" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContracts(this, '<%=getContractsURL %>')">
					<option value="-1">Choose a contact...</option>
				</select>
			</div>
		</div>
		<!-- Contract Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportsearch_WAR_cordilleraportlet_contract">Contract</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getContractDetailURL" name="getContractDetail" />
				<select id="_reportsearch_WAR_cordilleraportlet_contract" name="contract" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContractDetail(this, '<%=getContractDetailURL %>')">
					<option value="-1">Choose a contract...</option>
				</select>
			</div>
		</div>
		<!-- Progress -->
		<!-- Status -->
		<div class="form-group">
			<label class="control-label col-md-3">Status</label>
			<div class="col-md-9">
				<label class="checkbox-inline" for="example-checkbox-inline1">
					<input type="checkbox" id="_reportsearch_WAR_cordilleraportlet_statusCode1" name="statusCode" value="0"> Cold
				</label>
				<label class="checkbox-inline" for="example-checkbox-inline2">
					<input type="checkbox" id="_reportsearch_WAR_cordilleraportlet_statusCode2" name="statusCode" value="100"> Warm
				</label>
				<label class="checkbox-inline" for="example-checkbox-inline3">
					<input type="checkbox" id="_reportsearch_WAR_cordilleraportlet_statusCode3" name="statusCode" value="200"> Hot
				</label>
				<label class="checkbox-inline" for="example-checkbox-inline3">
					<input type="checkbox" id="_reportsearch_WAR_cordilleraportlet_statusCode4" name="statusCode" value="300"> Inactive
				</label>
			</div>
		</div>
		<!-- From Date -->
		<div class="form-group">
			<label class="control-label col-md-3" for="">From</label>
			<div class="col-md-9">
				<div class="input-group date input-datepicker" data-date="04-30-2013" data-date-format="mm-dd-yyyy">
					<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportsearch_WAR_cordilleraportlet_fromDate" name="fromDate" class="form-control">
				</div>
			</div>
		</div>
		<!-- To Date -->
		<div class="form-group">
			<label class="control-label col-md-3" for="">To</label>
			<div class="col-md-9">
				<div class="input-group date input-datepicker" data-date="04-30-2013" data-date-format="mm-dd-yyyy">
					<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportsearch_WAR_cordilleraportlet_toDate" name="toDate" class="form-control">
				</div>
			</div>
		</div>
		<div class="form-group form-actions">
			<div class="col-md-12 col-md-offset-3">
				<button type="reset" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
				<button type="submit" class="btn btn-success"><i class="fa fa-check"></i> Submit</button>
			</div>
		</div>
	</div>
	<!-- End Form Content -->
</form>
	
	<!-- form action="" method="post" id="_reportsearch_WAR_cordilleraportlet_searchReportForm" class="_reportsearch_WAR_cordilleraportlet_form">
		<aui:field-wrapper>
			<label class="aui-field-label" for="_reportsearch_WAR_cordilleraportlet_progressVal1">Progress Range:
				<span id="_reportsearch_WAR_cordilleraportlet_progressVal1">0% - 100%</span>
			</label>
			<input type="hidden" id="_reportsearch_WAR_cordilleraportlet_progress0" name="fromProgress" value="0" />
			<input type="hidden" id="_reportsearch_WAR_cordilleraportlet_progress1" name="toProgress" value="100" />
			<div id="_reportsearch_WAR_cordilleraportlet_slider-range" class="slider"></div>
		</aui:field-wrapper>
	</form -->
	
<%-- 	<aui:button-row cssClass="_reportsearch_WAR_cordilleraportlet_buttonSection"> --%>
<%-- 		<aui:button value="reset" cssClass="_reportsearch_WAR_cordilleraportlet_mediumButton" onClick="javascript:_reportsearch_WAR_cordilleraportlet_cleanAll()" /> --%>
<%-- 		<liferay-portlet:actionURL var="addReportURL" name="addReport" /> --%>
<!-- 		<button id="_reportsearch_WAR_cordilleraportlet_searchReportButton" onclick="_reportsearch_WAR_cordilleraportlet_searchReport('searchURL.toString()')"  class="_reportsearch_WAR_cordilleraportlet_bigButton">Search</button> -->
<%-- 	</aui:button-row> --%>

<liferay-portlet:actionURL var="getConsultantsURL" name="getConsultants" />

<script>
	
	/** Auxiliar methods **/
	function _reportsearch_WAR_cordilleraportlet_loadingSelect(select) {
		if (select != null) {
			select.innerHTML = '<option value="-2">Loading...</option>';
		}
	}
	
	function _reportsearch_WAR_cordilleraportlet_parseJson(text) {
		return JSON.parse(text);
	}
	
	function _reportsearch_WAR_cordilleraportlet_setDate(inputId, d) {
		$(inputId).datepicker('setDate', new Date(d));
	}
	
	function _reportsearch_WAR_cordilleraportlet_setToDate(d) {
		var toDate = new Date(d);
		$("#_reportsearch_WAR_cordilleraportlet_toDate").datepicker('setDate', toDate);
		$( "#_reportsearch_WAR_cordilleraportlet_fromDate" ).datepicker( "option", "maxDate", toDate );
	}
	
	function _reportsearch_WAR_cordilleraportlet_setFromDate(d) {
		var fromDoday = new Date(d);
		$("#_reportsearch_WAR_cordilleraportlet_fromDate").datepicker('setDate', fromDoday);
		$( "#_reportsearch_WAR_cordilleraportlet_toDate" ).datepicker( "option", "minDate", fromDoday );
		console.log('Set Date: ' + d);
	}
	
	/** Loader form methods **/
	
	function _reportsearch_WAR_cordilleraportlet_loadConsultantList(consultantList, currentConsultant, select) {
		var options = '';
		
		if (consultantList) {
			if (consultantList.length > 1) {
				options = '<option value="-1">All Consultants</option>';
			}
			
			for (var i=0; i<consultantList.length; i++) {
				if (currentConsultant == consultantList[i].id) {
					options += '<option selected="selected" value="' + consultantList[i].id + '">' + consultantList[i].name + '</option>';
				} else {
					options += '<option value="' + consultantList[i].id + '">' + consultantList[i].name + '</option>';
				}
			}

			select.innerHTML = options;
			select.onchange();
		}
	}
	
	function _reportsearch_WAR_cordilleraportlet_loadEnterpriseList(enterpriseList, select) {
		var options = '<option value="-1">Choose a company...</option>';
		if (enterpriseList) {
			for (var i=0; i<enterpriseList.length; i++) {
				options += '<option value="' + enterpriseList[i].id + '">' + enterpriseList[i].name + ' ' + enterpriseList[i].taxid + '</option>';
			}
		}
		
		select.innerHTML = options;
	}
	
	function _reportsearch_WAR_cordilleraportlet_loadContacts(contactList, select) {
		//_reportsearch_WAR_cordilleraportlet_cleanContactMethods();
		var options = '<option value="-1">Choose a contact...</option>';
		if (contactList) {
			for (var i=0; i<contactList.length; i++) {
				options += '<option value="' + contactList[i].id + '">' + contactList[i].name + '</option>';
			}
		}
		
		select.innerHTML = options;
	}
	
	function _reportsearch_WAR_cordilleraportlet_loadContracts(contractList, select) {
		//_reportsearch_WAR_cordilleraportlet_cleanContractDetails();
		var options = '<option value="-1">Choose a contract...</option>';
		if (contractList) {
			for (var i=0; i<contractList.length; i++) {
				options += '<option value="' + contractList[i].id + '">' + contractList[i].description + '</option>';
			}
		}
		
		select.innerHTML = options;
	}
	
	function _reportsearch_WAR_cordilleraportlet_loadContractDetail(contractDetail) {
		_reportsearch_WAR_cordilleraportlet_setFromDate(contractDetail.reportDate);
	}
	
	/** Data retrieve methods **/
	
	function _reportsearch_WAR_cordilleraportlet_getConsultantList(actionUrl) {
		console.log('Query getConsultantList:');
		$.ajax({
			async: false,
			url:actionUrl,
			data: {},
			success: function(result) {
				console.log('Response getConsultantList: ' + result);
				var select = document.getElementById('_reportsearch_WAR_cordilleraportlet_consultant');
				_reportsearch_WAR_cordilleraportlet_loadingSelect(select);
				var json = _reportsearch_WAR_cordilleraportlet_parseJson(result);
				_reportsearch_WAR_cordilleraportlet_loadConsultantList(json.consultants, json.currentConsultant, select);
			}
		});
	}
	
	function _reportsearch_WAR_cordilleraportlet_getEnterpriseList(select, actionUrl) {
		console.log('Query getEnterpriseList:');
		var index = select.selectedIndex;
    	var consultantId = select.options[index].value;
		$.ajax({
			async: false,
			url:actionUrl,
			data: {
				consultantId:consultantId
			},
			success: function(result) {
				console.log('Response getEnterpriseList: ' + result);
				
				_reportsearch_WAR_cordilleraportlet_cleanEnterpriseSearchDetail();
				
				var json = _reportsearch_WAR_cordilleraportlet_parseJson(result);
				
				var select = document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise');
				_reportsearch_WAR_cordilleraportlet_loadingSelect(select);
				_reportsearch_WAR_cordilleraportlet_loadEnterpriseList(json.enterprises, select);
				
				_reportsearch_WAR_cordilleraportlet_loadContractDetail(json);
			}
		});
	}
	
	function _reportsearch_WAR_cordilleraportlet_getContactsAndContracts(select, actionUrl) {
		console.log('Query getContactsAndContracts:');
		var index = select.selectedIndex;
    	var enterpriseId = select.options[index].value;
    	if (enterpriseId != -1) {
    		var consultantSelected = document.getElementById('_reportsearch_WAR_cordilleraportlet_consultant');
			$.ajax({
				async: false,
				url:actionUrl,
				data: {
					enterpriseId:enterpriseId,
					consultantId:consultantSelected.value
				},
				success: function(result) {
					console.log('Response getContactsAndContracts: ' + result);
					
					var json = _reportsearch_WAR_cordilleraportlet_parseJson(result);
					
					var selectContact = document.getElementById('_reportsearch_WAR_cordilleraportlet_contact');
					_reportsearch_WAR_cordilleraportlet_loadingSelect(selectContact);
					_reportsearch_WAR_cordilleraportlet_loadContacts(json.contacts, selectContact);
					
					var selectContract = document.getElementById('_reportsearch_WAR_cordilleraportlet_contract');
					_reportsearch_WAR_cordilleraportlet_loadingSelect(selectContract);
					_reportsearch_WAR_cordilleraportlet_loadContracts(json.contracts, selectContract);
					
					_reportsearch_WAR_cordilleraportlet_loadContractDetail(json);
				}
			});
    	} else {
    		_reportsearch_WAR_cordilleraportlet_cleanEnterpriseSearchDetail();
    	}
	}
	
	function _reportsearch_WAR_cordilleraportlet_getContracts(select, actionUrl) {
		console.log('Query getContracts:');
		var index = select.selectedIndex;
    	var contactId = select.options[index].value;
    	if (contactId != -1) {
    		var consultantSelected = document.getElementById('_reportsearch_WAR_cordilleraportlet_consultant');
    		var enterpriseSelected = document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise');
			$.ajax({
				async: false,
				url:actionUrl,
				data: {
					contactId: contactId,
					consultantId:consultantSelected.value,
					enterpriseId:enterpriseSelected.value
				},
				success: function(result) {
					console.log('Response getContracts: ' + result);
					
					var json = _reportsearch_WAR_cordilleraportlet_parseJson(result);
					
					var select = document.getElementById('_reportsearch_WAR_cordilleraportlet_contract');
					_reportsearch_WAR_cordilleraportlet_loadingSelect(select);
					_reportsearch_WAR_cordilleraportlet_loadContracts(json.contracts, select);
					
					_reportsearch_WAR_cordilleraportlet_loadContractDetail(json);
				},
				error: function(error) {
					console.log('error');
				}
			});
    	} else {
    		//_reportsearch_WAR_cordilleraportlet_cleanContactSearchDetails();
    	}
	}
	
	function _reportsearch_WAR_cordilleraportlet_getContractDetail(select, actionUrl) {
		console.log('Query getContractDetail:');
		var index = select.selectedIndex;
    	var contractId = select.options[index].value;
    	if (contractId != -1) {
    		var consultantSelected = document.getElementById('_reportsearch_WAR_cordilleraportlet_consultant');
			$.ajax({
				async: false,
				url:actionUrl,
				data: {
					contractId:contractId,
					consultantId:consultantSelected.value
				},
				success: function(result) {
					console.log('Response getContractDetail: ' + result);
					_reportsearch_WAR_cordilleraportlet_loadContractDetail(_reportsearch_WAR_cordilleraportlet_parseJson(result));
				}
			});
    	} else {
    		//_reportsearch_WAR_cordilleraportlet_cleanSearchContractDetails();
    	}
	}
	
	/** Cleaners form methods **/
	
	function _reportsearch_WAR_cordilleraportlet_cleanEnterpriseSearchDetail() {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_enterprise").value = -1;
		document.getElementById("_reportsearch_WAR_cordilleraportlet_contact").innerHTML = '<option value="-1">Choose a contact...</option>';
		_reportsearch_WAR_cordilleraportlet_cleanContactSearchDetails();
	}
	
	function _reportsearch_WAR_cordilleraportlet_cleanContactSearchDetails() {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_contact").value = -1;
	   	document.getElementById("_reportsearch_WAR_cordilleraportlet_contract").innerHTML = '<option value="-1">Choose a contract...</option>';
	   	_reportsearch_WAR_cordilleraportlet_cleanSearchContractDetails();
	}
	
	function _reportsearch_WAR_cordilleraportlet_cleanSearchContractDetails() {
		var fromDoday = new Date();
		fromDoday.setDate(fromDoday.getDate()-30);
		
		_reportsearch_WAR_cordilleraportlet_setFromDate(fromDoday);
		
		_reportsearch_WAR_cordilleraportlet_setToDate(new Date());
		
		$( "#_reportsearch_WAR_cordilleraportlet_statusCode1" ).prop("checked", false);
		$( "#_reportsearch_WAR_cordilleraportlet_statusCode2" ).prop("checked", false);
		$( "#_reportsearch_WAR_cordilleraportlet_statusCode3" ).prop("checked", false);
		
		$( "#_reportsearch_WAR_cordilleraportlet_progress0" ).val( 0 );
		$( "#_reportsearch_WAR_cordilleraportlet_progress1" ).val( 100 );
		$( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider({ values: [ 0, 100 ] });
		$( "#_reportsearch_WAR_cordilleraportlet_progressVal1" ).text( 0 + "% - " + 100 + "%" );
	}
	
	function _reportsearch_WAR_cordilleraportlet_cleanAll() {
		_reportsearch_WAR_cordilleraportlet_cleanEnterpriseSearchDetail();
		document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise').focus();
	}

	/** Initializer methods **/
	
	function _reportsearch_WAR_cordilleraportlet_loadFormComponents() {
		console.log('Loading components...');
		
		$( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider({
			range: true,
			min: 0,
			max: 100,
			step: 20,
			values: [ 0, 100 ],
			slide: function( event, ui ) {
				$( "#_reportsearch_WAR_cordilleraportlet_progress0" ).val( ui.values[ 0 ] );
				$( "#_reportsearch_WAR_cordilleraportlet_progress1" ).val( ui.values[ 1 ] );
				$( "#_reportsearch_WAR_cordilleraportlet_progressVal1" ).text( ui.values[ 0 ] + "% - " + ui.values[ 1 ] + "%" );
			}
		});

		$( "#_reportsearch_WAR_cordilleraportlet_progress0" ).val( $( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider( "values", 0 ) );
		$( "#_reportsearch_WAR_cordilleraportlet_progress1" ).val( $( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider( "values", 1 ) );
		$( "#_reportsearch_WAR_cordilleraportlet_progressVal1" ).text( $( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider( "values", 0 ) + "% - " + $( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider( "values", 1 ) + "%" );
		
		$( "#_reportsearch_WAR_cordilleraportlet_fromDate" ).datepicker({
			showOn: 'both',
			buttonImage: '<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/calendar-add.png") %>',
			buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 3,
			maxDate: 0,
			dateFormat: 'dd/mm/yy',
			onClose: function( selectedDate ) {
				$( "#_reportsearch_WAR_cordilleraportlet_toDate" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		var fromDoday = new Date();
		fromDoday.setDate(fromDoday.getDate()-30);
		$("#_reportsearch_WAR_cordilleraportlet_fromDate").datepicker('setDate', fromDoday);
		
		$( "#_reportsearch_WAR_cordilleraportlet_toDate" ).datepicker({
			showOn: 'both',
			buttonImage: '<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/calendar-add.png") %>',
			buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 3,
			maxDate: 0,
			dateFormat: 'dd/mm/yy',
			onClose: function( selectedDate ) {
				$( "#_reportsearch_WAR_cordilleraportlet_fromDate" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
		var toDate = new Date();
		$("#_reportsearch_WAR_cordilleraportlet_toDate").datepicker('setDate', toDate);
		
		$( "#_reportsearch_WAR_cordilleraportlet_toDate" ).datepicker( "option", "minDate", fromDoday );
		$( "#_reportsearch_WAR_cordilleraportlet_fromDate" ).datepicker( "option", "maxDate", toDate );
		
		console.log('Components loaded');			
	}
	
	$( document ).ready(function() {
		console.log('Initializing search form...');
		_reportsearch_WAR_cordilleraportlet_loadFormComponents();
		_reportsearch_WAR_cordilleraportlet_getConsultantList('<%=getConsultantsURL.toString() %>');
		console.log('Search form initialazed');
	});
	
	/** Data sender methods **/
	
	function _reportsearch_WAR_cordilleraportlet_searchReport(actionUrl) {
		// showLoading();
		console.log('Query searchReport:');
		document.getElementById("_reportsearch_WAR_cordilleraportlet_results").innerHTML = "Loading";
		$.ajax({
			async: false,
			url:actionUrl,
			type: "POST",
			data: $("#_reportsearch_WAR_cordilleraportlet_searchReportForm").serialize(), 
			success: function(result) {
				try {
					console.log("Response searchReport: " + result);
					document.getElementById("_reportsearch_WAR_cordilleraportlet_results").innerHTML = result;
					
					$(document).ready(function() {
						jQuery.fn.dataTableExt.oSort['usdate-asc']  = function(a,b) {
						    var usDatea = a.split('/'); 
						    var usDateb = b.split('/'); 
						    
						    var x = (usDatea[1] + usDatea[0] + usDatea[2]) * 1;
						    var y = (usDateb[1] + usDateb[0] + usDateb[2]) * 1;
						    
						    return ((x < y) ? -1 : ((x > y) ?  1 : 0));
						};

						jQuery.fn.dataTableExt.oSort['usdate-desc'] = function(a,b) {
						    var usDatea = a.split('/'); 
						    var usDateb = b.split('/'); 

						    var x = (usDatea[1] + usDatea[0] + usDatea[2]) * 1;
						    var y = (usDateb[1] + usDateb[0] + usDateb[2]) * 1;

						    return ((x < y) ? 1 : ((x > y) ?  -1 : 0));
						};
						
						$("#_reportsearch_WAR_cordilleraportlet_resultItems tbody tr").click( function( e ) {
					        if ( $(this).hasClass('row_selected') ) {
					            $(this).removeClass('row_selected');
					        }
					        else {
					            oTable.$('tr.row_selected').removeClass('row_selected');
					            $(this).addClass('row_selected');
					        }
					    });
					
						oTable = $('#_reportsearch_WAR_cordilleraportlet_resultItems').dataTable({
							"bJQueryUI": true,
							"oLanguage": {
								"sEmptyTable": "No results"
							},
							"aoColumns": [ 
											{"sName": "date",           "sTitle": "Date",         "bSortable": "true", "sType" : "usdate", "bSearchable": false},
											{"sName": "companyNane",    "sTitle": "Company Name", "bSortable": "true", "sType":"numeric"},
											{"sName": "contactName",    "sTitle": "Contact",      "bSortable": "true"},
											{"sName": "contractName",   "sTitle": "Contract",     "bSortable": "true"},
											{"sName": "consultantName", "sTitle": "Consultants",  "bSortable": "true"},
											{"sName": "method",         "sTitle": "Method",       "bSortable": "true"},
											{"sName": "progress",       "sTitle": "Progress",     "bSortable": "true"},
											{"sName": "status",         "sTitle": "Status",       "bSortable": "true"},
											{"sName": "comments",       "sTitle": "Comments",     "bSortable": "false"},
											]
						});
					});
					
					document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise').focus();
					// hideLoading();
				} catch (e) {
					// hideLoading();
				}
			}
		});
	}
</script>