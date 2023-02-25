package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage {

	WebDriver driver;

	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
	}

	// Locating the Web Elements
	By accSuccessHeadLines = By.xpath("//div//h1[text()='Your Account Has Been Created!']");
	By continueBtn=By.xpath("//a[text()='Continue']");
	
	public String getAccSuccessHeadLines()
	{
		String text=driver.findElement(accSuccessHeadLines).getText();
		return text;
	}
	
	public MyAccountPage clickOnContinueButton()
	{
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);
	}
	
	

	
	
	
	
	
	
	
	
}
