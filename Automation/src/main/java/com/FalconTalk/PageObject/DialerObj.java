package com.FalconTalk.PageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DialerObj {
	public DialerObj(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/number_plate_edit_text")
	public WebElement Textshow;
	
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_1")
	public WebElement KeypadOne;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_2")
	public WebElement KeypadTwo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_3")
	public WebElement KeypadThree;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_4")
	public WebElement KeypadFour;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_5")
	public WebElement KeypadFive;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_6")
	public WebElement KeypadSix;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_7")
	public WebElement KeypadSeven;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_8")
	public WebElement KeypadEight;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_9")
	public WebElement KeypadNine;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_0")
	public WebElement KeypadZero;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_star")
	public WebElement KeypadStar;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_dialer_buttons_asterisk")
	public WebElement KeypadAsterisk;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_del")
	public WebElement NumberDelete;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_add")
	public WebElement ContactAdd;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_call_button")
	public WebElement CallDialerButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfiles;
	
	
	
	
}
