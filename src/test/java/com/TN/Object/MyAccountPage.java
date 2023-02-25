package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
	}

	By logoutHeaderOption = By.xpath("//a[text()='Logout']");
	By myAccountHeaderOp = By.xpath("//a[text()='My Account']");
	By myAccHeadLines = By.xpath("//div//h2[text()='My Account']");
	By subscibeOpt = By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']");
	
	public LogoutPage clickOnLogoutOption() {
		driver.findElement(logoutHeaderOption).click();
		return new LogoutPage(driver);
	}

	public void getMyAccHeadLines() {
		driver.findElement(myAccHeadLines).getText();
	}

	public String getMyAccPageTitle() {
		String title=driver.getTitle();
		return title;
		
	}
	public String getLogoutOptionText() {
		String text=driver.findElement(logoutHeaderOption).getText();
		return text;
	}
	public NewsletterPage clickOnSubscribeUnsubscribeOption() {
		driver.findElement(subscibeOpt).click();
		return new NewsletterPage(driver);
	}

	public MyAccountPage myAccountDpHeaderOption() {
		driver.findElement(myAccountHeaderOp).click();
		return new MyAccountPage(driver);
	}



}
