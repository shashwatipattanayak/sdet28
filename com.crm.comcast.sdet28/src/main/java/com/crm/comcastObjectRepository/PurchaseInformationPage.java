package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Organization Information POM design
 * @author Shashwati Pattanayak
 *
 */
public class PurchaseInformationPage {
	
	//initialization
	public PurchaseInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//span[@class = 'lvtHeaderText']")
	private WebElement purchaseInfoText;

	//getter
	public WebElement getOrgInfoText() {
		return purchaseInfoText;
	}
	
	//business logic
	/**
	 *This method will return the purchase information text
	 * @return
	 */
	public String getPurchaseInformationText() {
		return purchaseInfoText.getText();
	}
	
	
	

}
