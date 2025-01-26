package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (features = {"src/test/resources/Features"} , 
glue = { "stepDefination" }, 
plugin = { "pretty", "html:target/htmlreport.html" })


public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
