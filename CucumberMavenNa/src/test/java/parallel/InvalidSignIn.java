package parallel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantsFiles.Constants;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectsFiles.PageObjectAddToCart;
//import webdriverManager.DriverManager;

public class InvalidSignIn extends VisiCheckRunner {

	WebDriver driver = getDriver1();

	private static Logger LOGGER = LogManager.getLogger(AddItemToCart.class);

	PageObjectAddToCart pageObjectAddToCart;
	
	@Then("it shows a failed error message {string}")
	public void it_shows_a_failed_error_message(String expToastMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		errorMessage.getText();
		String actualToastMessage = errorMessage.getText();
		
		//Assert.assertEquals(expToastMessage, actualToastMessage);

		if (expToastMessage.equals(actualToastMessage)) {
			System.out.println("===================================="
					+ "Incorrect email and password. The scenario is PASSED"
					+ "====================================");
		} else {
			System.out.println("===================================="
					+ "Incorrect email and password is not displayed The scenario is FAILED"
					+ "====================================");

	
}
}
}