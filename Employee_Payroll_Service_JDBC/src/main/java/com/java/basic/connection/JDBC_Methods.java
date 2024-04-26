package com.java.basic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

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
		try 
		{
			Connection connection=DriverManager.getConnection(url, username, password);
			String query="UPDATE payroll_service_database.employee_payroll \r\n"
					+ "SET basicPay = ? \r\n"
					+ "WHERE id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, 49000);
			preparedStatement.setInt(2, 3);
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			connection.close();
			preparedStatement.close();
			
			return executeUpdate;
		} 
		catch (SQLException e) 
		{
			throw new Exceptionclass("Salary Not updated in Database...");
		}
	}

	public List<EmployeePayroll> retrieveInfoDaterange(String url, String username, String password) throws Exceptionclass
	{
		List<EmployeePayroll> employeePayrolllist=new ArrayList<EmployeePayroll>();	
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query="SELECT * FROM payroll_service_database.employee_payroll where startDate between '2000-09-20' and '2020-10-22'";
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				double basicpay=resultSet.getDouble("basicPay");
				LocalDate startDate=resultSet.getDate("startDate").toLocalDate();
				
				EmployeePayroll employeePayroll=new EmployeePayroll(id, name, basicpay, startDate);
				employeePayrolllist.add(employeePayroll);
			}
			
		} catch (SQLException e) {

			throw new Exceptionclass("There is no any Employee within given joining...");
		}
		return employeePayrolllist;
	}

	public double Aggerateoperation(String url, String username, String password) throws Exceptionclass {
		
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query="select sum(basicPay) from employee_payroll where gender='Male' group by gender";
			ResultSet resultSet = statement.executeQuery(query);
			double sum = 0;
			
			while(resultSet.next())
			 {
				sum=resultSet.getDouble(1); 
			 }
			 connection.close();
			 statement.close();
			 
			return sum;
		} catch (SQLException e) {
			throw new Exceptionclass("Not able calculate value of function...");
		}
		
	}
}
