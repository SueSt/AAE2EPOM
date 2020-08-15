package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	By logo = By.id("hs-nav-v4--logo");
	By navBar = By.xpath("(//div[@aria-label='HubSpot Navigation'])[1]");
	By header = By.xpath("//i18n-string[text()='Dashboard Library']");
	By acctMenuAvatar = By.cssSelector("div#account-menu-container");
	By primaryContactLink = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By secondaryContactLink = By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
	By saleslink = By.xpath("(//a[@id='nav-primary-sales-branch'])[1]");
	By dealslink= By.xpath("(//a[@id='nav-secondary-deals'])[1]");

	
	public HomePage(WebDriver driver) {
		this.driver= driver ; 
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyHomePageHeaderText() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}
	
	public boolean verifyAcctmenuAvatar() {
	 return driver.findElement(acctMenuAvatar).isDisplayed();
		
	}
	
	
	
}
