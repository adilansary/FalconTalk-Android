package com.FalconTalk.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileObj {
	public ProfileObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfile;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_autodiscover_extension")
	public WebElement retryAutoConfig;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/routerDomain") //Router List on Auto Discover Page
	public List<WebElement> routerList;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/pilot_extension")
	public WebElement ringgrouppasswordfield;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_account_settings")
	public WebElement accountsettings;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_add_profile")
	public WebElement addprofilebutton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/spinner_drop_down_box")
	public WebElement dropdownbox;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/custom_spinner_item_name") //com.dassault.HONfalcontalk:id/custom_spinner_item_name
	public List<WebElement> manufacturersName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_done")
	public WebElement applybuttonprofile;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_cancel")
	public WebElement cancelbuttonprofile;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label_cabin_selection")
	public WebElement cabinselectionpage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_cabin_router_name")
	public WebElement customroutername;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/manufacturer_logo")
	public WebElement manufacturerLogo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_domain")
	public WebElement profileDomain;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_name")
	public WebElement profileName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_extension")
	public WebElement extensionSelect;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/display_name")
	public WebElement displayName;
	
	//For Custom Account
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_display_name")
	public WebElement displayNameonCustom;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_domain")
	public WebElement domainNameonCustom;
	
	@AndroidFindBy(id= "com.dassault.HONfalcontalk:id/spinner_drop_down_box")
	public WebElement protocolSelectonCustom;
	
	@AndroidFindBy(id= "com.dassault.HONfalcontalk:id/text_profile_extension")
	public WebElement extensiononCustom;
	
	@AndroidFindBy(id= "com.dassault.HONfalcontalk:id/text_profile_password")
	public WebElement passwordonCustom;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_done")
	public WebElement applyonCustom;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_profile_done") //apply button list view
	public List<WebElement> getItemApplyButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/status_data") //account status
	public List<WebElement> accountStatusData;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_data") //account Extension
	public List<WebElement> accountExtensionData;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/switch_enabled") //Account Enable/Disable switch
	public List<WebElement> accountEnableSwitch;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_cabin_router_name") //Account Enable/Disable switch
	public List<WebElement> textCabinRoutername;
	
	//For Ring Group
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_selection_instruction")
	public WebElement RingGroupPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gogo']")
	public WebElement gogo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Honeywell']")
	public WebElement honeywell;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Satcom Direct']")
	public WebElement satcomDirect;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Custom']")
	public WebElement custom;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Axxess']")
	public WebElement axxess;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (Legacy)']")
	public WebElement legacy;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (FC)']")
	public WebElement fc;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CNX-900']")
	public WebElement cnx900;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GDR']")
	public WebElement gdr;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SDR']")
	public WebElement sdr;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIP']")
	public WebElement sip;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='IAX']")
	public WebElement iax;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement Back;

}
