package com.FalconTalk.ManualAccountConfiguration;


import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.ProfileDetailsData;
import com.FalconTalk.PageActions.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ExtensionSelectionProfile {
	
	@BeforeTest
	public void Server_Start() throws InterruptedException, MalformedURLException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(6000);
		
	}
	
	@Test(priority=-1)
	public void Setup() throws InterruptedException {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.NavigationdDrawerOpen();
		Thread.sleep(200);
		addprofilepage.setup();
		Thread.sleep(200);
	}
	
	
	@Test(priority=0)
	public void ExtensionSelectionforGogoTest() {  //Start Test for Gogo Axxess router
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Gogo");
		addprofilepage.cabinrouterselections("Gogo", "Axxess");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=1)
	public void RingGroupNameforGogoTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("VVIP"), true, "Ring Group VVIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("VIP"), true, "Ring Group VIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Guest"), true, "Ring Group Guest missing");
	}
	
	@Test(priority=2)
	public void DisplayNameforGogoTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
		addprofilepage.getCancel();
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=3)
	public void ExtensionSelectionforLegacyTest() { //Start Test for HOneywell Legacy Router
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Honeywell");
		addprofilepage.cabinrouterselections("Honeywell", "CG-710 (Legacy)");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=4)
	public void PasswordFieldforLegacyTest() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getSelectedRingGroup("Pilot");
		Assert.assertEquals(addprofilepage.getPasswordField(),true , "Password field showing");
	}
	
	@Test(priority=5)
	public void RingGroupNameforLegacyTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("VVIP"), true, "Ring Group Legacy VVIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("VIP"), true, "Ring Group Legacy VIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Pilot"), true, "Ring Group Legacy Pilot missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Guest"), true, "Ring Group Legacy Guest missing");
	}
	
	@Test(priority=6)
	public void DisplayNameforLegacyTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
		addprofilepage.getCancel();
		addprofilepage.getBack();
	}
	
	@Test(priority=7)
	public void ExtensionSelectionforFcTest() { //Start Test for Honeywell FC router
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.cabinrouterselections("Honeywell", "CG-710 (FC)");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=8)
	public void PasswordFieldforFcTest() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getSelectedRingGroup("Pilot");
		Assert.assertEquals(addprofilepage.getPasswordField(),true , "Password field showing");
	}
	
	@Test(priority=9)
	public void RingGroupNameforFcTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("VVIP"), true, "Ring Group FC VVIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("VIP"), true, "Ring Group FC VIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Pilot"), true, "Ring Group FC Pilot missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Secretary"), true, "Ring Group FC Pilot missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Guest"), true, "Ring Group FC Guest missing");
	}
	
	@Test(priority=10)
	public void DisplayNameforFcTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
		addprofilepage.getCancel();
		addprofilepage.getBack();
	}
	
	@Test(priority=11)
	public void ExtensionSelectionforCNXTest() { //Start Test for Honeywell CNX router
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.cabinrouterselections("Honeywell", "CNX-900");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=12)
	public void PasswordFieldforCNX900Test() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getSelectedRingGroup("Cockpit");
		Assert.assertEquals(addprofilepage.getPasswordField(),true , "Password field showing");
	}
	
	@Test(priority=13)
	public void RingGroupNameforCNXTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("Cabin"), true, "Ring Group CNX-900 Cabin missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Cockpit"), true, "Ring Group CNX-900 Cockpit missing");
	}
	
	@Test(priority=14)
	public void DisplayNameforCNXTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
		addprofilepage.getCancel();
		addprofilepage.getBack();
	}
	
	@Test(priority=15)
	public void ExtensionSelectionforGDRTest() { //Start test for Honeywell GDR router
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.cabinrouterselections("Honeywell", "GDR");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=16)
	public void PasswordFieldforGDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getSelectedRingGroup("Cockpit");
		Assert.assertEquals(addprofilepage.getPasswordField(),true , "Password field showing");
	}
	
	@Test(priority=17)
	public void RingGroupNameforGDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("Cabin"), true, "Ring Group GDR Cabin missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Cockpit"), true, "Ring Group GDR Cockpit missing");
	}
	
	@Test(priority=18)
	public void DisplayNameforGDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
		addprofilepage.getCancel();
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=19)
	public void ExtensionSelectionforSDRTest() { // Start SDR
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Satcom Direct");
		addprofilepage.cabinrouterselections("Satcom Direct", "SDR");
		addprofilepage.getExtensionPage();
		Assert.assertEquals(addprofilepage.getRingGroupPage(),ProfileDetailsData.RingGroupPage , "Can't get Ring Group page");
	}
	
	@Test(priority=20)
	public void PasswordFieldforSDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getSelectedRingGroup("Pilot");
		Assert.assertEquals(addprofilepage.getPasswordField(),true , "Password field showing");
	}
	
	@Test(priority=21)
	public void RingGroupNameforSDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.RingGroupName("VVIP"), true, "Ring Group FC VVIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("VIP"), true, "Ring Group FC VIP missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Pilot"), true, "Ring Group FC Pilot missing");
		Assert.assertEquals(addprofilepage.RingGroupName("Guest"), true, "Ring Group FC Guest missing");
	}
	
	@Test(priority=22)
	public void DisplayNameforSDRTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getDisplayName(),ProfileDetailsData.RingGroupDispName , "Display Name showing wrong");
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
