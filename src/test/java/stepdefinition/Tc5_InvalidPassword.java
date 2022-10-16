package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_factory.Identity;
import page_factory.MyAccount;
import page_factory.Sign_In;
import utilities.ExcelReader;
import utilities.screenshotGenerator;

public class Tc5_InvalidPassword {
	public static WebDriver driver;
	Sign_In signin1;
	MyAccount myacc;
	Identity identity;
	ExcelReader reader = new ExcelReader();
	screenshotGenerator reports = new screenshotGenerator();
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	

	@Given("user is in Sign_In page")
	public void user_is_in_sign_in_page() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		reports.startTest("Tc-invalid_password");
	}

	

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String mailId, String currpasswd) throws InterruptedException, IOException {
		signin1 = new Sign_In(driver);

		signin1.clickSignIn(mailId, currpasswd);
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

		myacc = new MyAccount(driver);
		myacc.clickPersonalInfo();
		Thread.sleep(5000);
		reports.generateScreenshot(driver);
	}
	
	@When("user enters currentpassword as {string} and newpassword as {string} and confirmpassword as {string} and clicks save")
	public void user_enters_currentpassword_as_and_newpassword_as_and_confirmpassword_as_and_clicks_save(
			String currpasswd, String newpasswd, String conpasswd) throws IOException, InterruptedException {
		identity = new Identity(driver);
		identity.updatePassword(currpasswd, newpasswd, conpasswd);
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
		identity.clickSave();
		reports.generateScreenshot(driver);
		Thread.sleep(5000);

	}

	

	@Then("it shows  error message {string}")
	public void it_shows_error_message(String expmsg) throws InterruptedException {
		String actualmsg = identity.ErrorMessage();
		Assert.assertEquals(actualmsg, expmsg);
		reports.endTest();
		reports.endReport();
		Thread.sleep(5000);
		driver.quit();
	}

	

	@Given("user  in sign_In page")
	public void user_in_sign_in_page() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
	}

	

	@When("user enters mailid as {string} and password as {string}")
	public void user_enters_mailid_as_and_password_as(String mailId, String currpasswd) throws InterruptedException, IOException {
		signin1 = new Sign_In(driver);

		signin1.clickSignIn(mailId, currpasswd);
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

		myacc = new MyAccount(driver);
		myacc.clickPersonalInfo();
		Thread.sleep(5000);
		reports.generateScreenshot(driver);
	}

	

	@When("user enters firstname as {string} and lastname as {string} and email as {string} and currentpassword as {string} and clicks save")
	public void user_enters_firstname_as_and_lastname_as_and_email_as_and_currentpassword_as_and_clicks_save(String fname, String lname, String mail, String passwd) throws IOException, InterruptedException {
		identity = new Identity(driver);
		identity.updateDetails(fname, lname, mail, passwd);
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
		identity.clickSave();
		reports.generateScreenshot(driver);
		Thread.sleep(5000);

	}

	

	@Then("it shows a error message {string}")
	public void it_shows_a_error_message(String expmsg) throws InterruptedException {
		String actualmsg = identity.ErrorMessage();
		Assert.assertEquals(actualmsg, expmsg);
		reports.endTest();
		Thread.sleep(5000);
		driver.quit();
	}

	
}
