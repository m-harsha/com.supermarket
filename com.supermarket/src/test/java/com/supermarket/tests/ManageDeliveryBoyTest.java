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
		excel.setExcelFile("Delivery Boy Details","DeliveryBoyInformations");
		String name=excel.getCellData(0,0);
		String email=excel.getCellData(0,1);
		String phone=excel.getCellData(0,2);
		String address=excel.getCellData(0,3);
		String userName=excel.getCellData(0,4);
		String password=excel.getCellData(0,5);	
		loginpage=new LoginPage(driver);
		loginpage.login();	
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoy(name,email,phone,address,userName,password);
		String actualresult=deliveryboypage.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_ALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
			
	
	@Test(groups= {"smoke","sanity"})
	public void verify_DeliveryBoyStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		deliveryboypage.deactivate_UserStatus("name");
		String actualresult=deliveryboypage.visibilityOfDeactivateAlertNotification();
		String expectedresult=Constants.EXPECTED_DEACTIVATEALERT;
		Assert.assertEquals(actualresult,expectedresult);
			
    }	
	
	@Test
	public void verify_DeleteDeliveryBoyData() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.clickOnDeliveryBoy();
		deliveryboypage.delete_DeliveryBoy("Aimy");
		String actualresult=deliveryboypage.visibilityOfDeleteAlertNotification();
		String expectedresult=Constants.EXPECTED_DELETEALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
			
		
	@Test(dataProvider="DeliveryBoy",dataProviderClass=DataProviderClass.class)
	public void verify_DeliveryBoyDetailsByDataproviderclass(String data1,String data2,String data3,String data4,String data5,String data6) {
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
		String actualcolor=deliveryboypage.get_ColorOfSaveButton();
		String expectedcolor=Constants.EXPECTEDCOLOR_SAVEBUTTON;
		Assert.assertEquals(actualcolor,expectedcolor);
    }
	
	@Test
	public void verify_DeliveryBoyTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		deliveryboypage=new ManageDeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoy("Ami","ami@gmail.com","897565634","erty2y","ana","wet87");
		String expectedresult=Constants.EXPECTED_ALERT_TEXT1;
		String actualresult=deliveryboypage.get_AlertMessageNotification();
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
     }
	
	
}


	

