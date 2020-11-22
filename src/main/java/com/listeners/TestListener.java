/*****************************************************************************************************
Author: Manish Gairola
File Name: TestListener
Date Created: 12 July 2020
About: Implements TestNG listeners. For this project, only onTestFailure failures have been implemented
#*****************************************************************************************************/

package com.listeners;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

public class TestListener extends BaseTestClass implements ITestListener {

	public void onTestStart(ITestResult result) {




	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		if (result.getThrowable() != null) {
			testUtils.log().error(result.getThrowable().getMessage());
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			extentTest.log(Status.FAIL, result.getName() + " failed");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());

		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
