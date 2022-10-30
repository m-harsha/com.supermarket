package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")		
	private WebElement logoSymbol;
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")		
	private WebElement alertMessage;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoSymbolOfAdminUsers_IsDisplayed() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Displayed(logoSymbol);		
	}
	public void clickOnAdminUsers() {
		adminUsersLink.click();
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUserName(String username) {
	    userName.sendKeys(username);
	}	    
	public void enterPassword(String password) {
	    Password.sendKeys(password);
	}
	public void enterUserType() {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(2,userType);
    }
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void adminUsersDetails(String userName,String password) {
		clickOnAdminUsers();
		clickOnNewButton();
		enterUserName(userName);
		enterPassword(password);
		enterUserType();
		clickOnSaveButton();	
	}	
	public String get_DangerAlertMessageNotification() {
	    generalutility=new GeneralUtility(driver);
	    return generalutility.get_Text(alertMessage);
	}
	public boolean alertMessage_isDisplayed() {
 	    generalutility=new GeneralUtility(driver);
 	    return generalutility.is_Displayed(alertMessage);
    }

}
