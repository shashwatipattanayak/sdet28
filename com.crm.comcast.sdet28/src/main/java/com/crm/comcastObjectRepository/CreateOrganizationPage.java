package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Create Organization page POM design
 * @author Shashwati Pattanayak
 *
 */
public class CreateOrganizationPage {
	
	//initialization 
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//declaration
	@FindBy(name = "accountname")
	private WebElement organizationTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	//getters method
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	/**
	 * This method will create an organization
	 * @param orgName
	 */
	public void createOrganization(String orgName) {
		organizationTextField.sendKeys(orgName);
		saveButton.click();
	}
	
	
}
