package com.leancrm.service.dao;

import java.util.List;

import com.leancrm.portlet.entity.ContactColleague;

public interface ContactsColleaguesDao {

	public List<ContactColleague> getContactsColleagues(long organization, long userId, int limit, int offset) throws Exception ;
}
