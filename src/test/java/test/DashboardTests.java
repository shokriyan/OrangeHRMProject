package test;

import org.testng.Assert;

import pages.DashboadPage;
import pages.logInPage;
import utils.BaseClass;
import utils.CommonMethods;
import utils.ConfigReader;

public class DashboardTests {
	
	BaseClass base ; 
	
	public void initialTest() {
		base = new BaseClass(); 
		BaseClass.initialSetup("ghost");
		
	}
	
	public void VerifyLoggedUser() {
		ConfigReader config = new ConfigReader(); 
		
		String getUser = config.getUserName();
		String getpass = config.getPassword();
		logInPage login = new logInPage();
		CommonMethods.sendFieldValue(login.userName, getUser);
		CommonMethods.sendFieldValue(login.password, getpass);
		CommonMethods.clickOnButtons(login.logInButton);
		DashboadPage dash = new DashboadPage();
		String actualUser = dash.getLoggedUser();
		
		Assert.assertEquals(actualUser, getUser);
	}

}
