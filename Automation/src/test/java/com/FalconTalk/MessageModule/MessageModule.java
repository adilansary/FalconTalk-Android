package com.FalconTalk.MessageModule;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.MessageModuleData;
import com.FalconTalk.PageActions.MessageModulePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class MessageModule {
	
	@BeforeTest()
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		//messagepage.Setup();
	}
	
	@Test(priority=0)
	public void MessageModuleTest() throws InterruptedException {
		Thread.sleep(100);
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.NavigationdDrawerOpen();
		messagepage.SignIn();
	}
	
	@Test(priority=1,description="Verif if Message service related pop up message shows on Compose button press while Message service is unregistered")
	public void TostMessageTest() {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.tostMessage(),MessageModuleData.MessagenotRegisterTostMessage , "Wrong message");
	}
	
	@Test(priority=2,description="This Test if For Chacking That Message Module is Online or Not")
	public void MessageModuleOnline() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		int i=0;
		while(true) {
			if(messagepage.MessageModuleOnlineCheck() == true) {
				break;
			}else {
				Thread.sleep(5000);
				if(i==12) {
					messagepage.ResyncAccForMessageModule();
					i=0;
				}
				i++;
				continue;
			}
		}
	}
	
	@Test(priority=3,description="Verify if new message page is showing when press on create new message button from message list")
	public void NewMessagePageTest() throws InterruptedException {
		Thread.sleep(5000);
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getNewMessagePage(),"New Message" , "Cann't go to New Message Page");
		Thread.sleep(5000);
	}
	
	@Test(priority=4,description="Verify if buddy can be searched from message auto suggestion list with Buddy Name")
	public void BuddySearchWithNameTest() throws InterruptedException {
		Thread.sleep(5000);
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.BuddySearchName("Nahid Hossain"),"Nahid Hossain" , "Can't Get The Write Contact Name");
	}
	
	@Test(priority=5,description="Verify if buddy can be searched from message auto suggestion list with Buddy Number ")
	public void BuddySearchWithNumberTest() throws InterruptedException {
		Thread.sleep(100);
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.BuddySearchNumber("14805539877"),"14805539877" , "Can't Get The Write Contact Number");
	}
	
	@Test(priority=6,description="Verify if buddy can be added and removed from message auto suggestion list")
	public void BuddyAddAndRemoveTest() {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.BuddyRemove(),"Mohammed Hasan Murad" , "Can't Remove Buddy");
	}
	
	@Test(priority=7,description="Verify if secure message can be sent to that added buddy ")
	public void SentSecureMessageTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getMessageBody("Hello Falcon World To Talk"), true, "Can't sent Secure Message");
		messagepage.getBack();
	}
	
	@Test(priority=8,description="Verify if message can be sent to a buddy from Buddies module")
	public void SentMessageFromBuddiesTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getDetailsToMessage(2, "Mohiuddin Maruf",1), true, "Can't sent Secure Message");
		messagepage.getBack();
	}
	
	@Test(priority=9,description="Verify if message can be sent on condition that is a buddy from Favorites details")
	public void SentMessageFromFavoriteList() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.getDetailsToMessage(2, "Mohiuddin Maruf", 0);
		messagepage.getBack();
		messagepage.getFavoriteDetails();
		Assert.assertEquals(messagepage.SentMessageFromFavoriteDetails("Message From Favorite Details"), true, "Can't sent Secure Message");
		messagepage.getBack();
		
	}
	
	@Test(priority=10,description="Verify if message can be sent on condition that is a buddy from History details ")
	public void SentMessageFromHistoryDetails() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.getHistoryModule();
		Thread.sleep(4000);
		messagepage.getHistoryDetails();
		Assert.assertEquals(messagepage.SentmessageFromHistoryDetails("Message From History Details"), true, "Can't sent Secure Message");
	}
	
	
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

	
	
	
	
}
