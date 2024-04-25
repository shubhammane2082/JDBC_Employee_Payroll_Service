package com.java.basic.test.connection;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.java.basic.connection.EmployeePayroll;
import com.java.basic.connection.Exceptionclass;
import com.java.basic.connection.JDBC_Methods;

public class Testcase 
{
	JDBC_Methods methods;
	String url="jdbc:mysql://localhost:3306/payroll_service_database";
	
	public Testcase()
	{
		methods=new JDBC_Methods();
	}
	@Test
	public void createconnectionTestCase() {
		String result=methods.createConnection(url);
		String expectedResult="Connection sucessfully...";
		
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void getemployeeDataTestcase() throws Exceptionclass
	{
		List<EmployeePayroll> employeelist = methods.getemployeeData(url);
		
		EmployeePayroll employeePayroll=employeelist.get(0);
		
		assertEquals(1, employeePayroll.getId());
		assertEquals("Suraj", employeePayroll.getName());
		assertEquals(10000, employeePayroll.getBasicPay(),0.01);
		assertEquals("2000-09-20", employeePayroll.getStartDate().toString());
		
	}

}
