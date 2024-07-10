package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementutils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(name = "email")
	private WebElement emailInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement loginWarningMessage; 
	
	public void enterEmailAddress(String emailText)
	{
		elementutils.typeTextIntoElement(emailInput, emailText, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText)
	{
		elementutils.typeTextIntoElement(passwordInput, passwordText, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage clickLoginButton() {
		elementutils.clickOnElement(loginButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public void verifyLoginWarningMessage() {
		elementutils.displayStatusOfElement(loginWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
