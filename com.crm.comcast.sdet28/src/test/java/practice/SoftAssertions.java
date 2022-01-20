package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	@Test
	public void softAssert() {
	
		String expected = "Tom";
		String actual = "Harry";
		
		Reporter.log(actual, true);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		
		sa.assertAll();
		
	}

}
