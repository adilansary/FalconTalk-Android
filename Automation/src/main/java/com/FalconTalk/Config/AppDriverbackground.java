package com.FalconTalk.Config;

import org.openqa.selenium.WebDriver;

public class AppDriverbackground {
private static ThreadLocal<WebDriver> driverActivitybackground = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		
		return driverActivitybackground.get();
	}
	
	static void setDriver(WebDriver Driver) {
		driverActivitybackground.set(Driver);
	}

}
