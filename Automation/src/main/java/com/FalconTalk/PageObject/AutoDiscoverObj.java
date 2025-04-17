package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AutoDiscoverObj {
	public AutoDiscoverObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Axxess']")
	public WebElement Axxess;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (Legacy)']")
	public WebElement CgLegacy;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (FC)']")
	public WebElement CgFC;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CNX-900']")
	public WebElement Cnx;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GDR']")
	public WebElement Gdr;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SDR']")
	public WebElement Sdr;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/skip")
	public WebElement Skip;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_retry_automatic_configuration")
	public WebElement RetryAutoCOnfig;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_manual_configuration")
	public WebElement RetryManualCOnfig;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_cabin_mode_configuration")
	public WebElement CabinModeCOnfig;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_honeywell_login")
	public WebElement HoneywellLogin;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/auto_discovery_failed_notice")
	public WebElement AutoDiscoveryFailedNotice;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/auto_discovery_failed_instruction")
	public WebElement AutoDiscoveryFailedInstruction;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_selection_instruction")
	public WebElement ExtensionSelectionInstruction;
	
}
