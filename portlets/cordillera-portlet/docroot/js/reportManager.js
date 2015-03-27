function submitReport(actionUrl) {
	showLoading();
	AUI().io.request(actionUrl,{
		method: 'POST',
		form: { id: namespace+'reportForm' },
		on: {
			success: function() {
				try {
					var response = this.get('responseData');
					document.getElementById("messageContainer").innerHTML = response;
					if (response.indexOf("error") < 0) {
						cleanEnterpriseDetail();
					}
					hideLoading();
				} catch (e) {
					hideLoading();
				}
			}
		}
	});
}

function getReportManagerRequest(actionUrl, afterResponse) {
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

function getContacts(enterpriseId) {
	loadingSelect(document.getElementById(namespace+"contact"));
	loadingSelect(document.getElementById(namespace+"contract"));
	
	if (enterpriseId != -1) {
		var ajaxRequest = getReportManagerRequest(contactSelectURL, reloadContacts);
		ajaxRequest.set("data", {
			enterpriseId: enterpriseId
		});
		ajaxRequest.start();
	} else {
		cleanEnterpriseDetail();
	}
}

function cleanEnterpriseDetail() {
	cleanContactDetails();
	document.getElementById(namespace+"enterprise").value = -1;
	document.getElementById(namespace+"contact").innerHTML = '<option value="-1">Choose a contact...</option>';
}

function reloadContacts(response) {
	var contactSelect = document.getElementById(namespace+"contact");
	var contacts = response.contacts;
	var options = '<option value="-1">Choose a contact...</option>';
    for (var i=0; i<contacts.length; i++) {
    	options += '<option value="' + contacts[i].id + '">' + contacts[i].name + '</option>';
    }
    
    contactSelect.innerHTML = options;
    contactSelect.onchange = function(event) {
    	var index = event.target.selectedIndex;
    	var contactId = event.target.options[index].value;
   		showContactDetail(contactId);
    };
    
    cleanContactDetails();
    
	var contracts = response.contracts;
	reloadContracts(contracts);
}

function cleanContactDetails() {
	cleanContractDetails();
	document.getElementById(namespace+"contact").value = -1;
   	document.getElementById(namespace+"method").innerHTML = '<option value="-1">Choose a method...</option>';
//   	document.getElementById(namespace+"contract").innerHTML = '<option value="-1">New contract</option>';
}

function showContactDetail(contactId) {
	loadingSelect(document.getElementById(namespace+"method"));
//	loadingSelect(document.getElementById(namespace+"contract"));
	
	if (contactId != '' && contactId > 0) {
		var ajaxRequest = getReportManagerRequest(contactDetailURL, reloadContactDetails);
		ajaxRequest.set("data", {
			contactId: contactId
		});
		ajaxRequest.start();
	} if (contactId == -1) {
		cleanContactDetails();
//		cleanContractDetails();
	}
}

function reloadContactDetails(response) {
	var methods = response.methods;
	reloadMethods(methods);
	
//	var contracts = response.contracts;
//	reloadContracts(contracts);
}

function reloadMethods(methods) {
	var methodSelect = document.getElementById(namespace+"method");
	var options = '<option value="-1">Choose a method...</option>';
	for (var i=0; i<methods.length; i++) {
    	options += '<option value="' + methods[i].id + '">' + methods[i].name + '</option>';
    }
	
	methodSelect.innerHTML = options;
}

function reloadContracts(contracts) {
	var contractSelect = document.getElementById(namespace+"contract");
	var options = '<option value="-1">New contract</option>';
	for (var i=0; i<contracts.length; i++) {
    	options += '<option value="' + contracts[i].id + '">' + contracts[i].description + '</option>';
    }
	
	contractSelect.innerHTML = options;
	contractSelect.onchange = function(event) {
    	var index = event.target.selectedIndex;
    	var contractId = event.target.options[index].value;
   		showContractDetails(contractId);
    };
}

function showContractDetails(contractId) {
	if (contractId != '' && contractId > 0) {
		var ajaxRequest = getReportManagerRequest(contractDetailURL, reloadContractDetails);
		ajaxRequest.set("data", {
			contractId: contractId
		});
		ajaxRequest.start();
	} if (contractId == -1) {
		cleanContractDetails();
	}
}

function reloadContractDetails(response) {
	document.getElementById(namespace+"contractDescContainer").style.display = "none";
	document.getElementById(namespace+"contractAmount").value = response.amount;
	
	var progress = response.progress;
	setProgress(progress);
	
	var statusCode = response.statusCode;
	setStatus(statusCode);
	
	var minDate  = response.minDate;
	setMinDate(minDate);
	
	// document.getElementById(namespace+"comments").value = response.comments;
}

function cleanContractDetails() {
	$(function() {
    	$( "#"+namespace+"slider" ).slider('value',0);
    	$( "#"+namespace+"progressVal" ).text( $( "#"+namespace+"slider" ).slider( "value" ) + "%" );
    	$("#"+namespace+"reportDate").datepicker( 'option', 'minDate', -30 );
    	$("#"+namespace+"reportDate").datepicker('setDate', new Date());
    });
    
	document.getElementById(namespace+"status").value = 0;
	document.getElementById(namespace+"contract").value = -1;
	document.getElementById(namespace+"contractDescription").value = "";
	document.getElementById(namespace+"contractAmount").value = "";	
	document.getElementById(namespace+"contractDescContainer").style.display = "";
	document.getElementById(namespace+"comments").value = "";
}

function setProgress(progress) {
	$(function() {
    	$( "#"+namespace+"slider" ).slider('value',progress);
    	$( "#"+namespace+"progressVal" ).text( $( "#"+namespace+"slider" ).slider( "value" ) + "%" );
    	$( "#"+namespace+"progress" ).val( $( "#"+namespace+"slider" ).slider( "value" ) );
    });
}

function setStatus(statusCode) {
	document.getElementById(namespace+"status").value = statusCode;
}

function setMinDate(minDate) {
	$("#"+namespace+"reportDate").datepicker( 'option', 'minDate', minDate );
}

//function reloadContractDetail(event) {
//	var contracts = contactDetail_cache.contracts;
//	var index = event.target.selectedIndex;
//	var contractId = event.target.options[index].value;
//	
//	if (contractId > 0) {
//		for (var i=0; i<contracts.length; i++) {
//	    	if (contractId == contracts[i].id) {
//	    		document.getElementById(namespace+"contractDescContainer").style.display = "none";
//	    		document.getElementById(namespace+"contractAmount").value = contracts[i].amount;
//	    	}
//	    }
//	} else {
//		document.getElementById(namespace+"contractDescription").value = "";
//		document.getElementById(namespace+"contractDescContainer").style.display = "";
//		document.getElementById(namespace+"contractAmount").value = "";
//	}
//}