package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	
	@Test
	public void verify_Login() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}
	
	@Test
	public void verify_InvalidLogin_AlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login("admin","admin1");
		loginpage.get_AlertMessageNotification();
		String expectedresult=Constants.EXPECTED_ALERT_TEXT;
		String actualresult=loginpage.get_AlertMessageNotification();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");		
	}
	
	@Test
	public void verify_RememeberMeCheckBox() {
		loginpage=new LoginPage(driver);
		loginpage.click_OnRememberMeCheckBox();
		Assert.assertTrue(loginpage.is_RememeberMeSelected());
	}
	
}
