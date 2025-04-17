package com.FalconTalk.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HistoryFunctionalityObj {
	public HistoryFunctionalityObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_call_button")
	public WebElement CallBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_call_incall_hang_round")
	public WebElement CallEndBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='HISTORY']")
	public WebElement History;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/recent_all_btn")
	public WebElement AllBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/recent_missed_btn")
	public WebElement MissedBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_full_name")
	public List<WebElement> ContactName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/call_type_text")
	public List<WebElement> CallType;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/call_time")
	public List<WebElement> CallTime;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/message_call_status")
	public List<WebElement> CallStatus;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/communication_date_string")
	public List<WebElement> CallDate;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_item_delete")
	public WebElement HistoryDeleteBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement dilogYesBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement PageBack;
}
