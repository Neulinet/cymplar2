package com.leancrm.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.leancrm.service.dao.ContactsColleaguesDaoImpl;

public class SqlUtils {

	public static String readQueryFile(String resourcePath) throws Exception {
		StringBuilder query = new StringBuilder();
		try {
			InputStream is = ContactsColleaguesDaoImpl.class.getResourceAsStream(resourcePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				query.append(line);
				query.append('\n');
			}
		} catch (IOException e) {
			throw new Exception("Could not read Bureau Reporting Query file.", e);
		}
		return query.toString();
	}
	
}
