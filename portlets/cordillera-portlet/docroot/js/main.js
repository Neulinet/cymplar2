AUI.add(
	'liferay-users-admin',
	function(A) {
		var Addresses = {
			getCountries: function(callback) {
				Liferay.Service.Portal.Country.getCountries(
					{
						active: true
					},
					callback
				);
			},

			getRegions: function(callback, selectKey) {
				Liferay.Service.Portal.Region.getRegions(
					{
						countryId: Number(selectKey),
						active: true
					},
					callback
				);
			}
		};

		Liferay.UsersAdmin = {
			Addresses: Addresses
		};
	}
);

//function submitContactForm() {
	//var formFields = document.forms.contactForm['addFields'].value.split(',');
	//if (validateContactForm(formFields)) {
//		document.forms.contactForm.submit();
	//}
//}

function showAddEnterpriseForm() {
	document.getElementById("addEnterprise").className = "shown";
	document.getElementById("searchEnterprise").className = "hidden";
	document.getElementById("enterpriseDetail").innerHTML = "";
	document.getElementById("enterpriseId").value = "";
	document.getElementById("enterpriseName").value = "";
	document.getElementById("isEnterpriseNew").checked = "checked";
	
}

function showAutoCompleteEnterprise() {
	document.getElementById("addEnterprise").className = "hidden";
	document.getElementById("searchEnterprise").className = "shown";
	document.getElementById("newEnterpriseName").value = "";
	document.getElementById("newEnterpriseTaxId").value = "";
	document.getElementById("isEnterpriseNew").checked = "";
}