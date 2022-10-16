package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_In {

	WebDriver driver;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "passwd")
	WebElement Password;

	@FindBy(id = "SubmitLogin")
	WebElement Submit;
	
	public Sign_In(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignIn(String mailId, String passwrd) {
		Email.sendKeys(mailId);
		Password.sendKeys(passwrd);
		Submit.click();
	}
}
