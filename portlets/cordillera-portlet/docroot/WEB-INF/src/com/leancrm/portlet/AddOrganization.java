package com.leancrm.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.Industry;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.IndustryLocalServiceUtil;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.leancrm.portlet.utils.ConstantDefinitions;
import com.leancrm.portlet.utils.CustomFieldUtils;
import com.leancrm.portlet.utils.MailUtils;
import com.leancrm.portlet.utils.OrganizationCode;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.validator.CompanyValidator;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.CountryConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.RegionConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AddOrganization
 */
public class AddOrganization extends MVCPortlet {
 
	private Logger logger = Logger.getLogger(this.getClass());

	public void selectOrganization(ActionRequest actionRequest, ActionResponse actionResponse) {
		String code = ParamUtil.getString(actionRequest, "code");
		try {
			long organizationId = OrganizationCode.decode(code);
			if (organizationId > 0) {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				if (ValidationsUtil.isCompany(organizationId)) {
					
					// SET CUSTOM FIELD WITH THE ID OF THE ORGANIZATION ID REQUESTED
					CustomFieldUtils.setCustomValue(themeDisplay.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, themeDisplay.getUserId(), organizationId);
					// UserLocalServiceUtil.updateUser(member);
					
					// CREATE ADDRESS BOOK IN CASE IT WAS NOT CREATED BEFORE
					List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
					if (addressBookUserList == null || addressBookUserList.isEmpty()) {
						AddressBookLocalServiceUtil.addAddressBookUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
					}
					
					// SEND AN EMAIL TO THE ADMINS OF THE ORGANIZATION ABOUT A MEMBER REQUEST
					List<User> adminList = OrganizationUtils.getOrganizationAdmin(organizationId);
					for (User admin : adminList) {
						MailUtils.sendRequestToBeMember(admin, themeDisplay.getUser(), OrganizationLocalServiceUtil.getOrganization(organizationId));
					}
				}
				
				SessionMessages.add(actionRequest, CRMErrorKey.ORGANIZATION_REQUEST_CREATED_SUCCESS);
			} else {
				SessionErrors.add(actionRequest, CRMErrorKey.INVALID_ORGANIZATION_CODE);
			}
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		}
	}
	
	public void getOrganizationDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		try {
			String code = ParamUtil.getString(resourceRequest, "code");
			long organizationId = OrganizationCode.decode(code);
			if (organizationId > 0) {
				try {
					Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
					json.put("name", organization.getName());
				} catch (Exception e) {
					json.put("error", "Could not found an organization with that code");
				}
			} else {
				json.put("error", "Invalid organization code");
			}
		} catch (Exception e) {
			json.put("error", "Unexpected error when try to get organization from code. " + e.getMessage());
			logger.error("Unexpected error when try to get organization from code.", e);
		}
		
		try {
			writeJSON(resourceRequest, resourceResponse, json);
		} catch (IOException e) {
			logger.error("Unexpected error when try to get enterprises from report manager.", e);
		}
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
	 
		if ("getOrganizationDetail".equals(resourceID)) {
			getOrganizationDetail(resourceRequest, resourceResponse);
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	public void removeRequest(ActionRequest actionRequest, ActionResponse actionResponse) {
		//CalEvent event = CalEventLocalServiceUtil.crea
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			// REMOVE/UPDATE CUSTOM FIELD WITH THE ID OF THE ORGANIZATION ID REQUESTED
			CustomFieldUtils.setCustomValue(themeDisplay.getCompanyId(), ConstantDefinitions.PENDING_COMPANY_FIELD, themeDisplay.getUserId(), 0);
			// UserLocalServiceUtil.updateUser(themeDisplay.getUser());
			
			// TODO PERHAPS WILL BE NECESARY TO SEND AN EMAIL TO THE ORGANIZATION
			
			SessionMessages.add(actionRequest, CRMErrorKey.ORGANIZATION_REQUEST_REMOVED_SUCCESS);
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
			
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getMessage());
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getMessage());
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		}
	}
	
	public void createOrganization(ActionRequest actionRequest, ActionResponse actionResponse) {
		String companyName = ParamUtil.getString(actionRequest, "name");
		String taxid = ParamUtil.getString(actionRequest, "taxId");
		String countryId = ParamUtil.getString(actionRequest, "countryId");
		String regionId = ParamUtil.getString(actionRequest, "regionId");
		String postalCode = ParamUtil.getString(actionRequest, "postalCode");
		String city = ParamUtil.getString(actionRequest, "city");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String street2 = ParamUtil.getString(actionRequest, "street2");
		String street3 = ParamUtil.getString(actionRequest, "street3");
		Long industryId = ParamUtil.getLong(actionRequest, "industryId");
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			CompanyValidator validator = new CompanyValidator();
			
			if (validator.validateCompanyName(companyName) && validator.validateAddress(countryId, regionId, postalCode, city, street1, street2, street3)) {
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Organization.class.getName(), actionRequest);

				Organization organizationCreated = OrganizationLocalServiceUtil.addOrganization(
						/** user id */ themeDisplay.getUserId(),
						/** parent id */ OrganizationConstants.ANY_PARENT_ORGANIZATION_ID,
						/** name */ companyName,
						/** type */ OrganizationConstants.TYPE_REGULAR_ORGANIZATION,
						/** region id */ RegionConstants.DEFAULT_REGION_ID,
						/** country id */ CountryConstants.DEFAULT_COUNTRY_ID,
						/** status id */ 12017,
						/** comments */ taxid,
						/** site */ false,
						/** context */ serviceContext
						);
				
				int billingAddres = 12000;
				
				AddressLocalServiceUtil.addAddress(
						/** userId */ themeDisplay.getUserId(), 
						/** className */ Organization.class.getName(), 
						/** classPK */ organizationCreated.getOrganizationId(), 
						/** street1 */ street1, 
						/** street2 */ street2, 
						/** street3 */ street3, 
						/** city */ city, 
						/** zip */ postalCode, 
						/** regionId */ Long.parseLong(regionId), 
						/** countryId */ Long.parseLong(countryId), 
						/** typeId */ billingAddres, 
						/** mailing */ true, 
						/** primary */ true,
						/** serviceContext */ serviceContext);
				
				UserLocalServiceUtil.addOrganizationUsers(organizationCreated.getOrganizationId(), new long[] { themeDisplay.getUserId() });
				
				Industry industry = IndustryLocalServiceUtil.getIndustry(industryId);
				CustomFieldUtils.setCustomValue(themeDisplay.getCompanyId(), ConstantDefinitions.INDUSTRY_FIELD, organizationCreated, new String[] {industry.getName()});
								
				// ADD USER TO REGULAR USERGROUP
				UserGroup regularUserGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGULAR_USER_GROUP_NAME);
				UserGroup registerOnlyGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGISTER_ONLY_GROUP_NAME);
				
				if (ValidationsUtil.isUserGroup(regularUserGroup.getUserGroupId())) {
					
					UserLocalServiceUtil.addUserGroupUsers(regularUserGroup.getUserGroupId(), new long[] { themeDisplay.getUserId() });
				} else {
					logger.error("Error when try to add a user (" + themeDisplay.getUserId()+ ") in the regular group.");
				}
				
				// REMOVE USER FROM REGISTER ONLY USERGROUP
				if (ValidationsUtil.isUserGroup(registerOnlyGroup.getUserGroupId())) {
					
					UserLocalServiceUtil.deleteUserGroupUser(registerOnlyGroup.getUserGroupId(), themeDisplay.getUserId());
				} else {
					logger.error("Error when try to delete a user (" + themeDisplay.getUserId()+ ") from the register only group.");
				}
				
				// add user to the role
				Role companyAdministratorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), ConstantDefinitions.ROLE_COMPANY_ADMINISTRATOR);
				RoleLocalServiceUtil.addUserRoles(themeDisplay.getUserId(), new long[] { companyAdministratorRole.getRoleId() });
				
				// List<UserGroupRole> o = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
				// for (UserGroupRole ugr : o) {
				//	UserGroupRoleLocalServiceUtil.deleteUserGroupRole(ugr);
				// }
				
				AddressBookLocalServiceUtil.addAddressBookOrganization(organizationCreated.getOrganizationId(), themeDisplay.getCompanyId());
				
				List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(themeDisplay.getUserId());
				if (addressBookUserList == null || addressBookUserList.isEmpty()) {
					AddressBookLocalServiceUtil.addAddressBookUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
				}
				
				SessionMessages.add(actionRequest, CRMErrorKey.ORGANIZATION_CREATED_SUCCESS);
				
				// REDIRECT TO THE USER PRIVATE PAGES
				String redirectUrl = "/group/" + themeDisplay.getUser().getScreenName() + "/~/"
						+ regularUserGroup.getUserGroupId()
						+ "/my-dashboard";
				actionResponse.sendRedirect(redirectUrl);				
			} else {
				for (String message : validator.getMessageList()) {
					SessionErrors.add(actionRequest, message);
				}
				
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", "/html/addOrganization/companyAddForm.jsp");
			}
			
		} catch (PortalException e) {
			logger.error("Cannot add organization", e);
			SessionErrors.add(actionRequest, e.getMessage());
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		} catch (SystemException e) {
			logger.error("Cannot add organization", e);
			SessionErrors.add(actionRequest, e.getMessage());
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		} catch (IOException e) {
			logger.error("Cannot add organization", e);
			SessionErrors.add(actionRequest, e.getMessage());
			actionResponse.setRenderParameter("jspPage", "/html/addOrganization/view.jsp");
		}
	}
	
}