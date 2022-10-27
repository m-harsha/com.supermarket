package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpenseCategoryPage;
import com.supermarket.utilities.Excel;

public class ManageExpenseCategoryTest extends Base {
	Excel excel=new Excel();
	LoginPage loginpage;
	ManageExpenseCategoryPage category;
	
	@Test
	public void verify_add_NewExpenseCategory() {
		String title;
		excel.setExcelFile("Expense Category","ExpenseCategoryInformations");
		title=excel.getCellData(0, 0);
		
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.ExpenseCategoryDetails(title);
		System.out.println(category.get_DangerAlertMessageNotification());
        Assert.assertTrue(category.AlertMessage_isDisplayed());
	}
	
	@Test
	public void verify_ExpenseCategoryTextAlertMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login();	
		category=new ManageExpenseCategoryPage(driver);
		category.ExpenseCategoryDetails("vegetables1");
		String expectedresult=Constants.EXPECTED_ALERTTEXT2;
		String actualresult=category.get_DangerAlertMessageNotification();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult, expectedresult,"This testcase failed");
	}

	
}
