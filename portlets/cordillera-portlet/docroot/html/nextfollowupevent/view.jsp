<%@page import="com.leancrm.portlet.entity.ContactEntity"%>
<%@page import="com.leancrm.portlet.library.service.ContactLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contact"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactDataMethod"%>
<%@page import="com.leancrm.portlet.library.service.ContactDataLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.ContactData"%>
<%@page import="com.leancrm.portlet.utils.ReportManagerUtils"%>
<%@page import="com.leancrm.portlet.types.FollowUpEventStatus"%>
<%@page import="com.leancrm.portlet.library.model.Report"%>
<%@page import="com.leancrm.portlet.library.service.NextFollowUpEventLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.NextFollowUpEvent"%>
<%@page import="com.leancrm.portlet.library.service.ContractLocalServiceUtil"%>
<%@page import="com.leancrm.portlet.library.model.Contract"%>
<%@page import="com.leancrm.portlet.entity.ConsultantEntity"%>
<%@ include file="/html/common/init.jsp" %>

<p>
<%@ include file="/html/nextfollowupevent/followUpEventList.jsp" %>
</p>