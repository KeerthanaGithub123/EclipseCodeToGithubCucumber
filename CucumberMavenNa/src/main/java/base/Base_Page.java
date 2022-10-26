package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Base_Page {
	
	
	public WebDriver driver;
	
	public Base_Page(WebDriver driver ){
		
		this.driver = driver;
		loadElements();
	}


	public void loadElements(){
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
}
