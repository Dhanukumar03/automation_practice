package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Identity {

	WebDriver driver;

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement EmailId;

	@FindBy(id = "old_passwd")
	WebElement currentPassword;
	
	@FindBy(id = "passwd")
	WebElement newPassword;

	@FindBy(id = "confirmation")
	WebElement confirmPassword;


	@FindBy(xpath = "//button[@name='submitIdentity']")
	WebElement save;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement SuccessMessage;

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement Mr;
	
	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement Mrs;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']//li")
	WebElement errorMessage;

	public Identity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public void clickMr() {
		Mr.click();
	}
	
	public void clickMrs() {
		Mrs.click();
	}*/
	
	

	public void updateDetails(String fname, String lname, String mailId, String passwrd) {
		
		
		
		
		firstName.clear();
		firstName.sendKeys(fname);

		lastName.clear();
		lastName.sendKeys(lname);

		EmailId.clear();
		EmailId.sendKeys(mailId);

		currentPassword.sendKeys(passwrd);

	}

	public void clickSave() {
		save.click();
	}

	public String alertMessage() {

		return SuccessMessage.getText();

	}
	
	public void updatePassword(String oldpass,String newpass,String confpass) {
		currentPassword.sendKeys(oldpass);
		newPassword.sendKeys(newpass);
		confirmPassword.sendKeys(confpass);
	}
	
	public String ErrorMessage() {

		return errorMessage.getText();

	}
	
	

}
