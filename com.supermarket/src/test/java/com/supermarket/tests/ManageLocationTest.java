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
	public void verify_Add_NewLocationInformations() {
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
		Assert.assertTrue(managelocation.alertMessage_isDisplayed());	
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
	@Test
	public void verify_LocationStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();
		managelocation.deactivate_UserStatus("lkj");
		System.out.println(managelocation.get_StatusAlertMessageNotification());
		Assert.assertTrue(managelocation.statusAlertMessage_isDisplayed());		
    }	
	@Test
	public void verify_DeleteLocationAction() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();
		managelocation.delete_Location("kerala");
		Assert.assertTrue(managelocation.deleteAlertMessage_isDisplayed());
    }
	@Test
	public void verify_UpdateDetailsOfManageLocation() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();	
		managelocation.enter_StateDataUpdation();	
		managelocation.updateButton();
		Assert.assertTrue(managelocation.updatedAlertMessage_IsDisplayed());
	}
	@Test
	public void verify_SearchedDataOfManageLocation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();	
		managelocation.clickSearchButton();
		managelocation.search_CategoriesOfManageLocation();
		managelocation.entersearchedLocation("tvm");
		managelocation.click_SearchButtonManageLocation();
		Assert.assertFalse(managelocation.searchButtonManageLocationIsSelected());	
	}
	
}
