package stepDefinitions;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonUtils;

public class Register {
	
	driverFactory driverfactory;
	WebDriver driver;
	HomePage homepage;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	commonUtils commonutils = new commonUtils();
	
	@Given("User navigates to register account page.")
	public void user_navigates_to_register_account_page() {
		driverfactory = new driverFactory();
		driver = driverfactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmail(commonutils.generateUniqueEmail());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmpassword(dataMap.get("confirmPassword"));	
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmail(dataMap.get("email"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmpassword(dataMap.get("confirmPassword"));	
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerpage.selectPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountsuccesspage =  registerpage.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		accountsuccesspage.getAccountSuccessPageHeading();
	}

	@When("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
		registerpage.selecYesNewsLetterOption();
	}

	@Then("User account should get warning message about duplicate email")
	public void user_account_should_get_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerpage.getDuplicateEmailWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields.")
	public void user_dont_enter_any_details_into_fields() {
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmail("");
		registerpage.enterTelephone("");
		registerpage.enterPassword("");
		registerpage.enterConfirmpassword("");	
	}

	@Then("User should get warning message for all the mandatory fields.")
	public void user_should_get_warning_message_for_all_the_mandatory_fields() {
		Assert.assertTrue(registerpage.getPrivacyPolicyWarning().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastNameWarning());	
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarning());

	}

}
