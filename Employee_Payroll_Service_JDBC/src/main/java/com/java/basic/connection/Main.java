package com.java.basic.connection;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exceptionclass 
	{
		JDBC_Methods methods=new JDBC_Methods();
		
		String url="jdbc:mysql://localhost:3306/payroll_service_database";
		
		String result=methods.createConnection(url);
//		System.out.println(result);
		
		List<EmployeePayroll> resultList=methods.getemployeeData(url);
		for(EmployeePayroll employeePayroll : resultList)
		{
			System.out.println("Employee Id is : "+employeePayroll.getId()+" and Employee Name is : "+employeePayroll.getName()+" and Employee Basic Pay is : "+employeePayroll.getBasicPay()+" and Employee Start Date is : "+employeePayroll.getStartDate());
		}
	}

}