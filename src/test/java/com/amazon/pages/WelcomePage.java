/*****************************************************************************************************
Author: Manish Gairola
File Name: Welcome Page
Date Created: 10 July 2020
About: Implements objects of the Welcome Page
#*****************************************************************************************************/


package com.amazon.pages;


import org.openqa.selenium.support.FindBy;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends BaseTestClass {


	
	
	@FindBy(xpath = "//android.widget.Button[contains(@resource-id,'skip_sign_in_button')]") 
	private MobileElement btnSkipSignIn;


	public HomePage clickSkipSignIn() {

		try {

			btnSkipSignIn.isDisplayed();
			testUtils.log().info(txtDataHashMap.get("xmlSkipSignIn") + " is displayed");
			testUtils.log().info(txtDataHashMap.get("xmlSkipSignIn") + " getting clicked");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlSkipSignIn") + " getting clicked");
			click(btnSkipSignIn);
			return new HomePage();

		}

		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlSkipSignIn") + " cannot be clicked");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlSkipSignIn") + " cannot be clicked");
			return null;
		}

	}
}