package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.Excel;

public class ManageExpenseTest extends Base {
	LoginPage loginpage;
	Excel excel=new Excel();
	ManageExpensePage manageexpensepage;
	
	@Test(priority=1)
	public void verify_EnterNewExpenseInformations() {
		excel.setExcelFile("ManageExpenses","ManageExpenseInformations");
		String amount=excel.getCellData(0,0);
		String remarks=excel.getCellData(0,1);
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnNewExpense();
		manageexpensepage.clickOnUserType(2);
		manageexpensepage.clickOnCategory(2);
		manageexpensepage.clickOnOrderId(3);
		manageexpensepage.clickOnPurchaseId(3);
		manageexpensepage.clickOnExpenseType(4);
		manageexpensepage.enterAmount(amount);
		manageexpensepage.enterRemarks(remarks);
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		String actualresult=manageexpensepage.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_EXPENSEALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
			
	@Test(priority=2)
	public void verify_CreateExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnNewExpense();
		manageexpensepage.clickOnUserType(2);
		manageexpensepage.clickOnCategory(2);
		manageexpensepage.clickOnOrderId(3);
		manageexpensepage.clickOnPurchaseId(3);
		manageexpensepage.clickOnExpenseType(4);
		manageexpensepage.enterAmount("2000");
		manageexpensepage.enterRemarks("Amount is paid");
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		String actualcolor=manageexpensepage.get_BackgroundColorOfAlertMessage();
		String expectedcolor=Constants.EXPECTED_BACKGROUNDCOLOR_ALERT;
		Assert.assertEquals(actualcolor, expectedcolor);		
	}
	
	@Test(priority=3)
	public void verify_UpdateFunctionalityOfExpenseData() {
		loginpage=new LoginPage(driver);
		SoftAssert softassert=new SoftAssert();
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.edit_ExpenseData("Order -403(-DB)");
		manageexpensepage.enter_OrderIdDataUpdation(9);
		manageexpensepage.updateButton();
		String actualresult=manageexpensepage.visibilityOfUpdatedAlertNotification();
		String expectedresult=Constants.EXPECTED_UPDATEALERT;
		softassert.assertEquals(actualresult,expectedresult);
	}
	
	@Test(priority=4)
	public void verify_DeleteExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.delete_DataExpense("IceCreams (Sumesh-PT)");
		manageexpensepage.clickSearchButton();
		manageexpensepage.search_EnterTitle("IceCreams (Sumesh-PT)");
		manageexpensepage.click_SearchButtonManageExpense();
		manageexpensepage.click_ReportButtonManageExpense();
		String actualtext=manageexpensepage. get_ReportOfDeletedData();
		String expectedtext=Constants.EXPECTED_DATAREPORT;
		Assert.assertEquals(actualtext, expectedtext);
	}
	
	@Test(priority=5)
	public void verify_Search_ExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.clickSearchButton();
		manageexpensepage.search_EnterTitle("FruitNew (Staff-ST)");
		manageexpensepage.click_SearchButtonManageExpense();
		manageexpensepage.click_ReportButtonManageExpense();
		String actualtext=manageexpensepage.get_TextOfSearchedData();
		String expectedtext=Constants.EXPECTED_EXPENSEREPORT;
		Assert.assertEquals(actualtext, expectedtext);
	}	

}
