<%@ include file="/html/common/init.jsp" %>

<div id="reportCalendar">
	<%@ include file="/html/reportmanager/reportCalendar.jsp" %>
</div>

<br />

<liferay-portlet:actionURL var="searchURL" name="search" portletName="reportSearchResult_WAR_cordilleraportlet" />
<form action="javascript:void(0)" method="post" name="searchReportForm" id="searchReportForm" class="form-horizontal form-box remove-margin">
	<!-- Form Header -->
	<h4 class="form-box-header">
		<liferay-ui:message key="Search reports" />
		<small>
		</small>
	</h4>

	<!-- Form Content -->
	<div class="form-box-content">
		<!-- Consultant Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportsearch_WAR_cordilleraportlet_consultant">Consultant</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="getEnterprisesURL" name="getEnterprises" />
				<select id="_reportsearch_WAR_cordilleraportlet_consultant" name="consultant" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getEnterpriseList(this, '<%=getEnterprisesURL.toString() %>')">
					<option value="-1">Choose a consultant...</option>
				</select>
				<input type="hidden" name="consultantId" value="<%=user.getUserId() %>" />
			</div>
		</div>
		<!-- Company Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportsearch_WAR_cordilleraportlet_enterprise">Company</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="searchByEnterpriseURL" name="searchByEnterprise" />
				<select id="_reportsearch_WAR_cordilleraportlet_enterprise" name="enterprise" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContactsAndContracts(this, '<%=searchByEnterpriseURL %>')">
					<option value="-1">Choose a company...</option>
				</select>
			</div>
		</div>
		<!-- Contact Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportsearch_WAR_cordilleraportlet_contact">Contact</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="getContractsURL" name="getContracts" />
				<select id="_reportsearch_WAR_cordilleraportlet_contact" name="contact" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContracts(this, '<%=getContractsURL %>')">
					<option value="-1">Choose a contact...</option>
				</select>
			</div>
		</div>
		<!-- Contract Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportsearch_WAR_cordilleraportlet_contract">Contract</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="getContractDetailURL" name="getContractDetail" />
				<select id="_reportsearch_WAR_cordilleraportlet_contract" name="contract" class="form-control" onchange="javascript:_reportsearch_WAR_cordilleraportlet_getContractDetail(this, '<%=getContractDetailURL %>')">
					<option value="-1">Choose a contract...</option>
				</select>
			</div>
		</div>
		<!-- Progress -->
		<div class="form-group">
 			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_status">Progress</label>
 			<input type="hidden" id="_reportsearch_WAR_cordilleraportlet_progress0" name="fromProgress" value="0" autocomplete="off" />
 			<input type="hidden" id="_reportsearch_WAR_cordilleraportlet_progress1" name="toProgress" value="100" autocomplete="off" />
 			<div class="col-sm-10">
				<select style="text-align: center;" autocomplete="off" id="_reportsearch_WAR_cordilleraportlet_progress" name="fromToProgress" class="form-control" onclick="javascript:evalProgress()" size="6" multiple>
					<option value="0">0</option>
					<option value="20">20</option>
					<option value="40">40</option>
					<option value="60">60</option>
					<option value="80">80</option>
					<option value="100">100</option>
				</select>
			</div>
		</div>
		<!-- Status -->
		<div class="form-group">
			<label class="control-label col-md-2">Status</label>
			<div class="col-md-10">
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
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportsearch_WAR_cordilleraportlet_fromDate">Date</label>
			<!-- From Date -->
			<div class="col-md-5">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportsearch_WAR_cordilleraportlet_fromDate" name="fromDate" class="form-control" autocomplete="off" readonly="readonly">
				</div>
			</div>
			<!-- To Date -->
			<div class="col-md-5">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportsearch_WAR_cordilleraportlet_toDate" name="toDate" class="form-control" autocomplete="off" readonly="readonly">
				</div>
			</div>
		</div>
		<div class="form-group form-actions">
			<div class="col-md-12 col-md-offset-4">
				<button type="reset" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
				<button class="btn btn-success" onclick="javascript:_reportsearch_WAR_cordilleraportlet_searchReport('<%=searchURL.toString() %>')" ><i class="fa fa-search"></i> Search</button>
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

/** Commons Methods **/

function parseDate(s) {
	console.log("Parse Date: " + s);
	var a = s.split("/");
	return new Date(a[0], a[1]-1, a[2], 0, 0, 0, 0);	
}

function _reportsearch_WAR_cordilleraportlet_parseJson(text) {
	return JSON.parse(text);
}

function _reportsearch_WAR_cordilleraportlet_loadingSelect(select) {
	if (select != null) {
		select.innerHTML = '<option value="-2">Loading...</option>';
	}
}

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
	
//	$( "#_reportsearch_WAR_cordilleraportlet_slider-range" ).slider({ values: [ 0, 100 ] });
//	$( "#_reportsearch_WAR_cordilleraportlet_progressVal1" ).text( 0 + "% - " + 100 + "%" );
}

/** Search Methods **/

function evalProgress() {
	var progressSelect = document.getElementById("_reportsearch_WAR_cordilleraportlet_progress");
	
	var selected = [];
	for (var i = 0; i < progressSelect.length; i++) {
		if (progressSelect.options[i].selected) {
			selected[selected.length] = progressSelect.options[i];
		}
	}
	
	if (selected.length === 0) {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress0").value = 0;
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress1").value = 100;
	} else if (selected.length === 1) {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress0").value = selected[0].value;
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress1").value = selected[0].value;
	} else if (selected.length === 2) {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress0").value = selected[0].value;
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress1").value = selected[1].value;	
	} else if (selected.length > 2) {
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress0").value = selected[0].value;
		document.getElementById("_reportsearch_WAR_cordilleraportlet_progress1").value = selected[1].value;
		for (var i = 2; i<selected.length; i++){
			selected[i].selected = false;
		}
	}
}

function _reportsearch_WAR_cordilleraportlet_searchReport(actionUrl) {
	// showLoading();
	console.log('Query searchReport:');
	document.getElementById("_reportsearch_WAR_cordilleraportlet_results").innerHTML = "Loading";
	$.ajax({
		async: false,
		url:actionUrl,
		type: "POST",
		data: $("#searchReportForm").serialize(), 
		success: function(result) {
			try {
				console.log("Response searchReport: " + result);
				document.getElementById("_reportsearch_WAR_cordilleraportlet_results").innerHTML = result;
				
		        $('#resultItems1').dataTable({"aoColumnDefs": [{"bSortable": false, "aTargets": [0]}]});
		        $('.dataTables_filter input').attr('placeholder', 'Search');
				
				document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise').focus();
				// hideLoading();
			} catch (e) {
				// hideLoading();
			}
		}
	});
}

/** Load Contract Details Method **/

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

/** Load Contact Details Methos**/

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

/** Load Contacts and Contracts Methods**/

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


/** Load Conmpanies Methods **/

function _reportsearch_WAR_cordilleraportlet_setFromDate(date) {
    searchFromDatePicker.setValue(date);
}

function _reportsearch_WAR_cordilleraportlet_setToDate(date) {
    searchToDatePicker.setValue(date);
}

function _reportsearch_WAR_cordilleraportlet_loadContractDetail(contractDetail) {
	_reportsearch_WAR_cordilleraportlet_setFromDate(parseDate(contractDetail.reportDate));
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

/** Load Consultants Method (Init) **/

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

var searchFromDatePicker;
var searchToDatePicker;

function _reportsearch_WAR_cordilleraportlet_loadFormComponents() {
	console.log('Loading components...');

	var to = new Date();
	var from = new Date(to.getFullYear(), to.getMonth(), to.getDate()-30, 0, 0, 0, 0);
	
	// Reffere To: http://www.eyecon.ro/bootstrap-datepicker/
	searchFromDatePicker = $('#_reportsearch_WAR_cordilleraportlet_fromDate').datepicker({
		format: 'dd/mm/yyyy'
	}).on('changeDate', function(ev) {
		if (ev.date.valueOf() > searchToDatePicker.date.valueOf()) {
			var newDate = new Date(ev.date);
			newDate.setDate(newDate.getDate() + 1);
			searchToDatePicker.setValue(newDate);
		}
		searchFromDatePicker.hide();
		$('#_reportsearch_WAR_cordilleraportlet_toDate')[0].focus();
	}).data('datepicker');
	
	searchFromDatePicker.setValue(from);
	
	searchToDatePicker = $('#_reportsearch_WAR_cordilleraportlet_toDate').datepicker({
		onRender: function(date) {
			return date.valueOf() <= searchFromDatePicker.date.valueOf() ? 'disabled' : '';
		},
		format: 'dd/mm/yyyy'
	}).on('changeDate', function(ev) {
		searchToDatePicker.hide();
	}).data('datepicker');
	
	searchToDatePicker.setValue(to);
	
	console.log('Components loaded');			
}

$( document ).ready(function() {
	console.log('Initializing search form...');
	_reportsearch_WAR_cordilleraportlet_loadFormComponents();
	_reportsearch_WAR_cordilleraportlet_getConsultantList('<%=getConsultantsURL.toString() %>');
	console.log('Search form initialazed');
});
</script>
