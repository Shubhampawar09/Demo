package com.neo.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	Reporter report;// = new reporter();
	ActionMethod action = new ActionMethod();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		report.createReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.pass("Testcase has passed ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		report.fail("Testcase got failed ");
			try {
				action.takeScreenShots("failed" +result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report.skipped("Testcase got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		report=new Reporter();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.teardown();
	}

}
