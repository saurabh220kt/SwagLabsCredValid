package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;

	By Email = By.id("user-name");
	By Password = By.id("password");
	By loginBtn = By.id("login-button");
	By appLogo = By.xpath("//div[@class=\"app_logo\"]");

	public void enterusername(String Username) {

		driver.findElement(Email).sendKeys("standard_user ");
		
	}

	public void enterpassword(String Password1) {

		driver.findElement(Password).sendKeys("secret_sauce");

	}

	public void clickonLoginBtn() {

		driver.findElement(loginBtn).click();
	}

	public void isAppLogoDisplayed() {

		driver.findElement(appLogo).isDisplayed();
	}

//	public void validuserLoginandpassword(String Username, String Password1) {
//		driver.findElement(Email).sendKeys("standard_user");
//		driver.findElement(Password).sendKeys("secret_sauce");
//		driver.findElement(loginBtn).click();  
}

