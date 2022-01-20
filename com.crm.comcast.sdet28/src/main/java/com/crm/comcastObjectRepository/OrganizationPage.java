package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Organization page POM design
 * @author Shashwati Pattanayak
 *
 */
public class OrganizationPage {
	//initializataion
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgPlusImage;
	
	//getters method
	public WebElement getCreateOrgPlusImage() {
		return createOrgPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on createOrg plus image 
	 */
	public void clickCreateOrgImg() {
		createOrgPlusImage.click();
	}
	

}
