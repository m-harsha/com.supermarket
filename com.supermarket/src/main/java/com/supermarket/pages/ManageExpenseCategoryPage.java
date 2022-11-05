package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	private WebElement titleField;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement editUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedAlertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	private WebElement searchTitle;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchData;
	@FindBy(xpath="//h1[text()='Add Expense Category']")
	private WebElement expenseText;
	
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
		titleField.sendKeys(title);
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
	 public String visibilityOfAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(alertMessage, "class");
	 }
	 public String get_ColorDangerAlert() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(alertMessage, "color");
	 }
	 public String get_FontWeightOfSaveButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(saveButton, "font-weight");
	 }
			
	 public String get_DangerAlertMessageNotification() {
	    generalutility=new GeneralUtility(driver);
	    return generalutility.get_Text(alertMessage);
	 }
	 public boolean alertMessage_IsDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertMessage);
     }
	
	 public void click_EditOption(String usersName) {
		 int j=0;
		 List<String> names=new ArrayList<String>();
		 generalutility=new GeneralUtility(driver);
		 names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
		 for(j=0;j<names.size();j++) {
			 if(usersName.equals(names.get(j))) {
				 j++;
				 break;	 
			 }
		 }
		 WebElement editActionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[2]//a)[1]"));
		 editActionButton.click();
	 }
	 public void enterUpdatedTitle(String usersName,String title1) {
		 click_EditOption(usersName);
		 titleField.clear();
		 titleField.sendKeys(title1);
	}
	 public void updateButton() {
		 editUpdateButton.click();
	 }
	 public String get_FontSizeOfUpdateButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(editUpdateButton, "font-size");
	 }
	 public String get_FontStyleOfDeleteButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(editUpdateButton, "font-style");
	 }
	 public boolean updatedAlertMessage_IsDisplayed() {
	  	 generalutility=new GeneralUtility(driver);
	  	 return generalutility.is_Displayed(updatedAlertMessage);
	 }
	 public void delete_ManageExpenseCategory(String usersName) {
		 int j=0;
		 List<String> names=new ArrayList<String>();
		 generalutility=new GeneralUtility(driver);
		 names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
		 for(j=0;j<names.size();j++) {
			 if(usersName.equals(names.get(j))) {
				 j++;
				 break;	 
			 }
		 }
		 WebElement deactivateactionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[2]//a)[2]"));
		 deactivateactionButton.click();
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();	 
	 }
	
	 public boolean deleteAlertMessage_isDisplayed() {
	     generalutility=new GeneralUtility(driver);
	  	 return generalutility.is_Displayed(deleteAlert);
	 }
	 public void clickSearchButton() {
		 searchButton.click();	   
	 }
	 public String get_ColorSearchButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(searchButton, "color");
	 }
	 public void searchedTitle(String title) {
		clickSearchButton();
		searchTitle.sendKeys(title);
     }
	 public void click_SearchButtonExpenseCategory() {
		 searchData.click();	
     }
	
	 public String get_TextExpenseCategory() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Text(expenseText);
	 }
	 
	 
	 
	 
	
}
