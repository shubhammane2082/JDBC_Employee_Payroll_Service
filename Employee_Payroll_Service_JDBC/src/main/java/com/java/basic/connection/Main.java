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
//		for(EmployeePayroll employeePayroll : resultList)
//		{
//			System.out.println("Employee Id is : "+employeePayroll.getId()+" and Employee Name is : "+employeePayroll.getName()+" and Employee Basic Pay is : "+employeePayroll.getBasicPay()+" and Employee Start Date is : "+employeePayroll.getStartDate());
//		}
		int salaryResult=methods.updateSalary(url,username,password);
		
//		List<EmployeePayroll> listResult = methods.retrieveInfoDaterange(url,username,password);
//		
//		System.out.println("Employee Who Joins Date range Between '2000-09-20' and '2020-10-22' are :");
//		System.out.println("----------------------------------------------------------------");
//		
//		for(EmployeePayroll employeePayroll : listResult)
//		{
//			System.out.println("\nId is : "+employeePayroll.getId()+"\n"+"Name is : "+employeePayroll.getName()+"\n"+"Basic Pay is : "+employeePayroll.getBasicPay()+"\n"+"Start Date is : "+employeePayroll.getStartDate()+"\n-------------------------------------------------");
//		}
		
		double result1 = methods.Aggerateoperation(url,username,password);
		System.out.println("sum of salary for gender male is : "+result1);
		
	}

}