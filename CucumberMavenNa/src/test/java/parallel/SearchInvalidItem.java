package parallel;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectsFiles.PageObjectAddToCart;

public class SearchInvalidItem extends VisiCheckRunner {
	WebDriver driver = getDriver1();
	PageObjectAddToCart pageObjectAddToCart;
	@When("User search the Invalid Item {string} at add to Cart")
	public void user_search_the_invalid_item_at_add_to_cart(String SearchItem) throws InterruptedException {
		Thread.sleep(3000);
			pageObjectAddToCart = new PageObjectAddToCart(driver);
			Thread.sleep(3000);
			pageObjectAddToCart.SearchText.sendKeys(SearchItem);
						
			}

	
	
	@When("User view the message that Showing No results found")
	public void user_view_the_message_that_showing_no_results_found() throws InterruptedException {
		
		
			Thread.sleep(3000);
				boolean productCount=	pageObjectAddToCart.ShowResults.isDisplayed();
				if(productCount==true)
				{
					System.out.println("Searched Item is not found. Please Search Another product");
				}
				else
				{
					System.out.println("Item Searched is in Cart. Please proceed.");
				}
					
	}


	
}
