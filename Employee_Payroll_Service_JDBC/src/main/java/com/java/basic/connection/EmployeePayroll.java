package com.java.basic.connection;

import java.time.LocalDate;

public class EmployeePayroll 
	{
		int id;
		String name;
		double basicPay;
		LocalDate startDate;
		
		public EmployeePayroll(int id, String name, double basicPay, LocalDate startDate) {
			super();
			this.id = id;
			this.name = name;
			this.basicPay = basicPay;
			this.startDate = startDate;
		}

		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}

		public double getBasicPay() {
			return basicPay;
		}


		public LocalDate getStartDate() {
			return startDate;
		}	
}
