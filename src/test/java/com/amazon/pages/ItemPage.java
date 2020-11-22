/*****************************************************************************************************
Author: Manish Gairola
File Name: Item Page
Date Created: 13 July 2020
About: Implements objects of the Item Page
#*****************************************************************************************************/


package com.amazon.pages;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.MobileElement;

public class ItemPage extends BaseTestClass {

	@FindBy(xpath="//android.view.View[contains(@resource-id,'availabilityInsideBuyBox_feature_div')]/descendant::android.widget.TextView")
	private MobileElement inStockLabel;


	public boolean verifyStockAvailability() {
		try {

			inStockLabel.isDisplayed();
			Assert.assertTrue(true, "Product In Stock");
			testUtils.log().info("Product is " + txtDataHashMap.get("xmlInStock"));
			extentTest.log(Status.PASS, "Product is " + txtDataHashMap.get("xmlInStock"));
			return true;


		}
		catch (Exception e){

			testUtils.log().error("Product is NOT " + txtDataHashMap.get("xmlInStock"));
			Assert.assertTrue(false, "Product is NOT " + txtDataHashMap.get("xmlInStock"));
			extentTest.log(Status.FAIL, "Product is NOT " + txtDataHashMap.get("xmlInStock"));
			return false;
		}
	}

	public ItemPage scrollToInStockLabel() {

		try {
			scrollToElementTouchAction("downslow",inStockLabel,50);
			testUtils.log().info(txtDataHashMap.get("xmlInStock") + " scroll Successful");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlInStock") + " scroll Successful");
			return this;
		}
		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlInStock") + " scroll failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlInStock") + " scroll failed");
			return null;
		}



	}

}
