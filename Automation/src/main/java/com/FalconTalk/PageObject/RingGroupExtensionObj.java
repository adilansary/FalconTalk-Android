package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RingGroupExtensionObj {
	public RingGroupExtensionObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	

	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/vvip_extension")
	public WebElement VVIPExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/vip_extension")
	public WebElement VIPExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/guest_extension")
	public WebElement GuestExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/pilot_extension")
	public WebElement PilotExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/secretary_extension")
	public WebElement SecretaryExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/pilot_extension")
	public WebElement CockpitExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/guest_extension")
	public WebElement CabinExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/display_name")
	public WebElement DisplayName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension")
	public WebElement Extension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/apply_button")
	public WebElement ApplyButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cancel_button")
	public WebElement CancelButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_name")
	public WebElement NavDrawerAccountName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Axxess']")
	public WebElement SelectAccountName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatus;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfiles;


}
