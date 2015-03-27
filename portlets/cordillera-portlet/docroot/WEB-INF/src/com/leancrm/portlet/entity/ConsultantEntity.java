package com.leancrm.portlet.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leancrm.portlet.library.model.AddressBook;
import com.leancrm.portlet.library.model.AddressBookContact;
import com.leancrm.portlet.library.model.AddressBookUser;
import com.leancrm.portlet.library.model.ColleagueAddressBookContact;
import com.leancrm.portlet.library.model.Contact;
import com.leancrm.portlet.library.model.MyAddressBookContact;
import com.leancrm.portlet.library.model.impl.AddressBookContactImpl;
import com.leancrm.portlet.library.service.AddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookLocalServiceUtil;
import com.leancrm.portlet.library.service.AddressBookUserLocalServiceUtil;
import com.leancrm.portlet.library.service.ColleagueAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.library.service.MyAddressBookContactLocalServiceUtil;
import com.leancrm.portlet.types.ContractStatus;
import com.leancrm.portlet.utils.OrganizationUtils;
import com.leancrm.portlet.validator.ValidationsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ConsultantEntity {

	private Logger logger = Logger.getLogger(ConsultantEntity.class);
	
	private User user;
	
	public ConsultantEntity(User user) {
		this.user = user;
	}
	
	public ConsultantEntity(Long userId) throws PortalException, SystemException {
		this.user = UserLocalServiceUtil.getUser(userId);
	}
	
	public String getFullName() {
		return this.user.getFullName();
	}
	
	public String getFirstName() {
		return this.user.getFirstName(); 
	}
	
	public String getMiddleName() {
		return this.user.getMiddleName(); 
	}
	
	public String getLastName() {
		return this.user.getLastName(); 
	}
		
	public long getConsultantId() {
		return user.getUserId();
	}
	
	public long getCompanyId() {
		return user.getCompanyId();
	}
	
	public String getEmailAddress() {
		return user.getEmailAddress();
	}
	
	public OrganizationEntity getOrganization() {
		try {
			Organization organization = OrganizationUtils.getOrganizationByUser(user.getUserId());
			if (organization != null) {
					return new OrganizationEntity(organization.getOrganizationId());
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public AddressBook getAddressBook() {
		try {
			List<AddressBookUser> addressBookUserList = AddressBookUserLocalServiceUtil.getAddressBookUserList(user.getUserId());
			if (!ValidationsUtil.isEmpty(addressBookUserList)) {
				return AddressBookLocalServiceUtil.getAddressBook(addressBookUserList.get(0).getAddressBookId());
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getContactsCount() {
		return getContacts().size();
	}
	
	public int getContactsCountPaged() {
		return Math.round(getContactsCount()/10) + 1;
	}
	
	public int getColleaguesContactsCount() {
		return getColleaguesContacts().size();
	}
	
	public int getColleaguesContactsCountPaged() {
		return Math.round(getColleaguesContactsCount()/10) + 1;
	}
	
	public List<ContactEntity> getContacts() {
		List<ContactEntity> contacts = new ArrayList<ContactEntity>();
		try {
			AddressBook addressBook = getAddressBook();
			if (addressBook != null) {
				List<Contact> contactList = AddressBookLocalServiceUtil.getContacts(addressBook.getAddressBookId());
				if (!ValidationsUtil.isEmpty(contactList)) {
					for (Contact contact : contactList) {
						contacts.add(new ContactEntity(contact.getContactId(), user.getUserId()));
					}
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		logger.info("Total getContacts: " + contacts.size());
		
		return contacts;
	}
	
	public List<com.leancrm.portlet.entity.Contact> getMyContacts(int start, int end) {
		List<com.leancrm.portlet.entity.Contact> contactList = new ArrayList<com.leancrm.portlet.entity.Contact>();
		try {
			if (getOrganization() != null) {
				List<MyAddressBookContact> resultList;
				
				resultList = MyAddressBookContactLocalServiceUtil.getAll(getOrganization().getOrganizationId(), getConsultantId(), start*2, end*2);
				Map<Long, com.leancrm.portlet.entity.Contact> temporaryResult = new HashMap<Long, com.leancrm.portlet.entity.Contact>();
				if (resultList != null) {
					for (MyAddressBookContact result : resultList) {
						com.leancrm.portlet.entity.Contact c = temporaryResult.get(result.getContactId());
						if (c == null) {
							c = new com.leancrm.portlet.entity.Contact();
							c.setContactId(result.getContactId());
							temporaryResult.put(result.getContactId(), c);
						}
						Long methodId = result.getMethodId();
						if (methodId != null && methodId == 204) {
							c.setFullName( result.getContactName());
						} else if (methodId == 205) {
							c.setEnterpriseName( result.getEnterpriseName());
							
							Long contractId = result.getContactId();
							if (contractId != null && contractId > 0) {
								c.setContractDescription( result.getDescription() );
								c.setContractProgress( String.valueOf(result.getProgress()) );
								ContractStatus cs = ContractStatus.getContractStatus( Integer.parseInt(String.valueOf(result.getStatus())) );
								c.setContractStatus( cs.getLabel() );
							}
						}
					}
				}
				contactList.addAll(temporaryResult.values());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactList;
	}

	public List<ContactEntity> getColleaguesContacts() {
		Map<Long, ContactEntity> colleaguesContacts = new HashMap<Long, ContactEntity>();
		
//		OrganizationEntity organization = getOrganization();
//		if (organization != null) {
//			List<ContactEntity> contacts = organization.getContacts();
//			logger.info("Total getColleaguesContacts Organization Contacts: : " + contacts.size());
//			if (contacts != null) {
//				for (ContactEntity contact : contacts) {
//					colleaguesContacts.put(contact.getContactId(), contact);
//				}
//			}
//		}
		
		List<ConsultantEntity> colleagueList = getColleagues();
		logger.info("Total getColleaguesContacts Collegues: " + colleagueList.size());
		if (colleagueList != null) {
			for (ConsultantEntity colleague : colleagueList) {
				List<ContactEntity> contacts = colleague.getContacts();
				logger.info("Total getColleaguesContacts Colleague Contacts: : " + contacts.size());
				if (contacts != null) {
					for (ContactEntity contact : contacts) {
						if (!colleaguesContacts.containsKey(contact.getContactId())) {
							colleaguesContacts.put(contact.getContactId(), contact);
						}
					}
				}
			}
		}
		
		logger.info("Total getColleaguesContacts: " + colleaguesContacts.size());
		
		return new ArrayList<ContactEntity>(colleaguesContacts.values());
	}
	
	public List<ContactColleague> getMyColleagueContacts(int start, int end) {
		List<ContactColleague> contactColleagueList = new ArrayList<ContactColleague>();
		try {
			if (getOrganization() != null) {
				List<ColleagueAddressBookContact> resultList = ColleagueAddressBookContactLocalServiceUtil.getAll(getOrganization().getOrganizationId(), getConsultantId(), start*2, end*2);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactColleagueList;
	}
	
	public boolean isAdmin() {
		try {
			return RoleServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.ADMINISTRATOR, true);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<ConsultantEntity> getColleagues() {
		List<ConsultantEntity> colleagues = new ArrayList<ConsultantEntity>();
		
		try {
			List<User> userList = UserLocalServiceUtil.getOrganizationUsers(getOrganization().getOrganizationId());
			if (userList != null) {
				for (User user : userList) {
					if (user.getUserId() != this.user.getUserId()) {
						colleagues.add(new ConsultantEntity(user));
					}
				}
			}
		} catch (Exception e) {
			logger.warn("Unexpected error while get colleagues.", e);
		}
		
		return colleagues;
	}
	
	public void addContact(long contactId) throws SystemException {
		AddressBook addressBook = getAddressBook();
		AddressBookContact addressBookContact = new AddressBookContactImpl();
		addressBookContact.setAddressBookId(addressBook.getAddressBookId());
		addressBookContact.setCompanyId(getCompanyId());
		addressBookContact.setContactId(contactId);
		
		AddressBookContactLocalServiceUtil.addAddressBookContact(addressBookContact);
	}
}
