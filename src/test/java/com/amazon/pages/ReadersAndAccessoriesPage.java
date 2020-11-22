/*****************************************************************************************************
Author: Manish Gairola
File Name: Read and Accessories Page
Date Created: 12 July 2020
About: Implements objects of the Read and Accessories Page
#*****************************************************************************************************/


package com.amazon.pages;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.MobileElement;

public class ReadersAndAccessoriesPage extends BaseTestClass{



	@FindBy(xpath="//android.view.View[contains(@resource-id,'fst-hybrid-dynamic-h1')]")
	private MobileElement labelRAndSPage;

	@FindBy(xpath="//android.view.View[contains(@text,'Top rated')]")
	private MobileElement topRatedLabel;

	@FindBy(xpath="//android.view.View[contains(@text,'Top rated')]/../descendant::android.widget.ListView/child::android.view.View[1]")
	private MobileElement firstTopRatedItem;




	public boolean verifyRAndSPage() {

		try {
			isDisplayed(labelRAndSPage);
			Assert.assertTrue(true, txtDataHashMap.get("xmlReadAndAccessories") + " Page is displayed");
			testUtils.log().info(txtDataHashMap.get("xmlReadAndAccessories") +" Page is displayed");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlReadAndAccessories") +  " Page is displayed");
			return true;
		}

		catch (Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlReadAndAccessories") +" Page is NOT displayed");
			Assert.assertTrue(false, txtDataHashMap.get("xmlReadAndAccessories") + " Page is NOT displayed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlReadAndAccessories") +  " Page is NOT displayed");
			return false;
		}


	}


	public ReadersAndAccessoriesPage scrollToFirstTopRatedItem() {

		try {

			scrollToElementTouchAction("downslow",firstTopRatedItem,50);
			testUtils.log().info(txtDataHashMap.get("xmlFirstTopRatedItem") + " scroll successful");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlFirstTopRatedItem") +  " scroll successful");
			return this;

		}

		catch (Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlFirstTopRatedItem") + " scroll failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlFirstTopRatedItem") +  " scroll failed");

			return null;
		}

	}


	public ItemPage clickFirstTopRatedItem() {

		try {

			click(firstTopRatedItem);
			testUtils.log().info(txtDataHashMap.get("xmlFirstTopRatedItem") + " click successful");
			new SampleTest().extentTest.log(Status.PASS, txtDataHashMap.get("xmlFirstTopRatedItem") +  " click successful");
			return new ItemPage();

		}
		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlFirstTopRatedItem") + " click failed");
			new SampleTest().extentTest.log(Status.FAIL, txtDataHashMap.get("xmlFirstTopRatedItem") +  " click failed");
			return null;
		}

	}

}
