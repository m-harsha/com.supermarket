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
		excel.setExcelFile("Location Details","LocationInformations");
		String location=excel.getCellData(0, 0);
		String deliverycharge=excel.getCellData(0, 1);
		loginpage=new LoginPage(driver);
		loginpage.login();		
		managelocation=new ManageLocationPage(driver);
		managelocation.ManageLocationDetails(location,deliverycharge);
		managelocation.get_AlertMessageNotification();
		String actualresult=managelocation.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_LOCATIONALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}

	@Test
	public void verify_LocationStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();
		managelocation.deactivate_UserStatus("kerala");
		managelocation.get_StatusAlertMessageNotification();
		managelocation.statusAlertMessage_isDisplayed();
		String actualbackgroundcolor=managelocation.get_BackgroundcolorDeactivateAlert();
		String expectedbackgroundcolor=Constants.EXPECTEDBACKGROUNDCOLOR_DEACTIVATEALERT;
		Assert.assertEquals(actualbackgroundcolor, expectedbackgroundcolor);		
    }	
	
	@Test
	public void verify_DeleteLocationData() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();
		managelocation.delete_Location("kerala");
		managelocation.deleteAlertMessage_isDisplayed();
		String actualfontstyle=managelocation. get_FontStyleOfDeleteButton();
		String expectedfontstyle=Constants.EXPECTEDSTYLE_DELETEALERT;
		Assert.assertEquals(actualfontstyle, expectedfontstyle);
	}
	
	@Test
	public void verify_UpdateDetailsOfManageLocation() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();	
		managelocation.enter_StateDataUpdation("Street7");	
		managelocation.updateButton();
		managelocation.updatedAlertMessage_IsDisplayed();
		String actualcolor=managelocation.get_ColorOfUpdateButton();
		String expectedcolor=Constants.EXPECTEDCOLOR_UPDATEALERT;
		Assert.assertEquals(actualcolor, expectedcolor);		
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
		String actualbackgroundcolor=managelocation.get_BackgroundcolorOfSearchButton();
		String expectedbackgroundcolor=Constants.EXPECTEDBACKGROUNDCOLOR_SEARCH;
		Assert.assertEquals(actualbackgroundcolor, expectedbackgroundcolor);		
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
