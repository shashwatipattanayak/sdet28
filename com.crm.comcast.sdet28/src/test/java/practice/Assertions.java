package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	
	@Test
	public void hardAssert() {
		System.out.println("Launch the browser");
		System.out.println("Login to application");
		System.out.println("Create organization");
		
		int a = 10;
		int b = 10;
		Assert.assertEquals(a, b);
		
		int[] arr1 = {1,2,2,3,3,3};
		int[] arr2 = {1,2,3,4};
		Assert.assertEquals(arr1, arr2);
		
		String actual = "Tom";
		String expected = "Harry";
		Assert.assertEquals(actual, expected);
		
		System.out.println("Log out from the application");
		System.out.println("Quit the browser");
	}

}
