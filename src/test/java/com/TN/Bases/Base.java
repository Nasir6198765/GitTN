package com.TN.Bases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.TN.Utils.MyRetryAnalyser;
import com.TN.Utils.UtilFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

//compiler will consider This driver null until any initialized driver method								
	public static WebDriver driver;
	public static Logger log;
	public static ExtentReports report;
	public static ExtentSparkReporter sparkReport;
	public static ExtentTest test;

	@BeforeSuite
	public void configureReports() {
		log = LogManager.getLogger(Base.class.getName());
		log.info("@BeforeSuite");

		report = new ExtentReports();
		File file = new File(System.getProperty("user.dir") + "//ExtentReportFolder//ExtentReport"
				+ UtilFile.generateTimeStamp() + ".html");
		sparkReport = new ExtentSparkReporter(file);
		report.attachReporter(sparkReport);

		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("TutorialsNinja Report");
		sparkReport.config().setDocumentTitle("URL TutorialsNinja");
		sparkReport.config().setTimeStampFormat("dd-mm-yy hh:mm:ss");

		report.setSystemInfo("Browser Name:", "Chrome Browser");
		report.setSystemInfo("Browser Version:", "13.17");
		report.setSystemInfo("User Name:", System.getProperty("user.name"));
		report.setSystemInfo("OS Name:", System.getProperty("os.name"));
		report.setSystemInfo("Java Version:", System.getProperty("java.version"));

	}

	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {
		log.info("@BeforeMethod");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Browser got launched ");
		driver.manage().window().maximize();
		log.info("Browser got maximized");
		driver.get("http://tutorialsninja.com/demo/");
		log.info("Navigated to URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void close(ITestResult result) {
		log.info("@AfterMethod");
		driver.quit();
		log.info("Browser got closed");

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}

	}

	@AfterSuite
	public void configureEnd() {
		log.info("@AfterSuite");
		report.flush();
	}

}
