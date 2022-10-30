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
	@FindBy(xpath="(//tbody//tr[6]//td[2]//a)[1]")
	private WebElement editExpenseCategoryData;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement editUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedAlertMessage;
	@FindBy(xpath="(//tbody//tr[7]//td[2]//a)[2]")
	private WebElement DeleteExpenseData;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	private WebElement searchTitle;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchData;
	
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
	public void expenseCategoryDetails(String title) {
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
	 public boolean alertMessage_IsDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertMessage);
     }
	 public boolean saveButtonIs_Selected() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.is_Selected(saveButton);
	 }
	
	 public void click_EditOption() {
		 editExpenseCategoryData.click();
	 }
	 public void enterUpdatedTitle(String title1) {
		 click_EditOption();
		 Title.clear();
		 Title.sendKeys(title1);
	}
	 public void updateButton() {
		 editUpdateButton.click();
	 }
	 public boolean updatedAlertMessage_IsDisplayed() {
	  	 generalutility=new GeneralUtility(driver);
	  	 return generalutility.is_Displayed(updatedAlertMessage);
	 }
	 public void delete_DataExpense() {
		 DeleteExpenseData.click();
		 driver.switchTo().alert().accept();
		 //driver.switchTo().alert().dismiss();
	 }
	 public boolean deleteAlertMessage_isDisplayed() {
	     generalutility=new GeneralUtility(driver);
	  	 return generalutility.is_Displayed(deleteAlert);
	 }
	 public void clickSearchButton() {
		 searchButton.click();	   
	 }
	 public void searchedTitle(String title) {
		clickSearchButton();
		searchTitle.sendKeys(title);
     }
	 public void click_SearchButtonExpenseCategory() {
		 searchData.click();	
     }
	 public boolean searchButtonManageExpenseCategoryIsSelected() {
  	    generalutility=new GeneralUtility(driver);
  	    return generalutility.is_Selected(searchData);
    }
	 
	 
	 
	 
	
}
