package com.FalconTalk.Config;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriver driver;
	public static AppiumDriverLocalService service;
	
	public static AppiumDriver Capabilities() throws MalformedURLException,InterruptedException, IOException {
		
		String device = System.getProperty("deviceName");//Get the connected Device id
		
		File f= new File("src");
		File fs = new File(f,"FT.apk");
		
		//String device = "CVH7N15A14002871";
		System.out.println(device);
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);//Set the app is on android Platform
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), cap);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.startActivity(new Activity("com.dassault.HONfalcontalk","com.sb.app.application.MainActivity"));
		Thread.sleep(25000);
		driver.getCapabilities().getCapability("deviceModel").toString();
		return driver;
	} 

}
