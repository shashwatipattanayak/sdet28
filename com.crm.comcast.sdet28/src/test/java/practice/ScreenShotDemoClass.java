package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;

@Listeners(com.crm.comcast.GenericUtility.ListenerImplementationClass.class)
public class ScreenShotDemoClass extends BaseClass {
	@Test
	public void screenshot() {
		String actualOrganizationName = "Wipro";
		String expectedOrganizationName = "Tyss";
		
		Assert.assertEquals(actualOrganizationName, expectedOrganizationName);
	}

}
