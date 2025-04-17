package com.FalconTalk.ManualAccountConfiguration;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.ProfileDetailsData;
import com.FalconTalk.PageActions.KeypadPage;
import com.FalconTalk.PageActions.ProfilePage;
import com.FalconTalk.Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

class CustomAccountConfiguration {
	
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(6000);//
	}
	
	@Test(priority=-0)
	public void Setup() throws InterruptedException {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.NavigationdDrawerOpen();
		Thread.sleep(200);
		addprofilepage.setup();
		Thread.sleep(200);
	}
	
	@Test(priority=1)
	public void CustomProfileInputRegTest() {  //TC74
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.manufacturerselections("Custom");
		addprofilepage.CustomProfileInput(ProfileDetailsData.DomainNameCustom, ProfileDetailsData.ExtensionCustom.get(0), ProfileDetailsData.passwordCustom.get(0));
		Utils.scrollDown();
		addprofilepage.applyonCustomProfile();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(addprofilepage.getAccountStatus(1),ProfileDetailsData.AccountStatus.get(0) , "Account is not registerd");
		
	}
	
	@Test(priority=2)
	public void CustomAccoundAddedDisablePreviousAcountTest() { //TC81
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.getAccountStatus(0),ProfileDetailsData.AccountStatus.get(2) , "Previous Account is not disable");
	}
	
	@Test(priority=3)
	public void CustomAccountDisableWhenEnableingAutoAccountTest() throws InterruptedException { //TC84
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getAccountToggleSwitch(0);
		addprofilepage.getApply();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		Assert.assertEquals(addprofilepage.getAccountStatus(1),ProfileDetailsData.AccountStatus.get(2) , "Custom Account is not diable");
		addprofilepage.getAccountToggleSwitch(1);
		AppDriver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
	}
	
	@Test(priority=4)
	public void CustomAccountEditTest() throws InterruptedException {
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.getAccountClick(1);
		addprofilepage.CustomProfileInputFieldClear();
		addprofilepage.CustomProfileInput(ProfileDetailsData.DomainNameCustom, ProfileDetailsData.ExtensionCustom.get(1), ProfileDetailsData.passwordCustom.get(0));
		Utils.scrollDown();
		addprofilepage.applyonCustomProfile();
		Thread.sleep(5000);
		AppDriver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		Assert.assertEquals(addprofilepage.getAccountExtension(1),ProfileDetailsData.ExtensionListOnProfile.get(1) , "Account is not edit properly");
	}
	
	@Test(priority=5)
	public void CustomAccountShowingOnKeypadTest() throws InterruptedException { //TC75
		ProfilePage addprofilepage = new ProfilePage();
		KeypadPage KeypadPage = new KeypadPage();
		addprofilepage.getBack();
		//KeypadPage.AccountStatus();
		Thread.sleep(200);
		Assert.assertEquals(KeypadPage.getAccountNameCustom(),ProfileDetailsData.CabinRouterNameforCustom , "Account Name is not showing properly");
	}
	
	@Test(priority=6)
	public void CustomAccontShowingOnNavDrawerTest() { //TC76
		KeypadPage KeypadPage = new KeypadPage();
		KeypadPage.getNavigationDrawerOpen();
		Assert.assertEquals(KeypadPage.getAccountNameNav(),ProfileDetailsData.CabinRouterNameforCustom , "Account Name on nav drawer is not showing properly");
		KeypadPage.getUserProfile();
	}
	
	@Test(priority=7)
	public void CustomAccountShowingOnProfileListTest() {
		KeypadPage KeypadPage = new KeypadPage();
		KeypadPage.getUserProfile();
		Assert.assertEquals(KeypadPage.getAccountNameNav(),ProfileDetailsData.CabinRouterNameforCustom , "Account Name on nav drawer is not showing properly");
	}
	
	@Test(priority=8)
	public void CustomAccountShowingOnAutoDiscoveryCabinListTest() { //TC93
		ProfilePage addprofilepage = new ProfilePage();
		KeypadPage KeypadPage = new KeypadPage();
		KeypadPage.getUserProfile();
		KeypadPage.getNavigationDrawerOpen();
		addprofilepage.getRetryAutoConfig();
		Assert.assertEquals(addprofilepage.getRouterNameFromAutoDiscoverPage(0),ProfileDetailsData.CabinRouterNameforCustom , "Custom account Name is not showing on Auto Discover Page");
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}
}
