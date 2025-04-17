package com.FalconTalk.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.DialPlansObj;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

public class DialPlansPage {
	
	DialPlansObj dialplansobj = new DialPlansObj();
	ProfileDetailsPage profiledetailpage = new ProfileDetailsPage();
	
	By byDialPlansName = By.id("com.dassault.HONfalcontalk:id/text_dial_plan_name");
	By byDialPlansAddButton = By.id("com.dassault.HONfalcontalk:id/menu_item_add_dial_plan");
	
	public DialPlansPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	public void setup() {
		System.out.println("Dial Plans Module Test Start");
		profiledetailpage.setup();
		dialplansobj.profileDialPlans.click();
	}
	
	public String AddNewDialPlans() {
		System.out.println("Dial plans Page");
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byDialPlansAddButton));
		dialplansobj.DialPlansAddButton.click();
		dialplansobj.DialPlansEnterName.sendKeys("Test Dial Plans");
		dialplansobj.DialPlansEnterMatchNumber.sendKeys("0110x.");
		dialplansobj.DialPlansEnterRemovePrefix.sendKeys("011");
		dialplansobj.DialPlansEnterAddPrefix.sendKeys("+");
		dialplansobj.DialPlansSaveButton.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byDialPlansName));
		return dialplansobj.DialPlansName.get(5).getText();
	}
	
	public String DialPlansEdit() {
		dialplansobj.DialPlansInfo.get(5).click();
		dialplansobj.DialPlansEnterName.clear();
		dialplansobj.DialPlansEnterName.sendKeys("Test Dial Plans 1");
		dialplansobj.DialPlansEnterMatchNumber.clear();
		dialplansobj.DialPlansEnterMatchNumber.sendKeys("0101x.");
		dialplansobj.DialPlansEnterRemovePrefix.clear();
		dialplansobj.DialPlansEnterRemovePrefix.sendKeys("010");
		dialplansobj.DialPlansEnterAddPrefix.clear();
		dialplansobj.DialPlansEnterAddPrefix.sendKeys("+");
		dialplansobj.DialPlansSaveButton.click();
		return dialplansobj.DialPlansName.get(5).getText();
	}
	
	public void DialPlansDelete() { 
		//TouchAction t = new TouchAction((PerformsTouchActions) AppDriver.getDriver());
		//t.longPress((LongPressOptions) dialplansobj.DialPlansName).perform().release();
		TouchAction action = new TouchAction((PerformsTouchActions) AppDriver.getDriver());
		action.longPress((LongPressOptions) dialplansobj.DialPlansName);
		action.perform();


		dialplansobj.DialPlanDelete.click();
	}
}
