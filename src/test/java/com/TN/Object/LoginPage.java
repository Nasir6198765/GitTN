package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By email = By.name("email");
	By password = By.name("password");
	By loginBt = By.xpath("//input[@value='Login']");
	By warnMassage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	By forgotLink = By.xpath("//a[text()='Forgotten Password']");
	By continueBtn = By.xpath("//a[text()='Continue']");

	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public MyAccountPage clickOnLoginButton() {
		driver.findElement(loginBt).click();
		return new MyAccountPage(driver);
	}

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getwarnMassagEmailNotMatch() {
		String massage = driver.findElement(warnMassage).getText();
		return massage;
	}

	public ForgottenPasswordPage clickOnForgottenPasswordLink() {
		driver.findElement(forgotLink).click();
		return new ForgottenPasswordPage(driver);
	}

	public Boolean IsForgottenLinkDisplayed() {
		Boolean link = driver.findElement(forgotLink).isDisplayed();
		return link;
	}

	public String getEmailText() {
		String massage = driver.findElement(email).getText();
		return massage;
	}

	public String getPassText() {
		String massage = driver.findElement(password).getText();
		return massage;
	}

	public String getEmailFieldAtrribute(String mail) {
		String text = driver.findElement(email).getAttribute(mail);
		return text;
	}

	public String getPasswordFielsAtrribute(String pass) {
		String text = driver.findElement(password).getAttribute(pass);
		return text;
	}

	public RegisterPage clickOnContinueButton() {
		driver.findElement(continueBtn).click();
		return new RegisterPage(driver);
	}

	public boolean isForgottenPasswordLinkEnabled() {
		boolean text = driver.findElement(forgotLink).isEnabled();
		return text;
	}
	
}
