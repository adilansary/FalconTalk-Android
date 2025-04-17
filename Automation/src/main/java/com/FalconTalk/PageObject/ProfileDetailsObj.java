package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileDetailsObj {
	
	public ProfileDetailsObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/manufacturer_logo")
	public WebElement manufacturerLogo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_cabin_router_name")
	public WebElement routerName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_name")
	public WebElement profileName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_domain")
	public WebElement profileDomain;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_extension")
	public WebElement profileExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_dial_plans")
	public WebElement profileDialPlans;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_done")
	public WebElement profileApplyButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_cancel")
	public WebElement profileCancelButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/status_data")
	public WebElement profileStatusData;
	
	@AndroidFindBy(xpath = "com.dassault.HONfalcontalk:id/extension_data")
	public WebElement profileaccountSelect;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_account_settings")
	public WebElement accountsettings;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement profileBack;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_selection_instruction")
	public WebElement ringgrouppage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/apply_button")
	public WebElement ringGroupApplyButton;
}
