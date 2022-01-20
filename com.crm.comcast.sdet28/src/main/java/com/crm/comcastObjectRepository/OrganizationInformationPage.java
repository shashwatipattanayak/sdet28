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
public class OrganizationInformationPage {
	
	//initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement orgInfoText;

	//getter
	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	
	//business logic
	/**
	 *This method will return the organization information text
	 * @return
	 */
	public String getOrgInformationText() {
		return orgInfoText.getText();
	}
	
	
	

}
