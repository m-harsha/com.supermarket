package com.supermarket.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageProductPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	private WebElement manageProductLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleName;
	@FindBy(xpath="//input[@value='Nonveg']")
	private WebElement product;
	@FindBy(xpath="//input[@id='tag']")
	private WebElement tagName;
	@FindBy(xpath="//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath="//select[@id='sub_id']")
	private WebElement subCategory;
	@FindBy(xpath="//select[@id='grp_id']")
	private WebElement groupId;
	@FindBy(xpath="//input[@id='purpose']")
	private WebElement priceType;
	@FindBy(xpath="//input[@id='m_weight']")
	private WebElement weightValue;
	@FindBy(xpath="//select[@id='w_unit']")
	private WebElement weightUnit;
	@FindBy(xpath="//input[@id='max_weight']")
	private WebElement maxQuantity;
	@FindBy(xpath="//input[@id='w_price']")
	private WebElement price;
	@FindBy(xpath="//input[@id='w_mrp']")
	private WebElement mrpPrice;
	@FindBy(xpath="//input[@id='w_stock']")
	private WebElement stockAvailability;
	@FindBy(xpath="//input[@id='w_pp']")
	private WebElement purchasePrice;
	@FindBy(xpath="(//input[@value='yes'])[1]")
	private WebElement checkbox;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	private WebElement description;
	@FindBy(xpath="(//input[@name='stock'])[1]")
	private WebElement stockBox;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement mainImage;
	@FindBy(xpath="(//input[@name='featured'])[1]")
	private WebElement featured;
	@FindBy(xpath="(//input[@name='combo'])[2]")
	private WebElement combo;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	
	
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageProduct() {
		manageProductLink.click();
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterTitle(String title) {
		titleName.sendKeys(title);
	}
	public void enterProductType() {
		product.click();
	}
	public void enterTag(String tag) {
		tagName.sendKeys(tag);
	}
	public void clickOnCategory() {
		category.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(2, category);
	}
	public void clickOnSubCategory() {
		waitutility=new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L, "//select[@id='sub_id']");	
		subCategory.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText("Atta & Flours",subCategory );
	}
	public void clickOnGroup() {
		groupId.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(1, groupId);
	}
	public void clickOnPriceType() {
		priceType.click();
	}
	public void enterWeightValue(String weight) {
		weightValue.sendKeys(weight);
	}
	public void clickOnWeightUnit() {
		weightUnit.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(1, weightUnit);
	}
	public void enterMaximunQuantity(String quantity) {
		maxQuantity.sendKeys(quantity);
	}
	public void enterThePrice(String Price) {
		price.sendKeys(Price);
	}
	public void enterTheMrp(String mrp) {
		mrpPrice.sendKeys(mrp);
	}
	public void enterStockAvailability(String stock) {
		stockAvailability.sendKeys(stock);
	}
	public void enterThePurchasePrice(String purchase) {
		purchasePrice.sendKeys(purchase);
	}
	public void clickOnUnlimitedStock() {
		pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(checkbox); 
	}
	public void enterTheDescription(String des) {
		description.sendKeys(des);
	}
	public void clickOnStock() {
		pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(stockBox); 
	}
	public void enterProductDetails(String title,String tag,String weight,String quantity,String Price,String mrp,String stock,String purchase,String des) {
		clickOnManageProduct();
		clickOnNewButton();
		enterTitle(title);
		enterProductType();
		enterTag(tag);
		clickOnCategory();
		clickOnSubCategory();
		clickOnGroup();
		clickOnPriceType();
		enterWeightValue(weight);
		clickOnWeightUnit();
		enterMaximunQuantity(quantity);
		enterThePrice(Price);
		enterTheMrp(mrp);
		enterStockAvailability(stock);
		enterThePurchasePrice(purchase);
		clickOnUnlimitedStock();
		enterTheDescription(des);
		clickOnStock();		
	}
	public void imageUpload(String filepath) {
		mainImage.sendKeys(filepath);
	}
	public void clickOnFeaturedBox() {
		pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(featured); 
	}
	public void clickOnCombo() {
		combo.click();
	}
	public void clickOnSaveButton() {
		clickOnFeaturedBox();
		clickOnCombo();
		pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(saveButton); 
	}
	 public String visibilityOfAlertNotification() {
		 generalutility=new GeneralUtility(driver);
		 return generalutility.get_Attribute(alertMessage, "class");
	}
	 
		
	
	
	
	
	
	
	
	
	
	

}
