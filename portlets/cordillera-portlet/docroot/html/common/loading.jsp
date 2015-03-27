<%@ include file="/html/common/init.jsp" %>
<div id="loading">
	<div id="loading-image">
		<% if (renderResponse != null) { %>
			<img alt="" src="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/loading_animation.gif") %>">
			<br />
			Loading
		<%} %>
	</div>
</div>