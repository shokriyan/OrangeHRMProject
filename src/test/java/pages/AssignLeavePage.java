package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class AssignLeavePage extends BaseClass {
	
	@FindBy (how = How.ID , using = "assignleave_txtEmployee_empName")
	public WebElement empName;
	
	public AssignLeavePage() {
		PageFactory.initElements(driver, this);
	}
	

}
