package com.gps.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gps.qa.base.TestBase;
import com.gps.qa.pages.GoalsPage;
import com.gps.qa.pages.LoginPage;
import com.gps.qa.util.TestUtil;

public class GoalPageTest extends TestBase {

	GoalsPage goalPage;
	LoginPage loginPage;
	String sheetName="Goals";
	
	public GoalPageTest() {
		
		super();
		System.out.println("constructor");
	}
	
	@BeforeSuite
	public void beforeSuiteEx() {
		System.out.println("before suite");
	}
	
	@BeforeTest
	public void beforeTestEx() {
		System.out.println("before Test ");
	}
	@AfterTest
	public void afterTestEx() {
		System.out.println("after Test ");
	}
	@BeforeMethod
	public void setup() {
		System.out.println("before method");
		init();
		loginPage=new LoginPage();
		goalPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//goalPage=new GoalsPage();
	}
	
	@Test(priority = 1)
	public void titleValidationTest() {
		String title=goalPage.checkTitle();
		assertEquals(title, "Saumya Shukla | Goal Sheet | www.ourgoalplan.com","title not match");
	}
	
	@Test(priority = 2)
	public void goalCheckTest() {
		goalPage.navigateToGoals();
	}
	
	@Test(priority = 3)
	public void updateGoalTest() {
		goalPage.updateGoals();
	}
	
	@Test(priority = 4)
	public void userTest() {
		assertTrue(goalPage.userValidate(), "Unauthorized user");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		System.out.println("data provider");
		Object [][] data= TestUtil.getTestDataUtil(sheetName);
		return data;
	}
	
	@Test(priority = 5 , dataProvider="getTestData")
	public void addingGoalTest(String GoalDesc, String Topic) {
		goalPage.addingGoalDesc(GoalDesc, Topic);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("after method");
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuiteEx() {
		System.out.println("after suite");
	}
	
	
}
