package com.leancrm.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.leancrm.portlet.entity.ConsultantEntity;
import com.leancrm.portlet.entity.ContactColleague;
import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class OrganizationContactManager extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
	 
		if ("contactColleaguePagination".equals(resourceID)) {
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
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}
