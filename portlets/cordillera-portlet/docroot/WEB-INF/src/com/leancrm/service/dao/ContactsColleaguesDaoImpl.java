package com.leancrm.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.entity.ContactColleague;
import com.leancrm.service.JdbcConnection;
import com.leancrm.service.SqlUtils;

public class ContactsColleaguesDaoImpl implements ContactsColleaguesDao {

	@Override
	public List<ContactColleague> getContactsColleagues(long organizationId, long userId, int size, int pageNumber) throws Exception {
		List<ContactColleague> contacts = new ArrayList<ContactColleague>();
		
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getConnection();
		try {
			int limit = size * 2;
			int offset = limit * (pageNumber-1);
			
			String sql = SqlUtils.readQueryFile("/custom-sql/contactsColleagues.sql");
			
//			String sql2 = "select "
//					+ " c.contactid, u.emailAddress, cd.contactdataid, cd.contactdatamethodid as methodId, cdt.value as contactName, e.name as enterpriseName"
//					+ " from crm_addressbookcontact abc "
//					+ " join crm_contact c on abc.contactid=c.contactid "
//					+ " join crm_addressbookuser abu on abc.addressbookid=abu.addressbookid "
//					+ " join user_ u on abu.userId=u.userId "
//					+ " join crm_contactdata cd on c.contactid=cd.contactid "
//					+ " left join crm_contactdatatext cdt on cd.contactdataid=cdt.contactdataid "
//					+ " left join crm_contactdataref cdr on cd.contactdataid=cdr.contactdataid "
//					+ " left join crm_enterprise e on cdr.refValue=e.enterpriseId "
//					+ " where abc.addressbookid in ("
//					+ " select addressbookid from crm_addressbookuser abu join users_orgs uo on abu.userid=uo.userid where uo.organizationid = ? and uo.userid != ?"
//					+ " ) and cd.contactdatamethodid in (204,205) limit ? offset ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, organizationId);
			statement.setLong(2, userId);
			statement.setLong(3, limit);
			statement.setLong(4, offset);
			ResultSet result = statement.executeQuery();
			
			Map<Long, ContactColleague> temporaryResult = new HashMap<Long, ContactColleague>();
			while (result.next()) {
				Long contactId = result.getLong( "contactId" );
				ContactColleague c = temporaryResult.get(contactId);
				if (c == null) {
					c = new ContactColleague();
					temporaryResult.put(contactId, c);
				}
				Long methodId = result.getLong( "methodId" );
				if (methodId != null && methodId == 204) {
					c.setContactName( result.getString("contactName") );
				} else if (methodId == 205) {
					c.setEnterpriseName( result.getString("enterpriseName") );
				}
				c.setOwnerEmail( result.getString("emailaddress") );
				c.setHasOwner(c.getOwnerEmail() != null && !c.getOwnerEmail().trim().isEmpty());
			}

			contacts.addAll(temporaryResult.values());
			result.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			throw new Exception("Error while execute query", e);
		}
		return contacts;
	}

	
}
