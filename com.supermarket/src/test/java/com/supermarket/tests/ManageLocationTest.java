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
		managelocation.clickOnManageLocation();
		managelocation.clickOnNewButton();
		managelocation.enterTheCountry(1);
		managelocation.enterTheState(2);
		managelocation.ManageLocationDetails(location,deliverycharge);
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
		Assert.assertTrue(managelocation.deleteAlertMessage_isDisplayed());
	}
	
	@Test
	public void verify_UpdateFunctionalityOfLocation() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();	
		managelocation.enter_StateDataUpdation("Street7",5);	
		managelocation.updateButton();
		String actualcolor=managelocation.get_ColorOfUpdateAlertMessage();
		String expectedcolor=Constants.EXPECTEDCOLOR_UPDATEALERT;
		Assert.assertEquals(actualcolor, expectedcolor);		
	}
	
	@Test
	public void verify_Search_Location() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();	
		managelocation.clickSearchButton();
		managelocation.search_CategoriesOfManageLocation(1,2);
		managelocation.entersearchedLocation("tvm");
		managelocation.click_SearchButtonManageLocation();
		Assert.assertTrue(managelocation.is_DisplayedSearchedData());	
	}
	
	@Test
	public void verify_LocationInformationTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		managelocation=new ManageLocationPage(driver);
		managelocation.clickOnManageLocation();
		managelocation.clickOnNewButton();
		managelocation.enterTheCountry(1);
		managelocation.enterTheState(2);
		managelocation.ManageLocationDetails("kerala","75");
		String expectedresult=Constants.EXPECTED_ALERTTEXT;
		String actualresult=managelocation.get_AlertMessageNotification();
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
	}
	
}
