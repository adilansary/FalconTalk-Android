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

class MessageModule_NonSecure {
	@BeforeTest()
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		//messagepage.Setup();
	}
	
	@Test(priority=0,description="Verify the Secure Status")
	public void CheckSecureStatusTest() throws InterruptedException {
		Thread.sleep(100);
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.NavigationdDrawerOpen();
		messagepage.SignIn();
		Thread.sleep(100);
		messagepage.NavigationdDrawerOpen();
		Thread.sleep(4000);
		messagepage.SignIn();
		Thread.sleep(4000);
		messagepage.NavigationdDrawerOpen();
		Thread.sleep(2000);
		messagepage.getAccountSetting();
		Thread.sleep(2000);
		messagepage.getSecureOnorOff("Off");
		Thread.sleep(2000);
		messagepage.getBack();
	}
	@Test(priority=1,description="Verify if non secure message can be sent with auto provisioned account when secured option is disabled")
	public void SentNonSecureMessageTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.getMessageModule();
		messagepage.SentNewMessage();
		messagepage.BuddySearchName("Mohiuddin Mohammad Maruf");
		Assert.assertEquals(messagepage.getMessageBodys("Non Secure Message Test"), true, "Non Secure Message is not Sent");
		
	}
	
	@Test(priority=2,description="Verify if lock icon is removed on the end where secured option is disabled for non secured sent message")
	public void SecurityiConTest() {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.getSecurityIndicate();
		Assert.assertEquals(messagepage.getSecurityIndicate(), false, "Secure icon is still showing");
	}
	@Test(priority=3,description="Verify if message can be sent and received with different variable Phone number")
	public void SentPhoneNumberTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getMessageBodys(MessageModuleData.PhoneNumber), true, "Message sent with phone number");
	}
	
	@Test(priority=4,description="Verify if message can be sent and received with different variable \"Email ID\"")
	public void SentEmailIdTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getMessageBodys(MessageModuleData.EmailID), true, "Message sent with phone number");
	}
	
	@Test(priority=5,description="Verify if message can be sent and received with different variable \"Web URL\"")
	public void SentWebURLTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.getMessageBodys(MessageModuleData.WebURL), true, "Message sent with phone number");
	}
	
	@Test(priority=6,description="Verify if message can be sent and received by attached \"Photo/Picture\"")
	public void SentImageTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		Assert.assertEquals(messagepage.sentImage("Choose picture"), true, "Image is not sent");
	}
	
	@Test(priority=7,description="Verify if message can be sent and by Take Picture")
	public void TakeImageTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.sentImage("Take picture");
	}
	
	@Test(priority=8,description="Verify if single text message can be deleted from message thread")
	public void DeleteMessageTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.longPress("Delete message");
		Assert.assertEquals(messagepage.varifyMessageDeleteOrNot(), true, "Message is not delete");
	}
	
	@Test(priority=9,description="Verify if message thread can be deleted from Message thread->Delete Message Thread")
	public void DeleteMessageThreadTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		
		Assert.assertEquals(messagepage.DeleteMessageThread(), true, "Message Thread is not delete");
	}
	
	@Test(priority=10,description="Verify if message thread can be deleted from Messages list")
	public void DeleteMessages() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.SentNewMessage();
		messagepage.BuddySearchName("Mohiuddin Mohammad Maruf");
		messagepage.getMessageBodys("Delte");
		messagepage.getBack();
		System.out.println(messagepage.DeleteFromMessages());
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
