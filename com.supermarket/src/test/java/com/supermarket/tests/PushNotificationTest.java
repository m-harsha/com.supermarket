package com.supermarket.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	PdfReader pdfreader;
	Excel excel=new Excel();
	
	@Test(dataProvider="PushNotificationExcelData",dataProviderClass=DataProviderClass.class)
	public void verify_PushNotificationByDataproviderclass(String message,String des) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.enter_TitleField(message);
		pushnotificationpage.enter_DescriptionField(des);
		pushnotificationpage.click_OnSend();	
		String actualcolor=pushnotificationpage.get_BackgroundColorOfAlert();
		String expectedcolor=Constants.EXPECTED_BACKGROUNDCOLORALERT;
		Assert.assertEquals(actualcolor, expectedcolor);			
	}
	
	@Test
	public void verify_PushNotificationData() {	
		HashMap<String, String> map=new HashMap<String,String>();	
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pdfreader=new PdfReader();
		map=pdfreader.readPdf_Data("pushnotificationdatas");
		String notificationTitle=map.get("title 1");
		String notificationDescription=map.get("description 1");
		pushnotificationpage.get_SuccessAlertMessage(notificationTitle,notificationDescription);
		String actualcolor=pushnotificationpage.get_ColorOfAlert();
		String expectedcolor=Constants.EXPECTEDCOLOR;
		Assert.assertEquals(actualcolor, expectedcolor);			
	}	
	
	@Test
	public void verify_EnterPushNotificationData() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.enter_PushNotificationData("data","data entered");
		pushnotificationpage.click_OnSend();
		Assert.assertTrue(pushnotificationpage.is_AlertMessageDisplayed());		
	}

}
