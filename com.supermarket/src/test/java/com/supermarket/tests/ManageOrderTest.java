package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrderPage;

public class ManageOrderTest extends Base {
	LoginPage loginpage;
	ManageOrderPage manageorder;
	
	@Test
	public void verify_UpdateFunctionalityOfDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageorder=new ManageOrderPage(driver);
		manageorder.selectDeliveryBoy("403",4);
		manageorder.click_UpdateButton();
		String actualcolor=manageorder.get_ColorOfAlertMessage();	
		String expectedcolor=Constants.EXPECTEDCOLOR_ASSIGNDELIVERYBOYALERT;
		Assert.assertEquals(actualcolor, expectedcolor);
    }

	@Test
	public void verify_OrderedDetailsViewList() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageorder=new ManageOrderPage(driver);
		manageorder.click_ManageOrder();
		manageorder.viewListData("403");
		String actualtext=manageorder.get_TextOfOrderDetails();
		String expectedtext=Constants.EXPECTED_TEXT_ORDER;
		Assert.assertEquals(actualtext, expectedtext);	
	}
}
	
	


