package com.neo.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {
	public  ExtentReports extent;
	public  ExtentSparkReporter spark;
	public  ExtentTest test;
	
	public Reporter() {
		spark = new ExtentSparkReporter(ReportName());
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("NEOBROKER");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	/*
	 * Format to print the name of the reports
	 */
	public String ReportName() {
		DateFormat dateformat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		Date date = new Date();
		String reportFileName = "Report" + "_" + dateformat.format(date) + ".html";
		return System.getProperty("user.dir") +"/SparkReport/"+reportFileName;
		//C:\Users\LENOVO\eclipse-workspace\Neo\test-output
	}

	/*
	 * to generate report
	 */
	public void createReport(String testname) {
		test = extent.createTest(testname);
	}
	
	/*
	 * to display info
	 */
	public void info(String message) {
		test.info(message);
	}

	/*
	 *Method for Test pass
	 */
	public void pass(String message) {
		test.pass(message);
	}

	/*
	 *Method for Test Fail 
	 */
	public void fail(String message) {
		test.fail(message);
		
	}
	
	/*
	 *Method for Test Skipped 
	 */
	public void skipped(String message) {
		test.skip(message);
	}

	/*
	 * Method for Teardown
	 */
	public void teardown() {
		extent.flush();
	}
	
	
	
}
