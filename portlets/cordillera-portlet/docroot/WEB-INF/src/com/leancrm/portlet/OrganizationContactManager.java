package com.leancrm.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.entity.ConsultantEntity;
import com.leancrm.portlet.entity.ContactColleague;
import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.model.Contract;
import com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.UserContractLocalServiceUtil;
import com.leancrm.portlet.utils.ContactManagerUtils;
import com.leancrm.portlet.utils.MailUtils;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class OrganizationContactManager extends MVCPortlet {
	private static Logger logger = Logger.getLogger(ContactManagerUtils.class);
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
	 
		if ("contactColleaguePagination".equals(resourceID)) {
			contractColleguePagination(resourceRequest, resourceResponse);
		} else if ("getContractUsers".equals(resourceID)) {
			getContractUsers(resourceRequest, resourceResponse);
		} else {	
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

	private void contractColleguePagination(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			JSONArray results = JSONFactoryUtil.createJSONArray();
			json.put("response", results);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ConsultantEntity consultant = new ConsultantEntity(themeDisplay.getUser());
			
			Integer pageNumber = ParamUtil.getInteger(resourceRequest, "pageNumber");
			Integer pageSize = ParamUtil.getInteger(resourceRequest, "pageSize");
			
			List<ContactColleague> contactColleagueList = new ArrayList<ContactColleague>();
			if (consultant.getOrganization() != null) {
				int start = (pageNumber - 1) * pageSize + 1;
				int end = pageNumber * pageSize;
				
				List<ColleagueAddressBookContact> resultList = ColleagueAddressBookContactLocalServiceUtil.getAll(consultant.getOrganization().getOrganizationId(), consultant.getConsultantId(), start, end);
				
				Map<Long, ContactColleague> temporaryResult = new HashMap<Long, ContactColleague>();
				if (resultList != null) { 
					for (ColleagueAddressBookContact result : resultList) {
						ContactColleague c = temporaryResult.get(result.getContactid());
						if (c == null) {
							c = new ContactColleague();
							temporaryResult.put(result.getContactid(), c);
						}
						Long methodId = result.getMethodId();
						if (methodId != null && methodId == 204) {
							c.setContactName( result.getContactName());
						} else if (methodId == 205) {
							c.setEnterpriseName( result.getEnterpriseName());
						}
						c.setOwnerEmail( result.getEmailAddress() );
						c.setHasOwner(c.getOwnerEmail() != null && !c.getOwnerEmail().trim().isEmpty());
					}
				}
				contactColleagueList.addAll(temporaryResult.values());
				
			}
			
   
			for (ContactColleague c : contactColleagueList) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				
				object.put("enterpriseName", c.getEnterpriseName());
				object.put("fullName", c.getContactName());
				object.put("ownerEmail", c.getOwnerEmail());
				object.put("hasOwnerEmail", String.valueOf(c.isHasOwner()));
//					object.put("contractDescription", c.getContractDescription());
//					object.put("contractProgress", c.getContractProgress());
//					object.put("contractStatus", c.getContractStatus());
				
				results.put(object);
			}
			
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Get users, responsible for contract: first return owner of contract, second - organization admins
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	private void getContractUsers(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		long contractId = ParamUtil.getLong(resourceRequest, "contractId");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray users = JSONFactoryUtil.createJSONArray();
		json.put("users", users);
		
		try {
			Contract contract = ContractLocalServiceUtil.getContract(contractId);
			User owner = UserContractLocalServiceUtil.getContractOwner(contractId);
			
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("userId", owner.getUserId());
			object.put("name", owner.getFullName() + " (Owner)");
			users.put(object);
			
			//get organization admins
			for (User orgAdmin : OrganizationUtils.getOrganizationAdmin(contract.getOrganizationId())) {
				if (orgAdmin.getUserId() != owner.getUserId()) {
					object = JSONFactoryUtil.createJSONObject();
					object.put("userId", orgAdmin.getUserId());
					object.put("name", orgAdmin.getFullName() + " (Admin)");
					users.put(object);
				}
			}
			
		} catch (Exception ex) {
			logger.error("Cannot get list of contract users", ex);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get contracts users", e);
		}
	}
	
	/** Send request to access specific lead
	 * 
	 * @param request
	 * @param response
	 */
	public void requestLead(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long contractId = ParamUtil.getLong(request, "contractId");
		long consultant = ParamUtil.getLong(request, "consultant");
		int leadAccess = ParamUtil.getInteger(request, "leadAccess");
		
		logger.info("User " + themeDisplay.getUserId() + " requested access to lead " + contractId + " from user " + consultant + " with leadAccess " + leadAccess);
 
		// TODO - permission checking
	        
		try {
			User leadOwner = UserLocalServiceUtil.getUser(consultant);
			Contract contract  = ContractLocalServiceUtil.getContract(contractId);
			MailUtils.sendRequestToLead(leadOwner, themeDisplay.getUser(), contract, leadAccess);
		} catch (Exception ex) {
			logger.error("Cannot get request to the lead", ex);
		}
	}
}
