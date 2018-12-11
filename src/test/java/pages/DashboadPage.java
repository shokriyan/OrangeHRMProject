package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class DashboadPage extends BaseClass{
	
	@FindBy (how = How.ID, using = "welcome")
	public WebElement loggeduser; 
	
	@FindBy (how=How.XPATH, using = "//span[contains(text(),'Assign Leave')]")
	public WebElement asgnLv; 

	
	public DashboadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLoggedUser() {
		String user = loggeduser.getText();
		return user.substring(8);
	}
	

}
