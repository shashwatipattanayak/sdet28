package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcastObjectRepository.HomePage;
import com.crm.comcastObjectRepository.LoginPage;
/**
 * BaseClass with contains all the configuration annotations
 * @author Shashwati Pattanayak
 *
 */
public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	//Object creation for utilities
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	/**
	 * This method will connect you with the database
	 */
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		//Connection to database
		System.out.println("====Connect to DB====");
	}
	
	//@Parameters("browser")
	/**
	 * This method will launch the browser
	 * @throws Throwable
	 */
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		//Getting the data from property file
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		//Launching the browser
		if(browser.equals("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser is not supported");
		}
		
		sdriver = driver;
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);		
	}
	
	/**
	 * This method will log in to application
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		//Logging in to the application 
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
	}
	
	/**
	 * This method will logout of the application
	 */
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		//logging out of the application
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}
	
	/**
	 * This method will close/ quit the browser
	 */
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		//Quitting/ closing the browser
		driver.quit();	
	}
	
	/**
	 * This method will close the database connection
	 */
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
		//Closing the database connection
		System.out.println("====Close the connection to DB====");
	}
	

}
