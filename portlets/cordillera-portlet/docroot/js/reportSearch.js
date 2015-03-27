function searchReport(actionUrl) {
	showLoading();
	document.getElementById("results").innerHTML = "Loading";
	AUI().io.request(actionUrl,{
		method: 'POST',
		form: { id:'searchReportForm' },
		on: {
			success: function() {
				try {
					var response = this.get('responseData');
					document.getElementById("results").innerHTML = response;
					
					$(document).ready(function() {
						$("#resultItems tbody tr").click( function( e ) {
					        if ( $(this).hasClass('row_selected') ) {
					            $(this).removeClass('row_selected');
					        }
					        else {
					            oTable.$('tr.row_selected').removeClass('row_selected');
					            $(this).addClass('row_selected');
					        }
					    });
					
						oTable = $('#resultItems').dataTable({
							"bJQueryUI": true
						});
					});
					
					hideLoading();
				} catch (e) {
					hideLoading();
				}
			}
		}
	});
}

function getReportSearchRequest(actionUrl, afterResponse) {
	return AUI().io.request(actionUrl,{
		autoLoad: false,
		dataType: 'json',
		on: {
			success: function() {
				var response = this.get('responseData');
				afterResponse(response);
			}
		}
	});
}

function loadingSelect(select) {
	if (select != null) {
		select.innerHTML = '<option value="-1">Loading...</option>';
	}
}

function getSearchContacts(enterpriseId) {
	loadingSelect(document.getElementById(searchnamespace+"contact"));
	if (enterpriseId != -1) {
		var ajaxRequest = getReportManagerRequest(searchByEnterpriseURL, reloadSearchByEnterpriseResult);
		ajaxRequest.set("data", {
			enterpriseId: enterpriseId
		});
		ajaxRequest.start();
	} else {
		cleanEnterpriseSearchDetail();
	}
}

function cleanEnterpriseSearchDetail() {
	cleanContactSearchDetails();
	document.getElementById(searchnamespace+"enterprise").value = -1;
	document.getElementById(searchnamespace+"contact").innerHTML = '<option value="-1">Choose a contact...</option>';
}

function reloadSearchByEnterpriseResult(response) {
	var contactSelect = document.getElementById(searchnamespace+"contact");
	var contacts = response.contacts;
	var options = '<option value="-1">Choose a contact...</option>';
    for (var i=0; i<contacts.length; i++) {
    	options += '<option value="' + contacts[i].id + '">' + contacts[i].name + '</option>';
    }
    
    contactSelect.innerHTML = options;
    contactSelect.onchange = function(event) {
    	var index = event.target.selectedIndex;
    	var contactId = event.target.options[index].value;
   		showContactSearchDetail(contactId);
    };
    
    cleanContactSearchDetails();
    reloadSearchContracts(response.contracts);
    setFromDate(response.reportDate);
}

function cleanContactSearchDetails() {
	document.getElementById(searchnamespace+"contact").value = -1;
   	document.getElementById(searchnamespace+"contract").innerHTML = '<option value="-1">Choose a contract...</option>';
}

function showContactSearchDetail(contactId) {
	loadingSelect(document.getElementById(searchnamespace+"contract"));
	
	if (contactId != '' && contactId > 0) {
		var ajaxRequest = getReportManagerRequest(contactDetailSearchURL, reloadContactSearchDetails);
		ajaxRequest.set("data", {
			contactId: contactId
		});
		ajaxRequest.start();
	} if (contactId == -1) {
		cleanContactSearchDetails();
	}
}

function reloadContactSearchDetails(response) {
	var contracts = response.contracts;
	reloadSearchContracts(contracts);
	setFromDate(response.reportDate);
}

function reloadSearchContracts(contracts) {
	var contractSelect = document.getElementById(searchnamespace+"contract");
	var options = '<option value="-1">Choose a contract...</option>';
	for (var i=0; i<contracts.length; i++) {
    	options += '<option value="' + contracts[i].id + '">' + contracts[i].description + '</option>';
    }
	
	contractSelect.innerHTML = options;
	contractSelect.onchange = function(event) {
    	var index = event.target.selectedIndex;
    	var contractId = event.target.options[index].value;
   		showSearchContractDetails(contractId);
    };
}

function showSearchContractDetails(contractId) {
	if (contractId != '' && contractId > 0) {
		var ajaxRequest = getReportManagerRequest(contractDetailSearchURL, reloadSearchContractDetail);
		ajaxRequest.set("data", {
			contractId: contractId
		});
		ajaxRequest.start();
	}
}

function reloadSearchContractDetail(response) {
	setFromDate(response.reportDate);
}

function setFromDate(d) {
	$("#fromDate").datepicker('setDate', new Date(d));
}

function cleanSearchContractDetails() {
	$(function() {
    	$("#fromDate").datepicker('setDate', new Date());
    });
}

function searchReports(actionUrl) {
	
}