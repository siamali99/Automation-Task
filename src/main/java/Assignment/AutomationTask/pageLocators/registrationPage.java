package Assignment.AutomationTask.pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationPage {
	WebDriver driver;
	
	public registrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	private WebElement nameField;
	@FindBy(id="email")
	private WebElement emailField;
	@FindBy(id="pass")
	private WebElement passwordField;
	@FindBy(id="agree")
	private WebElement agreeCheckBox;
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-signup[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/p[1]/button[1]")
	private WebElement signupButton;

	@FindBy(id="toast-container")
	WebElement errorMessage;
	
	public void enterRegistrationDetails(String name,String email, String password) {
		
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
	}
	public void clickAgree() {
		agreeCheckBox.click();
	}
	public void clickSignup() {
		signupButton.click();
	}
	public boolean isErrorMessageDisplayed(String expectedErrorMessage) {
	    return errorMessage.getText().contains(expectedErrorMessage);
	}
}
