<%@ include file="/html/common/consultantInit.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="myColleagueDataTable"></div>

<div id="colleaguePagination" class="aui-pagination aui-pagination-centered">
	<ul class="aui-pagination-content">
		<li><a href="#">Prev</a></li>
		<c:forEach var="i" begin="1" end="${consultant.colleaguesContactsCountPaged}">
			<li><a href="#">${i}</a></li>
		</c:forEach>
		<li><a href="#">Next</a></li>
	</ul>
</div>

<liferay-portlet:resourceURL id="contactColleaguePagination" var="contactColleaguePaginationURL" />

<script>

var dataTableColleague;
YUI().use(
	'aui-datatable',
	'aui-pagination',
	'aui-datatype',
	'datatable-sort',
	function(Y) {
		var columns = [{label: 'Company', key: 'enterpriseName'}, {label: 'Full Name', key: 'contactName'}, {label: 'Owner Email', key: 'emailAddress'}, {label: 'Actions', key: '', formatter: ''}];
		
		dataTableColleague = new Y.DataTable({
			columnset: columns,
			rowsPerPage: 4
			// data: dataPageOne,
		}).render('#myColleagueDataTable');
		
		new Y.Pagination({
			contentBox: '#colleaguePagination .aui-pagination-content',
			page: 1,
			on: {
				changeRequest: function(event) {
					doNextColleaguePage(event.state.page);
				}
			},
			circular: false
		}).render();
	}
);

function doNextColleaguePage(page) {
YUI().use(
	'aui-io-request',
	function (Y) {
		Y.io.request('<%=contactColleaguePaginationURL%>',
		{
			data: {
				<portlet:namespace />pageNumber: page,
				<portlet:namespace />pageSize: 10
			},
			dataType: 'json',
			on: {
				success: function() {
					var data = this.get('responseData');
					dataTableColleague.set('data', data.response);
				}
			}
		});
	}
);
}

</script>