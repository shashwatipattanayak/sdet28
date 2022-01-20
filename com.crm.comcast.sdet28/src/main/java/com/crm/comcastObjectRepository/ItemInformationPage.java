package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class ItemInformationPage extends WebDriverUtility {
	
	//initialization
	WebDriver driver;
	public ItemInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[text()='Products']")
	private WebElement itemPageTitle;

	@FindBy(linkText = "IdeaPad")
	private WebElement itemName;
	
	@FindBy(xpath = "//*[text()='Creating New Purchase Order']")
	private WebElement purchaseOrderPageTitle;
	
	//getters method
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getItemPageTitle() {
		return itemPageTitle;
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getPurchaseOrderPageTitle() {
		return purchaseOrderPageTitle;
	}
	
	//Business logic
	public void selectItem() {
		itemName.click();
		//switchWindow(driver, partialWindowTitle);
	}
	
}
