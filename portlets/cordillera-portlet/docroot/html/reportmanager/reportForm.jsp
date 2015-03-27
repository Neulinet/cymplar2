<%@ include file="/html/common/init.jsp" %>

<a type="button" id="modales" class="hidden" style="width:100%;" href="#modal-user-settings" data-toggle="modal">Add Image</a>

<!-- User Modal Settings, appears when clicking on 'User Settings' link found on user dropdown menu (header, top right) -->
<div id="modal-user-settings" class="modal">
    <!-- Modal Dialog -->
    <div class="modal-dialog" style="width: 300px">
        <!-- Modal Content -->
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4>Appointment</h4>
            </div>
            <!-- END Modal Header -->

            <!-- Modal Content -->
            <div class="modal-body">
            	<p id="calendarTitle"></p>
            	<p id="calendarDescription"></p>
            	<p id="calendarDate"></p>
            </div>
            <!-- END Modal Content -->

            <!-- Modal footer -->
            <div class="modal-footer remove-margin">
                <button class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
            </div>
            <!-- END Modal footer -->
        </div>
        <!-- END Modal Content -->
    </div>
    <!-- END Modal Dialog -->
</div>
<!-- END User Modal Settings -->


<liferay-portlet:actionURL var="reloadCalendarURL" name="reloadCalendar"/>

<div id="messageContainer"></div>

<form action="javascript:void(0)" method="post" name="reportManagerForm" id="reportManagerForm" class="form-horizontal form-box remove-margin">
	<!-- Form Header -->
	<h4 class="form-box-header">
		<liferay-ui:message key="Add new report" />
		<small>
		</small>
	</h4>

	<!-- Form Content -->
	<div class="form-box-content">
		<!-- Enterprise Select -->
		<div class="form-group">
		    <label class="control-label col-md-2" for="example-input-typeahead">Company</label>
		    <div class="col-md-10">
		        <div class="input-group">
		        	<liferay-portlet:actionURL var="getContactsAndContractsByEnterpriseURL" name="getContactsAndContractsByEnterprise"/>
		        	<input type="hidden" name="enterpriseId" id="_contactmanager_WAR_cordilleraportlet_enterpriseId" value="" autocomplete="off" />
		            <input onblur="javascript:fixEnterpriseSelected()" type="text" id="_contactmanager_WAR_cordilleraportlet_enterpriseSelect" name="enterpriseSelect" class="form-control example-typeahead2" placeholder="search.." autocomplete="off">
		            <span class="input-group-btn">
		                <button class="btn btn-default"><i class="fa fa-search"></i></button>
		            </span>
		        </div>
		    </div>
		</div>
		<!-- Contact Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_contact">Contact</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="getContactDetailURL" name="getContactDetail" />
				<select id="_reportmanager_WAR_cordilleraportlet_contact" name="contact" class="form-control" onchange="javascript:_reportmanager_WAR_cordilleraportlet_getContactDetail(this, '<%=getContactDetailURL %>')">
					<option value="-1">Choose a contact...</option>
				</select>
			</div>
		</div>
		<!-- Contract Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_contract">Contract</label>
			<div class="col-md-10">
				<liferay-portlet:actionURL var="getContractDetailURL" name="getContractDetail" />
				<select id="_reportmanager_WAR_cordilleraportlet_contract" name="contract" class="form-control" onchange="javascript:_reportmanager_WAR_cordilleraportlet_getContractDetail(this, '<%=getContractDetailURL %>')">
					<option value="-1">New contract</option>
				</select>
			</div>
		</div>
		<div class="form-group" id="_reportmanager_WAR_cordilleraportlet_contractDescContainer">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_contractDescription">Description</label>
			<div class="col-md-10">
				<input type="text" id="_reportmanager_WAR_cordilleraportlet_contractDescription" name="contractDescription" class="form-control" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_contractAmount">Amount</label>
			<div class="col-md-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-asterisk fa-fw"></i></span>
					<input type="text" id="_reportmanager_WAR_cordilleraportlet_contractAmount" name="contractAmount" class="form-control" autocomplete="off">
				</div>
			</div>
		</div>
		<!-- Method Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_method">Method</label>
			<div class="col-md-10">
				<select id="_reportmanager_WAR_cordilleraportlet_method" name="contactDataId" class="form-control">
					<option id="-1">No Methods</option>
				</select>
			</div>
		</div>
		<!-- Status Select -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_status">Status</label>
			<div class="col-md-10">
				<select id="_reportmanager_WAR_cordilleraportlet_status" name="statusCode" class="form-control" >
					<option value="0">Cold</option>
					<option value="100">Warm</option>
					<option value="200">Hot</option>
					<option value="300">Inactive</option>
				</select>
			</div>
		</div>
		<!-- Progress -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_status">Progress</label>
			<input type="hidden" id="_reportmanager_WAR_cordilleraportlet_progress" name="progress" value="" />
			<div class="col-md-10">
				<input type="button" class="btn btn-default col-md-1" onclick="javascript:downProgress()" value="-" />
				<div class="col-md-10">
					<div class="progress" id="progressBar">
						<div class="progress-bar progress-bar-danger" style="width: 0%;">0%</div>
					</div>
				</div>
				<input type="button" class="btn btn-default col-md-1" onclick="javascript:upProgress()" value="+" />
			</div>
		</div>
		<!-- Report Date -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_reportDate">Date</label>
			<div class="col-md-10">
				<div class="input-group">
					<span class="input-group-addon" onclick="javascript:showReportDatePicker()"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportmanager_WAR_cordilleraportlet_reportDate" name="reportDate" class="form-control" autocomplete="off" contenteditable="false" readonly="readonly">
				</div>
			</div>
		</div>
		<!-- Comments -->
		<div class="form-group">
			<label class="control-label col-md-2" for="_reportmanager_WAR_cordilleraportlet_comments">Comments</label>
			<div class="col-md-10">
				<textarea id="_reportmanager_WAR_cordilleraportlet_comments" name="comments" class="form-control textarea-elastic" rows="3" draggable="false" autocomplete="off"></textarea>
			</div>
		</div>
		<!-- Calendar Input -->
		<div class="form-group">
			<label class="control-label col-md-6" for="nextTime">Next Follow Up</label>
			<div class="col-md-6">
				<div class="input-group bootstrap-timepicker">
					<input type="text" id="nextTime" name="nextTime" class="form-control input-timepicker" autocomplete="off" readonly="readonly">
					<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="input-group date input-datepicker" data-date="" data-date-format="dd/mm/yyyy">
					<input type="text" id="nextDate" name="nextDate" class="form-control" autocomplete="off" readonly="readonly">
					<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
				</div>
			</div>
		</div>
		<div class="form-group form-actions">
			<div class="col-md-12 col-md-offset-4">
				<button onclick="javascript:_reportmanager_WAR_cordilleraportlet_cleanAll()" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
				<liferay-portlet:actionURL var="addReportURL" name="addReport" />
				<button onclick="javascript:submitReporte('<%=addReportURL %>')" class="btn btn-success"><i class="fa fa-check"></i> Submit</button>
			</div>
		</div>
	</div>
</form>

<%-- 	<aui:button-row cssClass="_reportmanager_WAR_cordilleraportlet_buttonSection"> --%>
<%-- 		<aui:button value="reset" cssClass="_reportmanager_WAR_cordilleraportlet_mediumButton" onClick="javascript:_reportmanager_WAR_cordilleraportlet_cleanAll()" /> --%>
<%-- 		<liferay-portlet:actionURL var="addReportURL" name="addReport" /> --%>
<!-- 		<button onclick="javascript:submitReporte('addReportURL')" class="_reportmanager_WAR_cordilleraportlet_bigButton">Save</button> -->
<%-- 	</aui:button-row> --%>

<liferay-portlet:actionURL var="getEnterprisesURL" name="getEnterprises" />


<script>

function reloadCalendar(actionUrl) {
	$.ajax({
		async: false,
		url:actionUrl,
		data: {},
		success: function(result) {
			console.log("Reload Calendar Response: " + result);
			$('#reportCalendar').html(result);
		}
	});	
}

function fixEnterpriseSelected() {
	var enterpriseId = document.getElementById("_contactmanager_WAR_cordilleraportlet_enterpriseId").value;
	console.log("EntId: " + enterpriseId);
	if (enterpriseId === null || enterpriseId.length === 0) {
		document.getElementById("_contactmanager_WAR_cordilleraportlet_enterpriseSelect").value = "";
	}
}

function _reportmanager_WAR_cordilleraportlet_cleanAll() {
	document.getElementById('_contactmanager_WAR_cordilleraportlet_enterpriseId').value = '';
	document.getElementById('_contactmanager_WAR_cordilleraportlet_enterpriseSelect').value = '';
	_reportmanager_WAR_cordilleraportlet_loadContacts([], document.getElementById('_reportmanager_WAR_cordilleraportlet_contact'));
	_reportmanager_WAR_cordilleraportlet_loadContracts([], document.getElementById('_reportmanager_WAR_cordilleraportlet_contract'));
	_reportmanager_WAR_cordilleraportlet_cleanContractDetails();
	$("#reportManagerForm").validate().resetForm();
}

function submitReporte(actionUrl) {
	// showLoading();
	
	if ($('#reportManagerForm').valid()) {
		$.ajax({
			async: false,
			url:actionUrl,
			type: "POST",
			data: $("#reportManagerForm").serialize(), 
			success: function(result) {
				try {
					document.getElementById("messageContainer").innerHTML = result;
					if (result.indexOf("error") < 0) {
						_reportmanager_WAR_cordilleraportlet_cleanAll();
						reloadCalendar('<%=reloadCalendarURL.toString() %>');
					}
					// hideLoading();
				} catch (e) {
					// hideLoading();
				}
			}
		});
	} else {
		console.log("[Report Manager]: Trying to submit Invalid fields");
	}
}

var reportDatePicker;
var current = new Date();
var reportMinDate = new Date(current.getFullYear(), current.getMonth(), current.getDate() - 30, 0, 0, 0, 0);

jQuery.validator.addMethod("greaterThan", function(value, element, params) {
	var d2 = new Date(reportMinDate.getFullYear(),reportMinDate.getMonth(),reportMinDate.getDate());
	console.log("Min Date: " + d2);
    if (!/Invalid|NaN/.test(new Date(value))) {
    	var v1 = value.split('/', -1);
    	var d1 = new Date(v1[2],v1[1]-1,v1[0]);
    	console.log("Current Date: " + d1);
        return d1 >= d2 && d1 <= current;
    }
    return isNaN(value) || (Number(value) > Number(d2)); 
	}, 
	function () { 
		return 'Please enter a date from to ' + reportMinDate.getDate() + "/" + (reportMinDate.getMonth() + 1) + "/" + reportMinDate.getFullYear() + ' to ' 
		+ current.getDate() + "/" + (current.getMonth() + 1) + "/" + current.getFullYear() + '!';
	}
);

$(function() {

    /* For advanced usage and examples please check out
     *  Jquery Validation   -> https://github.com/jzaefferer/jquery-validation
     */

    /* Initialize Form Validation */
    $('#reportManagerForm').validate({
        errorClass: 'help-block',
        errorElement: 'span',
        errorPlacement: function(error, e) {
            e.parents('.form-group > div').append(error);
        },
        highlight: function(e) {
        	console.log("Form Error...");
            $(e).closest('.form-group').removeClass('has-success has-error').addClass('has-error');
            $(e).closest('.help-block').remove();
        },
        success: function(e) {
        	console.log("Form Success...");
            // You can use the following if you would like to highlight with green color the input after successful validation!
            e.closest('.form-group').removeClass('has-success has-error'); // e.closest('.form-group').removeClass('has-success has-error').addClass('has-success');
            e.closest('.help-block').remove();
            e.closest('.help-inline').remove();
        },
        rules: {
        	enterpriseSelect: {
        		 required: true
        	},
        	contact: {
        		min: 1
        	},
        	contractAmount: {
                required: true,
                number: true
            },
            contractDescription: {
            	required: true
            },
            reportDate: {
                required: true,
                date: true,
                greaterThan: (reportMinDate.getMonth() + 1) + "/" + reportMinDate.getDate() + "/" + reportMinDate.getFullYear()
            },
            comments: {
            	required: true
            }
        },
        messages: {
        	enterpriseSelect: 'Please select a company!',
        	contractAmount: 'Please enter an amount!',
        	contractDescription: 'Please enter a description',
            contact: 'Please select a contact!',
            comments: 'Please enter a comment!'
        }
    });
});

</script>

<!-- Javascript code only for this page -->
<script>
    $(function() {
        // Demostration of progress bars
        var pbBar = $('#example-progress-bar .progress-bar');
        var pbButton = $('#example-progress-bar-button');

        pbButton.click(function() {
            $(this).button('loading');
            var i = 1;
            interval = setInterval(function() {
                pbBar.css('width', i + '%');
                if (i > 15)
                    pbBar.html(i * 10 + '/1000');
                if (i === 33)
                    pbBar.removeClass('progress-bar-danger').addClass('progress-bar-warning');
                if (i === 66)
                    pbBar.removeClass('progress-bar-warning').addClass('progress-bar-success');
                i++;
                if (i > 100) {
                    clearInterval(interval);
                    pbButton.html('Done!');
                    pbBar.html('<i class="fa fa-check"></i>');
                }
            }, 50);
        });
    });
</script>

<script>

/** Common methods **/

function _reportmanager_WAR_cordilleraportlet_parseJson(text) {
	return JSON.parse(text);
}

function _reportmanager_WAR_cordilleraportlet_loadingSelect(select) {
	if (select != null) {
		select.innerHTML = '<option value="-2">Loading...</option>';
	}
}

function showReportDatePicker() {
	$('#_reportmanager_WAR_cordilleraportlet_reportDate')[0].focus();
}

function _reportmanager_WAR_cordilleraportlet_loadFormComponents() {
    var current = new Date();
    reportMinDate = new Date(current.getFullYear(), current.getMonth(), current.getDate() - 30, 0, 0, 0, 0);
    
    reportDatePicker = $('#_reportmanager_WAR_cordilleraportlet_reportDate').datepicker({
//		onRender: function(date) {
//			var now = new Date();
//			return date.valueOf() < reportMinDate.valueOf() || date.valueOf() > now.valueOf() ? 'disabled' : '';
//		},
		format: 'dd/mm/yyyy'
	}).data('datepicker'); // Reffere To: http://www.eyecon.ro/bootstrap-datepicker/
	
//	var newDate = new Date(now);
//	newDate.setDate(newDate.getDate() + 1);
	reportDatePicker.setValue(new Date());
}

function downProgress() {
	var pbBar = $('#progressBar .progress-bar');
	var progressWidth = pbBar.html().substring(0, pbBar.html().length -1);
	if (progressWidth === '0') {
		return;
	}
	progressVal = parseInt(progressWidth) - 20;
	_reportmanager_WAR_cordilleraportlet_setProgress(progressVal);
}

function upProgress() {
	var pbBar = $('#progressBar .progress-bar');
	var progressWidth = pbBar.html().substring(0, pbBar.html().length - 1);
	if (progressWidth === '100') {
		return;
	}
	progressVal = parseInt(progressWidth) + 20;
	_reportmanager_WAR_cordilleraportlet_setProgress(progressVal);
}

/** Load Companies Methods (Init) **/

function _reportmanager_WAR_cordilleraportlet_loadEnterpriseList(enterpriseList) {
	$('#_contactmanager_WAR_cordilleraportlet_enterpriseSelect').typeahead({
		source: function (query, process) {
			states = [];
			map = {};
			var data = enterpriseList;
			$.each(data, function (i, enterprise) {
				map[enterprise.name] = enterprise;
				states.push(enterprise.name);
			});
			process(states);
		},
		updater: function (item) {
			selected = map[item];
			$( "#_contactmanager_WAR_cordilleraportlet_enterpriseId" ).val( selected.id );
	        _reportmanager_WAR_cordilleraportlet_getContactsAndContracts(this, '<%=getContactsAndContractsByEnterpriseURL %>', selected.id);
			return selected.name;
		},
		matcher: function (item) {
			document.getElementById('_contactmanager_WAR_cordilleraportlet_enterpriseId').value = '';
			_reportmanager_WAR_cordilleraportlet_loadContacts([], document.getElementById('_reportmanager_WAR_cordilleraportlet_contact'));
			_reportmanager_WAR_cordilleraportlet_loadContracts([], document.getElementById('_reportmanager_WAR_cordilleraportlet_contract'));
			_reportmanager_WAR_cordilleraportlet_cleanContractDetails();
			
			if (item.toLowerCase().indexOf(this.query.trim().toLowerCase()) != -1) {
				return true;
			}
		},
		sorter: function (items) {
			return items.sort();
		},
		highlighter: function (item) {
			var regex = new RegExp( '(' + this.query + ')', 'gi' );
			return item.replace( regex, "<strong>$1</strong>" );
		},
	});
}

function _reportmanager_WAR_cordilleraportlet_getEnterpriseList(actionUrl) {
	$.ajax({
		async: false,
		url:actionUrl,
		data: {},
		success: function(result) {
//			var select = document.getElementById('_reportmanager_WAR_cordilleraportlet_enterprise');
//			_reportmanager_WAR_cordilleraportlet_loadingSelect(select);
			_reportmanager_WAR_cordilleraportlet_loadEnterpriseList(_reportmanager_WAR_cordilleraportlet_parseJson(result).enterprises);
		}
	});
}

$( document ).ready(function() {
	console.log("Starting init");
	_reportmanager_WAR_cordilleraportlet_getEnterpriseList('<%=getEnterprisesURL.toString() %>');
	_reportmanager_WAR_cordilleraportlet_loadFormComponents();
	console.log("Finish to init");
});

/** Load Contacts and Contracts Methos **/

function _reportmanager_WAR_cordilleraportlet_cleanContactMethods() {
   	document.getElementById("_reportmanager_WAR_cordilleraportlet_method").innerHTML = '<option value="-1">No methods</option>';
}

function _reportmanager_WAR_cordilleraportlet_cleanContractDetails() {
	$(function() {
    	// $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider('value',0);
    	// $( "#"+"_reportmanager_WAR_cordilleraportlet_progressVal" ).text( $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) + "%" );
    	_reportmanager_WAR_cordilleraportlet_setProgress(0);
    	_reportmanager_WAR_cordilleraportlet_setMinDate('-30');
    });
    
	document.getElementById("_reportmanager_WAR_cordilleraportlet_status").value = 0;
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contract").value = -1;
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contractDescription").value = "";
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contractAmount").value = "";	
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contractDescContainer").style.display = "";
	document.getElementById("_reportmanager_WAR_cordilleraportlet_comments").value = "";
}

function _reportmanager_WAR_cordilleraportlet_setProgress(progress) {
   	$( "#"+"_reportmanager_WAR_cordilleraportlet_progress" ).val(progress);
   	var pbBar = $('#progressBar .progress-bar');
   	pbBar.html(progress + '%');
   	pbBar.css('width', progress + '%');
   	if (progress < 40)
		pbBar.removeClass('progress-bar-warning').removeClass('progress-bar-success').removeClass('progress-bar-info').addClass('progress-bar-danger');
	if (progress >= 40)
		pbBar.removeClass('progress-bar-success').removeClass('progress-bar-danger').removeClass('progress-bar-info').addClass('progress-bar-warning');
	if (progress >= 60)
		pbBar.removeClass('progress-bar-success').removeClass('progress-bar-danger').removeClass('progress-bar-warning').addClass('progress-bar-info');
	if (progress >= 100)
		pbBar.removeClass('progress-bar-warning').removeClass('progress-bar-danger').removeClass('progress-bar-info').addClass('progress-bar-success');
}

function _reportmanager_WAR_cordilleraportlet_loadContacts(contactList, select) {
	_reportmanager_WAR_cordilleraportlet_cleanContactMethods();
	var options = '<option value="-1">Choose a contact...</option>';
	for (var i=0; i<contactList.length; i++) {
		options += '<option value="' + contactList[i].id + '">' + contactList[i].name + '</option>';
	}
	select.innerHTML = options;
}

function _reportmanager_WAR_cordilleraportlet_loadContracts(contractList, select) {
	_reportmanager_WAR_cordilleraportlet_cleanContractDetails();
	var options = '<option value="-1">New contract</option>';
	for (var i=0; i<contractList.length; i++) {
		options += '<option value="' + contractList[i].id + '">' + contractList[i].description + '</option>';
	}
	select.innerHTML = options;
}

function _reportmanager_WAR_cordilleraportlet_getContactsAndContracts(select, actionUrl, enterpriseId) {
//	_reportmanager_WAR_cordilleraportlet_cleanMessages();
//	var index = select.selectedIndex;
//	var enterpriseId = select.options[index].value;
	$.ajax({
		async: false,
		url:actionUrl,
		data: {
			enterpriseId:enterpriseId
		},
		success: function(result) {
			var selectContact = document.getElementById('_reportmanager_WAR_cordilleraportlet_contact');
			_reportmanager_WAR_cordilleraportlet_loadingSelect(selectContact);
			_reportmanager_WAR_cordilleraportlet_loadContacts(_reportmanager_WAR_cordilleraportlet_parseJson(result).contacts, selectContact);
			
			var selectContract = document.getElementById('_reportmanager_WAR_cordilleraportlet_contract');
			_reportmanager_WAR_cordilleraportlet_loadingSelect(selectContract);
			_reportmanager_WAR_cordilleraportlet_loadContracts(_reportmanager_WAR_cordilleraportlet_parseJson(result).contracts, selectContract);
		}
	});
}

/** Load Contact Detail Methods **/

function _reportmanager_WAR_cordilleraportlet_loadMethods(methodList, select) {
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

function _reportmanager_WAR_cordilleraportlet_getContactDetail(select, actionUrl) {
//	_reportmanager_WAR_cordilleraportlet_cleanMessages();
	var index = select.selectedIndex;
   	var contactId = select.options[index].value;
	$.ajax({
		async: false,
		url:actionUrl,
		data: {
			contactId: contactId
		},
		success: function(result) {
			var select = document.getElementById('_reportmanager_WAR_cordilleraportlet_method');
			_reportmanager_WAR_cordilleraportlet_loadingSelect(select);
			_reportmanager_WAR_cordilleraportlet_loadMethods(_reportmanager_WAR_cordilleraportlet_parseJson(result).methods, select);
		},
		error: function(error) {
			console.log('error');
		}
	});
}

/** Load Contract Detail Methods **/

function _reportmanager_WAR_cordilleraportlet_setStatus(statusCode) {
	document.getElementById("_reportmanager_WAR_cordilleraportlet_status").value = statusCode;
}

function _reportmanager_WAR_cordilleraportlet_setMinDate(days) {
    var current = new Date();
    reportMinDate  = new Date(current.getFullYear(), current.getMonth(), current.getDate() + parseInt(days) + 1, 0, 0, 0, 0);
}

function _reportmanager_WAR_cordilleraportlet_loadContractDetail(contractDetail) {
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contractDescContainer").style.display = "none";
	document.getElementById("_reportmanager_WAR_cordilleraportlet_contractAmount").value = contractDetail.amount;
	
	var progress = contractDetail.progress;
	_reportmanager_WAR_cordilleraportlet_setProgress(progress);
	
	var statusCode = contractDetail.statusCode;
	_reportmanager_WAR_cordilleraportlet_setStatus(statusCode);
	
	var minDate  = contractDetail.minDate;
	_reportmanager_WAR_cordilleraportlet_setMinDate(minDate);
}

function _reportmanager_WAR_cordilleraportlet_getContractDetail(select, actionUrl) {
//	_reportmanager_WAR_cordilleraportlet_cleanMessages();
	var index = select.selectedIndex;
   	var contractId = select.options[index].value;
   	if (contractId == -1) {
   		_reportmanager_WAR_cordilleraportlet_cleanContractDetails();
   	} else {
		$.ajax({
			async: false,
			url:actionUrl,
			data: {
				contractId:contractId
			},
			success: function(result) {
				_reportmanager_WAR_cordilleraportlet_loadContractDetail(_reportmanager_WAR_cordilleraportlet_parseJson(result));
			}
		});
   	}
}

</script>
