package parallel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.core.appender.FileManager;

//import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObjects.Forgotpas;
import pageObjectsFiles.PageObjectAddToCart;
//import utilities.ExcelReader;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
//import pageObjects.Forgotpas;
//import utilities.ExcelReader;

public class ForgetPassword extends VisiCheckRunner
{
    WebDriver driver=getDriver1();

	
	PageObjectAddToCart pageObjectAddToCart;

	/*
	 * public void setup() throws IOException {
	 * 
	 * Properties configProp = new Properties(); FileInputStream configPropFile =
	 * new FileInputStream(
	 * "C:\\Projects\\signet-projects\\Newp\\src\\test\\resources\\config\\config.properties"
	 * ); configProp.load(configPropFile);
	 * 
	 * logger = Logger.getLogger("Newp2"); // logger=Logger.getLogger("Newp");
	 * 
	 * PropertyConfigurator.configure("Log4j.properties"); String brw =
	 * configProp.getProperty("browser"); if (brw.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * configProp.getProperty("chromepath")); driver = new ChromeDriver(); } else if
	 * (brw.equals("firefox")) { System.setProperty("webdriver.Firefox.driver",
	 * configProp.getProperty("firefox")); driver = new FirefoxDriver(); }
	 */

	

	
	@Given("User enters website through URL https:\\/\\/rahulshettyacademy.com\\/client\\/auth\\/login")
	public void user_enters_website_through_url_https_rahulshettyacademy_com_client_auth_login() {
//we are including the code in try catch block to include screenshot utility
		System.out.println("Checking first part");
		try {
			
			driver.get("https://rahulshettyacademy.com/client/");
			driver.manage().window().maximize();
			pageObjectAddToCart= new PageObjectAddToCart(driver);
			pageObjectAddToCart.frgtpwd.click();
			
		} catch (Exception e) {
			
		
		}
	}
	
	@When("User fill the emailID and Password and confirm password from given Sheet name {string} and row number {string} and row number {string} to login to the Application")
	public void user_fills_the_email_id_and_password_and_confirm_password_from_given_sheet_name_and_row_number_to_login_to_the_application(String EmailID, String password, String confirmpwd) throws InterruptedException {
		
		pageObjectAddToCart.email.sendKeys(EmailID);
		pageObjectAddToCart.pass.sendKeys(password);
		pageObjectAddToCart.confirmpass.sendKeys(confirmpwd);
		Thread.sleep(4000);
		pageObjectAddToCart.savenewpwd.click();
		
	}
	  
	  
	  
	  @Then("close the browser") public void close_the_browser() {
		  driver.close();
	  
	  }
	 

}
