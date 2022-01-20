package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrg {
	
	@BeforeClass
	public void bc() {
		System.out.println("Launch the browser");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("Quit the  browser");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Login to application");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("Logout of application");
	}
	
	@Test(priority = 1)
	public void organization() {
		System.out.println("Navigate to organizatio");
		System.out.println("Create organization");
		System.out.println("Verify organization");
	}
	
	@Test(priority = 2)
	public void contact() {
		System.out.println("Navigate to contact");
		System.out.println("Create contact");
		System.out.println("Verify contact");
	}
	
	@Test(priority = 3)
	public void product() {
		System.out.println("Navigate to product");
		System.out.println("Create product");
		System.out.println("Verify product");
	}

}
