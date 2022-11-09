package com.supermarket.base;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.Excel;

public class DataProviderClass {
	Excel excel;
	
	@DataProvider (name="PushNotificationExcelData")
	public  Object[][]  push_Notification() {
		excel=new Excel();
		excel.setExcelFile("Push Notification","PushNotificationInformations");
		return excel.getMultiDimensionalArray(3, 2);
			
	}
	
	
	@DataProvider (name="DeliveryBoy")
	public  Object[][]  details() {
		return new Object [][] {{"Ammu","ammu@gmail.com","986546753","werty","amu","sfge"},{"Nikila","niku@gmail.com","6789324509","niku","erh","rtyry"}};	
	}
	
	@DataProvider (name="ManageExpenseCategory")
	public  Object[][]  expensetitle() {
		return new Object [][] {{"orange"},{"apple1"}};	
	}
	
}
