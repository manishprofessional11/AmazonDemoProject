/***************************************************************************************************
Author: Manish Gairola
File Name: BaseTestClass
Date Created: 16 Nov 2020
About: This class file is the main class of this project and all the test classes extend this class
#***************************************************************************************************/


package com.basepackage;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class BaseTestClass {

	public BaseTestClass()  {

		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	protected static AppiumDriver<MobileElement> driver;
	protected InputStream sampleTestJsonStream;
	protected JSONObject jsonObject;
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static Properties prop;
	protected static HashMap<String,String> txtDataHashMap = new HashMap<String,String>();
	public static String executionOS;
	protected InputStream propInputStream;
	protected InputStream txtDataStream;
	protected static TestUtils testUtils;
	public static ExtentTest extentTest;
	String sampleTestJsonFile = "data/sampleTest.json";



	@BeforeSuite
	public void reportSetUp() {

		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@AfterSuite
	public void reportTearDown() {
		// calling flush writes everything to the log file
		extent.flush();
	}



	@Parameters({"emulator","platformName","platformVersion","deviceName","udid"})
	@BeforeTest
	public void setup(String emulator, String platformName, String platformVersion,
			String deviceName, String udid) throws Exception {

		try {

			prop = new Properties();
			String propFileName = "config.properties";
			String txtDataFileName = "txtdata/txtData.xml";


			propInputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(propInputStream);

			txtDataStream =  getClass().getClassLoader().getResourceAsStream(txtDataFileName);
			testUtils = new TestUtils();
			txtDataHashMap = testUtils.parseXML(txtDataStream);


			DesiredCapabilities caps = new DesiredCapabilities();
			File classRootPath = new File(System.getProperty("user.dir"));
			File appDir,app;

			this.executionOS = platformName;

			caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);

			switch (executionOS) {

			case "Android":
				appDir = new File(classRootPath,prop.getProperty("androidAppLocation"));
				app = new File(appDir,prop.getProperty("androidAppName"));
				if(emulator.equalsIgnoreCase("true")) {
					caps.setCapability("avd", deviceName);
					caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);

				}
				else {
					caps.setCapability(MobileCapabilityType.UDID,udid);
				}

				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("androidAutomationName"));
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,100);
				caps.setCapability("appPackage",prop.getProperty("androidAppPackage"));
				caps.setCapability("appActivity",prop.getProperty("androidAppActivity"));
				caps.setCapability("noReset",false);
				caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
				testUtils.log().info("app location is " + app.getAbsolutePath());
				URL url  = new URL(prop.getProperty("appiumURL"));

				driver = new AndroidDriver<MobileElement>(url, caps);
				String sessionID = driver.getSessionId().toString();
				break;

			case "iOS":


				//Desired Capabilities for iOS Device

				break;

			default:
				throw new Exception(platformName + "Platform Doesn't Exist ");


			}




		} catch (Exception e) {
			System.out.println("Error cause" + e.getCause());
			System.out.println("Message" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {

			if (propInputStream != null) {
				propInputStream.close();

			}

			if (txtDataStream != null) {
				txtDataStream.close();

			}
		}

	}
	
	
	@BeforeTest
	public void jsonReader() throws Exception {

		try {

			sampleTestJsonStream = getClass().getClassLoader().getResourceAsStream(sampleTestJsonFile);
			JSONTokener tokener = new JSONTokener(sampleTestJsonStream);
			jsonObject = new JSONObject(tokener);

		} catch(Exception e) {
			e.printStackTrace();
			throw e;

		} finally {

			if (sampleTestJsonStream != null) {
				sampleTestJsonStream.close();
			}
		}


	}


	public void waitiForElementVisibility(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void click(MobileElement element) {

		element.click();

	}

	public void sendKeys(MobileElement element, String str) {
		waitiForElementVisibility(element);
		element.sendKeys(str);
	}

	public String getAttribute(MobileElement element, String attribute) {
		waitiForElementVisibility(element);
		return (element.getAttribute(attribute));
	}


	public boolean isDisplayed(MobileElement element) {
		try {
			waitiForElementVisibility(element);
			if (element.isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}

	}

	public MobileElement scrollToElementForScrollableElement() {

		return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".description(\"parent locator\")).scrollIntoView("
						+ "new UiSelector().description(\"child_locator\"));");
	}

	public void scrollToElementTouchAction(String direction, MobileElement element, int numberofScrolls) {
		TouchAction ta = new TouchAction(driver);
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth()/2;
		int startY = 0;
		int endY = 0;

		switch(direction.toLowerCase()) {

		case "upfast":

			startY = (int) (dim.getHeight() * 0.1);
			endY = (int) (dim.getHeight() * 0.99);
			break;

		case "downfast":

			startY = (int) (dim.getHeight() * 0.99);
			endY = (int) (dim.getHeight() * 0.1);
			break;

		case "upslow":

			startY = (int) (dim.getHeight() * 0.4);
			endY = (int) (dim.getHeight() * 0.7);
			break;

		case "downslow":

			startY = (int) (dim.getHeight() * 0.7);
			endY = (int) (dim.getHeight() * 0.4);
			break;

		}

		int i =0;
		while (i <= numberofScrolls) {
			ta.press(PointOption.point(x,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(PointOption.point(x,endY)).release().perform();

			if(isDisplayed(element)) {
				break;
			}
			i++;
		}


	}


	@AfterTest
	public void teardown() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}




}
