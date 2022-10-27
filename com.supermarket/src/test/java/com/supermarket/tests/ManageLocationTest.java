package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;
import com.supermarket.utilities.Excel;

public class ManageLocationTest extends Base {
	Excel excel=new Excel();
	LoginPage loginpage;
	ManageLocationPage managelocation;
	
	@Test
	public void verify_add_NewLocationInformations() {
		String location;
		String deliverycharge;
		excel.setExcelFile("Location Details","LocationInformations");
		location=excel.getCellData(0, 0);
		deliverycharge=excel.getCellData(0, 1);
		
		loginpage=new LoginPage(driver);
		loginpage.login();		
		managelocation=new ManageLocationPage(driver);
		managelocation.ManageLocationDetails(location,deliverycharge);
		System.out.println(managelocation.get_AlertMessageNotification());
		Assert.assertTrue(managelocation.AlertMessage_isDisplayed());	
	}
	
	@Test
	public void verify_LocationInformationTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		managelocation=new ManageLocationPage(driver);
		managelocation.ManageLocationDetails("kerala","75");
		String expectedresult=Constants.EXPECTED_ALERTTEXT;
		String actualresult=managelocation.get_AlertMessageNotification();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
	}
	
	
}
