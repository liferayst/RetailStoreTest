package com.test.retailstore.service;


import java.util.List;

import com.test.retailstore.model.Customer;
import com.test.retailstore.model.Item;

public interface BillCalculatorService {
	
	double calculateTotalPayableAmount(Customer customer, List<Item> items);

}
