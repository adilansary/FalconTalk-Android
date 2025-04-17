package com.FalconTalk.PageActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.KeypadObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class KeypadPage {
	KeypadObj keypad = new KeypadObj();
	public KeypadPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	public static final String PROFILE_STATUS_ONLINE = "ONLINE";
	public static final String PROFILE_STATUS_OFFLINE = "OFFLINE";
	
	By byKeypad = By.xpath("//android.widget.TextView[@text='KEYPAD']");
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	By byAccountNameNavDrawer = By.id("com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_name");
	
	
	public String ProfileName() {
		String ProfileName;
		//String ProfileNameXpath = "//android.widget.TextView[@text='Axxess']";
		System.out.println("Keypad Page Start");
		AppDriver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(120)).until(ExpectedConditions.presenceOfElementLocated(byKeypad));
		keypad.Keypad.click();
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			
		}
		ProfileName = keypad.SelectAccountNameAxxess.getText();
		
		System.out.println(ProfileName);
		return ProfileName;
	}
	public boolean ObjectFoundorNot(String xpath) {
		try {
	        AppDriver.getDriver().findElement(By.id(xpath));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
		
	}
	public String getSelectedRouter(){
		GlobalUtilsPage gup = new GlobalUtilsPage();
		System.out.println(gup.getSelectRouter());
		if(gup.getSelectRouter().equals("Axxess")){
			return gup.getSelectRouter();
		}
		else if(gup.getSelectRouter().equals("CG-710 (Legacy)")){
			return gup.getSelectRouter();
		}
		else if(gup.getSelectRouter().equals("CG-710 (FC)")){
			return gup.getSelectRouter();
		}
		else if(gup.getSelectRouter().equals("CNX-900")){
			return gup.getSelectRouter();
		}
		else if(gup.getSelectRouter().equals("GDR")){
			return gup.getSelectRouter();
		}
		else if(gup.getSelectRouter().equals("SDR")){
			return gup.getSelectRouter();
		}
		return gup.getSelectRouter();
	}


	public String AccountStatus() { //Return Account Status from Keypad module
		//String Online = "//android.widget.TextView[@text='ONLINE']";
		String ProfileStatus;
			ProfileStatus = keypad.SelectAccountStatusOnline.getText();
		return ProfileStatus;
	}
	
	public String ProfileNameNave() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(50)).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		keypad.NavigationDrawer.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(80)).until(ExpectedConditions.presenceOfElementLocated(byAccountNameNavDrawer));
		String AccountName = keypad.AccountNameNavDrawer.getText();
		System.out.println(AccountName);
		return AccountName;
	}
	
	public String AccountStatusNave() { //Return Account Status from navigation drawer
		String statusNav = keypad.SelectAccountStatus.getText();
		//keypad.UserProfiles.click();
		System.out.println(statusNav);
		return statusNav;
	}
	
	public String getAccountNameCustom() { //Return Account Name from keypadModule
		System.out.println(keypad.SelectAccountNameCustom.getText());
		return keypad.SelectAccountNameCustom.getText();
	}
	
	public void getNavigationDrawerOpen() { //Open Navigation Drawer
		keypad.NavigationDrawer.click();
	}
	
	public String getAccountNameNav() { //return Account Name from nav drawer
		return keypad.AccountNameNavDrawer.getText();
	}
	
	public void getUserProfile() { // Click on user profile
		try {
			keypad.UserProfiles.click();
		}catch(Exception e) {
			
		}
	}
	public void getContactPage() {
		keypad.Contacts.click();
		keypad.Contacts.click();
	}
	public String getOwnNumber() {
		return keypad.OwnNumber.getText();
	}
	public String addAccount() {
		
			return keypad.addAccount.getText();
	}
	public String RingGroupAndExtensionName() {
		return keypad.ExtensionNavDrawer.getText();
	}
	
	public void typeNumberOnKeypad(String Number) {
		int i=0;
		for(i=0;i<Number.length();i++) {
			char num = Number.charAt(i);
			switch(num) {
			case '1':
				keypad.dialer1.click();
				break;
			case '2':
				keypad.dialer2.click();
				break;
			case '3':
				keypad.dialer3.click();
				break;
			case '4':
				keypad.dialer4.click();
				break;
			case '5':
				keypad.dialer5.click();
				break;
			case '6':
				keypad.dialer6.click();
				break;
			case '7':
				keypad.dialer7.click();
				break;
			case '8':
				keypad.dialer8.click();
				break;
			case '9':
				keypad.dialer9.click();
				break;
			case '0':
				keypad.dialer0.click();
				break;
			}
				
		}
	}

}
