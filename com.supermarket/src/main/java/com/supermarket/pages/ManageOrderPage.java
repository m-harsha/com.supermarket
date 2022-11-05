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

public class ManageOrderPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	private WebElement manageOrderLink;
	@FindBy(xpath="(//select[@id='delivery_boy_id'])[1]")
	private WebElement updateDeliveryBoy;
	@FindBy(xpath="(//button[@name='assign_del'])[1]")
	private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath="//i[@class='fas fa-arrow-left']")
	private WebElement backButton;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement listOrderText;
	
	public ManageOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_ManageOrder() {
		manageOrderLink.click();
	}
	public void assignDeliveryBoyData(String usersName) {
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
		 WebElement deliveryBoyButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[6]//a)[3]"));
		 deliveryBoyButton.click();
	 }
	public void selectDeliveryBoy(String usersName) {
		click_ManageOrder();
		assignDeliveryBoyData(usersName);
		updateDeliveryBoy.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(4,updateDeliveryBoy);
	}
	public void click_UpdateButton() {
		updateButton.click();
	}
	 public String get_ColorOfAssignDeliveryBoy() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_CssValue(updateDeliveryBoy, "color");
	 }
	 public void viewListData(String usersName) {
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
		   WebElement viewButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[7]//a)[1]"));
		   viewButton.click();
	 }
	 public void click_BackButton() {
		backButton.click();
    }
	 public String get_TextOfListOrder() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Text(listOrderText);
	 }

	

}
