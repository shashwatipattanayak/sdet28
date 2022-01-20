package com.crm.comcastObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * Home page POM design
 * @author Shashwati Pattanayak
 *
 */
public class HomePage extends WebDriverUtility {
	//Initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//declaration of elements
	@FindBy(linkText = "Organizations")
	private WebElement orginizationLink;
	
	@FindBy(xpath = "//img[@src ='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreOption;
	
	@FindBy (name = "Purchase Order")
	private WebElement  purchaseOrderLink;
	
	@FindBy (xpath = "//img[@src ='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutLink;
	
	//Getter method
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrginizationLink() {
		return orginizationLink;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	//business logic
	/**
	 * This method will click on organization link
	 */
	public void clickOrganizationLink() {
		orginizationLink.click();	
	}
	/**
	 * This method will click on purchase order link
	 */
	public void clickPurchaseOrder() {
		mouseHover(driver, moreOption);
		purchaseOrderLink.click();
	}
	/**
	 * This method will perform log out option
	 */
	public void logout() {
		mouseHover(driver, logoutImg);
		signOutLink.click();
	}
}
