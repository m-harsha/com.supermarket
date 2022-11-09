package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpenseCategoryPage;
import com.supermarket.utilities.Excel;

public class ManageExpenseCategoryTest extends Base {
	Excel excel=new Excel();
	LoginPage loginpage;
	ManageExpenseCategoryPage category;
	
	@Test(priority=1)
	public void verify_Add_NewExpenseCategory() {
		excel.setExcelFile("Expense Category","ExpenseCategoryInformations");
		String title=excel.getCellData(0, 0);
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.expenseCategoryDetails(title);
		String actualresult=category.visibilityOfAlertNotification();
		String expectedresult=Constants.EXPECTED_CATEGORYALERT;
		Assert.assertEquals(actualresult,expectedresult);
	}
	
	@Test
	public void verify_CreateExpenseCategoryDetails() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.expenseCategoryDetails("vegetables3");
		String actualcolor=category.get_ColorOfAlertMessage();
		String expectedcolor=Constants.EXPECTEDCOLOROFALERT;
		Assert.assertEquals(actualcolor, expectedcolor);
    }
	
	@Test(priority=2)
	public void verify_UpdateFunctionalityOfManageExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.enterUpdatedTitle("grapes","Grapess");
		category.updateButton();
		Assert.assertTrue(category.updatedAlertMessage_IsDisplayed());
    }
		
	@Test(priority=3)
	public void verify_DeleteExpenseCategoryData() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.delete_ManageExpenseCategory("orange11111");
		category.searchedTitle("orange11111");
		category.click_SearchButtonExpenseCategory();
		String actualtext=category. get_ReportOfDeletedData();
		String expectedtext=Constants.EXPECTED_DATA;
		Assert.assertEquals(actualtext, expectedtext);	
	}
	
	@Test(priority=4)
	public void verify_Search_ManageExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.searchedTitle("Diary");
		category.click_SearchButtonExpenseCategory();	
		Assert.assertTrue(category.SearchedData_isDisplayed());		
	}
	
	@Test(dataProvider="ManageExpenseCategory",dataProviderClass=DataProviderClass.class)
	public void verifyManageExpenseCategoryByDataproviderclass(String data1) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.expenseCategoryDetails(data1);
		Assert.assertTrue(category.expenseCategoryDetails_isDisplayed());	
    }
	
}
