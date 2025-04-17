package com.FalconTalk.PageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AboutObj {
	public AboutObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	public static final String EULA_HEADER = "License Agreement";
	public static final String PRIVACY_HAEDR = "Privacy Statement";
	public static final String ABOUT_FOOTER= "© Dassault Aviation SA.";
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_about")
	public WebElement NavAbout;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FalconTalk']")
	public WebElement AppName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
	public WebElement About;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='End User License Agreement']" )
	public WebElement EULA;
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text = 'License Agreement']")
	public WebElement LAPage;
	
	@AndroidFindBy(xpath = "//com.dassault.HONfalcontalk:id/pdfView")
	public WebElement LAPageView;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement LAPageBack;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Statement']")
	public WebElement PrivacyStatement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Statement']")
	public WebElement PSPage;
	
	@AndroidFindBy(xpath = "android.webkit.WebView[@text='privacy_statement']")
	public WebElement PSPageView;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement PSPageBack;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement AboutBackButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/footer_message")
	public WebElement AboutFooter;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	
}
