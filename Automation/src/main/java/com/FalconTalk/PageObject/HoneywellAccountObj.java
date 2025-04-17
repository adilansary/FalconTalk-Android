package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HoneywellAccountObj {
	
	public HoneywellAccountObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_signin")
	public WebElement signin;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_signin_label")
	public WebElement signinText;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_signout")
	public WebElement SignOut;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_account_settings")
	public WebElement AccountSetting;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/falcontalk_login_instruction")
	public WebElement loginpage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/input_username")
	public WebElement usernameInput;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/input_password")
	public WebElement passwordInput;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_login")
	public WebElement loginButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_cancel")
	public WebElement cancelButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/forget_password")
	public WebElement forgotPassword;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialog_message")
	public WebElement dialogMessage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement dialogMessageOkButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_cancel")
	public WebElement dialogMessageNoButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_honeywell_login")
	public WebElement honeywellLoginButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/falcontalk_login_instruction")
	public WebElement honeywellLoginInstraction;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label_username")
	public WebElement labelUserName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label_password")
	public WebElement labelPassword;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/auto_discovery_failed_notice")
	public WebElement ConfigurationPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfile;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/domain_data")
	public WebElement Domain;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/status_data")
	public WebElement Status;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/display_name")
	public WebElement Name;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension_data")
	public WebElement Extension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_secure_status")
	public WebElement SecureButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement Back;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nazmun Nahar']")
	public WebElement SelectAccountName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_email_value")
	public WebElement EmainNav;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_resync")
	public WebElement ResyncHoneyWellAccount;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_change_password")
	public WebElement ChangePassNav;
	
	@AndroidFindBy(id = "android:id/title")
	public WebElement dialogTitel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatusOnline;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Password']")
	public WebElement ChangePasswordPage;
	
	
	
	

	
	
	
	
	
	
	
	

}
