package com.test.retailstore.model;

import java.util.Calendar;
import java.util.Date;

public class Customer {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = -2;
	
	private CustomerType customerType;
	
	private String customerID;
	
	private String customerName;
	
	private Date registrationDate;
	
	public Customer(CustomerType customerType, String customerID, String customerName, Date registrationDate) {
		super();
		this.customerType = customerType;
		this.customerID = customerID;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public boolean isAvailableForLoyaltyDiscount() {
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.YEAR, CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS); 
		Date dateToCompare = cal.getTime();		
		return registrationDate.before(dateToCompare) && (CustomerType.CUSTOMER == customerType);
	}
}
