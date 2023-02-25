package com.TN.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer {
	int invokeStart = 0;
	int invokeEnd = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (invokeStart<invokeEnd) {
			invokeStart++;
			return true;
		} else {
			return false;

		}
	}
}