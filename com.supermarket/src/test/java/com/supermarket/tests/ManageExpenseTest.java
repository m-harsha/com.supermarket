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
		String amount;
		String remarks;
		excel.setExcelFile("ManageExpenses","ManageExpenseInformations");
		amount=excel.getCellData(0,0);
		remarks=excel.getCellData(0,1);
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.enter_PageInformations(amount, remarks);
		manageexpensepage.FileUpload(Constants.USERFILE_UPLOAD);
		manageexpensepage.ClickOnSaveButton();
		System.out.println(manageexpensepage.get_AlertMessageNotification());
		Assert.assertTrue(manageexpensepage.AlertMessage_isDisplayed());		
	}
	@Test
	public void verify_ManageExpenseFunctionalities() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.enter_PageInformations("2000", "Amount is paid");
		manageexpensepage.FileUpload(Constants.USERFILE_UPLOAD);
		manageexpensepage.ClickOnSaveButton();
		Assert.assertTrue(manageexpensepage.SaveButton_isDisplayed());
	}
	@Test
	public void verify_UpdateDetailsOfManageExpense() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.edit_ExpenseData();
		manageexpensepage.enter_OrderIdDataUpdation();
		manageexpensepage.updateButton();
		Assert.assertTrue(manageexpensepage.updatedAlertMessage_IsDisplayed());
		//String expectedresult=Constants.EXPECTED_ALERTTEXT4;
		//String actualresult=manageexpensepage.get_UpdatedAlertMessage();
		//Assert.assertEquals(actualresult,expectedresult);
		
	}
	@Test
	public void verify_DeleteManageExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.delete_DataExpense();
		Assert.assertTrue(manageexpensepage.deleteAlertMessage_isDisplayed());
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
		Assert.assertFalse(manageexpensepage.searchButtonManageExpenseIsSelected());
		System.out.println(manageexpensepage.get_TextNewWindowReport());
		manageexpensepage.click_BackButton();
		
	}

}
