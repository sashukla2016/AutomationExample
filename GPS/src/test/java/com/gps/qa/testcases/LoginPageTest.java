package com.gps.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gps.qa.base.TestBase;
import com.gps.qa.pages.GoalsPage;
import com.gps.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	GoalsPage goalPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 2)
	public void loginTest() {
		goalPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
