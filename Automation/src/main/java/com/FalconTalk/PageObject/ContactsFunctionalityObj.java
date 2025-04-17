package com.FalconTalk.PageObject;

import com.FalconTalk.Config.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsFunctionalityObj {
    public ContactsFunctionalityObj() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTACTS']")
    public WebElement Contacts;
    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_list_btn")
    public WebElement ContactsList;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
    public WebElement Keypad;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_add")
    public WebElement ContactsAddFromKeypad;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_call_incall_hang_round")
    public WebElement endCall;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/create_contact_button")
    public WebElement CreateNewContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HISTORY']")
    public WebElement History;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/recent_all_btn")
    public WebElement HistoryAllList;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/recent_missed_btn")
    public WebElement HistoryMissedList;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_name") //Router List on Auto Discover Page
    public List<WebElement> ContactName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/add_fab")
    public WebElement addFavorit;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement NavigationBack;

    //Contact For Samsung Galaxy Tab A
    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/arrowButton")
    public WebElement ArrowButton;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/prefixEdit")
    public WebElement NamePrefix;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/firstEdit")
    public WebElement FirstName;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/middleEdit")
    public WebElement MiddleName;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/lastEdit")
    public WebElement LastName;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/suffixEdit")
    public WebElement NameSuffix;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone']")
    public WebElement PhoneNumberClick;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
    public WebElement PhoneNumberInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    public WebElement EmailClink;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
    public WebElement EmailInput;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/menu_done")
    public WebElement SaveButton;

    //Contact Search Object
    @AndroidFindBy(id = "android:id/search_button")
    public WebElement SearchBtn;

    @AndroidFindBy(id = "android:id/search_close_btn")
    public WebElement SearchClose;

    @AndroidFindBy(id = "android:id/search_src_text")
    public WebElement SearchKeyword;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_name")
    public WebElement ContactSearchList;

    //Contact Details Page

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Details']")
    public WebElement ContactDetailsPage;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_delete_contact")
    public WebElement ContactDelete;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_edit_contact")
    public WebElement ContactEdit;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_call")
    public WebElement CallFromContactDetails;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_message")
    public WebElement MessageFromContactDetails;

    //Call Screen Element
    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/outgoing_caller_name")
    public WebElement CallerName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/outgoing_call_status")
    public WebElement CallStatus;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement CallHold;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement DTMFKeypad;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement Speaker;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement CallMute;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement CallAddCall;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/hold")
    public WebElement CallTransfer;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/view_call_incall_hang_round")
    public WebElement CallEnd;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialer_call_button")
    public WebElement callFromKeypad;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/search_src_text")
    public WebElement SearchForExistingContact;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/nameEdit")
    public WebElement EditContactName;
    //History page Element

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_full_name")
    public List<WebElement> AllCallListOnHistoryPage;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/contact_list_item_main")
    public List<WebElement> ContactDetails;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_item_add_to_contact")
    public WebElement AddContactFromHistoryDetails;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/buddy_list_btn")
    public WebElement BuddyList;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/buddy_display_name")
    public WebElement BuddiesDisplayName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_full_name")
    public WebElement BuddiesDetailsName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/listTitle")
    public List<WebElement> AccountList;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/action_add_buddy")
    public WebElement AddBuddyInContacts;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
    public WebElement Pop_Up_Yes;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/empty_buddy_notice")
    public List<WebElement> EmptyBuddyNotice;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/msg_button_call")
    public WebElement Call_From_Buddy_Details_UnSaveName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_call")
    public WebElement Call_From_Buddy_Details_SaveName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/msg_button_message")
    public WebElement Message_From_Buddy_Details_UnSaveName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_message")
    public WebElement Message_From_Buddy_Details_SaveName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]")
    public WebElement MessageThreadName;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/chatting_name")
    public List<WebElement> MessageListChattingName;

    //For Multiple Number Save
    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/nameEdit")
    public WebElement Full_Name;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
    public List<WebElement> MultiplePhoneNumberInput;

    @AndroidFindBy(id = "com.samsung.android.app.contacts:id/plusImage")
    public WebElement Add_Second_Phone_Input_Field;

}


