package com.TN.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TN.Bases.Base;

public class MyListener extends Base implements ITestListener {
	String path;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart Working");
		log.info("====================================");
		log.info(result.getName());
		log.info("====================================");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Working");

		log.info(result.getName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Working");

		log.info(result.getName() + " Failed");
		String methodName = result.getName().toString();

		try {
			path = UtilFile.takeScreenShot(driver, methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Working");

		log.info(result.getName() + " Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
