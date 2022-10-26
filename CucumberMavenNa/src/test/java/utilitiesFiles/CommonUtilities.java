package utilitiesFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import constantsFiles.Constants;
import pageObjectsFiles.PageObjectAddToCart;
import parallel.VisiCheckRunner;
import webdriverManager.DriverManager;

public class CommonUtilities extends VisiCheckRunner {
	//if we give static we cannot create object
	//if not static we have to create object and call
	WebDriver driver = getDriver1();
	private static CommonUtilities commonUtilsInstance = null;
	private CommonUtilities()
	{
		
	}
	
	public static CommonUtilities getInstance()
	{
		
		if(commonUtilsInstance==null)
		{
			commonUtilsInstance=new CommonUtilities();
		}
		return commonUtilsInstance;
		
	}
	
	public void loadProperties() throws IOException {

	/*	FileReader reader = null;
		try
		{
		reader = new FileReader("config.properties");
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}*/
		
		Properties properties=new Properties();
		try {
			//to get the properties from config.properties file under resources folder
			properties.load(getClass().getResourceAsStream("/config.properties"));
			//if we / before config.properties means whether it is in any folder, this property file will be called
		} catch (Exception e) {
			e.printStackTrace();
		}
	/*	try
		{
		properties.load(reader);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}*/
		
		//instead of storing these as String, we are creating Constants class
		//the values from Properties file are retrieved and stored in constants
		Constants.APP_URL=properties.getProperty("APP_URL");
	//	Constants.Browser=properties.getProperty("Browser");
	//	Constants.Email=properties.getProperty("Email");
	//	Constants.Password=properties.getProperty("Password");
		Constants.Chrome_Driver_Location=properties.getProperty("Chrome_Driver_Location");//constants
		Constants.Firefox_Driver_Location=properties.getProperty("Firefox_Driver_Location");//constants
		
}
//	public void initWebElements()
	//{
		//using POM model, we have to initialise the elements(driver and the class name)
		//the webelemebts will be identified by page factory
		//pagefactory will set the values to the web elements
		//songleton desogn pattern followed here
		
		//PageFactory.initElements(driver, PageObjectAddToCart.getInstance());
	//}
	
	//Below code is not used in the framework. As we are going to include the screenshot with report so this is not used.
	//this can be used as the seperate utility
/*	public void takeScreenshot()
	{
		TakesScreenshot screenshot=(TakesScreenshot) DriverManager.getDriver();
		File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshotFile, new File(CommonStepDefinition.getScenarioName()+".png"));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
	}
	*/
	public void highlightElement(WebElement element)
	{
		JavascriptExecutor executor=(JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}
}