package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	    WebDriver driver;

	    // Locators
	    @FindBy(id = "email")
		WebElement emailField;

		@FindBy(id = "pass")
		WebElement passwordField;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(By.id("send2")).click();
	    }

}
