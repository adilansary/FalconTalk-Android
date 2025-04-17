package com.FalconTalk.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuddiesFunctionalityObj {
	public BuddiesFunctionalityObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfile;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTACTS']")
	public WebElement Contacts;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement PageBack;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_list_btn")
	public WebElement FavoritesBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_list_btn")
	public WebElement ContactsBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/buddy_list_btn")
	public WebElement BuddiesBtn;
	
	@AndroidFindBy(id = "android:id/search_button")
	public WebElement ContactSearch;
	
	@AndroidFindBy(id = "android:id/search_src_text")
	public WebElement SearchText;
	
	@AndroidFindBy(id = "android:id/search_close_btn")
	public WebElement SearchCloseBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/no_contacts")
	public WebElement NoContactFound;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_name")
	public List<WebElement> ContactSelect;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_delete_contact")
	public WebElement DeleteContact;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement YesBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_cancel")
	public WebElement NoBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialog_message")
	public WebElement DilogMessageBody;
	
	@AndroidFindBy(id = "android:id/title")
	public WebElement DilogMessageTitel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mohiuddin Maruf']")
	public WebElement MohiuddinMaruf;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nahid Hossain']")
	public WebElement NahidHossain;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mohammed Hasan Murad']")
	public WebElement MohammedHasanMurad;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/listTitle")
	public List<WebElement> OnlineOfflineBuddyList;
	
	@AndroidFindBy(id= "com.dassault.HONfalcontalk:id/buddy_display_name")
	public WebElement BuddyDisplayName;
	
	@AndroidFindBy(id= "com.dassault.HONfalcontalk:id/add_fab")
	public WebElement AddContacts;
	
}
