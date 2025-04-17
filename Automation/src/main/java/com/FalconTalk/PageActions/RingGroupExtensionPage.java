package com.FalconTalk.PageActions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.AutoDiscoverObj;
import com.FalconTalk.PageObject.RingGroupExtensionObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RingGroupExtensionPage {
	RingGroupExtensionObj RingGObj = new RingGroupExtensionObj();
	AutoDiscoverObj AutoDisObj = new AutoDiscoverObj();
	
	public RingGroupExtensionPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	public ArrayList<String> RingGroupExtensionAxxess() {
		System.out.println("Ring Group Extension page Start");
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ArrayList<String> ringgrouplist = new ArrayList<String>();
		ringgrouplist.add(RingGObj.VVIPExtension.getText());
		ringgrouplist.add(RingGObj.VIPExtension.getText());
		ringgrouplist.add(RingGObj.GuestExtension.getText());
		
		return ringgrouplist;
	}
	
	public String DisplayName() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String DisplayName = RingGObj.DisplayName.getText();
		return DisplayName;
	}
	
	public ArrayList<String> RingGroupExtensionAxxessSelect() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ArrayList<String> ringgwithextention = new ArrayList<String>();
		RingGObj.VVIPExtension.click();
		RingGObj.Extension.click();
		String VVIPExten = RingGObj.VVIPExtension.getText();
		ringgwithextention.add(VVIPExten);
		
		RingGObj.VIPExtension.click();
		RingGObj.Extension.click();
		String VIPExten = RingGObj.VIPExtension.getText();
		ringgwithextention.add(VIPExten);
		
		RingGObj.GuestExtension.click();
		RingGObj.Extension.click();
		String GuestExten = RingGObj.GuestExtension.getText();
		ringgwithextention.add(GuestExten);
		
		return ringgwithextention;
	}
	
	public String CancelButtonAxxess() {
		RingGObj.CancelButton.click();
		String AutoDiscoveryFailedNotice = AutoDisObj.AutoDiscoveryFailedNotice.getText();
		AutoDisObj.RetryAutoCOnfig.click();
		return AutoDiscoveryFailedNotice;
		
		
	}
	
	public String ApplyButtonAxxess() {  //When Discover for Axxess Router
		RingGObj.Extension.click();
		RingGObj.ApplyButton.click();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String AccountName = RingGObj.SelectAccountName.getText();
		return AccountName;
	}
	
	public String AccountStatus() {
		String AccountStatus = RingGObj.SelectAccountStatus.getText();
		return AccountStatus;
	}
	
	public String ProfilePageAccountName() {
		RingGObj.UserProfiles.click();
		String NavDrawerAccName = RingGObj.NavDrawerAccountName.getText();
		RingGObj.UserProfiles.click();
		return NavDrawerAccName;
	}

}
