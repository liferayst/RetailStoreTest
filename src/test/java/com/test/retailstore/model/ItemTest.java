package com.test.retailstore.model;

import org.junit.Assert;
import org.junit.Test;

import com.test.retailstore.builder.BillingSystemBuilder;

public class ItemTest {
	
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = BillingSystemBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);		
		Assert.assertEquals(149.8, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);		
		Assert.assertEquals(299.858, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);		
		Assert.assertEquals(315.64, item.getDiscountedPrice(0), 0);
		
	}

}
