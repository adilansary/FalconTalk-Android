package com.FalconTalk.ProfileDetails;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.ProfileDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class ProfileDetails {
	
	
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(10000);
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		profiledetailsPage.setup();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void ProfileNamefieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.ProfileNamefield(), false);
	}
	
	@Test(priority=1)
	public void DomainfieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.Domainfield(), true);
	}
	
	@Test(priority=2)
	public void ExtensionfieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.Extensionfield(), true);

	}
	
	@Test(priority=3)
	public void ApplyButtonTest() throws InterruptedException {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Thread.sleep(5000);
		String status = profiledetailsPage.ApplyButton();
		Assert.assertEquals(status, "Registered", "Account is not Registered");
	
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
