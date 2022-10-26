package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
	//Singleton design pattern
	private static final DriverFactory instance = new DriverFactory();

	private DriverFactory(){
	}
	
	public static DriverFactory getInstance(){
		return instance;
	}
	
	//Factory design pattern
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

	public WebDriver getDriver(BrowserType type) {
		if (threadLocal.get() == null) {
			switch (type) {
			case CHROME:
				threadLocal.set(new ChromeDriver());
				break;
			case FIREFOX:
				threadLocal.set(new FirefoxDriver());
				break;
			case Edge:
				threadLocal.set(new EdgeDriver());
				break;
			default:
				break;
			}
		}
		return threadLocal.get();
	}
	
	public WebDriver getDriver1() {
		
		return threadLocal.get();
	}

}