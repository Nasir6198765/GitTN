package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Locating the Web Elements
	By myAccountDp = By.xpath("//span[text()='My Account']");
	By registerOption = By.xpath("//a[text()='Register']");
	By loginOption = By.xpath("//a[text()='Login']");

	// Right side Buttons common for all
	By register_RSBtn = By.xpath("//a[text()='Register'][@class='list-group-item']");
	By login_RSBtn = By.xpath("//a[text()='Login'][@class='list-group-item']");
	By forgetPass_RSBtn = By.xpath("//a[text()='Forgotten Password'][@class='list-group-item']");
	By myAcc_RSBtn = By.xpath("//a[text()='My Account'][@class='list-group-item']");
	By addressBook_RSBtn = By.xpath("//a[text()='Address Book'][@class='list-group-item']");
	By wishList_RSBtn = By.xpath("//a[text()='Wish List'][@class='list-group-item']");
	By orderHys_RSBtn = By.xpath("//a[text()='Order History'][@class='list-group-item']");
	By download_RSBtn = By.xpath("//a[text()='Downloads'][@class='list-group-item']");
	By payments_RSBtn = By.xpath("//a[text()='Recurring payments'][@class='list-group-item']");
	By rewards_RSBtn = By.xpath("//a[text()='Reward Points'][@class='list-group-item']");
	By transaction_RSBtn = By.xpath("//a[text()='Transactions'][@class='list-group-item']");
	By newsLetter_RSBtn = By.xpath("//a[text()='Newsletter'][@class='list-group-item']");

	// Action on Web Elements
	public void clickOnMyAccDropMenu() {
		driver.findElement(myAccountDp).click();
	}

	public RegisterPage clickOnRegisterOption() {
		driver.findElement(registerOption).click();
		return new RegisterPage(driver);
	}

	public LoginPage clickOnLoginOption() {
		driver.findElement(loginOption).click();
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterRightSideButton() {
		driver.findElement(register_RSBtn).click();
		return new RegisterPage(driver);
	}

	public ForgottenPasswordPage clickOnForgottenPasswordRightSideButton() {
		driver.findElement(forgetPass_RSBtn).click();
		return new ForgottenPasswordPage(driver);
	}

	public MyAccountPage clickOnMyAccountRightSideButton() {
		driver.findElement(myAcc_RSBtn).click();
		return new MyAccountPage(driver);
	}

	public void clickOnBookAddressRightSideButton() {
		driver.findElement(addressBook_RSBtn).click();

	}

	public void clickOnPaymentRightSideButton() {
		driver.findElement(payments_RSBtn).click();

	}

	public void clickOnOrderHystoryRightSideButton() {
		driver.findElement(orderHys_RSBtn).click();

	}

	public void clickOnWishListRightSideButton() {
		driver.findElement(wishList_RSBtn).click();

	}

	public boolean isMyAccDpMenuEnabled() {
		boolean text = driver.findElement(myAccountDp).isEnabled();

		return text;
	}
}
