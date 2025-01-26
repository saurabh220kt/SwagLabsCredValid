package stepDefination;
/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class POMLoginStepDefiniations {

	public static WebDriver driver;
	LoginPage login;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/v1/");

	}

	@When("User enter valid {string} and {string}")
	public void user_enter_valid_and(String Username, String Password1) {

		login = new LoginPage();
		login.enterusername(Username);
		login.enterpassword(Password1);

	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		login.clickonLoginBtn();

	}

	@Then("User is navigated to the saucedemo website")
	public void user_is_navigated_to_the_saucedemo_website() {
		login.isAppLogoDisplayed();

	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.close();

	}
}
*/