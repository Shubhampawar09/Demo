package com.neo.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest{
	
	public  AppiumDriver<MobileElement> driver;
	public  AppiumDriverLocalService service;
	public Logger log;
		DeviceCapabilities cap=new DeviceCapabilities();	
	
	@BeforeClass
	@org.testng.annotations.Parameters(value={"deviceIndex"})
	public void setUp(String deviceIndex) throws Exception{
		//service =cap.startService();
		cap.SetCapabilities(deviceIndex);
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
	}

	@AfterClass
	public void teardown() {
		//service.stop();
		DeviceCapabilities.getDriver().quit();
	}
	
}
