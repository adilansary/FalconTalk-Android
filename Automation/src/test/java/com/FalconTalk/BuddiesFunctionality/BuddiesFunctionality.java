package com.FalconTalk.BuddiesFunctionality;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.BuddiesFunctionalityPage;
import com.FalconTalk.PageActions.MessageModulePage;
import com.FalconTalk.Utils.SystemUtils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class BuddiesFunctionality {
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		//messagepage.Setup();
	}
	@AfterTest
	public void tearDown() {
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}
	
	@Test(priority=1)
	public void BuddiesFunctionalityTest() throws InterruptedException {
		BuddiesFunctionalityPage PageActions = new BuddiesFunctionalityPage();
		PageActions.getContactsPage();
		MessageModulePage messagepage = new MessageModulePage();
		messagepage.NavigationdDrawerOpen();
		messagepage.SignIn();
		PageActions.getContactsPage();
	}
	@Test(priority=2,description="Verify if Honeywell account profile name is showing in buddies list when the buddy number is unsaved")
	@Severity(SeverityLevel.CRITICAL)
	public void AccountProfileNameForUnsavedNumbertest() {
		BuddiesFunctionalityPage PageActions = new BuddiesFunctionalityPage();
		PageActions.getContactList();
		PageActions.SearchInContact("16506145382");
		boolean SearchResule=PageActions.ContactFoundOrNotCheck();
		if(SearchResule==false) {
			PageActions.getContactDetails();
			PageActions.contactDelete();
			PageActions.getBuddisPage();
		}else {
			PageActions.getBuddisPage();
		}
		PageActions.CancelSearch();
		PageActions.SearchInContact("16506145382");
		
		Assert.assertEquals(PageActions.CheckBuddyName(), "Nahid Hossain", "Buddy not Found");
	}
	
	@Test(priority=3,description="Verify if saved contact name is showing in buddies list when the buddy number is saved into contacts")
	@Severity(SeverityLevel.CRITICAL)
	public void AccountProfileNameForSavedNumberTest() {
		String ContactName="Nahid Bhai";
		SystemUtils Obj = new SystemUtils();
		BuddiesFunctionalityPage PageActions = new BuddiesFunctionalityPage();
		PageActions.getContactList();
		PageActions.SearchInContact("16506145382");
		boolean SearchResule=PageActions.ContactFoundOrNotCheck();
		if(SearchResule==false) {
			ContactName=PageActions.getContactName();
		}else {
			PageActions.getContactList();
			Obj.navigateBack();
			PageActions.addContact();
			//Obj.navigateBack();
			Obj.SaveContactsSamsungS10Plus("Nahid Bhai", "16506145382");
		}
		PageActions.getBuddisPage();
		PageActions.CancelSearch();
		PageActions.SearchInContact("16506145382");
		
		Assert.assertEquals(PageActions.CheckBuddyName(), ContactName, "Save Name is Not showing on Buddy List");
		
	}
	
	@Test(priority=4,description="Verify if buddies search with Buddy Name then buddies search result is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	public void BuddySearchWithName() throws InterruptedException {
		BuddiesFunctionalityPage PageActions = new BuddiesFunctionalityPage();
		PageActions.getBuddisPage();
		PageActions.SearchInContact("Mohammed Hasan Murad");
		Thread.sleep(5000);
		Assert.assertEquals(PageActions.CheckBuddyName(), "Mohammed Hasan Murad", "Save Name is Not showing on Buddy List");
	}
	
	@Test(priority=5,description="Verify if buddies search with Buddy Number then buddies search result is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	public void BuddySearchWithNumber() throws InterruptedException {
		BuddiesFunctionalityPage PageActions = new BuddiesFunctionalityPage();
		PageActions.getBuddisPage();
		PageActions.SearchInContact("16506145382");
		Thread.sleep(5000);
		Assert.assertEquals(PageActions.CheckBuddyName(), "Nahid Hossain", "Save Name is Not showing on Buddy List");
	}
	
	


}
