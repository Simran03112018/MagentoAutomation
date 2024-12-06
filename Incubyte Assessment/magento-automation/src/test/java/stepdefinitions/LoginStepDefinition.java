package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.LoginPage;

public class LoginStepDefinition {
	WebDriver driver;
	LoginPage page;
	
	String url = "https://magento.softwaretestingboard.com/";
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abc\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		page = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	@When("the user enters valid login details {string} {string}")
	public void the_user_enters_valid_login_details(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
	   page.enterEmail(email);
	   page.enterPassword(password);
	   page.clickLoginButton();
	   
	}

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		String dashboardTitle = driver.getTitle();
		Assert.assertEquals("Home Page", dashboardTitle);
		driver.quit();
	}

}
