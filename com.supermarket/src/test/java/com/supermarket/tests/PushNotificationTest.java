package com.supermarket.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	PdfReader pdfreader;
	
	@Test
	public void verify_PushNotification() {
		
		HashMap<String, String> map=new HashMap<String,String>();
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		String actualtext=pushnotificationpage.get_SuccessAlertMessage("ab", "rt");
		System.out.println(actualtext);
		
		pdfreader=new PdfReader();
		map=pdfreader.readPdf_Data("pushnotificationdatas");
			
	}
	
	@Test(dataProvider="pushnotification",dataProviderClass=DataProviderClass.class)
	public void create_pushNotificationDatabyDataproviderclass(String data1,String data2) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.enter_TitleField(data1);
		pushnotificationpage.enter_DescriptionField(data2);
		pushnotificationpage.click_OnSend();		
	}
	
	@Test
	public void verify_colorofSendButton() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		String actualcolor=pushnotificationpage.get_color_SendButton();
		System.out.println(actualcolor);
		String expectedcolor="rgba(255, 255, 255, 1)";
		Assert.assertEquals(actualcolor, expectedcolor);
	
	}
	

}
