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
	public void verify_add_NewAdminUsers() {
		String userName;
		String password;
		excel.setExcelFile("Admin Users Details","AdminUsersInformations");
		userName=excel.getCellData(0, 0);
		password=excel.getCellData(0, 1);
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUsersDetails(userName,password);
		System.out.println(adminuserspage.get_DangerAlertMessageNotification());
		Assert.assertTrue(adminuserspage.AlertMessage_isDisplayed());
	}
	
	@Test
	public void verify_LocationInformationTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUsersDetails("ani", "ani345");
		String expectedresult=Constants.EXPECTED_ALERTTEXT3;
		String actualresult=adminuserspage.get_DangerAlertMessageNotification();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
	}
 
}
