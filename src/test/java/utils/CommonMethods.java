package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass{
	
	public static void sendFieldValue(WebElement element , String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public static void clickOnButtons(WebElement element) {
		clickableWait(element);
		element.click();
	}
	
	public static void clickOnlinks (String linkText) {
		WebElement element = driver.findElement(By.linkText(linkText));
		clickableWait(element);
		element.click();
	}

}
