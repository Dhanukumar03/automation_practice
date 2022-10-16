package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class Tc2_UpdatePasswordInvalid {
	
	public static WebDriver driver;
	Sign_In signin2;
	MyAccount myacc;
	Identity identity;
	ExcelReader reader ;
	screenshotGenerator reports = new screenshotGenerator();
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	@Given("user is in SignIn page")
	public void user_is_in_sign_in_page() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		reports.startTest("Tc-Update_Password_Invalid");
	}

	

	@When("user enters details in the form from given sheetNumber  {string} and rowNumber  {int}")
	public void user_enters_details_in_the_form_from_given_sheet_number_as_and_row_number_as(String sheetname,
			Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		signin2 = new Sign_In(driver);
		identity = new Identity(driver);
		myacc = new MyAccount(driver);
		reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("src\\test\\resources\\excel sheets\\updateDetails.xlsx",
				sheetname);
		String curr_mail = testData.get(rownumber).get("currentmail");
		String password = testData.get(rownumber).get("password");
		String newpasswd = testData.get(rownumber).get("newpass");
		String confpass = testData.get(rownumber).get("confirm");
		
		signin2.clickSignIn(curr_mail, password);
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
		myacc.clickPersonalInfo();
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
		identity.updatePassword(password, newpasswd, confpass);
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
		
		
		
	}
	
	@When("user clicks  save button")
	public void user_clicks_save_button() throws IOException, InterruptedException {
		identity.clickSave();
		reports.generateScreenshot(driver);
		Thread.sleep(5000);
	}

	

	@Then("user should be able to see error message {string}")
	public void user_should_be_able_to_see_error_message(String expmsg) throws InterruptedException {
		String actualmsg = identity.ErrorMessage();
		Assert.assertEquals(actualmsg, expmsg);
		reports.endTest();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
