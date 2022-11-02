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

public class ManageUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	private WebElement manageusersLink;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deactivateAlert;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	
	
	public ManageUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageUsers() {
		manageusersLink.click();
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
		 WebElement deactivateactionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[6]//a)[1]"));
		 deactivateactionButton.click();
		 
	 }
	 public void delete_ManageUser(String usersName) {
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
		 driver.switchTo().alert().dismiss();
		 
	 }
	 public boolean is_DeactivateActionAlertMessageDisplayed() {
		 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(deactivateAlert);
	 }
	 public String get_AlertMessageNotification() {
	    	generalutility=new GeneralUtility(driver);
	    	return generalutility.get_Text(deactivateAlert);
	    }
	 public boolean is_DeleteAlertMessageDisplayed() {
		 generalutility=new GeneralUtility(driver);
    	 return generalutility.is_Displayed(deleteAlert);
	 }
}
