package com.FalconTalk.PreviousConfig;

import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.Data;
import com.FalconTalk.PageActions.PreviousConfigPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class PreviousConfig {
	
	
	@BeforeTest()
	public void Server_Start() throws MalformedURLException, InterruptedException {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		AppiumServer.Start();
		preconfpage.PreviousPage();
		Thread.sleep(2000);
	}

	
	@Test(priority=0,description = "Verify the last used extension page is showing or not when relaunch the app and same cabin router account is discovered ")
	@Severity(SeverityLevel.CRITICAL)
	public void LastExtensionPageTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		boolean res = preconfpage.LastExtensionPage();
		Assert.assertEquals(res, true);
	}
	
	@Test(priority=1,description = "Verify the last Taken extension is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	public void LastExtensionTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String preext = preconfpage.LastExtension();
		Assert.assertEquals(preext, Data.PreExtension, "Extension don't match with Previous extension");
	}
	
	@Test(priority=2,description = "Verify the ring group is showing properly")
	@Severity(SeverityLevel.CRITICAL)
	public void LastRingGroupTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String preringgroup = preconfpage.LastRingGroup();
		Assert.assertEquals(preringgroup, Data.PreRingGroup , "RingGroup don't match with Previous Ring Group");
	}
	
	@Test(priority=3,description = "Verify Display name is showing properly or not")
	@Severity(SeverityLevel.NORMAL)
	public void LastDisplayNameTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String preDisplayname = preconfpage.LastDisplayName();
		Assert.assertEquals(preDisplayname, Data.PreDisplayName, "Display Name don't match with Previous Display Name");
	}
	
	@Test(priority=4,description = "Press OK in the last used extension page and verify if it takes to KEYPAD module with previous account or not")
	@Severity(SeverityLevel.BLOCKER)
	public void OkButtonTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		Assert.assertEquals(preconfpage.OkButton(), Data.NavDrawerAccInfo, "Account Information dosen't match");
	}
	
	@Test(priority=5,description = "Press Change in last used extension page and verify if it takes to ring group and extension selection page or not")
	@Severity(SeverityLevel.BLOCKER)
	public void ChangeButtonTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		Assert.assertEquals(preconfpage.ChangeButton(), Data.NavDrawerAccInfo1, "Test Case is Failed");
	}

	@AfterTest
	public void tearDown() {
		AppiumServer.Stop();
	}

}
