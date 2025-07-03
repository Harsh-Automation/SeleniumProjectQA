package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClass.BaseClass;

public class ListnerClass implements ITestListener {

	Logger log = LogManager.getLogger(ListnerClass.class);

	@Override
	public void onTestStart(ITestResult result) {
		ReportManager.createTest("Test for " + result.getMethod().getMethodName());
		ReportManager.getTest().info("Browser launched Successfully");
		ReportManager.getTest().info("Navigated to " + BaseClass.url);
		System.out.println("***** Test started for " + result.getName() + "*****");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		log.info("Test Passed for " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		log.info("Test FAILED for " + result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		ReportManager.setupExtendReport();

		System.out.println("***** Test started for " + context.getName() + "*****");
	}

	@Override
	public void onFinish(ITestContext context) {
		ReportManager.flushReport();

		System.out.println("***** Test finish for " + context.getName() + "*****");

	}

}
