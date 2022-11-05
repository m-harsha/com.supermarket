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
	public void verify_UpdatedDetailsOfDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageorder=new ManageOrderPage(driver);
		manageorder.selectDeliveryBoy("406");
		manageorder.click_UpdateButton();
		String actualcolor=manageorder.get_ColorOfAssignDeliveryBoy();	
		String expectedcolor=Constants.EXPECTEDCOLOR_ASSIGNDELIVERYBOY;
		Assert.assertEquals(actualcolor, expectedcolor);
    }

	@Test
	public void verify_OrderIdViewList() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageorder=new ManageOrderPage(driver);
		manageorder.click_ManageOrder();
		manageorder.viewListData("406");
		manageorder.click_BackButton();
		String actualtext=manageorder.get_TextOfListOrder();
		String expectedtext=Constants.EXPECTED_TEXT_LIST;
		Assert.assertEquals(actualtext, expectedtext);
    
		
	}
}
	
	


