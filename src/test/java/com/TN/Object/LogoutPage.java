package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By continueBtn = By.xpath("//a[text()='Continue']");

	public HomePage clickOnContinueButton() {
		driver.findElement(continueBtn).click();
		return new HomePage(driver);
	}

}
