package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.logInPage;
import utils.BaseClass;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTests {
	BaseClass base;
	logInPage log;

	@BeforeMethod
	public void start() {
		base = new BaseClass();
		BaseClass.initialSetup("Chrome");
	}

	@Test
	public void verifyLogIn() {
		ConfigReader config = new ConfigReader();
		log = new logInPage();
		String Uname = config.getUserName();
		String pwd = config.getPassword();
		CommonMethods.sendFieldValue(log.userName, Uname);
		CommonMethods.sendFieldValue(log.password, pwd);
		CommonMethods.clickOnButtons(log.logInButton);

	}
	
	@Test
	public void verifyLogoPresent() {
		log = new logInPage();
		boolean exist = log.logoExist();
		Assert.assertTrue(exist);
	}

	@AfterMethod
	public void finish() {
		base.teardown();

	}
}
