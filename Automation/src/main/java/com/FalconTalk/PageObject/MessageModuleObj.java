package com.FalconTalk.PageObject;

import com.FalconTalk.Config.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessageModuleObj {
	public MessageModuleObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;

	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfile;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_signin")
	public WebElement signin;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='MESSAGES']")
	public WebElement Messages;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTACTS']")
	public WebElement Contacts;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='HISTORY']")
	public WebElement History;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='2']")
	public WebElement NMessages;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/compose_msg")
	public WebElement NewMessage;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement TostMessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Message']")
	public WebElement NewMessagePage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_resync")
	public WebElement ResyncHoneyWellAccount;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement dialogMessageOkButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	public WebElement AddBuddy;
	
	@AndroidFindBy(id="com.dassault.HONfalcontalk:id/chips_input")
	public WebElement AddBuddys;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/delete_button")
	public List<WebElement> DeleteBuddy;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/chat_textinput")
	public WebElement ChatTextInput;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/chatTextSendButton")
	public WebElement SendButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/attach_file")
	public WebElement AttachFileButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose file']")
	public WebElement ChooseFile;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose picture']")
	public WebElement ChoosePicture;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Take picture']")
	public WebElement TakePicture;
	
	@AndroidFindBy(xpath = "//GLButton[@text='Take picture']")
	public WebElement CapturePicture;
	
	@AndroidFindBy(id = "com.sec.android.app.camera:id/okay")
	public WebElement OkPicture;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label")
	public List<WebElement> SelectBuddyName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/info")
	public List<WebElement> SelectBuddyNumber;
	
	
	//Message Body
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/message_body")
	public List<WebElement> MessageBody;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/date_n_time")
	public List<WebElement> MessagSentTime;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/message_status")
	public List<WebElement> MessageStatus;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/message_status")
	public WebElement MessageState;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/security_indicator")
	public List<WebElement> SecurityIndicator;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/security_indicator")
	public WebElement SecurityIndicate;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_list_btn")
	public WebElement FavoritesBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_list_btn")
	public WebElement ContactsBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/buddy_list_btn")
	public WebElement BuddiesBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/text_own_number")
	public WebElement MyNumber;
	
	@AndroidFindBy(id = "android:id/search_button")
	public WebElement ContactSearch;
	
	@AndroidFindBy(id = "android:id/search_src_text")
	public WebElement SearchText;
	
	@AndroidFindBy(id = "android:id/search_close_btn")
	public WebElement SearchCloseBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_message")
	public WebElement BuddyDetailsMessageButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement PageBack;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_name")
	public WebElement ContactName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_call")
	public WebElement CallFromContactDetails;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_delete_contact")
	public WebElement DeleteContactFromContactDetails;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_edit_contact")
	public WebElement EditContactFromContactDetails;
	
	//Favorites
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact")
	public WebElement AddtoFavorites;
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact_info")
	public WebElement FavoritesDetails;
	
	//History
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mohiuddin Maruf']")
	public WebElement HistoryDetails;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mohiuddin Maruf']")
	public WebElement MohiuddinMaruf;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nahid Hossain']")
	public WebElement NahidHossain;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mohammed Hasan Murad']")
	public WebElement MohammedHasanMurad;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/no_messages")
	public WebElement NoMessageFound;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_item_message")
	public WebElement HistoryDetailsMessagebtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_secure_status")
	public WebElement SecureStatus;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_proceed")
	public WebElement PopUpProcessBtn;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_account_settings")
	public WebElement AccountSettings;
	
	@AndroidFindBy(id = "com.android.documentsui:id/icon_mime_lg")
	public List<WebElement> SelectImage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/attach_image_thumbnail")
	public WebElement AttatchImage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/message_image")
	public WebElement MessageImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete message']")
	public WebElement DeleteMessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete Message']")
	public WebElement DeleteMessages;
	
	@AndroidFindBy(className = "android.view.View")
	public WebElement SelectImageClass;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
	public WebElement MoreOptions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add to Contacts']")
	public WebElement AddToContacts;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete Message Thread']")
	public WebElement DeleteMessageThread;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/msg_menu_item_delete")
	public WebElement DeleteMessagesIcon;

	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement YesButtton;

	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/chatting_name")
	public List<WebElement> BuddyNameOnMessageList;

}
