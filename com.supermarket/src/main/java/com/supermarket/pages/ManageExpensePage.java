package com.supermarket.pages;


import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageExpensePage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	private WebElement ManageExpense;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewButton;
	@FindBy(xpath="//select[@id='user_id']")
	private WebElement user;
	@FindBy(xpath="//select[@id='ex_cat']")
	private WebElement category;
	@FindBy(xpath="//select[@id='order_id']")
	private WebElement orderId;
	@FindBy(xpath="//select[@id='purchase_id']")
	private WebElement purchaseId;
	@FindBy(xpath="//select[@id='ex_type']")
	private WebElement expensetype;
	@FindBy(xpath="//input[@id='amount']")
	private WebElement Amount;
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Remarks;
	@FindBy(xpath="//input[@type='file']")
	private WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath="(//tbody//tr[3]//td[9]//a)[1]")
	private WebElement editExpenseData;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement editUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedAlertMessage;
	@FindBy(xpath="(//tbody//tr[7]//td[9]//a)[2]")
	private WebElement DeleteExpenseData;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement searchUsers;
	@FindBy(xpath="//input[@id='ti']")
	private WebElement searchEnterTitle;
	@FindBy(xpath="//select[@id='uc']")
	private WebElement searchCategory;
	@FindBy(xpath="//select[@id='ty']")
	private WebElement searchExpenseType;
	@FindBy(xpath="//select[@id='od']")
	private WebElement searchOrderId;
	@FindBy(xpath="//select[@id='pi']")
	private WebElement searchPurchaseId;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButtonOfManageExpense;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-info']")
	private WebElement reportButtonOfManageExpense;
	@FindBy(xpath="//div[@class='col-sm-12']")
	private WebElement nextWindowExpenseReport;
	@FindBy(xpath="//span[@id='back']")
	private WebElement backButtonExpenseReport;
	
	
	
	public ManageExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageExpense() {
		manageExpenseLink.click();
	}
	public void clickOnExpense() {
		ManageExpense.click();
	}
	public void clickOnNewButton() {
		NewButton.click();
	}
	public void clickOnUserType() {
		user.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(2, user);
	}
	public void clickOnCategory() {
		category.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(2, category);
	}
	public void clickOnOrderId() {
		orderId.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(3, orderId);
	}
	public void clickOnPurchaseId() {
		purchaseId.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(3, purchaseId);
	}
	public void clickOnExpenseType() {
		expensetype.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(4,expensetype);
	}
	public void enterAmount(String amount) {
		Amount.sendKeys(amount);
	}
	public void enterRemarks(String remarks) {
		Remarks.sendKeys(remarks);
	}
	public void clickOnChooseFile() {
		pageutility=new PageUtility(driver);
		pageutility.click_JavaScriptExecutor(chooseFile);	
	}
	public void FileUpload(String filepath) {
		chooseFile.sendKeys(filepath);
	}
	public void ClickOnSaveButton() {
		pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(saveButton); 
		
	}
	public void enter_PageInformations(String amount,String remarks) {
		clickOnManageExpense();
		clickOnExpense();
		clickOnNewButton();
		clickOnUserType();
		clickOnCategory();
		clickOnOrderId();
		clickOnPurchaseId();
		clickOnExpenseType();
		enterAmount(amount);
		enterRemarks(remarks);
	}
	
	public boolean AlertMessage_isDisplayed() {
   	    generalutility=new GeneralUtility(driver);
   	    return generalutility.is_Displayed(alertMessage);
    }
   public String get_AlertMessageNotification() {
   	    generalutility=new GeneralUtility(driver);
   	    return generalutility.get_Text(alertMessage);
   }
   public boolean SaveButton_isDisplayed() {
	   	 generalutility=new GeneralUtility(driver);
	   	 return generalutility.is_Displayed(saveButton);
   }
   public void edit_ExpenseData() {
	   editExpenseData.click();
   }
   public void enter_OrderIdDataUpdation() {
	   orderId.click();
	   pageutility=new PageUtility(driver);
	   pageutility.select_ByIndex(9, orderId);
	   
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
   public String get_UpdatedAlertMessage() {
	   generalutility=new GeneralUtility(driver);
 	    String string= generalutility.get_Text(updatedAlertMessage);
 	    String split[]=string.split("Alert!");
 	    String text=split[1];
 	    System.out.println(text);
 	    return text;
   }
   public void delete_DataExpense() {
	   DeleteExpenseData.click();
	   driver.switchTo().alert().accept();
	   //driver.switchTo().alert().dismiss();
   }
   public boolean deleteAlertMessage_isDisplayed() {
  	 generalutility=new GeneralUtility(driver);
  	 return generalutility.is_Displayed(deleteAlert);
   }
  
   public void clickSearchButton() {
	   searchButton.click();
	   
   }
   public void search_EnterTitle(String name) {
	   searchEnterTitle.sendKeys(name);
   }
   public void search_CategoriesOfManageExpense() {
	   searchUsers.click();
	   pageutility=new PageUtility(driver);
	   pageutility.select_ByIndex(7, searchUsers);
	   searchCategory.click();
	   pageutility=new PageUtility(driver);
	   pageutility.select_ByIndex(5, searchCategory);
	   searchExpenseType.click();
	   pageutility.select_ByVisibleText("Debit Bank", searchExpenseType);
	   searchOrderId.click();
	   pageutility.select_ByIndex(9, searchOrderId);
	   searchPurchaseId.click();
	   pageutility.select_ByIndex(10, searchPurchaseId);
   }
   public void click_SearchButtonManageExpense() {
	   pageutility.scrollAndClick(searchButtonOfManageExpense); 
	   
   }
   public boolean searchButtonManageExpenseIsSelected() {
	   generalutility=new GeneralUtility(driver);
	   return generalutility.is_Selected(searchButtonOfManageExpense);
   }
   public void click_ReportButtonManageExpense() {
	   pageutility.scrollAndClick(reportButtonOfManageExpense); 
	   String parentWindow=driver.getWindowHandle();
	   System.out.println(parentWindow);
	   Set<String> windows=driver.getWindowHandles();
	   System.out.println("size" +windows.size());
	   System.out.println(windows);
	   for(String w:windows) {
		   if(parentWindow.equals(w)) {
			   System.out.println("no need to switch");
			   System.out.println(w+" "+parentWindow);
		   }
		   else {
			   driver.switchTo().window(w);
		   }
	   }
	   
   }
   public String get_TextNewWindowReport() {
	   click_ReportButtonManageExpense();
	   generalutility=new GeneralUtility(driver);
	   return generalutility.get_Text(nextWindowExpenseReport);
   }
   public void click_BackButton() {
	   backButtonExpenseReport.click();
   }
   
  
   

}