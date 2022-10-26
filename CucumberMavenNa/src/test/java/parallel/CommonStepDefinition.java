package parallel;

import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.errorprone.annotations.Var;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webdriverManager.DriverManager;

public class CommonStepDefinition {

/*	private static String scenarioName=null;

	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinition.class);

	@Before

	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution started");
		try {
			
			scenarioName = scenario.getName();
			// in singleton design pattern the user is allowed to craete only one object in
			// the class
			LOGGER.info("Instantiating the Common Utilities");

			LOGGER.info("Loading the properties file");
			CommonUtilities.getInstance().loadProperties();// if the method is static, we can use here as
															// classname.methodname
			LOGGER.info("Checking the driver is null or not");
		if (DriverManager.getDriver() == null) {
			
				LOGGER.info("Driver is null, so launching the browser");
				//below venkat coding
			PageObjectAddToCart.CartInstance=null;
				DriverManager.launchBrowser();
				CommonUtilities.getInstance().initWebElements();
			//	launchURL();
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*	private void launchURL() {
		// if this method is to be executed in all the feature files then we can write it as the method
		//this is to avoid code duplication
		DriverManager.getDriver().get(Constants.APP_URL);
		DriverManager.getDriver().manage().window().maximize();
	}*/
	//this method will be used in report when there is failure
	//this hook is useful for in extent.properties
	//screenshot will be attached only in index.html
	@AfterStep
	public void attachScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] 	screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot_Of_FailedScenario");
		}
	}

	

}
