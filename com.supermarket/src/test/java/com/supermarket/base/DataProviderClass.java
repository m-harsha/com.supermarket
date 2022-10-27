package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider (name="pushnotification")
	public  Object[][]  supermarket() {
		return new Object [][] {{"abc","erty"},{"erh","rtyry"}};	
	}
	
	@DataProvider (name="DeliveryBoy")
	public  Object[][]  details() {
		return new Object [][] {{"Ammu","ammu@gmail.com","986546753","werty","amu","sfge"},{"Nikila","niku@gmail.com","6789324509","niku","erh","rtyry"}};	
	}
	
	
}
