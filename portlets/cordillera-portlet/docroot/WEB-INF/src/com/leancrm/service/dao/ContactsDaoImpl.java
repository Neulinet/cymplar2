package com.leancrm.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leancrm.portlet.entity.Contact;
import com.leancrm.service.JdbcConnection;
import com.leancrm.service.SqlUtils;

public class ContactsDaoImpl implements ContactsDao {

	@Override
	public List<Contact> getContacts(long organizationId, long userId, int size, int pageNumber) throws Exception {
		List<Contact> contactList = new ArrayList<Contact>();
		
		int limit = size * 2;
		int offset = limit * (pageNumber-1);
		
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getConnection();
		try {
			String sql = SqlUtils.readQueryFile("/custom-sql/contacts.sql");
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, organizationId);
			statement.setLong(2, userId);
			statement.setLong(3, organizationId);
			statement.setLong(4, userId);
			statement.setLong(5, organizationId);
			statement.setLong(6, userId);
			statement.setLong(7, organizationId);
			statement.setLong(8, userId);
			statement.setLong(9, organizationId);
			statement.setLong(10, userId);
			statement.setLong(11, organizationId);
			statement.setLong(12, userId);
			statement.setLong(13, organizationId);
			statement.setLong(14, userId);
			statement.setLong(15, organizationId);
			statement.setLong(16, userId);
			statement.setLong(17, organizationId);
			statement.setLong(18, userId);
			statement.setLong(19, organizationId);
			statement.setLong(20, userId);
			statement.setLong(21, userId);
			statement.setInt(22, limit);
			statement.setInt(23, offset);
			
			ResultSet result = statement.executeQuery();
			
			Map<Long, Contact> temporaryResult = new HashMap<Long, Contact>();
			while (result.next()) {
				Long contactId = result.getLong( "contactId" );
				Contact c = temporaryResult.get(contactId);
				if (c == null) {
					c = new Contact();
					c.setContactId(contactId);
					temporaryResult.put(contactId, c);
				}
				Long methodId = result.getLong( "methodId" );
				if (methodId != null && methodId == 204) {
					c.setFullName( result.getString("contactName") );
				} else if (methodId == 205) {
					c.setEnterpriseName( result.getString("enterpriseName") );
					
					Long contractId = result.getLong("contractId");
					if (contractId != null && contractId > 0) {
						c.setContractDescription( result.getString("description") );
						c.setContractProgress( result.getString("progress") );
						c.setContractStatus( result.getString("status") );
					}
				}
			}

			contactList.addAll(temporaryResult.values());
			result.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			throw new Exception("Error while execute query", e);
		}
		return contactList;
	}

}
