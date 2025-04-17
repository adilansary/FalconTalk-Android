package com.FalconTalk.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DialPlansObj {
	
	public DialPlansObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_profile_dial_plans")
	public WebElement profileDialPlans;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_item_add_dial_plan")
	public WebElement DialPlansAddButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_save_settings")
	public WebElement DialPlansSaveButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/edit_text_dialplan_name")
	public WebElement DialPlansEnterName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/edit_text_match_number")
	public WebElement DialPlansEnterMatchNumber;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/edit_text_remove_pref")
	public WebElement DialPlansEnterRemovePrefix;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/edit_text_add_prefix")
	public WebElement DialPlansEnterAddPrefix;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/img_dialplan_info")
	//public WebElement DialPlansInfo;
	public List<WebElement> DialPlansInfo;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/img_drag_handle")
	public List<WebElement> DialPlansDragHandle;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_dial_plan_name")
	public List<WebElement> DialPlansName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_view_hint")
	public WebElement DialPlansTextHint;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_item_delete")
	public WebElement DialPlanDelete;

}
