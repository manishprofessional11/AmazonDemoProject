/*****************************************************************************************************
Author: Manish Gairola
File Name: ElectronicsPage
Date Created: 12 July 2020
About: Implements objects of the Electronics Page
#*****************************************************************************************************/


package com.amazon.pages;

import org.openqa.selenium.support.FindBy;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.MobileElement;

public class ElectronicsPage extends BaseTestClass{

	@FindBy(xpath="//android.view.View[contains(@resource-id,'fst-hybrid-dynamic-h1')]")
	private MobileElement elLabelElectronicsPage;

	@FindBy(xpath="//android.view.View[contains(@resource-id,'fst-hybrid-dynamic-h1')]/child::android.view.View")
	private MobileElement elLabelElectronicsPageChild;

	@FindBy(xpath="//android.view.View[contains(@resource-id,'s-center-below-extra-content')]/descendant::android.view.View[@content-desc='eBook Readers & Accessories']")
	private MobileElement readersAndAccessories;


	public ElectronicsPage verifyElectronicsPage() {

		try {
			super.isDisplayed(elLabelElectronicsPage);
			testUtils.log().info(txtDataHashMap.get("xmlelectronicsPage") + " is displayed");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlelectronicsPage") + " is displayed");
			return this;

		}

		catch (Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlelectronicsPage") + " is NOT displayed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlelectronicsPage") + " is NOT displayed");
			return null;
		}


	}

	public String getAttributeElectronicsPage() {

		try {
			testUtils.log().info(txtDataHashMap.get("xmlelectronicsPage") + " getting attribute");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlelectronicsPage") + " getting attribute");
			return getAttribute(elLabelElectronicsPageChild,"text");
		}

		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlelectronicsPage") + " failed to retrieve attribute");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlelectronicsPage") + " failed to retrieve attribute");
			return null;


		}	

	}

	public ElectronicsPage getToReadersAndAccessories() {
		try {
			scrollToElementTouchAction("downfast",readersAndAccessories,50);
			testUtils.log().info(txtDataHashMap.get("xmlReadAndAccessories") + " scroll successful");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlReadAndAccessories") + " scroll successful");
			return this;
		}

		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlReadAndAccessories") + " scroll failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlReadAndAccessories") + " scroll failed");
			return null;
		}


	}

	public ReadersAndAccessoriesPage clickReadersAndAccessories() {

		try {
			click(readersAndAccessories);
			testUtils.log().info(txtDataHashMap.get("xmlReadAndAccessories") + " click successful");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlReadAndAccessories") +  " click successful");
			return new ReadersAndAccessoriesPage();

		}
		catch (Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlReadAndAccessories") + " click failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlReadAndAccessories") +  " click failed");
			return null;
		}

	}

}
