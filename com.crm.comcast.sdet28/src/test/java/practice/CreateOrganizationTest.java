package practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcastObjectRepository.CreateOrganizationPage;
import com.crm.comcastObjectRepository.HomePage;
import com.crm.comcastObjectRepository.LoginPage;
import com.crm.comcastObjectRepository.OrganizationInformationPage;
import com.crm.comcastObjectRepository.OrganizationPage;
/**
 * Create Organization Page
 * @author Shashwati Pattanayak
 *
 */
public class CreateOrganizationTest extends BaseClass {
/**
 * This method will create organization
 */
	@Test
	public void createOrganization() throws Throwable {
		
		 //Generate Random Number
		 int randomNumber = jUtil.getRandomNumber();
		 
		 //Get the data from excel sheet
		 String expectedOrganizationName = eUtil.getStringCellData("sheet1", 1, 2);
		 expectedOrganizationName = expectedOrganizationName+randomNumber;
				
		//create organization
		HomePage homePage = new HomePage(driver);
		homePage.clickOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(expectedOrganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrganizationName = orgInfoPage.getOrgInformationText();
		
		//Organization name verification
		Assert.assertEquals(actualOrganizationName.contains(expectedOrganizationName), true);
	}

}
