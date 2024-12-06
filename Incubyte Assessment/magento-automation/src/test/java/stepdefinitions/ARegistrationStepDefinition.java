package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.ARegistrationPage;

public class ARegistrationStepDefinition {
	
	WebDriver driver;
	ARegistrationPage page;
	
	String url = "https://magento.softwaretestingboard.com/";	
	

@Given("the user is on the registration page")
public void the_user_is_on_the_registration_page() {
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abc\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	page = new ARegistrationPage(driver);
	driver.manage().window().maximize();
    
}

@When("the user enters valid details {string} {string} {string} {string} {string}")
public void the_user_enters_valid_details(String firstName, String lastName, String email, String password, String cnfpassword) {
    // Write code here that turns the phrase above into concrete actions
	if(driver.getCurrentUrl() == "https://magento.softwaretestingboard.com/#google_vignette")
	{
		driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]/div/svg/path[1]")).click();
	}
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
    page.enterFirstName(firstName);
    page.enterLastName(lastName);
    page.enterEmail(email);
    page.enterPassword(password);
    page.confirmPassword(cnfpassword);
    page.validation();
    page.createAccountButton();
}

@Then("the user should be successfully registered")
public void the_user_should_be_successfully_registered() {
    // Write code here that turns the phrase above into concrete actions
	String dashboardTitle = driver.getTitle();
	Assert.assertEquals("My Account", dashboardTitle);
    driver.quit();
}

}
