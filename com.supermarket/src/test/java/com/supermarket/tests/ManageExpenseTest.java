package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.Excel;

public class ManageExpenseTest extends Base {
	LoginPage loginpage;
	Excel excel=new Excel();
	ManageExpensePage manageexpensepage;
	
	@Test
	public void verify_EnterNewExpenseInformations() {
		excel.setExcelFile("ManageExpenses","ManageExpenseInformations");
		String amount=excel.getCellData(0,0);
		String remarks=excel.getCellData(0,1);
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.enter_PageInformations(amount, remarks);
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		String actualresult=manageexpensepage.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_EXPENSEALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
		
	
	@Test
	public void verify_ManageExpenseFunctionalities() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.enter_PageInformations("2000", "Amount is paid");
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		String actualcolor=manageexpensepage.get_ColorOfSaveButton();
		String expectedcolor=Constants.EXPECTEDCOLOR_SAVE_EXPENSE;
		Assert.assertEquals(actualcolor, expectedcolor);		
	}
	
	@Test
	public void verify_UpdateDetailsOfManageExpense() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.edit_ExpenseData("Icecream_21_09_2022_01_20 (232-ST)");
		manageexpensepage.enter_OrderIdDataUpdation();
		manageexpensepage.updateButton();
		String actualresult=manageexpensepage.visibilityOfUpdatedAlertNotification();
		String expectedresult=Constants.EXPECTED_UPDATEALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
	
	@Test
	public void verify_DeleteManageExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.delete_DataExpense("Order -406(Nyahgr-DB)");
		manageexpensepage.deleteAlertMessage_isDisplayed();
		String actualfontstyle=manageexpensepage. get_FontStyleOfDeleteButton();
		String expectedfontstyle=Constants.EXPECTEDSTYLE_DELETE_EXPENSE;
		Assert.assertEquals(actualfontstyle, expectedfontstyle);
	}
	
	@Test
	public void verify_SearchedDataOfManageExpense() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.clickSearchButton();
		manageexpensepage.search_EnterTitle("FruitNew (Staff-ST)");
		manageexpensepage.search_CategoriesOfManageExpense();
		manageexpensepage.click_SearchButtonManageExpense();
		manageexpensepage.click_ReportButtonManageExpense();
		manageexpensepage.click_BackButton();
		String actualtext=manageexpensepage.get_TextListExpense();
		String expectedtext=Constants.EXPECTED_EXPENSETEXT;
		Assert.assertEquals(actualtext, expectedtext);
	}
		
		
		
	

}
