package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentSparkReporter reporter;
	public static ExtentReports report;

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static final String reportPath = "reports/ExecutionReport.html";

	public static void setupExtendReport() {

		reporter = new ExtentSparkReporter(reportPath);

		report = new ExtentReports();
		report.attachReporter(reporter);

		reporter.config().setDocumentTitle("OrangeHRM Test Execution Report");
		reporter.config().setReportName("Execution Report");
		reporter.config().setTheme(Theme.DARK);

	}

	public static void flushReport() {
		report.flush();
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest test = report.createTest(testName);
		extentTest.set(test);
		return test;
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
}
