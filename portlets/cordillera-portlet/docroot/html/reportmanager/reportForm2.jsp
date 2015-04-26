<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/common/init.jsp" %>

<%@ include file="/html/reportmanager/reportError.jsp" %>

<form action="javascript:void(0)" method="post" name="reportManagerForm" id="reportManagerForm" class="form-box remove-margin">
	<aui:input type="hidden" name="command" id="command" value="NEW"/>
	<aui:input type="hidden" name="reportId" id="reportId" value=""/>
	
	
	<!-- 
	Enterprise Id
	Mandatory
	Default: (empty)
	 -->
	
	<!-- Typeahead -->
	<aui:input type="hidden" name="enterpriseId" label="Enterprise ID" id="enterpriseId" value="" autocomplete="off" />
	<aui:input label="Company" onblur="javascript:fixEnterpriseSelected()" type="text" id="enterpriseName" name="enterpriseName" placeholder="search.." autocomplete="off" />
	<!-- END Typeahead -->

	<!-- 
	Contact
	Mandatory
	Default: -1
	 -->
	
	<aui:select label="Contact" id="contact" name="contact" class="form-control" onchange="javascript:loadContactDetail(this)">
		<aui:option value="-1">Choose a contact...</aui:option>
	</aui:select>

	<!-- 
	Contract
	Mandatory
	Default: -1 (New Contract)
	 -->
	
	<aui:select label="Contract" id="contract" name="contract" class="form-control" onchange="javascript:rm_loadContractDetail(this)">
		<aui:option value="-1">New contract</aui:option>
	</aui:select>
	
	<!-- 
	Contract Description
	Mandatory just in case Contract is 'New Contract'
	Default: (empty)
	Limit characters: XX
	 -->
	
	<aui:input label="Description" type="text" id="contractDescription" name="contractDescription" class="form-control" autocomplete="off" />
	
	<!-- 
	Contract Amount
	Mandatory
	Editable
	Default: (empty)
	 -->
	
	<aui:input label="Amount" type="text" id="contractAmount" name="contractAmount" class="form-control" autocomplete="off" />
	
	<!-- 
	Contact Data Id (Method used)
	Mandatory
	Default: -1
	 -->
	
	<aui:select label="Method" id="method" name="contactDataId" class="form-control">
		<aui:option id="-1">No Methods</aui:option>
	</aui:select>
	
	<!-- 
	Status
	Mandatory
	Default: 0 (Cold)
	 -->
	
	<aui:select label="Status" id="status" name="statusCode" class="form-control" >
		<aui:option value="0">Cold</aui:option>
		<aui:option value="100">Warm</aui:option>
		<aui:option value="200">Hot</aui:option>
		<aui:option value="300">Inactive</aui:option>
	</aui:select>
	
	<!-- 
	Progress
	Mandatory
	No lower than the current progress
	Default: 0
	 -->
	
	<div class="example yui3-skin-sam">
		<label for="horiz_value">Progress: <span id="horiz_value">0</span></label>
		<aui:input type="hidden" id="progress" name="progress" value="" />
		<span class="horiz_slider"></span>
	</div>
	
	<!-- 
	Report Date
	Mandatory
	Default: Current Date
	No before the last report date o one month
	No future date
	 -->
	<%
		java.util.Date now = new java.util.Date();
		DateFormat dateFormatDate = new SimpleDateFormat("dd/MM/yyyy");
		dateFormatDate.setTimeZone(timeZone);
	
	%>
	<aui:input label="Report Date" type="text" id="reportDate" name="reportDate" class="form-control" placeholder="dd/MM/yyyy" autocomplete="off" contenteditable="false" readonly="readonly" value="<%= dateFormatDate.format(now) %>"/>
	
	<!-- 
	Comments
	Mandatory
	Limit Characters: XX
	 -->

	<label>Comments: <span id="commentsCounter">0</span> character(s) remaining</label>	
	<aui:input label="" type="textarea" id="comments" name="comments" draggable="false" autocomplete="off"></aui:input>
	
	<div>
		<h4>Next Follow Up</h4>
		
		<!-- 
		Next Follow Up Date
		No mandatory
		Future date
		 -->
		
		<aui:input label="Date" type="text" id="nextFollowUpDate" name="nextFollowUpDate" class="form-control" value="" placeholder="dd/MM/yyyy" autocomplete="off" contenteditable="false" readonly="readonly" />
		
		<!-- 
		Next Follow Up Time
		No Mandatory
		 -->
		
		<aui:input label="Time" type="text" id="nextFollowUpTime" name="nextFollowUpTime" class="form-control" value="" placeholder="hh:mm" autocomplete="off" contenteditable="false" readonly="readonly" />
	</div>
	
	<div class="buttonBox">
		<button type="reset" class="btn btn-info">Reset</button>
		<button type="submit" class="btn btn-primary" onclick="javascript:submitReporte()">Submit</button>
	</div>
</form>

<liferay-portlet:resourceURL id="addReport" var="addReportURL"/>

<style>

.aui .control-group input[type="text"].reportDateError {
	border-color: #b50303;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
	color: #b50303;
}
</style>

<script>
var reportManagerFormValidation;
/*
 *********************************
 METHODS TO MANAGE FORM VALIDATION

 reportManagerFormValidation.validate();
 reportManagerFormValidation.hasErrors();
 reportManagerFormValidation.resetAllFields();
 reportManagerFormValidation.validateField(field)
 reportManagerFormValidation;
 ********************************* 
*/

function addLastReportDateBox() {
	var reportDateInput = document.getElementById('<portlet:namespace />reportDate');
	var div = document.createElement('div');
	var small = document.createElement('small');
	var span = document.createElement('span');
	span.id = 'report_date_value';
	small.appendChild(span);
	div.appendChild(small);
	reportDateInput.parentNode.appendChild(div);
}

addLastReportDateBox();

function removeErrorMessage(field) {
	var alert = document.getElementById(field.id + '_alert');
	if (alert != null) {
		var parent = field.parentNode;
		parent.removeChild(document.getElementById(field.id + '_alert'));
		var childrens = parent.childNodes;
		childrens[1].style.color = '';
		parent.style.color = '';
	}
 }

function addErrorMessage(field, message) {
	removeErrorMessage(field);
	var alert = document.createElement('div');
	var parent = field.parentNode;
	parent.style.color = '#b50303';
	var childrens = parent.childNodes;
	childrens[1].style.color = '#b50303';
	alert.innerHTML = message;
	alert.id = field.id + '_alert';
	parent.appendChild(alert);
}

var lastReportDate;
function setDefaultLastReportDate() {
	var today = new Date();
	lastReportDate = new Date(today);
	lastReportDate.setDate(today.getDate()-30);
}
setDefaultLastReportDate();

function validateReportDate() {
	var reportDateInput = document.getElementById('<portlet:namespace />reportDate');
	
	var reportDateArray = reportDateInput.value.split('/');
	var currentReportDate = new Date(reportDateArray[2]+','+reportDateArray[1]+','+reportDateArray[0]);
	var now = new Date();
	
	
	if (lastReportDate.getTime() > currentReportDate.getTime() || currentReportDate.getTime() > now.getTime()) {
		reportDateInput.value = '';
		if (reportDateInput.className.indexOf('reportDateError') < 0) {
			reportDateInput.className = reportDateInput.className + ' reportDateError';
		}
		if (lastReportDate.getTime() > currentReportDate.getTime()) {
			addErrorMessage(reportDateInput, 'Report date must be greater than previous');
		} else if (currentReportDate.getTime() > new Date()) {
			addErrorMessage(reportDateInput, 'Report date must not be a future date');
		}
	} else {
		reportDateInput.className = reportDateInput.className.replace(' reportDateError', '');
		removeErrorMessage(reportDateInput);
	}
}
 
function submitReporte(actionUrl) {
	
	validateReportDate();
	
	// showLoading();
	reportManagerFormValidation.validate();
	// var fieldw = document.getElementById("<portlet:namespace />contractDescription");
	// reportManagerFormValidation.validateField(fieldw);
	if (!reportManagerFormValidation.hasErrors()) {
		
		YUI().use(
				'aui-io-request',
				function (Y) {
					var enterpriseId = document.getElementById('<portlet:namespace />enterpriseId').value;
					var contactId = document.getElementById('<portlet:namespace />contact').value;
					var contractId = document.getElementById('<portlet:namespace />contract').value;
					var contractDescription = document.getElementById('<portlet:namespace />contractDescription').value;
					var contractAmount = document.getElementById('<portlet:namespace />contractAmount').value;
					var method = document.getElementById('<portlet:namespace />method').value;
					var status = document.getElementById('<portlet:namespace />status').value;
					var progress = document.getElementById('<portlet:namespace />progress').value;
					var comments = document.getElementById('<portlet:namespace />comments').value;
					var reportDate = document.getElementById('<portlet:namespace />reportDate').value;
					var nextFollowUpDate = document.getElementById('<portlet:namespace />nextFollowUpDate').value;
					var nextFollowUpTime = document.getElementById('<portlet:namespace />nextFollowUpTime').value;
					
					Y.io.request('<%=addReportURL%>',
					{
						data: {
							<portlet:namespace />enterpriseId: enterpriseId,
							<portlet:namespace />contact: contactId,
							<portlet:namespace />contract: contractId,
							<portlet:namespace />contractDescription: contractDescription,
							<portlet:namespace />contractAmount: contractAmount,
							<portlet:namespace />contactDataId: method,
							<portlet:namespace />statusCode: status,
							<portlet:namespace />progress: progress,
							<portlet:namespace />reportDate: reportDate,
							<portlet:namespace />comments: comments,
							<portlet:namespace />nextFollowUpDate: nextFollowUpDate,
							<portlet:namespace />nextFollowUpTime: nextFollowUpTime
						},
						dataType: 'json',
						on: {
							success: function() {
								var data = this.get('responseData');
								console.log("[Report Manager] submitReporte: " + data);
								
								cleanEnterpriseSelector();
								cleanContactDropDown();
								cleanContractDropDown();
								cleanContractDetail();
								cleanNextFollowUp();
								reportManagerFormValidation.resetAllFields();
								location.reload(); // REFRESH PAGE (ALL TABS)
							}
						}
					});
				}
			);
	} else {
		console.log("[Report Manager]: Trying to submit Invalid fields");
	}
}
</script>

<aui:script use="aui-form-validator">

YUI().use(
	'aui-form-validator',
	function(Y) {
		var rules = {
        	<portlet:namespace />enterpriseName: {
        		required: true
        	},
            <portlet:namespace />contact: {
            	required: true,
        		min: 0
        	},
        	<portlet:namespace />contract: {
        		required: true
        	},
        	<portlet:namespace />contractDescription: {
        		required: true,
        		maxlength: 70
        	},
        	<portlet:namespace />contractAmount: {
        		required: true,
        		min: 1,
        		max: <%=Double.MAX_VALUE %>
        	},
        	<portlet:namespace />contactDataId: {
        		required: true,
                min: 0
        	},
        	<portlet:namespace />statusCode: {
        		required: true,
                min: 0
        	},
        	<portlet:namespace />progress: {
        		required: true,
        		min: 0,
        		max: 100
        	},
        	// AKA - commented this validation. It looks like it is not working with formats like 'dd/MM/yyyy' - only with 'MM/dd/yyyy'
        	//<portlet:namespace />reportDate: {
        	//	date: true
        	//},
        	<portlet:namespace />comments: {
        		maxlength: 200
        	},
        	<portlet:namespace />nextFollowUpDate: {
        		date: true
        	},
        	<portlet:namespace />nextFollowUpTime: {
                time: true
        	}
		};
		var fieldStrings = {
			<portlet:namespace />enterpriseName: 'Please select a company',
			<portlet:namespace />contact: {
									required: 'Contact is required',
									min: 'Please select a contact'
								},
			<portlet:namespace />contract: {
									required: 'Contract is required'
								},
			<portlet:namespace />contractDescription: {
									required: 'Description is required',
									maxlength: 'Please enter a contract description with no more than 70 characters'
								},
			<portlet:namespace />contractAmount: {
									required: 'Please enter a valid contract amount',
									min: 'Greater than 0',
									max: 'Lower than <%=Double.MAX_VALUE %>'
								},
			<portlet:namespace />contactDataId: {
									required: 'Method is required',
									min: 'Please select a method'
								},
			<portlet:namespace />statusCode: {
									required: 'Status is required',
									min: 'Please select a status'
								},
			<portlet:namespace />progress: {
									required: 'Please enter a valid progress',
									min: 'Greater than 0',
									max: 'Lower than 100'
								},
			<portlet:namespace />reportDate: {
									required: 'Please select a valid report date'
								},
			<portlet:namespace />comments: {
									required: 'Comment is required',
									maxlength: 'Please enter a comment with no more than 200 characters'
								},
			<portlet:namespace />nextFollowUpDate: 'Please select a valid next follow up date',
			<portlet:namespace />nextFollowUpTime: 'Please select a valid next follow up time'
		};
		reportManagerFormValidation = new Y.FormValidator({
			boundingBox: '#reportManagerForm',
			fieldStrings: fieldStrings,
			rules: rules,
			showAllMessages: true
		});
	}
);
</aui:script>

<liferay-portlet:resourceURL id="autocompleteEnterpriseAddReport" var="autocompleteEnterpriseAddReportURL" />
<liferay-portlet:resourceURL id="getContactsAndContractsByEnterprise" var="getContactsAndContractsByEnterpriseURL"/>
<liferay-portlet:resourceURL id="getContactDetail" var="getContactDetailURL"/>
<liferay-portlet:resourceURL id="getContractDetail" var="getContractDetailURL"/>
	
<aui:script use="autocomplete-list,datasource-io">
var datasource = new A.DataSource.IO({
	source: '<%=autocompleteEnterpriseAddReportURL%>'
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
					updateEnterpriseId(result.enterpriseId);
					loadContactAndContracts(result.enterpriseId, -1, -1);
				},
				clear: function(prevVal, src) {
					//console.log("(clear) Prev Val: " + prevVal);
					cleanContactDropDown();
					cleanContractDropDown();
					cleanContractDetail();
				},
				query: function(inputValue, query, src) {
					//console.log("(query) Input Value: " + inputValue);
					//console.log("(query) Query: " + query);
				},
				render: function() {
				},
				results: function(data, query, results) {
					cleanContactDropDown();
					cleanContractDropDown();
					cleanContractDetail();
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
<script>
function rm_loadingSelect(select) {
	if (select != null) {
		select.innerHTML = '<option value="-2">Loading...</option>';
	}
}

function cleanEnterpriseSelector() {
	document.getElementById('<portlet:namespace />enterpriseName').value = '';
	document.getElementById('<portlet:namespace />enterpriseId').value = '';
}

function cleanContactDropDown() {
	var selectContact = document.getElementById('<portlet:namespace />contact');
	var options = '<option value="-1">Choose a contact...</option>';
	selectContact.innerHTML = options;
	cleanMethodDropDown();
}

function cleanContractDropDown() {
	var selectContract = document.getElementById('<portlet:namespace />contract');
	var options = '<option value="-1">New contract</option>';
	selectContract.innerHTML = options;
}

function cleanMethodDropDown() {
	var selectMethod = document.getElementById('<portlet:namespace />method');
	options = '<option value="-1">No methods</option>';
	selectMethod.innerHTML = options;
}

function cleanContractDetail() {
	setSlider(0);
	document.getElementById('<portlet:namespace />status').value = 0;
	document.getElementById('<portlet:namespace />contractDescription').value = '';
	document.getElementById('<portlet:namespace />contractAmount').value = '';	
	document.getElementById('<portlet:namespace />comments').value = '';
	document.getElementById("report_date_value").innerHTML = '';
	//!!! document.getElementById('<portlet:namespace />reportDate').value = '';
	setDefaultLastReportDate();
}

function cleanNextFollowUp() {
	document.getElementById('<portlet:namespace />nextFollowUpDate').value = '';
	document.getElementById('<portlet:namespace />nextFollowUpTime').value = '';
}

function rm_loadContacts(contactList, select, contactId) {
	cleanMethodDropDown();
	var options = '<option value="-1">Choose a contact...</option>';
	for (var i=0; i<contactList.length; i++) {
		options += '<option value="' + contactList[i].id + '">' + contactList[i].name + '</option>';
	}
	select.innerHTML = options;
	
	select.value = contactId;
	if (contactId > 0) {
		loadContactDetail(select);
	}
}

function rm_loadContracts(contractList, select, contractId) {
	cleanContractDropDown();
	cleanContractDetail();
	var options = '<option value="-1">New contract</option>';
	for (var i=0; i<contractList.length; i++) {
		options += '<option value="' + contractList[i].id + '">' + contractList[i].description + '</option>';
	}
	select.innerHTML = options;	
	
	select.value = contractId;
	if (contractId > 0) {
		rm_loadContractDetail(select);
	}
}

function updateEnterpriseId(enterpriseId) {
	document.getElementById('<portlet:namespace />enterpriseId').value = enterpriseId;
}

function loadContactAndContracts(enterpriseId, contactId, contractId) {
	YUI().use(
		'aui-io-request',
		function (Y) {
			Y.io.request('<%=getContactsAndContractsByEnterpriseURL%>',
			{
				data: {
					<portlet:namespace />enterpriseId: enterpriseId
				},
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						console.log("[Report Manager] loadContactAndContracts: " + data);
						console.log("[Report Manager] contact result: " + data.contacts);
						console.log("[Report Manager] contract result: " + data.contracts);
						
						var selectContact = document.getElementById('<portlet:namespace />contact');
						rm_loadingSelect(selectContact);
						rm_loadContacts(data.contacts, selectContact, contactId);
						
						var selectContract = document.getElementById('<portlet:namespace />contract');
						rm_loadingSelect(selectContract);
						rm_loadContracts(data.contracts, selectContract, contractId);
					}
				}
			});
		}
	);
}

function loadContactDetail(select) {
	var index = select.selectedIndex;
   	var contactId = select.options[index].value;
	YUI().use(
		'aui-io-request',
		function (Y) {
			Y.io.request('<%=getContactDetailURL %>',
			{
				data: {
					<portlet:namespace />contactId: contactId
				},
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						console.log("[Report Manager] loadContactDetail: " + data);
						console.log("[Report Manager] contact methods: " + data.methods);
						
						var select = document.getElementById('<portlet:namespace />method');
						rm_loadingSelect(select);
						loadMethods(data.methods, select);
					}
				}
			});
		}
	);
}

function rm_loadContractDetail(select) {
	var index = select.selectedIndex;
   	var contractId = select.options[index].value;
   	console.log("ContractId: " + contractId);
   	if (contractId == -1) {
   		cleanContractDetail();
   	} else {
   		YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getContractDetailURL %>',
				{
					data: {
						<portlet:namespace />contractId:contractId
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log("[Report Manager] rm_loadContractDetail: " + data);
							
							fillContractDetail(data);
						}
					}
				});
			}
		);
   	}
}

function loadMethods(methodList, select) {
	var options = '';
	if (methodList != null && methodList.length > 0) {
		for (var i=0; i<methodList.length; i++) {
			options += '<option value="' + methodList[i].id + '">' + methodList[i].name + '</option>';
		}
	} else {
		options = '<option value="-1">No methods</option>';
	}
	
	select.innerHTML = options;
}

function fillContractDetail(contractDetail) {
	// document.getElementById("<portlet:namespace />contractDescContainer").style.display = "none";
	document.getElementById("<portlet:namespace />contractDescription").value = contractDetail.description;
	document.getElementById("<portlet:namespace />contractAmount").value = contractDetail.amount;
	
	var progress = contractDetail.progress;
	setSlider(progress);
	
	var statusCode = contractDetail.statusCode;
	setStatus(statusCode);
	
	var reportDateLabel = document.getElementById("report_date_value");
	reportDateLabel.innerHTML = 'Last report date was ' + contractDetail.lastDate;
	
	var lastReportDateArray = contractDetail.lastDate.split('/');
	lastReportDate = new Date(lastReportDateArray[1]+'/'+lastReportDateArray[0]+'/'+lastReportDateArray[2]);
}

function setStatus(statusCode) {
	document.getElementById("<portlet:namespace />status").value = statusCode;
}

function fixEnterpriseSelected() {
	var enterpriseId = document.getElementById("<portlet:namespace />enterpriseId").value;
	console.log("EntId: " + enterpriseId);
	if (enterpriseId === null || enterpriseId.length === 0) {
		// document.getElementById("_contactmanager_WAR_cordilleraportlet_enterpriseSelect").value = "";
		// cleanEnterpriseDetail();
	}
}

/* Fill Report Form with data, prepared to add new report for same contract (contact and enterprise)
 * 
 */
function fillReportFormForAdd(data) {
	console.log('DATA FOR REPORT FORM: ' + data);
	
	document.getElementById('<portlet:namespace />enterpriseId').value = data.enterpriseId;
	document.getElementById('<portlet:namespace />enterpriseName').value = data.enterpriseName;
	document.getElementById('<portlet:namespace />enterpriseName').readOnly = true;
	
	loadContactAndContracts(data.enterpriseId, data.contactId, data.contractId);
	document.getElementById('<portlet:namespace />contact').disabled = true;
	document.getElementById('<portlet:namespace />contract').disabled = true;
	
	document.getElementById('<portlet:namespace />contractDescription').readOnly = true;
	document.getElementById('<portlet:namespace />contractAmount').readOnly = true;
	
	// set report id
	document.getElementById('<portlet:namespace />reportId').value = data.reportId;
	// set command
	document.getElementById('<portlet:namespace />command').value = "ADD";
}
</script>

<aui:script>
YUI().use(
  'aui-char-counter',
  function(Y) {
    new Y.CharCounter(
      {
        counter: '#commentsCounter',
        input: '#<portlet:namespace />comments',
        maxLength: 200,
        on: {
          maxLength: function(event) {
            alert('The max length limit was reached');
          }
        }
      }
    );
  }
);

YUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: 'input[id=<portlet:namespace />reportDate]',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
          	var dt = event.newSelection[0];
          	var dayStr = dt.getDate().toString();
          	var monthStr = (dt.getMonth() + 1).toString();
          	var yearStr = dt.getFullYear().toString();
          	var dateStr = dayStr + "/" + monthStr + "/" + yearStr;
            Y.one('#<portlet:namespace />reportDate').set('value', dateStr);
            
            validateReportDate();
          }
        }
      }
    );
  }
);

YUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: 'input[id=<portlet:namespace />nextFollowUpDate]',
		mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
          	var dt = event.newSelection[0];
          	var dateStr = dt.getDate() + "/" + dt.getMonth() + 1 + "/" + dt.getFullYear();
            // Y.one('#<portlet:namespace />nextFollowUpDate').set('value', dateStr);
          }
        }
      }
    );
  }
);

YUI().use(
  'aui-timepicker',
  function(Y) {
    new Y.TimePicker(
      {
        trigger: 'input[id=<portlet:namespace />nextFollowUpTime]',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
          	var dt = event.newSelection[0];
          	var dateStr = dt.getHours() + ":" + dt.getMinutes();
          }
        }
      }
    );
  }
);

</aui:script>

<script>

//Create a YUI instance and request the slider module and its dependencies
	var xInput,  // input tied to xSlider
	    xSlider; // horizontal Slider
	YUI().use("slider", function (Y) {
	
	// Function to pass input value back to the Slider
	function updateSlider( e ) {
	    var data   = this.getData(),
	        slider = data.slider,
	        value  = parseInt( this.get( "value" ), 10 );
	
	    if ( data.wait ) {
	        data.wait.cancel();
	    }
	
	    // Update the Slider on a delay to allow time for typing
	    data.wait = Y.later( 200, slider, function () {
	        data.wait = null;
	        this.set( "value", value );
	    } );
	}
	
	// Function to update the input value from the Slider value
	function updateInput( e ) {
	    this.set( "value", e.newVal );
	    Y.one('#horiz_value').set('text', e.newVal);
	}
	
	// Create a horizontal Slider using all defaults
	xSlider = new Y.Slider({
		value: 30,
		length: '225px'
	});
	
	// Link the input value to the Slider
	xInput = Y.one( "#<portlet:namespace />progress" );
	xInput.setData( { slider: xSlider } );
	
	// Pass the input as the 'this' object inside updateInput
	xSlider.after( "valueChange", updateInput, xInput );
	xInput.on( "keyup", updateSlider );
	
	// Render the Slider next to the input
	xSlider.render('.horiz_slider');
	});
	
	function setSlider(val) {
		xSlider.setValue(val);
	}
</script>