package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrderPage;

public class ManageOrderTest  extends Base {
	LoginPage loginpage;
	ManageOrderPage manageorder;
	
	@Test
	public void verify_UpdationOfDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageorder=new ManageOrderPage(driver);
		manageorder.selectDeliveryBoy();
		manageorder.click_UpdateButton();
		Assert.assertTrue(manageorder.alertMessage_IsDisplayed());
		
		
	}
	

}
