package PurchaseOrderTestScript;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcastObjectRepository.CreatePurchaseOrderPage;
import com.crm.comcastObjectRepository.HomePage;
import com.crm.comcastObjectRepository.LoginPage;
import com.crm.comcastObjectRepository.PurchaseInformationPage;
import com.crm.comcastObjectRepository.PurchaseOrderPage;
/**
 * Purchase Order with DropDown
 * @author Shashwati Pattanayak
 *
 */
@Listeners(com.crm.comcast.GenericUtility.ListenerImplementationClass.class)
public class CancelledOrderDropdownStatusTest extends BaseClass {
/**
 * Purchase Order creation with status Cancelled
 * @param args
 * @throws Throwable
 */
@Test(groups = {"smokeTest"})
public void cancelledOrder() throws Throwable {
		
		//Get data from excel sheet
		 String expectedPurchaseName = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 9);
		 String status = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 2);
		 String subject = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 3);
		 String vendorName = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 4);
		 String billingAddress = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 5);
		 String shippingAddress = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 6);
		 String itemName = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 12, 7);
		 int quantity = (int) eUtil.getNumericCellData(IPathConstants.SHEET_NAME, 12, 8);
		
		//create purchase order
		HomePage homePage = new HomePage(driver);
		homePage.clickPurchaseOrder();
				
		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);
		purchaseOrderPage.clickCreatePurchaseOrderImg();
				
		CreatePurchaseOrderPage createPurchaseOrderPage = new CreatePurchaseOrderPage(driver);
		createPurchaseOrderPage.createPurchaseOrder(quantity, subject, vendorName, status, billingAddress, shippingAddress, itemName);				
		
		PurchaseInformationPage purchaseInfoPage = new PurchaseInformationPage(driver);
		String actualPurchaseName = purchaseInfoPage.getPurchaseInformationText();
		
		//verification
		Assert.assertEquals(actualPurchaseName.contains(expectedPurchaseName), true);

	}

}
