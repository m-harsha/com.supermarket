package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpenseCategoryPage;
import com.supermarket.utilities.Excel;

public class ManageExpenseCategoryTest extends Base {
	Excel excel=new Excel();
	LoginPage loginpage;
	ManageExpenseCategoryPage category;
	
	@Test
	public void verify_Add_NewExpenseCategory() {
		String title;
		excel.setExcelFile("Expense Category","ExpenseCategoryInformations");
		title=excel.getCellData(0, 0);
		
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.expenseCategoryDetails(title);
		System.out.println(category.get_DangerAlertMessageNotification());
        Assert.assertTrue(category.alertMessage_IsDisplayed());
	}
	
	@Test
	public void verify_ExpenseCategoryFunctionalities() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.expenseCategoryDetails("vegetables1");
		Assert.assertFalse(category.saveButtonIs_Selected());
	}
	@Test
	public void verify_UpdateDetailsOfManageExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.enterUpdatedTitle("Nuts");
		category.updateButton();
		Assert.assertTrue(category.updatedAlertMessage_IsDisplayed());
	}
	@Test
	public void verify_DeleteExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.delete_DataExpense();
		Assert.assertTrue(category.deleteAlertMessage_isDisplayed());
	
	}
	@Test
	public void verify_SearchedDataOfManageExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.searchedTitle("Diary123");
		category.click_SearchButtonExpenseCategory();
		Assert.assertFalse(category.searchButtonManageExpenseCategoryIsSelected());		
	}
	
	@Test(dataProvider="ManageExpenseCategory",dataProviderClass=DataProviderClass.class)
	public void ManageExpenseCategoryByDataproviderclass(String data1) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.expenseCategoryDetails(data1);
		Assert.assertTrue(category.alertMessage_IsDisplayed());
		
		
		
	}
	
}
