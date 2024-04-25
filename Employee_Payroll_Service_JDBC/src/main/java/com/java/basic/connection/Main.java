package com.java.basic.connection;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args)
	{
		JDBC_Methods methods=new JDBC_Methods();
		
		String url="jdbc:mysql://localhost:3306/payroll_service_database";
		
		String result=methods.createConnection(url);
		System.out.println(result);
		
	}

}
