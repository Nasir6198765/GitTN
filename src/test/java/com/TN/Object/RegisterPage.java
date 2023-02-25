package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
	}

	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By phone = By.name("telephone");
	By password = By.name("password");
	By email = By.name("email");
	By confirmPassword = By.name("confirm");
	By radioButton = By.name("newsletter");
	By privacyBox = By.name("agree");
	By continueBtn = By.xpath("//input[@value='Continue']");
	By registerButton = By.xpath("//a[text()='Register'][@class='list-group-item']");
	By warnMassageFN = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
	By warnMassageLN = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']");
	By warnMassageEM = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
	By warnMassageTP = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']");
	By warnMassageP = By.xpath("//div[text()='Password must be between 4 and 20 characters!']");
	By warnMassageCp = By.xpath("//div[text()='Password confirmation does not match password!']");
	By warnmassageTakenEmail = By.xpath("//div[text()=' Warning: E-Mail Address is already registered!']");
	By registerBreadcrumbutton = By.xpath("//a[text()='Register']");

	public void enterFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);

	}

	public void enterPhoneNumber(String phoneN) {
		driver.findElement(phone).sendKeys(phoneN);
	}

	public void enterEmail(String emailId) {
		driver.findElement(email).sendKeys(emailId);
	}

	public void enterPassword(String Pass) {
		driver.findElement(password).sendKeys(Pass);
	}

	public void enterConfirmPassword(String pass) {
		driver.findElement(confirmPassword).sendKeys(pass);
	}

	public void selectNewsLetterYesRadioButton() {
		driver.findElement(radioButton).click();
	}

	public void selectPrivacyPolicyField() {
		driver.findElement(privacyBox).click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		driver.findElement(continueBtn).click();
		return new AccountSuccessPage(driver);
	}

	public String getwarnMassageForFirstName() {
		String massage = driver.findElement(warnMassageFN).getText();
		return massage;
	}

	public String getwarnMassageForLastName() {
		String massage = driver.findElement(warnMassageLN).getText();
		return massage;
	}

	public String getwarnMassageForEmail() {
		String massage = driver.findElement(warnMassageEM).getText();
		return massage;
	}

	public String getwarnMassageForPhone() {
		String massage = driver.findElement(warnMassageTP).getText();
		return massage;
	}

	public void selectNewsLetterNoRadioButton() {
		driver.findElement(radioButton).click();
	}

	public String getRegisterPageTitle() {
		String massage = driver.getTitle();
		return massage;
	}

	public String getwarnMassageForConfirmPassword() {
		String massage = driver.findElement(warnMassageCp).getText();
		return massage;
	}

	public String getwarnMassageForPassword() {
		String massage = driver.findElement(warnMassageP).getText();
		return massage;
	}

	public String getwarnMassageForAlreadyTakenEmail() {
		String massage = driver.findElement(warnmassageTakenEmail).getText();
		return massage;
	}

	public String getEmailAttribute(String msg) {
		String massage = driver.findElement(email).getAttribute(msg);
		return massage;
	}

	public String getLastNameAttribute(String msg) {
		String massage = driver.findElement(lastName).getAttribute(msg);
		return massage;
	}

	public String getPhoneAttribute(String msg) {
		String massage = driver.findElement(phone).getAttribute(msg);
		return massage;
	}

	public String getPasswordAttribute(String msg) {
		String massage = driver.findElement(password).getAttribute(msg);
		return massage;
	}

	public String getConfirmPasswordAttribute(String msg) {
		String massage = driver.findElement(confirmPassword).getAttribute(msg);
		return massage;
	}

	public String getFirstNameAttribute(String msg) {
		String massage = driver.findElement(firstName).getAttribute(msg);
		return massage;
	}

	public RegisterPage clickOnRegisterBreadcrombButton() {
		driver.findElement(registerBreadcrumbutton).click();
		return new RegisterPage(driver);
	}

	public RegisterPage clickOnRegisterButton() {
		driver.findElement(registerButton).click();
		return new RegisterPage(driver);
	}
	
	
	
	
	
	
	

}