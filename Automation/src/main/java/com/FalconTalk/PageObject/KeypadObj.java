package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class KeypadObj {
	public KeypadObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Axxess']")
	public WebElement SelectAccountNameAxxess;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (Legacy)']")
	public WebElement SelectAccountNameLegacy;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CG-710 (FC)']")
	public WebElement SelectAccountNameFC;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CNX-900']")
	public WebElement SelectAccountNameCNX;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GDR']")
	public WebElement SelectAccountNameGDR;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SDR']")
	public WebElement SelectAccountNameSDR;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Not Ready']")
	public WebElement SelectAccountNameNotReady;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Custom']")
	public WebElement SelectAccountNameCustom;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatus;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatusOnline;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFLINE']")
	public WebElement SelectAccountStatusOffline;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfiles;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_name")
	public WebElement AccountNameNavDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_extension")
	public WebElement ExtensionNavDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/profile_selection")
	public WebElement ProfileSelection;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_1")
	public WebElement dialer1;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_2")
	public WebElement dialer2;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_3")
	public WebElement dialer3;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_4")
	public WebElement dialer4;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_5")
	public WebElement dialer5;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_6")
	public WebElement dialer6;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_7")
	public WebElement dialer7;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_8")
	public WebElement dialer8;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_9")
	public WebElement dialer9;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_0")
	public WebElement dialer0;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_star")
	public WebElement dialer1Star;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_text_asterisk")
	public WebElement dialer1Hash;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_addAccount_label")
	public WebElement addAccount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTACTS']")
	public WebElement Contacts;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_own_number")
	public WebElement OwnNumber;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/own_number_title")
	public WebElement MyNumberTxt;

	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_del")
	public WebElement button_del;
	
}

