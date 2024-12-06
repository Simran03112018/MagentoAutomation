package poms;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARegistrationPage {
	
	WebDriver driver;

    // Locators
	@FindBy(id = "firstname")
	WebElement firstNameField;

	@FindBy(id = "lastname")
	WebElement lastNameField;

	@FindBy(id = "email_address")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "password-confirmation")
	WebElement confirmpassword;

    public ARegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void confirmPassword(String cnfpassword) {
    	confirmpassword.sendKeys(cnfpassword);
    }
    
    public void validation()
    {
    	String p = passwordField.getAttribute("value");
    	String c = confirmpassword.getAttribute("value");
    	Assert.assertEquals("Passwords do not match", p, c);
    }

    public void createAccountButton() {
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
    }
}