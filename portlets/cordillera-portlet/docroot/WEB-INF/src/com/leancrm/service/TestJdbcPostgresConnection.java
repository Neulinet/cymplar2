package com.leancrm.service;

import com.leancrm.service.dao.JdbcTestDao;
import com.leancrm.service.dao.TestDao;

public class TestJdbcPostgresConnection {

	public static void main(String[] args) {
		TestDao test = new JdbcTestDao();
		test.getTest();
	}
}
