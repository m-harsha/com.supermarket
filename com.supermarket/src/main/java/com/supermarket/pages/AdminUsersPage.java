package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")		
	private WebElement alertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")		
	private WebElement statusAlertMessage;
	@FindBy(xpath="//img[@class='img-circle']")		
	private WebElement profileImage;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")		
	private WebElement logout;
	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
	public void enterUserType(int a) {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(a,userType);
    }
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void adminUsersDetails(String userName,String password) {
		clickOnAdminUsers();
		clickOnNewButton();
		enterUserName(userName);
		enterPassword(password);
	}	
	 public String visibilityOfAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(alertMessage, "class");
	 }
	public String get_AlertMessageNotification() {
	    generalutility=new GeneralUtility(driver);
	    return generalutility.get_Text(alertMessage);
	}
	 public void deactivate_UserAction(String usersName) {
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
		 WebElement deactivateactionButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[3]//a"));
		 deactivateactionButton.click();
		 
	 }
	 public boolean statusAlertMessage_isDisplayed() {
	 	 generalutility=new GeneralUtility(driver);
	 	 return generalutility.is_Displayed(statusAlertMessage);
	 }
	 public String get_BackgroundColorOfAlertMessage() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(statusAlertMessage, "color");
	 }
	 public void clickOnLogout() {
		 profileImage.click();
		 logout.click();	 
	 }
	 public boolean is_ProfileNameDisplayed() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.is_Displayed(profileImage);		
	}

}
