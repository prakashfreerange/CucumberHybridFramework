package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webelement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		if(element != null)
		{
		WebElement webElement= waitForElement(element, durationInSeconds);
		webElement.click();
		}else {
			System.out.println("Element not found");
		}
	}
	
	
	public void typeTextIntoElement(WebElement element, String textToBTyped, long durationInSeconds)
	{
		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBTyped);
	}
	
	public void selectOptionInDropdown(WebElement element, String dropdownOption,long durationInSeconds) {
		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropdownOption);
	}
	
	
	// Common utils for Alert
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e){
			e.printStackTrace();
		}
		return alert;
	}
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();
	}
	
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].click();", webelement);
	}
	
	
	public void javaScriptType(WebElement element,  String textToBTyped, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].value='"+textToBTyped+"';", webelement);
	}
	
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		return webelement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}

	}
}
