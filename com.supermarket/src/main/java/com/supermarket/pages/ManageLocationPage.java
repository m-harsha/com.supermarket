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
import com.supermarket.utilities.WaitUtility;

public class ManageLocationPage {
	
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
	private WebElement manageLocationLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//select[@id='country_id']")
	private WebElement country;
	@FindBy(xpath="//select[@id='st_id']")
	private WebElement state;
	@FindBy(xpath="//input[@id='location']")
	private WebElement Location;
	@FindBy(xpath="//input[@id='delivery']")
	private WebElement deliveryCharge;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")		
	private WebElement alertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")		
	private WebElement statusAlertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	@FindBy(xpath="(//tbody//tr[7]//td[6]//a)[1]")
	private WebElement editExpenseData;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement editUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedAlertMessage;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix align-center']")
	private WebElement searchButtonOfManageLocation;
	
	
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageLocation() {
		manageLocationLink.click();
	}
	public void clickOnNewButton() {
		newButton.click();	
    }
	public void enterTheCountry() {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(1,country);
    }
	public void enterTheState() {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(2,state);
    }
	public void enterTheLocation(String location) {
    	Location.sendKeys(location);
    }
	public void enterTheDeliveryCharge(String deliverycharge) {
    	deliveryCharge.sendKeys(deliverycharge);
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
	 public boolean alertMessage_isDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(alertMessage);
     }
	 public String get_StatusAlertMessageNotification() {
	    	generalutility=new GeneralUtility(driver);
	    	return generalutility.get_Text(statusAlertMessage);
	    }
	 public boolean statusAlertMessage_isDisplayed() {
 	 generalutility=new GeneralUtility(driver);
 	 return generalutility.is_Displayed(statusAlertMessage);
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
		 WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[5]//a"));
		 deactivateButton.click();
	 }
	 public void delete_Location(String usersName) {
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
		 WebElement deactivateactionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[6]//a)[2]"));
		 deactivateactionButton.click();
		 driver.switchTo().alert().accept();	
		// driver.switchTo().alert().dismiss();	 
	 }
	 public boolean deleteAlertMessage_isDisplayed() {
    	 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(deleteAlert);
     }
	 public void click_EditOption() {
		 editExpenseData.click();
	 }
	 public void enter_StateDataUpdation() {
		 click_EditOption();
		 pageutility=new PageUtility(driver);
		 pageutility.select_ByIndex(5,state);
	 }
	 public void updateButton() {
		 waitutility=new WaitUtility(driver);
		 waitutility.element_ToBeClickable(10L, "//button[@type='submit']");
		 pageutility.scrollAndClick(editUpdateButton); 	   
	   }
	 public boolean updatedAlertMessage_IsDisplayed() {
	  	 generalutility=new GeneralUtility(driver);
	  	 return generalutility.is_Displayed(updatedAlertMessage);
	  }
	 public void clickSearchButton() {
		 searchButton.click();	   
	   }
	 public void search_CategoriesOfManageLocation() {
		 country.click();
	     pageutility=new PageUtility(driver);
		 pageutility.select_ByIndex(1, country);
		 state.click();
		 pageutility.select_ByVisibleText("Argyll", state);	 
	 }
	 public void entersearchedLocation(String location) {
	    	Location.sendKeys(location);
	 }
	 public void click_SearchButtonManageLocation() {
		 searchButtonOfManageLocation.click();	 
	 }
	 public boolean searchButtonManageLocationIsSelected() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.is_Selected(searchButtonOfManageLocation);
	 }
		  
}
