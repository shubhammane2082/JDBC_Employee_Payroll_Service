package com.java.basic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Methods {

	public String createConnection(String url, String username, String password) 
	{
		try 
		{	
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			connection.close();
			return "Connection sucessfully...";
		} 
		catch (Exception e) 
		{
			return "Connection Not sucessfully...";
		}
	}
	
	public List<EmployeePayroll> getemployeeData(String url, String username, String password) throws Exceptionclass {
	List<EmployeePayroll> employeePayrolllist=new ArrayList<EmployeePayroll>();
	
		try 
		{
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query="select * from employee_payroll";
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				double basicPay=resultSet.getDouble(3);
				LocalDate startDate=resultSet.getDate(4).toLocalDate();
				
				EmployeePayroll employeePayroll=new EmployeePayroll(id, name, basicPay, startDate);
				employeePayrolllist.add(employeePayroll);
			}
		} 
		catch (SQLException e) 
		{
			throw new Exceptionclass("There is no Any Data in database...");
		}
		
		return employeePayrolllist;
	}

	public int updateSalary(String url, String username, String password) throws Exceptionclass 
	{
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query="UPDATE payroll_service_database.employee_payroll \r\n"
					+ "SET basicPay = 35000 \r\n"
					+ "WHERE id = 2";
			
			int executeUpdate = statement.executeUpdate(query);
			return executeUpdate;
			
		} catch (SQLException e) {
			throw new Exceptionclass("Data Not updated in Database...");
		}
	}
}
