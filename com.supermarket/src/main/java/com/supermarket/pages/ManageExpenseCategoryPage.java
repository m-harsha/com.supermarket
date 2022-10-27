package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.supermarket.utilities.GeneralUtility;

public class ManageExpenseCategoryPage {
	WebDriver driver;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	private WebElement expenseCategory;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@id='name']")
	private WebElement Title;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	
	public ManageExpenseCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageExpense() {
		manageExpenseLink.click();
	}
	public void clickOnExpenseCategory() {
		expenseCategory.click();
	}
	public void clickOnNewButton() {
		newButton.click();	
    }
	public void enterTitle(String title) {
		Title.sendKeys(title);
	}
	public void clickOnSaveButton() {
		saveButton.click();	
    }
	public void ExpenseCategoryDetails(String title) {
		clickOnManageExpense();
		clickOnExpenseCategory();
		clickOnNewButton();
		enterTitle(title);
		clickOnSaveButton();
	}
			
	 public String get_DangerAlertMessageNotification() {
	    generalutility=new GeneralUtility(driver);
	    return generalutility.get_Text(alertMessage);
	 }
	 public boolean AlertMessage_isDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertMessage);
     }
	
}
