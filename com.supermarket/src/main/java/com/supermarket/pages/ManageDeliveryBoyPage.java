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

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoy;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement addressField;
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWord;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deactivateAlert;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnDeliveryBoy() {
	    manageDeliveryBoy.click();	
	}
    public void clickOnNewButton() {
    	newButton.click();
    } 
    public void enterName(String name) {
    	nameField.sendKeys(name);
    }
    public void enterEmail(String email) {
    	emailField.sendKeys(email);
    }
    public void enterPhoneNumber(String phone) {
    	phoneNumberField.sendKeys(phone);
    } 
    public void enterAddress(String address) {
    	addressField.sendKeys(address);
    }
    public void enterUserName(String username) {
    	userName.sendKeys(username);
    }  
    public void enterPassword(String password) {
    	passWord.sendKeys(password);
    }
    public void click_SaveButton() {
    	pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(saveButton); 	
    }   
   
    public void create_DeliveryBoy(String name,String email,String phone,String address,String UserName, String password) {
    	clickOnDeliveryBoy();
    	clickOnNewButton();
    	enterName(name);
    	enterEmail(email);
    	enterPhoneNumber(phone);
    	enterAddress(address);
    	enterUserName(UserName);
		enterPassword(password);
		click_SaveButton();
	}  
     public String visibilityOfAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(alertMessage, "class");
	 }
    public String get_AlertMessageNotification() {
    	generalutility=new GeneralUtility(driver);
    	return generalutility.get_Text(alertMessage);
    }
    public void deactivate_UserStatus(String usersName) {
		 int j=0;
		 List<String> names=new ArrayList<String>();
		 generalutility=new GeneralUtility(driver);
		 pageutility=new PageUtility(driver);
		 names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
		 for(j=0;j<names.size();j++) {
			 if(usersName.equals(names.get(j))) {
				 j++;
				 break;	 
			 }
		 }
		 WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[6]//a"));
		 deactivateButton.click();
	 }
	
	 public void delete_DeliveryBoy(String usersName) {
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
		 WebElement deactivateactionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[8]//a)[2]"));
		 deactivateactionButton.click();
		 driver.switchTo().alert().accept();	
	 }
	 public String visibilityOfDeleteAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(deleteAlert, "class");
	 }
	 public String visibilityOfDeactivateAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(deactivateAlert, "class");
	 }
		
	 public String get_ColorOfSaveButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(saveButton, "color");
	 }
		
	 
	
	
}


