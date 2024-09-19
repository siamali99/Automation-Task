package Assignment.AutomationTask;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Assignment.AutomationTask.pageLocators.registrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class registration extends configDriver{
	registrationPage reg;
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://letcode.in/signup");
		reg= new registrationPage(driver);
	}

	
    @Test(dataProvider = "invalidRegistrationData", priority = 1, description="Test signup with sample invalid registration data")
    public void invalidRegistration(String name, String email, String password, String expectedError) throws InterruptedException {
        // Filling all the  registration details
        reg.enterRegistrationDetails(name, email, password);
        //Clicking the agree checkbox
        reg.clickAgree();
        reg.clickSignup();
        Thread.sleep(2000);
        //Getting the error messages and checking the messages are correct
        Assert.assertTrue(reg.isErrorMessageDisplayed(expectedError), "Error message did not match");
    }
    
	@Test(priority = 2, description="Test signup with sample valid registration data")
	public void validRegistration() throws InterruptedException {
		reg.enterRegistrationDetails("Siam", "siamali14999@gmail.com", "12345678");
		reg.clickAgree();
		reg.clickSignup();
		Thread.sleep(2000);
		//Checking after succesfull signup it takes us to the right page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://letcode.in/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL didn't match after signup");
	}

    //Giving sample invalid registration data using data provider
    @DataProvider(name = "invalidRegistrationData")
    public Object[][] getRegistrationData() {
        return new Object[][]{
            {"Siam", "", "879654", "×\n"+ "Error: The email address is badly formatted."},                      
            {"Siam", "testads", "879654", "×\n"+ "Error: The email address is badly formatted."},            
            {"Siam", "testads@gmail.com", "", "×\n"+ "Error: The password must be 6 characters long or more."},      
            {"Siam", "testads@gmail.com", "123", "×\n"+ "Error: Password should be at least 6 characters"}     
        };
    }
	
}
