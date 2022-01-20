package com.crm.comcastObjectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * Purchase Order POM design
 * @author Shashwati Pattanayak
 *
 */
public class CreatePurchaseOrderPage extends WebDriverUtility{
	//initialization 
		WebDriver driver;
		public CreatePurchaseOrderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
			
		
		//declaration
		@FindBy(name = "subject")
		private WebElement subjectTextField;
		
		@FindBy(name = "vendor_name")
		private WebElement vendorNameField;
		
		@FindBy(xpath = "//img[@src = 'themes/softed/images/select.gif']")
		private WebElement vendorNameLookUp;
		
		@FindBy(name = "postatus")
		private WebElement statusDropDownField;
		
		@FindBy(name = "bill_street")
		private WebElement billingAddressTextField;
		
		@FindBy(name = "ship_street")
		private WebElement shippingAddressTextField;
		
		@FindBy(id = "productName1")
		private WebElement itemNameField;
		
		@FindBy(id = "searchIcon1")
		private WebElement itemNameLookUp;
		
		@FindBy(id = "qty1")
		private WebElement quantityTextField;
		
		@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
		private WebElement saveButton;
		
		@FindBy(xpath = "//*[text()='Vendors']")
		private WebElement vendorPageTitle;
		
		@FindBy(linkText = "Lenovo Smart Care")
		//@FindBy(id = "1")
		private WebElement vendorNameList;
		
		@FindBy(xpath = "//*[text()='Creating New Purchase Order']")
		private WebElement purchaseOrderPageTitle;
		
		@FindBy(xpath = "//*[text()='Products']")
		private WebElement itemPageTitle;

		@FindBy(linkText = "IdeaPad")
		private WebElement itemNameList;
		
		//getters method
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getSubjectTextField() {
			return subjectTextField;
		}

		public WebElement getVendorNameLookUp() {
			return vendorNameLookUp;
		}

		public WebElement getVendorPageTitle() {
			return vendorPageTitle;
		}

		public WebElement getStatusDropDownField() {
			return statusDropDownField;
		}

		public WebElement getBillingAddressTextField() {
			return billingAddressTextField;
		}

		public WebElement getShippingAddressTextField() {
			return shippingAddressTextField;
		}

		public WebElement getItemNameField() {
			return itemNameField;
		}

		public WebElement getItemNameLookUp() {
			return itemNameLookUp;
		}

		public WebElement getQuantityTextField() {
			return quantityTextField;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		
		//business logic
		
		public void statusDropDown(String status) {
				selectOption(status, statusDropDownField);
		}
		
		public void switchToVendor() {
			String partialWindowVendor = "Vendor&action";
			switchWindow(driver, partialWindowVendor);
			 vendorNameList.click();

		}
		 
		public void switchToItem() {
			String partialWindowProduct = "Products&action";
			switchWindow(driver, partialWindowProduct);
			 itemNameList.click();
		}
		 
		
		public void createPurchaseOrder(int quantity, String subject, String vendorName, String status, String billingAddress, String shippingAddress, String itemName) {
			subjectTextField.sendKeys(subject);
			vendorNameLookUp.click();
			switchToVendor();
			switchWindow(driver, "PurchaseOrder&action");
			statusDropDown(status);
			billingAddressTextField.sendKeys(billingAddress);
			shippingAddressTextField.sendKeys(shippingAddress);
			itemNameLookUp.click();
			switchToItem();
			switchWindow(driver, "PurchaseOrder&action");
			quantityTextField.sendKeys(String.valueOf(quantity));
			saveButton.click();
		}
		
		
}
