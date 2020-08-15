package com.qa.hubspot.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.Utils.Constants;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	LoginPage lgPage;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage= new BasePage();
		prop= basePage.init_prop();
		driver=	basePage.init_driver(prop);
		lgPage= new LoginPage(driver);
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title= lgPage.getLoginPageTitle();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "LoginPage title is not matched...");
		
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(lgPage.verifySignUpLink(), "Sign Up Link is not displayed....");
	
	}
	
	@Test(priority=3)
	public void doLoginTest() {
		lgPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
