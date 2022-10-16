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

public class Tc3_UpdateUserDetails {

	public static WebDriver driver;

	Sign_In sign_in;
	MyAccount myacc;
	Identity identity;
	ExcelReader reader = new ExcelReader();
	screenshotGenerator reports = new screenshotGenerator();
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@Given("user is in signin page")
	public void user_is_in_signin_page() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		reports.startTest("Tc-Update_User_Details");
		
	}

	@When("user enters details in the form from given sheetNumber {string} and rowNumber {int}")
	public void user_enters_details_in_the_form_from_given_sheet_number_and_row_number(String sheetName,
			Integer rowNumber) throws IOException, InterruptedException, InvalidFormatException {
		
		sign_in = new Sign_In(driver);
		identity = new Identity(driver);
		myacc = new MyAccount(driver);
		List<Map<String, String>> testData = reader.getData("src\\test\\resources\\excel sheets\\updateDetails.xlsx",
				sheetName);
		String curr_mail = testData.get(rowNumber).get("currentmail");
		String fname = testData.get(rowNumber).get("firstname");
		String lname = testData.get(rowNumber).get("lastname");
		String email = testData.get(rowNumber).get("email");
		String passwrd = testData.get(rowNumber).get("password");
		//String title = testData.get(rowNumber).get("Title");

		sign_in.clickSignIn(curr_mail, passwrd);
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

		myacc.clickPersonalInfo();
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

		identity.updateDetails(fname, lname, email, passwrd);
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() throws IOException {
		identity.clickSave();
		reports.generateScreenshot(driver);
	}

	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String expmsg) throws InterruptedException {
		String actualmsg = identity.alertMessage();
		Assert.assertEquals(actualmsg, expmsg);
		reports.endTest();
		
		Thread.sleep(5000);
		driver.quit();
	}

}