package com.FalconTalk.PageActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.Activitybackground;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.AppDriverbackground;
import com.FalconTalk.PageObject.PreviousConfigObj;
import com.FalconTalk.PageObject.RingGroupExtensionObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreviousConfigPage {
	PreviousConfigObj previousconfig = new PreviousConfigObj();
	RingGroupExtensionObj RingGObj = new RingGroupExtensionObj();
	
	By byPreviousConfigContainer = By.id("com.dassault.HONfalcontalk:id/previous_config_container");
	By byChangeButton = By.id("com.dassault.HONfalcontalk:id/search_button");
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	
	public PreviousConfigPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriverbackground.getDriver()), this);
	}
	
	public void PreviousPage() throws MalformedURLException {
		Activitybackground.AndroidLaunchApp();
	}
	public void close() {
		Activitybackground.CloseApp();
	}
	public void lan() throws MalformedURLException {
		Activitybackground.AndroidLaunchApp();
	}
	
	public String Name() {
		return previousconfig.RouterName.getText();
	}
	
	public boolean LastExtensionPage() {
		System.out.println("Previous Config Page Start");
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byPreviousConfigContainer));
		return previousconfig.PreviousConfigContainer.isDisplayed();
	}
	
	public String LastExtension() {
		return previousconfig.PreExtension.getText();
	}
	public String LastRingGroup() {
		return previousconfig.PreRingGroup.getText();
	}
	public String LastDisplayName() {
		return previousconfig.PreDisplayName.getText();
	}
	
	public String OkButton() {
		previousconfig.OkButton.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		previousconfig.NavigationDrawer.click();
		return previousconfig.NavDrawerAccInfo.getText();
	}
	
	public String ChangeButton() {
		previousconfig.RetryAutoConfig.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byChangeButton));
		previousconfig.ChangeButton.click();
		RingGObj.VIPExtension.click();
		RingGObj.Extension.click();
		RingGObj.ApplyButton.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		previousconfig.NavigationDrawer.click();
		return previousconfig.NavDrawerAccInfo.getText();
	}
}
