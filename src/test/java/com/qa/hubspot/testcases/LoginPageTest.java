package com.qa.hubspot.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.Utils.Constants;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest extends BasePage {

	LoginPage lgPage;

	@BeforeTest
	public void setUp() {
		driver=	init_driver("chrome");
		lgPage= new LoginPage(driver);
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title= lgPage.getLoginPageTitle();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "LoginPage title ISelect not matched...");
		
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(lgPage.verifySignUpLink(), "Sign Up Link is not displayed....");
	
	}
	
	@Test(priority=3)
	public void doLoginTest() {
		lgPage.doLogin("suest2020@gmail.com", "Sue@1234");
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
