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
	
	@Test
	public void verify_PushNotificationFromExcel() {
		excel.setExcelFile("Push Notification","PushNotificationInformations");
		String title=excel.getCellData(0, 0);
		String description=excel.getCellData(0, 1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.get_SuccessAlertMessage(title,description);
		String actualresult=pushnotificationpage.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTEDALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
		
	
	@Test
	public void verify_PushNotification() {	
		HashMap<String, String> map=new HashMap<String,String>();	
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.get_SuccessAlertMessage("ab", "rt");
		pushnotificationpage.is_AlertMessageDisplayed();
		String actualcolor=pushnotificationpage.get_ColorOfAlert();
		String expectedcolor=Constants.EXPECTEDALERTCOLOR;
		Assert.assertEquals(actualcolor, expectedcolor);
		pdfreader=new PdfReader();
		map=pdfreader.readPdf_Data("pushnotificationdatas");
			
	}
	
	@Test(dataProvider="pushnotification",dataProviderClass=DataProviderClass.class)
	public void verify_PushNotificationDataByDataproviderclass(String data1,String data2) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_PushNotificationButton();
		pushnotificationpage.enter_TitleField(data1);
		pushnotificationpage.enter_DescriptionField(data2);
		pushnotificationpage.click_OnSend();	
		String actualcolor=pushnotificationpage.get_ColorOfSendButton();
		String expectedcolor=Constants.EXPECTEDCOLOR;
		Assert.assertEquals(actualcolor, expectedcolor);
		
			
	}
	
	
	
	
	

}
