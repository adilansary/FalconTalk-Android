package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreviousConfigObj {
	public PreviousConfigObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/falcontalklogo")
	public WebElement Logo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/selection_instruction")
	public WebElement SelectionIns;
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_router")
	public WebElement RouterName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_extension_label")
	public WebElement ExtensionLebel;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_ring_group_label")
	public WebElement RingGroupLabel;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_display_name_label")
	public WebElement DisplayNameLabel;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_extension")
	public WebElement PreExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_ring_group")
	public WebElement PreRingGroup;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_display_name")
	public WebElement PreDisplayName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/ok_button")
	public WebElement OkButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/search_button")
	public WebElement ChangeButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/previous_config_container")
	public WebElement PreviousConfigContainer;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_extension")
	public WebElement NavDrawerAccInfo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_autodiscover_extension_label")
	public WebElement RetryAutoConfig;

}
