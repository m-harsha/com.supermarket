package com.supermarket.tests;


import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ManageUsersPage manageuser;
	
	@Test
	public void verify_manageUserStatusDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.deactivate_UserStatus("Subina S");
    }
	
	@Test
	public void verify_manageUserActionDeactivation() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.deactivate_UserAction("rex lex");
	}
	
	@Test
	public void verify_DeletemanageUserAction() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuser=new ManageUsersPage(driver);
		manageuser.clickOnManageUsers();
		manageuser.delete_ManageUser("Riyanka M");
	}
	
}
