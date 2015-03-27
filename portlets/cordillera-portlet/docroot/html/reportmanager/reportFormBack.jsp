<%@ include file="/html/common/init.jsp" %>

<div id="messageContainer"></div>

<form action="" method="post" name="reportManagerForm" id="reportManagerForm" class="form-horizontal form-box remove-margin">
	<!-- Form Header -->
	<h4 class="form-box-header">
		<liferay-ui:message key="" />
		<small>
		</small>
	</h4>

	<!-- Form Content -->
	<div class="form-box-content">
		<!-- Enterprise Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_enterprise">Company</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getContactsAndContractsByEnterpriseURL" name="getContactsAndContractsByEnterprise" />
				<select id="_reportmanager_WAR_cordilleraportlet_enterprise" name="enterprise" class="form-control" onchange="javascript:_reportmanager_WAR_cordilleraportlet_getContactsAndContracts(this, '<%=getContactsAndContractsByEnterpriseURL %>')">
					<option value="-1">Choose a company...</option>
					<option>html</option>
					<option>css</option>
					<option>javascript</option>
					<option>php</option>
					<option>mysql</option>
				</select>
			</div>
		</div>
		<!-- Contact Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_contact">Contact</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getContactDetailURL" name="getContactDetail" />
				<select id="_reportmanager_WAR_cordilleraportlet_contact" name="contact" class="form-control" onchange="javascript:_reportmanager_WAR_cordilleraportlet_getContactDetail(this, '<%=getContactDetailURL %>')">
					<option value="-1">Choose a contact...</option>
					<option>html</option>
					<option>css</option>
					<option>javascript</option>
					<option>php</option>
					<option>mysql</option>
				</select>
			</div>
		</div>
		<!-- Contract Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_contract">Contract</label>
			<div class="col-md-9">
				<liferay-portlet:actionURL var="getContractDetailURL" name="getContractDetail" />
				<select id="_reportmanager_WAR_cordilleraportlet_contract" name="contract" class="form-control" onchange="javascript:_reportmanager_WAR_cordilleraportlet_getContractDetail(this, '<%=getContractDetailURL %>')">
					<option value="-1">New contract</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_contractDescription">Contract Description</label>
			<div class="col-md-9">
				<input type="text" id="_reportmanager_WAR_cordilleraportlet_contractDescription" name="contractDescription" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_contractAmount">Contract Amount</label>
			<div class="col-md-9">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-asterisk fa-fw"></i></span>
					<input type="text" id="_reportmanager_WAR_cordilleraportlet_contractAmount" name="contractAmount" class="form-control">
				</div>
			</div>
		</div>
		<!-- Method Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_method">Method</label>
			<div class="col-md-9">
				<select id="_reportmanager_WAR_cordilleraportlet_method" name="contactDataId" class="form-control">
					<option id="-1">No Methods</option>
				</select>
			</div>
		</div>
		<!-- Status Select -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_status">Status</label>
			<div class="col-md-9">
				<select id="_reportmanager_WAR_cordilleraportlet_status" name="statusCode" class="form-control" >
					<option value="0">Cold</option>
					<option value="100">Warm</option>
					<option value="200">Hot</option>
					<option value="300">Inactive</option>
				</select>
			</div>
		</div>
		<!-- Progress -->
		<div class="row push">
			<div class="col-sm-3">Progress</div>
			<input type="hidden" id="_reportmanager_WAR_cordilleraportlet_progress" name="progress" value="" />
			<div class="col-sm-9">
				<div class="progress">
					<div class="progress-bar progress-bar-danger" style="width: 30%;">30%</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-warning" style="width: 45%;">45%</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-info" style="width: 60%;">60%</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-success" style="width: 75%;">75%</div>
				</div>
			</div>
		</div>
		<!-- Report Date -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_reportDate">Report date</label>
			<div class="col-md-9">
				<div class="input-group date input-datepicker" data-date="04-30-2013" data-date-format="mm-dd-yyyy">
					<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
					<input type="text" id="_reportmanager_WAR_cordilleraportlet_reportDate" name="reportDate" class="form-control">
				</div>
			</div>
		</div>
		<!-- Comments -->
		<div class="form-group">
			<label class="control-label col-md-3" for="_reportmanager_WAR_cordilleraportlet_comments">Comments</label>
			<div class="col-md-9">
				<textarea id="_reportmanager_WAR_cordilleraportlet_comments" name="comments" class="form-control textarea-elastic" rows="3"></textarea>
			</div>
		</div>
		<div class="form-group form-actions">
			<div class="col-md-12 col-md-offset-3">
				<button type="reset" class="btn btn-danger"><i class="fa fa-repeat"></i> Reset</button>
				<button type="submit" class="btn btn-success"><i class="fa fa-check"></i> Submit</button>
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
                $(e).closest('.form-group').removeClass('has-success has-error').addClass('has-error');
                $(e).closest('.help-block').remove();
            },
            success: function(e) {
                // You can use the following if you would like to highlight with green color the input after successful validation!
                e.closest('.form-group').removeClass('has-success has-error'); // e.closest('.form-group').removeClass('has-success has-error').addClass('has-success');
                e.closest('.help-block').remove();
                e.closest('.help-inline').remove();
            },
            rules: {
            	contractAmount: {
                    required: true,
                    number: true
                },
                reportDate: {
                    required: true,
                    date: true
                }
            },
            messages: {
            	contractAmount: 'Please enter a number!',
            	_reportmanager_WAR_cordilleraportlet_contractAmount: 'Please enter a number!',
                reportDate: 'Please select a date!'
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

	/** Auxiliar methods **/
	
	function _reportmanager_WAR_cordilleraportlet_loadingSelect(select) {
		if (select != null) {
			select.innerHTML = '<option value="-2">Loading...</option>';
		}
	}
	
	function _reportmanager_WAR_cordilleraportlet_parseJson(text) {
		return JSON.parse(text);
	}
	
	/** Loader form methods **/
	
	function _reportmanager_WAR_cordilleraportlet_loadEnterpriseList(enterpriseList, select) {
		var options = '<option value="-1">Choose a company...</option>';
		for (var i=0; i<enterpriseList.length; i++) {
			options += '<option value="' + enterpriseList[i].id + '">' + enterpriseList[i].name + ' ' + enterpriseList[i].taxid + '</option>';
		}
		select.innerHTML = options;
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

	function _reportmanager_WAR_cordilleraportlet_setProgress(progress) {
		$(function() {
	    	$( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider('value',progress);
	    	$( "#"+"_reportmanager_WAR_cordilleraportlet_progressVal" ).text( $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) + "%" );
	    	$( "#"+"_reportmanager_WAR_cordilleraportlet_progress" ).val( $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) );
	    });
	}
	
	function _reportmanager_WAR_cordilleraportlet_setStatus(statusCode) {
		document.getElementById("_reportmanager_WAR_cordilleraportlet_status").value = statusCode;
	}

	function _reportmanager_WAR_cordilleraportlet_setMinDate(minDate) {
		$("#"+"_reportmanager_WAR_cordilleraportlet_reportDate").datepicker( 'option', 'minDate', minDate );
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
	
	/** Data retrieve methods **/
	
	function _reportmanager_WAR_cordilleraportlet_getEnterpriseList(actionUrl) {
		_reportmanager_WAR_cordilleraportlet_cleanMessages();
		$.ajax({
			async: false,
			url:actionUrl,
			data: {},
			success: function(result) {
				var select = document.getElementById('_reportmanager_WAR_cordilleraportlet_enterprise');
				_reportmanager_WAR_cordilleraportlet_loadingSelect(select);
				_reportmanager_WAR_cordilleraportlet_loadEnterpriseList(_reportmanager_WAR_cordilleraportlet_parseJson(result).enterprises, select);
			}
		});
	}
	
	function _reportmanager_WAR_cordilleraportlet_getContactsAndContracts(select, actionUrl) {
		_reportmanager_WAR_cordilleraportlet_cleanMessages();
		var index = select.selectedIndex;
    	var enterpriseId = select.options[index].value;
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
	
	function _reportmanager_WAR_cordilleraportlet_getContactDetail(select, actionUrl) {
		_reportmanager_WAR_cordilleraportlet_cleanMessages();
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
	
	function _reportmanager_WAR_cordilleraportlet_getContractDetail(select, actionUrl) {
		_reportmanager_WAR_cordilleraportlet_cleanMessages();
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
	
	/** Cleaners form methods **/
	
	function _reportmanager_WAR_cordilleraportlet_cleanMessages() {
		var messageContainer = document.getElementById('messageContainer');
		messageContainer.innerHMTL = '';
	}
	
	function _reportmanager_WAR_cordilleraportlet_cleanAll() {
		var select = document.getElementById('_reportmanager_WAR_cordilleraportlet_enterprise');
		select.focus();
		select.value = -1;
		select.onchange();
	}
	
	function _reportmanager_WAR_cordilleraportlet_cleanContactMethods() {
	   	document.getElementById("_reportmanager_WAR_cordilleraportlet_method").innerHTML = '<option value="-1">No methods</option>';
	}
	
	function _reportmanager_WAR_cordilleraportlet_cleanContractDetails() {
		$(function() {
	    	// $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider('value',0);
	    	// $( "#"+"_reportmanager_WAR_cordilleraportlet_progressVal" ).text( $( "#"+"_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) + "%" );
	    	_reportmanager_WAR_cordilleraportlet_setProgress(0);
	    	$("#"+"_reportmanager_WAR_cordilleraportlet_reportDate").datepicker( 'option', 'minDate', -30 );
	    	$("#"+"_reportmanager_WAR_cordilleraportlet_reportDate").datepicker('setDate', new Date());
	    });
	    
		document.getElementById("_reportmanager_WAR_cordilleraportlet_status").value = 0;
		document.getElementById("_reportmanager_WAR_cordilleraportlet_contract").value = -1;
		document.getElementById("_reportmanager_WAR_cordilleraportlet_contractDescription").value = "";
		document.getElementById("_reportmanager_WAR_cordilleraportlet_contractAmount").value = "";	
		document.getElementById("_reportmanager_WAR_cordilleraportlet_contractDescContainer").style.display = "";
		document.getElementById("_reportmanager_WAR_cordilleraportlet_comments").value = "";
	}
	
	/** Data sender methods **/
	
	function submitReporte(actionUrl) {
		// showLoading();
		console.log(actionUrl);
		$.ajax({
			async: false,
			url:actionUrl,
			type: "POST",
			data: $("#_reportmanager_WAR_cordilleraportlet_reportForm").serialize(), 
			success: function(result) {
				try {
					document.getElementById("messageContainer").innerHTML = result;
					if (result.indexOf("error") < 0) {
						_reportmanager_WAR_cordilleraportlet_cleanAll();
						
						var select = document.getElementById('_reportsearch_WAR_cordilleraportlet_enterprise');
						select.value = -1;
						select.onchange();
						
						var searchButton = document.getElementById('_reportsearch_WAR_cordilleraportlet_searchReportButton');
						searchButton.click();
					}
					// hideLoading();
				} catch (e) {
					// hideLoading();
				}
			}
		});
	}
	
	/** Initializer methods **/
	
	function _reportmanager_WAR_cordilleraportlet_loadFormComponents() {
		$(function() {
			$( "#_reportmanager_WAR_cordilleraportlet_slider" ).slider({
				value: 0,
				min: 0,
				max: 100,
				step: 20,
				range: "min",
				animate: "slow",
				slide: function( event, ui ) {
					$( "#_reportmanager_WAR_cordilleraportlet_progress" ).val( ui.value );
					$( "#_reportmanager_WAR_cordilleraportlet_progressVal" ).text(ui.value + "%");
				}
			});
			$( "#_reportmanager_WAR_cordilleraportlet_progress" ).val( $( "#_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) );
			$( "#_reportmanager_WAR_cordilleraportlet_progressVal" ).text( $( "#_reportmanager_WAR_cordilleraportlet_slider" ).slider( "value" ) + "%" );
			
			$( "#_reportmanager_WAR_cordilleraportlet_reportDate" ).datepicker({
				showOn: 'both',
				<% if (renderResponse != null) { %>
					buttonImage: '<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/calendar-add.png") %>',
				<%} %>
				
				buttonImageOnly: true,
				maxDate: 0,
				minDate: -30,
				dateFormat: 'dd/mm/yy'
			});
			$("#_reportmanager_WAR_cordilleraportlet_reportDate").datepicker('setDate', new Date());
		});
	}
	
	$( document ).ready(function() {
		_reportmanager_WAR_cordilleraportlet_getEnterpriseList('<%=getEnterprisesURL.toString() %>');
		_reportmanager_WAR_cordilleraportlet_loadFormComponents();
	});
</script>
