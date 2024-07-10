package stepDefinitions;




import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import factory.driverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;


public class Login {
	
	driverFactory driverfactory;
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;

	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		driverfactory = new driverFactory();
		driver = driverfactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	
	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String emailText) {
		loginpage.enterEmailAddress(emailText);

	}
	
	@And("^User enters valid password (.+)$")
	public void user_enters_valid_password(String pwordText) {
		loginpage.enterPassword(pwordText);
	}
	
	@When("user clicks on Login Button")
	public void user_clicks_on_login_button() {
		accountpage = loginpage.clickLoginButton();
	}
	
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformation());
	}
	
	@When("User enters invalid email address {string}")
	public void user_enters_invalid_email_address(String emailText) {
		loginpage.enterEmailAddress(emailText);
	}

	@When("User enters invalid password {string}")
	public void user_enters_invalid_password(String pwordText) {
		loginpage.enterPassword(pwordText);
	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
		loginpage.verifyLoginWarningMessage();
	}

	@When("User dont enter email address")
	public void user_dont_enter_email_address() {
		
	}

	@When("User dont enter password")
	public void user_dont_enter_password() {


	}

	
}
