package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {
	LoginPage loginpage;
	ManageProductPage manageproduct;
	
	@Test
	public void verify_Add_NewProductDetails() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageproduct=new ManageProductPage(driver);
		manageproduct.enterProductDetails("Milk","rty","20","5","30","25","10","25","fresh milk");
		manageproduct.imageUpload(Constants.IMAGE_UPLOAD +"\\image1.jpeg");
		manageproduct.clickOnSaveButton();
		Assert.assertTrue(manageproduct.alertMessage_IsDisplayed());
		
	}
	

}
