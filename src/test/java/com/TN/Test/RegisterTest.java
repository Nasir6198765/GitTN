package com.TN.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TN.Bases.Base;
import com.TN.Object.AccountSuccessPage;
import com.TN.Object.HomePage;
import com.TN.Object.LoginPage;
import com.TN.Object.MyAccountPage;
import com.TN.Object.NewsletterPage;
import com.TN.Object.RegisterPage;
import com.TN.Utils.UtilFile;

public class RegisterTest extends Base {

	@Test(priority = 1, groups = "sanity")
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		test = report.createTest("verifyRegisteringAnAccountWithMandatoryFields");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clicked on My account drop menu");
		RegisterPage reg = hmp.clickOnRegisterOption();
		log.info("clicked on Register option");
		reg.enterFirstName("Nasir");
		log.info("entered First name ");
		reg.enterLastName("Khan");
		log.info("entered Last name ");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		log.info("entered Email");
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		log.info("entered phone Number");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		log.info("entered Password");
		reg.enterConfirmPassword(pass);
		log.info("entered Confirm password");
		reg.selectPrivacyPolicyField();
		log.info("selected Privacy policy");

		AccountSuccessPage asp = reg.clickOnContinueButton();
		log.info("clicked on Continue button");
		Assert.assertEquals(asp.getAccSuccessHeadLines(), "Your Account Has Been Created!");
	}

	@Test(priority = 2, groups = "smoke")
	public void verifyRegisteringAnAccountWithAllFields() {

		test = report.createTest("verifyRegisteringAnAccountWithAllFields");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		RegisterPage reg = hmp.clickOnRegisterOption();
		log.info("clickOnRegisterOption");
		reg.enterFirstName("Nasir");
		log.info("enterFirstName");
		reg.enterLastName("Khan");
		log.info("enterLastName");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		log.info("enterEmail");
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		log.info("enterPhoneNumber");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		log.info("enterPassword");
		reg.enterConfirmPassword(pass);
		log.info("enterConfirmPassword");
		reg.selectNewsLetterYesRadioButton();
		log.info("selectNewsLetterYesRadioButton");
		reg.selectPrivacyPolicyField();
		log.info("selectPrivacyPolicyField");

		AccountSuccessPage asp = reg.clickOnContinueButton();
		log.info("clickOnContinueButton");
		Assert.assertEquals(asp.getAccSuccessHeadLines(), "Your Account Has Been Created!");
		MyAccountPage accp = asp.clickOnContinueButton();
		log.info("clickOnContinueButton");
		Assert.assertEquals(accp.getMyAccPageTitle(), "My Account");

	}

	@Test(priority = 3)
	public void verifyWarningMassagesDisplayedForMandatoryFields() {
		test = report.createTest("verifyWarningMassagesDisplayedForMandatoryFields");

		log.info("verifyWarningMassagesDisplayedForMandatoryFields");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		RegisterPage reg = hmp.clickOnRegisterOption();
		log.info("clickOnRegisterOption");
		UtilFile.scrollDown(driver);
		reg.clickOnContinueButton();
		log.info("clickOnContinueButton");
		Assert.assertEquals(reg.getwarnMassageForFirstName(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(reg.getwarnMassageForLastName(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(reg.getwarnMassageForEmail(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(reg.getwarnMassageForPhone(), "Telephone must be between 3 and 32 characters!");

	}

	@Test(priority = 4)
	public void verifyRegisteringAnAccountWithYesOptionSelected() {
		test = report.createTest("verifyRegisteringAnAccountWithYesOptionSelected");

		log.info("verifyRegisteringAnAccountWithYesOptionSelected");
		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		log.info("clickOnMyAccDropMenu");
		RegisterPage reg = hmp.clickOnRegisterOption();
		log.info("clickOnRegisterOption");

		reg.enterFirstName("Nasir");
		log.info("");
		reg.enterLastName("Khan");
		log.info("enterLastName");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		log.info("enterEmail");
		UtilFile.scrollDown(driver);
		log.info("");
		reg.enterPhoneNumber("9921992184");
		log.info("enterPhoneNumber");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		log.info("enterPassword");
		reg.enterConfirmPassword(pass);
		log.info("enterConfirmPassword");
		reg.selectPrivacyPolicyField();
		log.info("selectPrivacyPolicyField");
		reg.selectNewsLetterYesRadioButton();
		log.info("selectNewsLetterYesRadioButton");
		AccountSuccessPage asp = reg.clickOnContinueButton();
		log.info("clickOnContinueButton");
		Assert.assertEquals(asp.getAccSuccessHeadLines(), "Your Account Has Been Created!");
		MyAccountPage map = asp.clickOnContinueButton();
		log.info("clickOnContinueButton");
		Assert.assertEquals(map.getMyAccPageTitle(), "My Account");
		NewsletterPage nlp = map.clickOnSubscribeUnsubscribeOption();
		log.info("clickOnSubscribeUnsubscribeOption");
		Assert.assertTrue(nlp.getYesRadioButtonSelected());
	}

	@Test(priority = 5)
	public void verifyRegisteringAnAccountWithNoOptionSelected() {
		test = report.createTest("verifyRegisteringAnAccountWithNoOptionSelected");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();

		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.enterConfirmPassword(pass);
		reg.selectPrivacyPolicyField();
		AccountSuccessPage asp = reg.clickOnContinueButton();
		Assert.assertEquals(asp.getAccSuccessHeadLines(), "Your Account Has Been Created!");
		MyAccountPage map = asp.clickOnContinueButton();
		Assert.assertEquals(map.getMyAccPageTitle(), "My Account");
		NewsletterPage nlp = map.clickOnSubscribeUnsubscribeOption();
		Assert.assertTrue(nlp.getNoRadioButtonSelected());
	}

	@Test(priority = 7)
	public void verifyRegisteringAnAccountWithDifferentPassowrd() throws InterruptedException {
		test = report.createTest("verifyRegisteringAnAccountWithDifferentPassowrd");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.enterConfirmPassword("234" + pass);
		reg.selectPrivacyPolicyField();
		reg.selectNewsLetterYesRadioButton();
		reg.clickOnContinueButton();
		Thread.sleep(3000);
		Assert.assertEquals(reg.getwarnMassageForConfirmPassword(), "Password confirmation does not match password!");

	}

	@Test(priority = 8)
	public void verifyRegisteringAnAccountWithExistingAccountDetails() {
		test = report.createTest("verifyRegisteringAnAccountWithExistingAccountDetails");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail("nasirkhanp93@gmail.com");
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.enterConfirmPassword(pass);
		reg.selectPrivacyPolicyField();
		reg.selectNewsLetterYesRadioButton();
		reg.clickOnContinueButton();
		Assert.assertEquals(reg.getwarnMassageForAlreadyTakenEmail(), "Warning: E-Mail Address is already registered!");

	}

	@Test(priority = 9)
	public void verifyRegisteringAnAccountWithInvalidEmailAddress() {
		test = report.createTest("verifyRegisteringAnAccountWithInvalidEmailAddress");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail("salmanKhanGmial.com");
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.enterConfirmPassword(pass);
		reg.selectPrivacyPolicyField();
		reg.selectNewsLetterYesRadioButton();
		reg.clickOnContinueButton();
		String msg = reg.getEmailAttribute("validationMessage");
		Assert.assertEquals(msg,
				"Please include an '@' in the email address. 'salmanKhanGmial.com' is missing an '@'.");

	}

	@Test(priority = 10)
	public void verifyRegisteringAnAccountWithInvalidPhoneNumber() {
		test = report.createTest("verifyRegisteringAnAccountWithInvalidPhoneNumber");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail("salmanKhanGmial.com");
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("abcdefg");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.enterConfirmPassword(pass);
		reg.selectPrivacyPolicyField();
		reg.selectNewsLetterYesRadioButton();
		reg.clickOnContinueButton();
		Assert.assertEquals(reg.getRegisterPageTitle(), "Register Account");
	}

	@Test(priority = 11)
	public void verifyRegisteringAnAccountHasPlaceholderInAllFields() {
		test = report.createTest("verifyRegisteringAnAccountHasPlaceholderInAllFields");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		reg.getEmailAttribute("placeholder");
		Assert.assertNotNull(reg.getEmailAttribute("placeholder"));
		reg.getFirstNameAttribute("placeholder");
		Assert.assertNotNull(reg.getFirstNameAttribute("placeholder"));

		reg.getLastNameAttribute("placeholder");
		Assert.assertNotNull(reg.getLastNameAttribute("placeholder"));

		reg.getConfirmPasswordAttribute("placeholder");
		Assert.assertNotNull(reg.getConfirmPasswordAttribute("placeholder"));

		reg.getPasswordAttribute("placeholder");
		Assert.assertNotNull(reg.getPasswordAttribute("placeholder"));

		reg.getPhoneAttribute("placeholder");
		Assert.assertNotNull(reg.getPhoneAttribute("placeholder"));

	}

	@Test(priority = 12)
	public void verifyRegisteringAnAccountWithoutProvidingConfirmPassword() {
		test = report.createTest("verifyRegisteringAnAccountWithoutProvidingConfirmPassword");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();

		reg.enterFirstName("Nasir");
		reg.enterLastName("Khan");
		String mail = UtilFile.randomStringGenerator();
		reg.enterEmail(mail);
		UtilFile.scrollDown(driver);
		reg.enterPhoneNumber("9921992184");
		String pass = UtilFile.randomNumberGenerator();
		reg.enterPassword(pass);
		reg.selectNewsLetterYesRadioButton();
		reg.selectPrivacyPolicyField();

		AccountSuccessPage asp = reg.clickOnContinueButton();
		UtilFile.scrollDown(driver);
		Assert.assertEquals(reg.getwarnMassageForConfirmPassword(), "Password confirmation does not match password!");

	}

	@Test(priority = 6)
	public void verifyDifferentWaysOfNavigatingToRegisterPage() {
		test = report.createTest("verifyDifferentWaysOfNavigatingToRegisterPage");

		HomePage hmp = new HomePage(driver);
		hmp.clickOnMyAccDropMenu();
		RegisterPage reg = hmp.clickOnRegisterOption();
		Assert.assertEquals(reg.getRegisterPageTitle(), "Register Account");

		hmp.clickOnMyAccDropMenu();
		LoginPage lgp = hmp.clickOnLoginOption();
		lgp.clickOnContinueButton();
		Assert.assertEquals(reg.getRegisterPageTitle(), "Register Account");

		hmp.clickOnMyAccDropMenu();
		hmp.clickOnLoginOption();
		hmp.clickOnRegisterRightSideButton();
		Assert.assertEquals(reg.getRegisterPageTitle(), "Register Account");

	}

}
