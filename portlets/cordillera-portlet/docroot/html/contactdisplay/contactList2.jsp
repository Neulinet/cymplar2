<%@ include file="/html/common/consultantInit.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="myContactDataTable"></div>

<div id="contactPagination" class="aui-pagination aui-pagination-centered">
	<ul class="aui-pagination-content">
		<li><a href="#">Prev</a></li>
		<c:forEach var="i" begin="1" end="${consultant.contactsCountPaged}">
			<li><a href="#">${i}</a></li>
		</c:forEach>
		<li><a href="#">Next</a></li>
	</ul>
</div>

<liferay-portlet:resourceURL id="contactPagination" var="contactPaginationURL" />

<script>

function cellFormat(o) {
	var row = o.cell.ancestor();
	row.one('td');

    row.insert(
        '<tr class="auth"><td colspan="3">' +
            '<button class="ok">authorize</button>' +
            '<button class="stop">discontinue</button>' +
        '</td></tr>',
        'after');
	
    // Fill the column cells with data from firstName and lastName
    return false;
}

var dataTableContact;
YUI().use(
	'aui-datatable',
	'aui-pagination',
	'aui-datatype',
	'datatable-sort',
	function(Y) {
		var columns = [ {label:'Company', key: 'enterpriseName'}, {label: 'Full Name', key: 'fullName'}, {label: 'Contract', key: 'contractDescription'}, {label: 'Progress', key: 'contractProgress'}, {label: 'Status', key: 'contractStatus'}, {label: 'Actions', key: '', formatter: '<a href="" data-toggle="tooltip" title="Edit" class="btn btn-xs btn-success">Edit</a><a href="" data-toggle="tooltip" title="Edit" class="btn">Remove</a>'}];
		// dataPageOne = [{ enterpriseName:"", fullName:"", contractDescription:"", contractProgress:"", contractStatus:"" }],
		
		dataTableContact = new Y.DataTable({
			columnset: columns
			// data: dataPageOne,
		}).render('#myContactDataTable');
		
		new Y.Pagination({
			contentBox: '#contactPagination .aui-pagination-content',
			page: 1,
			on: {
				changeRequest: function(event) {
					console.log(
				             'page:', event.state.page,
				             'getOffsetPageNumber:', this.getOffsetPageNumber()
				           );
					doNextContactPage(event.state.page);
				}
			},
			offset: 1,
			circular: false
		}).render();
	}
);

function doNextContactPage(page) {
YUI().use(
	'aui-io-request',
	function (Y) {
		Y.io.request('<%=contactPaginationURL%>',
		{
			data: {
				<portlet:namespace />pageNumber: page,
				<portlet:namespace />pageSize: 10
			},
			dataType: 'json',
			on: {
				success: function() {
					var data = this.get('responseData');
					console.log("Data 1: ");
					console.log(data);
					console.log(data.response);
					dataTableContact.set('data', data.response);
				}
			}
		});
	}
);
}

</script>