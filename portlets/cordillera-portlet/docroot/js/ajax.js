function getAjaxRequest(actionUrl, afterResponse, title) {
	return AUI().io.request(actionUrl,{
		autoLoad: false,
		on: {
			success: function() {
				var response = this.get('responseData');
				afterResponse(response, title);
			}
		}
	});
}

function showLoading() {
	document.getElementById("loading").style.display = "block";
}

function hideLoading() {
	document.getElementById("loading").style.display = "none";
}

function submitContactForm2(actionUrl) {
	showLoading();
	//callback handler for form submit
	$("#contactForm").submit( function(e) {
		var postData = $(this).serializeArray();
		var formURL = $(this).attr("action");
		$.ajax({
			url : formURL,
			type: "POST",
			data : postData,
			success:function(data, textStatus, jqXHR) {
				$("#contactMessageContainer").html(data);
				hideLoading();
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("#contactMessageContainer").html(jqXHR);
			}
		});
		e.preventDefault();
		$("#contactForm").unbind();
	});
	
	$("#contactForm").submit();
}

function submitContactForm(actionUrl) {
	
	showLoading();
	AUI().io.request(actionUrl,{
		method: 'POST',
		form: { id: 'contactForm' },
		on: {
			success: function(){
				alert(actionUrl);
				var response = this.get('responseData');
				document.getElementById("contactMessageContainer").innerHTML = response;
				if (response.indexOf("error") < 0) {
					cleanContactForm();
					document.getElementById("cancelButton").value = "Done";
				}
				hideLoading();
			},
		
			error: function() {
				alert('error');
			}
		}
	});
}

function callPopup(body, title){
	AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
		AUI().pdialog = new A.Dialog({
			title: title,
			centered: true,
			modal: true,
			draggable: true,
			bodyContent: body
		}).render();
	});
}

function showMethodFormPopup(actionUrl, methodId) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Edit Method');
	
	ajaxRequest.set("data", {
		methodId: methodId
	});
	
	ajaxRequest.start();
}

function removeMethod(actionUrl, methodName) {
	if (confirm("Are you sure to remove the method " + methodName)) {
		window.location = actionUrl;
	}
}

function showIndustryFormPopup(actionUrl, industryId) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Edit Industry');
	
	ajaxRequest.set("data", {
		industryId: industryId
	});
	
	ajaxRequest.start();
}

function removeIndustry(actionUrl, industryName) {
	if (confirm("Are you sure to remove the industry " + industryName)) {
		window.location = actionUrl;
	}
}

function showOrganizationDetail(actionUrl, organizationId) {
	var ajaxRequest = getAjaxRequest(
			actionUrl, 
			function showEnterpriseDetail(content, title) {
				document.getElementById('organizationDetail').innerHTML = content;
			}, 
			'');
	
	ajaxRequest.set("data", {
		organizationId: organizationId
	});
	
	ajaxRequest.start();
}

function showOrganizationCleanPopup(actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Select clean option');
	ajaxRequest.start();
}

function showUserCleanPopup(actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Select clean option');
	ajaxRequest.start();
}

function showAddContactFormPopup(actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Add Contact');
	ajaxRequest.start();
}

function showAddEnterpriseFormPopup(actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Add Company');
	ajaxRequest.start();
}

function showAssignRolePopup(actionUrl, userId) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Assign Role');
	
	ajaxRequest.set("data", {
		userId: userId
	});
	
	ajaxRequest.start();
}

function showAddEnterpriceFormPopup(actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, callPopup, 'Add Company Form');

	ajaxRequest.set("data", {
		userId: 0
	});
	
	ajaxRequest.start();
}


function showEnterpriseDetail(content, title) {
	document.getElementById('enterpriseDetail').innerHTML = content;
}

function getEnterpriseDetail(event, actionUrl) {
	var ajaxRequest = getAjaxRequest(actionUrl, showEnterpriseDetail, 'Enterprise detail');
	
	var enterpriseSelected = document.getElementById("_contactmanager_WAR_cordilleraportlet_enterpriseId");
	var index = enterpriseSelected.selectedIndex;
	var enterpriseId = enterpriseSelected.options[index].value;
	
	if (enterpriseId > 0) {
		ajaxRequest.set("data", {
			enterpriseId: enterpriseId
		});
	
		ajaxRequest.start();
	} else {
		showEnterpriseDetail("", "");
	}
	
	
}

function removeContactData(actionUrl, contactDataId, method, methodId, value, componentId) {
	var params = componentId + "," + contactDataId + "," + methodId + ",editFields";
	
	if (confirm("Are you sure to remove the " + method + ": " + value)) {
		var ajaxRequest = getAjaxRequest(actionUrl, removeContactDataElement, params);
	
		ajaxRequest.set("data", {
			contactDataId: contactDataId
		});
		
		ajaxRequest.start();
	}
}

function removeContactDataElement(response, params) {
	var paramArray = params.split(",");
	var componentId = paramArray[0];
	var fieldName = paramArray[1];
	var methodId = paramArray[2];
	var queueFields = paramArray[3];
	
	removeField(componentId, fieldName, methodId, queueFields);
}