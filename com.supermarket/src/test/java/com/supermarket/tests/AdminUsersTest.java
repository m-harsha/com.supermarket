package com.supermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.Excel;

public class AdminUsersTest extends Base {
	Excel excel=new Excel();
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	
	@Test
	public void verify_CreateNewAdminUsers() {
		excel.setExcelFile("Admin Users Details","AdminUsersInformations");
		String userName=excel.getCellData(0, 0);
		String password=excel.getCellData(0, 1);	
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUsersDetails(userName,password);
		adminuserspage.enterUserType(2);
		adminuserspage.clickOnSaveButton();
		String actualresult=adminuserspage.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_ADMINALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}		
	
	@Test
	public void verify_AdminUserStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsers();
		adminuserspage.deactivate_UserAction("terry@20");
		adminuserspage.statusAlertMessage_isDisplayed();
		String actualcolor=adminuserspage.get_BackgroundColorOfAlertMessage();
		String expectedcolor=Constants.EXPECTEDBACKGROUNDCOLOR_ALERT;
		Assert.assertEquals(actualcolor,expectedcolor);
	}
	
	@Test
	public void verify_CreateAdminUserData_LogOutLogIn() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUsersDetails("binn","binn12");
		adminuserspage.enterUserType(2);
		adminuserspage.clickOnSaveButton();
		adminuserspage.clickOnLogout();
		loginpage.login("binn","binn12");
		Assert.assertTrue(adminuserspage.is_ProfileNameDisplayed());
	}
		
	@Test
	public void verify_AdminUsersTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUsersDetails("ani", "ani345");
		adminuserspage.enterUserType(2);
		adminuserspage.clickOnSaveButton();
		String expectedresult=Constants.EXPECTED_ALERTTEXT3;
		String actualresult=adminuserspage.get_AlertMessageNotification();
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
	}
	
 
}
