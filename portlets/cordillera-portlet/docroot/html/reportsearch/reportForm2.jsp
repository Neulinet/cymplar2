<%@ include file="/html/common/init.jsp" %>


<portlet:actionURL name="search" var="searchActionURL">
</portlet:actionURL>


<aui:form action="<%= searchActionURL %>" method="post" name="searchReportForm" id="searchReportForm" cssClass="form-box remove-margin searchReportForm">
	
	<!-- Consultant Select -->
	<liferay-portlet:actionURL var="getEnterprisesURL" name="getEnterprises" />
	<aui:select label="Consultant" id="consultant" name="consultant" class="form-control" autocomplete="off" onchange="javascript:getEnterpriseList(this)">
		<aui:option value="-1">Choose a consultant...</aui:option>
	</aui:select>
	<input type="hidden" name="consultantId" value="<%=user.getUserId() %>" />
	
	<!-- Company Select -->
	<liferay-portlet:actionURL var="searchByEnterpriseURL" name="searchByEnterprise" />
	<aui:select label="Company" id="enterprise" name="enterprise" class="form-control" autocomplete="off" onchange="javascript:getContactsAndContracts(this)">
		<aui:option value="-1">Choose a company...</aui:option>
	</aui:select>
	
	<!-- Contact Select -->
	<liferay-portlet:actionURL var="getContractsURL" name="getContracts" />
	<aui:select label="Contact" id="contact" name="contact" class="form-control" autocomplete="off" onchange="javascript:getContracts(this)">
		<aui:option value="-1">Choose a contact...</aui:option>
	</aui:select>
	
	<!-- Contract Select -->
	<aui:select label="Contract" id="contract" name="contract" class="form-control" autocomplete="off" onchange="javascript:getContractDetail(this)">
		<aui:option value="-1">Choose a contract...</aui:option>
	</aui:select>
	
	<!-- Status -->
	<div class="form-group">
		<label>Status</label>
		<div class="checkbox-group">
			<label class="checkbox-inline" for="statusCodeCOld">
				<aui:input label="Cold" type="checkbox" id="statusCodeCold" name="statusCodeCold" autocomplete="off" /> 
			</label>
			<label class="checkbox-inline" for="statusCodeWarm">
				<aui:input label="Warm" type="checkbox" id="statusCodeWarm" name="statusCodeWarm" autocomplete="off" /> 
			</label>
			<label class="checkbox-inline" for="statusCodeHot">
				<aui:input label="Hot" type="checkbox" id="statusCodeHot" name="statusCodeHot" autocomplete="off" /> 
			</label>
			<label class="checkbox-inline" for="statusCodeInactive">
				<aui:input label="Inactive" type="checkbox" id="statusCodeInactive" name="statusCodeInactive" autocomplete="off" /> 
			</label>
		</div>
	</div>
	
	<!-- Progress -->
	<div class="example yui3-skin-sam">
		<label for="progressFrom">Progress from: <span id="progressFromValue">0</span> to: <span id="progressToValue">100</span></label>
		<aui:input type="hidden" id="progressFrom" autocomplete="off" name="progressFrom" value="" />
		<span class="progressFromSlider"></span>
	</div>

	<div class="example yui3-skin-sam">
		<aui:input type="hidden" id="progressTo" autocomplete="off" name="progressTo" value="" />
		<span class="progressToSlider"></span>
	</div>
		
	<aui:input label="From" type="text" id="fromDate" name="fromDate" class="form-control" value="21/11/1999" placeholder="dd/MM/yyyy" autocomplete="off" contenteditable="false" readonly="readonly" />
	
	<aui:input label="To" type="text" id="toDate" name="toDate" class="form-control" placeholder="dd/MM/yyyy" value="" autocomplete="off" contenteditable="false" readonly="readonly" />
	
	<div class="buttonBox">
		<button type="reset" class="btn btn-info">Reset</button>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</aui:form>

<div id="reportSearchResultTable">
	<%@ include file="/html/reportsearchresult/results2.jsp" %>
</div>

<liferay-portlet:resourceURL id="getConsultants" var="getConsultantsURL" />
<liferay-portlet:resourceURL id="getEnterprises" var="getEnterprisesURL"/>
<liferay-portlet:resourceURL id="searchByEnterprise" var="searchByEnterpriseURL"/>
<liferay-portlet:resourceURL id="getContracts" var="getContractsURL"/>
<liferay-portlet:resourceURL id="getContractDetail" var="getContractDetailURL"/>
<liferay-portlet:resourceURL id="search" var="searchURL" />

<script>

function rs_loadingSelect(select) {
	if (select != null) {
		select.innerHTML = '<option value="-2">Loading...</option>';
	}
}

function getConsultantList() {
	YUI().use(
		'aui-io-request',
		function (Y) {
			Y.io.request('<%=getConsultantsURL %>',
			{
				data: {},
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						console.log("getConsultantList: ");
						console.log(data);
						
						var select = document.getElementById('<portlet:namespace />consultant');
						rs_loadingSelect(select);
						loadConsultantList(data.consultants, data.currentConsultant, select);
					}
				}
			});
		}
	);
}

function loadConsultantList(consultantList, currentConsultant, select) {
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

function getEnterpriseList(select) {
	var index = select.selectedIndex;
	var consultantId = select.options[index].value;
	YUI().use(
		'aui-io-request',
		function (Y) {
			Y.io.request('<%=getEnterprisesURL %>',
			{
				data: {
					<portlet:namespace />consultantId: consultantId
				},
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						console.log("getEnterpriseList: ");
						console.log(data);
						
						cleanEnterpriseSearchDetail();
						var select = document.getElementById('<portlet:namespace />enterprise');
						rs_loadingSelect(select);
						loadEnterpriseList(data.enterprises, select);
						loadContractDetail(data);
					}
				}
			});
		}
	);
}

function cleanEnterpriseSearchDetail() {
	document.getElementById("<portlet:namespace />enterprise").value = -1;
	document.getElementById("<portlet:namespace />contact").innerHTML = '<option value="-1">Choose a contact...</option>';
	cleanContactSearchDetails();
}

function cleanContactSearchDetails() {
	document.getElementById("<portlet:namespace />contact").value = -1;
   	document.getElementById("<portlet:namespace />contract").innerHTML = '<option value="-1">Choose a contract...</option>';
   	cleanSearchContractDetails();
}

function cleanSearchContractDetails() {
	var fDay = new Date();
	var tiempo = fDay.getTime();
	var milisegundos = parseInt(30 * 24*60*60*1000);
    //fDay.setTime(tiempo-milisegundos);
	fDay.setDate(fDay.getDate()-30);
	
	console.log('Init Set From Date');
	setFromDate(fDay);
	
	console.log('Init Set To Date');
	setToDate(new Date());
	
	// TODO - do we really need it?
	document.getElementById('<portlet:namespace />statusCodeColdCheckbox').checked = '';
	document.getElementById('<portlet:namespace />statusCodeWarmCheckbox').checked = '';
	document.getElementById('<portlet:namespace />statusCodeHotCheckbox').checked = '';
	document.getElementById('<portlet:namespace />statusCodeInactiveCheckbox').checked = '';
	
	setSliderProgressFrom(0);
	setSliderProgressTo(100);
//	$( "#_reportsearch_WAR_cordilleraportlet_progress0" ).val( 0 );
//	$( "#_reportsearch_WAR_cordilleraportlet_progress1" ).val( 100 );
}

function loadEnterpriseList(enterpriseList, select) {
	var options = '<option value="-1">Choose a company...</option>';
	if (enterpriseList) {
		for (var i=0; i<enterpriseList.length; i++) {
			options += '<option value="' + enterpriseList[i].id + '">' + enterpriseList[i].name + ' ' + enterpriseList[i].taxid + '</option>';
		}
	}
	select.innerHTML = options;
}

function loadContractDetail(contractDetail) {
	console.log("Set From Date");
	setFromDate(parseDate(contractDetail.reportDate));
	console.log("Set To Date");
	setToDate(new Date());
}

function parseDate(s) {
	var a = s.split("/");
	return new Date(a[0], a[1]-1, a[2], 0, 0, 0, 0);	
}

function getContactsAndContracts(select) {
	var index = select.selectedIndex;
   	var enterpriseId = select.options[index].value;
   	if (enterpriseId != -1) {
   		var consultantSelected = document.getElementById('<portlet:namespace />consultant');
		YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=searchByEnterpriseURL %>',
				{
					data: {
						<portlet:namespace />enterpriseId:enterpriseId,
						<portlet:namespace />consultantId:consultantSelected.value
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log("getContactsAndContracts: ");
							console.log(data);
							
							var selectContact = document.getElementById('<portlet:namespace />contact');
							rs_loadingSelect(selectContact);
							loadContacts(data.contacts, selectContact);
							
							var selectContract = document.getElementById('<portlet:namespace />contract');
							rs_loadingSelect(selectContract);
							loadContracts(data.contracts, selectContract);
							
							loadContractDetail(data);
						}
					}
				});
			}
		);
   	} else {
   		cleanEnterpriseSearchDetail();
   	}
}

function loadContacts(contactList, select) {
	var options = '<option value="-1">Choose a contact...</option>';
	if (contactList) {
		for (var i=0; i<contactList.length; i++) {
			options += '<option value="' + contactList[i].id + '">' + contactList[i].name + '</option>';
		}
	}
	select.innerHTML = options;
}

function loadContracts(contractList, select) {
	var options = '<option value="-1">Choose a contract...</option>';
	if (contractList) {
		for (var i=0; i<contractList.length; i++) {
			options += '<option value="' + contractList[i].id + '">' + contractList[i].description + '</option>';
		}
	}
	select.innerHTML = options;
}

function getContracts(select) {
	var index = select.selectedIndex;
   	var contactId = select.options[index].value;
   	if (contactId != -1) {
   		var consultantSelected = document.getElementById('<portlet:namespace />consultant');
   		var enterpriseSelected = document.getElementById('<portlet:namespace />enterprise');
		YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getContractsURL %>',
				{
					data: {
						<portlet:namespace />contactId: contactId,
						<portlet:namespace />consultantId: consultantSelected.value,
						<portlet:namespace />enterpriseId: enterpriseSelected.value
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log("getContracts: ");
							console.log(data);
							
							var select = document.getElementById('<portlet:namespace />contract');
							rs_loadingSelect(select);
							loadContracts(data.contracts, select);
							
							loadContractDetail(data);
						}
					}
				});
			}
		);
   	} else {
//		cleanContactSearchDetails();
   	}
}

function getContractDetail(select) {
	var index = select.selectedIndex;
   	var contractId = select.options[index].value;
   	if (contractId != -1) {
   		var consultantSelected = document.getElementById('<portlet:namespace />consultant');
		YUI().use(
			'aui-io-request',
			function (Y) {
				Y.io.request('<%=getContractDetailURL %>',
				{
					data: {
						<portlet:namespace />contractId: contractId,
						<portlet:namespace />consultantId: consultantSelected.value
					},
					dataType: 'json',
					on: {
						success: function() {
							var data = this.get('responseData');
							console.log("getContractDetail: ");
							console.log(data);
							
							loadContractDetail(data);
						}
					}
				});
			}
		);
   	} else {
//		cleanSearchContractDetails();
   	}
}

</script>

<script>

function searchReport() {
	YUI().use(
		'aui-io-request',
		function (Y) {
			Y.io.request('<%=searchURL %>',
			{
				data: { 
					<portlet:namespace />consultant: document.getElementById('<portlet:namespace />consultant').value,
					<portlet:namespace />enterprise: document.getElementById('<portlet:namespace />enterprise').value,
					<portlet:namespace />contact: document.getElementById('<portlet:namespace />contact').value,
					<portlet:namespace />contract: document.getElementById('<portlet:namespace />contract').value,
					<portlet:namespace />statusCode1: document.getElementById('<portlet:namespace />statusCode1').value,
					<portlet:namespace />statusCode2: document.getElementById('<portlet:namespace />statusCode2').value,
					<portlet:namespace />statusCode3: document.getElementById('<portlet:namespace />statusCode3').value,
					<portlet:namespace />statusCode4: document.getElementById('<portlet:namespace />statusCode4').value,
					<portlet:namespace />progressFrom: document.getElementById('<portlet:namespace />progressFrom').value,
					<portlet:namespace />progressTo: document.getElementById('<portlet:namespace />progressTo').value,
					<portlet:namespace />fromDate: document.getElementById('<portlet:namespace />fromDate').value,
					<portlet:namespace />toDate: document.getElementById('<portlet:namespace />toDate').value
				},
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						console.log("getContractDetail: ");
						console.log(data);
						// loadResults(data.searchResultsItems);
						document.getElementById('reportSearchResultTable').innerHTML = data;
					}
				}
			});
		}
	);
}

/*
function loadResults(result) {
document.getElementById('reportSearchResultTable').innerHTML = '';
YUI().use(
  'aui-datatable',
  function(Y) {
	var columns = [ {label:'Date', key: 'reportDate'}, {label: 'Company', key: 'enterpriseName'}, {label: 'Contract', key: 'contractDescription'}, {label: 'Contact', key: 'contactFullName'}, {label: 'Method', key: 'methodName'}, {label: 'Value', key: 'methodValue'}, {label: 'Progress', key: 'contractProgress'}, {label: 'Status',  key: 'contractStatus'}, {label: 'Comments', key: 'reportComment'}];
		
    var data = result;

    new Y.DataTable(
      {
        columnset: columns,
        recordset: data
      }
    ).render('#reportSearchResultTable');
  }
);
}*/
</script>

<script>
var fromDate,
	toDate;
YUI().use(
  'aui-datepicker',
  function(Y) {
    fromDate = new Y.DatePicker(
      {
        trigger: 'input[id=<portlet:namespace />fromDate]',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
          	var dt = event.newSelection[0];
          	var month = dt.getMonth() + 1;
          	var dateStr = dt.getDate() + "/" + month + "/" + dt.getFullYear();
            console.log(dateStr);
            Y.one('#<portlet:namespace />fromDate').set('value', dateStr);
          }
        }
      }
    );
  }
);

function setFromDate(dt) {
	var month = dt.getMonth() + 1;
   	var dateStr = dt.getDate() + "/" + month + "/" + dt.getFullYear();
    console.log(dateStr);
	document.getElementById('<portlet:namespace />fromDate').value = dateStr;
}

YUI().use(
  'aui-datepicker',
  function(Y) {
    toDate = new Y.DatePicker(
      {
        trigger: 'input[id=<portlet:namespace />toDate]',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        minDate: '11/10/2014',
        on: {
          selectionChange: function(event) {
          	var dt = event.newSelection[0];
          	var month = dt.getMonth() + 1;
          	var dateStr = dt.getDate() + "/" + month + "/" + dt.getFullYear();
            console.log(dateStr);
            Y.one('#<portlet:namespace />toDate').set('value', dateStr);
          }
        }
      }
    );
  }
);

function setToDate(dt) {
	var month = dt.getMonth() + 1;
   	var dateStr = dt.getDate() + "/" + month + "/" + dt.getFullYear();
    console.log(dateStr);
	document.getElementById('<portlet:namespace />toDate').value = dateStr;
}

// PROGRESS FROM 

//Create a YUI instance and request the slider module and its dependencies
var xInputProgressFrom,  // input tied to xSlider
    xSliderProgressFrom; // horizontal Slider
YUI().use("slider", function (Y) {

// Function to pass input value back to the Slider
function updateSliderProgressFrom( e ) {
    var data = this.getData(),
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
function updateInputProgressFrom( e ) {
    this.set( "value", e.newVal );
    Y.one('#progressFromValue').set('text', e.newVal);
    if (e.newVal > getSliderProgressTo()) {
    	setSliderProgressTo(e.newVal);
    }
}

// Create a horizontal Slider using all defaults
xSliderProgressFrom = new Y.Slider({
	value: 0,
	length: '225px'
});

// Link the input value to the Slider
xInputProgressFrom = Y.one( "#<portlet:namespace />progressFrom" );
xInputProgressFrom.setData( { slider: xSlider } );

// Pass the input as the 'this' object inside updateInput
xSliderProgressFrom.after( "valueChange", updateInputProgressFrom, xInputProgressFrom );
xInputProgressFrom.on( "keyup", updateSliderProgressFrom );

// Render the Slider next to the input
xSliderProgressFrom.render('.progressFromSlider');
});

function setSliderProgressFrom(val) {
	xSliderProgressFrom.setValue(val);
}

function getSliderProgressFrom() {
	return xSliderProgressFrom.getValue();
}

// PROGRESS TO

//Create a YUI instance and request the slider module and its dependencies
var xInputProgressTo,  // input tied to xSlider
    xSliderProgressTo; // horizontal Slider
YUI().use("slider", function (Y) {

// Function to pass input value back to the Slider
function updateSliderProgressTo( e ) {
    var data = this.getData(),
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
function updateInputProgressTo( e ) {
    this.set( "value", e.newVal );
    Y.one('#progressToValue').set('text', e.newVal);
    if (e.newVal < getSliderProgressFrom()) {
    	setSliderProgressFrom(e.newVal);
    }
}

// Create a horizontal Slider using all defaults
xSliderProgressTo = new Y.Slider({
	value: 100,
	length: '225px'
});

// Link the input value to the Slider
xInputProgressTo = Y.one( "#<portlet:namespace />progressTo" );
xInputProgressTo.setData( { slider: xSlider } );

// Pass the input as the 'this' object inside updateInput
xSliderProgressTo.after( "valueChange", updateInputProgressTo, xInputProgressTo );
xInputProgressTo.on( "keyup", updateSliderProgressTo );

// Render the Slider next to the input
xSliderProgressTo.render('.progressToSlider');
});

function setSliderProgressTo(val) {
	xSliderProgressTo.setValue(val);
}

function getSliderProgressTo() {
	return xSliderProgressTo.getValue();
}

</script>

