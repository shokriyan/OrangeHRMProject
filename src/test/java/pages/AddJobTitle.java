package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class AddJobTitle extends BaseClass {
	
	@FindBy(linkText = "Admin")
	public WebElement adminPage;
	
	@FindBy(linkText = "Job")
	public WebElement jobPage;
	
	@FindBy (linkText = "Job Titles")
	public WebElement jobTtilePgae;
	
	@FindBy(id = "btnAdd")
	public WebElement btnAdd;

	@FindBy(id = "jobTitle_jobTitle")
	public WebElement jobTitle;

	@FindBy(id = "jobTitle_jobDescription")
	public WebElement jobDescription;

	@FindBy(id = "jobTitle_note")
	public WebElement jobTitleNote;
	
	@FindBy (id="btnSave")
	public WebElement btnSave;
	
	@FindBy (xpath="//table[@id='resultTable']/tbody")
	WebElement resultTable;
	
	public AddJobTitle () {
		PageFactory.initElements(driver, this);
	}

	public String getJobTitle (String jobTitleValue) {
		
		List<WebElement> rows = resultTable.findElements(By.xpath("tr/td[2]"));
		
		String getValue = null;
		for (WebElement row : rows) {
			String rowData = row.getText();
			if (rowData.contains(jobTitleValue)) {;
				getValue = rowData;
				break;
			}
		}
		return getValue;
		
	}
	
}


