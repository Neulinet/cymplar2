<%@page import="com.leancrm.portlet.entity.ConsultantEntity"%>
<%@ include file="/html/common/init.jsp" %>
<c:set var="consultant" value="<%=new ConsultantEntity(user) %>" />
