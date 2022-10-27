package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage {
	
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
	private WebElement manageLocationLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewButton;
	@FindBy(xpath="//select[@id='country_id']")
	private WebElement Country;
	@FindBy(xpath="//select[@id='st_id']")
	private WebElement State;
	@FindBy(xpath="//input[@id='location']")
	private WebElement Location;
	@FindBy(xpath="//input[@id='delivery']")
	private WebElement DeliveryCharge;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")		
	private WebElement alertMessage;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageLocation() {
		manageLocationLink.click();
	}
	public void clickOnNewButton() {
		NewButton.click();	
    }
	public void enterTheCountry() {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(1,Country);
    }
	public void enterTheState() {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(2,State);
    }
	public void enterTheLocation(String location) {
    	Location.sendKeys(location);
    }
	public void enterTheDeliveryCharge(String deliverycharge) {
    	DeliveryCharge.sendKeys(deliverycharge);
    }
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void ManageLocationDetails(String location,String deliverycharge) {
		clickOnManageLocation();
		clickOnNewButton();
		enterTheCountry();
		enterTheState();
		enterTheLocation(location);
		enterTheDeliveryCharge(deliverycharge);
		clickOnSaveButton();
	}
	
	 public String get_AlertMessageNotification() {
	    	generalutility=new GeneralUtility(driver);
	    	return generalutility.get_Text(alertMessage);
	    }
	 public boolean AlertMessage_isDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertMessage);
     }
}
