package Assignment.AutomationTask;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Assignment.AutomationTask.pageLocators.loginPage;
import Assignment.TestUtils.configDriver;

public class login extends configDriver{
	loginPage login;
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://letcode.in/signin");
		login= new loginPage(driver);
	}
	
	@Test(priority = 1, description="Login with valid credentials")
	public void testValidLogin() throws InterruptedException {
		login.enterCredentials("siamali14999@gmail.com", "12345678");
		login.clickLogin();
		Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://letcode.in/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL didn't match after login");
	}

}
