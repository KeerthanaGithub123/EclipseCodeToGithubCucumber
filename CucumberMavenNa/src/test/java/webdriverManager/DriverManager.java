package webdriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
//if I right click on driver and Go to Source and Slelect "Getters and Setters" and the below method is displayed 
public static WebDriver getDriver() {
		return driver;
	}

private static Logger LOGGER=LogManager.getLogger(DriverManager.class);

private static WebDriver driver=null;
//private static WebDriver driver;

	public static void launchBrowser(String browser) {
		
		LOGGER.info("DriverManager class to lauch the browser");
		try
		{
			//fill the proper browser
			//the values of the constants class are used everywhere
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
							
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				//	LOGGER.info("Launching"+Constants.Browser);
					driver=new EdgeDriver();
				
			}
			
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				//	LOGGER.info("Launching"+Constants.Browser);
					driver=new FirefoxDriver();
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
}
}
