<%@ include file="/html/common/init.jsp" %>

<div id="_reportsearch_WAR_cordilleraportlet_results">
	<%@ include file="/html/reportsearchresult/results2.jsp" %>
</div>

<!-- script type="text/javascript">
$(document).ready(function() {
	jQuery.fn.dataTableExt.oSort['usdate-asc']  = function(a,b) {
	    var usDatea = a.split('/'); 
	    var usDateb = b.split('/'); 
	    
	    var x = (usDatea[1] + usDatea[0] + usDatea[2]) * 1;
	    var y = (usDateb[1] + usDateb[0] + usDateb[2]) * 1;
	    
	    return ((x < y) ? -1 : ((x > y) ?  1 : 0));
	};

	jQuery.fn.dataTableExt.oSort['usdate-desc'] = function(a,b) {
	    var usDatea = a.split('/'); 
	    var usDateb = b.split('/'); 

	    var x = (usDatea[1] + usDatea[0] + usDatea[2]) * 1;
	    var y = (usDateb[1] + usDateb[0] + usDateb[2]) * 1;

	    return ((x < y) ? 1 : ((x > y) ?  -1 : 0));
	};
	oTable = $('#_reportsearch_WAR_cordilleraportlet_resultItems').dataTable({
		"bJQueryUI": true,
		"oLanguage": {
			"sEmptyTable": "No results"
		},
		"aoColumns": [ 
						{"sName": "date",           "sTitle": "Datess",         "bSortable": "true", "sType" : "usdate", "bSearchable": false},
						{"sName": "companyNane",    "sTitle": "Company Name", "bSortable": "true", "sType":"numeric"},
						{"sName": "contactName",    "sTitle": "Contact",      "bSortable": "true"},
						{"sName": "contractName",   "sTitle": "Contract",     "bSortable": "true"},
						{"sName": "consultantName", "sTitle": "Consultants",  "bSortable": "true"},
						{"sName": "method",         "sTitle": "Method",       "bSortable": "true"},
						{"sName": "progress",       "sTitle": "Progress",     "bSortable": "true"},
						{"sName": "status",         "sTitle": "Status",       "bSortable": "true"},
						{"sName": "comments",       "sTitle": "Comments",     "bSortable": "false"},
						],
		aaSorting:[]
	});
});
</script -->