package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstnameInputField;
	
	@FindBy(name = "lastname")
	private WebElement lastnameInputField;
	
	@FindBy(name = "email")
	private WebElement emailInputField;
	
	@FindBy(name = "telephone")
	private WebElement telephoneInputField;
	
	@FindBy(name = "password")
	private WebElement passwordInputField;
	
	@FindBy(name = "confirm")
	private WebElement confirmInputField;

	@FindBy(xpath = "//input[@type='checkbox'][@name='agree']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement yesToNewsLetter;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@name='password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public void enterFirstName(String fname)
	{
		elementutils.typeTextIntoElement(firstnameInputField, fname, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String lname)
	{
		elementutils.typeTextIntoElement(lastnameInputField, lname, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmail(String email)
	{
		elementutils.typeTextIntoElement(emailInputField, email, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephone(String telephone)
	{
		elementutils.typeTextIntoElement(telephoneInputField, telephone, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String pword)
	{
		elementutils.typeTextIntoElement(passwordInputField, pword, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterConfirmpassword(String cpword) {
		elementutils.typeTextIntoElement(confirmInputField, cpword, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacyPolicy() {
		elementutils.clickOnElement(privacyPolicyCheckbox, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	

	
	public AccountSuccessPage clickOnContinueButton() {
		elementutils.clickOnElement(continueButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void selecYesNewsLetterOption() {
		elementutils.clickOnElement(yesToNewsLetter, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getDuplicateEmailWarningMessage() {
		return duplicateEmailWarning.getText();
	}
	
	public String getPrivacyPolicyWarning() {
		return privacyPolicyWarning.getText();
	}
	
	public String getFirstNameWarning() {
		return firstNameWarningMessage.getText();
	}
	
	public String getLastNameWarning() {
		return lastNameWarningMessage.getText();
	}
	
	public String getEmailWarning() {
		return emailWarningMessage.getText();
	}
	
	public String getTelephoneWarning() {
		return telephoneWarningMessage.getText();
	}
	
	public String getPasswordWarning() {
		return passwordWarningMessage.getText();
	}
}
