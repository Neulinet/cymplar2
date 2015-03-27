<%@ include file="/html/common/init.jsp" %>

<p>
	<%@ include file="/html/reportsearch/reportForm2.jsp" %>
</p>


<script>
YUI().use("event", function (Y) {
    Y.on("domready", function (e) {
    	getConsultantList();
    });  
});
</script>