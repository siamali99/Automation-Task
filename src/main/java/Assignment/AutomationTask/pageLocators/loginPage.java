package Assignment.AutomationTask.pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-signin[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/p[1]/button[1]")
	private WebElement loginButton;
	
	public void enterCredentials(String user,String pass) {
		email.sendKeys(user);
		password.sendKeys(pass);
	}
	public void clickLogin() {
		loginButton.click();
	}
}
