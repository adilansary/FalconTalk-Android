package com.FalconTalk.Config;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.FalconTalk.PageObject.ProfileObj;
import com.mobile.MobileTest.MobileDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scrolling {
	ProfileObj addprofileobj = new ProfileObj();
	
	public void scrollDown(Double y) {
		Dimension dimension = MobileDriver.getDriver().manage().window().getSize();
		
		Double scrollHeightStart = dimension.getHeight() * y;
		int ScrollStart = scrollHeightStart.intValue();
		
		Double ScrollHightEnd = dimension.getHeight() * y-0.3;
		int ScrollEnd = ScrollHightEnd.intValue();
		
		new TouchAction((PerformsTouchActions)MobileDriver.getDriver())
		.press(PointOption.point(0,ScrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0,ScrollEnd)).release().perform();
	}
	
	public void scrollTillApplyButton() {
		while(addprofileobj.getItemApplyButton.size()==0) {
			scrollDown(0.5);
		}
		
		if(addprofileobj.getItemApplyButton.size() > 0) {
			addprofileobj.getItemApplyButton.get(0).click();
		}
	}

}
