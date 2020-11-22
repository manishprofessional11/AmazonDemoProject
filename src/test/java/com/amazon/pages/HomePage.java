/*****************************************************************************************************
Author: Manish Gairola
File Name: Home Page
Date Created: 11 July 2020
About: Implements objects of the Home Page
#*****************************************************************************************************/

package com.amazon.pages;

import org.openqa.selenium.support.FindBy;

import com.amazon.tests.SampleTest;
import com.aventstack.extentreports.Status;
import com.basepackage.BaseTestClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BaseTestClass {




	@FindBy(xpath="//android.widget.EditText[contains(@resource-id,'rs_search_src_text')]")
	private MobileElement txtSearchBox;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'double tap to open side panel')]")
	private MobileElement elmainMenuBar;

	@FindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'drawer_arrow')]")
	private MobileElement elshopByDeptArrow;

	@FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'anp_drawer_item')]/descendant::android.widget.TextView[@text='Electronics']")
	private MobileElement elelectronics;







	public String getHomePageAttribute() {
		try {
			testUtils.log().info(txtDataHashMap.get("xmlSearchBox") + " getting attribute");
			extentTest.log(Status.INFO, txtDataHashMap.get("xmlSearchBox") + " getting attribute");
			return getAttribute(txtSearchBox,"text");

		}
		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlSearchBox") + " failed to get attribute");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlSearchBox") + " attribute NOT retrieved");
			return null;
		}

	}

	public HomePage clickMainMenuBar() {
		try {
			click(elmainMenuBar);
			testUtils.log().info(txtDataHashMap.get("xmlmainMenuBar") + " click successful");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlmainMenuBar") + " click successful");
			return this;
		}
		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlmainMenuBar")+ " click failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlmainMenuBar") + " click failed");
			return null;
		}

	}

	public HomePage clickShopByDeptArrow() {
		try {
			click(elshopByDeptArrow);
			testUtils.log().info(txtDataHashMap.get("xmlshopByDeptArrow") + " click successful");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlshopByDeptArrow") + " click successful");
			return this;
		}
		catch (Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlshopByDeptArrow") + " click failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlshopByDeptArrow") + " click failed");
			return null;
		}

	}

	public ElectronicsPage clickElectronics() {
		try {
			click(elelectronics);
			testUtils.log().info(txtDataHashMap.get("xmlelectronics") + " click successful");
			extentTest.log(Status.PASS, txtDataHashMap.get("xmlelectronics") + " click successful");
			return new ElectronicsPage();
		}

		catch(Exception e) {
			testUtils.log().error(txtDataHashMap.get("xmlelectronics") + " click failed");
			extentTest.log(Status.FAIL, txtDataHashMap.get("xmlelectronics") + " click failed");
			return null;
		}


	}

}
