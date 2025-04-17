package com.FalconTalk.MessageModule;


import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.MessageModulePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class MessageModule_Search {
	
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
		
		Thread.sleep(3000);
		messagepage.SentNewMessage();
		messagepage.BuddySearchName("Mohiuddin Mohammad Maruf");
		messagepage.getMessageBodys("Search Message 1");
		messagepage.getBack();
		Thread.sleep(3000);
		
		messagepage.SentNewMessage();
		messagepage.BuddySearchName("Mohammed Hasan Murad");
		messagepage.getMessageBodys("Search Message 2");
		messagepage.getBack();
		Thread.sleep(3000);
		
		messagepage.SentNewMessage();
		messagepage.BuddySearchName("Nahid Hossain");
		messagepage.getMessageBodys("Search Message 3");
		messagepage.getBack();
		Thread.sleep(3000);
	}
	
	@Test(priority=1,description="Verify if message search with Buddy Name then message search result is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	public void SearchWithBuddyNameTest() throws InterruptedException {
		MessageModulePage messagepage = new MessageModulePage();
		boolean SearchResult=messagepage.SearchInMessages("Mohammed Hasan Murad");
		Assert.assertEquals(SearchResult, true, "Search With Buddy Name Can't Work Properly");
	}
	
	@Test(priority=2,description="Verify if message search with saved Contact Name then message search result is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Search wiht the Conatct save name")
	public void SearchWithContactNameTest() {
		MessageModulePage messagepage = new MessageModulePage();
		boolean SearchResult=messagepage.SearchInMessages("Mohiuddin Mohammad Maruf");
		Assert.assertEquals(SearchResult, true, "Search With Contact Name Can't Work Properly");
	}
	
	@Test(priority=3,description="Verify if message search with Buddy Number then message search result is showing properly")
	public void SearchWithBuddyNumberTest() {
		MessageModulePage messagepage = new MessageModulePage();
		boolean SearchResult=messagepage.SearchInMessages("16506145382");
		Assert.assertEquals(SearchResult, true, "Search With Buddy Number Can't Work Properly");
	}
	
	@Test(priority=4,description="Verify if message search with Message sent and received text keyword then message search result is showing properly")
	public void SearchWithTextKeywordTest() {
		MessageModulePage messagepage = new MessageModulePage();
		boolean SearchResult=messagepage.SearchInMessages("Search Message 2");
		Assert.assertEquals(SearchResult, true, "Search With Text Keyword Can't Work Properly");
	}
	
	@Test(priority=5,description="Verify if message search with no match keyword then \"No Message Found\" is showing ")
	public void SearchWithNoKeywordFoundTest() {
		MessageModulePage messagepage = new MessageModulePage();
		boolean SearchResult=messagepage.SearchInMessages("Masud Rana");
		Assert.assertEquals(SearchResult, false, "Search With Invalid Name Can't Work Properly");
	}
	
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
