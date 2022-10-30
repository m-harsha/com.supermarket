package com.supermarket.pages;

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
	@FindBy(xpath="(//tbody//tr[1]//td[6]//a)[3]")
	private WebElement assignDeliveryBoy;
	@FindBy(xpath="(//select[@id='delivery_boy_id'])[1]")
	private WebElement updateDeliveryBoy;
	@FindBy(xpath="(//button[@name='assign_del'])[1]")
	private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath="(//tbody//tr[1]//td[6]//a)[1]")
	private WebElement status;
	@FindBy(xpath="(//select[@id='status'])[1]")
	private WebElement updatestatus;
	@FindBy(xpath="(//button[@name='Update_st'])[1]")
	private WebElement updateStatusButton;
	
	
	public ManageOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_ManageOrder() {
		manageOrderLink.click();
	}
	public void assignDeliveryBoyData() {
		assignDeliveryBoy.click();
	}
	public void selectDeliveryBoy() {
		click_ManageOrder();
		assignDeliveryBoyData();
		updateDeliveryBoy.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(4,updateDeliveryBoy);
	}
	public void click_UpdateButton() {
		waitutility=new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L, "(//button[@name='assign_del'])[1]");	
		pageutility.scrollAndClick(updateButton);
		//updateButton.click();
	}
	 public boolean alertMessage_IsDisplayed() {
    	generalutility=new GeneralUtility(driver);
    	return generalutility.is_Displayed(alertMessage);
   }
	

}
