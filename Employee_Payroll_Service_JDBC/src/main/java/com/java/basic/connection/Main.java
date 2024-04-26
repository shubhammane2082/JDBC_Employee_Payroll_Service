package com.java.basic.connection;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exceptionclass 
	{
		JDBC_Methods methods=new JDBC_Methods();
		String username="root";
		String password="Root";
		String url="jdbc:mysql://localhost:3306/payroll_service_database";
		
		String result=methods.createConnection(url,username,password);
//		System.out.println(result);
		
		List<EmployeePayroll> resultList=methods.getemployeeData(url,username,password);
		for(EmployeePayroll employeePayroll : resultList)
		{
			System.out.println("Employee Id is : "+employeePayroll.getId()+" and Employee Name is : "+employeePayroll.getName()+" and Employee Basic Pay is : "+employeePayroll.getBasicPay()+" and Employee Start Date is : "+employeePayroll.getStartDate());
		}
		
		int salaryResult=methods.updateSalary(url,username,password);
		System.out.println(salaryResult);
	}

}