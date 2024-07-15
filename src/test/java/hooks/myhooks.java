package hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class myhooks {
	
	WebDriver driver;
	driverFactory driverfactory;
	
	@Before
	public void setup() {
		
		Properties prop = configReader.intializeProperties();
		
		driverfactory = new driverFactory();
		driver = driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
//	@Before
//	public void setup() {
//		driverfactory = new driverFactory();
//		driver = driverfactory.initializeBrowser("chrome");
//		driver.get("https://tutorialsninja.com/demo/index.php?");
//	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}

}
