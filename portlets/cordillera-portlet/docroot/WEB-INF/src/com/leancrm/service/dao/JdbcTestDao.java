package com.leancrm.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.leancrm.service.JdbcConnection;

public class JdbcTestDao implements TestDao {

	@Override
	public Object getTest() {
		
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getConnection();
		try {
			String sql = "select * from crm_contact";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				System.out.println( result.getLong("contactid") );
				System.out.println( result.getLong("groupid") );
				System.out.println( result.getLong("companyid") );
				System.out.println( result.getDate("createdate") );
				System.out.println( result.getDate("modifieddate") );
			}
			
			result.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
