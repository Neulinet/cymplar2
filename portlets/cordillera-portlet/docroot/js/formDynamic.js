
function updateSelect() {
	var select = document.getElementById("methods");
	var options = "";

	for (var i=0; i<methodList.length; i++) {
		if (methodUsed[methodList[i].id] == null || !methodUsed[methodList[i].id]) {
			options += '<option value="' + methodList[i].id + '">' + methodList[i].name + '</option>';
		}
	}
	
	select.innerHTML = options;
}
updateSelect();

var totalFields = 0;

function addField() {
	
	var component = document.getElementById("componentDemo").cloneNode(true);
	component.style.display = '';
	component.id = "component" + totalFields;
	
	var field = component.getElementsByTagName("input")[0];
	var fieldMethod = component.getElementsByTagName("input")[1];
	var methodSelected = document.getElementById("methods");
	
	var methodId = methodSelected.value;
	methodUsed[methodId] = true;
	
	var methodName = methodSelected.options[methodSelected.selectedIndex].text;
	
	field.name = "_contactmanager_WAR_cordilleraportlet_" + methodName + totalFields;
	fieldMethod.name = field.name + "Method";
	fieldMethod.id = field.name + "Method";
	fieldMethod.value = methodId;
	
	var label = component.getElementsByTagName("label")[0];
	//label.for = field.name;
	label.innerHTML = methodName;
	
	var removeButton = component.getElementsByTagName("button")[0];
	
	var paramName = methodName + totalFields;
	removeButton.onclick = function() {
		removeField(component.id, paramName, methodId, "addFields");
	};
	
	document.getElementById("fieldContainer").appendChild(component);
	
	addParam(paramName);
	
	totalFields++;
	
	updateSelect();
}

function removeField(componentId, fieldName, methodId, queueFields) {
	var component = document.getElementById(componentId);
	var parent = component.parentNode;
	parent.removeChild(component);
	
	removeParam(fieldName, queueFields);
	
	methodUsed[methodId] = false;
	
	updateSelect();
}

function addParam(paramName) {
	var queueFields = "addFields";
	var paramInput = document.getElementById(queueFields);
	
	if (paramInput.value.length > 0) {
		paramInput.value = paramInput.value + "," + paramName;
	} else {
		paramInput.value = paramName;
	}
}

function removeParam(paramName, queueFields) {
	var paramInput = document.getElementById(queueFields);
	var paramList = paramInput.value.split(",");
	var rest = "";
	var comma = "";
	
	if (paramList != null && paramList.length > 0) {
		for (var i=0; i<paramList.length; i++) {
			if (paramList[i]!=paramName) {
				rest = rest + comma + paramList[i];
				if (i==paramList.length-1) {
					comma = "";
				} else {
					comma = ",";
				}
			}
		}
	}
	
	paramInput.value = rest;
}

function submitAddContactForm() {
	var formFields = document.forms.contactForm['addFields'].value.split(',');
	if (validateContactForm(formFields)) {
		document.forms.contactForm.submit();
	}
}

function submitEditContactForm() {
	var formOldFields = [];
	var validateOldFields = true;
	var validateNewFields = true;
	
	if (document.forms.contactForm['editFields'].value != "") {
		formOldFields = document.forms.contactForm['editFields'].value.split(',');
		validateOldFields = validateContactForm(formOldFields);
	}
	
	var formNewFields = [];
	if (document.forms.contactForm['addFields'].value != "") {
		formNewFields = document.forms.contactForm['addFields'].value.split(',');
		validateNewFields = validateContactForm(formNewFields);
	}
	
	if (validateOldFields && validateNewFields) {
		document.forms.contactForm.submit();
	}
}

function validateContactForm(formFields) {

	document.getElementById("formErrorMessage").innerHTML = "";
	document.getElementById("contactFormMessage").style.display = "none";
	
	for (var i=0; i<formFields.length; i++) {
		var fieldName = "_contactmanager_WAR_cordilleraportlet_" + formFields[i];
		
		var methodName = document.getElementById(fieldName + "Method").value;
		var fieldValue = document.forms.contactForm[fieldName].value;
		if (fieldValue == "" || fieldValue == -1) {
			document.getElementById("formErrorMessage").innerHTML = "Please, fill every field.";
			document.getElementById("contactFormMessage").style.display = "block";
			return false;
		} else if (methodName == 1003 && !validateEmail(fieldValue)) {
			document.getElementById("formErrorMessage").innerHTML = "Please, enter a valid email.";
			document.getElementById("contactFormMessage").style.display = "block";
			return false;
		}
	}

	return true;
}

function validateEmail(email) {
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2 >= email.length) {
		return false;
	}
	
	return true;
}