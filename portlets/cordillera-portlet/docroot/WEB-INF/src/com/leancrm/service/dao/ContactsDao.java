package com.leancrm.service.dao;

import java.util.List;

import com.leancrm.portlet.entity.Contact;

public interface ContactsDao {

	public List<Contact> getContacts(long organizationId, long userId, int limit, int offset) throws Exception;
}
