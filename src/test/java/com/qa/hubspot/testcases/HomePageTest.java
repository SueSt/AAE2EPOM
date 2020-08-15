package com.qa.hubspot.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.Utils.Constants;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;


public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	
	BasePage basePage;
	LoginPage lgPage;
	HomePage hmPage;
	
	
	@BeforeTest
	public void setUp() {
		basePage= new BasePage();
		prop= basePage.init_prop();
		driver=	basePage.init_driver(prop);
		lgPage= new LoginPage(driver);
		hmPage= lgPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void getHomePageTitleTest() {
		String title= hmPage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home page title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyHomePageHeaderTextTest() {
		String header= hmPage.verifyHomePageHeaderText();
		System.out.println(header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "HomePage Header is not present");

	}
	
	@Test(priority = 3)
	public void verifyAcctmenuAvatarTest() {
	Assert.assertTrue(hmPage.verifyAcctmenuAvatar(), "Acct menu Avatar is not displayed");
		
	}
	

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
