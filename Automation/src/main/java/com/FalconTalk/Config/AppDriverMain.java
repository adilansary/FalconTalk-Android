package com.FalconTalk.Config;

import org.openqa.selenium.WebDriver;

public class AppDriverMain {
private static ThreadLocal<WebDriver> driverActivityMain = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driverActivityMain.get();
	}
	
	static void setDriver(WebDriver Driver) {
		driverActivityMain.set(Driver);
	}

}
