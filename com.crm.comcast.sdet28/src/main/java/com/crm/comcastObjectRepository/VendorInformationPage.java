package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class VendorInformationPage extends WebDriverUtility {
	//Initialization
	WebDriver driver;
	public VendorInformationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//declaration
	@FindBy(xpath = "//*[text()='Vendors']")
	private WebElement vendorPageTitle;
	
	@FindBy(linkText = "Lenovo Smart Care")
	private WebElement vendorName;
	
	@FindBy(xpath = "//*[text()='Creating New Purchase Order']")
	private WebElement purchaseOrderPageTitle;


	//getters method
	public WebElement getPageTitle() {
		return vendorPageTitle;
	}

	public WebElement getVendorName() {
		return vendorName;
	}
	
	//Business logic
	public void selectVendor() {
		vendorName.click();
	}

	

}
