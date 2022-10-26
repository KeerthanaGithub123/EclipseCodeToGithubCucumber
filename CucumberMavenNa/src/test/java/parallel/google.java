package parallel;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriverManager.DriverManager;

public class google extends VisiCheckRunner {
	WebDriver driver = getDriver1();
	@When("User enters the designated URL in the browser")
	public void user_enters_the_designated_url_in_the_browser() {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Then("the google has to opened in the driver")
	public void the_google_has_to_opened_in_the_driver() {
		
		System.out.println("Google URL is launched");
	}
}
