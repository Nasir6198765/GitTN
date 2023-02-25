package com.TN.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TN.Bases.Base;
import com.TN.Object.HomePage;
import com.TN.Object.LoginPage;
import com.TN.Object.MyAccountPage;

public class LoginTest extends Base {

	@Test(priority = 1)
	public void verifyLoggingWithValidCredentails() throws InterruptedException {
		log.info("verifyLoggingWithValidCredentails");
		test = report.createTest("verifyLoggingWithValidCredentails");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		LoginPage lgp = hmp.clickOnLoginOption();
		log.info("clickOnLoginOption");
		Assert.assertEquals(lgp.getLoginPageTitle(), "Account Login");
		lgp.enterEmail("nasirkhanp93@gmail.com");
		log.info("enterEmail");
		lgp.enterPassword("8421");
		log.info("enterPassword");
		MyAccountPage map = lgp.clickOnLoginButton();
		log.info("clickOnLoginButton");
		Assert.assertEquals(map.getMyAccPageTitle(), "My Account");
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		Assert.assertEquals(map.getLogoutOptionText(), "Logout");

	}

	@Test(priority = 2, groups = "smoke")
	public void verifyLoggingWithInValidCredentials() throws InterruptedException {
		log.info("verifyLoggingWithInValidCredentials");

		test = report.createTest("verifyLoggingWithInValidCredentials");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		LoginPage lgp = hmp.clickOnLoginOption();
		log.info("clickOnLoginOption");
		lgp.enterEmail("KJMnasirKhanp93@gmail.com");
		log.info("enterEmail");
		lgp.enterPassword("KJM8421");
		log.info("enterPassword");
		lgp.clickOnLoginButton();
		log.info("clickOnLoginButton");
		Assert.assertEquals(lgp.getwarnMassagEmailNotMatch(), "Warning: No match for E-Mail Address and/or Password.");
	}

//	@Test(priority = 3, groups = "sanity")
//	public void verifyLoggingWithInValidEmailAndValidPasswod() throws InterruptedException {
//
//		test = report.createTest("verifyLoggingWithInValidEmailAndValidPasswod");
//		log.info("verifyLoggingWithInValidEmailAndValidPasswod");
//		HomePage hmp = new HomePage(driver);
//		Thread.sleep(5000);
//		hmp.clickOnMyAccDropMenu();
//		log.info("clickOnMyAccDropMenu");
//		LoginPage lgp = hmp.clickOnLoginOption();
//		log.info("clickOnLoginOption");
//		lgp.enterEmail("KJMnasirKhanp93@gmail.com");
//		log.info("enterEmail");
//		lgp.enterPassword("8421");
//		log.info("enterPassword");
//		lgp.clickOnLoginButton();
//		log.info("clickOnLoginButton");
//		Assert.assertEquals(lgp.getwarnMassagEmailNotMatch(), "Warning: No match for E-Mail Address and/or Password.");
//	}
//
//	@Test(priority = 4)
//	public void verifyLoggingWithValidEmailAndInValidPasswod() throws InterruptedException {
//
//		test = report.createTest("verifyLoggingWithValidEmailAndInValidPasswod");
//		HomePage hmp = new HomePage(driver);
//		Thread.sleep(5000);
//		hmp.clickOnMyAccDropMenu();
//		log.info("clickOnMyAccDropMenu");
//		LoginPage lgp = hmp.clickOnLoginOption();
//		log.info("clickOnLoginOption");
//		lgp.enterEmail("nasirKhanp93@gmail.com");
//		log.info("enterEmail");
//		lgp.enterPassword("KJM8421");
//		log.info("enterPassword");
//		lgp.clickOnLoginButton();
//		log.info("clickOnLoginButton");
//		Assert.assertEquals(lgp.getwarnMassagEmailNotMatch(), "Warning: No match for E-Mail Address and/or Password.");
//	}
//
//	@Test(priority = 5)
//	public void verifyLoggingWithoutCredentials() {
//
//		test = report.createTest("verifyLoggingWithoutCredentials");
//		HomePage hmp = new HomePage(driver);
//		hmp.clickOnMyAccDropMenu();
//		log.info("clickOnMyAccDropMenu");
//		LoginPage lgp = hmp.clickOnLoginOption();
//		log.info("clickOnLoginOption");
//		lgp.clickOnLoginButton();
//		log.info("clickOnLoginButton");
//		Assert.assertEquals(lgp.getwarnMassagEmailNotMatch(), "Warning: No match for E-Mail Address and/or Password.");
//	}
//
//	@Test(priority = 6)
//	public void verifyForgottenPasswordLinkAvailableAndWorking() {
//
//		test = report.createTest("verifyForgottenPasswordLinkAvailableAndWorking");
//		HomePage hmp = new HomePage(driver);
//		hmp.clickOnMyAccDropMenu();
//		log.info("clickOnMyAccDropMenu");
//		LoginPage lgp = hmp.clickOnLoginOption();
//		log.info("clickOnLoginOption");
//		Assert.assertTrue(lgp.IsForgottenLinkDisplayed());
//		lgp.clickOnForgottenPasswordLink();
//		log.info("clickOnForgottenPasswordLink");
//		Assert.assertTrue(lgp.isForgottenPasswordLinkEnabled());
//	}
//
//	@Test(priority = 7)
//	public void verifyPlaceHolderAvailableOnEmailAndPasswordFields() {
//
//		test = report.createTest("verifyPlaceHolderAvailableOnEmailAndPasswordFields");
//		HomePage hmp = new HomePage(driver);
//		hmp.clickOnMyAccDropMenu();
//		log.info("clickOnMyAccDropMenu");
//		LoginPage lgp = hmp.clickOnLoginOption();
//		log.info("clickOnLoginOption");
//		Assert.assertEquals(lgp.getEmailFieldAtrribute("placeholder"), "E-Mail Address");
//		Assert.assertEquals(lgp.getPasswordFielsAtrribute("placeholder"), "Password");
//	}

}
