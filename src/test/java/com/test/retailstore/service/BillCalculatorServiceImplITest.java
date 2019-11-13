package com.test.retailstore.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.test.retailstore.builder.BillingSystemBuilder;
import com.test.retailstore.model.Customer;
import com.test.retailstore.model.Item;


public class BillCalculatorServiceImplITest {
	
	private BillCalculatorService billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billCalculatorService = new BillCalculatorServiceImpl();
		items = BillingSystemBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillForDiscountEligibleCustomer() {
		Customer customer = BillingSystemBuilder.getCustomerWithMoreThan2YearOldRegistration();		
		Assert.assertEquals(892.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForNonEligibleCustomer() {
		Customer customer = BillingSystemBuilder.getCustomerWithLessThan2YearOldRegistration();		
		Assert.assertEquals(931.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = BillingSystemBuilder.getAffiliateCustomer();		
		Assert.assertEquals(857.00, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Customer employeeCustomer = BillingSystemBuilder.getEmployeeCustomer();		
		Assert.assertEquals(705.00, billCalculatorService.calculateTotalPayableAmount(employeeCustomer, items), 0);
	}
}
