package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Purchase Order page POM design
 * @author Shashwati Pattanayak
 *
 */
public class PurchaseOrderPage {
		//Initialization
		public PurchaseOrderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//declaration
		@FindBy(xpath = "//img[@src = 'themes/softed/images/btnL3Add.gif']")
		private WebElement createPurchaseOrderPlusImage;
		
		//getters method
		public WebElement getCreatePurchaseOrderPlusImage() {
			return createPurchaseOrderPlusImage;
		}

		//business logic
		/**
		 * this method will click on createPurchaseOrder plus image 
		 */
		public void clickCreatePurchaseOrderImg() {
			createPurchaseOrderPlusImage.click();
		}
		
}
