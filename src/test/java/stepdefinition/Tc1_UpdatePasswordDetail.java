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

public class Tc1_UpdatePasswordDetail {
	public static WebDriver driver;

	Sign_In signin;
	MyAccount myacc;
	Identity identity;
	ExcelReader reader = new ExcelReader();
	screenshotGenerator reports = new screenshotGenerator();
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@Given("user is in sign_in page")
	public void user_is_in_sign_in_page() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		reports.startReport();
		reports.startTest("Tc-Update_Password_Details");
	}

	@When("a user enters details in the form from given sheetNumber  {string} and rowNumber  {int}")
	public void a_user_enters_details_in_the_form_from_given_sheet_number_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		signin = new Sign_In(driver);
		identity = new Identity(driver);
		myacc = new MyAccount(driver);
		List<Map<String, String>> testData = reader.getData("src\\test\\resources\\excel sheets\\updateDetails.xlsx",
				sheetName);
		String curr_mail = testData.get(rowNumber).get("Emails");
		String passwrd = testData.get(rowNumber).get("Password");
		String newpasswrd = testData.get(rowNumber).get("newpass");
		String confirm = testData.get(rowNumber).get("confirm");
		
		
		signin.clickSignIn(curr_mail, passwrd);
		Thread.sleep(5000);
		reports.generateScreenshot(driver);

		myacc.clickPersonalInfo();
		Thread.sleep(5000);
		reports.generateScreenshot(driver);
		identity.updatePassword(passwrd, newpasswrd, confirm);
	}

	@When("the user clicks  save button")
	public void the_user_clicks_save_button() throws IOException {
		identity.clickSave();
		reports.generateScreenshot(driver);
	}

	@Then("the user should be able to see  message {string}")
	public void the_user_should_be_able_to_see_message(String expmsg) throws InterruptedException {
		String actualmsg = identity.alertMessage();
		Assert.assertEquals(actualmsg, expmsg);
		reports.endTest();
		Thread.sleep(5000);
		driver.quit();
	}

}
