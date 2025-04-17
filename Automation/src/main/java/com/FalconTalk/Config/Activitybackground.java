package com.FalconTalk.Config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Activitybackground {
	
	public static AppiumDriver driverActivitybackground;
	public static DesiredCapabilities cap;
	
	
	public static void AndroidLaunchApp() throws MalformedURLException {
		String device = System.getProperty("deviceName");
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("autoGrantPermissions","true");
		cap.setCapability(MobileCapabilityType.NO_RESET,"true");
		cap.setCapability(MobileCapabilityType.FULL_RESET,"false");
		cap.setCapability("appPackage", "com.dassault.HONfalcontalk");
		cap.setCapability("appActivity", "com.sb.app.application.SplashScreenActivity");
		driverActivitybackground = new AppiumDriver(new URL("http://127.0.0.1:4723/"),cap);
		AppDriver.setDriver(driverActivitybackground);
		
	}
	
	public static void CloseApp() {
		driverActivitybackground.quit();
	}


}
