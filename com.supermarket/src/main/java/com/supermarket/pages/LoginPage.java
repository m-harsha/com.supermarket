package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class LoginPage {
	
	WebDriver driver;
	Excel excel=new Excel();
	GeneralUtility generalutility;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@CacheLookup
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement signIn;
	@FindBy(xpath="//img[@class='img-circle']")		
	private WebElement profileImage;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")		
	private WebElement alertMessage;
	@FindBy(xpath="//input[@id='remember']")		
	private WebElement rememeberMe;
	@FindBy(xpath="//label[@for='remember']")		
	private WebElement rememeberMeLabel;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")		
	private WebElement logout;
	@FindBy(xpath="//p[text()='Sign in to start your session']")		
	private WebElement signInText;
	
		
	public LoginPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String UserName) {
		userName.sendKeys(UserName);
	}
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}	
	public void clickOnLoginButton() {
		signIn.click();		
	}
	public void login(String UserName, String Password) {
		enterUserName(UserName);
		enterPassword(Password);
		clickOnLoginButton();				
	}
	public void login() {
		String userName;
		String password;
		excel.setExcelFile("Login","validlogincredentials");
		userName=excel.getCellData(0, 0);
		password=excel.getCellData(0, 1);
		login(userName,password);
	}	
    public boolean is_ProfileImageDisplayed() {
	    generalutility=new GeneralUtility(driver);
	    return generalutility.is_Displayed(profileImage);		
	}  
    public String get_AlertMessageNotification() {
    	generalutility=new GeneralUtility(driver);
    	return generalutility.get_Text(alertMessage);
    }
    public void click_OnRememberMeCheckBox() {
    	rememeberMeLabel.click();
    }
    public boolean is_RememeberMeSelected() {
    	generalutility=new GeneralUtility(driver);
    	return generalutility.is_Selected(rememeberMe);
    }
    public void clickOnProfileImage() {
    	profileImage.click();
    }
    public void clickOnLogOut() {
    	clickOnProfileImage();
    	logout.click();
    }
    public String getTextOfSignIn() {
    	generalutility=new GeneralUtility(driver);
    	return generalutility.get_Text(signInText);
    }

}
