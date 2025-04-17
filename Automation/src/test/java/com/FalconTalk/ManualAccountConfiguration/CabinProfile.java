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

@Test
class CabinProfile {
	
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(6000);
	}
	
	@Test(priority=-1)
	public void Setup() throws InterruptedException {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.NavigationdDrawerOpen();
		Thread.sleep(2000);
		addprofilepage.setup();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void CabinRouterPageforGogo() {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Gogo");
		addprofilepage.cabinrouterselections("Gogo", "Axxess");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(), ProfileDetailsData.CabinRouternameforgogo, "Wrong Cabin router Name Showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouternameforgogo , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameAxxess, "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=1)
	public void CabinRouterPageforHoneywellLegacy() { //Legacy
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Honeywell");
		addprofilepage.cabinrouterselections("Honeywell", "CG-710 (Legacy)");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(), ProfileDetailsData.CabinRouterNameforHonwywell.get(0), "Wrong Cabin router Name Showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforHonwywell.get(0) , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameHoneywell.get(0), "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=2)
	public void CabinRouterPageforHoneywellFc() { //FC
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Honeywell");
		addprofilepage.cabinrouterselections("Honeywell", "CG-710 (FC)");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(), ProfileDetailsData.CabinRouterNameforHonwywell.get(1), "Wrong Cabin router Name Showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforHonwywell.get(1) , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameHoneywell.get(1), "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=3)
	public void CabinRouterPageforHoneywellCNX() { //CNX
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Honeywell");
		addprofilepage.cabinrouterselections("Honeywell", "CNX-900");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(), ProfileDetailsData.CabinRouterNameforHonwywell.get(2), "Wrong Cabin router Name Showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforHonwywell.get(2) , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameHoneywell.get(1), "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=4)
	public void CabinRouterPageforHoneywellGDR() { //GDR
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Honeywell");
		addprofilepage.cabinrouterselections("Honeywell", "GDR");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(), ProfileDetailsData.CabinRouterNameforHonwywell.get(3), "Wrong Cabin router Name Showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforHonwywell.get(3) , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameHoneywell.get(1), "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	} 
	
	@Test(priority=5)
	public void CabinRouterPageforSatcom() { //Satcom SDR
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Satcom Direct");
		addprofilepage.cabinrouterselections("Satcom Direct", "SDR");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(),ProfileDetailsData.CabinRouterNameforSatcom , "Wrong Cabin router Name showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforSatcom , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), ProfileDetailsData.DomainNameSDR, "Wrong Domain");
		addprofilepage.getBack();
		addprofilepage.getBack();
	}
	
	@Test(priority=6)
	public void CabinRouterPageforCustom() { //Custom
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Custom");
		Assert.assertEquals(addprofilepage.getManufacturerLogo(), true);
		Assert.assertEquals(addprofilepage.getCabinRouterName(),ProfileDetailsData.CabinRouterNameforCustom, "Wrong Cabin router Name showing");
		Assert.assertEquals(addprofilepage.getProfileName(),ProfileDetailsData.CabinRouterNameforCustom , "Can't get cabin account page");
		Assert.assertEquals(addprofilepage.getDomainName(), "", "Wrong Domain");
	}
	
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
