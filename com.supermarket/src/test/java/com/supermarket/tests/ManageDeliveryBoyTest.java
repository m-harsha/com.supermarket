package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.utilities.Excel;

import com.supermarket.pages.LoginPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	Excel excel=new Excel();
	ManageDeliveryBoyPage deliveryboypage;
	
	@Test
	public void verify_Add_NewDeliveryBoy() {
		String name;
    	String email;
    	String phone;
    	String address;
		String userName;
		String password;
		excel.setExcelFile("Delivery Boy Details","DeliveryBoyInformations");
		name=excel.getCellData(0,0);
		email=excel.getCellData(0,1);
		phone=excel.getCellData(0,2);
		address=excel.getCellData(0,3);
		userName=excel.getCellData(0,4);
		password=excel.getCellData(0,5);
		
		loginpage=new LoginPage(driver);
		loginpage.login();	
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoy(name,email,phone,address,userName,password);
		System.out.println(deliveryboypage.get_DangerAlertMessageNotification());
		Assert.assertTrue(deliveryboypage.alertMessage_isDisplayed());
	}
	
	@Test
	public void verify_DeliveryBoyTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoy("Ami","ami@gmail.com","897565634","erty2y","ana","wet87");
		String expectedresult=Constants.EXPECTED_ALERT_TEXT1;
		String actualresult=deliveryboypage.get_DangerAlertMessageNotification();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
     }
	
	@Test
	public void verify_DeliveryBoyStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		deliveryboypage.deactivate_UserStatus("name");
		System.out.println(deliveryboypage.get_AlertMessageNotification());
		Assert.assertTrue(deliveryboypage.is_DeactivateActionAlertMessageDisplayed());		
    }	
	
	@Test
	public void verify_DeleteDeliveryBoyAction() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		deliveryboypage.delete_DeliveryBoy("Aimy");
		Assert.assertTrue(deliveryboypage.deleteAlertMessage_isDisplayed());
    }
	
	@Test
	public void verify_BackGroundColorOfNewButton() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		String actualbackgroundcolor=deliveryboypage.get_Backgroundcolor_NewButton();
		System.out.println(actualbackgroundcolor);
		String expectedbackgroundcolor="rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualbackgroundcolor, expectedbackgroundcolor);
	}
	
	@Test(dataProvider="DeliveryBoy",dataProviderClass=DataProviderClass.class)
	public void create_DeliveryBoyDetailsByDataproviderclass(String data1,String data2,String data3,String data4,String data5,String data6) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		deliveryboypage.clickOnNewButton();
		deliveryboypage.enterName(data1);
		deliveryboypage.enterEmail(data2);
		deliveryboypage.enterPhoneNumber(data3);
		deliveryboypage.enterAddress(data4);
		deliveryboypage.enterUserName(data5);
		deliveryboypage.enterPassword(data6);
		deliveryboypage.click_SaveButton();	
		Assert.assertTrue(deliveryboypage.is_SaveButtonDisplayed());
		
    }
	
	
}


	

