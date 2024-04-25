package com.java.basic.test.connection;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.basic.connection.JDBC_Methods;

public class Testcase {

	@Test
	public void createconnectionTestCase() {
		JDBC_Methods methods=new JDBC_Methods();
		String url="jdbc:mysql://localhost:3306/payroll_service_database";
		String result=methods.createConnection(url);
		String expectedResult="Connection sucessfully...";
		
		assertEquals(expectedResult, result);
	}

}
