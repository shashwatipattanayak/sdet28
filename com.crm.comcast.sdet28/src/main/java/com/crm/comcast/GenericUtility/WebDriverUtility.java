package com.crm.comcast.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriver utility class
 * @author Shashwati Pattanayak
 *
 */
public class WebDriverUtility {
	/**
	 * It will take 20 seconds till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * The method will wait till the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * The method will wait till element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));	
		element.click();
	}
	/**
	 * this method is used to wait for element and do click option
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count = 0;
		while(count < 50) {
			try {
				element.click();
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method will select the element based on index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will select the element based on value
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select the value based on visible text
	 * @param text
	 * @param element
	 */
	public void selectOption(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will verify whether expected option is present in drop down list or not
	 * @param element
	 * @param expectedOptions
	 * @return
	 */
	public WebElement verifyTheDropDownList(WebElement element, String expectedOptions) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement ele : options) {
			if(ele.equals(expectedOptions)) {
				System.out.println("Value is present in the dropdown");
				return ele;	
			}else {
			System.out.println("Value is not present in the dropdown");
			return ele;
		}
	}
	return null;
	}
	/**
	 * This method performs mouse hovering action	
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method performs right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * Used to perform java script click on web element
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
	}
	/**This method is used to send the value using java script executor
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	public void enterDataUsingJs(WebDriver driver, String valueToEnter, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+valueToEnter+"'", element);
	}
	/**
	 * This method will switch to different windows using partial title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> it = winds.iterator();
		while(it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * This method will switch the frame based on name or id passesed
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenShot(WebDriver driver, String testCaseName) {
		JavaUtility jUtil = new JavaUtility();
		String filePath = "./errorshot"+testCaseName+jUtil.getSystemDateAndTime()+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		//Files.copy(source,destination);
		source.renameTo(destination);
		return filePath;
	}
	/**
	 * This method will switch the frame based on the index passed
	 * @param driver
	 * @param index
	 */
	public void switchFrames(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame based on id passed
	 * @param driver
	 * @param nameOrId
	 */
	public void switchFrames(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will based the frame based on web element passed
	 * @param driver
	 * @param element
	 */
	public void switchFrames(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * Method will accept the alert
	 * @param driver
	 */
	public void accptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is clicked on dismiss button in alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}


}





































