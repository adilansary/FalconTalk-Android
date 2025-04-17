package com.FalconTalk.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Data.HonweywellAccountData;
import com.FalconTalk.PageObject.MessageModuleObj;
import com.FalconTalk.Utils.Utils;

import java.time.Duration;

public class MessageModulePage {
	MessageModuleObj MessageModuleObje = new MessageModuleObj();
	Utils utils = new Utils();
	By byNewMessage = By.id("com.dassault.HONfalcontalk:id/compose_msg");
	//By bySearchBuddy = By.xpath("//android.widget.EditText[@Text='Add Buddy']");
	
	public void NavigationdDrawerOpen() {
		try {
			MessageModuleObje.NavigationDrawer.click();
		}catch(Exception e) {
			MessageModuleObje.UserProfile.click();
			MessageModuleObje.NavigationDrawer.click();
		}
		
	}
	public void getSecureOnorOff(String Status) {
		if(Status.equals("On")) {
			
			String SecurityStatusCheck0 = MessageModuleObje.SecureStatus.getText();
			if(SecurityStatusCheck0.equals("Secure On")) {
				System.out.println("Secure is alrady On");
			}else {
				MessageModuleObje.SecureStatus.click();
				MessageModuleObje.PopUpProcessBtn.click();
			}
		}
		else if(Status.equals("Off")) {
			
			String SecurityStatusCheck1 = MessageModuleObje.SecureStatus.getText();
			if(SecurityStatusCheck1.equals("Secure Off")) {
				System.out.println("Secure is alrady off");
			}else {
				MessageModuleObje.SecureStatus.click();
				MessageModuleObje.PopUpProcessBtn.click();
			}
		}
	}
	
	public void getAccountSetting() {
		MessageModuleObje.AccountSettings.click();
	}
	
	public void NavigationDrawerClose() {
		try {
			MessageModuleObje.NavigationDrawer.isEnabled();
		}catch(Exception e) {
			MessageModuleObje.UserProfile.click();
		}
	}
	
	public void getBack() {
		MessageModuleObje.PageBack.click();
	}
	
	public boolean MessageModuleOnlineCheck() {
		try {
			tostMessage();
		}catch(Exception e) {
			return true;
		}
		return false;
	}
	
	public void ResyncAccForMessageModule() throws InterruptedException {
		Thread.sleep(100);
		NavigationdDrawerOpen();
		MessageModuleObje.ResyncHoneyWellAccount.click();
		Thread.sleep(6000);
		MessageModuleObje.dialogMessageOkButton.click();
	}
	
	public void CheckSinginOrNot() {
		try {
			MessageModuleObje.signin.click();
			Thread.sleep(100);
			HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
			honweywellAccountPage.ClearUserName();
			honweywellAccountPage.InputUserName(HonweywellAccountData.UsernameInput);
			honweywellAccountPage.ClearPassword();
			honweywellAccountPage.InputPassword(HonweywellAccountData.PasswordInput);
			honweywellAccountPage.LoginButtonPress();
			Thread.sleep(6000);
		}catch(Exception e) {
			NavigationDrawerClose();
		}
	}
	
	public void SignIn() throws InterruptedException {
		//MessageModuleObje.signin.click();
		CheckSinginOrNot();
		
		MessageModuleObje.Messages.click();
		Thread.sleep(1000);
	}
	public void getMessagePage(){
		MessageModuleObje.Messages.click();
	}
	public void getMessageModule() {
		MessageModuleObje.Messages.click();
	}
	public void SentNewMessage() {
		MessageModuleObje.NewMessage.click();
	}
	public String tostMessage() {
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNewMessage));
		try {
			MessageModuleObje.NewMessage.click();
		}catch(Exception e) {System.out.println("No tost message found");}
		
		return MessageModuleObje.TostMessage.getText();
	}
	public void newMessageSent(){
		MessageModuleObje.NewMessage.click();
	}
	
	public String getNewMessagePage() {
		//MessageModuleObje.NMessages.click();
		return MessageModuleObje.NewMessagePage.getText();
	}
	
	public String BuddySearchName(String SearchValue) {
		//new WebDriverWait(AppDriver.getDriver(),20).until(ExpectedConditions.presenceOfElementLocated(bySearchBuddy));
		MessageModuleObje.AddBuddy.click();
		MessageModuleObje.AddBuddy.sendKeys(SearchValue);
		String Name = MessageModuleObje.SelectBuddyName.get(0).getText();
		MessageModuleObje.SelectBuddyName.get(0).click();
		return Name;
	}
	
	public String BuddySearchNumber(String SearchValue) {
		MessageModuleObje.AddBuddy.click();
		MessageModuleObje.AddBuddy.sendKeys(SearchValue);
		String Number = MessageModuleObje.SelectBuddyNumber.get(0).getText();
		MessageModuleObje.SelectBuddyNumber.get(0).click();
		return Number;
	}
	
	public String BuddyRemove() {
		MessageModuleObje.DeleteBuddy.get(0).click();
		return MessageModuleObje.SelectBuddyName.get(0).getText();
	}
	
	public boolean getMessageBody(String MessageBody) throws InterruptedException {
		MessageModuleObje.ChatTextInput.click();
		MessageModuleObje.ChatTextInput.sendKeys(MessageBody);
		MessageModuleObje.SendButton.click();
		Thread.sleep(1000);
		return MessageModuleObje.SecurityIndicator.get(0).isDisplayed();
	}
	
	public boolean getMessageBodys(String MessageBody) throws InterruptedException {
		MessageModuleObje.ChatTextInput.click();
		MessageModuleObje.ChatTextInput.sendKeys(MessageBody);
		MessageModuleObje.SendButton.click();
		Thread.sleep(1000);
		return MessageModuleObje.MessageState.isDisplayed();
	}

	public void sentMessage(String message){
		MessageModuleObje.ChatTextInput.sendKeys(message);
		MessageModuleObje.SendButton.click();
	}
	
	public boolean getDetailsToMessage(int index,String SearchText,int performe) throws InterruptedException {
		boolean result=false;
		MessageModuleObje.Contacts.click();
		if(index==1) {
			MessageModuleObje.FavoritesBtn.click();
		}
		else if(index==2) {
			MessageModuleObje.ContactsBtn.click();
		}
		else if(index==3) {
			MessageModuleObje.BuddiesBtn.click();
		}
		if(index==0) {}else {
		MessageModuleObje.ContactSearch.click();
		MessageModuleObje.SearchText.sendKeys(SearchText);
		MessageModuleObje.ContactName.click();
		}
		if(performe==0) {
			addToFavorites();
		}
		else if(performe==1) {
			MessageModuleObje.BuddyDetailsMessageButton.click();
		}
		else if(performe==2) {
			MessageModuleObje.CallFromContactDetails.click();
		}
		else if(performe==3) {
			MessageModuleObje.EditContactFromContactDetails.click();
		}
		else if(performe==4) {
			MessageModuleObje.DeleteContactFromContactDetails.click();
		}
		if(performe==0) {}else {
			result =getMessageBody("Hi Test");
		}
		
		return result;
	}
	
	public void addToFavorites() {
		
		MessageModuleObje.AddtoFavorites.click();
	}
	
	public void getFavoriteDetails() {
		MessageModuleObje.FavoritesBtn.click();
		MessageModuleObje.FavoritesDetails.click();
	}
	public boolean SentMessageFromFavoriteDetails(String MessageBody) throws InterruptedException {
		MessageModuleObje.BuddyDetailsMessageButton.click();
		boolean result=getMessageBody(MessageBody);
		return result;
	}
	
	public void getHistoryModule() {
		MessageModuleObje.History.click();
	}
	public void getHistoryDetails() {
		MessageModuleObje.HistoryDetails.click();
	}
	public boolean SentmessageFromHistoryDetails(String MessageBody) throws InterruptedException {
		MessageModuleObje.HistoryDetailsMessagebtn.click();
		boolean results=getMessageBody(MessageBody);
		return results;
	}
	
	public boolean getSecurityIndicate() {
		try {
			MessageModuleObje.SecurityIndicate.isDisplayed();
			return true;}
		catch(Exception e) {return false;}
		
	}
	public boolean sentImage(String SetType) throws InterruptedException {
		MessageModuleObje.AttachFileButton.click();
		if(SetType.equals("Choose picture")) {
			MessageModuleObje.ChoosePicture.click();
			try {
				MessageModuleObje.SelectImage.get(0).click();
			}catch(Exception e) {
				try {
					MessageModuleObje.SelectImageClass.click();
				}catch(Exception ex) {
					
				}
			}
			
		}else if(SetType.equals("Take picture")) {
			MessageModuleObje.TakePicture.click();
			Thread.sleep(5000);
			MessageModuleObje.CapturePicture.click();
			Thread.sleep(5000);
			MessageModuleObje.OkPicture.click();
			Thread.sleep(1000);
		}
		
		boolean attatchImage = MessageModuleObje.AttatchImage.isDisplayed();
		MessageModuleObje.SendButton.click();
		Thread.sleep(2000);
		boolean SentImage = MessageModuleObje.MessageImage.isDisplayed();
		if(attatchImage==true && SentImage==true) {
			return true;
		}else {
			return false;
		}
	}
	
	public void longPress(String DeleteText) throws InterruptedException {
		getMessageBodys(DeleteText);
		utils.longPress(MessageModuleObje.DeleteMessage);
		Thread.sleep(5000);
		MessageModuleObje.DeleteMessages.click();
		Thread.sleep(1000);
		MessageModuleObje.dialogMessageOkButton.click();
	}
	
	public boolean varifyMessageDeleteOrNot() {
		try {
			MessageModuleObje.DeleteMessage.isDisplayed();
			
		}catch(Exception e) {
			return true;
		}
		return false;
	}
	public boolean DeleteMessageThread() throws InterruptedException {
		MessageModuleObje.MoreOptions.click();
		MessageModuleObje.DeleteMessageThread.click();
		MessageModuleObje.dialogMessageOkButton.click();
		Thread.sleep(2000);
		try {
			MessageModuleObje.HistoryDetails.isDisplayed();
		}catch(Exception e) {
			return true;
		}
		return false;
		
	}
	
	public boolean DeleteFromMessages() throws InterruptedException {
		utils.longPress(MessageModuleObje.HistoryDetails);
		Thread.sleep(5000);
		MessageModuleObje.DeleteMessagesIcon.click();
		MessageModuleObje.dialogMessageOkButton.click();
		try {
			MessageModuleObje.HistoryDetails.isDisplayed();
		}catch(Exception ex) {
			return true;
		}
		return false;
	}

	public void getMoreOptionsFromMessageThread(){
		MessageModuleObje.MoreOptions.click();
	}

	public void getAddToContactFromMessageThread(){
		MessageModuleObje.AddToContacts.click();
		MessageModuleObje.YesButtton.click();
	}



	public boolean SearchInMessages(String Buddyname) {
		MessageModuleObje.ContactSearch.click();
		MessageModuleObje.SearchText.sendKeys(Buddyname);
		try {
			if(Buddyname.equals("Mohammed Hasan Murad")) {
			MessageModuleObje.MohammedHasanMurad.isDisplayed();
			}
			else if(Buddyname.equals("Mohiuddin Mohammad Maruf")) {
				MessageModuleObje.MohiuddinMaruf.isDisplayed();
			}
			else if(Buddyname.equals("Nahid Hossain")) {
				MessageModuleObje.NahidHossain.isDisplayed();
			}
			else {
				MessageModuleObje.NoMessageFound.isDisplayed();
			}
		}catch(Exception e) {
			System.out.print("Fail to Search");
			MessageModuleObje.SearchCloseBtn.click();
			MessageModuleObje.SearchCloseBtn.click();
			return false;
		}
		MessageModuleObje.SearchCloseBtn.click();
		MessageModuleObje.SearchCloseBtn.click();
		return true;
	}

	public String getBuddyNameOnMessageList(int index){
		return MessageModuleObje.BuddyNameOnMessageList.get(index).getText();
	}
	public void getBuddyNameOnMessgeThread(){
		//TODO Code
	}


}
