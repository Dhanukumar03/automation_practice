import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\test\\resources\\features" }, 
	glue = { "stepdefinition" }, 
	tags = "", plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json" }

)
public class testrunner extends AbstractTestNGCucumberTests {

}
