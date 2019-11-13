package com.test.retailstore.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.test.retailstore.model.Customer;
import com.test.retailstore.model.CustomerType;
import com.test.retailstore.model.Item;
import com.test.retailstore.model.Product;

public class BillingSystemBuilder {
	
	private static final int CUST_LOYALTY_TIME_PERIOD_YRS = -2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("TT123456");
		product.setName("TaherTinwala");
		product.setDiscountable(true);
		product.setPrice(78.91);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("SB123456");
		product.setName("SakinaBootwala");
		product.setDiscountable(false);
		product.setPrice(37.45);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		
		Customer customer = new Customer(CustomerType.AFFILIATE, "testCust001", "Goods Affiliate", getDate(3));
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, "testCust002", "Muhammad", getDate(3));
		return customer;
	}
	
	public static Customer getCustomerWithMoreThan2YearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "testCust003", "Rafiq", getDate(CUST_LOYALTY_TIME_PERIOD_YRS-1));
		return customer;
	}
	
	public static Customer getCustomerWithLessThan2YearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "testCust004", "Taariq", getDate(CUST_LOYALTY_TIME_PERIOD_YRS+1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
	
	private static Date getDate(int year) {
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}
}
