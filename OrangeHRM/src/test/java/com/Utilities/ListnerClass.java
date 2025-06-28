package com.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListnerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ReportManager.test = ReportManager.report.createTest(result.getMethod().getMethodName());
		System.out.println("***** Test started for " + result.getName() + "*****");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ReportManager.test.log(Status.PASS, "Test Passed for " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		ReportManager.test.log(Status.FAIL, "Test FAILED for " + result.getThrowable());

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
