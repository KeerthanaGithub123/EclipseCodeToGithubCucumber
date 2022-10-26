package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import constantsFiles.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectsFiles.PageObjectAddToCart;
import webdriverManager.DriverManager;

public class AddItemToCart extends VisiCheckRunner{

	WebDriver driver = getDriver1();

		private static Logger LOGGER = LogManager.getLogger(AddItemToCart.class);
		
PageObjectAddToCart pageObjectAddToCart;

		@Given("User enters the website through URL https:\\/\\/rahulshettyacademy.com\\/client\\/auth\\/login")
		public void user_enters_the_website_through_url_https_rahulshettyacademy_com_client_auth_login() {
	//we are including the code in try catch block to include screenshot utility
			System.out.println("Checking first part");
			try {
				
				driver.get("https://rahulshettyacademy.com/client/");
				driver.manage().window().maximize();
				
			} catch (Exception e) {
				
			
			}
		}

		@When("User fills the emailID and Password from given Sheet name {string} and row number {string} to login to the Application")
		public void user_fills_the_email_id_and_password_from_given_sheet_name_and_row_number_to_login_to_the_application(String EmailID, String Password) throws InterruptedException {
			pageObjectAddToCart= new PageObjectAddToCart(driver);
			Thread.sleep(4000);
			pageObjectAddToCart.EmailID.sendKeys(EmailID);
			pageObjectAddToCart.Password.sendKeys(Password);
			Thread.sleep(4000);
			pageObjectAddToCart.login.click();
			
		}
		
		@When("User search the item and add the Item searched {string} to the Cart for shopping")
		public void user_search_the_item_and_add_the_item_searched_to_the_cart_for_shopping(String SearchItem) throws InterruptedException {
			Thread.sleep(3000);
			pageObjectAddToCart.SearchText.sendKeys(SearchItem);
			Thread.sleep(3000);
			pageObjectAddToCart.AddToCart.click();

		}

		
		@When("User click on the Cart to view the Items added and check whether the Item searched is added to Cart")
		public void user_click_on_the_cart_to_view_the_items_added_and_check_whether_the_item_searched_is_added_to_cart() throws InterruptedException {
			Thread.sleep(3000);
			 pageObjectAddToCart.Cart.click();
				Thread.sleep(3000);
			boolean ItemStatus=pageObjectAddToCart.Checkout.isDisplayed();
				if(ItemStatus==true)
				{
					System.out.println("Searched Item Added to Cart");
				}
				else
				{
					System.out.println("Item Searched is not added to Cart");
				}
		}

		
		@Then("User click on {string} to sign out of the Application")
		public void user_click_on_to_sign_out_of_the_application(String string) throws InterruptedException {
			Thread.sleep(3000);
			pageObjectAddToCart.SignOut.click();
	}
}

