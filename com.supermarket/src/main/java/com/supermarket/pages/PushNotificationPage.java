package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class PushNotificationPage {
	
	WebDriver driver;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	private WebElement pushNotificationLink;
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleField;	
	@FindBy(xpath="//input[@id='description']")
	private WebElement descriptionField ;	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSuccessText;
	
		
	public PushNotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_PushNotificationButton() {
		pushNotificationLink.click();
	}
	public void enter_TitleField(String title) {
		titleField.sendKeys(title);
	}	
	public void enter_DescriptionField(String description) {
		descriptionField.sendKeys(description);
	}	
	public void click_OnSend() {
		sendButton.click();
	}
	
	public String get_SuccessAlertMessage(String title, String description) {
		enter_TitleField(title);
		enter_DescriptionField(description);
		click_OnSend();
		return get_AlertText();	
	}
	
	public String get_AlertText() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertSuccessText);
		
	}
	 public boolean is_AlertMessageDisplayed() {
		 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertSuccessText);
	 }
	public String get_ColorOfSendButton() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(sendButton, "color");
	 }
	
	 public String get_ColorOfAlert() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue( alertSuccessText, "color");
	 }
	 public String visibilityOfAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(alertSuccessText, "class");
	 }
	
	
	
}
