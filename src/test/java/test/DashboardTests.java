package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DashboadPage;
import pages.logInPage;
import utils.BaseClass;
import utils.CommonMethods;
import utils.ConfigReader;

public class DashboardTests {

	BaseClass base;

	@BeforeMethod
	@Parameters({"browser"})
	public void initialTest(String browser) {
		base = new BaseClass();
		BaseClass.initialSetup(browser);

	}

	@Test
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

	@AfterMethod
	public void closingTest() {
		base.teardown();
	}

}
