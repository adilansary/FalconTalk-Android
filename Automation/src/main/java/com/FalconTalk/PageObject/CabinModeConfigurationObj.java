package com.FalconTalk.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CabinModeConfigurationObj {
	public CabinModeConfigurationObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_cabin_settings")
	public WebElement configureCabinDevice;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_button")
	public WebElement cabinPage;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement TostMessage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_validate_button")
	public WebElement validateButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_mode_password")
	public WebElement cabinModePassword;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_selection_instruction")
	public WebElement cabinModePage;
	
	//Page Object of Cabin Page
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_axxess_extension")
	public WebElement cabinAxxessExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_cg710_legacy_extension")
	public WebElement cabinCG_710LegacyExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_cg710_fc_extension")
	public WebElement cabinCG_710FCExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_cnx900_extension")
	public WebElement cabinCNX_900Extension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_gdr_extension")
	public WebElement cabinGDRExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/cabin_sdr_extension")
	public WebElement cabinSDRExtension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension") //Router extension List 
	public List<WebElement> extensionList;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/display_name")
	public WebElement displayName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/apply_button")
	public WebElement applyButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/welcome_text")
	public WebElement autoDiscoverPage;
	

}
