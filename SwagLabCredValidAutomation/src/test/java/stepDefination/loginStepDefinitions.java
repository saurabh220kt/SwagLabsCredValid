package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Test(dataProvider="testdata")
public class loginStepDefinitions {
	
	public static WebDriver driver;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/v1/");

	}

	@When("User enter valid {string} and {string}")
	public void user_enter_valid_and(String string, String string2) {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		Boolean loginbtn = driver.findElement(By.id("login-button")).isDisplayed();
		System.out.println(loginbtn);
		driver.findElement(By.id("login-button")).click();

	}

	@Then("User is navigated to the saucedemo website")
	public void user_is_navigated_to_the_saucedemo_website() {
		Boolean logoPresent = driver.findElement(By.xpath("//div[@class=\"app_logo\"]")).isDisplayed();
		System.out.println(logoPresent + "Logo is present..!!");
		//Assert.assertEquals(true, logoPresent);

	}

	@Then("Close the browser")
	public void close_the_browser() {

		driver.close();
	}
}
