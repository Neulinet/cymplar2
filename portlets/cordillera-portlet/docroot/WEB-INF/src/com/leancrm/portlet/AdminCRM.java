package com.leancrm.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookOrganization;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.ContactData;
import com.leancrm.portlet.library.model.ContactDataMethod;
import com.leancrm.portlet.library.model.Enterprise;
import com.leancrm.portlet.library.model.Industry;
import com.leancrm.portlet.library.model.impl.AddressBookOrganizationImpl;
import com.leancrm.portlet.library.model.impl.AddressBookUserImpl;
import com.leancrm.portlet.library.service.AddressBookContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookOrganizationLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactDataMethodLocalServiceUtil;
import com.leancrm.portlet.library.service.ContactLocalServiceUtil;
import com.leancrm.portlet.library.service.ContractLocalServiceUtil;
import com.leancrm.portlet.library.service.EnterpriseLocalServiceUtil;
import com.leancrm.portlet.library.service.IndustryLocalServiceUtil;
import com.leancrm.portlet.library.service.ReportLocalServiceUtil;
import com.leancrm.portlet.utils.AddressBookType;
import com.leancrm.portlet.utils.AddressBookUtils;
import com.leancrm.portlet.utils.CleanKey;
import com.leancrm.portlet.utils.ConstantDefinitions;
import com.leancrm.portlet.utils.CRMErrorKey;
import com.liferay.portal.kernel.cal.TZSRecurrence;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdminCRM
 */
public class AdminCRM extends MVCPortlet {
	
	private Logger logger = Logger.getLogger(AdminCRM.class);
	
	
	
	
	public void addEvent(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		TZSRecurrence occure =new TZSRecurrence();
		occure.setFrequency(3);
		
		List<CalEvent> events = CalEventLocalServiceUtil.getEvents(themeDisplay.getUser().getGroupId(), "event", 0, 10);
		for (CalEvent e : events) {
			System.out.println(e.getDescription());
		}
		
		
		CalEventLocalServiceUtil.addEvent(
				themeDisplay.getUserId(), // userId
				"Test Event", // title
				"Event Desc", // description
				"", // location
				8, // startDateMonth
				27, // startDateDay
				2014, // startDateYear
				6, // startDateHour
				0, // startDateMinute
				8, // endDateMonth
				27, // endDateDay
				2014, // endDateYear
				1, // durationHour
				0, // durationMinute
				false, // allDay
				false, // timeZoneSensitive
				"event", // type
				false, // repeating
				occure, // recurrence
				0, // remindBy
				300000, // firstReminder
				300000, // secondReminder
				ServiceContextFactory.getInstance(User.class.getName(), request) ); // serviceContext
	}
	
	private void goToPage(ActionRequest actionRequest, ActionResponse actionResponse, String page) throws ServletException, IOException, PortletException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletResponse servletResponse = PortalUtil.getHttpServletResponse(actionResponse);
		
		servletRequest.getRequestDispatcher(page).forward(servletRequest, servletResponse);
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void addIndustry(ActionRequest actionRequest, ActionResponse actionResponse) {
		String name = ParamUtil.getString(actionRequest, "name");
		
		if (name != null) {
			try {
				IndustryLocalServiceUtil.addIndustry(name);
				logger.info("Industry added: " + name);
			} catch (SystemException e) {
				SessionErrors.add(actionRequest, e.getMessage());
				logger.error("Error when try to add industry.", e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			}
		} else {
			SessionErrors.add(actionRequest, "invalid-industry-name-key");
			logger.error("Could not add the industry with name: " + name);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateIndustry(ActionRequest actionRequest, ActionResponse actionResponse) {
		long industryId = ParamUtil.getLong(actionRequest, "industryId");
		String name = ParamUtil.getString(actionRequest, "name");
		
		if (name != null) {
			try {
				Industry industry = IndustryLocalServiceUtil.getIndustry(industryId);
				if (industry != null) {
					industry.setName(name);
					IndustryLocalServiceUtil.updateIndustry(industry);
					logger.info("Industry with id " + industryId + " updated. Name: " + name);
				}
			} catch (SystemException e) {
				SessionErrors.add(actionRequest, e.getMessage());
				logger.error("Error when try to update industry with id " + industryId, e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			} catch (PortalException e) {
				logger.error("Error when try to update industry with id " + industryId, e);
				SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			}
		} else {
			SessionErrors.add(actionRequest, "invalid-industry-name-key");
			logger.error("Could not update industry with id " + industryId);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void showIndustryForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		long industryId = ParamUtil.getLong(actionRequest, "industryId");
		
		try {
			Industry industry = IndustryLocalServiceUtil.getIndustry(industryId);
			
			actionRequest.setAttribute("industry", industry);
			
			goToPage(actionRequest, actionResponse, "/html/admincrm/adminIndustryForm.jsp");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void removeIndustry(ActionRequest actionRequest, ActionResponse actionResponse) {
		long industryId = ParamUtil.getLong(actionRequest, "industryId");
		try {
			List<Enterprise> enterpriseList = EnterpriseLocalServiceUtil.getEnterpriseByIndustryId(industryId);
			if (enterpriseList == null || enterpriseList.size() == 0) {
				IndustryLocalServiceUtil.deleteIndustry(industryId);
				logger.info("Industry with id " + industryId + " removed.");
			} else {
				SessionErrors.add(actionRequest, "error-industry-in-use");
				logger.error("Could not remove industry with id " + industryId);
			}
			
		} catch (SystemException e) {
			logger.error("Error when try to remove industry with id " + industryId, e);
		} catch (PortalException e) {
			logger.error("Error when try to remove industry with id " + industryId, e);
		}
	}
	
	public void addMethod(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String name = ParamUtil.getString(actionRequest, "name");
		int type = ParamUtil.getInteger(actionRequest, "type");
		
		if (name != null) {
			try {
				ContactDataMethodLocalServiceUtil.addContactDataMethod(themeDisplay.getCompanyId(), name.toLowerCase(), StringUtil.upperCaseFirstLetter(name), type);
				logger.info("Method added: " + name + " (" +  type + ")");
			} catch (SystemException e) {
				SessionErrors.add(actionRequest, e.getMessage());
				logger.error("Error when try to add method.", e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			}
		} else {
			SessionErrors.add(actionRequest, "invalid-method-name-key");
			logger.error("Could not add the method with name: " + name);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	public void updateMethod(ActionRequest actionRequest, ActionResponse actionResponse) {
		long methodId = ParamUtil.getLong(actionRequest, "methodId");
		String name = ParamUtil.getString(actionRequest, "name");
		int type = ParamUtil.getInteger(actionRequest, "type");
		
		if (name != null) {
			try {
				ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(methodId);
				if (method != null) {
					method.setName(name);
					method.setContactDataType(type);
					ContactDataMethodLocalServiceUtil.updateContactDataMethod(method);
					logger.info("Method with id " + methodId + " updated. Name: " + name + ", Type: " + type);
				}
			} catch (SystemException e) {
				SessionErrors.add(actionRequest, e.getMessage());
				logger.error("Error when try to update method with id " + methodId, e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			} catch (PortalException e) {
				logger.error("Error when try to update method with id " + methodId, e);
				SessionErrors.add(actionRequest, CRMErrorKey.UNEXPECTED_ERROR);
			}
		} else {
			SessionErrors.add(actionRequest, "invalid-method-name-key");
			logger.error("Could not update method with id " + methodId);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	public void showMethodForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		long methodId = ParamUtil.getLong(actionRequest, "methodId");
		
		try {
			ContactDataMethod method = ContactDataMethodLocalServiceUtil.getContactDataMethod(methodId);
			
			actionRequest.setAttribute("method", method);
			
			goToPage(actionRequest, actionResponse, "/html/admincrm/adminMethodForm.jsp");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeMethod(ActionRequest actionRequest, ActionResponse actionResponse) {
		long methodId = ParamUtil.getLong(actionRequest, "methodId");
		try {
			List<ContactData> contactDataList = ContactDataLocalServiceUtil.getContactDataByMethod(methodId);
			if (contactDataList == null || contactDataList.size() == 0) {
				ContactDataMethodLocalServiceUtil.deleteContactDataMethod(methodId);
				logger.info("Method with id " + methodId + " removed.");
			} else {
				SessionErrors.add(actionRequest, "error-method-in-use");
				logger.error("Could not remove metod with id " + methodId);
			}
			
		} catch (SystemException e) {
			logger.error("Error when try to remove method with id " + methodId, e);
		} catch (PortalException e) {
			logger.error("Error when try to remove method with id " + methodId, e);
		}
	}

	public void cleanOrganization(ActionRequest actionRequest, ActionResponse actionResponse) {
		// remove contracts? contract - report
		// remove contacts? contact data - ref - text - ab contact data - ab contact - contact
		// remove address book? ab - ab organization
		// remove user in group?
		long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			AddressBook addressBook = AddressBookUtils.getAddressBook(OrganizationLocalServiceUtil.getOrganization(organizationId));
			int[] cleansSelected = ParamUtil.getIntegerValues(actionRequest, "cleans");
			
			if (cleansSelected != null && cleansSelected.length > 0) {
				for (int clean : cleansSelected) {
					CleanKey cleanKey = CleanKey.getOptionClean(clean);
					switch (cleanKey) {
					case REMOVE_CONTRACTS:
						ContractLocalServiceUtil.removeOrganizationContracts(organizationId);
						logger.info("Contracts of an organization with id " + organizationId + " removed.");
						break;
					case REMOVE_CONTACTS:
						AddressBookContactDataLocalServiceUtil.removerContactDatas(addressBook.getAddressBookId());
						AddressBookContactLocalServiceUtil.removeAddressBookContact(addressBook.getAddressBookId());
						ContactLocalServiceUtil.cleanContacs();
						logger.info("Contacts of an organization with id " + organizationId + " removed.");
						break;
					case REMOVE_ADDRESS_BOOK:
						AddressBookOrganizationLocalServiceUtil.deleteAddressBookOrganization(addressBook.getAddressBookId());
						AddressBookLocalServiceUtil.deleteAddressBook(addressBook.getAddressBookId());
						logger.info("Address book of an organization with id " + organizationId + " removed.");
						break;
					case REMOVE_USER_GROUP:
						List<User> userList = UserLocalServiceUtil.getOrganizationUsers(organizationId);
						if (userList != null) {
							for (User user : userList) {
								UserGroup regularUserGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGULAR_USER_GROUP_NAME);
								UserLocalServiceUtil.deleteUserGroupUser(regularUserGroup.getUserGroupId(), user.getUserId());
								
								UserGroup registerOnlyGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGISTER_ONLY_GROUP_NAME);
								UserLocalServiceUtil.addUserGroupUsers(registerOnlyGroup.getUserGroupId(), new long[] { user.getUserId() });
								
								logger.info("User with id " + user.getUserId() + " unlinked of an organization with id " + organizationId + ".");
							}
						}
						break;
					default:
						logger.warn("Any clean option matched.");
						break;
					}
				}
			} else {
				logger.warn("Any clean option selected.");
			}
			
		} catch (SystemException e) {
			logger.error("Error when try to clean organization with id " + organizationId, e);
		} catch (PortalException e) {
			logger.error("Error when try to clean organization with id " + organizationId, e);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	public void cleanUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		// remove reports? report
		// remove contacts? contact data - ref - text - ab contact data - ab contact - contact
		// remove address book? ab - ab user
		// remove from group?
		long userId = ParamUtil.getLong(actionRequest, "userId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		try {
			AddressBook addressBook = AddressBookUtils.getAddressBook(UserLocalServiceUtil.getUser(userId));
			int[] cleansSelected = ParamUtil.getIntegerValues(actionRequest, "cleans");
			
			for (int clean : cleansSelected) {
				CleanKey cleanKey = CleanKey.getOptionClean(clean);
				switch (cleanKey) {
				case REMOVE_REPORTS:
					ReportLocalServiceUtil.updateUserOfReports(userId, 0);
					logger.info("Reports of an user with id " + userId + " removed.");
					break;
				case REMOVE_CONTACTS:
					AddressBookContactDataLocalServiceUtil.removerContactDatas(addressBook.getAddressBookId());
					AddressBookContactLocalServiceUtil.removeAddressBookContact(addressBook.getAddressBookId());
					ContactLocalServiceUtil.cleanContacs();
					logger.info("Contacts of an user with id " + userId + " removed.");
					break;
				case REMOVE_ADDRESS_BOOK:
					AddressBookUserLocalServiceUtil.deleteAddressBookUser(addressBook.getAddressBookId());
					AddressBookLocalServiceUtil.deleteAddressBook(addressBook.getAddressBookId());
					logger.info("Address book of an user with id " + userId + " removed.");
					break;
				case REMOVE_USER_GROUP:
					UserGroup regularUserGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGULAR_USER_GROUP_NAME);
					UserLocalServiceUtil.deleteUserGroupUser(regularUserGroup.getUserGroupId(), userId);
					
					UserGroup registerOnlyGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), ConstantDefinitions.REGISTER_ONLY_GROUP_NAME);
					UserLocalServiceUtil.addUserGroupUsers(registerOnlyGroup.getUserGroupId(), new long[] { userId });
					
					logger.info("User with id " + userId + " unlinked of an organization with id " + regularUserGroup.getGroup().getOrganizationId() + ".");
					break;
				default:
					logger.warn("Any clean option matched.");
					break;
				}
			}
		} catch (SystemException e) {
			logger.error("Error when try to clean user with id " + userId, e);
		} catch (PortalException e) {
			logger.error("Error when try to clean user with id " + userId, e);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
	}
	
	public void createAddressBookUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String userIdChoosed = ParamUtil.getString(actionRequest, "userIdChoosed");
		
		try {
			if (userIdChoosed != null && !userIdChoosed.isEmpty()) {
				AddressBook addressBook = AddressBookLocalServiceUtil.addAddressBook(themeDisplay.getCompanyId(), AddressBookType.USER.getTypeId());
				
				Long userId = Long.parseLong(userIdChoosed);
				AddressBookUser addressBookUser = new AddressBookUserImpl();
				addressBookUser.setUserId(userId);
				addressBookUser.setAddressBookId(addressBook.getAddressBookId());
				
				AddressBookUserLocalServiceUtil.addAddressBookUser(addressBookUser);
			}
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getMessage());
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
		
		
	}
	
	public void createAddressBookOrganization(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String orgIdChoosed = ParamUtil.getString(actionRequest, "orgIdChoosed");
		
		try {
			if (orgIdChoosed != null && !orgIdChoosed.isEmpty()) {
				AddressBook addressBook = AddressBookLocalServiceUtil.addAddressBook(themeDisplay.getCompanyId(), AddressBookType.ORGANIZATION.getTypeId());
				
				Long orgId = Long.parseLong(orgIdChoosed);
				AddressBookOrganization addressBookOrganization = new AddressBookOrganizationImpl();
				addressBookOrganization.setOrganizationId(orgId);
				addressBookOrganization.setAddressBookId(addressBook.getAddressBookId());
				
				AddressBookOrganizationLocalServiceUtil.addAddressBookOrganization(addressBookOrganization);
			}
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getMessage());
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/admincrm/view.jsp");
		
		
	}
}