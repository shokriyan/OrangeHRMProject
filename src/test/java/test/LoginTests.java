package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.logInPage;
import utils.BaseClass;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTests {
	BaseClass base;

	@BeforeMethod
	public void start() {
		base = new BaseClass();
		BaseClass.initialSetup("Chrome");
	}

	@Test
	public void verifyLogIn() {
		ConfigReader config = new ConfigReader();
		logInPage log = new logInPage();
		String Uname = config.getUserName();
		String pwd = config.getPassword();
		CommonMethods.sendFieldValue(log.userName, Uname);
		CommonMethods.sendFieldValue(log.password, pwd);
		CommonMethods.clickOnButtons(log.logInButton);

	}

	@AfterMethod
	public void finish() {
		base.teardown();

	}
}
