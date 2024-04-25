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

	public String createConnection(String url) 
	{
		String username="root";
		String password="Root";
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
}
