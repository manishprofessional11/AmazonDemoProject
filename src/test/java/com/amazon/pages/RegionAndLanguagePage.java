package com.amazon.pages;

import org.openqa.selenium.support.FindBy;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.MobileElement;

public class RegionAndLanguagePage extends BaseTestClass {
	
	@FindBy(xpath = "//android.view.View[contains(@resource-id,'landing-doneButton')]/android.widget.Button") 
	private MobileElement btnDone;
	
	
	public WelcomePage clickDone() {

		try {

			btnDone.isDisplayed();
			testUtils.log().info(txtDataHashMap.get("xmlDone") + " is displayed");
			testUtils.log().info(txtDataHashMap.get("xmlDone") + " getting clicked");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlDone") + " getting clicked");
			click(btnDone);
			return new WelcomePage();

		}

		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlDone") + " cannot be clicked");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlDone") + " cannot be clicked");
			return null;
		}

	}

}
