package parallel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverfactory.BrowserType;
import driverfactory.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
//import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import utilitiesFiles.CommonUtilities;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/parallel/InvalidSignIn.feature",
glue = { "parallel" },
monochrome = true,  
plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }, 
publish = true)

//@Listeners({ExtentITestListenerClassAdapter.class})
//https://www.programsbuzz.com/article/cucumber-testng-extent-report-using-adapter(for testng extent report)
public class VisiCheckRunner extends AbstractTestNGCucumberTests {

	// System.out.println("===============================================" );

	

  public static WebDriver driver; 
  public static WebDriver driver2;
  
  public static String Device_name; 
  private static List<WebDriver> driverPool =   new ArrayList<WebDriver>();
  
  @BeforeSuite
  void setUpSuite() { 
	  
  WebDriverManager.chromedriver().setup();
  WebDriverManager.firefoxdriver().setup();
  WebDriverManager.edgedriver().setup();
  }
  
  public static WebDriver getDriver(BrowserType type) { 
	  
  driver = DriverFactory.getInstance().getDriver(type);
  driverPool.add(driver);
  driver.manage().window().maximize(); 
  return driver; 
  }
  
  public static WebDriver getDriver1() { 
	  driver = DriverFactory.getInstance().getDriver1(); 
	  driverPool.add(driver); 
	  return driver; 
	  }
  
  @BeforeMethod
  
  @Parameters("browser") 
  public void config_driver(String browser) throws   IOException { 
	  // String device = Config.projectconfig_Values("Browser");
 
//  File dir = new File(System.getProperty("user.dir") +
 // Config.config_Values("ScreenShots")); if (dir.isDirectory()){ dir.delete();
  //File newDir = new File(Config.config_Values("Reportpath")+"//screenshots");
  //newDir.mkdir(); }
  
  //CommonUtilities.getInstance().initWebElements(); // testEnvironment =
  //ConfigFactory.create(Environment.class);
	  if  (browser.equalsIgnoreCase("chrome")) {
		//  PageObjectAddToCart.CartInstance=null;
		  Device_name=browser;
  getDriver(BrowserType.CHROME);

 
  }
	  else if (browser.equalsIgnoreCase("firefox"))
  {
		//  PageObjectAddToCart.CartInstance=null;
		  Device_name=browser;
		  getDriver(BrowserType.FIREFOX);
		
		  } 
	  else if (browser.equalsIgnoreCase("edge"))
  {
		//  PageObjectAddToCart.CartInstance=null;
		  Device_name=browser;
		  getDriver(BrowserType.Edge);
		
		  } 
	  }
  
  @Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();

	}

 
	  
	  @AfterSuite
		public void Report() throws Exception {
			if (driver != null)
			{
				for (WebDriver webDriver : driverPool) {
					//webDriver.quit();
				}
			}
		}

}
  
/*  @BeforeClass(alwaysRun = true) public void setUpClass() {
  System.out.println("===============================================" +
  "Test Suit Execution Started==============================================="
  );
  
  }
  
  
  
  @AfterClass(alwaysRun = true) public void tearDownClass() {
  System.out.println("===============================================" +
  "Test Suit Execution Completed==============================================="
  );
  
  }*/
//@AfterSuite public void Report() throws Exception { if (driver != null) { 
	  /*for
  }
  (WebDriver webDriver : driverPool) {
  //SendEmail.sendEmailBody(Testdata.Email.EMAIL_RESULT_SUBJECT,
  "cucumber-json-report-Sanity"); //webDriver.quit(); } } }
  
  */
   
 