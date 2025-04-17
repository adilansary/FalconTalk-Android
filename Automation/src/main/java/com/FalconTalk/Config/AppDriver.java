package com.FalconTalk.Config;
import org.openqa.selenium.WebDriver;

public class AppDriver {
	private static ThreadLocal<WebDriver> driverActivity = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		
		return driverActivity.get();
	}
	
	static void setDriver(WebDriver Driver) {
		driverActivity.set(Driver);
	}
}
