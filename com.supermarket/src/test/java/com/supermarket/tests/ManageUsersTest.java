package com.supermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ManageUsersPage manageuser;
	
	@Test
	public void verify_ManageUserStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.deactivate_UserStatus("Subina S");
		Assert.assertTrue(manageuser.is_DeactivateActionAlertMessageDisplayed());		
    }
	
	@Test
	public void verify_UserActionDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.deactivate_UserAction("jothish thachamoochikkal");
		Assert.assertTrue(manageuser.is_DeactivateActionAlertMessageDisplayed());	
	}
	
	@Test
	public void verify_DeleteUserData() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.delete_ManageUser("Riyanka M");
		Assert.assertTrue(manageuser.is_DeleteAlertMessageDisplayed());	
	}
	
}
