<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/html/common/init.jsp" %>


<table id="resultItems1" class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="cell-small"></th>
			<th><i class="fa fa-calendar"></i> Date</th>
			<th><i class="fa fa-building"></i> Company Name</th>
			<th class="hidden-xs hidden-sm hidden-md"><i class="fa fa-user"></i> Contact</th>
			<th><i class=""></i> Contract</th>
			<th class="hidden-xs hidden-sm hidden-md"><i class="fa fa-user"></i> Consultant</th>
			<th class="hidden-xs hidden-sm hidden-md"><i class=""></i> Method</th>
			<th><i class=""></i> Progress</th>
			<th class="hidden-xs hidden-sm hidden-md"><i class=""></i> Status</th>
			<th class="hidden-xs hidden-sm hidden-md"><i class="fa fa-pencil-square"></i> Comments</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchResultsItems}" var="item">
			<tr>
				<td class="text-center">
					<div class="btn-group">
					</div>
				</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.reportDate}" /></td>
				<td>${item.enterprise.name}</td>
				<td>${item.contactName}</td>
				<td>${item.contract.description}</td>
				<td>${item.consultant.fullName}</td>
				<td>${item.methodUsed}</td>
				<td>${item.progress}</td>
				<td>${item.status}</td>
				<td>${item.comments}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Javascript code only for this page -->
<script>
    $(function() {
        /* Initialize Datatables */
        $('#resultItems1').dataTable({"aoColumnDefs": [{"bSortable": false, "aTargets": [0]}]});
        $('.dataTables_filter input').attr('placeholder', 'Search');
    });
</script>
