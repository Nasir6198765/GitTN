package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {

	WebDriver driver;

	public ForgottenPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.name("name");
	By continueBtn = By.xpath("//input[@value='Continue']");
	By backBtn = By.xpath("//a[text()='Back']");
	By HeaderFPHL = By.xpath("//div//h1[text()='Forgot Your Password?']");


	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}

	public LoginPage clickOnContinueButton() {
		driver.findElement(continueBtn).click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnBackButton() {
		driver.findElement(backBtn).click();
		return new LoginPage(driver);
	}
	
	public String getForgottenPasswordTitle() {
		String title=driver.getTitle();
		return  title;
	}
	public String getForgottenPasswordHeadLines() {
		String header=driver.findElement(HeaderFPHL).getText();
		return  header;
	}
	


}
