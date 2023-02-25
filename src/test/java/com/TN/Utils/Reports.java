package com.TN.Utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static void generateReports() throws IOException {

		ExtentReports report = new ExtentReports();
		File file = new File(System.getProperty("user.dir") + "//ExtentReportFolder//ExtentReport"
				+ UtilFile.generateTimeStamp() + ".html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		report.attachReporter(sparkReport);

		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("TutorialsNinja Report");
		sparkReport.config().setDocumentTitle("URL TutorialsNinja");
		sparkReport.config().setTimeStampFormat("dd-mm-yy hh:mm:ss");

		ExtentTest test = report.createTest("Registering");
		test.log(Status.FAIL, "Should work");

		report.setSystemInfo("Browser Name:", "Chrome Browser");
		report.setSystemInfo("Browser Version:", "13.17");
		report.setSystemInfo("User Name:", System.getProperty("user.name"));
		report.setSystemInfo("OS Name:", System.getProperty("os.name"));
		report.setSystemInfo("Java Version:", System.getProperty("java.version"));
		report.flush();

	}

}
