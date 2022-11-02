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
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		System.out.println(manageexpensepage.get_AlertMessageNotification());
		Assert.assertTrue(manageexpensepage.alertMessage_isDisplayed());		
	}
	@Test
	public void verify_ManageExpenseFunctionalities() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.enter_PageInformations("2000", "Amount is paid");
		manageexpensepage.fileUpload(Constants.USERFILE_UPLOAD +"\\Grocery.pdf");
		manageexpensepage.clickOnSaveButton();
		Assert.assertTrue(manageexpensepage.saveButton_isDisplayed());
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
		Assert.assertTrue(manageexpensepage.updatedAlertMessage_IsDisplayed());
	
	}
	@Test
	public void verify_DeleteManageExpenseData() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.clickOnManageExpense();
		manageexpensepage.clickOnExpense();
		manageexpensepage.delete_DataExpense("IceCreams (Admin2-AD)");
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
