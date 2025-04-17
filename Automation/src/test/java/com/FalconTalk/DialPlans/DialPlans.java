package com.FalconTalk.DialPlans;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.DialPlansPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class DialPlans {
	
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		DialPlansPage dialplanspage = new DialPlansPage();
		dialplanspage.setup();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void AddNewDialPlansTest() {
		DialPlansPage dialplanspage = new DialPlansPage();
		Assert.assertEquals(dialplanspage.AddNewDialPlans(), "Test Dial Plans", "Dial Plans Can't added");
	}
	
	@Test(priority=1)
	public void DialPlansEditTest() {
		DialPlansPage dialplanspage = new DialPlansPage();
		Assert.assertEquals(dialplanspage.DialPlansEdit(), "Test Dial Plans 1", "Dial Plans Can't Edit");
	}
	
	/*
	 * @Test(priority=2) public void DialPlansDeleteTest() { DialPlansPage
	 * dialplanspage = new DialPlansPage(); dialplanspage.DialPlansDelete(); }
	 */
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}
