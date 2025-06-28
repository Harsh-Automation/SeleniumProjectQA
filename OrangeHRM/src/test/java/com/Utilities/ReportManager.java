package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;

	public static final String reportPath = "reports/ExecutionReport.html";

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
}
