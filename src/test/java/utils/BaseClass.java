package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static ConfigReader config; 
	public static WebDriver driver; 
	
	public static void initialSetup(String browser) {
		
		config = new ConfigReader(); 
		
		if (browser.equalsIgnoreCase("chrome")) {
			String chromeValue = System.getProperty("user.dir")+config.getChromePath(); 
			String chromeKey = "webdriver.chrome.driver";
			System.setProperty(chromeKey, chromeValue);
			driver = new ChromeDriver(); 
		}else if (browser.equalsIgnoreCase("firefox")) {
			String fireValue = System.getProperty("user.dir")+config.getFirePath();
			String fireKey = "webdriver.gecko.driver";
			System.setProperty(fireKey, fireValue);
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ghost")) {
			
			driver = new HtmlUnitDriver();
		}else {
			throw new RuntimeException("invalid browser");
		}
		
		String baseUrl = config.getUrl(); 
		long impWait = config.getImpWait();
		long loadWait = config.getLoadWait(); 
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(loadWait, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	public static void clickableWait (WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void teardown() {
		driver.close();
	}

}
