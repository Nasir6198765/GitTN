package com.TN.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class UtilFile {

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");

	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-200)");

	}

	public static String randomStringGenerator() {
		String randStr = RandomStringUtils.randomAlphabetic(4);
		String randString = "nasir" + randStr + "@gmail.com";
		return randString;
	}

	public static String randomNumberGenerator() {
		String randNum = RandomStringUtils.randomNumeric(6);
		return randNum;
	}

	public static String generateTimeStamp() {
		Date date = new Date();
		String time = date.toString().replace(" ", "_").replace(":", "_");
		return time;
	}

	public static String takeScreenShot(WebDriver driver, String methodName) throws IOException {
		WebDriver drivers = driver;
		TakesScreenshot tks = (TakesScreenshot) drivers;
		File src = tks.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//ScreenShotFolder//" + methodName + ".png";
		File psrc = new File(path);
		FileUtils.copyFile(src, psrc);
		return path;
	}

	@DataProvider
	public static Object[][] getData() {
		Object[][] obj = { { "Nasir", "Khan", "nasir123@gmail.com", "9921995634", "8421", "8421" },
				{ "Mosin", "Khan", "mosin123@gmail.com", "9921995634", "8421", "8421" },
				{ "Wasim", "Khan", "wasim123@gmail.com", "9921995634", "8421", "8421" },
				{ "Salman", "Khan", "salman123@gmail.com", "9921995634", "8421", "8421" } };
		return obj;

	}

}
