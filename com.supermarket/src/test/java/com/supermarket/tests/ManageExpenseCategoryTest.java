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
	
	@Test
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
	public void verify_ExpenseCategoryFunctionalities() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.expenseCategoryDetails("vegetables1");
		String actualfontWeight=category.get_FontWeightOfSaveButton();
		String expectedfontWeight=Constants.EXPECTEDWEIGHT_SAVEBUTTON;
		Assert.assertEquals(actualfontWeight, expectedfontWeight);
    }
	
	@Test
	public void verify_UpdateDetailsOfManageExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.enterUpdatedTitle("Nutts1","Nutts2");
		category.updateButton();
		String actualfontsize=category. get_FontSizeOfUpdateButton();
		String expectedfontsize=Constants.EXPECTEDSIZE_UPDATEBUTTON;
		Assert.assertEquals(actualfontsize, expectedfontsize);
    }
		
	@Test
	public void verify_DeleteExpenseCategory() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.delete_ManageExpenseCategory("Biscuits");
		String actualfontstyle=category. get_FontStyleOfDeleteButton();
		String expectedfontstyle=Constants.EXPECTED_STYLEDELETEALERT;
		Assert.assertEquals(actualfontstyle, expectedfontstyle);
	
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
		String actualcolor=category. get_ColorSearchButton();
		String expectedcolor=Constants.EXPECTEDCOLOR_SEARCHBUTTON;
		Assert.assertEquals(actualcolor, expectedcolor);
	
	}
	
	@Test(dataProvider="ManageExpenseCategory",dataProviderClass=DataProviderClass.class)
	public void verifyManageExpenseCategoryByDataproviderclass(String data1) {
		loginpage=new LoginPage(driver);
		loginpage.login();
		category=new ManageExpenseCategoryPage(driver);
		category.clickOnManageExpense();
		category.clickOnExpenseCategory();
		category.expenseCategoryDetails(data1);
		category.alertMessage_IsDisplayed();	
		String actualtext=category. get_TextExpenseCategory();
		String expectedtext=Constants.EXPECTEDTEXT;
		Assert.assertEquals(actualtext, expectedtext);
    }
		
	
	
}
