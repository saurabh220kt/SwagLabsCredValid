package testData;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviders {

	WebDriver driver;

	@Test(dataProvider = "loginData")
	public  void verifyLoginCredentials(String scenario, String username, String password) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		//For below code, challenges is to find xpath,which results failure in the validation. so trace carefully to avoid exception
		
		if (scenario.equals("bothcorrect")) {
			//WebElement account = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/text()[2]")); //stduser
			WebElement account = driver.findElement(By.xpath("//div[@class=\"app_logo\"]"));
			Assert.assertTrue(account.isDisplayed());
			System.out.println("Login successfully");
			driver.quit();
			
		}  else if (scenario.equals("bothcorrect")) {
			WebElement account = driver.findElement(By.xpath("//div[@class=\"app_logo\"]")); //problem user  //failed
			Assert.assertTrue(account.isDisplayed());
			System.out.println("Login successfully1");
			driver.quit();
			
		}  else if (scenario.equals("bothcorrect")) {
			WebElement account = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/text()[5]"));  //performance-glitch
			Assert.assertTrue(account.isDisplayed());
			System.out.println("Login successfully");
			driver.quit();
			
		} else if (scenario.equals("Correctpassword")) {
			String errorMessage = driver
					.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3/text()[2]")).getText();   //failed
			//Assert.assertEquals(errorMessage, "Sorry, this user has been locked out.");
			Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out."));
			driver.quit();

		} else if (scenario.equals("Correctusername")) {
			String errorMessage = driver
					.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3/text()[2]")).getText();  //failed
			//Assert.assertEquals(errorMessage, "Username and password do not match any user in this service");
			Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"));
			driver.quit();
		} 
		
		driver.quit();
	}

	@DataProvider(name = "loginData")
	public Object[][] provideLoginData() {

		return new Object[][] { { "bothcorrect", "standard_user", "secret_sauce" },  //passed
								{ "bothcorrect", "problem_user ", "secret_sauce" },  //failed
								{ "bothcorrect", "performance_glitch_user", "secret_sauce" },  //passed
								{ "Correctpassword", "locked_out_user", "secret_sauce" },  //failed
								{ "Correctusername", "standard_user", "babachauli" }    //failed

		} ;
	}

}
