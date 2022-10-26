package pageObjectsFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base_Page;
import junit.framework.Assert;
//import utilitiesFiles.CommonUtilities;
//import webdriverManager.DriverManager;

public class PageObjectAddToCart extends Base_Page {
	
	

	public static Object CartInstance;

	public PageObjectAddToCart(WebDriver driver)
	{

		super(driver);

	}

	@FindBy(id = "userEmail")
	public WebElement EmailID;
	
	@FindBy(xpath = "//a[@class='forgot-password-link']")
	public WebElement frgtpwd;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@type='password'][1]")
	public WebElement pass;
	
	@FindBy(xpath = "//input[@placeholder='Confirm Passsword']")
	public WebElement confirmpass;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement savenewpwd;

	@FindBy(id = "userPassword")
	public WebElement Password;
	
	@FindBy(xpath = "//*[@id='login']")
	public WebElement login;
	
	@FindBy(xpath = "//*[@id='sidebar']/form/div[1]/input")
	public WebElement SearchText;

	@FindBy(xpath = "//b[text()='adidas original']//parent::h5//following::button[2]")
	public WebElement AddToCart;

	@FindBy(xpath = "//label[@class='hamberger-btn']//following::ul//li[4]//button")
	public WebElement Cart;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	public WebElement Checkout;

	@FindBy(xpath = "//div[@id='res']")
	public WebElement ShowResults;

	@FindBy(xpath = "//label[@class='hamberger-btn']//following::ul//li[5]//button")
	public WebElement SignOut;
	
	}
	
	