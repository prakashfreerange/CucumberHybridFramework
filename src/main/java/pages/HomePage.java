package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;


public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption; 
	
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchInputField; 
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	public void clickOnMyAccount() {
		elementutils.clickOnElement(myAccountDropdown, 30);
	}
	
	public LoginPage selectLoginOption() {
		elementutils.clickOnElement(loginOption, 15);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementutils.clickOnElement(registerOption, 15);
		return new RegisterPage(driver);
	}

	public void enterValidProductInSearchBox(String validProductText) {
		elementutils.typeTextIntoElement(searchInputField, validProductText, 15);
	}
	
	public void enterInvalidProductInSearchBox(String inavlidProductText) {
		elementutils.typeTextIntoElement(searchInputField, inavlidProductText, 15);
	}
	
	public searchResultsPage clickSearchButton() {
		elementutils.clickOnElement(searchButton, 15);
		return new searchResultsPage(driver);
	}
}
